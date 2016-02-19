package com.cqrcb.model;

import org.appfuse.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="system",catalog="myappfuse")
@Indexed
@XmlRootElement
public class System extends BaseObject implements Serializable {
    private String systemId;
    private String systemAbbreviation;
    private String systemName;
    private String systemRemark;

    @Id  @DocumentId    
    public String getSystemId() {
        return this.systemId;
    }
    
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
    
    @Column(name="SystemAbbreviation", nullable=false, length=16)
    @Field
    public String getSystemAbbreviation() {
        return this.systemAbbreviation;
    }
    
    public void setSystemAbbreviation(String systemAbbreviation) {
        this.systemAbbreviation = systemAbbreviation;
    }
    
    @Column(name="SystemName", nullable=false, length=64)
    @Field
    public String getSystemName() {
        return this.systemName;
    }
    
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
    
    @Column(name="SystemRemark", length=65535)
    @Field
    public String getSystemRemark() {
        return this.systemRemark;
    }
    
    public void setSystemRemark(String systemRemark) {
        this.systemRemark = systemRemark;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        System pojo = (System) o;

        if (systemAbbreviation != null ? !systemAbbreviation.equals(pojo.systemAbbreviation) : pojo.systemAbbreviation != null) return false;
        if (systemName != null ? !systemName.equals(pojo.systemName) : pojo.systemName != null) return false;
        if (systemRemark != null ? !systemRemark.equals(pojo.systemRemark) : pojo.systemRemark != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (systemAbbreviation != null ? systemAbbreviation.hashCode() : 0);
        result = 31 * result + (systemName != null ? systemName.hashCode() : 0);
        result = 31 * result + (systemRemark != null ? systemRemark.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("systemId").append("='").append(getSystemId()).append("', ");
        sb.append("systemAbbreviation").append("='").append(getSystemAbbreviation()).append("', ");
        sb.append("systemName").append("='").append(getSystemName()).append("', ");
        sb.append("systemRemark").append("='").append(getSystemRemark()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
