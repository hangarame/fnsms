package com.fnsms.instructor;


import java.util.ArrayList;
import java.util.Scanner;

import com.fnsms.attendance.Attendance;
import com.fnsms.dao.MemberDAO;
import com.fnsms.emp.MemberService;
import com.fnsms.member.Member;
import com.fnsms.reservation.Reservation;

public class InstructorService extends MemberService {

	
//	회원등록
	public static void resisterMember() {
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
		
	}//resisterMember
	
// 회원조회
//	public ArrayList<Member> inquiryMngMember() {
	public static void readMemberList() {
//      회원 목록이 비어있는지 확인
		if (MemberDAO.memberList.isEmpty()) {
			System.out.println("등록된 회원이 없습니다.\n");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		
		int pageSize = 20;
		int total = MemberDAO.memberList.size();
		int currentIndex = 0;
		
//		회원 조회 안내 메시지 출력
//		>
		
//      전체 회원 정보 출력
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
	
	
	
/*
1. data 폴더에 DummyMember.txt 파일로 데이터 존재
m000000001◈20090122◈배예하◈010-3343-7519
memberNo ◈ 생년월일 ◈ 이름 ◈ 전화번호

2. com.fnsms.dao 패키지 안에 MemberDao.java 클래스에
 
    private final static String MEMBER_DATA_PATH;
	public static ArrayList<Member> memberList;
 	static {
		MEMBER_DATA_PATH = ".\\data\\DummyMember.txt";
		memberList = new ArrayList<Member>();
	}
 	해놓고, 
 	
 	public static void load() {try {
			BufferedReader reader = new BufferedReader(new FileReader(MEMBER_DATA_PATH));
			
			String line = null; 

			while((line = reader.readLine()) != null) {
				String[] temp = line.split("◈");
				memberList.add(new Member(temp[2], temp[3], temp[1], temp[0]));
			}
			reader.close();
		} catch (Exception e) {e.printStackTrace();}
		
		
 	public static void save() { try {
			FileWriter writer = new FileWriter(MEMBER_DATA_PATH);
			for(Member mem : memberList ) {
				String line = mem.getMemberNo() + "◈" + mem.getBirthDate() + "◈" + mem.getName() + "◈" + mem.getTel() + "\r\n";
				writer.write(line);
			}
			writer.close();
		} catch (Exception e) {e.printStackTrace();}
	}

 	이렇게 load와 save를 만들어놓음
 
 3. Instructor라는 사용자가 수행할 기능은
  	- member 신규 등록
  	- member 목록 조회
  		- 조회 후 특정 회원의 정보를 수정하기
  	이렇게 있음
이 기능들을 com.fnsms.instructor 패키지 속 InstructorService.java에서 구현할것임

  효과적으로 구현할 수 있는 코드를 알려줘
  
  	
*/
		
//		- 이용권(
//				data폴더에 DummyTicket.txt로 저장되어있음.
//				상품번호,티켓이름,사용가능기간,티켓등록일,티켓판매종료일,사용가능횟수,티켓가격
//				ex) 1◈헬스1개월◈30◈197001010000◈999912312359◈0◈150000
//		추후에 ticketDAO.java를 만들어서 MemberDAO.java처럼 사용할 예정)
		
		
		
		
		
		
//		return null;
		
		
//	}

	
	
	// 근퇴기록조회
	public ArrayList<Attendance> inquiryAttendance() {
		return null;
	}

	public ArrayList<Attendance> inquriyAttendance() {
		return null;
	}

	public void regStartWorkTime() {

	}

	public void regEndWorkTime() {

	}

	
	
	// 수업관리
	public void manageClass() {

	}
	
	

	// 예약조회
//	public ArrayList<Reservation> inquiryReservinfo() {
		
		
		
//	}

	
	//수업예약
//	public Reservation addReserv() {
//
//	}
//	
//	//수업변경
//	public Reservation editReserv() {
//		
//	}
//	
//	//수업삭제
//	public Reservation deleteReserv() {
//		
//	}
//
}
