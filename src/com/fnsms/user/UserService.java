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
		boolean loop = true;
		
		while (loop) {

			//로그인 권한 선택 출력부 
			CommonView.printLoginSelct();
			
			
	        //System.out.print("선택: ");
	        String sel = scan.nextLine();
	        User user=null;
	        
	        
			if (sel.equals("1")) {//1번 회원
				CommonView.memberPrintBanner();
				listRoad(sel);
				user = memberIDFW();
				
				if (user != null) {
					//회원화면();
					MemberService memberService = new MemberService(((Member)user).getMemberNo());					
					memberService.memberMainMenu();					

					pause();
					
					
					return user;
				
				} else {
					//System.out.println("로그인 실패 초기화면");
				
				}
				
			} else if (sel.equals("2")) {//2번 강사
				CommonView.instructorPrintBanner();
				listRoad(sel);
				user = instructorIDFW();
				
				if (user != null) {
					//강사화면();
					
					InstructorService instructorService = new InstructorService(((Instructor)user).getEmpNo());
					instructorService.instructorMainMenu();
					pause();
					return user;
				
				} else {
					//System.out.println("로그인 실패 초기화면");
				
				}
		
				
			} else if (sel.equals("3")) {//2번 강사
				CommonView.adminPrintBanner();
				listRoad(sel);
				user = administratorIDFW();
				
				if (user != null) {
					//관리자화면();
					pause();
					return user;
				
				} else {
					//System.out.println("로그인 실패 초기화면");
				
				}	
				
			} else if(sel.equals("E")) { 
				loop = false;

			}
			// System.out.println("잘못 입력했습니다!");
			loop = true;
		}
		//System.out.println();
		//System.out.println("메모장을 종료합니다.");
		return null;
	}//login
	
	
	
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
	public static void logOut() {
		Scanner scan = new Scanner(System.in);
		String sel = scan.nextLine();
		if (sel.equals("E")) {
			logIn();
			
		} else {
			
		}		
	}
	
	
	
	//로그인


}