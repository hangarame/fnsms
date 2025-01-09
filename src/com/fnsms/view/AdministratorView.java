package com.fnsms.view;

import java.util.Calendar;

public class AdministratorView implements ConsoleColor{
	//오늘의 년도와 달
		public static Calendar now = Calendar.getInstance();
		
		//관리자 이름
		static String mem_name = "홍길동";
		static String tel = "010-1234-2345";
		static String gender = "남성";
		static String birth = "1980-03-02";
		
		static int in_mem = 9;
		
		//강사목록
		static String[] in_name = {"홍길동","가나다","강아지","고양이","병아라","코끼리","돼지","쥐","김우주"}; 
		static String[] position = {"필테","PT","필테","PT","필테","PT","필테","필테","필테"}; 
		static String[] company_num= {"1111","3434","5456","2393","5467","3236","4355","6666","7777"}; 

		
		//화면 설계4, 관리자일경우 메인화면
		public static void printMainmenu() {

			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t\t\t\t 관리자 메인페이지");
	        System.out.println("=================================================================================");
	        System.out.printf("\t안녕하세요 %s 관리자님!\n",mem_name);
	        System.out.println();
	        System.out.printf("\t연락처 : %s\n",tel);
	        System.out.printf("\t성별 : %s\n",gender);
	        System.out.printf("\t생년월일 : %s\n",birth);
	        System.out.println("=================================================================================");
	        System.out.println();
	        System.out.println("\t1. 강사 관리");
			System.out.println("\t2. 회원 관리");
			System.out.println("\t3. 매출 관리");
			System.out.println("\t(로그아웃을 하려면 \"E\"를 입력해주세요.)");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			
	       
		}
		
		//4-1 강사관리
		public static void instructorManagement()	{
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t\t       관리자 메인페이지/강사 관리");
	        
			System.out.println("=================================================================================");
			System.out.printf("\t쌍용 헬스장에서는 %d명의 강사님이 계십니다!\n",in_mem);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.printf("\t[번호]\t[이름]\t[직책]\t[사번]\n");
			for(int i =0; i<in_mem;i++) {
				System.out.printf("\t%5d\t%3s\t%3s\t%5s\n",i+1,in_name[i],position[i],company_num[i]);
			}
			System.out.println();
			System.out.println("=================================================================================");
			System.out.println();
//			System.out.println("\t조회할 강사님의 사번을 적어주세요 : ");
			
			
		}
		
		//강사 선택 실패
		public static void instructorManagementFailed()	{
			Header logo = new Header();
	        logo.Logo();
	        
			System.out.println("=================================================================================");
			System.out.printf("\t※사번을 찾을수 없습니다! 사번을 정확히 적어주세요!\n",in_mem);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.printf("\t[번호]\t[이름]\t[직책]\t[사번]\n");
			for(int i =0; i<in_mem;i++) {
				System.out.printf("\t%5d\t%3s\t%3s\t%5s\n",i+1,in_name[i],position[i],company_num[i]);
			}
			System.out.println();
			System.out.println("=================================================================================");
			System.out.println();
//			System.out.println("\t조회할 강사님의 사번을 적어주세요 : ");
		
		}
		
		//강사 선택 성공
		//4-1-1 강사를 선택한 후(아무개 선택이라고 가정)
		public static void selectInstructor() {
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t\t       관리자 메인페이지/강사 관리");
	        System.out.println("=================================================================================");
	        System.out.printf("\t%s %s님을 선택하셨습니다.\n",in_name[0],position[0]);
	        System.out.println("=================================================================================");
	        System.out.println();
	        System.out.println("\t(메인으로 돌아가려면 #을 입력하세요.)");
	        System.out.println("\t1. 근퇴 기록 관리");
	        System.out.println("\t2. 수업 관리");
	        System.out.println("\t3. 수업료 정산");
	        System.out.println();
//	        System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
	      
	        
		}
		
		//3-1-1-1 근퇴기록 관리
		public static void attendanceManagement() {
			
		   now.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            Calendar startOfWeek = (Calendar) now.clone();
            Calendar endOfWeek = (Calendar) now.clone();
            endOfWeek.add(Calendar.DATE, 6);

            String[] commuteResult = {"정상", "지각", "조퇴", "정상", "결근", "", ""};

            Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t관리자 메인페이지/강사 관리/근퇴 기록 관리");
            System.out.println("=================================================================================");
            System.out.printf("\t%s %s님의 이번주 근퇴 현황입니다.(%tF~%tF)\r\n"
                                ,in_name[0],position[0], startOfWeek, endOfWeek);
            System.out.println("=================================================================================");
            System.out.println();
            System.out.println("\t[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
            System.out.printf("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\r\n"
                                ,commuteResult[0]
                                ,commuteResult[1]
                                ,commuteResult[2]
                                ,commuteResult[3]
                                ,commuteResult[4]
                                ,commuteResult[5]
                                ,commuteResult[6]);
            System.out.println();
            System.out.println("=================================================================================");
            System.out.println();
            System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
            System.out.println("\t1. 근퇴 기록 조회하기");
            System.out.println("\t2. 근퇴 기록 수정하기");
            System.out.println();
//          System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
            
			
		}
		
		//달력 표시하고 근퇴 기록 조회할 날짜 받기
		public static void getAttendanceRecords() {
			CalendarView printCal = new CalendarView();
			
			
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t관리자 메인페이지/강사 관리/근퇴 기록 조회");
			printCal.printCalendar();
			System.out.println("=================================================================================");
			//(지각, 조퇴, 결근인 경우 * 표시를 할 수 있나요)
			System.out.println();
//			System.out.print("조회할 날짜를 입력하세요(YYYY-MM-DD) :");
		}
		
		//날짜 입력 받고 조회
		public static void getAttendanceDate() {
			
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t관리자 메인페이지/강사 관리/근퇴 기록 조회");
			System.out.println("=================================================================================");
			System.out.printf("%s %s님의 %s 근퇴 기록 조회",in_name[2],position[3],"2025-01-02");
			System.out.printf("출근 시간 : %s\n","9:00");
			System.out.printf("퇴근 시간 : %s\n","19:00");
			System.out.printf("결과 : %s\n","조퇴");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		}
		
		//날짜 입력 받고 조회
		public static void editAttendance() {
			
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t관리자 메인페이지/강사 관리/근퇴 기록 수정");
			System.out.println("=================================================================================");
			System.out.printf("%s %s님의 %s 근퇴 기록 조회",in_name[2],position[3],"2025-01-02");
			System.out.printf("출근 시간 : %s\n","9:00");
			System.out.printf("퇴근 시간 : %s\n","19:00");
			System.out.printf("결과 : %s\n","조퇴");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
//			System.out.println("수정할 값을 입력하세요");
//			System.out.println("출근 시간 : ");
//			System.out.println("퇴근 시간 : ");
//			System.out.println("결과 : ");
		}
		
		//4-1-2 수업관리, 해당 강사의 수업관리와 같다.
		public static void manageClass() {
			
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t     관리자 메인페이지/강사 관리/수업 관리");
			System.out.println("=================================================================================");
			System.out.printf("\t%s %s님의 수업관리 상세보기 페이지입니다.\n",in_name[2],position[3]);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("\t1. 날짜 검색");
			System.out.println("\t2. 회원 검색");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
		}
		
		//4-2 회원 관리
		public static void managePpl() {
			
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t\t       관리자 메인페이지/회원 관리");
			System.out.println("=================================================================================");
			System.out.println("\t쌍용 헬스장의 회원수는 110명입니다.");
			System.out.println("\t각 강사님이 맡고 있는 회원 수 입니다.");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t[번호]\t[이름]\t[직책]\t[사번]\t[회원수]");
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 1, "김민수", "PT", 1234, 8);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 2, "이영희", "필테", 2345, 9);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 3, "박철수", "헬스", 3456, 7);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 4, "최지은", "PT", 4567, 10);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 5, "정하늘", "헬스", 5678, 11);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 6, "강다솔", "필테", 6789, 6);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 7, "오승현", "PT", 7890, 12);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 8, "윤가영", "헬스", 8901, 8);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 9, "한민정", "필테", 9012, 7);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 10, "조성민", "헬스", 1123, 10);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 11, "서유리", "PT", 2234, 9);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 12, "이준혁", "헬스", 3345, 5);
			System.out.printf("\t%5d\t%s\t%s\t%5d\t%6d\n", 13, "송하늘", "필테", 4456, 9);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("\t1. 회원 등록");
			System.out.println("\t2. 회원 조회");
			System.out.println();
//			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			//회원 등록과 회원 조회는 강사의 회원 등록, 회원 조회와 같다.
			//회원 등록 :InstructorMemberView.newMemRegistration()
			//회원 조회 :InstructorMemberView.searchMember()
			
		}
		//4-3 매출 관리
		public static void recordSale() {
			
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t\t       관리자 메인페이지/매출 관리");
			System.out.println("=================================================================================");
			System.out.println("\t조회하고 싶은 이용권을 선택해주세요");
			System.out.println("\t1. 전체 이용권");
			System.out.println("\t2. 헬스 이용권");
			System.out.println("\t3. PT 이용권");
			System.out.println("\t4. 필라테스 이용권");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("\t");
//			System.out.println("🖙 이용권 종류의 숫자를 입력해주세요 : ");

			
		}
		
		//4-3 매출 관리 범위 선택
		public static void recordSaleDate() {
			
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("\t\t\t\t\t     관리자 메인페이지/매출 관리/매출 조회");
			System.out.println("=================================================================================");
			System.out.printf("\t%s을 선택했습니다.\n","전체 이용권");
			System.out.println("\t조회하고 싶은 범위를 입력해주세요.");
			System.out.println("\t기간은 최대 5개월까지 가능합니다.");
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("\t");

		}
		
		//4-3 매출 관리 범위 그래프 출력
		public static void recordSaleGraph() {
			
			// 월별 매출 데이터
		    int[] sales = { 120000000, 70000000, 80000000, 74000000, 74000000}; // 월별 매출
		    String[] months = { "2024-08", "2024-09", "2024-10", "2024-11", "2024-12"};  // 월별 이름

		    // 매출이 표시되는 최대 높이 (가장 큰 매출에 대한 높이)
		    int maxHeight = 15;

		    // Header 출력
		    Header logo = new Header();
		    logo.Logo();
		    System.out.println("\t\t\t\t\t     관리자 메인페이지/매출 관리/매출 조회");
		    System.out.println("=================================================================================");

		    // 각 월의 매출을 "■"로 표현하기 위해 비례 계산
		    int[] heights = new int[sales.length];
		    for (int i = 0; i < sales.length; i++) {
		        heights[i] = (int) ((double) sales[i] / 120000000 * maxHeight); // 최대값을 15로 설정
		    }

		    // 그래프를 위에서 아래로 출력
		    for (int i = maxHeight; i > 0; i--) {
		        // 각 월에 대해 현재 높이가 i 이상인 경우 "■"를 출력
		        for (int j = 0; j < sales.length; j++) {
		            if (heights[j] >= i) {
		                System.out.print("\t■■"); // 그래프의 막대
		            } else {
		                System.out.print("\t"); // 비어 있는 부분
		            }
		            // Add extra space to align with date format
	                System.out.print("\t");
		        }
		        System.out.println(); // 줄 바꿈
		    }

		    // 년도와 월 출력 (아래에 년도와 월을 출력)
		    System.out.println("=================================================================================");
		    for (String month : months) {
		        System.out.print("    [" + month + "]   "); // 각 월을 출력
		    }
		    System.out.println(); // 줄 바꿈

		    for(int i=0; i<sales.length; i++) {
		    	System.out.printf("%4s%,d원","",sales[i]);
		    }
		    System.out.println();
		    System.out.println("=================================================================================");
		    System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		    System.out.println("\t");
		}

}
