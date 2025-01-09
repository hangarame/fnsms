package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.fnsms.ticketregistration.TicketRegistration;

public class TicketRegistrationDAO {
	//파일 경로
	private final static String REGISTTICKET_DATA_PATH;
	public static ArrayList<TicketRegistration> ticketRegList;
	
	static {
		REGISTTICKET_DATA_PATH = ".\\data\\DummyRegistTicket.txt";
		ticketRegList = new ArrayList<TicketRegistration>();
	}
	
	
//	load
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
//save	
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
	
	
	
	
	public static ArrayList<TicketRegistration> 
	getTicketRegListByManager(String managerEmpNo) {
        ArrayList<TicketRegistration> regList = new ArrayList<>();
        for (TicketRegistration reg : ticketRegList) {
            if (reg.getManager().equals(managerEmpNo)) {
                regList.add(reg);
            }
        }
        return regList;
    }
    public static boolean isOverlappingMonth(TicketRegistration reg, String yyyyMM) {
        if (yyyyMM.length() != 6) return false;
        
        int y = Integer.parseInt(yyyyMM.substring(0,4));
        int m = Integer.parseInt(yyyyMM.substring(4,6));
        
        // monthStart = yyyy-MM-01 00:00:00
        Calendar monthStart = Calendar.getInstance();
        monthStart.set(y, m - 1, 1, 0, 0, 0);

        // monthEnd = yyyy-MM-(말일) 23:59:59
        Calendar monthEnd = (Calendar) monthStart.clone();
        monthEnd.add(Calendar.MONTH, 1);   // 다음달 1일
        monthEnd.add(Calendar.DATE, -1);   // 전날 => 이달 마지막 날

        Calendar start = reg.getStartDate();
        Calendar end = reg.getEndDate();

        // 구간이 아예 안 겹치면 false
        // ( monthEnd < start ) or ( monthStart > end ) 
        if (monthEnd.getTimeInMillis() < start.getTimeInMillis()) {
            return false;
        }
        if (monthStart.getTimeInMillis() > end.getTimeInMillis()) {
            return false;
        }
        return true;
    }

    public static int getMonthlyClassCount(String managerEmpNo, String yyyyMM) {
        int count = 0;
        // 1) managerEmpNo인 등록 건
        ArrayList<TicketRegistration> list = getTicketRegListByManager(managerEmpNo);
        // 2) startDate~endDate 중 yyyyMM과 겹치면 count++
        for (TicketRegistration tr : list) {
            if (isOverlappingMonth(tr, yyyyMM)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isOverlappingMonth(Calendar start, Calendar end, String yyyyMM) {
        if (yyyyMM.length() != 6) return false;
        
        int y = Integer.parseInt(yyyyMM.substring(0,4));
        int m = Integer.parseInt(yyyyMM.substring(4,6));
        
        // monthStart = yyyy-MM-01 00:00:00
        Calendar monthStart = Calendar.getInstance();
        monthStart.set(y, m - 1, 1, 0, 0, 0);

        // monthEnd = yyyy-MM-(말일) 23:59:59
        Calendar monthEnd = (Calendar) monthStart.clone();
        monthEnd.add(Calendar.MONTH, 1);   
        monthEnd.add(Calendar.DATE, -1);  

        // 구간 비교
        if (monthEnd.getTimeInMillis() < start.getTimeInMillis()) {
            return false;
        }
        if (monthStart.getTimeInMillis() > end.getTimeInMillis()) {
            return false;
        }
        return true;
    }
	
	
}//class
