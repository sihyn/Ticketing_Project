package Monday;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class JAVA_Ticketing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int adult1day = 62000, student1day = 54000, child1day = 47000, baby1day = 15000, free = 0;
		int adult4pm = 50000, student4pm = 43000, child4pm = 36000, baby4pm = 15000;
		int adultpark = 59000, studentpark = 52000, childpark = 46000, babypark = 15000;
		int adultpark4 = 47000, studentpark4 = 41000, childpark4 = 35000, babypark4 = 15000;

		int pass, passtime, birth;
		int ticketcount, special, ageyear;
		int age = 0, price = 0;
		int ageindex;
		int countprice = 0, ticketprice = 0;
		int reset, next;
		int totalprice = 0, index = 0;

		int[] passArr = new int[10];
		int[] ageindexArr = new int[10];
		int[] ticketcountArr = new int[10];
		int[] specialArr = new int[10];
		int[] ticketpriceArr = new int[10];

		Scanner scanner = new Scanner(System.in);
		do {
			do {
				do {
					System.out.printf("[�̿�� ����]\n\n1. �����̿��(�μӹڹ���+���̰���)\n2. ��ũ�̿��(���̰���)\n-> ");
					pass = scanner.nextInt();
					if (!(pass == 1 || pass == 2)) {
						System.out.println("\n---�ٽ� ������ �ּ���---");
					}
				} while (!(pass == 1 || pass == 2));

				do {
					System.out.printf("\n[�̿�ð� ����]\n\n1. 1Day(���ϱ�)\n2. After4(4�� ���� ���尡��)\n-> ");
					passtime = scanner.nextInt();
					if (!(passtime == 1 || passtime == 2)) {
						System.out.printf("\n---�ٽ� ������ �ּ���---\n");
					}
				} while (!(passtime == 1 || passtime == 2));

				do {
					System.out.printf("\n[��������� �Է��ϼ���](8�ڸ�)\n-> ");
					birth = scanner.nextInt();
					if (!(birth >= 19000101 && birth <= 20221231)) {
						System.out.printf("\n---�ٽ� �Է��� �ּ���---\n");
					}
				} while (!(birth >= 19000101 && birth <= 20221231));

				do {
					System.out.printf("\n[Ƽ�� ���� ��](�ִ�10��)\n-> ");
					ticketcount = scanner.nextInt();
					if (ticketcount > 10) {
						System.out.printf("\n---�ִ� ���� ������ 10���Դϴ�---\n");
					}
				} while (ticketcount > 10);

				do {
					System.out.printf("\n[������ ����]\n\n1. ����\n2. �����\n3. ����������\n");
					System.out.printf("4. �ް��庴\n5. �ӻ��\n6. �ٵ��� �ູī��\n-> ");
					special = scanner.nextInt();
					if (!(special == 1 || special == 2 || special == 3 || special == 4 || special == 5
							|| special == 6)) {
						System.out.printf("\n---�ٽ� ������ �ּ���---\n");
					}
				} while (!(special == 1 || special == 2 || special == 3 || special == 4 || special == 5
						|| special == 6));

				SimpleDateFormat MMdd = new SimpleDateFormat("MMdd");
				SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
				Calendar today = Calendar.getInstance();
				String todayDate = MMdd.format(today.getTime());
				String todayYear = yyyy.format(today.getTime());
				int birthday = Integer.parseInt(todayDate);
				int birthyear = Integer.parseInt(todayYear);

				ageyear = birth / 10000; // �⵵�� ������
				int date = birth - (ageyear * 10000);
				if (date > (int) birthday) { // ������ ���� ������ ��
					age = ((int) birthyear - ageyear) - 1;
				} else if (date <= birthday) { // ������ ���� ���� ��
					age = birthyear - ageyear;
				}

				if (age >= 65) {
					ageindex = 1; // 65�� �̻� -> ageindex1
				} else if (age > 18 && age < 65) { // 19-64��-> ageindex2
					ageindex = 2;
				} else if (age >= 13) { // 13-18��-> ageindex3
					ageindex = 3;
				} else if (age >= 3) { // 3-12��-> ageindex4
					ageindex = 4;
				} else if (age >= 1) { // 1-2��-> ageindex5
					ageindex = 5;
				} else {
					ageindex = 6; // 12���� �̸�-> ageindex6
				}

				switch (pass) {
				case 1:
					switch (passtime) {
					case 1:
						if (ageindex == 1) {
							price = child1day;
						} else if (ageindex == 2) {
							price = adult1day;
						} else if (ageindex == 3) {
							price = student1day;
						} else if (ageindex == 4) {
							price = child1day;
						} else if (ageindex == 5) {
							price = baby1day;
						} else if (ageindex == 6) {
							price = free;
						}
						break;
					case 2:
						if (ageindex == 1) {
							price = child4pm;
						} else if (ageindex == 2) {
							price = adult4pm;
						} else if (ageindex == 3) {
							price = student4pm;
						} else if (ageindex == 4) {
							price = child4pm;
						} else if (ageindex == 5) {
							price = baby4pm;
						} else if (ageindex == 6) {
							price = free;
						}
						break;
					}
					break;
				case 2:
					switch (passtime) {
					case 1:
						if (ageindex == 1) {
							price = childpark;
						} else if (ageindex == 2) {
							price = adultpark;
						} else if (ageindex == 3) {
							price = studentpark;
						} else if (ageindex == 4) {
							price = childpark;
						} else if (ageindex == 5) {
							price = babypark;
						} else if (ageindex == 6) {
							price = free;
						}
						break;

					case 2:
						if (ageindex == 1) {
							price = childpark4;
						} else if (ageindex == 2) {
							price = adultpark4;
						} else if (ageindex == 3) {
							price = studentpark4;
						} else if (ageindex == 4) {
							price = childpark4;
						} else if (ageindex == 5) {
							price = babypark4;
						} else if (ageindex == 6) {
							price = free;
						}
						break;
					}
					break;
				}

				if (ticketcount < 11) {
					countprice = price * ticketcount;
				}

				switch (special) {
				case 1:
					ticketprice = (int) (countprice / 10) * 10;
					break;
				case 2:
					ticketprice = (int) ((countprice * 0.5) / 10) * 10;
					break;
				case 3:
					ticketprice = (int) ((countprice * 0.5) / 10) * 10;
					break;
				case 4:
					ticketprice = (int) ((countprice * 0.51) / 10) * 10;
					if (pass != 1) {
						ticketprice = (countprice / 10) * 10;
					}
					break;
				case 5:
					ticketprice = (int) ((countprice * 0.5) / 10) * 10;
					if (pass != 1) {
						ticketprice = (countprice / 10) * 10;
					}
					break;
				case 6:
					ticketprice = (int) ((countprice * 0.7) / 10) * 10;
					if (pass != 1) {
						ticketprice = (countprice / 10) * 10;
					}
					break;
				}

				System.out.printf("\n===Ƽ�ϰ����� %d���Դϴ�===\n", ticketprice);

				passArr[index] = pass;
				ageindexArr[index] = ageindex;
				ticketcountArr[index] = ticketcount;
				specialArr[index] = special;
				ticketpriceArr[index] = ticketprice;
				totalprice += ticketprice;

				index++;

				do {
					System.out.printf("\n[��� �߱� �Ͻðڽ��ϱ�?]\n 1. �߱� 2. ���� -> ");
					reset = scanner.nextInt();
					if (!(reset == 1 || reset == 2)) {
						System.out.printf("\n�ٽ� ������ �ֽʽÿ�\n");
					}
					System.out.println("***************************");
				} while (!(reset == 1 || reset == 2));
			} while (reset == 1);

			System.out.printf("\n====================== HELLO WORLD ======================\n");
			System.out.printf("%s\t%s\t%s\t%s\t\t%s\n", "���û���", "����", "�ż�", "����", "������");
			System.out.printf("---------------------------------------------------------\n\n");
			for (int i = 0; i < index; i++) {
				switch (passArr[i]) {
				case 1:
					System.out.printf("%5s", "�����̿�� ");
					break;
				case 2:
					System.out.printf("%5s", "��ũ�̿�� ");
				default:
					break;
				}
				switch (ageindexArr[i]) {
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
				System.out.printf("\tx%d\t%d��\t", ticketcountArr[i], ticketpriceArr[i]);

				switch (specialArr[i]) {
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
			System.out.printf(">>�Ѿ��� %d�� �Դϴ�.\n", totalprice);
			System.out.printf("======================= THANK YOU =======================\n");
			do {
				System.out.printf("\n[���ο� �ֹ��� �Ͻðڽ��ϱ�?]\n 1. �߱� 2. ���� -> ");
				next = scanner.nextInt();
				if (!(next == 1 || next == 2)) {
					System.out.printf("\n�ٽ� ������ �ֽʽÿ�\n");
				}
			} while (!(next == 1 || next == 2));
		} while (next == 1);
		System.out.printf("\n!�̿��� �ּż� �����մϴ�!\n");
		System.out.printf("***************************\n");
		return;
	}
}
