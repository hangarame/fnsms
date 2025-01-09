package com.fnsms.emp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.member.Member;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;


public class EmpService {

	// 회원등록
	public static void addMember() {
		Scanner scan = new Scanner(System.in);

//		입력 안내 메시지 출력
//		>
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("생년월일: ");
		String birthDate = scan.nextLine();
		System.out.print("연락처: ");
		String tel = scan.nextLine();
		System.out.print("회원번호: ");
		String memberNo = scan.nextLine();
		
		Member newMember = new Member(name,tel,birthDate,memberNo);
		MemberDAO.memberList.add(newMember);
		MemberDAO.save();
//		등록 완료 메시지 출력
	}//addMember

	
	
	// 회원정보수정
	public static void readMemberList(int pageSize) {
//      회원 목록이 비어있는지 확인
		if (MemberDAO.memberList.isEmpty()) {
			System.out.println("등록된 회원이 없습니다.\n");
		}
		Scanner scan = new Scanner(System.in);
		
		int total = MemberDAO.memberList.size();
		int currentIndex = 0;
		
//		회원 조회 안내 메시지 출력
//		>
		
//      전체 회원 정보 중 상위 N개 출력
        System.out.println("\t[이름]\t\t[연락처]\t\t[생년월일]");
        while (currentIndex < total) {
        	int endIndex = currentIndex + pageSize;
        	if(endIndex > total) {
        		endIndex = total;
        	}
        	
        	for (int i = currentIndex; i<endIndex; i++) {
        		Member m = MemberDAO.memberList.get(i);
        		System.out.printf("%-3d\t%s\t\t%s\t\t%s\r\n"
        				,i+1, m.getName(), m.getTel(), m.getBirthDate());
        	}
        	
        		currentIndex = endIndex;
        		if(currentIndex >= total) {
        			System.out.println("더 이상 조회할 정보가 없습니다.");
        			break;
        		}
        		
        	System.out.println("엔터를 누르면 목록을 더 불러옵니다.");
        	System.out.println("그만 보려면 1을 입력");
        	String input = scan.nextLine();
        	if(input.equalsIgnoreCase("1")) {
        		System.out.println("조회를 중단합니다.");
        		break;
        	}
        }//while
	}//readMemberList
	
	
//	특정 회원 정보 조회
	public static void searchMember() {
		Scanner scan = new Scanner(System.in);

		System.out.println("[특정 회원 정보 조회]");
        System.out.print("조회할 회원의 이름을 입력하세요: ");
        String inputName = scan.nextLine();
        
//      1) 이름이 일치하는 모든 Member 처리
        ArrayList<Member> matchedList = new ArrayList<>();
        for (Member m : MemberDAO.memberList) {
            if (m.getName().equals(inputName)) {
                matchedList.add(m);
            }
        }//동명이인 리스트

//      회원이 없을 경우
        if (matchedList.isEmpty()) {
            System.out.println("해당 이름의 회원이 없습니다.");
            return;
        }//정보가 없을 경우

//      동명이인이 존재할 경우
        if (matchedList.size() > 1) {
            System.out.println("회원 정보를 확인 후, 조회를 원하는 회원의 연락처 뒤 4자리를 입력해 주세요.\n");
            for (Member mem : matchedList) {
                System.out.printf("- 회원번호: %s | 이름: %s | 연락처: %s\n",
                        mem.getMemberNo(), mem.getName(), mem.getTel());
            }

            System.out.print("\n연락처 뒤 4자리를 입력하세요> ");
            String last4 = scan.nextLine().trim();

            ArrayList<Member> last4Matched = new ArrayList<>();
            for (Member mem : matchedList) {
                String tel = mem.getTel();
                String digits = tel.replaceAll("[^0-9]", ""); //숫자만 추출 
                if (digits.endsWith(last4)) {
                    last4Matched.add(mem);
                }
            }
            
            if (last4Matched.isEmpty()) {
                System.out.println("회원을 찾을 수 없습니다. 다시 입력해주세요.");
                return;
            } else if (last4Matched.size() == 1) {
                // 유일하게 선택된 경우
                Member selected = last4Matched.get(0);
                showMemberDetails(selected);
            } else {
//          동명이인이 없을 때
            Member selected = matchedList.get(0);
            showMemberDetails(selected);
            }
        }
	}//searchMember
//	검색한 회원 정보
        private static void showMemberDetails(Member member) {
        	Scanner scan = new Scanner(System.in);

            System.out.println("\n[회원 정보]");
            System.out.println("회원번호: " + member.getMemberNo());
            System.out.println("이름: " + member.getName());
            System.out.println("연락처: " + member.getTel());
            System.out.println("생년월일: " + member.getBirthDate());

            
            while (true) {
                System.out.println("(1) 회원 정보 수정");
                System.out.println("(2) 이용권 신규 등록");
                System.out.println("(3) 이용권 수정");
                System.out.println("(0) 뒤로가기");
                System.out.print("선택> ");

                String sel = scan.nextLine();
                switch (sel) {
                    case "1":
                        // 회원 정보 수정
                        editMember(member);
                        MemberDAO.save();
                        break;
                    case "2":
                        // 이용권 신규 등록 (아직 미구현 (목요일9시6분))
                        break;
                    case "3":
                        // 이용권 수정 (아직 미구현)
                        break;
                    case "0":
                        // 뒤로가기
                        return;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }//switch case
            }//while
        }//showMemberDetail
        
//      회원정보수정
        private static void editMember(Member member) {
        	Scanner scan = new Scanner(System.in);
        	
            while (true) {
                System.out.println("\n[회원 정보 수정]");
                System.out.println("(1) 이름변경");
                System.out.println("(2) 연락처변경 ");
                System.out.println("(3) 생년월일변경 ");
                System.out.println("(4) 회원삭제 ");
                System.out.println("(0) 뒤로가기 ");
                System.out.print("선택> ");
                
                String sel = scan.nextLine();

                switch (sel) {
                    case "1":
                        // 이름 변경
                        System.out.print("새로운 이름을 입력하세요: ");
                        String newName = scan.nextLine();
                        member.setName(newName);
                        System.out.println("이름이 변경되었습니다.");
                        return;
                    case "2":
                        // 연락처 변경
                        System.out.print("새로운 연락처를 입력하세요: ");
                        String newTel = scan.nextLine();
                        member.setTel(newTel);
                        System.out.println("연락처가 변경되었습니다.");
                        return;
                    case "3":
                        // 생년월일 변경
                        System.out.print("새로운 생년월일(yyyymmdd)을 입력하세요: ");
                        String newBirth = scan.nextLine();
                        member.setBirthDate(newBirth);
                        System.out.println("생년월일이 변경되었습니다.");
                        return;
                    case "4":
                        // 회원 삭제
                        deleteMember(member);
                        return;  // 삭제 후 돌아감
                    case "0":
                        // 뒤로
                        return;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }//switch case
            }//while
        }//editMember
        
        private static void deleteMember(Member member) {
        	Scanner scan = new Scanner(System.in);
        	
            System.out.print("정말로 삭제하시겠습니까? '삭제'라고 입력하면 삭제가 진행됩니다> ");
            String confirm = scan.nextLine();
            if (confirm.equals("삭제")) {
                // 실제 리스트에서 제거
                MemberDAO.memberList.remove(member);
                MemberDAO.save();
                System.out.println("회원 정보가 삭제되었습니다.");
            } else {
                System.out.println("삭제가 취소되었습니다.");
            }//if
        }//deleteMember

		private ArrayList<TicketRegistration> ticketRegList;
    

	
	

	
	

	

	// 회원 이용권 정보조회


	
	// 회원이용권등록
	public TicketRegistration addRegTicket(int ticketNo, Calendar startDate, Emp emp, Member member) {
	    // 1. 공통 티켓 번호를 인덱스로 활용하여 조회 (1번부터 시작하므로 -1 처리)
	    if (ticketNo < 1 || ticketNo > TicketDAO.ticketList.size()) {
	        System.out.println("선택한 이용권 번호가 존재하지 않습니다.");
	        return null;
	    }

	    Ticket selectedTicket = TicketDAO.ticketList.get(ticketNo - 1);

	    // 2. 현재 날짜를 등록일로 설정
	    Calendar purchaseDate = Calendar.getInstance();

	    // 3. 만료일 계산 (시작일 + 이용권 기간)
	    Calendar endDate = (Calendar) startDate.clone();
	    endDate.add(Calendar.DAY_OF_YEAR, selectedTicket.getTicketUseDays());

	    // 4. 새로운 TicketRegistration 객체 생성
	    int newTicketRegNo = TicketRegistrationDAO.ticketRegList.size() + 1;
	    TicketRegistration newReg = new TicketRegistration(
	        newTicketRegNo,
	        member.getMemberNo(),  
	        selectedTicket.getTicketClassify(),
	        purchaseDate,
	        emp.getEmpNo(),
	        startDate,
	        endDate,
	        selectedTicket.getPrice()
	    );

	    // 5. 생성한 객체를 리스트에 추가
	    TicketRegistrationDAO.ticketRegList.add(newReg);

	    // 6. 해당 회원의 ticketRegList에 새 이용권 추가
	    member.addTicketRegistration(newReg);

	    return newReg;
	}
 
	

	// 회원이용권정보수정
	public TicketRegistration updateRegTicket() {
		return null;
	}

	// 회원이용권정보삭제
	public TicketRegistration deleteRegTicket() {
		return null;
	}

}
