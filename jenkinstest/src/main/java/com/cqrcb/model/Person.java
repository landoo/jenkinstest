package com.cqrcb.model;

import org.appfuse.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="person",catalog="myappfuse")
@Indexed
@XmlRootElement
public class Person extends BaseObject implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="first_name", length=50)
    @Field
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="last_name", length=50)
    @Field
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person pojo = (Person) o;

        if (firstName != null ? !firstName.equals(pojo.firstName) : pojo.firstName != null) return false;
        if (lastName != null ? !lastName.equals(pojo.lastName) : pojo.lastName != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("firstName").append("='").append(getFirstName()).append("', ");
        sb.append("lastName").append("='").append(getLastName()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
