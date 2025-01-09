package com.fnsms.member;

import com.fnsms.ticketregistration.TicketRegistration;
import com.fnsms.user.User;

public class Member extends User{
	
	
	public String memberNo;



	//	생성자
	public Member(String name, String tel, String birthDate, String memberNo) {
		super(name, tel, birthDate);
		this.memberNo = memberNo;
	}

	
//	GetterSetter
	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberNo=");
		builder.append(memberNo);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append("]");
		return builder.toString();
	}


	public void addTicketRegistration(TicketRegistration newReg) {
		
	}
	
	
}
