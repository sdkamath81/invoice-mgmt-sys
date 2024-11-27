package com.egdk.invoicesys.dto;

import com.egdk.invoicesys.enums.InvoiceStatus;

public class InvoiceRequest {	

	private double amount;
	private String due_date;
	private double late_fee;
	public InvoiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InvoiceRequest(double amount, String due_date, double late_fee) {
		super();
		this.amount = amount;
		this.due_date = due_date;
		this.late_fee = late_fee;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public double getLate_fee() {
		return late_fee;
	}

	public void setLate_fee(double late_fee) {
		this.late_fee = late_fee;
	}

}
