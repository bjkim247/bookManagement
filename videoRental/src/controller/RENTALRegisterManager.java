package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Rental;

public class RENTALRegisterManager {
	// 비디오 대여 신청 리스트(정보를 회원정보와 비디오정보를 포함한 비디오 대여내용을 출력) 
	public void RENTALList() throws Exception {
		Scanner input = new Scanner(System.in);
		String id; // 아이디
		String pw; // 비밀번호
		String mainMenu; // 메인 메뉴
		boolean success = false;
		RENTALDAO td = new RENTALDAO();
		MEMBERDAO sdao = new MEMBERDAO();

		System.out.println("비디오 대여 신청한 리스트");
		do {
			System.out.print("아이디 >>");
			id = input.nextLine();
			System.out.print("비밀번호 >>");
			pw = input.nextLine();
			success = sdao.getMEMBERLogin(id, pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
				System.out.print("메인 메뉴로 이동(y/n) : ");
				mainMenu = input.next();
				input.nextLine();
				if (mainMenu.equals("y") || mainMenu.equals("Y")) {
					return;
				}
			}
		} while (!success);
		System.out.println("비디오 대여 신청한 리스트");
		td.getMemberRentalTotalList(id);
//		td.getRENTALTotalList();

	}

	//비디오 대여 신청 관리 
	public void RENTALRegistr() throws Exception {
		Scanner input = new Scanner(System.in);
		//비디오리스트
		VIDEODAO vd = new VIDEODAO();
		//회원로그인
		MEMBERDAO sdao = new MEMBERDAO();
		RENTALDAO td = new RENTALDAO();
		Rental tvo = new Rental();
		int videoNo; // 비디오 일련번호
		String id; // 아이디
		String pw; // 비밀번호
		String mainMenu; //???? 메인 메뉴
		boolean success = false;
		
		System.out.println();
		System.out.println("비디오 대여 신청을 위한 정보 입력");
		//1. 회원로그인 인증단계 
		do {
			System.out.print("아이디 : ");
			id = input.nextLine();
			System.out.print("비밀번호 : ");
			pw = input.nextLine();
			//회원로그인
			success = sdao.getMEMBERLogin(id, pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
				System.out.print("메인 메뉴로 이동(y/n) : ");
				mainMenu = input.next();
				input.nextLine();
				if (mainMenu.equals("y") || mainMenu.equals("Y")) {
					return;
				}
			}
		} while (!success);
		System.out.println("회원체크 완료함");
		tvo.setId(id);
		
		//2. 비디오 리스트 출력(비디오번호선택, 대여날짜)
		vd.getVIDEOTotalList();
		System.out.print("비디오일련번호 >>");
		videoNo = input.nextInt();
		input.nextLine(); 
		// 실수
		tvo.setVideoNo(videoNo);
		// 대여날짜 오늘일자등록
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
        Date now = new Date();
        tvo.setRentDate(sdf.format(now));
 		
		//3. 비디오 대여 신청 등록 
		td.setRENTALRegiste(tvo);
	}

	// 	반납 관리 
	public void RENTALDelete() throws Exception {
		Scanner input = new Scanner(System.in);
		RENTALDAO td = new RENTALDAO();
		MEMBERDAO sdao = new MEMBERDAO();
		String videoName; // 반납할 비디오이름
		String id; // 아이디
		String pw; // 비밀번호
		String mainMenu; // 메인 메뉴
		boolean success = false;
		System.out.println("반납을 위한 정보 입력");
		//1. 회원로그인
		do {
			System.out.print("아이디 : ");
			id = input.nextLine();
			System.out.print("비밀번호 : ");
			pw = input.nextLine();
			success = sdao.getMEMBERLogin(id, pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
				System.out.print("메인 메뉴로 이동(y/n) : ");
				mainMenu = input.next();
				input.nextLine();
				if (mainMenu.equals("y") || mainMenu.equals("Y")) {
					return;
				}
				System.out.println();
			}
		} while (!success);
		
		//2.회원이 대여한 비디오를 보여준다.
		td.getMemberRentalTotalList(id);
		
		//3.반납할 비디오명 선택
		System.out.println("반납할 비디오이름 입력");
		System.out.print("비디오이름 >>");
		videoName = input.nextLine();
		
		//4. 반납요청
		td.setRentalReturn(id,videoName);
	}
	//비디오 대여 전체목록리스트
	public void rentTotalList() {
		Scanner input = new Scanner(System.in);
		String pw; // 관리자아이디
		RENTALDAO td = new RENTALDAO();
		
		System.out.println("비디오 대여 전체 리스트");
		System.out.print("관리자 비밀번호 >>");
		pw = input.nextLine();
		if (pw.equals("admin1234")) {
			td.getRENTALTotalList();
		} else {
			System.out.println("관리자 비밀번호가 틀립니다.");
		}
	}
}
