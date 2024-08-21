package com.aravind.micro.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_tbl")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payId;

	@Column
	private int amount;

	@Column
	private String payMethod;

	@Column
	private String status;

	@Column
	private Date payDate;

	@ManyToOne
	@JoinColumn(name = "applicant_Id")
	private Applicant applicant;

	@ManyToOne
	@JoinColumn(name = "premium_Id")
	private Premium premium;

	public Payment() {
		super();
	}

	public Payment(int payId, int amount, String payMethod, String status, Date payDate, Applicant applicant,
			Premium premium) {
		super();
		this.payId = payId;
		this.amount = amount;
		this.payMethod = payMethod;
		this.status = status;
		this.payDate = payDate;
		this.applicant = applicant;
		this.premium = premium;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Premium getPremium() {
		return premium;
	}

	public void setPremium(Premium premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", amount=" + amount + ", payMethod=" + payMethod + ", status=" + status
				+ ", payDate=" + payDate + ", applicant=" + applicant + ", premium=" + premium + "]";
	}

}
