package com.fnsms.main;

import com.fnsms.dao.MemberDAO;
import com.fnsms.view.CommonView;

public class Main {
	public static void main(String[] args) {
//		CommonView.printLogin();
//		CommonView.printLoginFailed();
//		CommonView.printLogout();

		MemberDAO.load();
		불러오기();
		

	}
}
