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
				
				try {
					startTime.set(Integer.parseInt(temp[2].substring(0, 4)), Integer.parseInt(temp[2].substring(4, 6)) - 1, Integer.parseInt(temp[2].substring(6,8)));
					startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[2].substring(8, 10)));
					startTime.set(Calendar.MINUTE, Integer.parseInt(temp[2].substring(10, 12)));
					startTime.set(Calendar.SECOND, Integer.parseInt(temp[2].substring(12)));
				} catch (Exception e) {
					startTime = null;
				}
				Calendar endTime = Calendar.getInstance();
				
				try {
					endTime.set(Integer.parseInt(temp[3].substring(0, 4)), Integer.parseInt(temp[3].substring(4, 6)) - 1, Integer.parseInt(temp[3].substring(6,8)));
					endTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[3].substring(8, 10)));
					endTime.set(Calendar.MINUTE, Integer.parseInt(temp[3].substring(10, 12)));
					endTime.set(Calendar.SECOND, Integer.parseInt(temp[3].substring(12)));
				} catch (Exception e) {
					endTime = null;
				}
				
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
				String startYyyy;
				String startMm;
				String startDd;
				String startHh;
				String startMi;
				String startSs;
				String startYYYYMMDDHHMISS;
				
				try {
					startYyyy = att.getStartWorkTime().get(Calendar.YEAR) +"";
					startMm = String.format("%02d", (att.getStartWorkTime().get(Calendar.MONTH) + 1)) ;
					startDd = String.format("%02d", att.getStartWorkTime().get(Calendar.DATE));
					startHh = String.format("%02d", att.getStartWorkTime().get(Calendar.HOUR_OF_DAY));
					startMi = String.format("%02d", att.getStartWorkTime().get(Calendar.MINUTE));
					startSs = String.format("%02d", att.getStartWorkTime().get(Calendar.SECOND));
					
					startYYYYMMDDHHMISS = startYyyy + startMm + startDd + startHh + startMi + startSs;
					
				} catch (Exception e) {
					startYYYYMMDDHHMISS = "";
				}
				
				String endYyyy;
				String endMm;
				String endDd;
				String endHh;
				String endMi;
				String endSs;
				String endYYYYMMDDHHMISS;
				
				try {
					endYyyy = att.getEndWorkTime().get(Calendar.YEAR) +"";
					endMm = String.format("%02d", (att.getEndWorkTime().get(Calendar.MONTH) + 1));
					endDd = String.format("%02d", att.getEndWorkTime().get(Calendar.DATE));
					endHh = String.format("%02d", att.getEndWorkTime().get(Calendar.HOUR_OF_DAY));
					endMi = String.format("%02d", att.getEndWorkTime().get(Calendar.MINUTE));
					endSs = String.format("%02d", att.getEndWorkTime().get(Calendar.SECOND));
					
					endYYYYMMDDHHMISS = endYyyy + endMm + endDd + endHh + endMi + endSs;
					
				} catch (Exception e) {
					endYYYYMMDDHHMISS = "";
				}
								
				String line = att.getEmpNo() + "◈" + att.getWorkDate() + "◈" + startYYYYMMDDHHMISS + "◈" + endYYYYMMDDHHMISS + "◈" + att.getPayment() + "\r\n" ;
				

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
