package com.pnv.models;
// Generated Apr 24, 2015 4:37:16 PM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Departments generated by hbm2java
 */
@Entity
@Table(name = "departments", catalog = "pnv"
)
public class Departments implements java.io.Serializable {

    private Integer id;
    @NotEmpty
    private String depCode;
    @NotEmpty
    private String depName;
    private String description;
    private List<Employees> employees;

    public Departments() {
    }

    public Departments(String depCode, String depName, String description, List<Employees> employees) {
        this.depCode = depCode;
        this.depName = depName;
        this.description = description;
        this.employees = employees;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dep_code", length = 45)
    public String getDepCode() {
        return this.depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    @Column(name = "dep_name", length = 45)
    public String getDepName() {
        return this.depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Column(name = "description", length = 65535)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departments")
    public List<Employees> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

}
