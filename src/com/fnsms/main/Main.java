package com.fnsms.main;

import com.fnsms.dao.AttendanceDAO;
import com.fnsms.dao.EmpDAO;
import com.fnsms.dao.MemberDAO;
import com.fnsms.dao.ReservationDAO;
import com.fnsms.dao.TicketDAO;
import com.fnsms.dao.TicketRegistrationDAO;
import com.fnsms.instructor.InstructorService;
import com.fnsms.member.Member;
import com.fnsms.member.MemberService;
import com.fnsms.user.User;
import com.fnsms.user.UserService;

/**
 * 프로그램의 메인 메서드가 담긴 클래스입니다.
 * @author 1조
 * 
 */
public class Main {

    public static void main(String[] args) {
        
        // 1) 모든 DAO 로드
        AttendanceDAO.load();
        EmpDAO.load();
        MemberDAO.load();
        ReservationDAO.load();
        TicketDAO.load();
        TicketRegistrationDAO.load();
        
        // 2) 로그인 & 메인 메뉴 반복
        
        while (true) {
            User user = UserService.logIn(); 
            
            if (user == null) { 
            	System.out.println("프로그램을 종료합니다.");
                return; 
        }//종료
        // 이 이후는 UserService 내부에서 이미 회원/강사/관리자 각자 메인 화면을 띄우고
        // 로그아웃시 다시 logIn() 반복
        }
        
//    		InstructorService.classManagement();
    		
    		
    }//main
}//class
