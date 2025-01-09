package com.fnsms.emp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fnsms.view.CalendarView;

public class EmpDateService {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, List<String>> reservations = new HashMap<>();

    //3-2-1 날짜 검색, 달력을 출력해서 날짜를 받는다.
    public void viewByDate() {
		
    	CalendarView calendarView = new CalendarView();
		calendarView.start();
	    
    }

    //다음화면에 출력될 이름의 예시
    public void initializeSampleReservations(String date) {
        List<String> sampleNames = Arrays.asList("홍길동", "", "강호동", "이수근", "", "", "", "", "", "", "", "");
        reservations.put(date, sampleNames);
    }
    
    //3-2-1-1 날짜를 선택할 경우
    public void viewReservationDetails(String date) {
        System.out.println("============================================");
        System.out.printf("%s 김계란 PT님의 예약 현황입니다.%n", date);

        // 예약 현황 표시
        List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
        for (int i = 0; i < times.size(); i++) {
            System.out.printf("- %02d시 %s%n", 9 + i, times.get(i).isEmpty() ? "" : times.get(i));
        }

        System.out.println("============================================");
        System.out.println("1. 예약 추가하기");
        System.out.println("2. 예약 변경하기");
        System.out.println("3. 예약 취소하기");
        System.out.println("\n(메인으로 돌아가려면 #을 입력해주세요.)");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                addReservation(date);
                break;
            case "2":
                updateReservation(date);
                break;
            case "3":
                cancelReservation(date);
                break;
            case "#":
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
        }
    }

    private void addReservation(String date) {
        System.out.println("추가할 시간을 입력해주세요 (예: 09): ");
        int time = Integer.parseInt(scanner.nextLine());
        System.out.println("예약자 이름을 입력해주세요: ");
        String name = scanner.nextLine();

        List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
        times.set(time - 9, name); // 시간대 추가
        reservations.put(date, times);

        System.out.println("예약이 추가되었습니다!");
    }

    private void updateReservation(String date) {
        System.out.println("변경할 시간을 입력해주세요 (예: 09): ");
        int time = Integer.parseInt(scanner.nextLine());
        System.out.println("새 예약자 이름을 입력해주세요: ");
        String name = scanner.nextLine();

        List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
        times.set(time - 9, name); // 시간대 변경
        reservations.put(date, times);

        System.out.println("예약이 변경되었습니다!");
    }

    private void cancelReservation(String date) {
        System.out.println("취소할 시간을 입력해주세요 (예: 09): ");
        int time = Integer.parseInt(scanner.nextLine());

        List<String> times = reservations.getOrDefault(date, new ArrayList<>(Collections.nCopies(12, "")));
        times.set(time - 9, ""); // 시간대 취소
        reservations.put(date, times);

        System.out.println("예약이 취소되었습니다!");
    }
}
