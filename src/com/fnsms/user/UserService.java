package com.fnsms.user;

import java.util.Scanner;

import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.emp.Emp;
import com.fnsms.instructor.Instructor;
import com.fnsms.instructor.InstructorService;
import com.fnsms.member.Member;
import com.fnsms.member.MemberService;
import com.fnsms.view.CommonView;

public class UserService {

    
	
	// 로그인
	public static User logIn() {
	    Scanner scan = new Scanner(System.in);
	    while (true) {
	    	
        CommonView.printLoginSelct();

        String sel = scan.nextLine().trim();
        User user = null;
        
        
        if (sel.equals("1")) { 
        // 1. 회원 로그인
            listRoad(sel);
            user = memberIDFW(); // ID/PW 비교
            if (user != null) {
        // 로그인 성공 -> memberMainMenu() 호출 등
                MemberService memberService = new MemberService(((Member)user).getMemberNo());
                memberService.memberMainMenu();
                
                // 이 시점에서 memberMainMenu()가 끝났다는 건 로그아웃 or 뒤로가기가 일어났을 때
                // 로그아웃 후 계속 진행 -> 다시 로그인 화면 or return user
                // 현재 구조상, memberMainMenu() 안에서 logOut() -> logIn() 재호출이 있으므로 
                // 여기서는 별도 처리 없음
            }
        } else if (sel.equals("2")) {
            // 2. 강사 로그인
            listRoad(sel);
            user = instructorIDFW();
            if (user != null) {
            	InstructorService instructorService = new InstructorService(((Instructor)user).getEmpNo());
            	instructorService.instructorMainMenu();
                // 강사 메인 화면 등
                // ...
                // return user; or loop to re-login
            }
        } else if (sel.equals("3")) {
            // 3. 관리자
            listRoad(sel);
            user = administratorIDFW();
            if (user != null) {
                // 관리자 메인 화면 등
                // ...
            }
        } else if (sel.equalsIgnoreCase("E")) {
            // 프로그램 종료 신호
            return null; 
        } else {
            System.out.println("잘못된 입력입니다.");
        }
	    }
	}//로그인
	
	protected static void pause() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		//System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}	//일시정지
	

	   

    // 멤버와 직원 데이터 초기화
	// 로그인했을 때 ID/PW를 비교하기 위해 데이터를 불러오는 메서드
    public static void listRoad(String sel) {
    	if(sel.equals("1")) {
    		MemberDAO.load();
    	
    	} else if(sel.equals("2")) {
    		EmpDAO.load();
    	
    	} else if(sel.equals("3")) {
    		EmpDAO.load();
    		
    	} else {
    		//System.out.println("잘못된 입력입니다.");//재입력메시지 출력
    		//종료(); 
    	}
    	
    }


	private static User memberIDFW() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("ID: ");
			String ID = scan.nextLine();
			
			System.out.print("PW: ");
			String PW = scan.nextLine();
			
			for (Member m : MemberDAO.memberList) {
				if (ID.equals(m.getName()) && PW.equals(m.getMemberNo())) {				
					//System.out.println("회원님 안녕하세요.");
					return m;
				
				}
			}
			
			CommonView.printLoginFailed();
			
			//System.out.println("ID/PW가 잘못되었습니다. 다시입력해 주세요.");
			//CommonView.printLoginFailed();
			//***
			 //System.out.print("다시 시도하시겠습니까? (Y/N): ");
	        String retry = scan.nextLine();
	        if (retry.equalsIgnoreCase("N")) {
	            return null; // 초기 화면으로 돌아가게 하기 위해 null 반환
	        }
			
		}
	}//회원Login
	

	private static User instructorIDFW() {
		Scanner scan = new Scanner(System.in);
		
		
		while (true) {
			System.out.print("ID: ");
			String ID = scan.nextLine();
			
			System.out.print("PW: ");
			String PW = scan.nextLine();
			
			for (Emp i : EmpDAO.instructorList) {
				if (ID.equals(i.getName()) && PW.equals(i.getEmpNo())) {				
					//System.out.println("강사님 안녕하세요.");
					return i;
					
				}
			}
			
			CommonView.printLoginFailed();
			//***
	        String retry = scan.nextLine();
	        if (retry.equalsIgnoreCase("N")) {
	            return null; // 초기 화면으로 돌아가게 하기 위해 null 반환
	            
	        }
		}
	}//강사Login

	
	
	private static User administratorIDFW() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.print("ID: ");
			String ID = scan.nextLine();
			
			System.out.print("PW: ");
			String PW = scan.nextLine();
			
			for (Emp a : EmpDAO.adminList) {
				if (ID.equals(a.getName()) && PW.equals(a.getEmpNo())) {				
					//System.out.println("관리자님 안녕하세요.");
					return a;
				}
			}

			CommonView.printLoginFailed();
			//***
	        String retry = scan.nextLine();
	        if (retry.equalsIgnoreCase("N")) {
	            return null; // 초기 화면으로 돌아가게 하기 위해 null 반환
	        
	        }	
	        
		}
	}//관리자Login
	
	
	
	//로그아웃
	public static void logOut() { logIn(); }
	
	
	//로그인


}