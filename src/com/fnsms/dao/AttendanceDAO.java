package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.fnsms.attendance.Attendance;


public class AttendanceDAO {
	//파일 경로
	private final static String ATTENDANCE_DATA_PATH;
	public static ArrayList<Attendance> attendanceList;
	
	static {
		ATTENDANCE_DATA_PATH = ".\\data\\DummyAttendance.txt";
		attendanceList = new ArrayList<Attendance>();
		
	}
	
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ATTENDANCE_DATA_PATH));
			
			String line = null; 

			while((line = reader.readLine()) != null) {
				String[] temp = line.split("◈");
				
				
				Calendar startTime = Calendar.getInstance();
				startTime.set(Integer.parseInt(temp[2].substring(0, 4)), Integer.parseInt(temp[2].substring(4, 6)) - 1, Integer.parseInt(temp[2].substring(6,8)));
				startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[2].substring(8, 10)));
				startTime.set(Calendar.MINUTE, Integer.parseInt(temp[2].substring(10, 12)));
				startTime.set(Calendar.SECOND, Integer.parseInt(temp[2].substring(12)));
				
				Calendar endTime = Calendar.getInstance();
				endTime.set(Integer.parseInt(temp[3].substring(0, 4)), Integer.parseInt(temp[3].substring(4, 6)) - 1, Integer.parseInt(temp[3].substring(6,8)));
				endTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[3].substring(8, 10)));
				endTime.set(Calendar.MINUTE, Integer.parseInt(temp[3].substring(10, 12)));
				endTime.set(Calendar.SECOND, Integer.parseInt(temp[3].substring(12)));

				
				
				attendanceList.add(new Attendance(temp[0], temp[1], startTime, endTime,Integer.parseInt(temp[4])));

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
			FileWriter writer = new FileWriter(ATTENDANCE_DATA_PATH);
			
			//test.code
//			FileWriter writer = new FileWriter(".\\data\\testsave.txt");
			
			for(Attendance att : attendanceList ) {
				
				String startYyyy = att.getStartWorkTime().get(Calendar.YEAR) +"";
				String startMm = String.format("%02d", (att.getStartWorkTime().get(Calendar.MONTH) + 1)) ;
				String startDd = String.format("%02d", att.getStartWorkTime().get(Calendar.DATE));
				String startHh = String.format("%02d", att.getStartWorkTime().get(Calendar.HOUR_OF_DAY));
				String startMi = String.format("%02d", att.getStartWorkTime().get(Calendar.MINUTE));
				String startSs = String.format("%02d", att.getStartWorkTime().get(Calendar.SECOND));  
				
				String endYyyy = att.getEndWorkTime().get(Calendar.YEAR) +"";
				String endMm = String.format("%02d", (att.getEndWorkTime().get(Calendar.MONTH) + 1));
				String endDd = String.format("%02d", att.getEndWorkTime().get(Calendar.DATE));
				String endHh = String.format("%02d", att.getEndWorkTime().get(Calendar.HOUR_OF_DAY));
				String endMi = String.format("%02d", att.getEndWorkTime().get(Calendar.MINUTE));
				String endSs = String.format("%02d", att.getEndWorkTime().get(Calendar.SECOND));
				
				
				String line = att.getEmpNo() + "◈" + att.getWorkDate() + "◈" + startYyyy + startMm + startDd + startHh + startMi + startSs + "◈" + endYyyy + endMm + endDd + endHh + endMi + endSs + "◈" + att.getPayment() + "\r\n" ;
				

				writer.write(line);
				
			}

			writer.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	
	
	//public Attendance(int empNo, String workDate, Calendar startWorkTime, Calendar endWorkTime, int payment)
	
	
	
	//사원번호(Emp.empNo) 파라미터 조회
	public static ArrayList<Attendance> getAttendanceList(String empNo){
		ArrayList<Attendance> attList = new ArrayList<Attendance>();
		
		for(Attendance att : attendanceList) {
			if(att.getEmpNo().equals(empNo)) {
				attList.add(att);
			}
		}
			
		return attList;
	}
	
	//파라미터(YYYYMMDD) == workdate 파라미터 조회
	public static ArrayList<Attendance> getAttendanceByDateList(String yyyymmdd){
		ArrayList<Attendance> attList = new ArrayList<Attendance>();
	
		for(Attendance att : attendanceList) {
			if(att.getWorkDate().equals(yyyymmdd)) {
				attList.add(att);
			}
		}
			
		return attList;
	}
	
	
	
}
