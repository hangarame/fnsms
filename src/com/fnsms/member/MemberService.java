package com.fnsms.member;

import java.util.ArrayList;
import java.util.Calendar;

import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.reservation.Reservation;
import com.fnsms.ticketregistration.TicketRegistration;
import com.fnsms.user.UserService;

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
	
	public boolean haveUseTowelTicketUse() {
		 for(TicketRegistration reg : TicketRegistrationDAO.getTicketRegList(this.getMember().getMemberNo()) ) {
			 if(reg.getTicket().startsWith("운동복")) {
				return true; 
			 }

		 }
		 return false;
	}
	
	
	//소유한 이용권 중 가장 가까운 만료일 반환 
	public int getNearExpiredate(ArrayList<TicketRegistration> regList) {
		if(regList.size() < 1 ) {
			return -1;
		} else {
			int min = 0;
			
			for(TicketRegistration reg : regList) {
				if(getTicketExpireDateGap(reg) < min)
				min = getTicketExpireDateGap(reg);
			}
			
			return min;
		}

	}
	
	//현재로부터 티켓의 만료일 D-Day
	public int getTicketExpireDateGap(TicketRegistration reg) {
		
		Calendar baseDate = Calendar.getInstance();

		int basYyyy = reg.getEndDate().get(Calendar.YEAR);
		int basMm = reg.getEndDate().get(Calendar.MONTH);
		int basDd = reg.getEndDate().get(Calendar.DATE);
		
		baseDate.set(basYyyy, basMm, basDd, 0, 0, 0);
		
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);


		return (int)((baseDate.getTimeInMillis() - currentDate.getTimeInMillis()) / 1000 / 60 / 60 / 24);
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
		
		return regList;
	}
	
	//이용권의 남은 횟수
	public int getRemainIning(TicketRegistration ticketReg) {
		ReservationDAO.getReservationList(ticketReg.getTicketRegNo());
		
		this.member.getMemberNo();
	}
	

	// 휴회신청
	public void requestRecess() {
		
	}



	
}
