package com.cactusteam.money.data.dao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "DEBT_NOTE".
 */
public class DebtNote implements ISyncObject {

    private Long id;
    private long debtId;
    /** Not-null value. */
    private java.util.Date date;
    private String text;
    private Long globalId;
    private Boolean synced;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public DebtNote() {
    }

    public DebtNote(Long id) {
        this.id = id;
    }

    public DebtNote(Long id, long debtId, java.util.Date date, String text, Long globalId, Boolean synced) {
        this.id = id;
        this.debtId = debtId;
        this.date = date;
        this.text = text;
        this.globalId = globalId;
        this.synced = synced;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDebtId() {
        return debtId;
    }

    public void setDebtId(long debtId) {
        this.debtId = debtId;
    }

    /** Not-null value. */
    public java.util.Date getDate() {
        return date;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getGlobalId() {
        return globalId;
    }

    public void setGlobalId(Long globalId) {
        this.globalId = globalId;
    }

    public Boolean getSynced() {
        return synced;
    }

    public void setSynced(Boolean synced) {
        this.synced = synced;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
