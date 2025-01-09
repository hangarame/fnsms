package com.fnsms.main;

import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.instructor.InstructorService;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.InstructorClassMngView;
import com.fnsms.view.InstructorView;

public class Main {
	public static void main(String[] args) {

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
//		InstructorClassMngView.printSelectReservationDate(); //날짜별 예약 조회
//		InstructorClassMngView.printReservationDate();// 일자별 수업 예약 상세내역
//		InstructorClassMngView.printAddReservation_Date(); //수업예약 등록(날짜별)
//		InstructorClassMngView.printEditReservation_Date(); //수업예약 변경(날짜별)
//		InstructorClassMngView.printDeleteReservation_Date();//수업예약 삭제(날짜별)
//		InstructorMemberView.searchMember();
//		InstructorMemberView.searchMemberFailed();
//		InstructorMemberView.selectMemberList();
//		InstructorMemberView.selectMemberListFailed();
//		InstructorMemberView.selectMember();
		
		AttendanceDAO.load();
		EmpDAO.load();
		MemberDAO.load();
		TicketDAO.load();
		TicketRegistrationDAO.load();
		InstructorService.calcSalary();

	}

}//main

