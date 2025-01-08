package com.fnsms.view;

public class InstructorMemberView {
	
	static String id = "아무개"; //아무개로 로그인 함
	static String position = "PT"; //아무개 회원의 직책
	static int total_mem = 100; //전체 회원수 임시 데이터 
	static int manage_mem = 9; //아무개의 담당 회원수 임시 데이터
	
	//3-3 회원 관리 페이지
	public static void memberManagement() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.printf("\t쌍용 헬스장의 회원수는 %d명입니다.\n",total_mem);
		System.out.printf("\t%s %s님의 담당 회원수는 %d명입니다.\n",id,position,manage_mem);
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t1. 회원 신규 등록");
		System.out.println("\t2. 회원 조회");
		System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
		System.out.println();
		System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
	//3-3-1 회원 신규 등록
	public static void newMemRegistration() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println("\t회원 신규 등록을 위한 회원 이름, 전화번호, 생년월일, 성별을 입력해주세요.");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t회원 이름 : ");
		System.out.println("\t전화번호 : ");
		System.out.println("\t생년월일 : ");
		System.out.println("\t성별 : ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
	//3-3-2 회원 조회
	public static void searchMember() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println("\t회원 조회를 위해 회원 이름을 입력해주세요.");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t회원 이름 : ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	//3-3-2 회원 조회
		public static void searchMemberFailed() {
			Header logo = new Header();
			logo.Logo();
			System.out.println("=================================================================================");
			System.out.println("\t※ 입력하신 이름은 없는 회원입니다! 회원 이름을 다시 입력해주세요.");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t회원 이름 : ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}

}
