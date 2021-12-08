package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private final Client owner;
    private final String id;
    private final List<Client> sharedClients = new ArrayList<>(80);
    private final List<CashFlow> cashFlows = new ArrayList<>(80);
    private boolean allowDept = false;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Account(final String id, final Client owner) {
        this.id = id;
        this.owner = owner;
        this.balance = 0.0;
    }

    public Account(final String id, final Client owner, final double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public Account(final String id, final Client owner, final double balance, final boolean allowDept) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.allowDept = allowDept;
    }
        
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public List<Client> getSharedClients() {
        return sharedClients;
    }

    public void addSharedClient(final Client client) {
        sharedClients.add(client);
    }

    public void removeSharedClient(final Client client) {
        sharedClients.remove(client);
    }

    public void makeMovement(final CashFlow cashFlow) {
        if (getBalance() >= cashFlow.getValue() || allowDept()) {
            cashFlows.add(cashFlow);
            balance += (cashFlow.getValue() - 0.42);
        }
    }

    public Client getOwner() {
        return owner;
    }

    public List<CashFlow> getCashFlows() {
        return cashFlows;
    }

    public boolean allowDept(){
        return allowDept;
    }

    public void setAllowDept(boolean allowDept) {
        this.allowDept = allowDept;
    }
}