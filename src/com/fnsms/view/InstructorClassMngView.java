
package com.fnsms.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.fnsms.dao.ReservationDAO;
import com.fnsms.reservation.Reservation;
/**
 * 강사의 수업관리에 관한 출력화면을 모은 클래스입니다.
 * @author 1조
 */
public class InstructorClassMngView implements ConsoleColor {

	private int reservationTime = -1;
	private static Calendar now = Calendar.getInstance();

	// 수업관리 출력
	public static void printInquiryClass(String name, String position) {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t\t수업 관리 및 예약");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t%s %s님의 수업 관리 상세보기 페이지입니다.\r\n", name, position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t1. 날짜별 예약 조회");
		System.out.println("\t2. 담당회원별 예약 조회");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

	}

	// 수업 예약 날짜 선택 >> 미완
	public static void printSelectReservationDate(String instructorName, String classType) {

		int ResvationDate = 0;

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t\t날짜별 예약 조회");
		System.out.println("=================================================================================");
		
		ArrayList<Reservation> reservations =
				ReservationDAO.getReservationsByInstructor(instructorName, classType);
		
//		CalendarView calendar = new CalendarView(reservations, true);
		CalendarView calendar = new CalendarView();
		calendar.start(instructorName);
		
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t이전 달을 보고싶을 경우 \"<\"을, 다음달을 보고싶을 경우 \">\"을 입력해주세요.");
		System.out.println("\t예약을 조회하고 싶을 경우 날짜를 입력하세요.  ");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

	}
	
	// 수업 예약일 >> 미완
	public static void printReservationDate() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t일자별 수업 예약 상세내역");
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("\t%tF %s %s님의 일자별 수업 예약 현황입니다.\r\n", InstructorView.instrutorName, InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("- 9시 : %s", InstructorView.memberName);
//		System.out.printf("- 10시 : %s", InstructorView.memberName);
//		System.out.printf("- 11시 : %s", InstructorView.memberName);
//		System.out.printf("- 12시 : %s", InstructorView.memberName);
//		System.out.printf("- 13시 : %s", InstructorView.memberName);
//		System.out.printf("- 14시 : %s", InstructorView.memberName);
//		System.out.printf("- 15시 : %s", InstructorView.memberName);
//		System.out.printf("- 16시 : %s", InstructorView.memberName);
//		System.out.printf("- 17시 : %s", InstructorView.memberName);
//		System.out.printf("- 18시 : %s", InstructorView.memberName);
//		System.out.printf("- 19시 : %s", InstructorView.memberName);
//		System.out.printf("- 20시 : %s", InstructorView.memberName);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t1. 예약 등록");
		System.out.println("\t2. 예약 변경");
		System.out.println("\t3. 예약 취소");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

	}

	// 수업예약 등록
	public static void printAddReservation_Date() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t수업예약 등록(날짜별)");
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("\t%tF %s %s님의 일자별 수업 예약 현황입니다.\r\n", now, InstructorView.instrutorName, InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("- 9시 : %s", InstructorView.memberName);
//		System.out.printf("- 10시 : %s", InstructorView.memberName);
//		System.out.printf("- 11시 : %s", InstructorView.memberName);
//		System.out.printf("- 12시 : %s", InstructorView.memberName);
//		System.out.printf("- 13시 : %s", InstructorView.memberName);
//		System.out.printf("- 14시 : %s", InstructorView.memberName);
//		System.out.printf("- 15시 : %s", InstructorView.memberName);
//		System.out.printf("- 16시 : %s", InstructorView.memberName);
//		System.out.printf("- 17시 : %s", InstructorView.memberName);
//		System.out.printf("- 18시 : %s", InstructorView.memberName);
//		System.out.printf("- 19시 : %s", InstructorView.memberName);
//		System.out.printf("- 20시 : %s", InstructorView.memberName);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t예약 할 시간과 담당회원의 이름을 입력하세요.");
		System.out.println();
//		System.out.println("\t>> 예약시간 : ");
//		System.out.println("\t>> 회원이름 : ");
//		 잘못 입력한 경우 >> System.out.println("\t "+tRED+"잘못된 입력이거나 등록정보가 없습니다. 다시한번 확인해주세요."+RESET+"");
	}

	// 수업예약 변경
	public static void printEditReservation_Date() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t수업예약 변경(날짜별)");
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("\t%tF %s %s님의 일자별 수업 예약 현황입니다.\r\n", now, InstructorView.instrutorName, InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("- 9시 : %s", InstructorView.memberName);
//		System.out.printf("- 10시 : %s", InstructorView.memberName);
//		System.out.printf("- 11시 : %s", InstructorView.memberName);
//		System.out.printf("- 12시 : %s", InstructorView.memberName);
//		System.out.printf("- 13시 : %s", InstructorView.memberName);
//		System.out.printf("- 14시 : %s", InstructorView.memberName);
//		System.out.printf("- 15시 : %s", InstructorView.memberName);
//		System.out.printf("- 16시 : %s", InstructorView.memberName);
//		System.out.printf("- 17시 : %s", InstructorView.memberName);
//		System.out.printf("- 18시 : %s", InstructorView.memberName);
//		System.out.printf("- 19시 : %s", InstructorView.memberName);
//		System.out.printf("- 20시 : %s", InstructorView.memberName);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t수정 할 시간과 담당회원의 이름을 입력하세요.");
		System.out.println();
//		System.out.println("\t>> 예약시간 : ");
//		System.out.println("\t>> 회원이름 : ");
//		 잘못 입력한 경우 >> System.out.println("\t "+tRED+"잘못된 입력이거나 등록정보가 없습니다. 다시한번 확인해주세요."+RESET+"");
	}

	// 수업취소 출력
	public static void printDeleteReservation_Date() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t수업예약 삭제(날짜별)");
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("\t%tF %s %s님의 일자별 수업 예약 현황입니다.\r\n", now, InstructorView.instrutorName, InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("- 9시 : %s", InstructorView.memberName);
//		System.out.printf("- 10시 : %s", InstructorView.memberName);
//		System.out.printf("- 11시 : %s", InstructorView.memberName);
//		System.out.printf("- 12시 : %s", InstructorView.memberName);
//		System.out.printf("- 13시 : %s", InstructorView.memberName);
//		System.out.printf("- 14시 : %s", InstructorView.memberName);
//		System.out.printf("- 15시 : %s", InstructorView.memberName);
//		System.out.printf("- 16시 : %s", InstructorView.memberName);
//		System.out.printf("- 17시 : %s", InstructorView.memberName);
//		System.out.printf("- 18시 : %s", InstructorView.memberName);
//		System.out.printf("- 19시 : %s", InstructorView.memberName);
//		System.out.printf("- 20시 : %s", InstructorView.memberName);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t삭제 할 시간을 입력하세요.");
		System.out.println();
//		System.out.println("\t>> 예약시간 : ");
//		System.out.println("\t>> 회원이름 : ");
//		 잘못 입력한 경우 >> System.out.println("\t "+tRED+"잘못된 입력이거나 등록정보가 없습니다. 다시한번 확인해주세요."+RESET+"");

	}

	// 담당회원 조회
	public static void printSearchReservationMember() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t담당회원별 예약 조회");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t%s %s님의 담당회원별 예약현황 조회 페이지입니다.\r\n", InstructorView.instrutorName, InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.printf("\t- %s 회원님\r\n", "홍길동"); // 담당회원 명단
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t이전 달을 보고싶을 경우 \"<\"을, 다음달을 보고싶을 경우 \">\"을 입력해주세요.");
		System.out.println("\t>>조회할 회원 이름을 입력해주세요. : ");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

	}

	// case1. 동명이인인경우
	public static void ifSameNameClassMember() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t중복 회원 선택");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t검색한 %s 회원님의 명단입니다.\r\n", "홍길동");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t\t[성함]\t\t[전화 번호]");
		System.out.printf("\t\t%s\t\t010-9147-1847\r\n", "홍길동");
		System.out.printf("\t\t%s\t\t010-9147-1847\r\n", "홍길동");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t>> 조회 할 회원의 전화번호 뒷 4자리를 입력해주세요.");
		System.out.println();
		// System.out.println("\t

	}

	// case2. 담당회원 조회 성공 또는 선택 후
	public static void ifNameSelectSuccess() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t담당회원별 수업 예약 상세내역");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t검색한 %s 회원님의 상세 예약 내역입니다.\r\n", "홍길동");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t\t  [날짜]\t[시간]");
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t(메인으로 돌아가려면 #을 입력해주세요.)");
//		System.out.println("\t>> 선택 할 회원의 예약 날짜와 시간을 입력해주세요.");
		// >선택 완료 후 하위 아래 기능 동작
//		System.out.println("\t1. 예약 등록");
//		System.out.println("\t2. 예약 변경");
//		System.out.println("\t3. 예약 취소");
//		System.out.println();
		// System.out.println("\t

	}

	// 수업예약 등록
	public static void printAddReservation_Member() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t수업예약 등록(회원별)");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t%tF %s %s님의 일자별 수업 예약 현황입니다.\r\n", now, InstructorView.instrutorName,
				InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t\t  [날짜]\t[시간]");
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t예약 할 시간과 담당회원의 이름을 입력하세요.");
		System.out.println();
//		System.out.println("\t>> 예약시간 : ");
//		System.out.println("\t>> 회원이름 : ");
//		 잘못 입력한 경우 >> System.out.println("\t "+tRED+"잘못된 입력이거나 등록정보가 없습니다. 다시한번 확인해주세요."+RESET+"");
	}

	// 수업예약 변경
	public static void printEditReservation_Member() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t수업예약 변경(회원별)");
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("\t%tF %s %s님의 일자별 수업 예약 현황입니다.\r\n", now, InstructorView.instrutorName, InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t\t  [날짜]\t[시간]");
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t수정 할 예약 시간과 담당회원의 이름을 입력하세요.");
		System.out.println();
//		System.out.println("\t>> 예약시간 : ");
//		System.out.println("\t>> 회원이름 : ");
//		 잘못 입력한 경우 >> System.out.println("\t "+tRED+"잘못된 입력이거나 등록정보가 없습니다. 다시한번 확인해주세요."+RESET+"");
	}

	// 수업취소 출력
	public static void printDeleteReservation_Member() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t수업예약 삭제(회원별)");
		System.out.println("=================================================================================");
		System.out.println();
//		System.out.printf("\t%tF %s %s님의 일자별 수업 예약 현황입니다.\r\n", now, InstructorView.instrutorName, InstructorView.position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.printf("\t\t%tF\t%tT\r\n", now, now);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println("\t삭제 할 시간을 입력하세요.");
		System.out.println();
//		System.out.println("\t>> 예약시간 : ");
//		System.out.println("\t>> 회원이름 : ");
//		 잘못 입력한 경우 >> System.out.println("\t "+tRED+"잘못된 입력이거나 등록정보가 없습니다. 다시한번 확인해주세요."+RESET+"");

	}

}
