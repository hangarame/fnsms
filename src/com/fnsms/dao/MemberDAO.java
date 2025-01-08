package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.fnsms.member.Member;



public class MemberDAO {
	//파일 경로
	private final static String MEMBER_DATA_PATH;
	public static ArrayList<Member> memberList;
	
	static {
		MEMBER_DATA_PATH = ".\\data\\DummyMember.txt";
		
		memberList = new ArrayList<Member>();

	}
	
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MEMBER_DATA_PATH));
			
			String line = null; 

			while((line = reader.readLine()) != null) {
				String[] temp = line.split("◈");
				
				memberList.add(new Member(temp[2], temp[3], temp[1], temp[0]));

						
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//testCode
//		for(Member mem : memberList) {
//			System.out.println(mem.toString());
//		}
			

		
	}
	
	public static void save() {
		
		try {
			FileWriter writer = new FileWriter(MEMBER_DATA_PATH);
			//test.code
//			FileWriter writer = new FileWriter(".\\data\\testsave.txt");
			
			for(Member mem : memberList ) {
				String line = mem.getMemberNo() + "◈" + mem.getBirthDate() + "◈" + mem.getName() + "◈" + mem.getTel() + "\r\n";
				writer.write(line);
			}
			
			writer.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	public static Member getMemberList(String memberNo){
		for(Member mem : memberList) {
			if(mem.getMemberNo().equals(memberNo)) {
				return mem;
			}
		}
		return null;
	}
	
		
}
