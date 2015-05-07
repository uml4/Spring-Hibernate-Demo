package com.pnv.models;
// Generated Apr 24, 2015 4:37:16 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Employees generated by hbm2java
 */
@Entity
@Table(name="employees"
    ,catalog="pnv"
)
public class Employees  implements java.io.Serializable {


     private Integer id;
     @JsonIgnore
     private Departments departments;
     @JsonIgnore
     private Titles titles;
     @NotEmpty
     private String empName;
     private String address;

    public Employees() {
    }

    public Employees(Departments departments, Titles titles, String empName, String address) {
       this.departments = departments;
       this.titles = titles;
       this.empName = empName;
       this.address = address;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    public Departments getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="title_id")
    public Titles getTitles() {
        return this.titles;
    }
    
    public void setTitles(Titles titles) {
        this.titles = titles;
    }

    
    @Column(name="emp_name")
    public String getEmpName() {
        return this.empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    
    @Column(name="address", length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

}

