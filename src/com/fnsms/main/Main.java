package com.fnsms.main;

import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.member.Member;
import com.fnsms.reservation.Reservation;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;
import com.fnsms.view.CommonView;

public class Main {
	public static void main(String[] args) {
//		CommonView.printLogin();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();

//		ReservationDAO.load();
//		for(Reservation a : ReservationDAO.getReservationList("20250107")) {
//			System.out.println(a);
//		}
		
//		TicketDAO.load();
//		TicketDAO.save();
//		
//
//		for(Ticket a : TicketDAO.getTicketList("헬스1개월")) {
//			System.out.println(a);
//		}
		
		MemberDAO.load();

		for(Member a : MemberDAO.getMemberList("m000000001")) {
			System.out.println(a);
		}
		
		TicketRegistrationDAO.load();
		
		for(TicketRegistration b : TicketRegistrationDAO.getTicketRegList("m0000000001")) {
			System.out.println(b);
		}
		

	}
}
