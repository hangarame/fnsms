package com.fnsms.main;

import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.user.UserService;
import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.InstructorView;

import com.fnsms.view.MemberView;


public class Main {
	public static void main(String[] args) {
		
		// 파일 데이터 객체 생성
		AttendanceDAO.load();
		EmpDAO.load();
		MemberDAO.load();
		ReservationDAO.load();
		TicketDAO.load();
		TicketRegistrationDAO.load();
		
		//로그인
		UserService.logIn();
		
		
		

	}
}
