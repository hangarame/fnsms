package com.fnsms.member;

import java.util.List;
import com.fnsms.ticket.Ticket;
import com.fnsms.user.User;

public class Member extends User{
	
	private String memberNo;
	private List<Ticket> ownTicket;
	
	public Member() {
		this( null, null, null, null, null );
	}
	
	public Member(String name, String tel, String birthDate, String memberNo, List<Ticket> ownTicket) {
		
		super(name, tel, birthDate);
		this.memberNo =memberNo;
		this.ownTicket = ownTicket;
		
	}

	public String getMemberNo() {
		return memberNo;
	}

	public List<Ticket> getOwnTicket() {
		return ownTicket;
	}
	
	public String getName() {
		return super.getName();
	}

	public String getTel() {
		return super.getTel();
	}
    
	public String getBirthDate() {
		return super.getBirthDate();
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public void setOwnTicket(List<Ticket> ownTicket) {
		this.ownTicket = ownTicket;
	}

	public void setName(String name) {
		super.setName(name);
	}
	
	public void setTel(String tel) {
		super.setTel(tel);
	}
	
	public void setBirthDate(String birthDate) {
		super.setBirthDate(birthDate);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", name=");
		builder.append(getName());
		builder.append(", tel=");
		builder.append(getTel());
		builder.append(", birthDate=");
		builder.append(getBirthDate());
		builder.append("Member [memberNo=");
		builder.append(memberNo);
		builder.append(", ownTicket=");
		builder.append(ownTicket);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<Ticket> getOwnTicket() {
		
		return null;
	}
	
}
