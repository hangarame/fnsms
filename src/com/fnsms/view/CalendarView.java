package com.fnsms.view;

import java.util.Calendar;
import java.util.Scanner;

import com.fnsms.emp.EmpDateService;
import com.fnsms.instructor.InstructorService;

public class CalendarView implements ConsoleColor {
    private Calendar currentCal;  // 실제 현재 날짜
    private Calendar displayCal;  // 화면에 표시할 날짜
    
    public CalendarView() {
        currentCal = Calendar.getInstance();
        displayCal = (Calendar) currentCal.clone();
    }
    
    public void start(String empNo) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
         Header logo = new Header();
         logo.Logo();
        
        // 처음에 현재 달 출력
        printCalendar();
        
        while (true) {
        	// 현재 displayCal의 연도와 월
            int year = displayCal.get(Calendar.YEAR);
            int month = displayCal.get(Calendar.MONTH) + 1; // MONTH는 0부터 시작
            int lastDay = displayCal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 월의 마지막 날
            
            System.out.println("\t다음달 일정을 보려면 \" >\"를,");
            System.out.println("\t이전달 일정을 보려면 \" <\"를,");
            System.out.println("\t이전 화면으로 돌아가려면 \"#\"을 입력해주세요.");
            System.out.println("\t상세 예약을 보려면 날짜를 선택해주세요.");
            System.out.print("\t🖙 원하는 작업을 입력해주세요 : ");
            input = scanner.nextLine();
            System.out.println();
            
            
            switch (input) {
                case ">":
                    displayCal.add(Calendar.MONTH, 1);
                    printCalendar();
                    break;
                case "<":
                    displayCal.add(Calendar.MONTH, -1);
                    printCalendar();
                    break;
 
                case "#":
                	InstructorService.classManagement(empNo);
                    return;
                default:
                	 try {
                         int day = Integer.parseInt(input); // 숫자로 변환
                         if (day >= 1 && day <= lastDay) { // 유효한 날짜인지 확인
                             String date = String.format("%4d-%02d-%02d", 
                                 year, 
                                 month, 
                                 day);
                             EmpDateService empDateService = new EmpDateService(empNo);
//                             if(!empDateService.viewReservationDetails(date)) {
//                            	 return;
//                             }
							empDateService.viewReservationDetails(date); // 예약 상세 보기
                         } else {
                             System.out.println("\t유효한 날짜를 입력해주세요.");
                         }
                     } catch (NumberFormatException e) {
                         System.out.println("\t잘못된 입력입니다. 다시 시도해주세요.");
                     }
                     break;
             }
            
        }
    }
    
    public void printCalendar() {
    	System.out.println("=================================================================================");
    	
        System.out.println("---------------------- " + displayCal.get(Calendar.YEAR) + "년 " + 
                          (displayCal.get(Calendar.MONTH) + 1) + "월 -----------------------------------------------");
        System.out.println("=================================================================================");
        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
        System.out.println();
        System.out.println();
        // 1일의 요일을 구함
        Calendar firstDay = (Calendar) displayCal.clone();
        firstDay.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = firstDay.get(Calendar.DAY_OF_WEEK);
        
        // 해당 월의 마지막 날짜를 구함
        int lastDay = displayCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // 1일이 시작하기 전까지 탭으로 공백을 채움
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("\t");
        }
        
        // 날짜 출력
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("\t%2d",i);
            
            // 토요일이면 줄바꿈
            if ((dayOfWeek + i - 1) % 7 == 0) {
                System.out.println();
                System.out.println("\t\t");
            }
        }
        System.out.println("\n");
        System.out.println("=================================================================================");
    }
    
    
}
