package com.fnsms.view;

import java.util.Calendar;

public class Header {
	
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
	
	
	public void Logo() {
		// Calendar 인스턴스 생성
	    Calendar cal = Calendar.getInstance();
	    
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t"+RESET+BOLD+UNDERLINE+"SSANGYONG FITNESS"+RESET+bWHITE+"\t\t\t\t\t"+RESET+"┃");                                
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t"+RESET+"[ 운영 시간 : 09:00 ~ 21:00 ]"+bWHITE+"\t\t"+RESET+"┃");                                
		System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
		System.out.printf( "┃"+bWHITE+tBLACK+"\t\t\t\t\t\t\t%2tY년  %2tm월  %2td일  %2tH시  %2tM분\t"+RESET+"┃\r\n",cal,cal,cal,cal,cal);
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");

	}
	
	
}
