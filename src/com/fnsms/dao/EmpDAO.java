package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.fnsms.administrator.Administrator;
import com.fnsms.attendance.Attendance;
import com.fnsms.instructor.Instructor;

public class EmpDAO {
	//파일 경로
	private final static String EMP_DATA_PATH;
	public static ArrayList<Instructor> instructorList;
	public static ArrayList<Administrator> adminList;
	
	static {
		EMP_DATA_PATH = ".\\data\\DummyEmp.txt";
		
		instructorList = new ArrayList<Instructor>();
		adminList = new ArrayList<Administrator>();
	}
	
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(EMP_DATA_PATH));
			
			String line = null; 

			while((line = reader.readLine()) != null) {
				String[] temp = line.split("◈");

				if(temp[3].equals("강사") ) {

					instructorList.add(new Instructor(temp[1], temp[2], temp[4], temp[0], temp[3], Integer.parseInt(temp[5]), null));
					ArrayList<Attendance> aList = new ArrayList<Attendance>();
					
				} else {
					adminList.add(new Administrator(temp[1], temp[2], temp[4], temp[0], temp[3]));
					
					
				}
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//testCode
//		for(Instructor ins : instructorList) {
//			System.out.println(ins.toString());
//		}
			
		
		
		
		//Attendance 배열 담는 과정 완성 필요.
		//AttendanceDAO 작성하고 main에서 AttendanceDAO.load() 먼저
		
	}
	
	public static void save() {
		
		try {
			FileWriter writer = new FileWriter(EMP_DATA_PATH);
			//test.code
//			FileWriter writer = new FileWriter(".\\data\\testsave.txt");
			
			for(Instructor ins : instructorList ) {
				String line = ins.getEmpNo() + "◈" + ins.getName() + "◈" + ins.getTel() + "◈" + ins.getRole() + "◈" + ins.getIningCost() + "\r\n";
				
				writer.write(line);
				
			}
			
			for(Administrator adm : adminList ) {
				String line = adm.getEmpNo() + "◈" + adm.getName() + "◈" + adm.getTel() + "◈" + adm.getRole() + "◈" + "0\r\n";
				writer.write(line);
			}
			
			writer.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
		
}
