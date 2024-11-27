package com.egdk.invoicesys.dto;

import com.egdk.invoicesys.enums.InvoiceStatus;

public class InvoiceResponse {	
	
	private int id;
	private double amount;
	private String due_date;
	private double paid_amount;
	private InvoiceStatus status;
	
	public InvoiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceResponse(int id, double amount, String due_date, double paid_amount, InvoiceStatus status) {
		super();
		this.id = id;
		this.amount = amount;
		this.due_date = due_date;
		this.paid_amount = paid_amount;
		this.status = status;
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

	public double getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(double paid_amount) {
		this.paid_amount = paid_amount;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
