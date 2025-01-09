package com.fnsms.view;

import java.util.ArrayList;
import java.util.Calendar;

public class InstructorView implements ConsoleColor {

	static ArrayList<String> instrutorName = new ArrayList<String>(); // 강사이름
	static ArrayList<String> position = new ArrayList<String>(); // 직책
	static ArrayList<String> tel = new ArrayList<String>(); // 전화번호
	static String gender = ""; // 성별
	static ArrayList<String> birth = new ArrayList<String>(); // 생년월일
	static ArrayList<Integer> memberOfIns = new ArrayList<Integer>(); // 담당회원
	static ArrayList<String> memberName = new ArrayList<String>(); // 담당회원이름
	static int classTime = 00; // 수업시간
	static Calendar now = Calendar.getInstance(); // 현재시간 전용
	static Calendar commutingCheckDate = Calendar.getInstance(); // 출퇴근 조회 날짜
	static Calendar checkInTime = Calendar.getInstance();// 출근시간
	static Calendar checkOutTime = Calendar.getInstance();// 퇴근시간
	static String[] commutingResult = {"출근", "지각", "조퇴", "결근"}; // 근퇴결과 > 출근, 지각, 조퇴, 결근

	// 강사메인 화면
	public static void printMainMenu(String insName, String position, String tel, String birth, int numberOfMngedMember, String classTime) {

		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.printf("\t안녕하세요, %s %s님!\r\n", insName, position);
		System.out.println();
		System.out.printf("\t연락처 : %s\r\n", tel);
//		System.out.println("\t성별 : 남성");
		System.out.printf("\t생년월일 : %s\r\n", birth);
		System.out.printf("\t담당 보유 회원 수 : %d명\r\n", numberOfMngedMember);
		System.out.println("=================================================================================");
		System.out.println("\t홍길동 : 9시");
		System.out.println("\t가동석 : 11시");
		System.out.println("\t이수근 : 14시");
		System.out.println("\t마동석 : 15시");
		System.out.println("\t서건훈 : 16시");
		System.out.println("\t고건아 : 17시");
		System.out.println("\t허아후 : 18시");
		System.out.println("\t문현우 : 19시");
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t1. 근퇴기록하기");
		System.out.println("\t2. 수업 관리");
		System.out.println("\t3. 회원관리");
		System.out.println("\t4. 수업료 정산");
		System.out.println("\t(로그아웃을 하려면 E를 입력해주세요.)");
		System.out.println();
//		System.out.print("\t🖙 원하는 작업을 입력하세요 :");
		
	}

	// 근퇴 관리
	public static void printInquiryAtendance(String[] commuteResult, String instrutorName, String position ) {// 결과 출력 수정

        now.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Calendar startOfWeek = (Calendar) now.clone();
        Calendar endOfWeek = (Calendar) now.clone();
        endOfWeek.add(Calendar.DATE, 6);

//        String[] commuteResult = { null, null, null, null, null, null, null };

        Header logo = new Header();
        logo.Logo();
        System.out.println("=================================================================================");
        System.out.println();
        System.out.printf("\t%s %s님의 이번주 근퇴 현황입니다.(%tF~%tF)\r\n", instrutorName, position, startOfWeek, endOfWeek);
        System.out.println();
        System.out.println("=================================================================================");
        System.out.println();
        System.out.println("\t[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
        System.out.printf("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\r\n", commuteResult[0] != null ? commuteResult[0] : "\t", commuteResult[1] != null ? commuteResult[1] : "\t" , commuteResult[2] != null ? commuteResult[2] : "\t",
                commuteResult[3] != null ? commuteResult[3] : "\t", commuteResult[4] != null ? commuteResult[4] : "\t", commuteResult[5] != null ? commuteResult[5] : "\t" , commuteResult[6] != null ? commuteResult[6] : "\t");
        System.out.println();
        System.out.println("=================================================================================");
        System.out.println();
        System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
        System.out.println("\t1. 출근 기록하기");
        System.out.println("\t2. 퇴근 기록하기");
        System.out.println("\t3. 근퇴 기록 조회하기");
        System.out.println();
        // System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

    }

	// 출근 기록하기
	public static void printAtendancePunchIn() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.printf("%s %s %tF %tT 출근되었습니다.\r\n", instrutorName, position, checkInTime, checkInTime);
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

	}

	// 퇴근 기록하기
	public static void printAtendancePunchOut() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.printf("%s %s %tF %tT 출근되었습니다.\r\n", instrutorName, position, checkOutTime, checkOutTime);
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

	}

	// 근퇴기록 조회하기
	public static void printCheckAttendanceRecord() {
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t%s %s님의 근퇴기록을 조회할 날짜를 입력해주세요.\r\n", instrutorName, position);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(YYYY-MM-DD 형식으로 '-'를 포함하는 날짜를 입력해주세요.)");
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");

	}

	// 근퇴기록 결과판단하기
	public static void printCheckAttendanceRecordResult() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.printf("\t조회하신 [%tF] %s님의 근퇴결과는 [%s]입니다.\r\n", commutingCheckDate, instrutorName, commutingResult);
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println();
	}

	public static void printCheckAttendanceRecordFailed() {

		Header logo = new Header();
		logo.Logo();
		System.out.println("\t\t\t\t\t\t\t강사 근퇴 기록 " + tRED + "조회오류" + RESET);
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t입력 형식" + UNDERLINE + "(YYYY-MM-DD)" + RESET + "을 맞춰서 입력해주세요.");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println();
		// System.out.println("\t🖙 원하는 작업을 입력하세요 : ");
	}

}
