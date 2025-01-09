package com.fnsms.reservation;

import java.util.Calendar;

public class Reservation {

	int ticketRegNo;
	Calendar reservDate;
	String classDiary;
	
	
	
	public Reservation(int ticketRegNo, Calendar reservDate, String classDiary) {
		super();
		this.ticketRegNo = ticketRegNo; //등록된 티켓 번호
		this.reservDate = reservDate;	//예약일
		this.classDiary = classDiary;	//수업일지
	}

	public int getTicketRegNo() {
		return ticketRegNo;
	}

	public void setTicketRegNo(int ticketRegNo) {
		this.ticketRegNo = ticketRegNo;
	}

	public Calendar getReservDate() {
		return reservDate;
	}

	public void setReservDate(Calendar reservDate) {
		this.reservDate = reservDate;
	}

	public String getClassDiary() {
		return classDiary;
	}

	public void setClassDiary(String classDiary) {
		this.classDiary = classDiary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [ticketRegNo=");
		builder.append(ticketRegNo);
		builder.append(", reservDate=");
		builder.append(reservDate);
		builder.append(", classDiary=");
		builder.append(classDiary);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
