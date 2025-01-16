package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.fnsms.administrator.Administrator;
import com.fnsms.instructor.Instructor;
/**
 * 근퇴 정보를 담고 있는 파일에서 데이터를 읽어오거나 쓰는 기능을 담은 클래스입니다.
 * @author 1조
 */
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
	
	/**
	 * 지정된 데이터 파일에서 근퇴정보를 읽어와 객체를 생성합니다.
	 */
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
	/**
	 * 생성된 객체 리스트를 파일에 기록합니다.
	 */
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
	/**
	 * 사원번호가 empNo인 강사를 얻습니다.
	 * @param empNo 사원번호
	 * @return 사원번호가 empNo인 강사
	 */
	public static ArrayList<Instructor> getInstructorList(String empNo){
		ArrayList<Instructor> insList = new ArrayList<Instructor>();
		
		for(Instructor ins : instructorList) {
			if(ins.getEmpNo().equals(empNo)) {
				insList.add(ins);
			}
		}
			
		return insList;
	}
	/**
	 * 사원번호를 통해 사원객체를 얻습니다.
	 * @param empNo 사원번호
	 * @return 사원객체
	 */
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
	
	public static Instructor getInstructor(String empNo){
		for(Instructor ins : instructorList) {
			if(ins.getEmpNo().equals(empNo)) {
				return ins;
			}
		}
			
		return null;
	}
	
		
}//class

