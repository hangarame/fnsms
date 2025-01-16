package com.fnsms.instructor;

import java.util.ArrayList;

import com.fnsms.attendance.Attendance;
import com.fnsms.emp.Emp;


/**
 * 강사 VO 클래스입니다.
 * @author 1조
 */
public class Instructor extends Emp {
	
	private int iningCost;
	/**
	 * 강사의 정보를 파라미터로 받는 생성자입니다.
	 * @param name 이름
	 * @param tel 연락처
	 * @param birthDate 생년월일
	 * @param empNo 사원번호
	 * @param role 직책
	 * @param iningCost 회단가
	 */
	public Instructor(String name, String tel, String birthDate, String empNo, String role, int iningCost) {
		super(name, tel, birthDate, empNo, role);
		this.iningCost = iningCost;
	}
	/**
	 * 회단가를 얻습니다.
	 * @return 회단가
	 */
	public int getIningCost() {
		return iningCost;
	}
	/**
	 * 회단가를 수정합니다.
	 * @param iningCost 회단가
	 */
	public void setIningCost(int iningCost) {
		this.iningCost = iningCost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instructor [iningCost=");
		builder.append(iningCost);
		builder.append(", empNo=");
		builder.append(empNo);
		builder.append(", role=");
		builder.append(role);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append("]");
		return builder.toString();
	}
	
}
