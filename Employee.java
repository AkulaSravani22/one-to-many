package com.gloify.OneToMany.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="employeetable")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    private Integer salary;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "empId")
    private Set<EmployeeContact> employeeContacts;

    public Set<EmployeeContact> getEmployeeContacts() {
        return employeeContacts;
    }

    public void setEmployeeContacts(Set<EmployeeContact> employeeContacts) {
        this.employeeContacts = employeeContacts;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Employee setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ",salary=" + salary + ", employeeContacts=" + employeeContacts
                + "]";
    }
}



