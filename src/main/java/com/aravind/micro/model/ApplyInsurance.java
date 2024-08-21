package com.aravind.micro.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "applyInsurance_tbl")
public class ApplyInsurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applyInsuranceId;

	@Column
	private String insuranceDate;

	@Column
	private boolean healthIssue;

	@Column(unique = true)
	private long policyNumber;

	@Column
	private String status;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] reports;

//	@ManyToOne
//	@JoinColumn(name = "insurance_Id")
//	private int insuranceId;

	@ManyToOne
	@JoinColumn(name = "insurance_Id")
	private Insurance insurance;

	@ManyToOne
	@JoinColumn(name = "applicant_Id")
	private Applicant applicant;

	public ApplyInsurance() {
		super();
	}

	public ApplyInsurance(int applyInsuranceId, String insuranceDate, boolean healthIssue, long policyNumber,
			String status, byte[] reports, Insurance insurance, Applicant applicant) {
		super();
		this.applyInsuranceId = applyInsuranceId;
		this.insuranceDate = insuranceDate;
		this.healthIssue = healthIssue;
		this.policyNumber = policyNumber;
		this.status = status;
		this.reports = reports;
		this.insurance = insurance;
		this.applicant = applicant;
	}

	public int getApplyInsuranceId() {
		return applyInsuranceId;
	}

	public void setApplyInsuranceId(int applyInsuranceId) {
		this.applyInsuranceId = applyInsuranceId;
	}

	public String getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(String insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public boolean isHealthIssue() {
		return healthIssue;
	}

	public void setHealthIssue(boolean healthIssue) {
		this.healthIssue = healthIssue;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getReports() {
		return reports;
	}

	public void setReports(byte[] reports) {
		this.reports = reports;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "ApplyInsurance [applyInsuranceId=" + applyInsuranceId + ", insuranceDate=" + insuranceDate
				+ ", healthIssue=" + healthIssue + ", policyNumber=" + policyNumber + ", status=" + status
				+ ", reports=" + Arrays.toString(reports) + ", insurance=" + insurance + ", applicant=" + applicant
				+ "]";
	}

}
