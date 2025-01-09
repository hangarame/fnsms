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
        
    	InstructorService.classManagement();

    }
}