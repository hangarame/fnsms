package com.fnsms.emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fnsms.instructor.InstructorService;
import com.fnsms.view.CalendarView;
import com.fnsms.view.Header;

public class EmpDateService {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, List<String>> reservations = new HashMap<>();
    
    
   
    //3-2-1 날짜 검색, 달력을 출력해서 날짜를 받는다.
    public void viewByDate(String instructorName) {
		
    	CalendarView calendarView = new CalendarView();
		calendarView.start(instructorName);
	    
    }

    //다음화면에 출력될 이름의 예시
    public void initializeSampleReservations(String date) {
    	// 해당 날짜의 예약 데이터를 설정
        if (!reservations.containsKey(date)) {
            reservations.put(date, new ArrayList<>(List.of(
                "홍길동", "", "가동석", "", "", "이수근",
                "", "서건훈", "고건아", "허아후", "", ""
            )));
        }
    }
    
    //3-2-1-1 날짜를 선택할 경우
    public void viewReservationDetails(String date) {
    	// 예약 데이터 초기화 (필요 시)
        initializeSampleReservations(date);
        Header logo = new Header();
        logo.Logo();
        System.out.println("=================================================================================");
        System.out.printf("\t%s 김계란 PT님의 예약 현황입니다.%n", date);

        // 예약 현황 표시
        List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
        for (int i = 0; i < times.size(); i++) {
            System.out.printf("\t- %02d시 %s%n", 9 + i, times.get(i).isEmpty() ? "" : times.get(i));
        }

        System.out.println("=================================================================================");
        System.out.println("\n\t(메인으로 돌아가려면 #을 입력해주세요.)");
        System.out.println("\t1. 예약 추가하기");
        System.out.println("\t2. 예약 변경하기");
        System.out.println("\t3. 예약 취소하기");
        System.out.println();
        
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;
        
        while(isRunning) {
        	System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
   
        	String input = scan.nextLine();

//	        switch (input) {
//	            case "1":
//	                addReservation(date);
//	                break;
//	            case "2":
//	                updateReservation(date);
//	                break;
//	            case "3":
//	                cancelReservation(date);
//	                break;
//	            case "#":
//	            	System.out.println();
//	            	System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
//	                scan.nextLine(); // 엔터 입력 대기
//	                isRunning  = false;
//	                InstructorService.classManagement();
//	                break;
//	        default:
//	            System.out.println("\t올바른 입력이 아닙니다. 다시 시도해주세요.");
//	        }
        	
        	if(input.equals("1")) {
        		addReservation(date);
        	}else
        	if(input.equals("1")) {
            		addReservation(date);
            }else if(input.equals("2")) {
            	updateReservation(date);
            }else if(input.equals("3")) {
            	cancelReservation(date);
        	}else if(input.equals("#")) {
        		System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
                scan.nextLine(); // 엔터 입력 대기
                isRunning = false;
        		InstructorService ins = new InstructorService();
        		ins.instructorMainMenu();
        	}else {
        		System.out.println("\t올바른 입력이 아닙니다. 다시 시도해주세요.");
//    	        
        	}
        }
        
    }

    private void addReservation(String date) {
    	Header logo = new Header();
        logo.Logo();
        System.out.println("=================================================================================");
         System.out.printf("\t%s 김계란 PT님의 예약 현황입니다.%n", date);

         // 예약 현황 표시
         List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
         for (int i = 0; i < times.size(); i++) {
             System.out.printf("\t- %02d시 %s%n", 9 + i, times.get(i).isEmpty() ? "" : times.get(i));
         }

         System.out.println("=================================================================================");
         System.out.println("\t추가할 시간과 회원을 입력해주세요.");
         try {
             // 시간 입력
             System.out.print("\t시간: ");
             int time = Integer.parseInt(scanner.nextLine());

             // 유효성 검사
             if (time < 9 || time > 20) {
            	 System.out.println();
                 System.out.println("\t※시간은 09시부터 20시 사이로 입력해주세요!");
                 System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
                 scanner.nextLine(); // 엔터 입력 대기
                 viewReservationDetails(date); 
                 return;
             }

             // 예약자 이름 입력
             System.out.print("\t회원 이름: ");
             String name = scanner.nextLine();

             // 해당 시간에 이미 예약이 있는지 확인
             if (!times.get(time - 9).isEmpty()) {
            	 System.out.println();
                 System.out.printf("\t%02d시에 이미 예약된 회원(%s)이 있습니다.%n", time, times.get(time - 9));
                 System.out.println("\t예약을 덮어쓰시겠습니까? (y/n)");
                 String overwrite = scanner.nextLine();
                 if (!overwrite.equalsIgnoreCase("y")) {
                	 System.out.println();
                     System.out.println("\t예약 추가가 취소되었습니다.");
                     System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
                     scanner.nextLine(); // 엔터 입력 대기
                     viewReservationDetails(date); 
                     return;
                 }
             }

             // 예약 추가
             times.set(time - 9, name);
             reservations.put(date, times);
             System.out.println();
             System.out.println("\t예약이 성공적으로 추가되었습니다!");
             System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
             scanner.nextLine(); // 엔터 입력 대기
             
             viewReservationDetails(date); 
             
         } catch (NumberFormatException e) {
             System.out.println("\t유효한 시간을 입력해주세요. (예: 09)");
         
         }
    }



    private void updateReservation(String date) {
    	Header logo = new Header();
        logo.Logo();
        System.out.println("=================================================================================");
         System.out.printf("\t%s 김계란 PT님의 예약 현황입니다.%n", date);

         // 예약 현황 표시
         List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
         for (int i = 0; i < times.size(); i++) {
             System.out.printf("\t- %02d시 %s%n", 9 + i, times.get(i).isEmpty() ? "" : times.get(i));
         }

         System.out.println("=================================================================================");
         System.out.println("\t변경할 시간과 회원을 입력해주세요.");
        
         try {
             // 시간 입력
             System.out.print("\t시간: ");
             int time = Integer.parseInt(scanner.nextLine());

             // 유효성 검사
             if (time < 9 || time > 20) {
            	 System.out.println();
                 System.out.println("\t※시간은 09시부터 20시 사이로 입력해주세요!");
                 System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
                 scanner.nextLine(); // 엔터 입력 대기
                 viewReservationDetails(date); 
                 return;
             }

             // 예약자 이름 입력
             System.out.print("\t회원 이름: ");
             String name = scanner.nextLine();

             // 기존 예약 확인
             String currentReservation = times.get(time - 9);
             if (currentReservation.isEmpty()) {
            	 System.out.println();
                 System.out.printf("\t%02d시에 기존 예약이 없습니다. 새로 예약을 추가합니다.%n", time);
             } else {
            	 System.out.println();
                 System.out.printf("\t%02d시의 기존 예약(%s)을 변경합니다.%n", time, currentReservation);
             }

             // 예약 변경
             times.set(time - 9, name);
             reservations.put(date, times);

             System.out.println("\t예약이 성공적으로 추가되었습니다!");
             System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
             scanner.nextLine(); // 엔터 입력 대기
             
             viewReservationDetails(date); 
             
            
         } catch (NumberFormatException e) {
             System.out.println("\t유효한 시간을 입력해주세요. (예: 09)");
             viewReservationDetails(date); // 이전 메뉴로 돌아가기
         }
         
    }

    private void cancelReservation(String date) {
    	Header logo = new Header();
        logo.Logo();
        System.out.println("\t\t\t\t\t\t\t강사 메인페이지/수업 조회/예약 취소");
        System.out.println("=================================================================================");
         System.out.printf("\t%s 김계란 PT님의 예약 현황입니다.%n", date);

         // 예약 현황 표시
         List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
         for (int i = 0; i < times.size(); i++) {
             System.out.printf("\t- %02d시 %s%n", 9 + i, times.get(i).isEmpty() ? "" : times.get(i));
         }

         System.out.println("=================================================================================");
         System.out.print("\t취소할 시간을 입력해주세요. : ");
         int time = Integer.parseInt(scanner.nextLine());
         
         // 유효한 시간인지 확인
         if (time < 9 || time > 20) {
        	 System.out.println();
             System.out.println("\t※시간은 09시부터 20시 사이로 입력해주세요!ㄴ");
             System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
             scanner.nextLine(); // 엔터 입력 대기
             viewReservationDetails(date); 
             return;
         }

         // 해당 시간대의 예약자가 있으면 취소
         if (!times.get(time - 9).isEmpty()) {
             times.set(time - 9, "");  // 예약 취소 (빈 문자열로 변경)
             System.out.println();
             System.out.println("\t예약이 취소되었습니다.");
             System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
             scanner.nextLine(); // 엔터 입력 대기
             viewReservationDetails(date); 
         } else {
             System.out.println("\t해당 시간에는 취소할 예약이 없습니다.");
             System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
             scanner.nextLine(); // 엔터 입력 대기
             viewReservationDetails(date);
         }

         reservations.put(date, times);  // 변경된 예약 현황 저장
         
         
    }
}
