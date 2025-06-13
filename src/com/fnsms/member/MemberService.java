package com.fnsms.member;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.main.Main;
import com.fnsms.reservation.Reservation;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;
import com.fnsms.user.UserService;
import com.fnsms.view.MemberView;

public class MemberService extends UserService {
	
	Member member;
//	static Scanner scan = new Scanner(System.in);

//	생성자
	public MemberService(String memberNo) {
		this.member = MemberDAO.getMemberList(memberNo);}
// 	게터세터
	public Member getMember() {return member;}
	public void setMember(Member member) {this.member = member;}

	
	
	
//  로그인 후 회원 메인화면
	public void memberMainMenu() {
		
		
		//회원의 이용중인 유효한 이용권
		ArrayList<TicketRegistration> validRegList =
				this.getValidRegstration(this.getMember());
		
		
		//센터 이용권
		TicketRegistration centerPass = null; 
		//System.out.println(validRegList);
		
		for(TicketRegistration item : validRegList) {
			String ticketName = TicketDAO.getTicketList(item.getTicket()).get(0).getTicketClassify();
			if(ticketName.startsWith("헬스")
				|| ticketName.startsWith("PT")
				|| ticketName.startsWith("필라테스")) {
				centerPass = item;
				break;
			}
			
			//System.out.println("센터 이용권: " + centerPass);
		}
		
		
		
		if(centerPass != null) {
			
			
//			return validRegList.get(0);
			
			while(true) {
				
				MemberView.printMainmenu(this.getMember().getName(), this.getMember().getTel(), this.getMember().getBirthDate()
						, this.haveUseTowelTicketUse()
						, centerPass.getTicket()
						, this.getTicketRemainIning(centerPass)
						, centerPass.getEndDate());
				
				System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
				String cmd = Main.scan.nextLine();
				if(cmd.equals("1")) {
//					이용권 정보 조회
					inquiryTicketInfo(centerPass);
//					scan.close();
				} else if(cmd.equals("2")) {
					// 예약 조회
					MemberView.printSelectReservationDate(this.inquiryReservInfo(this.getMember()));
					
				} else if(cmd.equals("E")) {
					//로그아웃 메서드
					UserService.logOut();
				} else {
					System.out.println("\t정해진 문자를 입력해주세요.");
//					scan.close();
				}
			}
		} else {
			System.out.println("\t등록하신 이용권이 없습니다.");
		}
		
		
		
	}//멤버메인	
	
	
	
	
	
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
		 for(TicketRegistration reg : this.getValidRegstration(this.getMember()) ) {
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
				
				return (int)(basDt - compareDt);
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
	
	//휴회 신청가능 총 횟수 > 30일 당 +5일
	public int getticketBreakTotalIning(TicketRegistration ticketReg) {
		//티켓의 기본정보 리스트
		ArrayList<Ticket> ticketInfoList = TicketDAO.getTicketList(ticketReg.getTicket());
		
		
		if(ticketInfoList.isEmpty()) {
			return -1;
		} else {
			int ticketIning = ticketInfoList.get(0).getTicketUseDays();
			return ticketIning / 30 * 5;
		}
		
	}
	
	
	
	//휴회 신청 가능 여부
	public boolean canticketBreak(TicketRegistration ticketReg) {
		if(getticketBreakTotalIning(ticketReg) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	

	
	//2-1. 이용권 정보 조회
	public void inquiryTicketInfo(TicketRegistration ticketReg) {
		
		
		Calendar registerDate = ticketReg.getPurchaseDate();
		Calendar startDate = ticketReg.getStartDate();
		Calendar endDate = ticketReg.getEndDate();
		long totalDays = getTicketTotalDays(ticketReg);
		long remainingDays = getTicketExpireDateGap(ticketReg);
		String name = this.getMember().getName();
		boolean towel = haveUseTowelTicketUse();
		String ticket = ticketReg.getTicket();
		int count = getTicketRemainIning(ticketReg);
		
//		boolean loop = true;
		
		MemberView.printDate(registerDate, startDate, endDate, totalDays, remainingDays, name, towel, ticket, count);
		
		 while(true) {
		        String cmd = Main.scan.nextLine().trim();
		        
		        if(cmd.equalsIgnoreCase("y")) {
		            // 휴회 신청
		            requestRecess(ticketReg);
		            return; 
		            // 휴회 신청 절차가 끝나면 여기서 끝내거나,
		            // 또는 아래쪽에서 memberMainMenu()를 호출할 수도 있음.
		        } else if(cmd.equalsIgnoreCase("n")) {
		            // "휴회 안 하고 메인으로 돌아간다"
		            System.out.println("휴회 신청을 하지 않습니다. 메인 화면으로 돌아갑니다.");
		            memberMainMenu(); 
		            return; 
		        } else if(cmd.equals("#")) {
		            // 메인 메뉴로 즉시 복귀
		            memberMainMenu();
		            return;
		        } else {
		            System.out.println("\t정해진 문자를 입력해주세요. (y / n / #)");
		        }
		    }
		}
	

	// 2-1-1. 휴회신청
	public void requestRecess(TicketRegistration ticketReg) {
		
		
		Calendar registerDate = ticketReg.getPurchaseDate();
		Calendar startDate = ticketReg.getStartDate();
		Calendar endDate = ticketReg.getEndDate();
		long totalDays = getTicketTotalDays(ticketReg);
		long remainingDays = getTicketExpireDateGap(ticketReg);
		String name = this.getMember().getName();
		boolean towel = haveUseTowelTicketUse();
		String ticket = ticketReg.getTicket();
		int count = getTicketRemainIning(ticketReg);
		boolean possible_break = canticketBreak(ticketReg);
		int possibleBreakDays = getticketBreakTotalIning(ticketReg);
		
		MemberView.ticketBreak(registerDate, startDate, endDate, totalDays, remainingDays, name, towel, ticket, count, possible_break,possibleBreakDays);


		while(true) {
	        String cmd = Main.scan.nextLine().trim();
	        
	        // (1) 먼저 문자인지 확인
	        if (cmd.equalsIgnoreCase("#")) {
	            // 메인 메뉴
	            System.out.println("메인화면으로 돌아갑니다.");
	            memberMainMenu();
	            return;
	        } else if (cmd.equalsIgnoreCase("n")) {
	            // 휴회 안 함 -> 메인
	            System.out.println("휴회하지 않고 메인으로 돌아갑니다.");
	            memberMainMenu();
	            return;
	        } 
	        // 만약 "y"는...? 여기서는 의미 없으니 pass or?
	        // "y" 자체가 일수가 아니므로, 
	        // 아무 로직 안 하고 "정해진 문자를 입력해주세요" or 무시.
	        
	        // (2) 숫자인지 확인
	        try {
	            int days = Integer.parseInt(cmd);
	            // 휴회일수가 days로 들어옴
	            // 이 days가 remaining 횟수보다 큰지 검사 -> 가능하면 ticketBreak(ticketReg, days)
	            if (days <= getTicketRemainIning(ticketReg) && days > 0) {
	                ticketBreak(ticketReg, days);
	                return;
	            } else {
	                System.out.println("\t휴회일을 정확하게 입력해주세요. 가능일수: " + getTicketRemainIning(ticketReg) );
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\t정해진 문자를 입력해주세요. (#:메인, n:취소, or 휴회일(숫자))");
	        }
	    }
	}
	//휴회 등록
	public void ticketBreak(TicketRegistration ticketReg, int days) {
		Calendar udtStartDate = ticketReg.getStartDate();
		Calendar udtEndDate = ticketReg.getEndDate();
		String name = this.member.getName();
		
		udtStartDate.add(Calendar.DATE, days);
		udtEndDate.add(Calendar.DATE, days);
		TicketRegistrationDAO.save();

		MemberView.ticketBreakSuccess(days, udtStartDate, udtEndDate, name);
		
		
		
	}

	
	
}
