package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.fnsms.ticket.Ticket;

public class TicketDAO {
	//파일 경로
	private final static String TICKET_DATA_PATH;
	public static ArrayList<Ticket> ticketList;
	
	static {
		TICKET_DATA_PATH = ".\\data\\DummyTicket.txt";
		ticketList = new ArrayList<Ticket>();
		
	}
	
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(TICKET_DATA_PATH));
			
			String line = null; 

			while((line = reader.readLine()) != null) {
				String[] temp = line.split("◈");
				
				Calendar regDt = Calendar.getInstance();
				regDt.set(Integer.parseInt(temp[3].substring(0, 4)), Integer.parseInt(temp[3].substring(4, 6)) - 1, Integer.parseInt(temp[3].substring(6,8)));
				regDt.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[3].substring(8, 10)));
				regDt.set(Calendar.MINUTE, Integer.parseInt(temp[3].substring(10, 12)));
				regDt.set(Calendar.SECOND, Integer.parseInt(temp[3].substring(12)));

				Calendar endDt = Calendar.getInstance();
				endDt.set(Integer.parseInt(temp[4].substring(0, 4)), Integer.parseInt(temp[4].substring(4, 6)) - 1, Integer.parseInt(temp[4].substring(6,8)));
				endDt.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[4].substring(8, 10)));
				endDt.set(Calendar.MINUTE, Integer.parseInt(temp[4].substring(10, 12)));
				endDt.set(Calendar.SECOND, Integer.parseInt(temp[4].substring(12)));
				

				ticketList.add(new Ticket(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), regDt, endDt, Integer.parseInt(temp[5]), Integer.parseInt(temp[6])));

				
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
			FileWriter writer = new FileWriter(TICKET_DATA_PATH);
			//test.code
//			FileWriter writer = new FileWriter(".\\data\\testsave.txt");
			
			for(Ticket ticket : ticketList ) {

				String line = ticket.getTicketNo() + "◈" + ticket.getTicketClassify() + "◈" + ticket.getTicketUseDays() + "◈" + ticket.getRegDate() + "◈" + ticket.getSellEndDate() + "◈" + ticket.getPrice() + "\r\n";

				
				
				writer.write(line);
				
			}

			writer.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	//티켓번호 파라미터 조회
	public static ArrayList<Ticket> getTicketList(int ticketNo){
		ArrayList<Ticket> tList = new ArrayList<Ticket>();
		
		for(Ticket t : ticketList) {
			if(t.getTicketNo() == ticketNo) {
				tList.add(t);
			}
		}
			
		return tList;
	}
	
	//티켓구분 파라미터 조회
	public static ArrayList<Ticket> getTicketList(String ticketClassify){
		ArrayList<Ticket> tList = new ArrayList<Ticket>();
		
		for(Ticket t : ticketList) {
			if(t.getTicketClassify().equals(ticketClassify)) {
				tList.add(t);
			}
		}
			
		return tList;
	}
}
