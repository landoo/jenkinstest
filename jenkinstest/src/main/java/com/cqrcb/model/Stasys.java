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
@Table(name="stasys",catalog="myappfuse")
@Indexed
@XmlRootElement
public class Stasys extends BaseObject implements Serializable {
    private Long staSysId;
    private String systemId;
    private String staffId;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getStaSysId() {
        return this.staSysId;
    }
    
    public void setStaSysId(Long staSysId) {
        this.staSysId = staSysId;
    }
    
    @Column(name="SystemID", nullable=false, length=6)
    @Field
    public String getSystemId() {
        return this.systemId;
    }
    
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
    
    @Column(name="StaffID", nullable=false, length=7)
    @Field
    public String getStaffId() {
        return this.staffId;
    }
    
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stasys pojo = (Stasys) o;

        if (systemId != null ? !systemId.equals(pojo.systemId) : pojo.systemId != null) return false;
        if (staffId != null ? !staffId.equals(pojo.staffId) : pojo.staffId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (systemId != null ? systemId.hashCode() : 0);
        result = 31 * result + (staffId != null ? staffId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("staSysId").append("='").append(getStaSysId()).append("', ");
        sb.append("systemId").append("='").append(getSystemId()).append("', ");
        sb.append("staffId").append("='").append(getStaffId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
