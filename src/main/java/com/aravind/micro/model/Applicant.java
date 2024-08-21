package com.aravind.micro.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "applicant_tbl")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicantId;

	@Column
	private String applicantName;

	@Column
	private String email;

	@Column
	private String mobile;

	@Column
	private int age;

	@Column
	private String address;

	@Column
	private String dob;

	@Column
	private String password;

	@Column
	private String occupation;

	@Column
	private String income;

	@Column
	private String gender;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] idProof;

	public Applicant() {
		super();
	}

	public Applicant(int applicantId, String applicantName, String email, String mobile, int age, String address,
			String dob, String password, String occupation, String income, String gender, byte[] idProof) {
		super();
		this.applicantId = applicantId;
		this.applicantName = applicantName;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.address = address;
		this.dob = dob;
		this.password = password;
		this.occupation = occupation;
		this.income = income;
		this.gender = gender;
		this.idProof = idProof;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getIdProof() {
		return idProof;
	}

	public void setIdProof(byte[] idProof) {
		this.idProof = idProof;
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", applicantName=" + applicantName + ", email=" + email
				+ ", mobile=" + mobile + ", age=" + age + ", address=" + address + ", dob=" + dob + ", password="
				+ password + ", occupation=" + occupation + ", income=" + income + ", gender=" + gender + ", idProof="
				+ Arrays.toString(idProof) + "]";
	}

	

	

}
