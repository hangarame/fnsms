package com.fnsms.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmpMemberService {

    // 회원 이름 중복 처리를 위한 맵
    private Map<String, List<Member>> instructorMembers = new HashMap<>();

    // 예제 데이터를 초기화
    public EmpMemberService() {
        String instructorName = "김계란";
        instructorMembers.put(instructorName, new ArrayList<>());
        
        // 회원 및 예약 데이터 추가
        instructorMembers.get(instructorName).add(new Member("김동석", "m12345678"));
        instructorMembers.get(instructorName).add(new Member("나동석", "m23456789"));
        instructorMembers.get(instructorName).add(new Member("다동석", "m34567890"));
        instructorMembers.get(instructorName).add(new Member("마동석", "m45678901", "2025-01-03 15시"));
        instructorMembers.get(instructorName).add(new Member("박동석", "m56789012"));
        instructorMembers.get(instructorName).add(new Member("심동석", "m67890123", "2025-01-24 11시"));
        instructorMembers.get(instructorName).add(new Member("이동석", "m78901234"));
        instructorMembers.get(instructorName).add(new Member("장동석", "m89012345"));
        instructorMembers.get(instructorName).add(new Member("차동석", "m90123456", "2025-01-24 15시"));
        instructorMembers.get(instructorName).add(new Member("조동석", "m01234567"));
        instructorMembers.get(instructorName).add(new Member("임동석", "m11234567"));
        instructorMembers.get(instructorName).add(new Member("하동석", "m22345678"));
    }

    // 3-2-2 회원검색
    public void viewByMember() {
        Scanner scanner = new Scanner(System.in);

        String instructorName = "김계란";
        List<Member> members = instructorMembers.get(instructorName);

        System.out.println("========================================");
        // 담당 회원 명단 출력
        System.out.println(instructorName + " PT님 담당 회원 명단입니다.");
        System.out.println("========================================");

        // 회원 중복 출력
        for (Member member : members) {
            System.out.println("- " + member.getName() + " 회원님");
        }
        System.out.println("========================================");

        // 회원 검색 기능
        String searchName = null;
        boolean validInput = false;

        // 유효성 검사를 위한 반복문
        while (!validInput) {
            System.out.print("조회할 회원 이름을 입력해주세요: ");
            searchName = scanner.nextLine();
            
            // 회원 이름 유효성 검사
            List<Member> foundMembers = new ArrayList<>();
            for (Member member : members) {
                if (member.getName().equals(searchName)) {
                    foundMembers.add(member);
                }
            }

            if (foundMembers.isEmpty()) {
                System.out.println("해당 회원은 " + instructorName + " PT님의 담당 회원이 아닙니다. 다시 시도해주세요.");
            } else {
                validInput = true;
                handleMemberSearchResult(foundMembers);
            }
        }
    }

    // 회원 검색 결과 처리
    private void handleMemberSearchResult(List<Member> foundMembers) {
        Scanner scanner = new Scanner(System.in);

        if (foundMembers.size() > 1) {
            // 동명이인 처리
            System.out.println("========================================");
            System.out.println("검색한 회원님 명단입니다.");
            System.out.println("[성함] \t [회원번호]");
            for (Member member : foundMembers) {
                System.out.println(member.getName() + "\t" + member.getMemberId());
            }
            System.out.println("========================================");
            
            // 회원번호 입력받기
            String memberId = null;
            boolean validMemberId = false;

            // 회원 번호 유효성 검사
            while (!validMemberId) {
                System.out.print("조회할 회원의 회원번호를 입력해주세요: ");
                memberId = scanner.nextLine();

                Member selectedMember = null;
                for (Member member : foundMembers) {
                    if (member.getMemberId().equals(memberId)) {
                        selectedMember = member;
                        validMemberId = true;
                        break;
                    }
                }

                if (validMemberId) {
                    viewReservationDetails(selectedMember);
                } else {
                    System.out.println("잘못된 회원번호입니다. 다시 입력해주세요.");
                }
            }
        } else {
            // 유일한 회원일 경우 바로 예약 상세 페이지 출력
            System.out.println("========================================");
            System.out.println(foundMembers.get(0).getName() + " 회원님 예약 상세 페이지 입니다.");
            viewReservationDetails(foundMembers.get(0));
        }
    }

    // 예약 상세보기
    public void viewReservationDetails(Member member) {
        if (member.getReservationTime() == null) {
            System.out.println(member.getName() + " 회원님은 예약된 시간이 없습니다.");
        } else {
            System.out.println("[날짜] \t [시간]");
            System.out.println(member.getReservationTime());
        }
        System.out.println("========================================");
        System.out.println("1. 예약 추가하기");
        System.out.println("2. 예약 변경하기");
        System.out.println("3. 예약 삭제하기");
    }

    // 회원 클래스 정의
    static class Member {
        private String name;
        private String memberId;
        private String reservationTime;

        public Member(String name, String memberId) {
            this.name = name;
            this.memberId = memberId;
        }

        public Member(String name, String memberId, String reservationTime) {
            this.name = name;
            this.memberId = memberId;
            this.reservationTime = reservationTime;
        }

        public String getName() {
            return name;
        }

        public String getMemberId() {
            return memberId;
        }

        public String getReservationTime() {
            return reservationTime;
        }
    }
}
