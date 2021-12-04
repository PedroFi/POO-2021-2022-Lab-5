package models;

import java.util.Collection;
import java.util.Date;

public class Client implements Comparable<Client> {
    private String name;
    private String id;
    private IdentificationType idTypeSymbol;
    private Date birthday;
    private String address;
    private String email;
    private String phoneNumber;
    private Collection<Account> accounts;
    private Collection<Account> sharedAccounts;

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

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public boolean addAccount(final Account account) {
        return this.accounts.add(account);
    }

    public boolean removeAccount(final Account account) {
        return this.accounts.remove(account);
    }

    public Collection<Account> getSharedAccounts() {
        return sharedAccounts;
    }

    public boolean addSharedAccount(final Account sharedAccount) {
        return this.sharedAccounts.add(sharedAccount);
    }

    public boolean removeSharedAccount(final Account sharedAccount) {
        return this.sharedAccounts.remove(sharedAccount);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public int compareTo(final Client e) {
        return this.getName().compareTo(e.getName());
    }
}
