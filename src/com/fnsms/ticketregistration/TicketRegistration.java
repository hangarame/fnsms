package com.fnsms.ticketregistration;

import java.util.Calendar;

/**
 * 회원에게 등록된 이용권의 정보가 담긴 클래스입니다.
 * @author 1조
 */
public class TicketRegistration {
	private int ticketRegNo;
	private String member;
	private String ticket;
	private Calendar purchaseDate;
	private String manager;
	private Calendar startDate;
	private Calendar endDate;
	private int purchasePrice;
	
	public TicketRegistration(int ticketRegNo, String member, String ticket, Calendar purchaseDate, String manager,
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

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Calendar getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
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
