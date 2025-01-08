package com.fnsms.instructor;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.emp.MemberService;
import com.fnsms.member.Member;
import com.fnsms.reservation.Reservation;

public class InstructorService extends MemberService {

	
//	회원등록
	public static void resisterMember() {
		Scanner scan = new Scanner(System.in);

//		입력 안내 메시지 출력
//		>
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("생년월일: ");
		String birthDate = scan.nextLine();
		System.out.print("연락처: ");
		String tel = scan.nextLine();
		System.out.print("회원번호: ");
		String memberNo = scan.nextLine();
		
		Member newMember = new Member(name,tel,birthDate,memberNo);
		MemberDAO.memberList.add(newMember);
		
		MemberDAO.save();
//		등록 완료 메시지 출력
		
	}//resisterMember
	
// 회원조회
	public static void readMemberList() {
//      회원 목록이 비어있는지 확인
		if (MemberDAO.memberList.isEmpty()) {
			System.out.println("등록된 회원이 없습니다.\n");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		
		int pageSize = 20;
		int total = MemberDAO.memberList.size();
		int currentIndex = 0;
		
//		회원 조회 안내 메시지 출력
//		>
		
//      전체 회원 정보 출력
        System.out.println("\t[이름]\t\t[연락처]\t\t[생년월일]");
        while (currentIndex < total) {
        	int endIndex = currentIndex + pageSize;
        	if(endIndex > total) {
        		endIndex = total;
        	}
        	
        	for (int i = currentIndex; i<endIndex; i++) {
        		Member m = MemberDAO.memberList.get(i);
        		System.out.printf("%-3d\t%s\t\t%s\t\t%s\r\n"
        				,i+1, m.getName(), m.getTel(), m.getBirthDate());
        	}
        	
        		currentIndex = endIndex;
        		if(currentIndex >= total) {
        			System.out.println("더 이상 조회할 정보가 없습니다.");
        			break;
        		}
        		
        	System.out.println("엔터를 누르면 목록을 더 불러옵니다.");
        	System.out.println("그만 보려면 1을 입력");
        	String input = scan.nextLine();
        	if(input.equalsIgnoreCase("1")) {
        		System.out.println("조회를 중단합니다.");
        		break;
        	}
        }//while
	}//readMemberList
	
	
	

  

		
		
		

		


	
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
	
	
	
	
	
	// 수업관리
	public void manageClass() {

	}
	
	private static boolean isSameDateTime(Calendar c1, Calendar c2) {
        return c1.getTimeInMillis() == c2.getTimeInMillis();
    }

	// 예약조회
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
