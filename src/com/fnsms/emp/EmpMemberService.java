package com.fnsms.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fnsms.view.Header;
import com.fnsms.view.InstructorClassMngView;
import com.fnsms.view.InstructorView;

/**
 * 강사, 관리자가 회원의 정보를 관리하는 클래스 입니다.
 * @author 1조
 * 
 */
public class EmpMemberService {

	private Map<String, List<Member>> instructorMembers = new HashMap<>();

	// 데이터를 초기화
	public EmpMemberService() {
		String instructorName = "김계란";
		instructorMembers.put(instructorName, new ArrayList<>());

		instructorMembers.get("김계란").add(new Member("홍길동", "m12345678", new ArrayList<>(List.of("2025-01-12  09시"))));
		instructorMembers.get("김계란").add(new Member("가동석", "m23456789", new ArrayList<>(List.of("2025-01-15  13시"))));
		instructorMembers.get("김계란").add(new Member("이수근", "m34567890", new ArrayList<>(List.of())));
		instructorMembers.get("김계란").add(new Member("마동석", "m56789012",
				new ArrayList<>(List.of("2025-01-10  15시", "2025-01-27  13시", "2025-01-31  14시"))));
		instructorMembers.get("김계란").add(new Member("서건훈", "m67890123", new ArrayList<>(List.of("2025-01-25  11시"))));
		instructorMembers.get("김계란").add(new Member("고건아", "m78901234", new ArrayList<>(List.of())));
		instructorMembers.get("김계란").add(new Member("허아후", "m89012345", new ArrayList<>(List.of("2025-01-30  15시"))));
		instructorMembers.get("김계란").add(new Member("문현우", "m90123456", new ArrayList<>(List.of("2025-01-28  09시"))));

	}

	// 회원 검색 및 예약 관리
	public void viewByMember() {
		Scanner scanner = new Scanner(System.in);

		String instructorName = "김계란";
		List<Member> members = instructorMembers.get(instructorName);

		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t" + instructorName + " PT님의 담당회원 명단입니다.");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();

		for (Member member : members) {
			System.out.println("\t- " + member.getName() + " 회원님");
		}
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();

		System.out.println("\t>>조회할 회원 이름을 입력해주세요.");
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
		System.out.println();
		System.out.print("\t🖙 원하는 작업을 입력하세요 : ");
		String searchName = scanner.nextLine();

		List<Member> foundMembers = new ArrayList<>();
		for (Member member : members) {
			if (member.getName().equals(searchName)) {
				foundMembers.add(member);
			}
		}

		if (foundMembers.isEmpty()) {
			System.out.println("해당 회원은 " + instructorName + " PT님의 담당 회원이 아닙니다.");
		} else if (foundMembers.size() > 1) {
			System.out.println("동명이인이 있습니다. 회원번호를 입력해주세요:");
			for (Member member : foundMembers) {
				System.out.println(member.getName() + " - 회원번호: " + member.getMemberId());
			}

			System.out.print("회원번호: ");
			String memberId = scanner.nextLine();

			Member selectedMember = foundMembers.stream().filter(member -> member.getMemberId().equals(memberId))
					.findFirst().orElse(null);

			if (selectedMember != null) {
				manageReservations(selectedMember);
			} else {
				System.out.println("잘못된 회원번호입니다.");
			}
		} else {
			manageReservations(foundMembers.get(0));
		}
	}

	// 예약 관리 메서드
	private void manageReservations(Member member) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			Header logo = new Header();
			logo.Logo();
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t검색한 " + member.getName() + " 회원님의 상세 예약 내역입니다.");
			System.out.println();
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t  [날짜]   [시간]");
			if (member.getReservations().isEmpty()) {
				System.out.println("\t예약된 시간이 없습니다.");
			} else {
				for (String reservation : member.getReservations()) {
					System.out.println("\t" + reservation);
				}
			}
			System.out.println();
			System.out.println("=================================================================================");
			System.out.println();
			System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");
			System.out.println("\t1. 예약 추가하기");
			System.out.println("\t2. 예약 변경하기");
			System.out.println("\t3. 예약 삭제하기");
			System.out.println();
//			System.out.println("4. 나가기");
//			System.out.print("원하는 번호를 선택해주세요: ");
			Scanner scan = new Scanner(System.in);

			boolean isRunning = true;

			while (isRunning) {
				System.out.print("\t🖙 원하는 작업을 입력하세요 : ");
				String input = scan.nextLine();

				switch (input) {
				case "1":
					addReservation(member);
					break;
				case "2":
					modifyReservation(member);
					break;
				case "3":
					deleteReservation(member);
					break;
				case "#":
					System.out.println("메인으로 돌아갑니다.");
					isRunning = false;
					break;
				default:
					System.out.println("올바른 입력이 아닙니다. 다시 시도해주세요.");
				}

			}
		}
	}

	// 예약 추가
	private void addReservation(Member member) {

		// InstructorClassMngView.printAddReservation_Member();
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t" + member.getName() + "님의 수업 예약 추가입니다.");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t  [날짜]   [시간]");
		if (member.getReservations().isEmpty()) {
			System.out.println("\t예약된 시간이 없습니다.");
		} else {
			for (String reservation : member.getReservations()) {
				System.out.println("\t" + reservation);
			}
		}
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t>>예약희망 날짜와 시간을 입력하세요.");
		System.out.println("\t(메인으로 돌아가려면 #을 입력해주세요.)");

		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("\t🖙 원하는 작업을 입력하세요");
		System.out.print("\t예약을 추가할 날짜 (YYYY-MM-DD) : ");
		String date = scanner.nextLine();
		System.out.println("\t>>");
		System.out.print("\t시간 (24h) : ");
		String time = scanner.nextLine();
		System.out.println("\t>>");
		String newReservation = date + " " + time;
		member.getReservations().add(newReservation);
		System.out.println("\t예약이 추가되었습니다: " + newReservation);
		System.out.println();
		System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
		scanner.nextLine(); // 엔터 입력 대기

		manageReservations(member);

	}

	// 예약 변경
	private void modifyReservation(Member member) {
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t" + member.getName() + "님의 수업 예약 변경입니다.");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t  [날짜]   [시간]");
		if (member.getReservations().isEmpty()) {
			System.out.println("\t예약된 시간이 없습니다.");
		} else {
			for (String reservation : member.getReservations()) {
				System.out.println("\t" + reservation);
			}
		}
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();

		Scanner scanner = new Scanner(System.in);

		if (member.getReservations().isEmpty()) {
			System.out.println("\t변경할 예약이 없습니다.");
			return;
		}

		System.out.println("\t변경할 예약을 선택해주세요");
		for (int i = 0; i < member.getReservations().size(); i++) {
			System.out.println("\t"+(i + 1) + ". " + member.getReservations().get(i));
		}
		
		System.out.println();
		System.out.print("\t🖙 원하는 작업을 입력하세요 : ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // 버퍼 비우기

		if (choice < 1 || choice > member.getReservations().size()) {
			System.out.println("\t잘못된 선택입니다.");
			return;
		}

		System.out.print("\t새로운 예약 날짜 (YYYY-MM-DD): ");
		String date = scanner.nextLine();
		System.out.println("\t>>");
		System.out.print("\t새로운 시간 (24h): ");
		String time = scanner.nextLine();
		System.out.println("\t>>");

		String updatedReservation = date + " " + time;
		member.getReservations().set(choice - 1, updatedReservation);
		System.out.println("\t예약이 변경되었습니다: " + updatedReservation);
		System.out.println();
		System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
		scanner.nextLine(); // 엔터 입력 대기

		manageReservations(member);

	}

	// 예약 삭제
	private void deleteReservation(Member member) {
		Header logo = new Header();
		logo.Logo();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t" + member.getName() + "님의 수업 예약 취소입니다.");
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		System.out.println("\t  [날짜]   [시간]");
		if (member.getReservations().isEmpty()) {
			System.out.println("\t예약된 시간이 없습니다.");
		} else {
			for (String reservation : member.getReservations()) {
				System.out.println("\t" + reservation);
			}
		}
		System.out.println();
		System.out.println("=================================================================================");
		System.out.println();
		Scanner scanner = new Scanner(System.in);

		if (member.getReservations().isEmpty()) {
			System.out.println("\t삭제할 예약이 없습니다.");
			return;
		}

		System.out.println("\t삭제할 예약을 선택해주세요:");
		for (int i = 0; i < member.getReservations().size(); i++) {
			System.out.println("\t"+(i + 1) + ". " + member.getReservations().get(i));
		}

		System.out.println();
		System.out.print("\t🖙 원하는 작업을 입력하세요 : ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // 버퍼 비우기

		if (choice < 1 || choice > member.getReservations().size()) {
			System.out.println("\t잘못된 선택입니다.");
			return;
		}

		String removedReservation = member.getReservations().remove(choice - 1);
		System.out.println("\t예약이 삭제되었습니다: " + removedReservation);
		System.out.println();
		System.out.println("\t엔터를 눌러 이전 화면으로 이동하세요.");
		scanner.nextLine(); // 엔터 입력 대기

		manageReservations(member);

	}

	// 회원 클래스 정의
	static class Member {
		private String name;
		private String memberId;
		private List<String> reservations;

		public Member(String name, String memberId) {
			this.name = name;
			this.memberId = memberId;
			this.reservations = new ArrayList<>();
		}

		public Member(String name, String memberId, List<String> reservations) {
			this.name = name;
			this.memberId = memberId;
			this.reservations = reservations;
		}

		public String getName() {
			return name;
		}

		public String getMemberId() {
			return memberId;
		}

		public List<String> getReservations() {
			return reservations;
		}

		// 예약 추가
		private void addReservation(Member member) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("예약을 추가할 날짜 (YYYY-MM-DD): ");
			String date = scanner.nextLine();
			System.out.print("시간 (24h): ");
			String time = scanner.nextLine();

			// 시간 유효성 검사
			try {
				int hour = Integer.parseInt(time.replaceAll("[^0-9]", ""));
				if (hour < 9 || hour > 20) {
					System.out.println("예약이 불가능한 시간입니다. 09시~20시 사이로 입력해 주세요.");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 시간 형식입니다. 다시 입력해 주세요.");
				return;
			}

			String newReservation = date + " " + time;
			member.getReservations().add(newReservation);
			System.out.println("예약이 추가되었습니다: " + newReservation);
		}

		// 예약 변경
		private void modifyReservation(Member member) {
			Scanner scanner = new Scanner(System.in);

			if (member.getReservations().isEmpty()) {
				System.out.println("변경할 예약이 없습니다.");
				return;
			}

			System.out.println("변경할 예약을 선택해주세요:");
			for (int i = 0; i < member.getReservations().size(); i++) {
				System.out.println((i + 1) + ". " + member.getReservations().get(i));
			}

			System.out.print("선택: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // 버퍼 비우기

			if (choice < 1 || choice > member.getReservations().size()) {
				System.out.println("잘못된 선택입니다.");
				return;
			}

			System.out.print("새로운 예약 날짜 (YYYY-MM-DD): ");
			String date = scanner.nextLine();
			System.out.print("새로운 시간 (24h): ");
			String time = scanner.nextLine();

			// 시간 유효성 검사
			try {
				int hour = Integer.parseInt(time.replaceAll("[^0-9]", ""));
				if (hour < 9 || hour > 20) {
					System.out.println("예약이 불가능한 시간입니다. 09시~20시 사이로 입력해 주세요.");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 시간 형식입니다. 다시 입력해 주세요.");
				return;
			}

			String updatedReservation = date + " " + time;
			member.getReservations().set(choice - 1, updatedReservation);
			System.out.println("예약이 변경되었습니다: " + updatedReservation);
		}

	}
}
