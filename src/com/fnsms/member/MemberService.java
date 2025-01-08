package com.fnsms.member;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.reservation.Reservation;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;
import com.fnsms.user.UserService;
import com.fnsms.view.MemberView;

public class MemberService extends UserService {
	
	Member member;
	
	public MemberService(String memberNo) {
		this.member = MemberDAO.getMemberList(memberNo);
	}

	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	// 예약 조회
	public ArrayList<Reservation> inquiryReservInfo(Member member) {
		ArrayList<Reservation> reservList = new ArrayList<Reservation>();
		
		for(TicketRegistration reg : TicketRegistrationDAO.getTicketRegList(member.getMemberNo())) {
			for(Reservation reserv : ReservationDAO.getReservationList(reg.getTicketRegNo())) {
				reservList.add(reserv);
			}
		}
		
		return reservList;
	}

	// 수건 이용권 사용 여부
	public boolean haveUseTowelTicketUse(Member member) {
		 for(TicketRegistration reg : TicketRegistrationDAO.getTicketRegList((member).getMemberNo()) ) {
			 if(reg.getTicket().startsWith("운동복")) {
				return true; 
			 }

		 }
		 return false;
	}
	
	//운동복/수건 이용권이 있는지
	public boolean haveUseTowelTicketUse() {
		 for(TicketRegistration reg : TicketRegistrationDAO.getTicketRegList(this.getMember().getMemberNo()) ) {
			 if(reg.getTicket().startsWith("운동복")) {
				return true; 
			 }

		 }
		 return false;
	}
	
	
	//소유한 이용권 중 가장 가까운 만료일 반환 
	public long getNearExpiredate(ArrayList<TicketRegistration> regList) {
		if(regList.size() < 1 ) {
			return -1;
		} else {
			long min = 0;
			
			for(TicketRegistration reg : regList) {
				if(getTicketExpireDateGap(reg) < min)
				min = getTicketExpireDateGap(reg);
			}
			
			return min;
		}

	}
	
	//이용권의 총 이용기간
	public long getTicketTotalDays(TicketRegistration reg) {
		Calendar endDate = Calendar.getInstance();

		int endYyyy = reg.getEndDate().get(Calendar.YEAR);
		int endMm = reg.getEndDate().get(Calendar.MONTH);
		int endDd = reg.getEndDate().get(Calendar.DATE);
		
		endDate.set(endYyyy, endMm, endDd, 0, 0, 0);
		
		Calendar startDate = Calendar.getInstance();
		int startYyyy = reg.getStartDate().get(Calendar.YEAR);
		int startMm = reg.getStartDate().get(Calendar.MONTH);
		int startDd = reg.getStartDate().get(Calendar.DATE);
		
		startDate.set(startYyyy, startMm, startDd, 0, 0, 0);
		
		return (endDate.getTimeInMillis() - startDate.getTimeInMillis()) / 1000 / 60 / 60 / 24;
	}
	
	
	//현재로부터 이용권의 만료일 D-Day
	public long getTicketExpireDateGap(TicketRegistration reg) {
		
		Calendar baseDate = Calendar.getInstance();

		int basYyyy = reg.getEndDate().get(Calendar.YEAR);
		int basMm = reg.getEndDate().get(Calendar.MONTH);
		int basDd = reg.getEndDate().get(Calendar.DATE);
		
		baseDate.set(basYyyy, basMm, basDd, 0, 0, 0);
		
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);


		return (baseDate.getTimeInMillis() - currentDate.getTimeInMillis()) / 1000 / 60 / 60 / 24;
	}
	
	
	
	// 기간이 유효한 이용권 등록 가져오기(현재일이 시작일과 종료일 기간이 아니면 해당되지 않음)
	public ArrayList<TicketRegistration> getValidRegstration(Member member){

		ArrayList<TicketRegistration> regList = new ArrayList<TicketRegistration>();
		Calendar current = Calendar.getInstance();				
		
		for (TicketRegistration reg : TicketRegistrationDAO.getTicketRegList(member.getMemberNo())) {
			if(reg.getStartDate().compareTo(current) <= 0 
					&& reg.getEndDate().compareTo(current) >= 0) {
				regList.add(reg);
			}
			
		}
		
		regList.sort(new Comparator<TicketRegistration>() {
			public int compare(TicketRegistration o1, TicketRegistration o2) {
				long basDt = o1.getEndDate().getTimeInMillis();
				long compareDt = o2.getEndDate().getTimeInMillis();
				
				return (int)(basDt - basDt);
			};
		});
		
		return regList;
	}
	
	//이용권의 사용 횟수
	public int getTicketUsedIning(TicketRegistration ticketReg) {
		
		//해당 이용권번호의 예약 리스트
		ArrayList<Reservation> reservList = ReservationDAO.getReservationList(ticketReg.getTicketRegNo());
		
		//예약횟수
		int reservCount = reservList.size();
		
		return reservCount;
		
	}
	
	//이용권의 남은 횟수
	public int getTicketRemainIning(TicketRegistration ticketReg) {
		//이용권의 횟수
		ArrayList<Ticket> ticketList = TicketDAO.getTicketList(ticketReg.getTicket());
		
		int useIning = 0;
		
		if(ticketList.isEmpty()) {
			return -1;
		} else {
			useIning = ticketList.get(0).getClassTimes();
		}
		
		//예약횟수
		int reservCount = getTicketUsedIning(ticketReg);

		return useIning - reservCount;
		
	}
	
	
	//로그인 후 회원 메인화면
	public void memberMainMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		
		//회원의 이용중인 유효한 이용권
		ArrayList<TicketRegistration> validRegList = this.getValidRegstration(this.getMember());
		
		MemberView.printMainmenu(this.getMember().getName(), this.getMember().getTel(), this.getMember().getBirthDate()
				, this.haveUseTowelTicketUse()
				, validRegList.get(0).getTicket()
				, this.getTicketRemainIning(validRegList.get(0))
				, validRegList.get(0).getEndDate());
		
//		return validRegList.get(0);
		
		while(true) {
			String cmd = scan.nextLine();
			
			if(cmd.equals("1")) {
				inquiryTicketInfo(validRegList.get(0));
				
			} else if(cmd.equals("2")) {
				
			} else if(cmd.equals("E")) {
				
			} else {
				
			}
		}
		
	}
	
	//2-1 이용권 정보 조회
	public void inquiryTicketInfo(TicketRegistration ticketReg) {
		//printDate(Calendar registerDate, Calendar startDate, Calendar endDate, long totalDays, long remainingDays, String name, boolean towel, String ticket, int count)
		Calendar registerDate = ticketReg.getPurchaseDate();
		Calendar startDate = ticketReg.getStartDate();
		Calendar endDate = ticketReg.getEndDate();
		long totalDays = getTicketTotalDays(ticketReg);
		long remainingDays = getTicketExpireDateGap(ticketReg);
		String name = this.getMember().getName();
		boolean towel = haveUseTowelTicketUse();
		String ticket = ticketReg.getTicket();
		int count = getTicketRemainIning(ticketReg);
		
		MemberView.printDate(registerDate, startDate, endDate, totalDays, remainingDays, name, towel, ticket, count);
		
	}
	

	// 휴회신청
	public void requestRecess() {
		
	}



	
}
