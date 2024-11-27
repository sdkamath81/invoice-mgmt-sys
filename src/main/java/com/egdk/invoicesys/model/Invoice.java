package com.egdk.invoicesys.model;

import java.util.Date;

import com.egdk.invoicesys.enums.InvoiceStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_details")
public class Invoice {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "amount")
	private Double amount = 0.00;
	
	@Column(name = "late_fee")
	private Double lateFee = 0.00;
	
	@Column(name = "paid_amount")
	private Double paidAmount = 0.00;
	
	@Column(name = "overdue_days")
	private Integer overdueDays = 0;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "status")
	@Enumerated(EnumType.STRING)
    private InvoiceStatus status = InvoiceStatus.valueOf("PENDING");

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getLateFee() {
		return lateFee;
	}

	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Integer getOverdueDays() {
		return overdueDays;
	}

	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
	
}
