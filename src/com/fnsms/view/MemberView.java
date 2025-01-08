package com.fnsms.view;

import java.util.Calendar;

public class MemberView implements ConsoleColor {
	
	
	//오늘의 년도와 달
	public static Calendar now = Calendar.getInstance();

	// 회원 로그인 베너 출력
	public static void memPrintBanner() {
		

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
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
		System.out.println("┃"+bWHITE+tBLACK+"\t\tID\t:\t\t\t\t\t\t\t\t"+RESET+"┃");//
		System.out.println("┃"+bWHITE+tBLACK+"\t\tPW\t:\t\t\t\t\t\t\t\t"+RESET+"┃");//
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//1
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//2
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//3
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//4
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//7
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//8
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//9
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+RESET);
		System.out.println();
		System.out.println();
	}

	
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
		System.out.println();
		System.out.println();
		System.out.println();
       
	}
	
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
       
       //오늘 날짜 설정
       Calendar today = Calendar.getInstance();
       
		
       // 전체 이용일 계산
       long totalDays = (endDate.getTimeInMillis() - startDate.getTimeInMillis()) / (1000 * 60 * 60 * 24);

       // 남은 일수 계산
       long remainingDays = (endDate.getTimeInMillis() - today.getTimeInMillis()) / (1000 * 60 * 60 * 24);
       
       Header logo = new Header();
       logo.Logo();
       System.out.println("=================================================================================");
       System.out.printf("\t%s님은 '%s%s'을 이용중입니다.\n",name,towel ? "(운)":"", ticket);
       System.out.printf("\t남은 횟수는 %d회 입니다.\n",count);
       System.out.printf("\t이용권이 %d일 중 %d일 남았습니다.\n", totalDays, remainingDays > 0 ? remainingDays : 0);
       System.out.println("=================================================================================");
       System.out.printf("\t등록일 : %tF\n",registerDate);
       System.out.printf("\t시작일 : %tF\n",startDate);
       System.out.printf("\t종료일 : %tF\n",endDate);
       System.out.printf("\t운동복/수건 미용 : %s\n",towel?"이용함":"이용 안함");

	}
	
	public static void printDate() {
		
	}
	
	public static void ticketBreak() {
		
	}


}
