package controllers;

import models.Client;

import java.util.Collection;

public class Bank {
    public boolean hasClient(final String clientId, final String clientIdType) {
            return false;
    }

    public void createClient(final String clientId, final String clientIdType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {

    }

    public void changeClient(final String clientId, final String clientIdType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {
    }

    public Collection<Client> getClients() {
        return null;
    }

    public boolean hasClients() {
        return false;
    }

    public String createAccount(final String clientId, final String clientIdType, final boolean allowDebt, final double amount) {
        return null;
    }

    public boolean isAmountValid(final double amount, final boolean allowDebt) {
        return false;
    }

    public boolean hasAccount(final String accountId) {
        return false;
    }

    public void shareAccount(final String clientId, final String clientIdType, final String accountId, final String sharedClientId, final String sharedClientIdType) {

    }
}
