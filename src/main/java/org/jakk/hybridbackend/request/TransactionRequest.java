package org.jakk.hybridbackend.request;

public class TransactionRequest {

    private long accountId;

    public TransactionRequest() {
    }

    public TransactionRequest(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
