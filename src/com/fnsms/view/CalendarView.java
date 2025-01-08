package com.fnsms.view;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarView {
    private Calendar currentCal;  // 실제 현재 날짜
    private Calendar displayCal;  // 화면에 표시할 날짜
    
    public CalendarView() {
        currentCal = Calendar.getInstance();
        displayCal = (Calendar) currentCal.clone();
    }
    
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;
        
         Header logo = new Header();
         logo.Logo();
        
        // 처음에 현재 달 출력
        printCalendar();
        
        while (true) {
            System.out.println("\t다음달 일정을 보려면 \" >\"를,");
            System.out.println("\t이전달 일정을 보려면 \" <\"를,");
            System.out.println("\t이번달 일정을 보려면 \"@\"를 입력해주세요.");
            System.out.println("\t\t메인으로 돌아가려면 \"#\"을 입력해주세요.");
            System.out.print("\t입력 : ");
            input = scanner.nextLine();
            System.out.println();
            System.out.println();
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
                case "@":
                    displayCal = (Calendar) currentCal.clone();
                    printCalendar();
                    break;
                case "#":
                    System.out.println("\t메인으로 돌아갑니다(회원 페이지로 돌아가야한다).");
                    return;
                default:
                    System.out.println("\t잘못된 명령어입니다.");
                    break;
            }
        }
    }
    
    private void printCalendar() {
    	System.out.println("================================================================");
    	
        System.out.println("------------------------- " + displayCal.get(Calendar.YEAR) + "년 " + 
                          (displayCal.get(Calendar.MONTH) + 1) + "월 ----------------------------");
        System.out.println("===============================================================");
        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
        
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
            }
        }
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        CalendarView calendar = new CalendarView();
        calendar.start();
    }
}
