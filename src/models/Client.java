package models;

import java.util.Collection;

public class Client implements Comparable<Client> {
    public String getId() {
        return null;
    }

    public String getIdTypeSymbol() {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getBirthday() {
        return null;
    }

    public String getEmail() {
        return null;
    }

    public String getPhoneNumber() {
        return null;
    }

    public String getAddress() {
        return null;
    }

    public Collection<Account> getAccounts() {
        return null;
    }

    public Collection<Account> getSharedAccounts() {
        return null;
    }

    @Override
    public int compareTo(Client e) {
        return this.getName().compareTo(e.getName());
    }
}
