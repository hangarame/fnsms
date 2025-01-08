package com.fnsms.attendance;

import java.util.Calendar;

public class Attendance {
	private String empNo;
	private String workDate;
	private Calendar startWorkTime;
	private Calendar endWorkTime;
	private int payment;
	
	
	
	public Attendance(String empNo, String workDate, Calendar startWorkTime, Calendar endWorkTime, int payment) {
		super();
		this.empNo = empNo;
		this.workDate = workDate;
		this.startWorkTime = startWorkTime;
		this.endWorkTime = endWorkTime;
		this.payment = payment;
	}



	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}



	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}



	public Calendar getStartWorkTime() {
		return startWorkTime;
	}
	public void setStartWorkTime(Calendar startWorkTime) {
		this.startWorkTime = startWorkTime;
	}



	public Calendar getEndWorkTime() {
		return endWorkTime;
	}
	public void setEndWorkTime(Calendar endWorkTime) {
		this.endWorkTime = endWorkTime;
	}



	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ");
		builder.append(empNo);
		builder.append(" ");
		builder.append(workDate);
		builder.append("   ");
		builder.append(String.format("%tF %tT", startWorkTime,startWorkTime) );
		builder.append("   ");
		builder.append(String.format("%tF %tT", endWorkTime,endWorkTime));
		builder.append("   ");
		builder.append(payment);
		return builder.toString();
	}

	
	
	
}
