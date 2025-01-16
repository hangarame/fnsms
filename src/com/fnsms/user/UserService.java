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
/**
 * 로그인을 메인으로 가지고 있는 클래스 입니다.
 * @author 1조
 */
public class UserService {
	/**
	 * 사용자의 권한에 맞는 기능을 사용하기 위해 로그인을 통해 분류합니다.
	 * @return 사용자의 정보를 반환 합니다. 
	 */
	// 로그인
	public static User logIn() {
	    Scanner scan = new Scanner(System.in);
	    while (true) {
	    /**
	     * 로그인 초기화면을 출력합니다.	
	     */
        CommonView.printLoginSelct();
        /**
         * 사용자가 해당하는 권한을 선택합니다.
         */
        String sel = scan.nextLine().trim();
        User user = null;
        
        /**
         * 1번 선택 시 회원이 맞는지 로그인을 통해 확인 합니다.
         */
        if (sel.equals("1")) { 
        // 1. 회원 로그인
            listRoad(sel);
            user = memberIDFW(); // ID/PW 비교
            /**
             * 로그인 정보와 유저정보가 일치하면 회원의 정보를 기준으로 메인화면을 출력합니다.
             */
            if (user != null) {
        // 로그인 성공 -> memberMainMenu() 호출 등
                MemberService memberService = new MemberService(((Member)user).getMemberNo());
                memberService.memberMainMenu();
                
                // 이 시점에서 memberMainMenu()가 끝났다는 건 로그아웃 or 뒤로가기가 일어났을 때
                // 로그아웃 후 계속 진행 -> 다시 로그인 화면 or return user
                // 현재 구조상, memberMainMenu() 안에서 logOut() -> logIn() 재호출이 있으므로 
                // 여기서는 별도 처리 없음
            }
            /**
             * 2번 선택 시 강사가 맞는지 로그인을 통해 확인 합니다.
             */
        } else if (sel.equals("2")) {
            // 2. 강사 로그인
            listRoad(sel);
            user = instructorIDFW();
            /**
             * 로그인 정보와 유저정보가 일치하면 강사의 정보를 기준으로 메인화면을 출력합니다.
             */

            if (user != null) {
            	InstructorService instructorService = new InstructorService(((Instructor)user).getEmpNo());
            	instructorService.instructorMainMenu();
                // 강사 메인 화면 등
                // ...
                // return user; or loop to re-login
            }
            /**
             * 3번 선택 시 관리자 맞는지 로그인을 통해 확인 합니다.
             */
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
	
	/**
	 * 화면이 출력된 후 바로 입력값을 받지않고 일시정지 합니다.
	 */
	protected static void pause() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		//System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}	//일시정지
	

	   
	/**
	 * 권한을 선택합니다.
	 * @param 선택 번호와 맞는 권한의 정보와 비교합니다.
	 */
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

    /**
     * 사용자가 로그인 시 입력한 값과 회원정보를 비교하여 일치하는 데이터를 가져옵니다.
     * @return 회원의 정보를 반환합니다. 
     */
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
			/**
			 * 잘못된 입력을 했을 시 재시도 메세지를 출력합니다.
			 */
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
	
	
	/**
	 * 로그아웃을 합니다.
	 */
	//로그아웃
	public static void logOut() { logIn(); }
	
	
	//로그인


}