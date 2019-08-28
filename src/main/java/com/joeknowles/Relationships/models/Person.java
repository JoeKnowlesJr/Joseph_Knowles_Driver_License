package com.joeknowles.Relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max=255)
    private String firstName;
    @Size(max=255)
    private String lastName;
    @Column(updatable=false)
    private Date created;
    private Date updated;
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
    
    public Person() {}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public Date getCreatedAt() { return created; }
	public void setCreatedAt(Date created) { this.created = created; }
	public Date getUpdatedAt() { return updated; }
	public void setUpdatedAt(Date updated) { this.updated = updated; }
	public License getLicense() { return license; }
	public void setLicense(License license) { this.license = license; }
	
	@Override
	public String toString() {
		return String.format("%s %s", firstName, lastName);
	}
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
}
