package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.fnsms.administrator.Administrator;
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
					instructorList.add(new Instructor(temp[1], temp[2], temp[4], temp[0], temp[3], Integer.parseInt(temp[5])));
					
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
	
	public static ArrayList<Instructor> getInstructorList(String empNo){
		ArrayList<Instructor> insList = new ArrayList<Instructor>();
		
		for(Instructor ins : instructorList) {
			if(ins.getEmpNo().equals(empNo)) {
				insList.add(ins);
			}
		}
			
		return insList;
	}

	public static Object getEmpByNo(String empNo) {
        // 1) 강사 리스트에서 검색
        for (Instructor ins : instructorList) {
            if (ins.getEmpNo().equals(empNo)) {
                return ins; // 찾으면 바로 반환
            }
        }
        // 2) 관리자 리스트에서 검색
        for (Administrator adm : adminList) {
            if (adm.getEmpNo().equals(empNo)) {
                return adm; // 찾으면 바로 반환
            }
        }
        // 3) 둘 다 없으면 null
        return null;
    }
		
}//class

