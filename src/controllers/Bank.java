package controllers;

import models.Account;
import models.Client;
import java.util.Collection;

public class Bank {
    public boolean hasClient(final String clientId, final String clientIdType) { return false; }

    public void createClient(final String clientId, final String clientIdType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {
    }

    public void changeClient(final String clientId, final String clientIdType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {

    }

    public boolean hasClients() {
        return false;
    }

    public Collection<Client> getClients() {
        return null;
    }

    public boolean isAmountValid(final double amount, final boolean allowDebt) {
        return false;
    }

    public String createAccount(final String clientId, final String clientIdType, final boolean allowDebt, final double amount) { return null; }

    public boolean hasAccount(final String accountId) {
        return false;
    }

    public void shareAccount(final String clientId, final String clientIdType, final String accountId, final String sharedclientId, final String sharedclientIdType) {
    }

    public boolean isAuthorized(String clientId, String clientIdType, String accountId) {
        return false;
    }

    public boolean isCashFlowAllowed(String accountId, double amount) {
        return false;
    }

    public void registerCashFlow(String clientId, String clientIdType, String accountId, double amount) {

    }

    public Account getAccount(String accountId) {
        return null;
    }

    public void save(String filename) {

    }

    public static Bank load(String filename) {
        return null;
    }
}
