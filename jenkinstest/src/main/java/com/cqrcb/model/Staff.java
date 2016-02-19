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
@Table(name="staff",catalog="myappfuse")
@Indexed
@XmlRootElement
public class Staff extends BaseObject implements Serializable {
    private String staffId;
    private String staffName;
    private String staffRemark;
    private Long staffstatus;

    @Id  @DocumentId    
    public String getStaffId() {
        return this.staffId;
    }
    
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    
    @Column(name="StaffName", nullable=false, length=11)
    @Field
    public String getStaffName() {
        return this.staffName;
    }
    
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    @Column(name="StaffRemark")
    @Field
    public String getStaffRemark() {
        return this.staffRemark;
    }
    
    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark;
    }
    
    @Column(name="Staffstatus", nullable=false)
    @Field
    public Long getStaffstatus() {
        return this.staffstatus;
    }
    
    public void setStaffstatus(Long staffstatus) {
        this.staffstatus = staffstatus;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff pojo = (Staff) o;

        if (staffName != null ? !staffName.equals(pojo.staffName) : pojo.staffName != null) return false;
        if (staffRemark != null ? !staffRemark.equals(pojo.staffRemark) : pojo.staffRemark != null) return false;
        if (staffstatus != null ? !staffstatus.equals(pojo.staffstatus) : pojo.staffstatus != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (staffName != null ? staffName.hashCode() : 0);
        result = 31 * result + (staffRemark != null ? staffRemark.hashCode() : 0);
        result = 31 * result + (staffstatus != null ? staffstatus.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("staffId").append("='").append(getStaffId()).append("', ");
        sb.append("staffName").append("='").append(getStaffName()).append("', ");
        sb.append("staffRemark").append("='").append(getStaffRemark()).append("', ");
        sb.append("staffstatus").append("='").append(getStaffstatus()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
