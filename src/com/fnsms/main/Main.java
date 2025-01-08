package com.fnsms.main;

<<<<<<< Updated upstream
import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;
=======
import com.fnsms.dao.MemberDAO;
import com.fnsms.instructor.InstructorService;
>>>>>>> Stashed changes

public class Main {
	public static void main(String[] args) {
//		CommonView.printLoginSelct();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();
<<<<<<< Updated upstream
//
//		new CalendarView().start();
		
//		MemberView.printMainmenu();
		
		AttendanceDAO.load();
		AttendanceDAO.save();
		
//		for(Attendance a : AttendanceDAO.getAttendanceList("i00000001")) {
//			System.out.println(a);
//		}
//		
		for(Attendance a : AttendanceDAO.getAttendanceByDateList("20241201")) {
			System.out.println(a);
		}
		
		
		
		
		
		
=======

//		CommonView.printCalendar();
		MemberDAO.load();
		InstructorService.readMemberList();
	
>>>>>>> Stashed changes
	}
}
