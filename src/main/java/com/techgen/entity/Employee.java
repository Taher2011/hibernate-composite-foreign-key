package com.techgen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
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
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String department;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "company_name", referencedColumnName = "company_name"),
			@JoinColumn(name = "company_code", referencedColumnName = "company_code") })
	private Company company;

	public Employee(String name, String department, Company company) {
		super();
		this.name = name;
		this.department = department;
		this.company = company;
	}

}
