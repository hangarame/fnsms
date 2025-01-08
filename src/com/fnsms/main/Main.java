package com.fnsms.main;

<<<<<<< HEAD
import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
<<<<<<< HEAD
import com.fnsms.view.InstructorView;

public class Main {
	public static void main(String[] args) {
		new InstructorView().printInquiryAtendancePunchOut();
=======
import com.fnsms.view.MemberView;
=======
import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;
import com.fnsms.user.UserService;
>>>>>>> ij

public class Main {
	public static void main(String[] args) {
//		CommonView.printLoginSelct();
//		MemberView.PrintBanner();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();
//
//		new CalendarView().start();
		
//		MemberView.printMainmenu();
<<<<<<< HEAD
<<<<<<< HEAD
//		MemberView.printUsingTicket();
=======
>>>>>>> sw
//		MemberView.printDate();
//		MemberView.ticketBreak();
//		MemberView.ticketBreakSuccess();
//		MemberView.ticketBreakFailed();
//		
<<<<<<< HEAD
//		AdministratorView.adminPrintBanner();
>>>>>>> 1541f55fd6defcb8f9f32375293272d5c9e32283
		
=======
		AdministratorView.PrintBanner();
		AdministratorView.instructorManagement();
		AdministratorView.instructorManagementFailed();
		AdministratorView.selectInstructor();
		AdministratorView.attendanceManagement();
>>>>>>> sw

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
