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
@Table(name = "risk_tbl")
public class Risk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int riskId;

	@Column
	private int riskScore;

	@Column
	private String riskType;

	@OneToOne
	@JoinColumn(name = "applicant_Id")
	private Applicant applicants;

	public Risk() {
		super();
	}

	public Risk(int riskId, int riskScore, String riskType, Applicant applicants) {
		super();
		this.riskId = riskId;
		this.riskScore = riskScore;
		this.riskType = riskType;
		this.applicants = applicants;
	}

	public int getRiskId() {
		return riskId;
	}

	public void setRiskId(int riskId) {
		this.riskId = riskId;
	}

	public int getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public Applicant getApplicants() {
		return applicants;
	}

	public void setApplicants(Applicant applicants) {
		this.applicants = applicants;
	}

	@Override
	public String toString() {
		return "Risk [riskId=" + riskId + ", riskScore=" + riskScore + ", riskType=" + riskType + ", applicants="
				+ applicants + "]";
	}

}
