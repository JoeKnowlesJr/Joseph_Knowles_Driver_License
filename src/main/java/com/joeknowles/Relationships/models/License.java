package com.joeknowles.Relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
    private Date created;
    private Date updated;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    public License() {}
    
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	public Date getExpirationDate() { return expirationDate; }
	public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	public Date getCreatedAt() { return created; }
	public void setCreatedAt(Date created) { this.created = created; }
	public Date getUpdatedAt() { return updated; }
	public void setUpdatedAt(Date updated) { this.updated = updated; }
	public Person getPerson() { return person; }
	public void setPerson(Person person) { this.person = person; }
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
}
