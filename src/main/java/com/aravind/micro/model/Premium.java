package com.aravind.micro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "premium_tbl")
public class Premium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int premiumId;

	@Column
	private double totalAmount;

	@Column
	private double monthly;

	@Column
	private double quartely;

	@Column
	private double halfly;

	@Column
	private double yearly;

	@OneToOne
	@JoinColumn(name = "applicant_Id")
	private Applicant applicant;

	public Premium() {
		super();
	}

	public Premium(int premiumId, double totalAmount, double monthly, double quartely, double halfly, double yearly,
			Applicant applicant) {
		super();
		this.premiumId = premiumId;
		this.totalAmount = totalAmount;
		this.monthly = monthly;
		this.quartely = quartely;
		this.halfly = halfly;
		this.yearly = yearly;
		this.applicant = applicant;
	}

	public int getPremiumId() {
		return premiumId;
	}

	public void setPremiumId(int premiumId) {
		this.premiumId = premiumId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getMonthly() {
		return monthly;
	}

	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}

	public double getQuartely() {
		return quartely;
	}

	public void setQuartely(double quartely) {
		this.quartely = quartely;
	}

	public double getHalfly() {
		return halfly;
	}

	public void setHalfly(double halfly) {
		this.halfly = halfly;
	}

	public double getYearly() {
		return yearly;
	}

	public void setYearly(double yearly) {
		this.yearly = yearly;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Premium [premiumId=" + premiumId + ", totalAmount=" + totalAmount + ", monthly=" + monthly
				+ ", quartely=" + quartely + ", halfly=" + halfly + ", yearly=" + yearly + ", applicant=" + applicant
				+ "]";
	}

}
