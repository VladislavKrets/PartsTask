package com.test.task.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lollipop on 28.06.2018.
 */
public class PartEntity {
    private String PN;
    private String partName;
    private String vendor;
    private Integer qty;
    private Date shipped;
    private Date received;
    private SimpleDateFormat simpleDateFormat;
    private String strShipped;
    private String strReceived;

    public PartEntity() {
        simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
        strShipped = simpleDateFormat.format(shipped);
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
        strReceived = simpleDateFormat.format(received);
    }

    public String getStrShipped() {
        return strShipped;
    }

    public String getStrReceived() {
        return strReceived;
    }
}
