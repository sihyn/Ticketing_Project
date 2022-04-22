package Ticketing;

import java.util.Calendar;

public class Ticket_Program {
	// 만나이 구하기
	public int CalAge(String num) {
		Calendar today = Calendar.getInstance();
		int yearToday = Calendar.getInstance().get(Calendar.YEAR);
		int monthToday = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int dayToday = Calendar.getInstance().get(Calendar.DATE);

		int birthyear, birthmonth, birthday, myage;

		birthyear = Integer.parseInt(num.substring(0, 4));	//년도
		birthmonth = Integer.parseInt(num.substring(4, 6));	//월
		birthday = Integer.parseInt(num.substring(6, 8));	//일

		if (birthmonth > monthToday) { //생일의 달 > 오늘의 달
			myage = (yearToday - birthyear + 1) - 2;
		} else if (birthmonth == monthToday) { //생일 달 = 오늘 달
			if (birthday > dayToday) { //생일 > 오늘
				myage = (yearToday - birthyear + 1) - 2;
			} else { //생일 <= 오늘
				myage = (yearToday - birthyear + 1) - 1;
			}
		} else { //생일 달 < 오늘 달
			myage = (yearToday - birthyear + 1) - 1;
		}
		return myage;
	}

	// 연령구분 : 0=baby, 1=kids, 2=Teen, 3=Old, 4=Adult
	public int calAgeGroup(int age) {
		int group = 0; // Baby
		if (age < 2) {
			group = 1; // Kids
		} else if (age >= 3 && age <= 12) {
			group = 2; // Teen
		} else if (age >= 13 && age <= 18) {
			group = 3; // Old
		} else if (age >= 65) {
			group = 4; // Adult
		} else if (age >= 19 && age <= 64) {
			group = 5;
		}
		return group;
	}

	public int calcTicketPrice(OrderData orderItem) {
		// [1=baby, 2=child, 3=teen, 4=old, 5=adult] //old(노인)는 child가격
		int price = 0;
		int DayPrice[] = { StaticData.BABY_ALL_DAY, StaticData.CHILD_ALL_DAY, StaticData.TEEN_ALL_DAY,
				StaticData.CHILD_ALL_DAY, StaticData.ADULT_ALL_DAY };
		int After4Price[] = { StaticData.BABY_ALL_AFTER4, StaticData.CHILD_ALL_AFTER4, StaticData.TEEN_ALL_AFTER4,
				StaticData.CHILD_ALL_AFTER4, StaticData.ADULT_ALL_AFTER4 };
		int parkDayPrice[] = { StaticData.BABY_PARK_DAY, StaticData.CHILD_PARK_DAY, StaticData.TEEN_PARK_DAY,
				StaticData.CHILD_PARK_DAY, StaticData.ADULT_PARK_DAY };
		int parkAfter4Price[] = { StaticData.BABY_PARK_AFTER4, StaticData.CHILD_PARK_AFTER4,
				StaticData.TEEN_PARK_AFTER4, StaticData.CHILD_PARK_AFTER4, StaticData.ADULT_PARK_AFTER4 };

		if (orderItem.getTicketType() == 1) { // 종합이용권
			switch (orderItem.getTicketTimeType()) {
			case 1: // 종일권 
				price = DayPrice[orderItem.getAgegroup() - 1]; // 배열은 0부터 시작하니까 1을 빼준다
				break;
			case 2: {  // After4
				price = After4Price[orderItem.getAgegroup() - 1]; 
				break;
			}
		  }
		}
		if (orderItem.getTicketType() == 2) { // 파크이용권
			switch (orderItem.getTicketTimeType()) {
			case 1: { // 종일권
				price = parkDayPrice[orderItem.getAgegroup() - 1]; 
				break;
			}
			case 2: { //After4
				price = parkAfter4Price[orderItem.getAgegroup() - 1]; 
				break;
			}
			}
		}
		return price;
	}

	//우대사항 할인률 가격
	public int calDiscount(int price, int preferenceType) {
		if (preferenceType == 1) { // 없음
			price = price;
		} else if (preferenceType == 2) { // 장애인
			price = (int) (price * 0.5);
		} else if (preferenceType == 3) { // 국가유공자
			price = (int) (price * 0.5);
		} else if (preferenceType == 4) { // 다둥이
			price = (int) (price * 0.7);
		} else if (preferenceType == 5) { // 임산부
			price = (int) (price * 0.5);
		} else if (preferenceType == 6) { // 휴가장병
			price = (int) (price * 0.51);
		}
		return price;
	}
}