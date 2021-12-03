package controllers;

import models.Account;
import models.Client;
import java.util.Collection;

public class Bank {
    public boolean hasClient(final String clientID, final String clientIDType) {
            return false;
    }

    public void createClient(final String clientID, final String clientIDType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {
    }

    public void changeClient(final String clientID, final String clientIDType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {
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

    public String createAccount(final String clientID, final String clientIDType, final boolean allowDebt, final double amount) {
        return null;
    }

    public boolean hasAccount(final String accountID) {
        return false;
    }

    public void shareAccount(final String clientID, final String clientIDType, final String accountID, final String sharedClientID, final String sharedClientIDType) {
    }

    public boolean isAuthorized(String clientID, String clientIDType, String accountID) {
        return false;
    }

    public boolean isCashFlowAllowed(String accountID, double amount) {
        return false;
    }

    public void registerCashFlow(String clientID, String clientIDType, String accountID, double amount) {

    }

    public Account getAccount(String accountID) {
        return null;
    }

    public void save(String filename) {

    }

    public static Bank load(String filename) {
        return null;
    }
}
