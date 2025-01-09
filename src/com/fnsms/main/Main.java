package com.fnsms.main;


import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.emp.EmpService;
import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.InstructorClassMngView;
import com.fnsms.view.InstructorMemberView;
import com.fnsms.view.InstructorView;

public class Main {
	public static void main(String[] args) {
//966◈m00000466◈필라테스1개월◈2024-10-16◈i000000005◈2024-10-18◈2025-01-16◈880000
		
		
		
//		System.out.println("printMainMenu > 강사메인");
//		InstructorView.printMainMenu();
//		System.out.println("printInquiryAtendance > 강사 근퇴관리");
//		InstructorView.printInquiryAtendance();
//		System.out.println("printAtendancePunchIn > 강사 출근");
//		InstructorView.printAtendancePunchIn();
//		System.out.println("printAtendancePunchOut > 강사 퇴근");
//		InstructorView.printAtendancePunchOut();
//		System.out.println("printCheckAttendanceRecord > 강사 근퇴조회");
//		InstructorView.printCheckAttendanceRecord();
//		System.out.println("printCheckAttendanceRecord > 강사 근퇴결과");
//		InstructorView.printCheckAttendanceRecordResult();
//		System.out.println("printCheckAttendanceRecord > 강사 근퇴입력오류");
//		InstructorView.printCheckAttendanceRecordFailed();
//		CommonView.printInputErrorh();
//		InstructorClassMngView.printInquiryClass(); // 수업 관리 및 예약
//		InstructorClassMngView.printSelectReservationDate(); // 날짜별 예약 조회
//		InstructorClassMngView.printReservationDate();// 일자별 수업 예약 상세내역
//		InstructorClassMngView.printAddReservation_Date(); // 수업예약 등록(날짜별)
//		InstructorClassMngView.printEditReservation_Date(); // 수업예약 변경(날짜별)
//		InstructorClassMngView.printDeleteReservation_Date(); // 수업예약 삭제(날짜별)
//		InstructorClassMngView.printSearchReservationMember();// 담당회원별 예약 조회
//		InstructorClassMngView.ifSameNameClassMember();// 담당회원별 예약 조회 동명이인인경우
		AttendanceDAO.load();
		ReservationDAO.load();
		TicketDAO.load();
		TicketRegistrationDAO.load();
		EmpDAO.load();
		MemberDAO.load();
		
		InstructorMemberView.newMemRegistration();
		EmpService.addMember();
	}
}
