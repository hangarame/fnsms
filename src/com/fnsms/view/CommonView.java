package com.fnsms.view;

import java.util.Calendar;

public class CommonView {

	//로그인하기전 출력될 문구
	public static void printLogin() {
		Calendar now = Calendar.getInstance();
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃\t\t쌍용헬스장1호점\t[\t영업시간:09:00~21:00\t]\t\t┃");                                
		System.out.printf( "┃\t\t\t%2tY년\t%2tm월\t%2td일\t\t%2tH시%2tM분\t\t\t┃\r\n",now,now,now,now,now);
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃\t쌍용헬스장에\t오신것을\t\t환영합니다!\t\t\t\t┃");
		System.out.println("┃\t이용할\t서비스를\t\t선택해\t주세요.\t\t\t\t\t┃");
		System.out.println("┃	┌───────────────┐  	┌───────────────┐  	┌───────────────┐	┃");
		System.out.println("┃	│\t\t│\t│\t\t│\t│\t\t│\t┃");
		System.out.println("┃	│(1)회원\t\t│\t│(2)강사\t\t│\t│(3)관리자\t│\t┃");
		System.out.println("┃	│\t\t│\t│\t\t│\t│\t\t│\t┃");
		System.out.println("┃	└───────────────┘  	└───────────────┘  	└───────────────┘	┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃\t\t\t\t\t\t\t\t\t\t┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(  " 선택 : ");
		System.out.println();
		System.out.println();
		
	}
	
	public static void printLoginFailed() {
		Calendar now = Calendar.getInstance();
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃\t\t쌍용헬스장1호점\t[\t영업시간:09:00~21:00\t]\t\t┃");                                
		System.out.printf( "┃\t\t\t%2tY년\t%2tm월\t%2td일\t\t%2tH시%2tM분\t\t\t┃\r\n",now,now,now,now,now);
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃\t쌍용헬스장에\t오신것을\t\t환영합니다!\t\t\t\t┃");
		System.out.println("┃\t이용할\t서비스를\t\t선택해\t주세요.\t\t\t\t\t┃");
		System.out.println("┃	┌───────────────┐  	┌───────────────┐  	┌───────────────┐	┃");
		System.out.println("┃	│\t\t│\t│\t\t│\t│\t\t│\t┃");
		System.out.println("┃	│(1)회원\t\t│\t│(2)강사\t\t│\t│(3)관리자\t│\t┃");
		System.out.println("┃	│\t\t│\t│\t\t│\t│\t\t│\t┃");
		System.out.println("┃	└───────────────┘  	└───────────────┘  	└───────────────┘	┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃\t※아이디\t또는\t비밀번호가\t잘못되었습니다.\t\t\t\t┃");
		System.out.println("┃\t※아이디와\t비밀번호를\t정확히\t입력해주세요.\t\t\t┃");
		System.out.println("┃\t\t\t\t\t\t\t\t\t\t┃");
		System.out.println("┃\tID\t:\t회원명\t\t\t\t\t\t\t┃");
		System.out.println("┃\tPW\t:\t●\t+\t일련번호\t\t\t\t\t┃");
		System.out.println("┃\t(●:회원은m,강사는i,관리자는a를입력해주세요.)\t\t\t\t┃");
		System.out.println("┃\t\t\t\t\t\t\t\t\t\t┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(  " 선택 : ");
		System.out.println();
		System.out.println();
		
	}
	
	public static void printLogout() {
		Calendar now = Calendar.getInstance();
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃\t\t쌍용헬스장1호점\t[\t영업시간:09:00~21:00\t]\t\t┃");                                
		System.out.printf( "┃\t\t\t%2tY년\t%2tm월\t%2td일\t\t%2tH시%2tM분\t\t\t┃\r\n",now,now,now,now,now);
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃\t홍길동님이\t로그아웃되었습니다.\t\t\t\t\t┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃                                                                    		┃");
		System.out.println("┃\t\t\t\t\t\t\t\t\t\t┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(  " 선택 : ");
		System.out.println();
		System.out.println();
	
	}
	
	//이번달 달력 출력
	public static void printCalendar() {
		Calendar now = Calendar.getInstance();
		System.out.println();
	}
	
}
