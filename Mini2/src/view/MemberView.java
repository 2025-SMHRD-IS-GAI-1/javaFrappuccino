package view;

import java.util.Scanner;

import model.MemberVO;

public class MemberView {
	Scanner sc = new Scanner(System.in);

	// 게임시작화면
	public int showMenu() {
		System.out.println("[1]로그인\n [2]회원가입\n ]3]게임시작\n [4]게임설명\n [5]게임종료");
		int input = sc.nextInt();
		return input;
	}

	// 로그인 출력하는 메소드
	public MemberVO showLogin() {
		System.out.println("=====로그인=====");
		System.out.print("ID입력 : ");
		String id = sc.next();
		System.out.print("PW입력 : ");
		String pw = sc.next();
		MemberVO mvo = new MemberVO();

		return mvo;
	}

	// 로그인 성공여부를 출력하는 메소드
	public void statusLogin(String name) {

		if (name != null) {
			System.out.println("로그인 성공 ! ");
			System.out.println(name + "님 환영합니다 !");
		} else {
			System.out.println("로그인 실패.");
		}
	}

	// 회원가입출력하는 메소드
	public MemberVO showJoin() {
		System.out.println("======회원 가입 ========");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		MemberVO mvo = new MemberVO();
		mvo.setId(id);
		mvo.setPw(pw);
		mvo.setName(name);
		return mvo;
	}

	// 회원가입 성공/실패를 출력하는 메소드
	public void statusJoin(int row) {
		if (row > 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
	}

	// 난이도선택 출력 메소드
	public int levelMenu() {
		System.out.println("=====난이도선택=====");
		System.out.println("[1]Easy [2]Normal [3]Hard");
		int level = sc.nextInt();

		return level;
	}
	// 사용자가 정답을 입력하는 출력
	public String getUseranswer() {
		System.out.println("정답을 입력하세요 : ");
		String useranswer = sc.next();
		return useranswer;
	}
	// 사용자가 잘못 입력했을 경우 출력
	public void userWrong() {
		System.out.println("자릿수가 일치하지 않습니다 다시 입력하세요");
	}
	// 정답을 맞췄을 시 게임 출력
	public void success(String num, int count) {
		System.out.println(num + " 정답입니다 !!");
		System.out.println("총" + count + " 회 시도했습니다 !");
	}
	// 실패 했을시 게임 출력 
	public void fail(int length, int[] answer) {
		System.out.println("정답을 맞추는데 실패했습니다");
		System.out.println("정답은 ");
		for(int i = 0; i < length; i++) {
			System.out.println(answer[i]);
		}
		System.out.println("입니다");
	}
	//난이도별 점수
	//점수계산하는 메소드를 따로 빼야할지도 애매
	//게임설명 메소드
	//회원조회 메서드
	

	//난이도별 횟수를 세팅해야되는데 이걸 어째야할지모르겠음 우선 이건 내일 쌤들한테 물어보기 
	//추후 필요한 메소드는 프로젝트 기간동안 회의 나눠보기
}
