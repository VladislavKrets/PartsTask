package com.test.task.entities;

import java.util.Date;

/**
 * Created by lollipop on 28.06.2018.
 */
public class Filter {
    private String PN;
    private String partName;
    private String vendor;
    private Integer qty;
    private Date shippedAfter;
    private Date shippedBefore;
    private Date receivedAfter;
    private Date receivedBefore;
    private String ascDescValue;

    public String getPN() {
        return PN;
    }

    public String getPartName() {
        return partName;
    }

    public String getVendor() {
        return vendor;
    }

    public Integer getQty() {
        return qty;
    }

    public Date getShippedAfter() {
        return shippedAfter;
    }

    public Date getShippedBefore() {
        return shippedBefore;
    }

    public Date getReceivedAfter() {
        return receivedAfter;
    }

    public Date getReceivedBefore() {
        return receivedBefore;
    }

    public String getAscDescValue() {
        return ascDescValue;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setShippedAfter(Date shippedAfter) {
        this.shippedAfter = shippedAfter;
    }

    public void setShippedBefore(Date shippedBefore) {
        this.shippedBefore = shippedBefore;
    }

    public void setReceivedAfter(Date receivedAfter) {
        this.receivedAfter = receivedAfter;
    }

    public void setReceivedBefore(Date receivedBefore) {
        this.receivedBefore = receivedBefore;
    }

    public void setAscDescValue(String ascDescValue) {
        this.ascDescValue = ascDescValue;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "PN='" + PN + '\'' +
                ", partName='" + partName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", qty=" + qty +
                ", shippedAfter=" + shippedAfter +
                ", shippedBefore=" + shippedBefore +
                ", receivedAfter=" + receivedAfter +
                ", receivedBefore=" + receivedBefore +
                ", ascDescValue='" + ascDescValue + '\'' +
                '}';
    }
}
