package Ticketing;

public class OrderData {
	private int ticketType; // 종합이용권or파크이용권
	private int ticketTimeType; // 1Day or After4
	private String number; // 생년월일(8자리)
	private int discount; // 우대사항(할인)
	private int amount; // 개수
	private int totalSum;
	private int price;
	private int agegroup;
	private int age;

	public OrderData() {
	}

	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getTicketTimeType() {
		return ticketTimeType;
	}

	public void setTicketTimeType(int ticketTimeType) {
		this.ticketTimeType = ticketTimeType;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(int agegroup) {
		this.agegroup = agegroup;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}
}
