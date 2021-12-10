package models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Client implements Comparable<Client> {
    private String name;
    private final String id;
    private final IdentificationType idTypeSymbol;
    private Date birthday;
    private String address;
    private String email;
    private String phoneNumber;
    private final Map<String, Account> accounts = new HashMap<>(101);
    private final Map<String, Account> sharedAccounts = new HashMap<>(101);

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Client(final String id, final IdentificationType idTypeSymbol) {
        this.id = id;
        this.idTypeSymbol = idTypeSymbol;
    }

    public Client(final String name, final String id, final IdentificationType idTypeSymbol) {
        this.name = name;
        this.id = id;
        this.idTypeSymbol = idTypeSymbol;
    }

    public Client(final String name, final String id, final IdentificationType idTypeSymbol, final Date birthday) {
        this.name = name;
        this.id = id;
        this.idTypeSymbol = idTypeSymbol;
        this.birthday = birthday;
    }

    public Client(final String name, final String id, final IdentificationType idTypeSymbol, final Date birthday, final String address) {
        this.name = name;
        this.id = id;
        this.idTypeSymbol = idTypeSymbol;
        this.birthday = birthday;
        this.address = address;
    }

    public Client(final String name, final String id, final IdentificationType idTypeSymbol, final Date birthday, final String address, final String email) {
        this.name = name;
        this.id = id;
        this.idTypeSymbol = idTypeSymbol;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
    }

    public Client(final String name, final String id, final IdentificationType idTypeSymbol, final Date birthday, final String address, final String email, final String phoneNumber) {
        this.name = name;
        this.id = id;
        this.idTypeSymbol = idTypeSymbol;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public IdentificationType getIdTypeSymbol() {
        return idTypeSymbol;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(final Account account) {
        this.accounts.put(account.getId(), account);
    }

    public void removeAccount(final Account account) {
        this.accounts.remove(account.getId(), account);
    }

    public Map<String, Account> getSharedAccounts() {
        return sharedAccounts;
    }

    public void addSharedAccount(final Account sharedAccount) {
        this.sharedAccounts.put(sharedAccount.getId(), sharedAccount);
    }

    public void removeSharedAccount(final Account sharedAccount) {
        this.sharedAccounts.remove(sharedAccount.getId(), sharedAccount);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public int compareTo(final Client e) {
        return this.getName().compareTo(e.getName());
    }
}
