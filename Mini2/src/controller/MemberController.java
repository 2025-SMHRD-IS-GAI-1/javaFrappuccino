package controller;

import java.util.Random;
import java.util.Scanner;

import model.MemberDAO;
import view.MemberView;

public class MemberController {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	private MemberView view;
	private MemberDAO dao;
	private NumberBaseballGame nbg;
	
	
	public MemberController(MemberView view, MemberDAO dao,NumberBaseballGame nbg) {
		this.view = view;
		this.dao = dao;
		this.nbg = nbg;
	}
	
	public void run() {
		while(true) {
			int input = view.showMenu();
			if(input == 1) {
				String name = dao.login(view.showLogin());
				view.statusLogin(name);
			} else if (input == 2) {
				int row = dao.Join(view.showJoin());
				view.statusJoin(row);
			} else if (input == 3) {
				
				
			}
		}
	}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
