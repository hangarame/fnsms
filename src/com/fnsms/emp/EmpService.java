package com.fnsms.emp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.member.Member;
import com.fnsms.ticket.Ticket;
import com.fnsms.ticketregistration.TicketRegistration;

/**
 * @author 1조
 * 강사, 관리자의 메뉴 기능을 구현하는 클래스 입니다.
 */
public class EmpService {

    public static void memberManagement(String empNo) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n[회원관리 메뉴]");
            System.out.println("1. 회원등록");
            System.out.println("2. 회원조회");
            System.out.println("0. 뒤로가기");
            System.out.print("선택> ");

            String sel = sc.nextLine();
            switch (sel) {
                case "1":
                    addMember();
                    break;
                case "2":
                    searchMember();
                    break;
                case "0":
                    System.out.println("회원관리 메뉴 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
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
		
		 // 1) memberNo 자동 생성
	    String newMemberNo = generateNextMemberNo(); 
	    // ↑ 아래에 구현된 메서드

	    // 2) Member 객체 생성
	    Member newMember = new Member(name, tel, birthDate, newMemberNo);

	    // 3) 컬렉션에 추가, 파일로 저장
	    MemberDAO.memberList.add(newMember);
	    MemberDAO.save();

	    System.out.printf("회원 '%s'(%s) 등록이 완료되었습니다.\n", name, newMemberNo);
	}//addMember

	private static String generateNextMemberNo() {
	    int maxNum = 0;

	    for (Member mem : MemberDAO.memberList) {
	        String memNo = mem.getMemberNo(); // 예: "m00000001"
	        
	        // 1) 'm' 빼고 숫자 부분만 추출
	        //    예: "00000001" -> 정수 1
	        if (memNo.startsWith("m")) {
	            String numericPart = memNo.substring(1);
	            try {
	                int num = Integer.parseInt(numericPart);
	                if (num > maxNum) {
	                    maxNum = num;
	                }
	            } catch (NumberFormatException e) {
	                // 숫자로 안 변환되는 경우가 있다면 무시 or 처리
	            }
	        }
	    }

	    // 2) maxNum + 1
	    int nextNum = maxNum + 1;

	    // 3) 포맷팅 → "m00000000" (8자리)
	    String newMemberNo = String.format("m%08d", nextNum);
	    return newMemberNo;
	}
	
	// 회원 목록 조회
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
        }//동명이인 리스트 만들기, 혼자라도 일단 리스트 안에 넣기

//      회원이 아예 없을 경우 > 리스트가 0인 경우
        if (matchedList.isEmpty()) {
            System.out.println("해당 이름의 회원이 없습니다.");
            return;
        }

//      동명이인이 존재할 경우 > 리스트의 크기가 2이상인 경우
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
                // still multiple → 임시: 첫 번째만 처리
                Member selected = last4Matched.get(0);
                showMemberDetails(selected);
            }

            return;

        } else {
            Member selected = matchedList.get(0);
            showMemberDetails(selected);
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
                    	// 이용권 등록
                    	registerNewTicket(member);
                        break;
                    case "3":
                        // 이용권 수정
                    	editTicketRegistration(member);
                        break;
                    case "0":
                        // 뒤로가기
                        return;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }//switch case
            }//while
        }//showMemberDetail
	        
        
    //이용권등록    
	private static void registerNewTicket(Member member) {
		Scanner scan = new Scanner(System.in);
        
        // (A) TicketDAO.ticketList 목록이 미리 로드되어 있다고 가정
        //     사용자에게 Ticket 목록을 보여주고, "이용권 번호"를 입력받을 수도 있음
        //     여기서는 간단히 번호만 물어본다고 가정
        
        // 만약 실제로 Ticket 목록을 보여주고 싶다면:
        // showTicketList();

        System.out.print("이용권 번호(1~" + TicketDAO.ticketList.size() + ") : ");
        int ticketNo = Integer.parseInt(scan.nextLine());

        System.out.print("시작일(YYYYMMDD) : ");
        String startStr = scan.nextLine().trim();

        // startDate 파싱
        Calendar startDate = parseDate(startStr); 

        // 사번을 입력
        System.out.print("담당자 사번(예: i000000001) : ");
        String inputEmpNo = scan.nextLine().trim();

        Object staff = EmpDAO.getEmpByNo(inputEmpNo);

        if (staff == null) {
            System.out.println("해당 사번의 직원(강사/관리자)을 찾을 수 없습니다.");
            return;
        }

        // staff는 Instructor or Administrator 일 수 있으므로,
        // addRegTicket()가 Emp 타입을 받는다면, 형변환 필요.
        // 예) Instructor, Administrator 둘 다 Emp 클래스를 상속한다고 가정할 수 있음
        // 여기서는 임시로 Emp가 아닌 Object 리턴을 가정했으므로,
        // instructor인 경우만 처리하겠다 or downcasting 하겠다 등 상황에 맞춰 조정 필요

        com.fnsms.instructor.Instructor instructorStaff = (com.fnsms.instructor.Instructor) staff;

        //addRegTicket()사용
        TicketRegistration newReg = addRegTicket(ticketNo, startDate, instructorStaff, member);
        if (newReg != null) {
            System.out.println("이용권 등록 완료");
            TicketRegistrationDAO.save();
        } else {
            System.out.println("이용권 등록 실패");
        }

		
	}
	
//	 이용권수정하기
	 private static void editTicketRegistration(Member member) {
	        Scanner scan = new Scanner(System.in);

	        // 1) 회원의 등록된 이용권 목록 보여주기
	        ArrayList<TicketRegistration> myRegList = new ArrayList<>();
	        for (TicketRegistration tr : TicketRegistrationDAO.ticketRegList) {
	            if (tr.getMember().equals(member.getMemberNo())) {
	                myRegList.add(tr);
	            }
	        }//for
	        
	        if (myRegList.isEmpty()) {
	            System.out.println("등록된 이용권이 없습니다.");
	            return;
	        }

	        System.out.println("[이용권 수정]");
	        for (TicketRegistration r : myRegList) {
	            // 예: 등록번호=3, ticket=헬스6개월, start=2024-09-05, end=2024-10-05, price=330000
	            System.out.printf("등록번호=%d | ticket=%s | start=%tF | end=%tF | price=%d\n",
	                    r.getTicketRegNo(),
	                    r.getTicket(),
	                    r.getStartDate(),
	                    r.getEndDate(),
	                    r.getPurchasePrice());
	        }

	        // 3) 등록번호를 직접 입력받아 찾기
	        System.out.print("수정할 이용권 등록번호: ");
	        int regNo = Integer.parseInt(scan.nextLine().trim());

	        // 4) myRegList에서 해당 등록번호를 가진 TicketRegistration 찾기
	        TicketRegistration target = null;
	        for (TicketRegistration r : myRegList) {
	            if (r.getTicketRegNo() == regNo) {
	                target = r;
	                break;
	            }
	        }

	        // 5) 없으면 종료
	        if (target == null) {
	            System.out.println("해당 등록번호가 없습니다. 다시 확인해주세요.");
	            return;
	        }

	        // 6) 수정 메뉴
	        while (true) {
	            System.out.println("\n[이용권 수정 메뉴]");
	            System.out.println("(1) 등록일 변경");
	            System.out.println("(2) 이용 기간 변경");
	            System.out.println("(3) 담당자 변경");
	            System.out.println("(4) 시작일 변경");
	            System.out.println("(5) 종료일 변경 (아직미구현)");
	            System.out.println("(6) 금액 변경");
	            System.out.println("(7) 이용권 삭제");
	            System.out.println("(0) 뒤로가기");
	            System.out.print("선택> ");

	            String input = scan.nextLine().trim();
	            switch (input) {
	                case "1": // 등록일 변경
	                    System.out.print("새 등록일(YYYYMMDD) 입력> ");
	                    String purStr = scan.nextLine().trim();
	                    Calendar newPurchaseDate = parseDate(purStr);
	                    target.setPurchaseDate(newPurchaseDate);
	                    System.out.println("등록일이 변경되었습니다.");
	                    TicketRegistrationDAO.save();
	                    break;

	                case "2": // 이용 기간 변경
	                    System.out.print("새 이용기간(숫자) 입력> ");
	                    int newDays = Integer.parseInt(scan.nextLine());
	                    Calendar newEndDate2 = (Calendar) target.getStartDate().clone();
	                    newEndDate2.add(Calendar.DATE, newDays);
	                    target.setEndDate(newEndDate2);
	                    System.out.println("이용 기간이 변경되었습니다.");
	                    TicketRegistrationDAO.save();
	                    break;

	                case "3": // 담당자 변경
	                    System.out.print("새 담당자 사번> ");
	                    String newManager = scan.nextLine().trim();
	                    target.setManager(newManager);
	                    System.out.println("담당자가 변경되었습니다.");
	                    TicketRegistrationDAO.save();
	                    break;

	                case "4": // 시작일 변경
	                    System.out.print("새 시작일(YYYYMMDD) 입력> ");
	                    String startStr = scan.nextLine().trim();
	                    Calendar newStart = parseDate(startStr);
	                    target.setStartDate(newStart);
	                    System.out.println("이용권 시작일이 수정되었습니다.");
	                    TicketRegistrationDAO.save();
	                    break;

	                case "5": // 종료일 변경 (미구현)
	                    System.out.println("종료일 변경 기능은 아직 미구현입니다.");
	                    break;

	                case "6": // 금액 변경
	                    System.out.print("새 금액(숫자) 입력> ");
	                    int newPrice = Integer.parseInt(scan.nextLine());
	                    target.setPurchasePrice(newPrice);
	                    System.out.println("금액이 변경되었습니다.");
	                    TicketRegistrationDAO.save();
	                    break;

	                case "7": // 이용권 삭제
	                    System.out.print("정말로 삭제하시겠습니까? (삭제 입력 시 진행): ");
	                    String confirm = scan.nextLine().trim();
	                    if (confirm.equals("삭제")) {
	                        TicketRegistrationDAO.ticketRegList.remove(target);
	                        TicketRegistrationDAO.save();
	                        System.out.println("이용권이 삭제되었습니다.");
	                        return; // 수정 메서드 종료
	                    } else {
	                        System.out.println("삭제 취소");
	                    }
	                    break;

	                case "0": // 뒤로가기
	                    return;

	                default:
	                    System.out.println("잘못된 입력입니다.");
	            }
	        }
	    }

	


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
    

	
	

	
	

	

	// 이용권정보조회
	public ArrayList<TicketRegistration> inquriyOwnTicketInfo() {
		return null;
	}

//	966◈m00000466◈필라테스1개월◈2024-10-16◈i000000005◈2024-10-18◈2025-01-16◈880000
	
	// 회원이용권등록
	public static TicketRegistration addRegTicket(
			int ticketNo, Calendar startDate, Emp emp, Member member) {
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
	}//이용권등록

	
	
	private static Calendar parseDate(String yyyymmdd) {
        Calendar cal = Calendar.getInstance();
        if (yyyymmdd.length() == 8) {
            int yyyy = Integer.parseInt(yyyymmdd.substring(0,4));
            int mm   = Integer.parseInt(yyyymmdd.substring(4,6));
            int dd   = Integer.parseInt(yyyymmdd.substring(6,8));
            cal.set(yyyy, mm-1, dd, 0,0,0);
        } else {
            System.out.println("날짜 형식이 올바르지 않아, 오늘 날짜로 설정합니다.");
            // 기본 값 = 현재 날짜
        }
        return cal;
    }//날짜형식다듬기

	// 회원이용권정보수정
	public TicketRegistration updateRegTicket() {
		return null;
	}

	// 회원이용권정보삭제
	public TicketRegistration deleteRegTicket() {
		return null;
	}

}
