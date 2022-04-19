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
					System.out.printf("[이용권 선택]\n\n1. 종합이용권(민속박물관+놀이공원)\n2. 파크이용권(놀이공원)\n-> ");
					pass = scanner.nextInt();
					if (!(pass == 1 || pass == 2)) {
						System.out.println("\n---다시 선택해 주세요---");
					}
				} while (!(pass == 1 || pass == 2));

				do {
					System.out.printf("\n[이용시간 선택]\n\n1. 1Day(종일권)\n2. After4(4시 이후 입장가능)\n-> ");
					passtime = scanner.nextInt();
					if (!(passtime == 1 || passtime == 2)) {
						System.out.printf("\n---다시 선택해 주세요---\n");
					}
				} while (!(passtime == 1 || passtime == 2));

				do {
					System.out.printf("\n[생년월일을 입력하세요](8자리)\n-> ");
					birth = scanner.nextInt();
					if (!(birth >= 19000101 && birth <= 20221231)) {
						System.out.printf("\n---다시 입력해 주세요---\n");
					}
				} while (!(birth >= 19000101 && birth <= 20221231));

				do {
					System.out.printf("\n[티켓 구매 수](최대10장)\n-> ");
					ticketcount = scanner.nextInt();
					if (ticketcount > 10) {
						System.out.printf("\n---최대 구매 수량은 10장입니다---\n");
					}
				} while (ticketcount > 10);

				do {
					System.out.printf("\n[우대사항 선택]\n\n1. 없음\n2. 장애인\n3. 국가유공자\n");
					System.out.printf("4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n-> ");
					special = scanner.nextInt();
					if (!(special == 1 || special == 2 || special == 3 || special == 4 || special == 5
							|| special == 6)) {
						System.out.printf("\n---다시 선택해 주세요---\n");
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

				ageyear = birth / 10000; // 년도만 나오게
				int date = birth - (ageyear * 10000);
				if (date > (int) birthday) { // 생일이 오늘 이후일 때
					age = ((int) birthyear - ageyear) - 1;
				} else if (date <= birthday) { // 생일이 오늘 안일 때
					age = birthyear - ageyear;
				}

				if (age >= 65) {
					ageindex = 1; // 65세 이상 -> ageindex1
				} else if (age > 18 && age < 65) { // 19-64세-> ageindex2
					ageindex = 2;
				} else if (age >= 13) { // 13-18세-> ageindex3
					ageindex = 3;
				} else if (age >= 3) { // 3-12세-> ageindex4
					ageindex = 4;
				} else if (age >= 1) { // 1-2세-> ageindex5
					ageindex = 5;
				} else {
					ageindex = 6; // 12개월 미만-> ageindex6
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

				System.out.printf("\n===티켓가격은 %d원입니다===\n", ticketprice);

				passArr[index] = pass;
				ageindexArr[index] = ageindex;
				ticketcountArr[index] = ticketcount;
				specialArr[index] = special;
				ticketpriceArr[index] = ticketprice;
				totalprice += ticketprice;

				index++;

				do {
					System.out.printf("\n[계속 발권 하시겠습니까?]\n 1. 발권 2. 종료 -> ");
					reset = scanner.nextInt();
					if (!(reset == 1 || reset == 2)) {
						System.out.printf("\n다시 선택해 주십시오\n");
					}
					System.out.println("***************************");
				} while (!(reset == 1 || reset == 2));
			} while (reset == 1);

			System.out.printf("\n====================== HELLO WORLD ======================\n");
			System.out.printf("%s\t%s\t%s\t%s\t\t%s\n", "선택사항", "연령", "매수", "가격", "우대사항");
			System.out.printf("---------------------------------------------------------\n\n");
			for (int i = 0; i < index; i++) {
				switch (passArr[i]) {
				case 1:
					System.out.printf("%5s", "종합이용권 ");
					break;
				case 2:
					System.out.printf("%5s", "파크이용권 ");
				default:
					break;
				}
				switch (ageindexArr[i]) {
				case 1:
					System.out.printf("%s", "65세이상 ");
					break;
				case 2:
					System.out.printf("%s", "성인 ");
					break;
				case 3:
					System.out.printf("%s", "학생 ");
					break;
				case 4:
					System.out.printf("%s", "어린이 ");
					break;
				case 5:
					System.out.printf("%s", "유아 ");
					break;
				case 6:
					System.out.printf("%s", "12개월미만 ");
					break;
				}
				System.out.printf("\tx%d\t%d원\t", ticketcountArr[i], ticketpriceArr[i]);

				switch (specialArr[i]) {
				case 1:
					System.out.printf("%s\n", "\t없음");
					break;
				case 2:
					System.out.printf("%s\n", "\t장애인 우대");
					break;
				case 3:
					System.out.printf("%s\n", "\t국가유공자 우대");
					break;
				case 4:
					System.out.printf("%s\n", "\t휴가장병 우대");
					break;
				case 5:
					System.out.printf("%s\n", "\t임산부 우대");
					break;
				case 6:
					System.out.printf("%s\n", "\t다둥이 우대");
					break;
				default:
					break;
				}
			}
			System.out.printf("\n---------------------------------------------------------\n");
			System.out.printf(">>총액은 %d원 입니다.\n", totalprice);
			System.out.printf("======================= THANK YOU =======================\n");
			do {
				System.out.printf("\n[새로운 주문을 하시겠습니까?]\n 1. 발권 2. 종료 -> ");
				next = scanner.nextInt();
				if (!(next == 1 || next == 2)) {
					System.out.printf("\n다시 선택해 주십시오\n");
				}
			} while (!(next == 1 || next == 2));
		} while (next == 1);
		System.out.printf("\n!이용해 주셔서 감사합니다!\n");
		System.out.printf("***************************\n");
		return;
	}
}
