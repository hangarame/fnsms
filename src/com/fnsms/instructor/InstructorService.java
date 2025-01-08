package com.fnsms.instructor;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.emp.EmpService;
import com.fnsms.member.Member;
import com.fnsms.reservation.Reservation;
import com.fnsms.ticket.Ticket;

public class InstructorService extends EmpService {

	
	
	

	
//	특정 회원 조회하기
	public static void readMember() {
//	이름을 입력받아서
//	해당 이름을 가진 회원의 정보를 출력
//	(1)회원정보 수정 (2)이용권등록 (3)이용권수정 	
	}//readMember 회원조회
//	회원정보 수정 기능 추가해야함
//	이용권 등록, 수정 기능 추가해야함
/*
	 # 이용권 등록
	 
	 1.
	 DummyTicket.txt
	 상품번호, 이용권이름, 기간, 등록일, 판매종료일, 수업횟수, 가격
	 ex) 1◈헬스1개월◈30◈19700101000000◈99991231235900◈0◈150000
	 
	 DummyRegistTicket.txt
	 등록번호, 회원번호, 이용권이름, 구매일(등록일), 등록담당자, 시작일, 종료일, 가격
	 ex) 959◈m0000000459◈운동복12개월◈2024-08-07◈i000000003◈2024-08-10◈2025-02-06◈132000
	 
	 2. 
	 (등록일, 이용권이름, 이용가능기간, 등록담당자, 시작일, 금액)을 입력받기
	 > 이용권 정보를 생성
	 > TicketDAO.java의 ArrayList<Ticket> ticketList 안에 추가
	 > data폴더의 DummyTicket.txt에 저장
	 상품번호, 이용권이름, 이용권기간, 등록일, 판매종료일,수업횟수,금액
	 
	 2. 
 	
 	
*/
	
	

  

		
		
		

		


	
/*
1. 이번주 근태현황 출력
2. 아래에 선택메뉴 출력
	(1) 출근등록
	(2) 퇴근등록
	(3) 근태기록조회하기
	(#) 메인으로 돌아가기
	
1. 
data폴더> DummyAttendance.txt에 정보 있음.
직원번호, 근무일, 출근시간, 퇴근시간, 급여
ex) i00000001◈20241201◈20241201090000◈20241201180000◈0
com.fnsms.dao 패키지 > AttendanceDAO.java > ArrayList<Attendance> attendanceList
컬렉션으로 데이터를 옮겨서 프로그램에서 사용.

2.
ArrayList<Attendance> attendanceList에
내 직원번호로 시작하고, 현재시간이 있는 주간과 같은 주간에 속하는 날짜가
저장되어 있는 근태기록을
(일)	(월)	(화)	(수)	(목)	(금)	(토)
출근	출근	출근	결근	오늘	
이런 식으로 출력시키기. 

3.
(1) 출근등록
현재시간으로 출근등록하기


(2) 퇴근등록
출근등록과 마찬가지
현재시간으로 퇴근등록하기

(3)
근태기록조회
ArrayList<Attendance> attendanceList에서 
내 사번으로 시작하는 정보만 뽑아와서 목록으로 출력하기

*/
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

// 해당 사번 & 오늘 날짜 & 출근, 퇴근이 동일한(즉, 아직 퇴근처리가 안 된) 
// 출근 기록을 찾는다
	
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

	        
	        // 출근~퇴근 시간(밀리초 차이)
	        long diffMillis = target.getEndWorkTime().getTimeInMillis()
	                        - target.getStartWorkTime().getTimeInMillis();
	        // 시간 단위로 변환
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
        ArrayList<Attendance> myAttList = AttendanceDAO.getAttendanceList(empNo);

        if (myAttList.isEmpty()) {
            System.out.println("해당 사번[" + empNo + "]에 대한 근태 기록이 없습니다.");
            return;
        }
System.out.println(" [사번]    [근무일]   [출근시간]            [퇴근시간]            [급여] ");
        for (Attendance att : myAttList) {
            System.out.println(att.toString());
        }
		
	}
	
	
//	테스트용
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
	
	
	
	private static boolean isSameDateTime(Calendar c1, Calendar c2) {
		return c1.getTimeInMillis() == c2.getTimeInMillis();
	}
	

	
	// 수업관리
	public void manageClass() {

	}
	

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
	  
	  
	 
	 
	 # 수업료정산
	 1. 근무현황출력
	 - 해당 달에 총 몇시간 근무했는지 출력
	 - 해당 달에 예약되어 있는 수업 횟수 출력
	 - 지금까지 근무한 시간을 토대로 급여 계산해서 출력
	 - 지난달 근무시간과 그에 해당하는 급여 출력
	 - 숫자(year, month값: yyyymm)을 입력받아서 해당 월에 대한 근무시간과 그에 대한 급여 출력
	 
	 
	 
	 
	 
	
	 
*/
//	public ArrayList<Reservation> inquiryReservinfo() {
		
		
		
//	}

	
	//수업예약
//	public Reservation addReserv() {
//
//	}
//	
//	//수업변경
//	public Reservation editReserv() {
//		
//	}
//	
//	//수업삭제
//	public Reservation deleteReserv() {
//		
//	}
//
}
