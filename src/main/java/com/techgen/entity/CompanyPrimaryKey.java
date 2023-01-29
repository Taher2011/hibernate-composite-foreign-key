package com.techgen.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompanyPrimaryKey {

	private String companyName;
	private String companyCode;

	public CompanyPrimaryKey(String companyName, String companyCode) {
		this.companyName = companyName;
		this.companyCode = companyCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, companyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyPrimaryKey other = (CompanyPrimaryKey) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(companyName, other.companyName);
	}

}
