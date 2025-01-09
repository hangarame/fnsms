package com.fnsms.instructor;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.emp.EmpDateService;
import com.fnsms.emp.EmpService;
import com.fnsms.view.InstructorClassMngView;
import com.fnsms.view.InstructorView;

public class InstructorService extends EmpService {

//	 # 예약조회 > 추가,수정,삭제
/*
	  1. 이번달 달력 출력
	  2. 날짜를 입력받음
	  > 그 날짜의 예약 목록을 출력
	  (1)신규 예약 추가
	  (2)기존 예약 변경
	  (3)기존 예약 삭제
	  3. 1에서 날짜가 아니라 회원의 이름을 입력받음
	  > 해당 회원의 예약정보를 출력
	  (1)신규 예약 추가
	  (2)기존 예약 변경
	  (3)기존 예약 삭제
*/	  
	
	
	Instructor instructor;
	
	
	
	public InstructorService(String empNo) {
		this.instructor = EmpDAO.getInstructor(empNo);
		
		
	}
	
	
	

	public Instructor getInstructor() {
		return instructor;
	}




	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}




	public static void startWork(String empNo) {
		Calendar now = Calendar.getInstance();
		
		String workDate = String.format("%04d%02d%02d"
				, now.get(Calendar.YEAR)
				, now.get(Calendar.MONTH) +1
				, now.get(Calendar.DATE) );
		
        Calendar endTime = (Calendar) now.clone(); // 같은 시간 복제
        
        int payment = 0;  // 아직 급여 계산 전
        
        Attendance att = new Attendance(empNo, workDate, now, endTime, payment);
        AttendanceDAO.attendanceList.add(att);
        AttendanceDAO.save();

        System.out.println("출근 등록 완료 - ");
	}//startWork
	
	public static void endWork(String empNo) {
	    Calendar now = Calendar.getInstance();
	        
	    String today = String.format("%04d%02d%02d",
	                now.get(Calendar.YEAR),
	                now.get(Calendar.MONTH) + 1,
	                now.get(Calendar.DATE));

// 해당 사번, 오늘 날짜, 출퇴근이 동일한(아직 퇴근처리가 안 된) 
// 출근 기록을 찾기
	    Attendance target = null;
        for (int i = AttendanceDAO.attendanceList.size() - 1; i >= 0; i--) {
            Attendance att = AttendanceDAO.attendanceList.get(i);
            if (att.getEmpNo().equals(empNo)
	                    && att.getWorkDate().equals(today)
	                    && isSameDateTime(att.getStartWorkTime(), att.getEndWorkTime())) {
	                target = att;
	                break;
	            }//if
	        }//for

	        if (target == null) {
	            System.out.println("퇴근 처리할 출근 기록이 없습니다.");
	            return;
	        }

	        // 퇴근 시간 설정
	        target.setEndWorkTime(now);

	        
	        // 출근~퇴근 시간
	        long diffMillis = target.getEndWorkTime().getTimeInMillis()
	                        - target.getStartWorkTime().getTimeInMillis();
	        long diffHours = diffMillis / (1000L * 60 * 60);

	        
//	        (근무시간 시급)+(수업 횟수 회단가)
//	        시급 : 10,000원, 회단가 : 25,000원
//	        3.3  : 월급 – (월급*0.033)
//	        월급 계산식입니다!
	        int payment = (int)(diffHours * 10000);
	        target.setPayment(payment);
	        AttendanceDAO.save();
	        System.out.println("퇴근 등록 완료 - ");
	}//endWork
	
	public static void readMyAttendance(String empNo) {
		// DAO에서 사원번호로 필터된 목록 가져오기
		// 사번입력 받아야함!!! 
		
        ArrayList<Attendance> myAttList = AttendanceDAO.getAttendanceList(empNo);

        if (myAttList.isEmpty()) {
            System.out.println("("+ empNo +")에 대한 기록이 없습니다.");
            return;
        }
System.out.println(" [사번]    [근무일]   [출근시간]            [퇴근시간]            [급여] ");
        for (Attendance att : myAttList) {
            System.out.println(att.toString());
        }
		
	}//readMyAttendance
	
	
//출퇴근등록 테스트용
	public static void testm() {
		Scanner scan = new Scanner(System.in);

		System.out.println("1. 출근등록");
		System.out.println("2. 퇴근등록");
		System.out.println("3. 내 기록 조회");
		String sel = scan.nextLine();
		
		if(sel.equals("1")){
			startWork("i00000001");
		} else if(sel.equals("2")) {
			endWork("i00000001");
		} else if(sel.equals("3")) {
			readMyAttendance("i00000001");
		}
		AttendanceDAO.save();
	}
	
	
//	날짜 확인 보조 메서드> 출퇴근등록에 쓰임
	private static boolean isSameDateTime(Calendar c1, Calendar c2) {
		return c1.getTimeInMillis() == c2.getTimeInMillis();
	}
	
	
	
	
	
	
	
	
//	# 수업료정산 메서드
	public static void calcSalary() {
        Scanner scan = new Scanner(System.in);

        EmpDAO.load();
        AttendanceDAO.load();
        TicketRegistrationDAO.load();

        Instructor instructor = null;

        while (true) {
            System.out.println("\n[수업료 정산]");
            System.out.println("수업료 정산을 위해 본인확인이 필요합니다.");
            System.out.println("(0) 뒤로가기");
            System.out.print("이름> ");
            String inputName = scan.nextLine().trim();
            
            // 0 → 처음 화면 복귀
            if (inputName.equals("0")) {
                return; 
            }
            
            System.out.print("생년월일(6자리)> ");
            String inputBirth6 = scan.nextLine().trim();
            if (inputBirth6.equals("0")) {
                return; 
            }

            // 강사 찾기
            instructor = findInstructor(inputName, inputBirth6);
            if (instructor == null) {
                System.out.println("해당 정보를 가진 강사를 찾을 수 없습니다. 다시 입력하세요.\n");
                continue;  // 재입력
            }
            // 찾으면 break
            break;
        }

//      근무현황
        String empNo = instructor.getEmpNo();

        // 이번 달
        Calendar now = Calendar.getInstance();
        int thisYear = now.get(Calendar.YEAR);
        int thisMonth = now.get(Calendar.MONTH) + 1; // 0~11
        String thisYYYYMM = String.format("%04d%02d", thisYear, thisMonth);

        // 지난 달
        Calendar prevCal = (Calendar) now.clone();
        prevCal.add(Calendar.MONTH, -1);
        int prevYear = prevCal.get(Calendar.YEAR);
        int prevMonth = prevCal.get(Calendar.MONTH) + 1;
        String prevYYYYMM = String.format("%04d%02d", prevYear, prevMonth);

        // 이번 달 근무시간/수업횟수
        long thisMonthHours = getMonthlyWorkHours(empNo, thisYYYYMM);
        int thisMonthClasses = getMonthlyClassCount(empNo, thisYYYYMM);

        // 지난 달 근무 + 수업
        long prevMonthHours = getMonthlyWorkHours(empNo, prevYYYYMM);
        int prevMonthClasses = getMonthlyClassCount(empNo, prevYYYYMM);
        int prevMonthSalary = calcSalary(prevMonthHours, prevMonthClasses);

        // 출력
        System.out.println("-------------------------------------------");
        System.out.printf("%s 님은 이번달 %d시간 근무했습니다.\n", instructor.getName(), thisMonthHours);
        System.out.printf("%04d년 %02d월 수업 횟수는 %d회 입니다.\n", thisYear, thisMonth, thisMonthClasses);
        System.out.printf("%04d년 %02d월은 %d시간 근무했으며, %,d원 정산했습니다.\n",
                prevYear, prevMonth, prevMonthHours, prevMonthSalary);
        System.out.println("===========================================");

        // 0 누르면 “처음 화면” 복귀
        System.out.print("처음 화면으로 돌아가려면 0을 입력, 계속하려면 Enter> ");
        String choice = scan.nextLine().trim();
        if (choice.equals("0")) {
            return;
        }

        
        //  (C) 지난 기록 조회
        while (true) {
            System.out.print("\n지난 기록을 확인하려면 근무 년,월을 입력하세요.(YYYYMM), (# -> 처음 화면) : ");
            String inputYYYYMM = scan.nextLine().trim();

            // # → 처음 화면
            if (inputYYYYMM.equals("#")) {
                return;
            }

            // 형식 체크
            if (inputYYYYMM.length() != 6) {
                System.out.println("입력 형식이 잘못되었습니다. (예: 202501)");
                continue;
            }

            long hours = getMonthlyWorkHours(empNo, inputYYYYMM);
            int classesCount = getMonthlyClassCount(empNo, inputYYYYMM);
            int monthlySalary = calcSalary(hours, classesCount);

            System.out.printf("[%s월 근무기록] 근무시간: %d시간, 수업횟수: %d회, 정산금액: %,d원\n",
                    inputYYYYMM, hours, classesCount, monthlySalary);
        }
    }
    private static Instructor
    findInstructor(String inputName, String inputBirth6) {
        for (Instructor ins : EmpDAO.instructorList) {
            if (ins.getName().equals(inputName)
            		&& ins.getBirthDate().length() >= 8) {
                String birth6 = ins.getBirthDate().substring(2, 8);
                if (birth6.equals(inputBirth6)) {
                    return ins;
                }
            }
        }
        return null;
    }//findInstructor

    private static long getMonthlyWorkHours(String empNo, String yyyyMM) {
        long totalHours = 0;
        ArrayList<Attendance> list = AttendanceDAO.getAttendanceList(empNo);
        for (Attendance att : list) {
            String workDate = att.getWorkDate(); // yyyymmdd
            if (workDate.startsWith(yyyyMM)) {
                long diffMillis = att.getEndWorkTime().getTimeInMillis()
                                - att.getStartWorkTime().getTimeInMillis();
                long hours = diffMillis / (1000L * 60 * 60);
                totalHours += hours;
            }
        }
        return totalHours;
    }//getMonthlyWorkHours

    private static int getMonthlyClassCount(String empNo, String yyyyMM) {
        return TicketRegistrationDAO.getMonthlyClassCount(empNo, yyyyMM);
    }

//  계산
    private static int calcSalary(long hours, int classCount) {
        long gross = hours * 10000 + classCount * 25000;
        long net = (long)(gross - (gross * 0.033));
        return (int)net;
    }

  //3-2 수업 관리 및 예약 출력 메서드
    public static void classManagement() {
//        InstructorClassMngView.printInquiryClass("홍길종","필테");
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("\t🖙 원하는 작업을 입력하세요: ");
            String input = scan.nextLine();

            switch (input) {
            case "1":
//              System.out.println("날짜별 예약 조회를 선택하셨습니다.");
            	EmpDateService empDateService = new EmpDateService();
            	empDateService.viewByDate();
                break;
            case "2":
                System.out.println("담당회원별 예약 조회를 선택하셨습니다.");
//                viewByMember();지온
                break;
            case "#":
                System.out.println("메인으로 돌아갑니다.");
                isRunning = false;
                break;
            default:
                System.out.println("올바른 입력이 아닙니다. 다시 시도해주세요.");
        }

            }

        }
    
    //강사의 담당 보유 회원수
    public int getNumberOfMngedMember(Instructor ins) {
    	int count = TicketRegistrationDAO.getTicketRegListByManager(ins.getEmpNo()).size();
    	
    	return count;
    }
    
    //강사의 가장 빠른 수업 예정일, 시간 (Calendar)
    public Calendar getFirstBookDay(Instructor ins) {
    	
    	Calendar currentDate = Calendar.getInstance();
    	
    	//강사의 모든 예약 리스트
    	ArrayList<Reservation> reservList = ReservationDAO.getReservationListByEmpNo(ins.getEmpNo());
    	
    	//유효한 이용권 등록
    	ArrayList<TicketRegistration> regList = getValidRegstration(ins);
    	
    	//강사의 유효한 수업리스트
    	ArrayList<Reservation> validReservList = new ArrayList<Reservation>(); 
    	
    	ArrayList<Calendar> calList = new ArrayList<Calendar>();
    	
    	
    	for(Reservation reserv : reservList) {
    		for(TicketRegistration reg : regList) {
    			if(reserv.getTicketRegNo() == reg.getTicketRegNo()) {
    				calList.add(reserv.getReservDate());
    			}
    		}
    	}
    	
    	//오름차 정렬
    	Collections.sort(calList, (o1, o2) -> o1.compareTo(o2));
    	
    	if(calList.isEmpty() ) {
    		System.out.println("수업이 없습니다.");
    		return null;
    	} else {
    		return calList.get(0);
    	}

    }
    
 // 기간이 유효한 이용권 등록 가져오기(현재일이 시작일과 종료일 기간이 아니면 해당되지 않음)
 	public ArrayList<TicketRegistration> getValidRegstration(Instructor instructor){

 		ArrayList<TicketRegistration> regList = new ArrayList<TicketRegistration>();
 		Calendar current = Calendar.getInstance();				
 		
 		for (TicketRegistration reg : TicketRegistrationDAO.getTicketRegListByManager(instructor.getEmpNo())) {
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

    
    //3. 강사일 경우<메인화면>
	public void instructorMainMenu() {

		Scanner scan = new Scanner(System.in);
		//printMainMenu(String insName, String position, String tel, String birth, int memberOfIns, String classTime)
		
		String insName = this.instructor.getName();
		String position = this.instructor.getRole();
		String tel = this.instructor.getTel();
		String birth = this.instructor.getBirthDate();
		int numberOfMngedMember = getNumberOfMngedMember(this.instructor);
		String classTime = getFirstBookDay(this.instructor) != null ? String.format("%02d", getFirstBookDay(this.instructor).get(Calendar.HOUR_OF_DAY)) : null;
		 
		InstructorView.printMainMenu(insName, position, tel, birth, numberOfMngedMember, classTime);
		
		/*
		//회원의 이용중인 유효한 이용권
		ArrayList<TicketRegistration> validRegList = this.getValidRegstration(this.getMember());
		
		MemberView.printMainmenu(this.getMember().getName(), this.getMember().getTel(), this.getMember().getBirthDate()
				, this.haveUseTowelTicketUse()
				, validRegList.get(0).getTicket()
				, this.getTicketRemainIning(validRegList.get(0))
				, validRegList.get(0).getEndDate());
		
//		return validRegList.get(0);
		
		while(true) {
//			Scanner scan = new Scanner(System.in);
			
			String cmd = scan.nextLine();
			
			if(cmd.equals("1")) {
				inquiryTicketInfo(validRegList.get(0));
//				scan.close();
			} else if(cmd.equals("2")) {

				// 예약 조회
//				scan.close();
			} else if(cmd.equals("E")) {

				//로그아웃 메서드
//				scan.close();
			} else {
				System.out.println("\t정해진 문자를 입력해주세요.");
//				scan.close();
			}
		}
		*/
		
	}
	
}//class