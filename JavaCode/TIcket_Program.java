package Ticketing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Ticket_Program {
	Scanner scanner = new Scanner(System.in);
	OrderData orderItem;
	ArrayList<OrderData> orderList = new ArrayList<OrderData>();

	void startSystem() {
		do {
			do {
				inputAll(); //�Է�
				ticketAll(); //��� �� [�߱�/����] ����
			} while (StaticData.reset == 1);
			receipt(); //Ƽ�� ��� �� [�߱�/����] ����
		} while (StaticData.next == 1);
		System.out.printf("\n!�̿��� �ּż� �����մϴ�!\n");
		return;
	}	

	int selectTicket() {
		do {
			System.out.printf("[�̿�� ����]\n\n1. �����̿��(�μӹڹ���+���̰���)\n2. ��ũ�̿��(���̰���)\n-> ");
			orderItem.passType = scanner.nextInt();
			if (!(orderItem.passType == 1 || orderItem.passType == 2)) {
				System.out.println("\n---�ٽ� ������ �ּ���---");
			}
		} while (!(orderItem.passType == 1 || orderItem.passType == 2));
		return orderItem.passType;
	}

	void selectTicketTime() {
		do {
			System.out.printf("\n[�̿�ð� ����]\n\n1. 1Day(���ϱ�)\n2. After4(4�� ���� ���尡��)\n-> ");
			StaticData.passtime = scanner.nextInt();
			if (!(StaticData.passtime == 1 || StaticData.passtime == 2)) {
				System.out.printf("\n---�ٽ� ������ �ּ���---\n");
			}
		} while (!(StaticData.passtime == 1 || StaticData.passtime == 2));
	}

	void inputIDnumber() {
		do {
			System.out.printf("\n[��������� �Է��ϼ���](8�ڸ�)\n-> ");
			StaticData.birth = scanner.nextInt();
			if (!(StaticData.birth >= 19000101 && StaticData.birth <= 20221231)) {
				System.out.printf("\n---�ٽ� �Է��� �ּ���---\n");
			}
		} while (!(StaticData.birth >= 19000101 && StaticData.birth <= 20221231));
	}

	int inputTicketCount() {
		do {
			System.out.printf("\n[Ƽ�� ���� ��](�ִ�10��)\n-> ");
			orderItem.orderCount = scanner.nextInt();
			if (orderItem.orderCount > 10) {
				System.out.printf("\n---�ִ� ���� ������ 10���Դϴ�---\n");
			}
		} while (orderItem.orderCount > 10);
		return orderItem.orderCount;
	}

	int inputSpecial() {
		do {
			System.out.printf("\n[������ ����]\n\n1. ����\n2. �����\n3. ����������\n");
			System.out.printf("4. �ް��庴\n5. �ӻ��\n6. �ٵ��� �ູī��\n-> ");
			orderItem.specialType = scanner.nextInt();
			if (!(orderItem.specialType == 1 || orderItem.specialType == 2 || orderItem.specialType == 3
					|| orderItem.specialType == 4 || orderItem.specialType == 5 || orderItem.specialType == 6)) {
				System.out.printf("\n---�ٽ� ������ �ּ���---\n");
			}
		} while (!(orderItem.specialType == 1 || orderItem.specialType == 2 || orderItem.specialType == 3
				|| orderItem.specialType == 4 || orderItem.specialType == 5 || orderItem.specialType == 6));
		return orderItem.specialType;
	}

	void ageCalculation() {
		SimpleDateFormat MMdd = new SimpleDateFormat("MMdd");
		SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
		Calendar today = Calendar.getInstance();
		String todayDate = MMdd.format(today.getTime());
		String todayYear = yyyy.format(today.getTime());
		int birthday = Integer.parseInt(todayDate);
		int birthyear = Integer.parseInt(todayYear);

		StaticData.ageyear = StaticData.birth / 10000; // �⵵�� ������
		int date = StaticData.birth - (StaticData.ageyear * 10000);
		if (date > (int) birthday) { // ������ ���� ������ ��
			StaticData.age = ((int) birthyear - StaticData.ageyear) - 1;
		} else if (date <= birthday) { // ������ ���� ���� ��
			StaticData.age = birthyear - StaticData.ageyear;
		}
	}

	int ageIndex() {
		if (StaticData.age >= 65) {
			orderItem.ageType = 1; // 65�� �̻� -> ageindex1
		} else if (StaticData.age > 18 && StaticData.age < 65) { // 19-64��-> ageindex2
			orderItem.ageType = 2;
		} else if (StaticData.age >= 13) { // 13-18��-> ageindex3
			orderItem.ageType = 3;
		} else if (StaticData.age >= 3) { // 3-12��-> ageindex4
			orderItem.ageType = 4;
		} else if (StaticData.age >= 1) { // 1-2��-> ageindex5
			orderItem.ageType = 5;
		} else {
			orderItem.ageType = 6; // 12���� �̸�-> ageindex6
		}
		return orderItem.ageType;
	}

	void Pass_agePrice() {
		switch (orderItem.passType) {
		case 1:
			switch (StaticData.passtime) {
			case 1:
				if (orderItem.ageType == 1) {
					StaticData.price = StaticData.child1day;
				} else if (orderItem.ageType == 2) {
					StaticData.price = StaticData.adult1day;
				} else if (orderItem.ageType == 3) {
					StaticData.price = StaticData.student1day;
				} else if (orderItem.ageType == 4) {
					StaticData.price = StaticData.child1day;
				} else if (orderItem.ageType == 5) {
					StaticData.price = StaticData.baby1day;
				} else if (orderItem.ageType == 6) {
					StaticData.price = StaticData.free;
				}
				break;
			case 2:
				if (orderItem.ageType == 1) {
					StaticData.price = StaticData.child4pm;
				} else if (orderItem.ageType == 2) {
					StaticData.price = StaticData.adult4pm;
				} else if (orderItem.ageType == 3) {
					StaticData.price = StaticData.student4pm;
				} else if (orderItem.ageType == 4) {
					StaticData.price = StaticData.child4pm;
				} else if (orderItem.ageType == 5) {
					StaticData.price = StaticData.baby4pm;
				} else if (orderItem.ageType == 6) {
					StaticData.price = StaticData.free;
				}
				break;
			}
			break;
		case 2:
			switch (StaticData.passtime) {
			case 1:
				if (orderItem.ageType == 1) {
					StaticData.price = StaticData.childpark;
				} else if (orderItem.ageType == 2) {
					StaticData.price = StaticData.adultpark;
				} else if (orderItem.ageType == 3) {
					StaticData.price = StaticData.studentpark;
				} else if (orderItem.ageType == 4) {
					StaticData.price = StaticData.childpark;
				} else if (orderItem.ageType == 5) {
					StaticData.price = StaticData.babypark;
				} else if (orderItem.ageType == 6) {
					StaticData.price = StaticData.free;
				}
				break;
			case 2:
				if (orderItem.ageType == 1) {
					StaticData.price = StaticData.childpark4;
				} else if (orderItem.ageType == 2) {
					StaticData.price = StaticData.adultpark4;
				} else if (orderItem.ageType == 3) {
					StaticData.price = StaticData.studentpark4;
				} else if (orderItem.ageType == 4) {
					StaticData.price = StaticData.childpark4;
				} else if (orderItem.ageType == 5) {
					StaticData.price = StaticData.babypark4;
				} else if (orderItem.ageType == 6) {
					StaticData.price = StaticData.free;
				}
				break;
			}
			break;
		}
	}

	void addTicketCount() {
		if (orderItem.orderCount < 11) {
			StaticData.countprice = StaticData.price * orderItem.orderCount;
		}
	}

	int specialDiscount() {
		switch (orderItem.specialType) {
		case 1:
			orderItem.ticketPrice = (int) (StaticData.countprice / 10) * 10;
			break;
		case 2:
			orderItem.ticketPrice = (int) ((StaticData.countprice * 0.5) / 10) * 10;
			break;
		case 3:
			orderItem.ticketPrice = (int) ((StaticData.countprice * 0.5) / 10) * 10;
			break;
		case 4:
			orderItem.ticketPrice = (int) ((StaticData.countprice * 0.51) / 10) * 10;
			if (orderItem.passType != 1) {
				orderItem.ticketPrice = (StaticData.countprice / 10) * 10;
			}
			break;
		case 5:
			orderItem.ticketPrice = (int) ((StaticData.countprice * 0.5) / 10) * 10;
			if (orderItem.passType != 1) {
				orderItem.ticketPrice = (StaticData.countprice / 10) * 10;
			}
			break;
		case 6:
			orderItem.ticketPrice = (int) ((StaticData.countprice * 0.7) / 10) * 10;
			if (orderItem.passType != 1) {
				orderItem.ticketPrice = (StaticData.countprice / 10) * 10;
			}
			break;
		}
		StaticData.totalprice += orderItem.ticketPrice;
		return orderItem.ticketPrice;
	}

	void input_dataArr(int pass, int age, int count, int price, int special) {
		orderList.add(orderItem);
	}

	void inputAll() {
		orderItem = new OrderData();
		selectTicket();
		selectTicketTime();
		inputIDnumber();
		inputTicketCount();
		inputSpecial();
	}

	void ticketAll() {
		ageCalculation();
		ageIndex();
		Pass_agePrice();
		addTicketCount();
		specialDiscount();
		input_dataArr(orderItem.passType, orderItem.ageType, orderItem.orderCount, orderItem.ticketPrice,
				orderItem.specialType);
		System.out.printf("\n===Ƽ�ϰ����� %d���Դϴ�===\n", orderItem.ticketPrice);

		do {
			System.out.printf("\n[��� �߱� �Ͻðڽ��ϱ�?]\n 1. �߱� 2. ���� -> ");
			StaticData.reset = scanner.nextInt();
			if (!(StaticData.reset == 1 || StaticData.reset == 2)) {
				System.out.printf("\n�ٽ� ������ �ֽʽÿ�\n");
			}
			System.out.println("***************************");
		} while (!(StaticData.reset == 1 || StaticData.reset == 2));
	}

	void receipt() {
		System.out.printf("\n====================== HELLO WORLD ======================\n");
		System.out.printf("%s\t%s\t%s\t%s\t\t%s\n", "���û���", "����", "�ż�", "����", "������");
		System.out.printf("---------------------------------------------------------\n\n");
		for (int index = 0; index < orderList.size(); index++) {
			switch (orderList.get(index).passType) {
			case 1:
				System.out.printf("%5s", "�����̿�� ");
				break;
			case 2:
				System.out.printf("%5s", "��ũ�̿�� ");
			default:
				break;
			}
			switch (orderList.get(index).ageType) {
			case 1:
				System.out.printf("%s", "65���̻� ");
				break;
			case 2:
				System.out.printf("%s", "���� ");
				break;
			case 3:
				System.out.printf("%s", "�л� ");
				break;
			case 4:
				System.out.printf("%s", "��� ");
				break;
			case 5:
				System.out.printf("%s", "���� ");
				break;
			case 6:
				System.out.printf("%s", "12�����̸� ");
				break;
			}
			System.out.printf("\tx%d\t%d��\t", orderList.get(index).orderCount, orderList.get(index).ticketPrice);

			switch (orderList.get(index).specialType) {
			case 1:
				System.out.printf("%s\n", "\t����");
				break;
			case 2:
				System.out.printf("%s\n", "\t����� ���");
				break;
			case 3:
				System.out.printf("%s\n", "\t���������� ���");
				break;
			case 4:
				System.out.printf("%s\n", "\t�ް��庴 ���");
				break;
			case 5:
				System.out.printf("%s\n", "\t�ӻ�� ���");
				break;
			case 6:
				System.out.printf("%s\n", "\t�ٵ��� ���");
				break;
			default:
				break;
			}
		}
		System.out.printf("\n---------------------------------------------------------\n");
		System.out.printf(">>�Ѿ��� %d�� �Դϴ�.\n", StaticData.totalprice);
		System.out.printf("======================= THANK YOU =======================\n");

		do {
			System.out.printf("\n[���ο� �ֹ��� �Ͻðڽ��ϱ�?]\n 1. �߱� 2. ���� -> ");
			StaticData.next = scanner.nextInt();
			if (!(StaticData.next == 1 || StaticData.next == 2)) {
				System.out.printf("\n�ٽ� ������ �ֽʽÿ�\n");
			}
			System.out.println("***************************");
		} while (!(StaticData.next == 1 || StaticData.next == 2));
	}

}
