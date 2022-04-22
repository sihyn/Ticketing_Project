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

			int totalSum = 0; // ���� �ʱ�ȭ
			
			while (true) {
				OrderData orderItem = new OrderData();

				orderItem.setTicketType(input.selectTicket());
				// Ƽ�� ���� �����ϱ�
				orderItem.setTicketTimeType(input.selectTicketTime());
				// Ƽ�� �ð� �����ϱ�
				orderItem.setNumber(input.inputIDnumber());
				// ������� �Է�
				orderItem.setAmount(input.ticketCount());
				// Ƽ�� �� �����ϱ�
				if (orderItem.getTicketType() == 1) {
					orderItem.setDiscount(input.selectDiscount()); // ���ձ� �̿�� ������
				} else {
					orderItem.setDiscount(input.selectDiscount_PARK()); // ��ũ�� �̿�� ������
				}
				orderItem.setAge(calculation.CalAge(orderItem.getNumber()));
				// ���� ��������
				orderItem.setAgegroup(calculation.calAgeGroup(orderItem.getAge()));
				// ���ɺ� �׷� �����ϱ�
				int ticketprice = calculation.calcTicketPrice(orderItem);
				// ���� �� Ƽ�ϰ��� �����ϱ�
				orderItem.setPrice(calculation.calDiscount(ticketprice, orderItem.getDiscount()));
				// ���� �� Ƽ�ϰ��� �����ϱ�

				totalSum += orderItem.getPrice() * orderItem.getAmount(); 
				// totalSum = ��� ���ΰ��� * Ƽ�� ��
				orderItem.setTotalSum(totalSum); //�� ����
				
				Ticket_Input.orderList.add(orderItem); //orderList�� ������ �� �ֱ�
				
				int selectReset = print.Reset(); //����
				if (selectReset == 2) {
					break;
				}
			}
			
			print.printTotalSum(totalSum); // ������ Ƽ�� ���
			
			System.out.print("[��� ����]\n1: �� Ƽ�� �߱�, 2: ���α׷� ����\n>> ");
			ticketend = scanner.nextInt();
			System.out.println();
			if (ticketend == 2) {
				System.out.println("*�̿����ּż� �����մϴ�*");
			}
		} while (ticketend == 1);
	}	
}


