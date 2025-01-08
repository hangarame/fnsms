package com.fnsms.main;

import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.InstructorView;
import com.fnsms.view.MemberView;

public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD
//		CommonView.printLoginSelct();
//		MemberView.PrintBanner();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();
//
//		new CalendarView().start();
		
//		MemberView.printMainmenu();
<<<<<<< HEAD
<<<<<<< HEAD
//		MemberView.printUsingTicket();
=======
>>>>>>> sw
//		MemberView.printDate();
//		MemberView.ticketBreak();
//		MemberView.ticketBreakSuccess();
//		MemberView.ticketBreakFailed();
//		
<<<<<<< HEAD
//		AdministratorView.adminPrintBanner();
>>>>>>> 1541f55fd6defcb8f9f32375293272d5c9e32283
=======
>>>>>>> jo
		
=======
		AdministratorView.PrintBanner();
		AdministratorView.instructorManagement();
		AdministratorView.instructorManagementFailed();
		AdministratorView.selectInstructor();
		AdministratorView.attendanceManagement();
>>>>>>> sw

		System.out.println("printMainMenu");
		new InstructorView().printMainMenu();
		System.out.println("printInquiryAtendance");
		new InstructorView().printInquiryAtendance();
		System.out.println("printAtendancePunchIn");
		new InstructorView().printAtendancePunchIn();
		System.out.println("printAtendancePunchOut");
		new InstructorView().printAtendancePunchOut();
		System.out.println("printCheckAttendanceRecord");
		new InstructorView().printCheckAttendanceRecord();
		System.out.println("printCheckAttendanceRecordResult");
		new InstructorView().printCheckAttendanceRecordResult();
		
	}
}
