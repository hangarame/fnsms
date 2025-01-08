package com.fnsms.view;

import java.util.ArrayList;
import java.util.Calendar;

public class InstructorView implements ConsoleColor{
	
<<<<<<< HEAD
    static String instrutorName = "";
    static String position = "";
    static String tel = "";
    static String gender = "";
    static String birth = "";
    static int memberOfIns  = 12;
    static String memberName  = "";
    static int classTime = 00;
    static Calendar now = Calendar.getInstance();
    static String commutingRecords = "";
    static Calendar commutingCheckDate  = Calendar.getInstance();
    
		
		// 강사 로그인 베너 출력
		public static void PrintBanner() {
=======
    String name = "";
    String position = "";
    String tel = "";
    String gender = "";
    String birth = "";
    int memberOfIns  = 12;
    String memberName  = "";
	int classTime = 00;
	static Calendar now = Calendar.getInstance();

		// 강사 로그인 베너 출력
		public static void insPrintBanner() {
>>>>>>> sw

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
			System.out.println("┃"+bWHITE+tBLACK+"\t\t\t안녕하세요, <강사님>\t\t\t\t\t\t"+RESET+"┃");
			System.out.println("┃"+bWHITE+tBLACK+"\t\t\t로그인을 위해 아이디와 비밀번호를 입력해주세요.\t\t\t"+RESET+"┃");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+RESET);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}

		// 강사메인 화면
		public static void printMainMenu() {

			Header logo = new Header();
			logo.Logo();
			System.out.println("=================================================================================");
			System.out.printf("\t안녕하세요, %s %s님!\r\n", instrutorName, position);
			System.out.println();
			System.out.printf("\t연락처 : %s\r\n", tel);
			System.out.printf("\t성별 : %s\r\n", gender);
			System.out.printf("\t생년월일 : %s\r\n", birth);
			System.out.printf("\t담당 보유 회원 수 : %d명\r\n", memberOfIns);
			System.out.println("=================================================================================");
			System.out.printf("\t2025-01-06 [%s %s]님의 수업 일정입니다.\r\n", instrutorName, position);
			System.out.printf("\t- %s %d시\r\n", memberName, classTime);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t1. 근퇴기록하기");
			System.out.println("\t2. 수업 관리");
			System.out.println("\t3. 회원관리");
			System.out.println("\t4. 수업료 정산");
			System.out.println("\t(로그아웃을 하려면 E를 입력해주세요.)");
			System.out.println();
			System.out.print("\t🖙 원하는 작업을 입력하세요 :");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}

		// 근퇴 관리
		public static void printInquiryAtendance() {//결과 출력 수정
			
			now.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			Calendar startOfWeek = (Calendar) now.clone();
			Calendar endOfWeek = (Calendar) now.clone();
			endOfWeek.add(Calendar.DATE, 6);
			
			String[] commuteResult = {"출근", "출근", "출근", "출근", "출근", "출근", "출근"};
			
			Header logo = new Header();
			logo.Logo();
			System.out.println("=================================================================================");
			System.out.println();
			System.out.printf("\t%s %s님의 이번주 근퇴 현황입니다.(%tF~%tF)\r\n"
								,instrutorName, position, startOfWeek, endOfWeek);
			System.out.println();
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
			System.out.println("\t1. 출근 기록하기");
			System.out.println("\t2. 퇴근 기록하기");
			System.out.println("\t3. 근퇴 기록 조회하기");
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println();
			System.out.println("\t🖙 원하는 작업을 입력하세요 : ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

		}
		
		//출근 기록하기
		public static void printAtendancePunchIn() {
			Header logo = new Header();
			logo.Logo();
			System.out.println("=================================================================================");
			System.out.printf("%s %s %tF %tT 출근되었습니다.\r\n", instrutorName, position, now, now);
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println();
			System.out.println("\t🖙 원하는 작업을 입력하세요 : ");
			System.out.println();
			System.out.println();
			System.out.println();
			
			
		}

		//퇴근 기록하기
		public static void printAtendancePunchOut() {
			
			System.out.println("=================================================================================");
			System.out.printf("\t%s %s %tF %tT 퇴근되었습니다.\r\n", instrutorName, position, now, now);
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("=================================================================================");
			
		}
		
		//근퇴기록 조회하기
		public static void printCheckAttendanceRecord() {
//			-> 25-01-06 14:38 출근 , 25-01-06 21:00 퇴근 "지각"입니다. 로 출력
//			 예외처리 -> 년-월-일(YYYY-MM-DD) 을 맞춰서 입력해주세요.

			System.out.println("=================================================================================");
			System.out.printf("\t%s %s님의 근퇴기록을 조회할 날짜를 입력해주세요(YYYY-MM-DD)\r\n", instrutorName, position);
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("=================================================================================");
			System.out.print("\t날짜(YYYY-MM-DD) :");
			
		}
		
		//근퇴기록 결과판단하기
		public static void printCheckAttendanceRecordResult() {
//			-> 25-01-06 14:38 출근 , 25-01-06 21:00 퇴근 "지각"입니다. 로 출력
//			 예외처리 -> 년-월-일(YYYY-MM-DD) 을 맞춰서 입력해주세요.
			
			System.out.println("=================================================================================");
			System.out.printf("\t조회하신 [%tF] %s님의 근퇴결과는 [%s]입니다.\r\n", commutingCheckDate, instrutorName, commutingRecords);
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("=================================================================================");
			
		}
		
		// 수업관리 출력
		public static void printInquiryClass() {

		}
		
		// 수업예약 출력
		public static void printAddReservClass() {
			
		}
		
		//수업변경 출력
		public static void printEditReservClass() {

		}
		
		//수업취소 출력
		public static void printDeleteReservClass() {

		}

}
