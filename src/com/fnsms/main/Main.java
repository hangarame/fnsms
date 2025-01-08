package com.fnsms.main;

import com.fnsms.view.AdministratorView;
import com.fnsms.view.CalendarView;
import com.fnsms.view.CommonView;
import com.fnsms.view.InstructorView;
import com.fnsms.view.MemberView;

public class Main {
	public static void main(String[] args) {
		

		System.out.println("printMainMenu");
		new InstructorView().printMainMenu();
		System.out.println("printInquiryAtendance");
		new InstructorView().printInquiryAtendance();
		System.out.println("printAtendancePunchIn");
		new InstructorView().printAtendancePunchIn();
		System.out.println("printAtendancePunchOut");
		new InstructorView().printAtendancePunchOut();
		System.out.println("printCheckAttendanceRecord");
		new InstructorView().printCheckAttendanceRecord();
		System.out.println("printCheckAttendanceRecordResult");
		new InstructorView().printCheckAttendanceRecordResult();
		
	}
}
