package com.kingdee.hljx.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_ad_kdAccount_gl")
@Data
public class TAdKdAccountGl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private int fAcctID;
    private String fAcctNumber;
    private String fAcctName;
    private String fDBName;
    @NotNull
    private int fDBType;
    private String fConnectString;
    private String fCreator;
    private Date fCreateTime;
    private Date fDupTime;
    private String fVersion;
    private int fNodeID;
    private String fServer;
    private Date fBackupTime;
    private String fSysPwd;
    private int fLevel;
    private Integer fIsPort;
    private Integer fSRMRelation;
	public int getfAcctID() {
		return fAcctID;
	}
	public void setfAcctID(int fAcctID) {
		this.fAcctID = fAcctID;
	}
	public String getfAcctNumber() {
		return fAcctNumber;
	}
	public void setfAcctNumber(String fAcctNumber) {
		this.fAcctNumber = fAcctNumber;
	}
	public String getfAcctName() {
		return fAcctName;
	}
	public void setfAcctName(String fAcctName) {
		this.fAcctName = fAcctName;
	}
	public String getfDBName() {
		return fDBName;
	}
	public void setfDBName(String fDBName) {
		this.fDBName = fDBName;
	}
	public int getfDBType() {
		return fDBType;
	}
	public void setfDBType(int fDBType) {
		this.fDBType = fDBType;
	}
	public String getfConnectString() {
		return fConnectString;
	}
	public void setfConnectString(String fConnectString) {
		this.fConnectString = fConnectString;
	}
	public String getfCreator() {
		return fCreator;
	}
	public void setfCreator(String fCreator) {
		this.fCreator = fCreator;
	}
	public Date getfCreateTime() {
		return fCreateTime;
	}
	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}
	public Date getfDupTime() {
		return fDupTime;
	}
	public void setfDupTime(Date fDupTime) {
		this.fDupTime = fDupTime;
	}
	public String getfVersion() {
		return fVersion;
	}
	public void setfVersion(String fVersion) {
		this.fVersion = fVersion;
	}
	public int getfNodeID() {
		return fNodeID;
	}
	public void setfNodeID(int fNodeID) {
		this.fNodeID = fNodeID;
	}
	public String getfServer() {
		return fServer;
	}
	public void setfServer(String fServer) {
		this.fServer = fServer;
	}
	public Date getfBackupTime() {
		return fBackupTime;
	}
	public void setfBackupTime(Date fBackupTime) {
		this.fBackupTime = fBackupTime;
	}
	public String getfSysPwd() {
		return fSysPwd;
	}
	public void setfSysPwd(String fSysPwd) {
		this.fSysPwd = fSysPwd;
	}
	public int getfLevel() {
		return fLevel;
	}
	public void setfLevel(int fLevel) {
		this.fLevel = fLevel;
	}
	public Integer getfIsPort() {
		return fIsPort;
	}
	public void setfIsPort(Integer fIsPort) {
		this.fIsPort = fIsPort;
	}
	public Integer getfSRMRelation() {
		return fSRMRelation;
	}
	public void setfSRMRelation(Integer fSRMRelation) {
		this.fSRMRelation = fSRMRelation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TAdKdAccountGl [fAcctID=" + fAcctID + ", fAcctNumber=" + fAcctNumber + ", fAcctName=" + fAcctName
				+ ", fDBName=" + fDBName + ", fDBType=" + fDBType + ", fConnectString=" + fConnectString + ", fCreator="
				+ fCreator + ", fCreateTime=" + fCreateTime + ", fDupTime=" + fDupTime + ", fVersion=" + fVersion
				+ ", fNodeID=" + fNodeID + ", fServer=" + fServer + ", fBackupTime=" + fBackupTime + ", fSysPwd="
				+ fSysPwd + ", fLevel=" + fLevel + ", fIsPort=" + fIsPort + ", fSRMRelation=" + fSRMRelation + "]";
	}
    
}
