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
	

	
	
	

	 
	
	
	
	
		
		
		

	
}//class