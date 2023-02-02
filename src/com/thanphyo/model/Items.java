package com.thanphyo.model;

public class Items {
	int id;
	String datetime;
	String name;
	int cp;
	int myan;
	int simee;
	int invest;
	int profit;
	int price;

	public Items(int id, String datetime, String name, int cp, int myan, int simee, int invest, int profit, int price) {
		super();
		this.id = id;
		this.datetime = datetime;
		this.name = name;
		this.cp = cp;
		this.myan = myan;
		this.simee = simee;
		this.invest = invest;
		this.profit = profit;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getMyan() {
		return myan;
	}

	public void setMyan(int myan) {
		this.myan = myan;
	}

	public int getSimee() {
		return simee;
	}

	public void setSimee(int simee) {
		this.simee = simee;
	}

	public int getInvest() {
		return invest;
	}

	public void setInvest(int invest) {
		this.invest = invest;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
