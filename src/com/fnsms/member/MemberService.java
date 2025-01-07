package com.fnsms.member;

import java.util.ArrayList;

import com.fnsms.reservation.Reservation;
import com.fnsms.user.UserService;

public class MemberService extends UserService {

	// 예약 조회
	public ArrayList<Reservation> inquiryReservInfo() {
		return null;
	}

	public boolean haveUseTowelTicket() {
		return false;
	}

	public int getNearExpiredate() {
		return 0;
	}

	// 휴회신청
	public void requestRecess() {

	}

}
