package view;

import java.util.Scanner;

public class MenuViewer {
	public static Scanner choice = new Scanner(System.in);
	
	// 메인 메뉴
	public static void mainMenuView() {
		System.out.println();
		System.out.println("비디오 대여 프로그램");
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 비디오 정보 목록/입력/수정/삭제");
		System.out.println("2. 회원 정보 입력/수정/목록");
		System.out.println("3. 비디오 대여 목록/신청/반납");
		System.out.println("4. 프로그램 종료");
		System.out.print("번호 선택 >>");
	}
	// 비디오 정보 메뉴
	public static void VIDEOMenuView() {
		System.out.println();
		System.out.println("비디오 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 비디오 정보 목록");
		System.out.println("2. 비디오 정보 입력");
		System.out.println("3. 비디오 정보 수정");
		System.out.println("4. 비디오 정보 삭제");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 >> ");
	}
	// 회원 정보 메뉴
	public static void MEMBERMenuView() {
		System.out.println();
		System.out.println("회원 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 회원 정보 입력");
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 회원 전체 목록");
		System.out.println("4. 메인 메뉴");
		System.out.print("번호 선택 >> ");
	}
	// 비디오 대여 메뉴
	public static void RENTALMenuView() {
		System.out.println();
		System.out.println("비디오 대여 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 비디오 대여 회원 목록");
		System.out.println("2. 비디오 대여 전체 목록");
		System.out.println("3. 비디오 대여 신청");
		System.out.println("4. 비디오 반납");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 >> ");
	}
}
