package com.fnsms.main;

<<<<<<< HEAD
import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.MemberView;
=======
import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;
import com.fnsms.user.UserService;
>>>>>>> ij

public class Main {
	public static void main(String[] args) {
		CommonView.printLoginSelct();
		MemberView.memPrintBanner();
		CommonView.printLoginFailed();
		CommonView.printLogout();
//
//		new CalendarView().start();
		
//		MemberView.printMainmenu();
<<<<<<< HEAD
//		MemberView.printUsingTicket();
//		MemberView.printDate();
//		MemberView.ticketBreak();
//		MemberView.ticketBreakSuccess();
//		MemberView.ticketBreakFailed();
//		
//		AdministratorView.adminPrintBanner();
		

	}
=======
		
		UserService.logIn();
		
//		AttendanceDAO.load();
//		AttendanceDAO.save();
//		
////		for(Attendance a : AttendanceDAO.getAttendanceList("i00000001")) {
////			System.out.println(a);
////		}
////		
//		for(Attendance a : AttendanceDAO.getAttendanceByDateList("20241201")) {
//			System.out.println(a);
		}
		
		
		
		
		
		
	
>>>>>>> ij
}
