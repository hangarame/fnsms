package com.fnsms.user;

import java.util.Scanner;

import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.emp.Emp;
import com.fnsms.member.Member;
import com.fnsms.view.MemberView;

public class UserService {

    
	User user;
	static String 유저구분;
    
	public UserService(User user) {
		super();
		this.user = user;
	}

	
	
	// 로그인
	public static void logIn() {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {

			//로그인 권한 선택 출력부 
	        System.out.print("선택: ");
	        String sel = scan.nextLine();
	        
	        
			if (sel.equals("1")) {//1번 회원
				불러오기(sel);//member, emp (name, memberNO, empNO) 불러오기
				memberIDFW();
				MemberView.memPrintBanner();
				
				pause();
				
			} else if (sel.equals("2")) {//2번 강사
				불러오기(sel);//member, emp (name, memberNO, empNO) 불러오기
				instructorIDFW();
				//강사화면();
				pause();
			
			} else if (sel.equals("3")) {//2번 강사
				불러오기(sel);//member, emp (name, memberNO, empNO) 불러오기
				administratorIDFW();
				//관리자화면();
				pause();	
				
			} else { 
			// System.out.println("잘못 입력했습니다!");
			
			loop = false;
			}	
		}
		//System.out.println();
		//System.out.println("메모장을 종료합니다.");
		
	}//login
	
	
	
	private static void pause() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		//System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}	//일시정지
	

	   

    // 멤버와 직원 데이터 초기화
	// 로그인했을 때 ID/PW를 비교하기 위해 데이터를 불러오는 메서드
    public static void 불러오기(String 유저구분) {
    	if(유저구분.equals("1")) {
    		MemberDAO.load();
    	
    	} else if(유저구분.equals("2")) {
    		MemberDAO.load();
    	
    	} else if(유저구분.equals("3")) {
    		MemberDAO.load();
    		
    	} else {
    		//System.out.println("잘못된 입력입니다.");//재입력메시지 출력
    		//종료(); 
    	}
    	
    }


	private static void memberIDFW() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ID: ");
		String ID = scan.nextLine();
		
		System.out.println("PW: ");
		String PW = scan.nextLine();
		
		boolean loop = true;
		
		while (loop) {
			for (Member m : MemberDAO.memberList) {
				if (ID.equals(m.getName()) && PW.equals(m.getMemberNo())) {				
					
					//System.out.println("회원님 안녕하세요.");
					
					return;
				}
			}
			//System.out.println("ID/PW가 잘못되었습니다. 다시입력해 주세요.");
			//***
			
		}
		

	}//회원Login
	

	private static void instructorIDFW() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ID: ");
		String ID = scan.nextLine();
		
		System.out.println("PW: ");
		String PW = scan.nextLine();
		
		boolean loop = true;
		
		while (loop) {
			for (Emp i : EmpDAO.instructorList) {
				if (ID.equals(i.getName()) && PW.equals(i.getEmpNo())) {				
					
					//System.out.println("강사님 안녕하세요.");
					
					return;
				}
			}
			//System.out.println("ID/PW가 잘못되었습니다. 다시입력해 주세요.");
			//***
		}
		
	}//강사Login

	
	private static void administratorIDFW() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ID: ");
		String ID = scan.nextLine();
		
		System.out.println("PW: ");
		String PW = scan.nextLine();
		
		boolean loop = true;
		
		while (loop) {
			for (Emp a : EmpDAO.adminList) {
				if (ID.equals(a.getName()) && PW.equals(a.getEmpNo())) {				
					
					//System.out.println("강사님 안녕하세요.");
					
					return;
				}
			}
			//System.out.println("ID/PW가 잘못되었습니다. 다시입력해 주세요.");
			//***
		}
		
		
	}//관리자Login
	
	
	
//	// 로그아웃
//	public void logOut() {
	

//	}


}