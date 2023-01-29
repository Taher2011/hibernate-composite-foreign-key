package com.techgen.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "companyName", column = @Column(name = "company_name")),
			@AttributeOverride(name = "companyCode", column = @Column(name = "company_code")) })
	private CompanyPrimaryKey companyPrimaryKey;

	private String city;

	private boolean status;

	public Company(CompanyPrimaryKey companyPrimaryKey) {
		super();
		this.companyPrimaryKey = companyPrimaryKey;
	}

	@OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
	private Set<Employee> employees = new HashSet<>();

	public void addEmployee(Employee employee) {
		employees.add(employee);
		employee.setCompany(this);
	}

}
