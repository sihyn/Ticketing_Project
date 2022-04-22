package Ticketing;

import java.util.ArrayList;
import java.util.Scanner;

public class Ticket_Print {
	Scanner sc = new Scanner(System.in);

	// Ƽ�� ���
	public void printTotalSum(int totalSum) {
		System.out.println("\n======================HELLO WORLD LAND=========================");
		System.out.println("***************************************************************");
		System.out.println("�� �� ��     *    �� ��    *    �� ��    *    �� ��    *    �� �� �� ��");
		System.out.println("***************************************************************");

		// ArrayList�� ��� for��
		for (int index = 0; index < Ticket_Input.orderList.size(); index++) {
			if (Ticket_Input.orderList.get(index).getTicketType() == 1) { // �����̿�� or ��ũ�̿��
				System.out.print("�����̿��\t\t");
			} else {
				System.out.print("��ũ�̿��\t\t");
			}

			if (Ticket_Input.orderList.get(index).getAgegroup() == 1) { // ���� ����
				System.out.print("����\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 2) {
				System.out.print("���\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 3) {
				System.out.print("û�ҳ�\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 4) {
				System.out.print("����\t");
			} else if (Ticket_Input.orderList.get(index).getAgegroup() == 5) {
				System.out.print("����\t");
			}

			System.out.printf("%5d��\t    ", Ticket_Input.orderList.get(index).getAmount()); // Ƽ�� ��

			System.out.printf("%9d��\t    ",
					Ticket_Input.orderList.get(index).getPrice() * Ticket_Input.orderList.get(index).getAmount()); // ���ΰ� * ����

			if (Ticket_Input.orderList.get(index).getDiscount() == 1) { // ������
				System.out.print(" ������ ����\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 2) {
				System.out.print(" ����� ���\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 3) {
				System.out.print(" ���������� ���\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 4) {
				System.out.print(" �ް��庴 ���\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 5) {
				System.out.print(" �ӻ�� ���\n");
			} else if (Ticket_Input.orderList.get(index).getDiscount() == 6) {
				System.out.print(" �ٵ����ູī�� ���\n");
			}
		}
		ArrayList<OrderData> orderList = new ArrayList<>(); // orderList �ʱ�ȭ
		System.out.println("\n===============================================================");
		System.out.printf("Ƽ�� �Ѿ��� %d���Դϴ�.\n\n", totalSum); // Ƽ�� �Ѿ�
	}

	public int Reset() { // ����
		int input;
		do {
			System.out.println("[��� �߱��Ͻðڽ��ϱ�?]");
			System.out.print("1. Ƽ�Ϲ߱�\n2. ����\n>> ");
			input = sc.nextInt();
			System.out.println();
			if (input > 2) {
				System.out.println("�ٽ� �������ּ���.\n");
			}
		} while (input > 2); // ���Ḧ ������ ������
		return input;
	}
}
