package Ticketing;

import java.util.Calendar;

public class Ticket_Program {
	// ������ ���ϱ�
	public int CalAge(String num) {
		Calendar today = Calendar.getInstance();
		int yearToday = Calendar.getInstance().get(Calendar.YEAR);
		int monthToday = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int dayToday = Calendar.getInstance().get(Calendar.DATE);

		int birthyear, birthmonth, birthday, myage;

		birthyear = Integer.parseInt(num.substring(0, 4));	//�⵵
		birthmonth = Integer.parseInt(num.substring(4, 6));	//��
		birthday = Integer.parseInt(num.substring(6, 8));	//��

		if (birthmonth > monthToday) { //������ �� > ������ ��
			myage = (yearToday - birthyear + 1) - 2;
		} else if (birthmonth == monthToday) { //���� �� = ���� ��
			if (birthday > dayToday) { //���� > ����
				myage = (yearToday - birthyear + 1) - 2;
			} else { //���� <= ����
				myage = (yearToday - birthyear + 1) - 1;
			}
		} else { //���� �� < ���� ��
			myage = (yearToday - birthyear + 1) - 1;
		}
		return myage;
	}

	// ���ɱ��� : 0=baby, 1=kids, 2=Teen, 3=Old, 4=Adult
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
		// [1=baby, 2=child, 3=teen, 4=old, 5=adult] //old(����)�� child����
		int price = 0;
		int DayPrice[] = { StaticData.BABY_ALL_DAY, StaticData.CHILD_ALL_DAY, StaticData.TEEN_ALL_DAY,
				StaticData.CHILD_ALL_DAY, StaticData.ADULT_ALL_DAY };
		int After4Price[] = { StaticData.BABY_ALL_AFTER4, StaticData.CHILD_ALL_AFTER4, StaticData.TEEN_ALL_AFTER4,
				StaticData.CHILD_ALL_AFTER4, StaticData.ADULT_ALL_AFTER4 };
		int parkDayPrice[] = { StaticData.BABY_PARK_DAY, StaticData.CHILD_PARK_DAY, StaticData.TEEN_PARK_DAY,
				StaticData.CHILD_PARK_DAY, StaticData.ADULT_PARK_DAY };
		int parkAfter4Price[] = { StaticData.BABY_PARK_AFTER4, StaticData.CHILD_PARK_AFTER4,
				StaticData.TEEN_PARK_AFTER4, StaticData.CHILD_PARK_AFTER4, StaticData.ADULT_PARK_AFTER4 };

		if (orderItem.getTicketType() == 1) { // �����̿��
			switch (orderItem.getTicketTimeType()) {
			case 1: // ���ϱ� 
				price = DayPrice[orderItem.getAgegroup() - 1]; // �迭�� 0���� �����ϴϱ� 1�� ���ش�
				break;
			case 2: {  // After4
				price = After4Price[orderItem.getAgegroup() - 1]; 
				break;
			}
		  }
		}
		if (orderItem.getTicketType() == 2) { // ��ũ�̿��
			switch (orderItem.getTicketTimeType()) {
			case 1: { // ���ϱ�
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

	//������ ���η� ����
	public int calDiscount(int price, int preferenceType) {
		if (preferenceType == 1) { // ����
			price = price;
		} else if (preferenceType == 2) { // �����
			price = (int) (price * 0.5);
		} else if (preferenceType == 3) { // ����������
			price = (int) (price * 0.5);
		} else if (preferenceType == 4) { // �ٵ���
			price = (int) (price * 0.7);
		} else if (preferenceType == 5) { // �ӻ��
			price = (int) (price * 0.5);
		} else if (preferenceType == 6) { // �ް��庴
			price = (int) (price * 0.51);
		}
		return price;
	}
}