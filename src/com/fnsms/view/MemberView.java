package com.fnsms.view;

import java.util.Calendar;

public class MemberView implements ConsoleColor {
	
	
	//오늘의 년도와 달
	public static Calendar now = Calendar.getInstance();

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
		System.out.println("┃"+bWHITE+tBLACK+"\t\t\t안녕하세요, <회원님>\t\t\t\t\t\t"+RESET+"┃");
		System.out.println("┃"+bWHITE+tBLACK+"\t\t\t로그인을 위해 아이디와 비밀번호를 입력해주세요.\t\t\t"+RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+RESET);
		System.out.println();
		System.out.println();
	}
	
	
	

	//화면 설계2, 회원일경우 메인화면
	public static void printMainmenu() {
		
		 String name = "홍길동";
		 String tel = "010-1234-2345";
		 String gender = "남성";
		 String birth = "1980-03-02";
		 
		 //boolean 값이 참이면 (운)
		 boolean towel = true;
		 String ticket = "PT 10회 이용권";
		 int count = 8;
		 
		
        // 종료일 설정 (예: 2025년 1월 30일)
        Calendar endDate = Calendar.getInstance();
        endDate.set(2025, Calendar.JANUARY, 30);
        

		Header logo = new Header();
        logo.Logo();
        System.out.println("=================================================================================");
        System.out.printf("\t안녕하세요 %s님!\n",name);
        System.out.println("");
        System.out.printf("\t연락처 : %s\n",tel);
        System.out.printf("\t성별 : %s\n",gender);
        System.out.printf("\t생년월일 : %s\n",birth);
        System.out.println("=================================================================================");
        System.out.printf("\t%s님은 '%s%s'을 이용중입니다.\n",name,towel ? "(운)":"", ticket);
        System.out.printf("\t남은 횟수는 %d입니다.\n",count);
        System.out.printf("\t%s%s의 만료일은 %tF입니다.\n",towel,ticket,endDate);
        System.out.println("=================================================================================");
        System.out.println("\t1. 이용권 정보 조회");
		System.out.println("\t2. 예약 조회");
		System.out.println("\t(로그아웃을 하려면 \"E\"를 입력해주세요.)");
		System.out.print("원하는 작업의 번호를 입력해주세요 : ");
		System.out.println();
		System.out.println();
		System.out.println();
       
	}
	//화면 설계 2-1에서 윗 3줄(중복됨)
	public static void printUsingTicket() {
		
		String name = "홍길동";
		 
		 //boolean 값이 참이면 (운)
		 boolean towel = true;
		 String ticket = "PT 10회 이용권";
		 int count = 8;
		 
		// 등록일 설정 (예: 2025년 1월 1일)
       Calendar registerDate = Calendar.getInstance();
       registerDate.set(2025, Calendar.JANUARY, 1);

		 
		// 시작일 설정 (예: 2025년 1월 1일)
       Calendar startDate = Calendar.getInstance();
       startDate.set(2025, Calendar.JANUARY, 1);

       // 종료일 설정 (예: 2025년 1월 30일)
       Calendar endDate = Calendar.getInstance();
       endDate.set(2025, Calendar.JANUARY, 30);
       
		
       // 전체 이용일 계산
       long totalDays = (endDate.getTimeInMillis() - startDate.getTimeInMillis()) / (1000 * 60 * 60 * 24);

       // 남은 일수 계산
       long remainingDays = (endDate.getTimeInMillis() - now.getTimeInMillis()) / (1000 * 60 * 60 * 24);
       
       Header logo = new Header();
       logo.Logo();
       System.out.println("=================================================================================");
       System.out.printf("\t%s님은 '%s%s'을 이용중입니다.\n",name,towel ? "(운)":"", ticket);
       System.out.printf("\t남은 횟수는 %d회 입니다.\n",count);
       System.out.printf("\t이용권이 %d일 중 %d일 남았습니다.\n", totalDays, remainingDays > 0 ? remainingDays : 0);
       System.out.println("=================================================================================");
       

	}
	
	//화면설계서 2-1
	public static void printDate() {
		
		printUsingTicket();
		
		//boolean 값이 참이면 (운)
		boolean towel = true;
		String ticket = "PT 10회 이용권";
		int count = 8;
		 
	 // 등록일 설정 (예: 2025년 1월 1일)
      Calendar registerDate = Calendar.getInstance();
      registerDate.set(2025, Calendar.JANUARY, 1);

		 
      // 시작일 설정 (예: 2025년 1월 1일)
      Calendar startDate = Calendar.getInstance();
      startDate.set(2025, Calendar.JANUARY, 1);

      // 종료일 설정 (예: 2025년 1월 30일)
      Calendar endDate = Calendar.getInstance();
      endDate.set(2025, Calendar.JANUARY, 30);
		
      System.out.printf("\t등록일 : %tF\n",registerDate);
      System.out.printf("\t시작일 : %tF\n",startDate);
      System.out.printf("\t종료일 : %tF\n",endDate);
      System.out.printf("\t운동복/수건 이용 : %s\n",towel?"이용함":"이용 안함");
      System.out.println("=================================================================================");
      System.out.println("\t이용권 휴회가 필요하신가요?(y/n)");
      System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
      //n을 누른경우도 메인으로 돌아감
      System.out.print("\t입력 : ");
      System.out.println();
      System.out.println();
      System.out.println();
	}
	
	public static void ticketBreak() {
		printUsingTicket();
		int possible_break=5;
		System.out.printf("\t회원님은 최대 %d일 휴회가 가능합니다.\n",possible_break);
		System.out.println("\t며칠 휴회하시겠습니까?)");
		System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
		System.out.print("\t입력 : ");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
	public static void ticketBreakSuccess() {
		Header logo = new Header();
        logo.Logo();
        int breaktime=2; //입력받은 휴회일
        
        System.out.println("=================================================================================");
		System.out.printf("\t신청하신 %d일 휴회가 등록되었습니다.\n",breaktime);
		System.out.printf("\t홍길동 회원님은 %tF ~ %tF일 이용이 가능합니다.\n",now,now);
		System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
		System.out.print("\t입력 : ");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
	public static void ticketBreakFailed() {
		Header logo = new Header();
        logo.Logo();
		int possible_break=5;
		System.out.printf("\t회원님은 최대 %d일 휴회가 가능합니다.\n",possible_break);
		System.out.printf("\t%d일 이내의 숫자를 입력해주세요.\n ",possible_break);
		System.out.println("\t(메인으로 돌아가려면 '#'을 입력해주세요.)");
		System.out.print("\t입력 : ");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}


}
