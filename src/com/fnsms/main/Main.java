package com.fnsms.main;

import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;

import com.fnsms.dao.MemberDAO;
import com.fnsms.instructor.InstructorService;


public class Main {
	public static void main(String[] args) {
//		CommonView.printLoginSelct();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();
//
//		new CalendarView().start();
		
//		MemberView.printMainmenu();
//		
//		AttendanceDAO.load();
//		AttendanceDAO.save();
//		
////		for(Attendance a : AttendanceDAO.getAttendanceList("i00000001")) {
////			System.out.println(a);
////		}
////		
//		for(Attendance a : AttendanceDAO.getAttendanceByDateList("20241201")) {
//			System.out.println(a);
//		}
		
		
		
		AttendanceDAO.load();
		InstructorService.testm();	
	}
}
