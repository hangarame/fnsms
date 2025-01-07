package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.fnsms.administrator.Administrator;
import com.fnsms.attendance.Attendance;
import com.fnsms.instructor.Instructor;
import com.fnsms.member.Member;
import com.fnsms.ticketregistration.TicketRegistration;

public class TicketRegistrationDAO {
	//파일 경로
	private final static String REGISTTICKET_DATA_PATH;
	public static ArrayList<TicketRegistration> ticketRegList;
	
	static {
		REGISTTICKET_DATA_PATH = ".\\data\\DummyRegistTicket.txt";
		ticketRegList = new ArrayList<TicketRegistration>();
	}
	
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(REGISTTICKET_DATA_PATH));
			
			String line = null; 

			while((line = reader.readLine()) != null) {
				String[] temp = line.split("◈");
				Calendar basDt = Calendar.getInstance();
				basDt.set(Integer.parseInt(temp[3].substring(0, 4)), Integer.parseInt(temp[3].substring(5, 7)) - 1, Integer.parseInt(temp[3].substring(8)));
				
				Calendar startDt = Calendar.getInstance();
				startDt.set(Integer.parseInt(temp[5].substring(0, 4)), Integer.parseInt(temp[5].substring(5, 7)) - 1, Integer.parseInt(temp[5].substring(8)));
				
				Calendar endDt = Calendar.getInstance();
				endDt.set(Integer.parseInt(temp[6].substring(0, 4)), Integer.parseInt(temp[6].substring(5, 7)) - 1, Integer.parseInt(temp[6].substring(8)));
				
				ticketRegList.add(new TicketRegistration(Integer.parseInt(temp[0]), temp[1], temp[2], basDt, temp[4], startDt, endDt,Integer.parseInt(temp[7])));
				
				
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
			FileWriter writer = new FileWriter(REGISTTICKET_DATA_PATH);
			//test.code
//			FileWriter writer = new FileWriter(".\\data\\testsave.txt");
			
			//1◈m0000000001◈헬스6개월◈2024-09-02◈i000000002◈2024-09-05◈2024-10-05◈330000
			for(TicketRegistration tr : ticketRegList ) {
				String line = tr.getTicketRegNo() + "◈" + tr.getMember() + "◈" + tr.getTicket() + "◈" + String.format("%tF", tr.getPurchaseDate()) + "◈" + tr.getManager()  + "◈" + String.format("%tF", tr.getStartDate()) + "◈" + String.format("%tF", tr.getEndDate()) + "◈" + tr.getPurchasePrice() + "\r\n";
				writer.write(line);
				
			}
			
			
			writer.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	//회원번호 파라미터 조회 > TicketRegistration
	public static ArrayList<TicketRegistration> getTicketRegList(String memberNo){
		ArrayList<TicketRegistration> regList = new ArrayList<TicketRegistration>();
		
		for(TicketRegistration reg : ticketRegList) {
			if(reg.getMember().equals(memberNo)) {
				regList.add(reg);
			}
		}
			
		return regList;
	}
	
}
