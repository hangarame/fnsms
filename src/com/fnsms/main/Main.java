package com.fnsms.main;

import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.instructor.Instructor;
import com.fnsms.instructor.InstructorService;
import com.fnsms.user.User;
import com.fnsms.user.UserService;

public class Main {

    public static void main(String[] args) {
        
        // 1) 먼저 모든 DAO의 load()를 호출해, data 폴더의 정보를 불러옵니다.
        AttendanceDAO.load();
        EmpDAO.load();
        MemberDAO.load();
        ReservationDAO.load();
        TicketDAO.load();
        TicketRegistrationDAO.load();
//        InstructorService ins = new InstructorService("i00000001");
//        ins.getThisWeekAttendance(ins.getInstructor());
        
        // 2) 로그인 & 메인 메뉴 반복
        //    (로그인 화면에서 'E'를 누르면 프로그램 종료)
        while (true) {
            // UserService.logIn() -> 내부에서 메뉴 출력 + ID/PW 검사
            User user = UserService.logIn();
            
            // 만약 사용자에게서 'E'(프로그램 종료) 선택 → user == null or 로직에 따라 종료
            if (user == null) {
                // 프로그램을 종료합니다.
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            
            // 여기서 user가 로그인 성공했다면, 
            // UserService.logIn() 내부에서 이미 회원/강사/관리자 메인 화면으로 넘어갔다가,
            // 로그아웃 시 다시 이 자리로 돌아올 수 있음.
            // (UserService.logOut() → logIn() 재호출 구조)
            
            // 만약 추가로 "로그인 후 한 번만 동작하고 프로그램 완전히 종료" 로직을 원한다면,
            // break; 등으로 처리할 수도 있음.
        }

    }
}