package com.fnsms.main;

import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.MemberView;

public class Main {
	public static void main(String[] args) {
//		CommonView.printLoginSelct();
//		MemberView.PrintBanner();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();
//
//		new CalendarView().start();
		
//		MemberView.printMainmenu();
//		MemberView.printDate();
//		MemberView.ticketBreak();
//		MemberView.ticketBreakSuccess();
//		MemberView.ticketBreakFailed();
//		
		AdministratorView.PrintBanner();
		AdministratorView.instructorManagement();
		AdministratorView.instructorManagementFailed();
		AdministratorView.selectInstructor();
		AdministratorView.attendanceManagement();

	}
}
