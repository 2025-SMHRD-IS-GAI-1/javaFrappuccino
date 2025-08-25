package controller;

import java.util.Random;
import java.util.Scanner;

import view.MemberView;

public class NumberBaseballGame {
	//접근제한자 설정했어야하는데 어떻게 건들어야할지 모르겠어서 이것도 쌤한테 물어봐야될듯 
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	int level;
	int length;
	int[] answer;
	int[] useranswer;
	String num;
	int count = 0;
	int s = 0;
	int b = 0;
	MemberView view;

	//뷰에서 받아온 레벨을 저장하고싶은데 이거 되는지 안되는지 모르겠음 일단 낼 가서 지피티 돌려보기 
	public void levelSelect() {
		level = view.levelMenu();
	}

	//컴퓨터가 정답 생성하는 메소드 
	public void createAnswer() {
		//
		if (level == 1) {
			length = 3;
		} else if (level == 2) {
			length = 4;
		} else {
			length = 5;
		} 
		answer = new int[length];
		for (int i = 0; i < length; i++) {
			answer[i] = rd.nextInt(10);
			for (int j = 0; j < i; j++) {
				if (answer[i] == answer[j]) {
					i--;
				}
			}
		}
	}
	//유저가 정답 ??하는 메소드
	public void userAnswer() {
		while (true) {
			view.getUseranswer();
			if (num.length() != length) {
				view.userWrong();
			} else {
				break;
			}
		}
		useranswer = new int[length];
		for (int i = 0; i < length; i++) {
			useranswer[i] = num.charAt(i) - '0';
		}
	}
	//컴퓨터 정답과 유저의 정답을 비교하여 성공여부 판단 
	public void compareAnswer() {
		while(true) {
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					if(answer[i] == useranswer[i]) {
						if(i == j) {
							s++;
						} else {
							b++;
						}
					}
				}
			}
			count++;
			if(s == length) {
				view.success(num, count);
			}
			if(count == 10) {
				view.fail(length, answer);
			}
		}

	}

}
