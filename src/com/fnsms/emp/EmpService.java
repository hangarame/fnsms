package com.fnsms.emp;

import java.util.ArrayList;
import java.util.Scanner;

import com.fnsms.dao.MemberDAO;
import com.fnsms.member.Member;
import com.fnsms.ticketregistration.TicketRegistration;

public class EmpService {

	// 회원등록
	public static void addMember() {
		Scanner scan = new Scanner(System.in);

//		입력 안내 메시지 출력
//		>
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("생년월일: ");
		String birthDate = scan.nextLine();
		System.out.print("연락처: ");
		String tel = scan.nextLine();
		System.out.print("회원번호: ");
		String memberNo = scan.nextLine();
		
		Member newMember = new Member(name,tel,birthDate,memberNo);
		MemberDAO.memberList.add(newMember);
		MemberDAO.save();
//		등록 완료 메시지 출력
	}//addMember

	
	
	// 회원정보수정
	public static void readMemberList(int pageSize) {
//      회원 목록이 비어있는지 확인
		if (MemberDAO.memberList.isEmpty()) {
			System.out.println("등록된 회원이 없습니다.\n");
		}
		Scanner scan = new Scanner(System.in);
		
		int total = MemberDAO.memberList.size();
		int currentIndex = 0;
		
//		회원 조회 안내 메시지 출력
//		>
		
//      전체 회원 정보 중 상위 N개 출력
        System.out.println("\t[이름]\t\t[연락처]\t\t[생년월일]");
        while (currentIndex < total) {
        	int endIndex = currentIndex + pageSize;
        	if(endIndex > total) {
        		endIndex = total;
        	}
        	
        	for (int i = currentIndex; i<endIndex; i++) {
        		Member m = MemberDAO.memberList.get(i);
        		System.out.printf("%-3d\t%s\t\t%s\t\t%s\r\n"
        				,i+1, m.getName(), m.getTel(), m.getBirthDate());
        	}
        	
        		currentIndex = endIndex;
        		if(currentIndex >= total) {
        			System.out.println("더 이상 조회할 정보가 없습니다.");
        			break;
        		}
        		
        	System.out.println("엔터를 누르면 목록을 더 불러옵니다.");
        	System.out.println("그만 보려면 1을 입력");
        	String input = scan.nextLine();
        	if(input.equalsIgnoreCase("1")) {
        		System.out.println("조회를 중단합니다.");
        		break;
        	}
        }//while
	}//readMemberList
	
	
//	특정 회원 정보 조회
	public static void readMember() {
//	
	}
	

	// 회원정보수정
	public ArrayList<Member> editMember() {
		return null;
	}
	
	
	// 회원정보삭제
	public Member deleteMemberInfo() {
		return null;
	}


	// 이용권정보조회
	public ArrayList<TicketRegistration> inquriyOwnTicketInfo() {
		return null;
	}

	// 회원이용권등록
	public TicketRegistration addRegTicket() {
		return null;
	}

	// 회원이용권정보수정
	public TicketRegistration updateRegTicket() {
		return null;
	}

	// 회원이용권정보삭제
	public TicketRegistration deleteRegTicket() {
		return null;
	}

}
