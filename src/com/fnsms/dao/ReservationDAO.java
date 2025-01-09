package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.fnsms.reservation.Reservation;
import com.fnsms.ticketregistration.TicketRegistration;

public class ReservationDAO {
	//파일 경로
	private final static String RESERVATION_DATA_PATH;
	public static ArrayList<Reservation> reservationList;
	
	static {
		RESERVATION_DATA_PATH = ".\\data\\DummySchedule.txt";
		reservationList = new ArrayList<Reservation>();
		
	}
	
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_DATA_PATH));
			
			String line = null; 

			while((line = reader.readLine()) != null) {
				String[] temp = line.split("◈");
				
				Calendar reservDt = Calendar.getInstance();
				reservDt.set(Integer.parseInt(temp[1].substring(0, 4)), Integer.parseInt(temp[1].substring(5, 7)) - 1, Integer.parseInt(temp[1].substring(8,10)));
				reservDt.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[1].substring(11, 13)));
				reservDt.set(Calendar.MINUTE, Integer.parseInt(temp[1].substring(14, 16)));
				reservDt.set(Calendar.SECOND, Integer.parseInt(temp[1].substring(17)));

				
				reservationList.add(new Reservation(Integer.parseInt(temp[0]), reservDt, temp[2]));
				
							}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//testCode
//		for(Instructor ins : instructorList) {
//			System.out.println(ins.toString());
//		}
			
		

		
	}
	
	public static void save() {
		
		try {
			FileWriter writer = new FileWriter(RESERVATION_DATA_PATH);
			
			//test.code
//			FileWriter writer = new FileWriter(".\\data\\testsave.txt");
			
			for(Reservation reserv : reservationList ) {
								
				String line = reserv.getTicketRegNo() + "◈" +String.format("%tF %tT", reserv.getReservDate(), reserv.getReservDate())  + "◈" + reserv.getClassDiary() + "\r\n";
				
				
				writer.write(line);
				
			}

			writer.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	//티켓등록번호(TicketRegistration.ticketRegNo) 파라미터 조회
	public static ArrayList<Reservation> getReservationList(int ticketRegNo){
		ArrayList<Reservation> reservList = new ArrayList<Reservation>();
		
		for(Reservation reserv : reservationList) {
			if(reserv.getTicketRegNo() == ticketRegNo) {
				reservList.add(reserv);
			}
		}
			
		return reservList;
	}
	
	//날짜 파라미터(YYYYMMDD) 파라미터 조회
	public static ArrayList<Reservation> getReservationList(String yyyymmdd){
		ArrayList<Reservation> reservList = new ArrayList<Reservation>();
		
		int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
		int mm = Integer.parseInt(yyyymmdd.substring(4, 6));
		int dd = Integer.parseInt(yyyymmdd.substring(6));

		for(Reservation reserv : reservationList) {

			if(reserv.getReservDate().get(Calendar.YEAR) == yyyy
					&& reserv.getReservDate().get(Calendar.MONTH) + 1 == mm
					&& reserv.getReservDate().get(Calendar.DATE) == dd) {
				reservList.add(reserv);
			}
		}
			
		return reservList;
	}
	
	
	
	//사원번호 파라미터 조회
	public static ArrayList<Reservation> getReservationListByEmpNo(String empNo) {
		ArrayList<Reservation> reservList = new ArrayList<Reservation>();
		ArrayList<TicketRegistration> regList = TicketRegistrationDAO.getTicketRegListByManager(empNo);
		ArrayList<Reservation> resultList = new ArrayList<Reservation>();
		
		for(TicketRegistration reg : regList) {
			for(Reservation reserv : reservationList) {
				if(reg.getTicketRegNo() == reserv.getTicketRegNo()) {
					resultList.add(reserv);
				}
			}
			
		}
		return resultList;
	}
}
