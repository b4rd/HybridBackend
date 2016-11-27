package org.jakk.hybridbackend.model;

import java.math.BigDecimal;

public class Transaction {

    private Long id;
    private Long accountId;
    private String partner;
    private BigDecimal amount;
    private String currency;

    public Transaction(Long id, Long accountId, String partner, BigDecimal amount, String currency) {
        this.id = id;
        this.accountId = accountId;
        this.partner = partner;
        this.amount = amount;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
