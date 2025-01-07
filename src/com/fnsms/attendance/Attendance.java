package com.fnsms.attendance;

import java.util.Calendar;

public class Attendance {
	private int empNo;
	private String workDate;
	private Calendar startWorkTime;
	private Calendar endWorkTime;
	private int payment;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
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
		builder.append("Attendance [empNo=");
		builder.append(empNo);
		builder.append(", workDate=");
		builder.append(workDate);
		builder.append(", startWorkTime=");
		builder.append(startWorkTime);
		builder.append(", endWorkTime=");
		builder.append(endWorkTime);
		builder.append(", payment=");
		builder.append(payment);
		builder.append("]");
		return builder.toString();
	}

	public Attendance(int empNo, String workDate, Calendar startWorkTime, Calendar endWorkTime, int payment) {
		super();
		this.empNo = empNo;
		this.workDate = workDate;
		this.startWorkTime = startWorkTime;
		this.endWorkTime = endWorkTime;
		this.payment = payment;
	}
}
