package com.fnsms.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.fnsms.member.Member;
import com.fnsms.ticket.Ticket;
import com.test.school.domain.Score;
import com.test.school.student.Student;

public class MemberDAO {

	private final static String DummyMember;
	private final static String DummyTicket;

	public static ArrayList<Member> memberList;
	public static ArrayList<Ticket> ticketList;
	
	
	static {
		DummyMember = ".\\data\\Dummymember.txt";
		DummyTicket = ".\\data\\Dummyticket.txt";
		memberList = new ArrayList<Member>();
		ticketList = new ArrayList<Ticket>();
	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DummyMember));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				//m000000001◈20090122◈배예하◈010-3343-7519
				String[] temp = line.split("◈");
				
				Member member = new Member( temp[0], temp[1], temp[2], temp[3], null );
				member.setOwnTicket(new ArrayList<Ticket>());
				
				memberList.add(member);
				
			}//while
			
			reader.close();

			
			ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
			reader = new BufferedReader(new FileReader(DummyTicket));
			
			line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp  = line.split("◈");
				
				//1◈헬스1개월◈30◈197001010000◈999912312359◈0◈150000
				Ticket ticket = new Ticket( temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6] );
				
				ticketList.add(ticket);
			}
			
			reader.close();
			
			for (member mb : memberList) {
			
				int memberNo = mb.getmemberNo();
				
				for (Ticket tc : ticketList) {
					if (tc.getticketNo() == memberNo) {
						mb.getownTicket().add(tc); //학생의 성적을 학생에게 추가
					}
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void save() {
		
	}
}
