

import controller.MEMBERRegisterManager;
import controller.VIDEORegisterManager;
import controller.RENTALRegisterManager;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.VIDEO_CHOICE;
import view.MEMBER_CHOICE;
import view.RENTAL_CHOICE;


public class VIDEORegisterMain {
	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {
		int choiceNum;
		boolean stopFlag = false;
		while (!stopFlag) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = MenuViewer.choice.nextInt();
				MenuViewer.choice.nextLine();
				
				switch (choiceNum) {
				case MENU_CHOICE.VIDEO:
					VIDEOMenu();
					break;
				case MENU_CHOICE.MEMBER:
					MEMBERMenu();
					break;
				case MENU_CHOICE.RENTAL:
					RENTALMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					stopFlag = true;
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				return;
			}
		}

	}
	//도서 대여 신청 메뉴
	public static void RENTALMenu() throws Exception {
		int choice;

		RENTALRegisterManager RENTALManager = new RENTALRegisterManager();
		MenuViewer.RENTALMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();

		switch (choice) {
		case RENTAL_CHOICE.LIST:
			System.out.println("");
			RENTALManager.RENTALList();
			break;
		case RENTAL_CHOICE.INSERT:
			System.out.println("");
			RENTALManager.RENTALRegistr();
			break;
		case RENTAL_CHOICE.DELETE:
			System.out.println("");
			RENTALManager.RENTALDelete();
			break;

		case RENTAL_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}
	
	//회원 메뉴
	public static void MEMBERMenu() throws Exception {
		int choice;
		MEMBERRegisterManager MEMBERManager = new MEMBERRegisterManager();
		MenuViewer.MEMBERMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		switch (choice) {
		case MEMBER_CHOICE.INSERT:
			System.out.println("");
			MEMBERManager.MEMBERRegistr();
			break;
		case MEMBER_CHOICE.UPDATE:
			System.out.println("");
			MEMBERManager.MEMBERUpdate();
			break;
		case MEMBER_CHOICE.LIST:
			System.out.println("");
			MEMBERManager.MEMBERTotalList();
			break;
		case MEMBER_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	
	// 비디오 메뉴
	public static void VIDEOMenu() throws Exception {
		int choice;
		VIDEORegisterManager VIDEOManager = new VIDEORegisterManager();
		MenuViewer.VIDEOMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		switch (choice) {
		case VIDEO_CHOICE.LIST:
			System.out.println("");
			VIDEOManager.VIDEOList();
			break;
		case VIDEO_CHOICE.INSERT:
			System.out.println("");
			VIDEOManager.VIDEORegistr();
			break;
		case VIDEO_CHOICE.UPDATE:
			System.out.println("");
			VIDEOManager.VIDEOUpdate();
			break;
		case VIDEO_CHOICE.DELETE:
			System.out.println("");
			VIDEOManager.VIDEODelete();
			break;
		case VIDEO_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

}
