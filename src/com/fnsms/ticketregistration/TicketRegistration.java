package com.fnsms.ticketregistration;

import java.util.Calendar;

import com.fnsms.instructor.Instructor;
import com.fnsms.member.Member;
import com.fnsms.ticket.Ticket;

public class TicketRegistration {
	private int ticketRegNo;
	private Member member;
	private Ticket ticket;
	private Calendar purchaseDate;
	private Instructor manager;
	private Calendar startDate;
	private Calendar endDate;
	private int purchasePrice;
	
	
	
	public TicketRegistration(int ticketRegNo, Member member, Ticket ticket, Calendar purchaseDate, Instructor manager,
			Calendar startDate, Calendar endDate, int purchasePrice) {
		super();
		this.ticketRegNo = ticketRegNo;
		this.member = member;
		this.ticket = ticket;
		this.purchaseDate = purchaseDate;
		this.manager = manager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.purchasePrice = purchasePrice;
	}
	
	
	public int getTicketRegNo() {
		return ticketRegNo;
	}
	public void setTicketRegNo(int ticketRegNo) {
		this.ticketRegNo = ticketRegNo;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Calendar getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Instructor getManager() {
		return manager;
	}
	public void setManager(Instructor manager) {
		this.manager = manager;
	}
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TicketRegistration [ticketRegNo=");
		builder.append(ticketRegNo);
		builder.append(", member=");
		builder.append(member);
		builder.append(", ticket=");
		builder.append(ticket);
		builder.append(", purchaseDate=");
		builder.append(purchaseDate);
		builder.append(", manager=");
		builder.append(manager);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", purchasePrice=");
		builder.append(purchasePrice);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
