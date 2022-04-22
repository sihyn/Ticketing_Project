package Ticketing;

import java.util.Scanner;

public class Ticketing {

	public void ticketingProcess() {
		int ticketend;
		Scanner scanner = new Scanner(System.in);

		do {
			Ticket_Input input = new Ticket_Input();
			Ticket_Print print = new Ticket_Print();
			Ticket_Program calculation = new Ticket_Program();

			int totalSum = 0; // 총합 초기화
			
			while (true) {
				OrderData orderItem = new OrderData();

				orderItem.setTicketType(input.selectTicket());
				// 티켓 종류 세팅하기
				orderItem.setTicketTimeType(input.selectTicketTime());
				// 티켓 시간 세팅하기
				orderItem.setNumber(input.inputIDnumber());
				// 생년월일 입력
				orderItem.setAmount(input.ticketCount());
				// 티켓 수 세팅하기
				if (orderItem.getTicketType() == 1) {
					orderItem.setDiscount(input.selectDiscount()); // 종합권 이용시 우대사항
				} else {
					orderItem.setDiscount(input.selectDiscount_PARK()); // 파크권 이용시 우대사항
				}
				orderItem.setAge(calculation.CalAge(orderItem.getNumber()));
				// 나이 가져오기
				orderItem.setAgegroup(calculation.calAgeGroup(orderItem.getAge()));
				// 연령별 그룹 세팅하기
				int ticketprice = calculation.calcTicketPrice(orderItem);
				// 할인 전 티켓가격 세팅하기
				orderItem.setPrice(calculation.calDiscount(ticketprice, orderItem.getDiscount()));
				// 할인 후 티켓가격 세팅하기

				totalSum += orderItem.getPrice() * orderItem.getAmount(); 
				// totalSum = 우대 할인가격 * 티켓 수
				orderItem.setTotalSum(totalSum); //총 가격
				
				Ticket_Input.orderList.add(orderItem); //orderList에 값들을 다 넣기
				
				int selectReset = print.Reset(); //리셋
				if (selectReset == 2) {
					break;
				}
			}
			
			print.printTotalSum(totalSum); // 구매한 티켓 출력
			
			System.out.print("[계속 진행]\n1: 새 티켓 발권, 2: 프로그램 종료\n>> ");
			ticketend = scanner.nextInt();
			System.out.println();
			if (ticketend == 2) {
				System.out.println("*이용해주셔서 감사합니다*");
			}
		} while (ticketend == 1);
	}	
}


