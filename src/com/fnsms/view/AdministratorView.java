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

		// 회원 로그인 베너 출력
		public static void PrintBanner() {

			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t"+RESET+BOLD+UNDERLINE+"SSANGYONG FITNESS"+RESET+bWHITE+"\t\t\t\t\t"+RESET+"┃");                                
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t"+RESET+"[ 운영 시간 : 09:00 ~ 21:00 ]"+bWHITE+"\t\t"+RESET+"┃");                                
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
			System.out.printf( "┃"+bWHITE+tBLACK+"\t\t\t\t\t\t\t%2tY년  %2tm월  %2td일  %2tH시  %2tM분\t"+RESET+"┃\r\n",now,now,now,now,now);
			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
			System.out.println("┃"+bWHITE+tBLACK+"\t\t\t안녕하세요, <관리자님>\t\t\t\t\t\t"+RESET+"┃");
			System.out.println("┃"+bWHITE+tBLACK+"\t\t\t로그인을 위해 아이디와 비밀번호를 입력해주세요.\t\t\t"+RESET+"┃");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+RESET);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
		
		//화면 설계4, 관리자일경우 메인화면
		public static void printMainmenu() {

			Header logo = new Header();
	        logo.Logo();
	        System.out.println("=================================================================================");
	        System.out.printf("\t안녕하세요 %s 관리자님!\n",mem_name);
	        System.out.println();
	        System.out.printf("\t연락처 : %s\n",tel);
	        System.out.printf("\t성별 : %s\n",gender);
	        System.out.printf("\t생년월일 : %s\n",birth);
	        System.out.println("=================================================================================");
	        System.out.println("\t1. 강사 관리");
			System.out.println("\t2. 회원 관리");
			System.out.println("\t3. 매출 관리");
			System.out.println("\t(로그아웃을 하려면 \"E\"를 입력해주세요.)");
			System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
	       
		}
		
		//4-1 강사관리
		public static void instructorManagement()	{
			Header logo = new Header();
	        logo.Logo();
	        
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
			System.out.println("\t조회할 강사님의 사번을 적어주세요 : ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
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
			System.out.println("\t조회할 강사님의 사번을 적어주세요 : ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
		}
		
		//강사 선택 성공
		//4-1-1 강사를 선택한 후(아무개 선택이라고 가정)
		public static void selectInstructor() {
			Header logo = new Header();
	        logo.Logo();
	        System.out.println("=================================================================================");
	        System.out.printf("\t%s %s님을 선택하셨습니다.\n",in_name[0],position[0]);
	        System.out.println("=================================================================================");
	        System.out.println();
	        System.out.println("\t1. 근퇴 기록 관리");
	        System.out.println("\t2. 수업 관리");
	        System.out.println("\t3. 수업료 정산");
	        System.out.println("\t(메인으로 돌아가려면 #을 입력하세요.)");
	        System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        
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
            System.out.println("\t1. 근퇴 기록 조회하기");
            System.out.println("\t2. 근퇴 기록 수정하기");
            System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
            System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
			
		}
		
		
		

}
