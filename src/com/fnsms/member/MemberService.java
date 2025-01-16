package com.fnsms.member;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.reservation.Reservation;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;
import com.fnsms.user.UserService;
import com.fnsms.view.CalendarView;
import com.fnsms.view.MemberView;

/**
 * 회원의 메뉴기능을 구현하는 클래스입니다.
 * @author 1조
 */
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
		Scanner scan = new Scanner(System.in);
		
				
		while(true) {
			
			//회원의 이용중인 유효한 이용권
			ArrayList<TicketRegistration> validRegList =
					this.getValidRegstration(this.getMember());
			
			if(validRegList.isEmpty()) {
				System.out.println("유효한 이용권이 없습니다.");
				return;
			}
			
			MemberView.printMainmenu(this.getMember().getName()
					, this.getMember().getTel(), this.getMember().getBirthDate()
					, this.haveUseTowelTicketUse()
					, validRegList.get(0).getTicket()
					, this.getTicketRemainIning(validRegList.get(0))
					, validRegList.get(0).getEndDate());
			
			
			
			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			String cmd = scan.nextLine();
			
			
			if(cmd.equals("1")) {
//				이용권 정보 조회
				inquiryTicketInfo(validRegList.get(0));
			} else if(cmd.equals("2")) {
				// 예약 조회

				Calendar currentDisplayCal = Calendar.getInstance();
				ArrayList<Reservation> myReservations =
						getReservationsOfMonth(currentDisplayCal.get(Calendar.YEAR),
                                currentDisplayCal.get(Calendar.MONTH)+1);
//				System.out.println("달력을 출력합니다.");
//				CalendarView cView = new CalendarView();
//	            cView.start(); 
			} else if(cmd.equals("E")) {
				//로그아웃 메서드
				UserService.logOut();
				return;
			} else {
				System.out.println("\t정해진 문자를 입력해주세요.");
			}
		}
	}//멤버메인	
	
	private ArrayList<Reservation> getReservationsOfMonth(int year, int month) {
        ArrayList<Reservation> reservList = new ArrayList<>();
        
        // 이 회원이 가진 TicketRegistration 목록
        ArrayList<TicketRegistration> myRegList = TicketRegistrationDAO.getTicketRegList(this.member.getMemberNo());
        
        for(TicketRegistration tr : myRegList) {
            ArrayList<Reservation> rList = ReservationDAO.getReservationList(tr.getTicketRegNo());
            for(Reservation r : rList) {
                Calendar rc = r.getReservDate();
                if(rc.get(Calendar.YEAR) == year && (rc.get(Calendar.MONTH)+1) == month) {
                    reservList.add(r);
                }
            }
        }
        return reservList;
    }
	
	
	private void viewMySchedule() {
	    Scanner scan = new Scanner(System.in);
	    
	    // 1) 초기: 현재 달부터 시작
	    Calendar displayCal = Calendar.getInstance(); // 현재 달
	    
//	    현재 달 출력
	    printCalendarWithReservations(displayCal);
	    
	    while(true) {
	        
	        System.out.println("  (1)다음달 일정보기, (2)지난달 일정보기, (#)메인으로 돌아가기");
	        System.out.print("선택> ");
	        String sel = scan.nextLine().trim();
	        
	        if(sel.equals("1")) {
	            // 다음달
	            displayCal.add(Calendar.MONTH, 1);
                printCalendarWithReservations(displayCal);
	        } else if(sel.equals("2")) {
	            // 지난달
	            displayCal.add(Calendar.MONTH, -1);
                printCalendarWithReservations(displayCal);
	        } else if(sel.equals("#")) {
	            // 메인메뉴로
	            return;
	        } else {
	            System.out.println("올바른 값을 입력해주세요.");
	        }
	    }
	}
	
	 private void printCalendarWithReservations(Calendar cal) {
	        int year = cal.get(Calendar.YEAR);
	        int month = cal.get(Calendar.MONTH) + 1; // 0~11
	        
	        // 1) 이 달에 예약(수업) 있는 날짜( dayOfMonth )를 구한다.
	        Set<Integer> reservedDays = getReservedDaysOfMonth(member, year, month);
	        
	        // 2) 달력 헤더
	        System.out.println("\n=======================================================");
	        System.out.printf("            %04d년 %02d월 \n", year, month);
	        System.out.println("=======================================================");
	        System.out.println("   일\t  월\t  화\t  수\t  목\t  금\t  토\n");
	        
	        // 3) 1일의 요일
	        Calendar tempCal = (Calendar) cal.clone();
	        tempCal.set(Calendar.DAY_OF_MONTH, 1);
	        int dayOfWeek = tempCal.get(Calendar.DAY_OF_WEEK); 
	        
	        // 4) 이 달의 마지막 날짜
	        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	        
	        // 5) 1일 전까지 공백
	        for (int i=1; i<dayOfWeek; i++) {
	            System.out.print("\t");
	        }
	        
	        // 6) 날짜 출력
	        for(int day=1; day<=lastDay; day++) {
	            // 예약 있는 날이면 -> 날짜 뒤에 '*' 붙임
	            if (reservedDays.contains(day)) {
	                System.out.printf("%4d*\t", day);
	            } else {
	                System.out.printf("%4d\t", day);
	            }
	            
	            // 줄바꿈 처리 (일~토: 7칸 주기)
	            if ((dayOfWeek + day - 1) % 7 == 0) {
	                System.out.println("\n");
	            }
	        }
	        System.out.println("\n");
	    }
	 
	 private Set<Integer> getReservedDaysOfMonth(Member member, int year, int month) {
	        Set<Integer> daySet = new HashSet<>();
	        
	        // 1) 이 회원의 이용권 등록 목록
	        ArrayList<TicketRegistration> regList = TicketRegistrationDAO.getTicketRegList(member.getMemberNo());
	        // 2) 각 이용권 등록번호에 대한 예약을 검사
	        for(TicketRegistration tr : regList) {
	            ArrayList<Reservation> rList = ReservationDAO.getReservationList(tr.getTicketRegNo());
	            for(Reservation r : rList) {
	                Calendar c = r.getReservDate();
	                int cYear = c.get(Calendar.YEAR);
	                int cMonth = c.get(Calendar.MONTH) + 1;
	                if(cYear == year && cMonth == month) {
	                    // 예약 날짜
	                    int cDay = c.get(Calendar.DATE);
	                    daySet.add(cDay);
	                }
	            }
	        }
	        return daySet; 
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
		Scanner scan = new Scanner(System.in);
		
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
//		boolean loop = true;
		
		MemberView.printDate(registerDate, startDate, endDate, totalDays, remainingDays, name, towel, ticket, count);
		
		 while(true) {
		        String cmd = scan.nextLine().trim();
		        
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
		        	System.out.println("메인 화면으로 돌아갑니다.");
		            memberMainMenu();
		            return;
		        } else {
		            System.out.println("\t정해진 문자를 입력해주세요. (y / n / #)");
		        }
		    }
		}
	

	// 2-1-1. 휴회신청
	public void requestRecess(TicketRegistration ticketReg) {
		Scanner scan = new Scanner(System.in);
		
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
	        String cmd = scan.nextLine().trim();
	        
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
	        
	        
	        // (2) 숫자인지 확인
	        try {
	            int days = Integer.parseInt(cmd);
	            
	            // 휴회일수가 days로 들어옴
	            // 이 days가 remaining 횟수보다 큰지 검사 -> 가능하면 ticketBreak(ticketReg, days)
	            if (days <= possibleBreakDays && days > 0) {
	                ticketBreak(ticketReg, days);
	                return;
	            } else {
	                System.out.println("\t휴회일을 정확하게 입력해주세요. 가능일수: " + possibleBreakDays );
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
		
//		휴회반영
		udtStartDate.add(Calendar.DATE, days);
		udtEndDate.add(Calendar.DATE, days);
//		저장
		TicketRegistrationDAO.save();

		MemberView.ticketBreakSuccess(days, udtStartDate, udtEndDate, name);
		
//		메인으로 복귀
		System.out.println("(엔터를 누르면 메인으로 돌아갑니다.)");
	    new Scanner(System.in).nextLine(); 

	    memberMainMenu();
	}

	
	
}
