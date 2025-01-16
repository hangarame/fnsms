package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;

import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;

/**
 * 이용권의 정보를 관리하는 클래스 입니다.
 * @author 1조
 */
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
				
				//1◈헬스1개월◈30◈197001010000◈999912312359◈0◈150000
				
				String[] temp = line.split("◈");
				
				
//				System.out.println(Integer.parseInt(temp[3].substring(0, 4)));
//				System.out.println(Integer.parseInt(temp[3].substring(4, 6)) - 1);
//				System.out.println(Integer.parseInt(temp[3].substring(6,8)));
//				
//				System.out.println(Integer.parseInt(temp[4].substring(0, 4)));
//				System.out.println(Integer.parseInt(temp[4].substring(4, 6)) - 1);
//				System.out.println(Integer.parseInt(temp[4].substring(6,8)));
//				

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
				
				String regYyyy = ticket.getRegDate().get(Calendar.YEAR) +"";
				String regMm = String.format("%02d", (ticket.getRegDate().get(Calendar.MONTH) + 1)) ;
				String regDd = String.format("%02d", ticket.getRegDate().get(Calendar.DATE));
				String regHh = String.format("%02d", ticket.getRegDate().get(Calendar.HOUR_OF_DAY));
				String regMi = String.format("%02d", ticket.getRegDate().get(Calendar.MINUTE));
				String regSs = String.format("%02d", ticket.getRegDate().get(Calendar.SECOND));  
				
				String endYyyy = ticket.getSellEndDate().get(Calendar.YEAR) +"";
				String endMm = String.format("%02d", (ticket.getSellEndDate().get(Calendar.MONTH) + 1));
				String endDd = String.format("%02d", ticket.getSellEndDate().get(Calendar.DATE));
				String endHh = String.format("%02d", ticket.getSellEndDate().get(Calendar.HOUR_OF_DAY));
				String endMi = String.format("%02d", ticket.getSellEndDate().get(Calendar.MINUTE));
				String endSs = String.format("%02d", ticket.getSellEndDate().get(Calendar.SECOND));
				
				String line = ticket.getTicketNo() + "◈" + ticket.getTicketClassify() + "◈" + ticket.getTicketUseDays() + "◈" + regYyyy + regMm + regDd + regHh + regMi + regSs + "◈" + endYyyy + endMm + endDd + endHh + endMi + endSs + "◈" + ticket.getClassTimes() + "◈" + ticket.getPrice() + "\r\n";

				
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
		
		//등록일 기준 역순 정렬
		tList.sort(new Comparator<Ticket>() {
			@Override
			public int compare(Ticket o1, Ticket o2) {
				long basDt = o1.getRegDate().getTimeInMillis();
				long compareDt = o2.getRegDate().getTimeInMillis();
				
				return (int)(compareDt - basDt);
			}
		});
		
		return tList;
	}
}
