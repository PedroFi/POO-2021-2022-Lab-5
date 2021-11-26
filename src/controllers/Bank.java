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
}
