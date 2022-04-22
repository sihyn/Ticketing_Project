package Ticketing;

import java.util.ArrayList;
import java.util.Scanner;

public class Ticket_Input {
	public static ArrayList<OrderData> orderList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	public int selectTicket() { // 이용권 종류
		int input;
		do {
			System.out.println("[이용권을 선택하세요]");
			System.out.print("1. 종합이용권\n2. 파크이용권\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 2) {
				System.out.println("다시 선택해주세요.\n");
			}
		} while (input > 2);
		return input;
	}

	public int selectTicketTime() { // 티켓 시간
		int input;
		do {
			System.out.println("[권종을 선택하세요]");
			System.out.print("1. 주간권(1Day)\n2. 야간권(After4)\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 2) {
				System.out.println("다시 선택해주세요.\n");
			}
		} while (input > 2);
		return input;
	}

	public String inputIDnumber() { // 생년월일
		String input;
		do {
			System.out.print("[생년월일을 입력하세요(8자리)]\n>> ");
			input = scanner.next();
			System.out.println();
			if (input.length() != 8) {
				System.out.print("다시 입력해주세요. (8자리)");
			}
		} while (input.length() != 8);
		return input;
	}

	public int ticketCount() { // 구매수량
		int input;
		do {
			System.out.print("[티켓 구매 수량을 입력하세요(최대 10개)]\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 10) {
				System.out.println("최대 10장까지 구매할 수 있습니다.\n");
			}
		} while (input > 10);
		return input;
	}

	public int selectDiscount() { // 종합이용권일때
		int input;
		do {
			System.out.println("[우대사항을 선택하세요]");
			System.out.println("1. 없음(나이 우대는 자동 처리))");
			System.out.println("2. 장애인");
			System.out.println("3. 국가유공자");
			System.out.println("4. 휴가장병");
			System.out.println("5. 임산부");
			System.out.print("6. 다둥이행복카드\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 6) {
				System.out.println("다시 선택해주세요.\n");
			}
		} while (input > 6);
		return input;
	}

	public int selectDiscount_PARK() { // 파크이용권일때
		int input;
		do {
			System.out.println("[우대사항을 선택하세요]");
			System.out.println("1. 없음(나이 우대는 자동 처리)");
			System.out.println("2. 장애인");
			System.out.println("3. 국가유공자");
			System.out.print("4. 휴가장병\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 4) {
				System.out.println("다시 선택해주세요.\n");
			}
		} while (input > 4);
		return input;
	}
}
