package com.fnsms.main;

import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.InstructorView;
import com.fnsms.view.MemberView;

public class Main {
	public static void main(String[] args) {

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
		
//		System.out.println("PrintBanner");
//		new MemberView().PrintBanner();
//		System.out.println("printDate");
//		new MemberView().printDate();
//		System.out.println("printMainmenu");
//		new MemberView().printMainmenu();
//		System.out.println("printUsingTicket");
//		new MemberView().printUsingTicket();
//		System.out.println("ticketBreak");
//		new MemberView().ticketBreak();
//		System.out.println("ticketBreakFailed");
//		new MemberView().ticketBreakFailed();
//		System.out.println("ticketBreakSuccess");
//		new MemberView().ticketBreakSuccess();

	}
}
