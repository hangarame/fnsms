package com.fnsms.view;

import java.util.Calendar;

public class CommonView {
	
	
	// 글자 색상
	public static final String tBLACK = "\033[30m"; // 검정
	public static final String tRED = "\033[31m"; // 빨강
	public static final String tGREEN = "\033[32m"; // 초록
	public static final String tYELLOW = "\033[33m"; // 노랑
	public static final String tBLUE = "\033[34m"; // 파랑
	public static final String tMAGENTA = "\033[35m"; // 자주색
	public static final String tCYAN = "\033[36m"; // 청록색
	public static final String tWHITE = "\033[37m"; // 흰색
	// 배경 색상
	public static final String bRED = "\033[41m"; // 빨강 배경
	public static final String bGREEN = "\033[42m"; // 초록 배경
	public static final String bYELLOW = "\033[43m"; // 노란 배경
	public static final String bBULE = "\033[44m"; // 파랑 배경
	public static final String bMAGENTA = "\033[45m"; // 자주색 배경
	public static final String bCAYN = "\033[46m"; // 청록색 배경
	public static final String bWHITE = "\033[47m"; // 흰색 배경
	// 특수효과
	public static final String BOLD = "\033[1m"; // 굵게
	public static final String UNDERLINE = "\033[4m"; // 밑줄

	// 효과 초기화
	public static final String RESET = "\033[0m";
	
	//오늘의 년도와 달
	public static Calendar now = Calendar.getInstance();
	public static int year = now.get(Calendar.YEAR);
	public static int month = now.get(Calendar.MONTH) + 1;

	
	//로그인하기전 출력될 문구
	public static void printLogin() {
		
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
		System.out.println("┃"+bWHITE+tBLACK+"\t\t\t쌍용 헬스장에 오신것을 환영합니다!!!\t\t\t\t"+RESET+"┃");
		System.out.println("┃"+bWHITE+tBLACK+"\t\t\t이용할 서비스를 선택해주세요.\t\t\t\t\t"+RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"┌───────────────┐"+RESET+bWHITE+"  \t"+RESET+bBULE+"┌───────────────┐"+RESET+bWHITE+"  \t"+RESET+bBULE+"┌───────────────┐"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"│   (1)회원\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│   (2)강사\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│   (3)관리자\t│"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"└───────────────┘"+RESET+bWHITE+"  \t"+RESET+bBULE+"└───────────────┘"+RESET+bWHITE+"  \t"+RESET+bBULE+"└───────────────┘"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//1
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//2
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//3
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//4
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//5
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//6
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//7
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//8
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//9
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+RESET);
		System.out.print(  bYELLOW+tBLACK+" "+UNDERLINE+"선택 : "+RESET);
		System.out.println();
		System.out.println();

		
	}
	
	public static void printLoginFailed() {
		
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
		System.out.println("┃"+bWHITE+tBLACK+"\t\t\t쌍용 헬스장에 오신것을 환영합니다!!!\t\t\t\t"+RESET+"┃");
		System.out.println("┃"+bWHITE+tBLACK+"\t\t\t이용할 서비스를 선택해주세요.\t\t\t\t\t"+RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"┌───────────────┐"+RESET+bWHITE+"  \t"+RESET+bBULE+"┌───────────────┐"+RESET+bWHITE+"  \t"+RESET+bBULE+"┌───────────────┐"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"│   (1)회원\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│   (2)강사\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│   (3)관리자\t│"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t│"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t"+RESET+bBULE+"└───────────────┘"+RESET+bWHITE+"  \t"+RESET+bBULE+"└───────────────┘"+RESET+bWHITE+"  \t"+RESET+bBULE+"└───────────────┘"+RESET+bWHITE+ "\t\t" +RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//1
		System.out.println("┃"+bWHITE+tBLACK+"\t\t※아이디 또는 비밀번호가 잘못되었습니다.\t\t\t\t\t"+RESET+"┃");//2
		System.out.println("┃"+bWHITE+tBLACK+"\t\t※아이디와 비밀번호를 정확히 입력해주세요.\t\t\t\t\t"+RESET+"┃");//3
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//4
		System.out.println("┃"+bWHITE+tBLACK+"\t\tID\t:\t회원명\t\t\t\t\t\t\t"+RESET+"┃");//5
		System.out.println("┃"+bWHITE+tBLACK+"\t\tPW\t:\t ●  +  일련번호(8자리)\t\t\t\t\t"+RESET+"┃");//6
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//7
		System.out.println("┃"+bWHITE+tBLACK+"\t\t(●:회원은m,강사는i,관리자는a를입력해주세요.)\t\t\t\t"+RESET+"┃");//8
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//9
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(bYELLOW+tBLACK+" "+UNDERLINE+"선택 : "+RESET);
		System.out.println();
		System.out.println();
		
	}
	
	public static void printLogout() {

		
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
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┃"+bWHITE+tBLACK+"\t\t\t[홍길동님]이\t로그아웃되었습니다.\t\t\t\t"+RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(  " 선택 : ");
		System.out.println();
		System.out.println();
	
	}
	
	//이번달 달력 출력
	public static void printCalendar(int year, int month) {
		
    	Header logo = new Header();
    	logo.Logo();
    	
        // 해당 월의 1일로 설정
        now.set(Calendar.DAY_OF_MONTH, 1);
        
        // 해당 월의 최대 일수 구하기
        int maxDays = now.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // 1일의 요일 구하기 (1:일요일, 2:월요일, ..., 7:토요일)
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
        
        // 달력 헤더 출력
        System.out.println("\n\t" + year + "년 " + month + "월");
        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
        
        // 1일의 요일만큼 탭으로 공백 추가
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("\t");
        }
        
        // 날짜 출력
        for (int day = 1; day <= maxDays; day++) {
            System.out.printf("\t%2d",day);
            
            // 토요일이면 줄바꿈
            if ((dayOfWeek + day - 1) % 7 == 0) {
                System.out.println();
            }
        }
        
        // 마지막 줄 처리
        if ((dayOfWeek + maxDays - 1) % 7 != 0) {
            System.out.println();
        }

	}
	
		//저번달 혹은 이번달 달력 출력
//		public static void printCalendar(String string) {
//			
//	    	Header logo = new Header();
//	    	logo.Logo();
//	    	
//			// 현재 년도와 월 가져오기
//	        int year = now.get(Calendar.YEAR);
//	        int month = now.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 1을 더함
//	        
//	        if(string.equals(">")) {
//	        	month += 1;
//	        	printCalendar();
//	        }else if(string.equals("<")) {
//	        	month -=1;
//	        }else if(string.equals("@")) {
//				printCalendar();
//			}
//	        
//	        // 해당 월의 1일로 설정
//	        now.set(Calendar.DAY_OF_MONTH, 1);
//	        
//	        // 해당 월의 최대 일수 구하기
//	        int maxDays = now.getActualMaximum(Calendar.DAY_OF_MONTH);
//	        
//	        // 1일의 요일 구하기 (1:일요일, 2:월요일, ..., 7:토요일)
//	        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
//	        
//	        // 달력 헤더 출력
//	        System.out.println("\n\t" + year + "년 " + month + "월");
//	        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
//	        
//	        // 1일의 요일만큼 탭으로 공백 추가
//	        for (int i = 1; i < dayOfWeek; i++) {
//	            System.out.print("\t");
//	        }
//	        
//	        // 날짜 출력
//	        for (int day = 1; day <= maxDays; day++) {
//	            System.out.printf("\t%2d",day);
//	            
//	            // 토요일이면 줄바꿈
//	            if ((dayOfWeek + day - 1) % 7 == 0) {
//	                System.out.println();
//	            }
//	        }
//	        
//	        // 마지막 줄 처리
//	        if ((dayOfWeek + maxDays - 1) % 7 != 0) {
//	            System.out.println();
//	        }
//
//		}

	
}
