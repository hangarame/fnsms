package com.fnsms.view;

import java.util.Calendar;

public class InstructorMemberView {
	
	static String id = "아무개"; //아무개로 로그인 함
	static String position = "PT"; //아무개 회원의 직책
	static int total_mem = 100; //전체 회원수 임시 데이터 
	static int manage_mem = 9; //아무개의 담당 회원수 임시 데이터
	
	//3-3 회원 관리 페이지
	public static void memberManagement() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t   강사 메인페이지/회원 관리");
		System.out.println("=================================================================================");
		System.out.printf("\t쌍용 헬스장의 회원수는 %d명입니다.\n",total_mem);
		System.out.printf("\t%s %s님의 담당 회원수는 %d명입니다.\n",id,position,manage_mem);
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
		System.out.println("\t1. 회원 신규 등록");
		System.out.println("\t2. 회원 조회");
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
		System.out.println("\t\t\t\t\t\t강사 메인페이지/회원 관리/회원 신규 등록");
		System.out.println("=================================================================================");
		System.out.println("\t회원 신규 등록을 위한 회원 이름, 전화번호, 생년월일, 성별을 입력해주세요.");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//		System.out.println("\t회원 이름 : ");
//		System.out.println("\t전화번호 : ");
//		System.out.println("\t생년월일 : ");
//		System.out.println("\t성별 : ");
		
	}
	
	
	//3-3-2 회원 조회
	public static void searchMember() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t강사 메인페이지/회원 관리/회원 조회");
		System.out.println("=================================================================================");
		System.out.println("\t회원 조회를 위해 회원 이름을 입력해주세요.");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//		System.out.println("\t회원 이름 :  ");
	}
	
	
	//3-3-2-0 회원 조회 실패할 경우
		public static void searchMemberFailed() {
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t\t\t강사 메인페이지/회원 관리/회원 조회");
			System.out.println("=================================================================================");
			System.out.println("\t※ 입력한 이름은 없는 회원입니다! 회원 이름을 다시 입력해주세요.");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.println("\t회원 이름 : ");
		}
		
		//동명이인중 조회할 회원 하나를 선택
		public static void selectMemberList() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t\t\t강사 메인페이지/회원 관리/회원 조회");
			System.out.println("=================================================================================");
			System.out.printf("\t검색한 %s 회원님 명단입니다.\n",member);
			System.out.printf("\t[번호]\t[이름]\t[담당자]\t[전화번호]\t\t[생년월일]\t\t[성별]\n");
			System.out.printf("\t%4d\t%3s\t%4s\t%s\t%s\t%3s\n",001,"홍길동","아무개","010-2345-4456","00-01-23","여성");
			System.out.printf("\t%4d\t%3s\t%4s\t%s\t%s\t%3s\n",002,"홍길동","관리자","010-2335-4706","80-07-28","여성");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.println("\t조회할 회원님의 전화번호 뒤 4자리를 입력하세요 : ");
			
		
		}
		
		//동명이인중 조회할 회원 선택 실패
			public static void selectMemberListFailed() {
				String member = "홍길동"; //홍길동을 입력 받았을때
				Header logo = new Header();
				logo.Logo();
				System.out.println("\t\t\t\t\t\t\t강사 메인페이지/회원 관리/회원 조회");
				System.out.println("=================================================================================");
				System.out.printf("\t검색한 %s 회원님 명단입니다.\n",member);
				System.out.printf("\t[번호]\t[이름]\t[담당자]\t[전화번호]\t\t[생년월일]\t\t[성별]\n");
				System.out.printf("\t%4d\t%3s\t%4s\t%s\t%s\t%3s\n",001,"홍길동","아무개","010-2345-4456","00-01-23","여성");
				System.out.printf("\t%4d\t%3s\t%4s\t%s\t%s\t%3s\n",002,"홍길동","관리자","010-2335-4706","80-07-28","남성");
				System.out.println("=================================================================================");
				System.out.println();
				System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
				System.out.println("\t※ 조회할 회원이 없습니다!! 다시 정확하게 입력해주세요.");
//				System.out.println("\t조회할 회원님의 전화번호 뒤 4자리를 입력하세요 : ");
				}
		
		//3-3-2-2 0001 홍길동 선탣
		public static void selectMember() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t\t\t강사 메인페이지/회원 관리/회원 조회");
			System.out.println("=================================================================================");
			System.out.printf("\t이름 : %s\n",member);
			System.out.printf("\t연락처 : %s\n","010-3345-8977");
			System.out.printf("\t성별 : %s\n","여성");
			System.out.printf("\t생년월일 : %s\n","00-11-23");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println("\t1. 회원 정보 수정");
			System.out.println("\t2. 이용권 신규 등록");
			System.out.println("\t3. 이용권 수정");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}

		
		public static void editMember() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t    강사 메인페이지/회원 관리/회원 조회/회원 정보 수정");
			System.out.println("=================================================================================");
			System.out.printf("\t이름 : %s\n",member);
			System.out.printf("\t연락처 : %s\n","010-3345-8977");
			System.out.printf("\t성별 : %s\n","여성");
			System.out.printf("\t생년월일 : %s\n","00-11-23");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println("\t1. 이름 변경");
			System.out.println("\t2. 전화번호 변경");
			System.out.println("\t3. 성별 변경");
			System.out.println("\t4. 생년월일 변경");
			System.out.println("\t5. 회원삭제");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}
		
		public static void editMemberName() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t     강사 메인페이지/회원 관리/회원 조회/회원 정보 수정/이름 변경");
			System.out.println("=================================================================================");
			System.out.println("\t이름 :");
			System.out.printf("\t연락처 : %s\n","010-3345-8977");
			System.out.printf("\t성별 : %s\n","여성");
			System.out.printf("\t생년월일 : %s\n","00-11-23");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.println("\t이름 재입력 : (위의 이름 칸이 널값이 됩니다.)");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}
		
		public static void editMemberTel() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t   강사 메인페이지/회원 관리/회원 조회/회원 정보 수정/전화번호 변경");
			System.out.println("=================================================================================");
			System.out.printf("\t이름 : %s\n",member);
			System.out.printf("\t연락처 : %s\n","");
			System.out.printf("\t성별 : %s\n","여성");
			System.out.printf("\t생년월일 : %s\n","00-11-23");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.println("\t연락처 재입력 : (위의 연락처 칸이 널값이 됩니다.)");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}

		
		public static void editMemberGender() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t     강사 메인페이지/회원 관리/회원 조회/회원 정보 수정/성별 변경");
			System.out.println("=================================================================================");
			System.out.printf("\t이름 : %s\n",member);
			System.out.printf("\t연락처 : %s\n","010-3345-8977");
			System.out.printf("\t성별 : %s\n","");
			System.out.printf("\t생년월일 : %s\n","00-11-23");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.println("\t성별 재입력 : (위의 성별 칸이 널값이 됩니다.)");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}

		
		public static void editMemberBirth() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t   강사 메인페이지/회원 관리/회원 조회/회원 정보 수정/생년월일 변경");
			System.out.println("=================================================================================");
			System.out.printf("\t이름 : %s\n",member);
			System.out.printf("\t연락처 : %s\n","010-3345-8977");
			System.out.printf("\t성별 : %s\n","여성");
			System.out.printf("\t생년월일 : %s\n","");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.println("\t생년월일(YY-MM-DD) 재입력 : (위의 생년월일 칸이 널값이 됩니다.)");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}

		
		//회원을 삭제할 경우 (이용권을 양도할때 등)
		public static void deleteMember() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t     강사 메인페이지/회원 관리/회원 조회/회원 정보 수정/회원 삭제");
			System.out.println("=================================================================================");
			System.out.printf("\t이름 : %s\n",member);
			System.out.printf("\t연락처 : %s\n","010-3345-8977");
			System.out.printf("\t성별 : %s\n","여성");
			System.out.printf("\t생년월일 : %s\n","00-11-23");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println("\t정말 홍길동 회원님의 정보를 삭제하시겠습니까? (y/n)"); 
			//n 누르면 "홍길동 회원님의 정보가 삭제되지 않았습니다. 메인화면으로 이동합니다."를 출력하고
			//#과 같이 메인으로 돌아감
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}
		
		
		//3-3-2-2-1 이용권 신규 등록
		public static void registerSubscription() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t   강사 메인페이지/회원 관리/회원 조회/이용권 신규 등록");
			System.out.println("=================================================================================");
			System.out.println("\t"+ member + "님의 이용권 신규 등록을 위해 ");
			System.out.println("\t등록일, 이용권 구분, 담당자, 이용 기간, 시작일, 금액을 입력하세요.");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.print("\t등록일(YYYY-MM-DD) : "); 
//			System.out.print("\t이용권 구분 : "); 
//			System.out.print("\t담당자 : "); 
//			System.out.print("\t이용 기간(일) : "); 
//			System.out.print("\t시작일(YYYY-MM-DD) : "); 
//			System.out.print("\t종료일(YYYY-MM-DD) : "); 종료일은 연산값(시작일+기간)으로 계산해서 조회할때 출력합니다
//			System.out.print("\t금액(원) : "); 
		}
		
		
		//3-3-2-2-1 이용권 수정
		public static void editSubscription() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t       강사 메인페이지/회원 관리/회원 조회/이용권 수정");
			System.out.println("=================================================================================");
			System.out.println("\t"+ member + "님이 현재 이용중인 이용권 목록입니다.");
			System.out.println("\t1. 헬스 이용권 수정(시작일-종료일)");
			System.out.println("\t2. Pt 이용권 수정(시작일-종료일)");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");

		}
		
		//3-3-2-2-2 이용권 수정
		public static void editSubscriptionList() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t       강사 메인페이지/회원 관리/회원 조회/이용권 수정");
			System.out.println("=================================================================================");
			System.out.println("\t"+ member + "님이 현재 이용중인 이용권 목록입니다.");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%s\t%s\t%6s\t\t%4s\t\t%3d\n","2025-01-05","홍길동","PT","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s\t %15s      %s\t%,d\n","60/100","2025-01-05","2025-02-06",211000);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
//			System.out.print("\t1. 등록일 변경(YYYY-MM-DD) : "); 
//			System.out.print("\t2. 이용권 구분 변경 : "); 
//			System.out.print("\t3. 담당자 변경 : "); 
//			System.out.print("\t4. 이용 기간 변경(일) : "); 
//			System.out.print("\t5. 시작일 변경(YYYY-MM-DD) : "); 
//			System.out.print("\t6. 종료일 변경(YYYY-MM-DD) : "); 휴회일 경우
//			System.out.print("\t7. 금액 변경(원) : "); 
//			System.out.print("\t8. 이용권 삭제 : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");

		}
		
		//3-3-2-2-2 이용권 수정/ 등록일 변경
		public static void editRegistrationDate() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t      강사 메인페이지/회원 관리/회원 조회/이용권 수정/등록일 변경");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%s\t%s\t%6s\t\t%4s\t\t%3d\n","","홍길동","PT","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s\t %15s      %s\t%,d\n","60/100","2025-01-05","2025-02-06",211000);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
			System.out.printf("\t등록일은 %s이었습니다.\n","2023-03-02");
			System.out.println("\t등록일을 재입력해주세요. : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			// 등록일 값을 null로 만들고 받은 값으로 표 채우기

			
		}
		
		
		//3-3-2-2-2 이용권 수정/ 이용권 구분 변경
		public static void editSubscriptionType() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t   강사 메인페이지/회원 관리/회원 조회/이용권 수정/이용권 구분 변경");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%10s%9s%10s%14s%15d\n","2025-15-23","홍길동","","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s%23s%15s\t%,4d\n","60/100","2025-01-05","2025-02-06",211000);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
			System.out.printf("\t이용권 구분은 %s이었습니다.\n","헬스");
			System.out.println("\t이용권 구분을 재입력해주세요. : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			// 이용권 구분 변경 값을 null로 만들고 받은 값으로 표 채우기

		}
		
		
		//3-3-2-2-2 이용권 수정/ 이용기간 변경
		public static void updateSubscriptionPeriod() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t    강사 메인페이지/회원 관리/회원 조회/이용권 수정/이용 기간 변경");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%10s%9s%10s%14s%15d\n","2025-15-23","홍길동","PT","아무개",0);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s%23s%15s\t%,4d\n","60/100","2025-01-05","2025-02-06",211000);
			System.out.println("=================================================================================");
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
			System.out.printf("\t이용 기간은 %d이었습니다.\n",30);
			System.out.println("\t이용 기간을 재입력해주세요. : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			// 이용기간 값을 0으로 만들고 받은 값으로 표 채우기

		}
		
		
		//3-3-2-2-2 이용권 수정/ 담당자변경
		public static void changeInstructor() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t      강사 메인페이지/회원 관리/회원 조회/이용권 수정/담당자 변경");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%10s%9s%10s%14s%15d\n","2025-15-23","","PT","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s%23s%15s\t%,4d\n","60/100","2025-01-05","2025-02-06",211000);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
			System.out.printf("\t담당자가 %s이었습니다.\n","강아지");
			System.out.println("\t담당자를 재입력해주세요. : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			// 담당자 값을 null 으로 만들고 받은 값으로 표 채우기


		}
		
		
		//시작일 변경
		//3-3-2-2-2 이용권 수정/ 등록일 변경
		public static void updateStartDate() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t      강사 메인페이지/회원 관리/회원 조회/이용권 수정/시작일 변경");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%10s%9s%10s%14s%15d\n","2025-15-23","홍길동","PT","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s%23s%15s\t%,4d\n","60/100","","2025-02-06",211000);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
			System.out.printf("\t시작일이 %s이었습니다.\n","2023-03-02");
			System.out.println("\t시작일을 재입력해주세요. : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");

		}
		
		//종료일 변경(휴회일 경우)
		//3-3-2-2-2 이용권 수정/ 종료일 변경
		public static void updateEndDate() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t      강사 메인페이지/회원 관리/회원 조회/이용권 수정/등록일 변경");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%10s%9s%10s%14s%15d\n","2025-15-23","홍길동","PT","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s%23s%15s\t%,4d\n","60/100","2025-01-05","",211000);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
			System.out.printf("\t종료일이 %s이었습니다.\n","2023-03-02");
			System.out.println("\t종료일을 재입력해주세요. : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");

		}
		//금액변경
		//3-3-2-2-2 이용권 수정/ 금액변경
		public static void updatePrice() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t강사 메인페이지/회원 관리/회원 조회/이용권 수정/금액 변경");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%10s%9s%10s%14s%15d\n","2025-15-23","홍길동","PT","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s%23s%15s\t%,4d\n","60/100","2025-01-05","2025-02-06",0);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
			System.out.println();
			System.out.printf("\t금액이 %d이었습니다.\n",100000);
			System.out.println("\t금액을 재입력해주세요. : ");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");

		}
		
		
		public static void deleteSubscription() {
			String member = "홍길동"; //홍길동을 입력 받았을때
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t       강사 메인페이지/회원 관리/회원 조회/이용권 삭제");
			System.out.println("=================================================================================");
			System.out.println("\t"+ member + "님이 현재 이용중인 이용권 목록입니다.");
			System.out.println("=================================================================================");
			System.out.println("\t[등록일]\t\t[이름]\t[이용권 구분]\t[담당자]\t\t[기간]");
			System.out.printf("\t%s\t%s\t%6s\t\t%4s\t\t%3d\n","2025-01-05","홍길동","PT","아무개",30);
			System.out.println();
			System.out.println("\t[남은 횟수/총 횟수]\t\t[시작일]\t\t[종료일]\t\t[금액]");
			System.out.printf("\t%10s\t %15s      %s\t%,d\n","60/100","2025-01-05","2025-02-06",211000);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.println("\t홍길동의 이용권을 삭제하시겠습니까? (Y/N) : ");
//			Y를 누르면 삭ㅈ제 후 경우 홍길동님의 PT이용권 삭제가 완료되었습니다! 출력
//			N을 누르면 메인화면으로 간다.
		}
		
		//4. 수업료 정산
		public static void calculateTuition() {
			
			// 현재 날짜 가져오기
	        Calendar calendar = Calendar.getInstance();
	        int currentYear = calendar.get(Calendar.YEAR);
	        int currentMonth = calendar.get(Calendar.MONTH) + 1; // MONTH는 0부터 시작하므로 +1
	        int previousMonth = currentMonth - 1;
	        int previousYear = currentYear;

	        // 이전 월이 12월일 경우 연도 처리
	        if (previousMonth == 0) {
	            previousMonth = 12;
	            previousYear -= 1;
	        }
			
			
			// 변수 선언
	        String name = "아무개 PT님";
	        int currentMonthHours = 10; // 이번 달 근무 시간
	        int currentMonthLessons = 5; // 이번 달 수업 횟수
	        int currentMonthSalary = 100000; // 이번 달 예상 급여

	        int previousMonthHours = 100; // 이전 달 근무 시간
	        int previousMonthSalary = 3200000; // 이전 달 정산 금액
			
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("\t\t\t\t\t\t\t     강사 메인페이지/수업료 정산");
			System.out.println("=================================================================================");
			System.out.printf( "\t%s은 이번달 %d시간 근무했습니다.\n",name,currentMonthHours);
	        System.out.printf("\t%d년 %d월 수업 횟수는 %d회 입니다.\n",currentYear, currentMonth,currentMonthLessons);
	        System.out.printf("\t%d년 %d월 예상 급여는 %d원입니다.\n",currentYear,currentMonth, currentMonthSalary);
	        System.out.printf("\t%d년 %d월은 %d시간 근무했으며, %,d원 정산했습니다.\n",previousYear,previousMonth,previousMonthHours,previousMonthSalary);
	        System.out.println("=================================================================================");
	        System.out.println();
			System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
//			System.out.print("\t월급을 조회하고 싶은 달을 입력하세요.:");
		}
		

}
