package Ticketing;

import java.util.ArrayList;
import java.util.Scanner;

public class Ticket_Input {
	public static ArrayList<OrderData> orderList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	public int selectTicket() { // �̿�� ����
		int input;
		do {
			System.out.println("[�̿���� �����ϼ���]");
			System.out.print("1. �����̿��\n2. ��ũ�̿��\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 2) {
				System.out.println("�ٽ� �������ּ���.\n");
			}
		} while (input > 2);
		return input;
	}

	public int selectTicketTime() { // Ƽ�� �ð�
		int input;
		do {
			System.out.println("[������ �����ϼ���]");
			System.out.print("1. �ְ���(1Day)\n2. �߰���(After4)\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 2) {
				System.out.println("�ٽ� �������ּ���.\n");
			}
		} while (input > 2);
		return input;
	}

	public String inputIDnumber() { // �������
		String input;
		do {
			System.out.print("[��������� �Է��ϼ���(8�ڸ�)]\n>> ");
			input = scanner.next();
			System.out.println();
			if (input.length() != 8) {
				System.out.print("�ٽ� �Է����ּ���. (8�ڸ�)");
			}
		} while (input.length() != 8);
		return input;
	}

	public int ticketCount() { // ���ż���
		int input;
		do {
			System.out.print("[Ƽ�� ���� ������ �Է��ϼ���(�ִ� 10��)]\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 10) {
				System.out.println("�ִ� 10����� ������ �� �ֽ��ϴ�.\n");
			}
		} while (input > 10);
		return input;
	}

	public int selectDiscount() { // �����̿���϶�
		int input;
		do {
			System.out.println("[�������� �����ϼ���]");
			System.out.println("1. ����(���� ���� �ڵ� ó��))");
			System.out.println("2. �����");
			System.out.println("3. ����������");
			System.out.println("4. �ް��庴");
			System.out.println("5. �ӻ��");
			System.out.print("6. �ٵ����ູī��\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 6) {
				System.out.println("�ٽ� �������ּ���.\n");
			}
		} while (input > 6);
		return input;
	}

	public int selectDiscount_PARK() { // ��ũ�̿���϶�
		int input;
		do {
			System.out.println("[�������� �����ϼ���]");
			System.out.println("1. ����(���� ���� �ڵ� ó��)");
			System.out.println("2. �����");
			System.out.println("3. ����������");
			System.out.print("4. �ް��庴\n>> ");
			input = scanner.nextInt();
			System.out.println();
			if (input > 4) {
				System.out.println("�ٽ� �������ּ���.\n");
			}
		} while (input > 4);
		return input;
	}
}
