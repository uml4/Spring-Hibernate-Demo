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
 * Titles generated by hbm2java
 */
@Entity
@Table(name = "titles", catalog = "pnv"
)
public class Titles implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "title_code", nullable = false, length = 45)
    @NotEmpty
    private String titleCode;
    
    @Column(name = "title_name", nullable = false, length = 45)
    @NotEmpty
    private String titleName;
    
    @Column(name = "description", length = 65535)
    private String description;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "titles")
    private List<Employees> employees;

    public Titles() {
    }

    public Titles(String titleCode, String titleName, String description) {
        this.titleCode = titleCode;
        this.titleName = titleName;
        this.description = description;
    }

    public Titles(String titleCode, String titleName, String description, List<Employees> employeeses) {
        this.titleCode = titleCode;
        this.titleName = titleName;
        this.description = description;
        this.employees = employeeses;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleCode() {
        return this.titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employees> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

}
