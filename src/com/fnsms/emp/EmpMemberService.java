package com.fnsms.emp;

import java.util.ArrayList;

import com.fnsms.administrator.Administrator;
import com.fnsms.attendance.Attendance;
import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.instructor.Instructor;
import com.fnsms.member.Member;
import com.fnsms.reservation.Reservation;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;

public class EmpMemberService {
	// 회원클래스
	ArrayList<Member> memberList = MemberDAO.memberList;// 배예하◈010-3343-7519◈20090122◈m00000001
	ArrayList<Instructor> instructorList = EmpDAO.instructorList;// a00000001◈한가람◈010-0000-0001◈대표◈19940101◈0
	ArrayList<Administrator> adminList = EmpDAO.adminList;
	ArrayList<Ticket> ticketList = TicketDAO.ticketList;
	ArrayList<TicketRegistration> ticketRegList = TicketRegistrationDAO.ticketRegList;
	ArrayList<Reservation> reservationList = ReservationDAO.reservationList;
	ArrayList<Attendance> attendanceList = AttendanceDAO.attendanceList;

	public static void viewByMember() {
		// TODO Auto-generated method stub

	}

	// 강사 ID로 회원 검색
	public ArrayList<Member> getMembersByInstructor(String instructorId) {
		ArrayList<Member> result = new ArrayList<>();
		for (TicketRegistration ticketRegList : EmpMemberService.ticketRegList) {
			if (memberTicket.getInstructorId().equals(instructorId)) {
				for (Member member : DataStorage.members) {
					if (member.getMemberId().equals(memberTicket.getMemberId())) {
						result.add(member);
					}
				}
			}
		}
		return result;
	}

}
