package models;

import java.util.Collection;

public class Account {
    private double balance;
    private Client owner; //Final?
    private final String id;
    private Collection<Client> sharedClients;
    private Collection<CashFlow> cashFlows;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Account(final String id, final Client owner, final double balance = 0.0000) {
        this.id = id;
        this.owner = owner;
        this.balance = balance; 
    }
        
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public boolean allowDept(final CashFlow cashFlow) {
        return balance - cashFlow.value >= 0.0;
    }

    public boolean addSharedClient(final Client client) {
        return sharedClients.add(client)
    }

    public boolean removeSharedClient(final Client client) {
        return sharedClients.remove(client)
    }

    public void makeMovement(final CashFlow cashFlow) {
        if(allowDept(cashFlow)) {
            cashFlows.add(cashFlow);
            balance += (cashFlow.value - 0.42);
        }
    }
}