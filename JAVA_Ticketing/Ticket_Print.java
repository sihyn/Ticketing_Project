package Ticketing;

import java.util.ArrayList;
import java.util.Scanner;

public class Ticket_Print {
	Scanner sc = new Scanner(System.in);

	// 티켓 출력
	public void printTotalSum(int totalSum) {
		System.out.println("\n======================HELLO WORLD LAND=========================");
		System.out.println("***************************************************************");
		System.out.println("이 용 권     *    조 건    *    개 수    *    가 격    *    우 대 사 항");
		System.out.println("***************************************************************");

		// ArrayList값 출력 for문
		for (int index = 0; index < Ticket_Input.orderList.size(); index++) {
			if (Ticket_Input.orderList.get(index).getTicketType() == 1) { // 종합이용권 or 파크이용권
				System.out.print("종합이용권\t\t");
			} else {
				System.out.print("파크이용권\t\t");
			}

			if (Ticket_Input.orderList.get(index).getAgegroup() == 1) { // 연령 구분
				System.out.print("유아\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 2) {
				System.out.print("어린이\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 3) {
				System.out.print("청소년\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 4) {
				System.out.print("노인\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 5) {
				System.out.print("성인\t");
			}

			System.out.printf("%5d개\t    ", Ticket_Input.orderList.get(index).getAmount()); // 티켓 수

			System.out.printf("%9d원\t    ",
					Ticket_Input.orderList.get(index).getPrice() * Ticket_Input.orderList.get(index).getAmount()); // 할인가 * 개수

			if (Ticket_Input.orderList.get(index).getDiscount() == 1) { // 우대사항
				System.out.print(" 우대사항 없음\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 2) {
				System.out.print(" 장애인 우대\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 3) {
				System.out.print(" 국가유공자 우대\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 4) {
				System.out.print(" 휴가장병 우대\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 5) {
				System.out.print(" 임산부 우대\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 6) {
				System.out.print(" 다둥이행복카드 우대\n");
			}
		}
		ArrayList<OrderData> orderList = new ArrayList<>(); // orderList 초기화
		System.out.println("\n===============================================================");
		System.out.printf("티켓 총액은 %d원입니다.\n\n", totalSum); // 티켓 총액
	}

	public int Reset() { // 리셋
		int input;
		do {
			System.out.println("[계속 발권하시겠습니까?]");
			System.out.print("1. 티켓발권\n2. 종료\n>> ");
			input = sc.nextInt();
			System.out.println();
			if (input > 2) {
				System.out.println("다시 선택해주세요.\n");
			}
		} while (input > 2); // 종료를 누르기 전까지
		return input;
	}
}
