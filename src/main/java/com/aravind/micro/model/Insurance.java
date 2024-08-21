package com.aravind.micro.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance_tbl")
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inusranceId;

	@Column
	private String insuranceName;

	@Column
	private String description;
	


	public Insurance() {
		super();
	}

	public Insurance(int inusranceId, String insuranceName, String description) {
		super();
		this.inusranceId = inusranceId;
		this.insuranceName = insuranceName;
		this.description = description;
	}

	public int getInusranceId() {
		return inusranceId;
	}

	public void setInusranceId(int inusranceId) {
		this.inusranceId = inusranceId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Insurance [inusranceId=" + inusranceId + ", insuranceName=" + insuranceName + ", description="
				+ description + "]";
	}

}
