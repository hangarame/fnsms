package com.fnsms.attendance;

import java.util.Calendar;
/**
 * 근퇴 VO 클래스입니다.
 * @author 1조
 */
public class Attendance {
	private String empNo;
	private String workDate;
	private Calendar startWorkTime;
	private Calendar endWorkTime;
	private int payment;
	
	
	/**
	 * 근퇴에 대한 정보를 파라미터로 받는 생성자입니다.
	 * @param empNo 사원번호
	 * @param workDate 근무일자
	 * @param startWorkTime 출근시간
	 * @param endWorkTime 퇴근시간
	 * @param payment 정산금
	 */
	public Attendance(String empNo, String workDate, Calendar startWorkTime, Calendar endWorkTime, int payment) {
		super();
		this.empNo = empNo;
		this.workDate = workDate;
		this.startWorkTime = startWorkTime;
		this.endWorkTime = endWorkTime;
		this.payment = payment;
	}


	/**
	 * 사원번호를 얻습니다.
	 * @return 사원번호
	 */
	public String getEmpNo() {
		return empNo;
	}
	/**
	 * 사원번호를 수정합니다.
	 * @param empNo 사원번호
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	/**
	 * 근무일자를 얻습니다.
	 * @return 근무일자
	 */
	public String getWorkDate() {
		return workDate;
	}
	/**
	 * 근무일자를 수정합니다.
	 * @param workDate 근무일자
	 */
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}


	/**
	 * 출근시간을 얻습니다.
	 * @return 출근시간
	 */
	public Calendar getStartWorkTime() {
		return startWorkTime;
	}
	/**
	 * 출근시간을 수정합니다.
	 * @param startWorkTime 출근시간
	 */
	public void setStartWorkTime(Calendar startWorkTime) {
		this.startWorkTime = startWorkTime;
	}


	/**
	 * 퇴근시간을 얻습니다.
	 * @return 퇴근시간
	 */
	public Calendar getEndWorkTime() {
		return endWorkTime;
	}
	/**
	 * 퇴근시간을 수정합니다.
	 * @param endWorkTime 퇴근시간
	 */
	public void setEndWorkTime(Calendar endWorkTime) {
		this.endWorkTime = endWorkTime;
	}


	/**
	 * 정산금을 얻습니다.
	 * @return 정산금
	 */
	public int getPayment() {
		return payment;
	}
	/**
	 * 정산금을 수정합니다.
	 * @param payment 정산금
	 */
	public void setPayment(int payment) {
		this.payment = payment;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ");
		builder.append(empNo);
		builder.append(" ");
		builder.append(workDate);
		builder.append("   ");
		builder.append(String.format("%tF %tT", startWorkTime,startWorkTime) );
		builder.append("   ");
		builder.append(String.format("%tF %tT", endWorkTime,endWorkTime));
		builder.append("   ");
		builder.append(payment);
		return builder.toString();
	}

	
	
	
}
