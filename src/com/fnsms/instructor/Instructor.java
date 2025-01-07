package com.fnsms.instructor;

import java.util.ArrayList;

import com.fnsms.attendance.Attendance;
import com.fnsms.emp.Emp;



public class Instructor extends Emp {
	
	private ArrayList<Attendance> Attendance;

	public Instructor(String empNo, String role, ArrayList<Attendance> attendance) {
		super(empNo, role);
		Attendance = attendance;
	}

	public ArrayList<Attendance> getAttendance() {
		return Attendance;
	}

	public void setAttendance(ArrayList<Attendance> attendance) {
		Attendance = attendance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instructor [Attendance=");
		builder.append(Attendance);
		builder.append("]");
		return builder.toString();
	}
	
	

}
