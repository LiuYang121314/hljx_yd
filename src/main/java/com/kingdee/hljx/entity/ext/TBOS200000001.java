/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingdee.hljx.entity.ext;


import com.kingdee.hljx.entity.item.TICItem;
import com.kingdee.hljx.entity.measure.TMeasureUnit;
import com.kingdee.hljx.entity.stock.TStock;
import com.kingdee.hljx.entity.stock.TStockPlace;
import com.kingdee.hljx.entity.submessage.MeasureInType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 入库过磅单
 * @author moon
 */
@Entity
@Table(name = "t_BOS200000001")
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "TBOS200000001.findAll", query = "SELECT t FROM TBOS200000001 t")
//    , @NamedQuery(name = "TBOS200000001.findByFid", query = "SELECT t FROM TBOS200000001 t WHERE t.fid = :fid")
//    , @NamedQuery(name = "TBOS200000001.findByFClassTypeID", query = "SELECT t FROM TBOS200000001 t WHERE t.fClassTypeID = :fClassTypeID")
//    , @NamedQuery(name = "TBOS200000001.findByFBillNo", query = "SELECT t FROM TBOS200000001 t WHERE t.fBillNo = :fBillNo")
//    , @NamedQuery(name = "TBOS200000001.findByFDate", query = "SELECT t FROM TBOS200000001 t WHERE t.fDate = :fDate")
//    , @NamedQuery(name = "TBOS200000001.findByFTime", query = "SELECT t FROM TBOS200000001 t WHERE t.fTime = :fTime")
//    , @NamedQuery(name = "TBOS200000001.findByFBase", query = "SELECT t FROM TBOS200000001 t WHERE t.fBase = :fBase")
//    , @NamedQuery(name = "TBOS200000001.findByFBase1", query = "SELECT t FROM TBOS200000001 t WHERE t.fBase1 = :fBase1")
//    , @NamedQuery(name = "TBOS200000001.findByFQty", query = "SELECT t FROM TBOS200000001 t WHERE t.fQty = :fQty")
//    , @NamedQuery(name = "TBOS200000001.findByFBase2", query = "SELECT t FROM TBOS200000001 t WHERE t.fBase2 = :fBase2")
//    , @NamedQuery(name = "TBOS200000001.findByFQty1", query = "SELECT t FROM TBOS200000001 t WHERE t.fQty1 = :fQty1")
//    , @NamedQuery(name = "TBOS200000001.findByFBase3", query = "SELECT t FROM TBOS200000001 t WHERE t.fBase3 = :fBase3")
//    , @NamedQuery(name = "TBOS200000001.findByFBase4", query = "SELECT t FROM TBOS200000001 t WHERE t.fBase4 = :fBase4")
//    , @NamedQuery(name = "TBOS200000001.findByFBiller", query = "SELECT t FROM TBOS200000001 t WHERE t.fBiller = :fBiller")
//    , @NamedQuery(name = "TBOS200000001.findByFUser", query = "SELECT t FROM TBOS200000001 t WHERE t.fUser = :fUser")
//    , @NamedQuery(name = "TBOS200000001.findByFBase5", query = "SELECT t FROM TBOS200000001 t WHERE t.fBase5 = :fBase5")
//    , @NamedQuery(name = "TBOS200000001.findByFQty2", query = "SELECT t FROM TBOS200000001 t WHERE t.fQty2 = :fQty2")
//    , @NamedQuery(name = "TBOS200000001.findByFBatchNo", query = "SELECT t FROM TBOS200000001 t WHERE t.fBatchNo = :fBatchNo")
//    , @NamedQuery(name = "TBOS200000001.findByFidSrc", query = "SELECT t FROM TBOS200000001 t WHERE t.fidSrc = :fidSrc")
//    , @NamedQuery(name = "TBOS200000001.findByFEntryIDSRC", query = "SELECT t FROM TBOS200000001 t WHERE t.fEntryIDSRC = :fEntryIDSRC")
//    , @NamedQuery(name = "TBOS200000001.findByFBillNoSRC", query = "SELECT t FROM TBOS200000001 t WHERE t.fBillNoSRC = :fBillNoSRC")
//    , @NamedQuery(name = "TBOS200000001.findByFClassIDSRC", query = "SELECT t FROM TBOS200000001 t WHERE t.fClassIDSRC = :fClassIDSRC")
//    , @NamedQuery(name = "TBOS200000001.findByFText", query = "SELECT t FROM TBOS200000001 t WHERE t.fText = :fText")
//    , @NamedQuery(name = "TBOS200000001.findByFInteger", query = "SELECT t FROM TBOS200000001 t WHERE t.fInteger = :fInteger")
//    , @NamedQuery(name = "TBOS200000001.findByFQty3", query = "SELECT t FROM TBOS200000001 t WHERE t.fQty3 = :fQty3")
//    , @NamedQuery(name = "TBOS200000001.findByFInteger1", query = "SELECT t FROM TBOS200000001 t WHERE t.fInteger1 = :fInteger1")
//    , @NamedQuery(name = "TBOS200000001.findByFInteger2", query = "SELECT t FROM TBOS200000001 t WHERE t.fInteger2 = :fInteger2")
//    , @NamedQuery(name = "TBOS200000001.findByFConnectFlag", query = "SELECT t FROM TBOS200000001 t WHERE t.fConnectFlag = :fConnectFlag")
})
public class TBOS200000001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FID")
    private Integer fid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FClassTypeID")
    private final int fClassTypeID=200000001;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FBillNo")
    private String fBillNo;
    @Column(name = "FDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fDate;
    @Column(name = "FTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fTime;
    @JoinColumn(name = "FBase",referencedColumnName="FItemID")
    @ManyToOne
    private TICItem fBase;
    @JoinColumn(name = "FBase1",referencedColumnName="FItemID")
    @ManyToOne
    private TMeasureUnit fBase1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FQty")
    private BigDecimal fQty=BigDecimal.ZERO;
    @Column(name = "FBase2")
    private Integer fBase2=0;
    @Column(name = "FQty1")
    private BigDecimal fQty1=BigDecimal.ZERO;
    @Column(name = "FBase3")
    private Integer fBase3=0;
    @JoinColumn(name = "FBase4",referencedColumnName="FItemID")
    @ManyToOne
    private TItem3001 fBase4;
    @Column(name = "FBiller")
    private Integer fBiller;
    @Column(name = "FUser")
    private Integer fUser;
    @Lob
    @Column(name = "FPicture")
    private byte[] fPicture;
    @Column(name = "FBase5")
    private Integer fBase5;
    @Column(name = "FBase6")
    private Integer fBase6=0;
//    @JoinColumn(name = "FBase7",referencedColumnName="FInterID")
//    @ManyToOne
//    private MeasureInType fBase7;
    @JoinColumn(name = "FBase8",referencedColumnName="FItemID")
    @ManyToOne
    private TStock fBase8;
    @JoinColumn(name = "FBase9",referencedColumnName="FSPID")
    @ManyToOne
    private TStockPlace fBase9;
    @Column(name = "FQty2")
    private BigDecimal fQty2=BigDecimal.ZERO;
    @Size(max = 255)
    @Column(name = "FBatchNo")
    private String fBatchNo="";
    @Column(name = "FID_SRC")
    private Integer fidSrc;
    @Column(name = "FEntryID_SRC")
    private Integer fEntryIDSRC;
    @Size(max = 255)
    @Column(name = "FBillNo_SRC")
    private String fBillNoSRC;
    @Column(name = "FClassID_SRC")
    private Integer fClassIDSRC;
    @Size(max = 500)
    @Column(name = "FText")
    private String fText;
    @Column(name = "FInteger")
    private Integer fInteger=0;
    @Column(name = "FQty3")
    private BigDecimal fQty3=BigDecimal.ZERO;
    @Column(name = "FInteger1")
    private Integer fInteger1=0;
    @Column(name = "FInteger2")
    private Integer fInteger2=0;
    @Column(name = "FConnectFlag")
    private Short fConnectFlag=0;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FDecimal5")
    private BigDecimal fDecimal5=BigDecimal.ZERO;



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fid != null ? fid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBOS200000001)) {
            return false;
        }
        TBOS200000001 other = (TBOS200000001) object;
        if ((this.fid == null && other.fid != null) || (this.fid != null && !this.fid.equals(other.fid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.org.malus.erp.k3.entity.ext.TBOS200000001[ fid=" + fid + " ]";
    }

    public Integer getFBase6() {
        return fBase6;
    }

    public void setFBase6(Integer fBase6) {
        this.fBase6 = fBase6;
    }

//    public MeasureInType getFBase7() {
//        return fBase7;
//    }
//
//    public void setFBase7(MeasureInType fBase7) {
//        this.fBase7 = fBase7;
//    }

    public TStock getFBase8() {
        return fBase8;
    }

    public void setFBase8(TStock fBase8) {
        this.fBase8 = fBase8;
    }

    public TStockPlace getFBase9() {
        return fBase9;
    }

    public void setFBase9(TStockPlace fBase9) {
        this.fBase9 = fBase9;
    }
    
}
