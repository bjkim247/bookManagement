package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Member;

public class MEMBERRegisterManager {
	//  정보 등록 
	public void MEMBERRegistr() throws Exception {
		Scanner input = new Scanner(System.in);
		MEMBERDAO sd = new MEMBERDAO();
		Member svo = new Member();
		String name; // 이름
		String id; // 아이디
		String passwd; // 비밀번호
		String phone; // 핸드폰번호
		boolean idCheck = false; // 아이디 체크
		
		System.out.println("학생 정보 입력");
		System.out.print("성명 >>");
		name = input.nextLine();
		do {
			System.out.print("아이디(8자 이상 12자 이내) : ");
			id = input.nextLine();
			idCheck = sd.getMEMBERIdOverlap(id);
			if (idCheck) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요");
				continue;
			}else {
				System.out.println("사용할수 있는 아이디입니다.");
				break; 
			}
		} while(idCheck);
		
		System.out.print("비밀번호(12자 이내) >>");
		passwd = input.nextLine();
		System.out.print("전화번호(010-1111-1111) >> ");
		phone = input.nextLine();
		svo.setName(name);
		svo.setId(id);
		svo.setPasswd(passwd);
		svo.setPhone(phone);
		boolean insertFlag = sd.setMEMBERRegiste(svo);
		//회원가입을 성공했을때 회원을 출력
		if(insertFlag == true) {
			sd.getMEMBER(svo.getId(), svo.getPasswd());
		}
	}

	// 회원 정보 수정 
	public void MEMBERUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		MEMBERDAO sdao = new MEMBERDAO();
		Member svo = new Member();
		String id = null; 		// 아이디
		String pw = null; 		// 입력 비밀번호
		String passwd = null; 	// 수정 비밀번호
		String phone = null; 	// 수정 전화번호
		boolean success = false;
		
		System.out.println("회원 정보 수정");
		do {
			System.out.print("아이디 >>");
			id = input.nextLine();
			System.out.print("비밀번호 >>");
			pw = input.nextLine();
			success = sdao.getMEMBERLogin(id, pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
			}else {
				System.out.println("아이디 또는 비밀번호가 확인완료");
			}
		} while (!success);
		System.out.println();
		svo.setId(id);
		System.out.printf("수정할 회원");
		System.out.printf("비밀번호(12자 이내) >>");
		passwd = input.nextLine();
		System.out.print("전화번호 >>");
		phone = input.nextLine();
		svo.setPasswd(passwd);
		svo.setPhone(phone);
		
		//회원정보수정
		sdao.setMEMBERUpdate(svo);
		System.out.println();
		System.out.println("회원 정보 수정 결과");
		sdao.getMEMBER(id, svo.getPasswd());
	}

	// 회원 전체 목록 
	public void MEMBERTotalList() throws Exception {
		Scanner input = new Scanner(System.in);
		MEMBERDAO sdao = new MEMBERDAO();
		String pw;
		System.out.println("회원 정보 전체 목록");
		System.out.print("관리자 비밀번호 : ");
		pw = input.nextLine();
		if (pw.equals("admin1234")) {
			sdao.getMEMBERTotalList();
		} else {
			System.out.println("관리자 비밀번호가 틀립니다.");
		}
	}
}
