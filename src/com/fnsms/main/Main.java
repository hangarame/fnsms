package com.fnsms.main;


import com.fnsms.user.UserService;
import com.fnsms.view.MemberView;

public class Main {
	public static void main(String[] args) {
//		CommonView.printLoginSelct();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();
//
//		new CalendarView().start();
		
		MemberView.printMainmenu();
		
		UserService.logIn();
		

	}
}
