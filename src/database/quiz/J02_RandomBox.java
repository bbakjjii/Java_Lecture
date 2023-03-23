package database.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.quiz.dataaccess.J02_DatabaseAccess;
import database.quiz.datamodel.J02_GameUser;

public class J02_RandomBox {

/*
사용자가 실행할 때마다 무언가를 랜덤으로 뽑는 프로그램을 만들어주세요.
(1) 랜덤으로 뽑는 물건은 자유 (축구선수, 농구선수, ...)
(2) 사용자에게는 재화가 있어서 재화를 다 쓰면 뽑기가 취소되어야 한다 (돈, 다이아몬드, 루비, ...)
(3) 모든 상품은 각자의 확률대로 뽑혀야 한다
(4) 사용자는 ID와 비밀번호로 인증하면 뽑기를 진행할 수 있다

★ 목록 보기는 과제!!!!!!!!!!!!! ★
 << DB >>
회원(아이디, 비밀번호, 소지금)
소유 아이템 (소유 아이디(PK), 회원 아이디(FK), 아이템 번호(FK), 획득시간)
아이템 (아이템 번호, 이름, 이미지 파일, 확률)	 
*/

	public static void main(String[] args) throws IOException {

		// ---------- ① 로그인 --------
		//Scanner sc = new Scanner(System.in);

		// Scanner 대신 Buffer방식으로 읽는다. 훨씬 간편해진다.
		// Scanner보다 성능이 좋다.
		BufferedReader in = 
				new BufferedReader(new InputStreamReader(System.in)); // 한줄 씩 읽기

		System.out.print("아이디를 입력해주세요. ");
		String userId = in.readLine();

		System.out.print("비밀번호를 입력해주세요. ");
		String userPassword = in.readLine();

		J02_GameUser userInfo = J02_DatabaseAccess.login(userId, userPassword);
		// ---------- ① 로그인 -------

		while(true) {
			System.out.println(userInfo.getUser_id() + "님이 가지고 있는 골드는 " 
					+ userInfo.getGold() + "골드입니다.");
			int select = -1;
			try {
				System.out.print("1. 뽑기  2. 목록보기  3. 그만하기\n>> ");
				select = Integer.parseInt(in.readLine().trim());

				if(select < 1 || select > 3) {
					continue;
				}
			} catch (NumberFormatException e) {
				continue;
			}

			if (select == 1) {
				J02_DatabaseAccess.openBox(userInfo);
			} else if (select == 2) {
				J02_DatabaseAccess.ItemBox(userId, userPassword);
			} else if (select == 3) { // 프로그램 종료
				System.out.println("그만하기를 선택하셨습니다.");
				break;
			}
		}
	}
}