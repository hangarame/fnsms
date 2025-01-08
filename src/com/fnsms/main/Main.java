package com.fnsms.main;

import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.MemberView;

public class Main {
	public static void main(String[] args) {
		CommonView.printLoginSelct();
		MemberView.memPrintBanner();
		CommonView.printLoginFailed();
		CommonView.printLogout();
//
//		new CalendarView().start();
		
//		MemberView.printMainmenu();
//		MemberView.printUsingTicket();
//		MemberView.printDate();
//		MemberView.ticketBreak();
//		MemberView.ticketBreakSuccess();
//		MemberView.ticketBreakFailed();
//		
//		AdministratorView.adminPrintBanner();
		

	}
}
