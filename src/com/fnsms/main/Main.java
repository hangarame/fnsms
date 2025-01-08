package com.fnsms.main;

import com.fnsms.view.InstructorMemberView;
import com.fnsms.view.InstructorView;

public class Main {
	public static void main(String[] args) {

		
		System.out.println("printMainMenu");
		InstructorView.printMainMenu();
		System.out.println("printInquiryAtendance");
		InstructorView.printInquiryAtendance();
		System.out.println("printAtendancePunchIn");
		InstructorView.printAtendancePunchIn();
		System.out.println("printAtendancePunchOut");
		InstructorView.printAtendancePunchOut();
		System.out.println("printCheckAttendanceRecord");
		InstructorView.printCheckAttendanceRecord();
		System.out.println("printCheckAttendanceRecord");
		InstructorView.printCheckAttendanceRecordResult();
		


//		InstructorMemberView.memberManagement();
//		InstructorMemberView.newMemRegistration();
//		InstructorMemberView.searchMember();
//		InstructorMemberView.searchMemberFailed();
//		InstructorMemberView.selectMemberList();
		InstructorMemberView.selectMemberListFailed();
		InstructorMemberView.selectMember();
	}


}
