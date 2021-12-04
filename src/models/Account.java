package models;

import java.util.Collection;

public class Account {
    public double getBalance() {
        return 0.0;
    }

    public Client getOwner() {
        return null;
    }

    public String getID() {
        return null;
    }

    public boolean getAllowDebt() {
        return false;
    }

    public Collection<Client> getSharedClients() {
        return null;
    }

    public Collection<CashFlow> getCashFlows() {
        return null;
    }
}