package com.fnsms.main;

import com.fnsms.user.UserService;
import com.fnsms.view.InstructorClassMngView;

public class Main {
	public static void main(String[] args) {
		InstructorClassMngView.printSelectReservationDate("홍길동","PT");
		
		UserService.logIn();

	}

}
