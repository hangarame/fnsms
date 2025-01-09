package com.fnsms.emp;

import java.util.ArrayList;
import java.util.Calendar;

import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.member.Member;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;

public class EmpService {

	// 회원등록
	public Member addMember() {
		return null;
	}

	// 회원정보수정
	public Member editMemberInfo() {
		return null;
	}

	// 회원정보삭제
	public Member deleteMemberInfo() {
		return null;
	}

	// 회원정보조회
	public ArrayList<Member> inquriyMemberInfo() {
		return null;
	}

	// 이용권정보조회
	public ArrayList<TicketRegistration> inquriyOwnTicketInfo() {
		return null;
	}

	// 회원이용권등록
	public TicketRegistration addRegTicket(int ticketNo, Calendar startDate, Emp emp, Member member) {
	    // 1. 공통 티켓 번호를 인덱스로 활용하여 조회 (1번부터 시작하므로 -1 처리)
	    if (ticketNo < 1 || ticketNo > TicketDAO.ticketList.size()) {
	        System.out.println("선택한 이용권 번호가 존재하지 않습니다.");
	        return null;
	    }

	    Ticket selectedTicket = TicketDAO.ticketList.get(ticketNo - 1);

	    // 2. 현재 날짜를 등록일로 설정
	    Calendar purchaseDate = Calendar.getInstance();

	    // 3. 만료일 계산 (시작일 + 이용권 기간)
	    Calendar endDate = (Calendar) startDate.clone();
	    endDate.add(Calendar.DAY_OF_YEAR, selectedTicket.getTicketUseDays());

	    // 4. 새로운 TicketRegistration 객체 생성
	    int newTicketRegNo = TicketRegistrationDAO.ticketRegList.size() + 1;
	    TicketRegistration newReg = new TicketRegistration(
	        newTicketRegNo,
	        member.getMemberNo(),  
	        selectedTicket.getTicketClassify(),
	        purchaseDate,
	        emp.getEmpNo(),
	        startDate,
	        endDate,
	        selectedTicket.getPrice()
	    );

	    // 5. 생성한 객체를 리스트에 추가
	    TicketRegistrationDAO.ticketRegList.add(newReg);

	    // 6. 해당 회원의 ticketRegList에 새 이용권 추가
	    member.addTicketRegistration(newReg);

	    return newReg;
	}

	    // 5. 생성한 객체를 리스트에 추가
	    TicketRegistrationDAO.ticketRegList.add(newReg);

	    return newReg;
	}

	
	// 회원이용권정보수정
	public TicketRegistration updateRegTicket() {
		return null;
	}

	// 회원이용권정보삭제
	public TicketRegistration deleteRegTicket() {
		return null;
	}

}
