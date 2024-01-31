package com.practice.entity;

import java.io.Serializable;

//import javax.persistence.Column;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_details")

public class Employee implements Serializable{

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
//	@Column(name = "id")
	private int eid;
	
	private String ename;
	
	private String esal;
	
	private String deptno;

	public Employee(int eid, String ename, String esal, String deptno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.deptno = deptno;
	}

	public Employee() {
		super();
		
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsal() {
		return esal;
	}

	public void setEsal(String esal) {
		this.esal = esal;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	
}
