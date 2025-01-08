package com.fnsms.main;

import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;

public class Main {
	public static void main(String[] args) {
		CommonView.printLoginSelct();
		CommonView.printLogin();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();
//
		new CalendarView().start();
		

	}
}
