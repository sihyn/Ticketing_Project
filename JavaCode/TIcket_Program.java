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
				inputAll(); //입력
				ticketAll(); //계산 후 [발권/종료] 선택
			} while (StaticData.reset == 1);
			receipt(); //티켓 출력 후 [발권/종료] 선택
		} while (StaticData.next == 1);
		System.out.printf("\n!이용해 주셔서 감사합니다!\n");
		return;
	}	

	int selectTicket() {
		do {
			System.out.printf("[이용권 선택]\n\n1. 종합이용권(민속박물관+놀이공원)\n2. 파크이용권(놀이공원)\n-> ");
			orderItem.passType = scanner.nextInt();
			if (!(orderItem.passType == 1 || orderItem.passType == 2)) {
				System.out.println("\n---다시 선택해 주세요---");
			}
		} while (!(orderItem.passType == 1 || orderItem.passType == 2));
		return orderItem.passType;
	}

	void selectTicketTime() {
		do {
			System.out.printf("\n[이용시간 선택]\n\n1. 1Day(종일권)\n2. After4(4시 이후 입장가능)\n-> ");
			StaticData.passtime = scanner.nextInt();
			if (!(StaticData.passtime == 1 || StaticData.passtime == 2)) {
				System.out.printf("\n---다시 선택해 주세요---\n");
			}
		} while (!(StaticData.passtime == 1 || StaticData.passtime == 2));
	}

	void inputIDnumber() {
		do {
			System.out.printf("\n[생년월일을 입력하세요](8자리)\n-> ");
			StaticData.birth = scanner.nextInt();
			if (!(StaticData.birth >= 19000101 && StaticData.birth <= 20221231)) {
				System.out.printf("\n---다시 입력해 주세요---\n");
			}
		} while (!(StaticData.birth >= 19000101 && StaticData.birth <= 20221231));
	}

	int inputTicketCount() {
		do {
			System.out.printf("\n[티켓 구매 수](최대10장)\n-> ");
			orderItem.orderCount = scanner.nextInt();
			if (orderItem.orderCount > 10) {
				System.out.printf("\n---최대 구매 수량은 10장입니다---\n");
			}
		} while (orderItem.orderCount > 10);
		return orderItem.orderCount;
	}

	int inputSpecial() {
		do {
			System.out.printf("\n[우대사항 선택]\n\n1. 없음\n2. 장애인\n3. 국가유공자\n");
			System.out.printf("4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n-> ");
			orderItem.specialType = scanner.nextInt();
			if (!(orderItem.specialType == 1 || orderItem.specialType == 2 || orderItem.specialType == 3
					|| orderItem.specialType == 4 || orderItem.specialType == 5 || orderItem.specialType == 6)) {
				System.out.printf("\n---다시 선택해 주세요---\n");
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

		StaticData.ageyear = StaticData.birth / 10000; // 년도만 나오게
		int date = StaticData.birth - (StaticData.ageyear * 10000);
		if (date > (int) birthday) { // 생일이 오늘 이후일 때
			StaticData.age = ((int) birthyear - StaticData.ageyear) - 1;
		} else if (date <= birthday) { // 생일이 오늘 안일 때
			StaticData.age = birthyear - StaticData.ageyear;
		}
	}

	int ageIndex() {
		if (StaticData.age >= 65) {
			orderItem.ageType = 1; // 65세 이상 -> ageindex1
		} else if (StaticData.age > 18 && StaticData.age < 65) { // 19-64세-> ageindex2
			orderItem.ageType = 2;
		} else if (StaticData.age >= 13) { // 13-18세-> ageindex3
			orderItem.ageType = 3;
		} else if (StaticData.age >= 3) { // 3-12세-> ageindex4
			orderItem.ageType = 4;
		} else if (StaticData.age >= 1) { // 1-2세-> ageindex5
			orderItem.ageType = 5;
		} else {
			orderItem.ageType = 6; // 12개월 미만-> ageindex6
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
		System.out.printf("\n===티켓가격은 %d원입니다===\n", orderItem.ticketPrice);

		do {
			System.out.printf("\n[계속 발권 하시겠습니까?]\n 1. 발권 2. 종료 -> ");
			StaticData.reset = scanner.nextInt();
			if (!(StaticData.reset == 1 || StaticData.reset == 2)) {
				System.out.printf("\n다시 선택해 주십시오\n");
			}
			System.out.println("***************************");
		} while (!(StaticData.reset == 1 || StaticData.reset == 2));
	}

	void receipt() {
		System.out.printf("\n====================== HELLO WORLD ======================\n");
		System.out.printf("%s\t%s\t%s\t%s\t\t%s\n", "선택사항", "연령", "매수", "가격", "우대사항");
		System.out.printf("---------------------------------------------------------\n\n");
		for (int index = 0; index < orderList.size(); index++) {
			switch (orderList.get(index).passType) {
			case 1:
				System.out.printf("%5s", "종합이용권 ");
				break;
			case 2:
				System.out.printf("%5s", "파크이용권 ");
			default:
				break;
			}
			switch (orderList.get(index).ageType) {
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
			System.out.printf("\tx%d\t%d원\t", orderList.get(index).orderCount, orderList.get(index).ticketPrice);

			switch (orderList.get(index).specialType) {
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
		System.out.printf(">>총액은 %d원 입니다.\n", StaticData.totalprice);
		System.out.printf("======================= THANK YOU =======================\n");

		do {
			System.out.printf("\n[새로운 주문을 하시겠습니까?]\n 1. 발권 2. 종료 -> ");
			StaticData.next = scanner.nextInt();
			if (!(StaticData.next == 1 || StaticData.next == 2)) {
				System.out.printf("\n다시 선택해 주십시오\n");
			}
			System.out.println("***************************");
		} while (!(StaticData.next == 1 || StaticData.next == 2));
	}

}
