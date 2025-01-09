package com.fnsms.main;

import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.user.UserService;

public class Main {
	public static void main(String[] args) {

		AttendanceDAO.load();
		EmpDAO.load();
		MemberDAO.load();
		ReservationDAO.load();
		TicketDAO.load();
		TicketRegistrationDAO.load();
		
		UserService.logIn();
	
		


	}


}
