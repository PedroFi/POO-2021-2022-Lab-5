package views;

import controllers.Bank;
import models.Client;

import java.util.Collection;
import java.util.Scanner;

public class CLI {
    public CLI() {
        final var scanner = new Scanner(System.in);
        Bank bank = new Bank();
        while(true) {
            final var line = scanner.nextLine();
            final String[] commands = line.split(" ");
            switch(commands[0]) {
                case "RC":
                    var clientId = commands[1];
                    var clientIdType = commands[2];
                    var birthday = commands[3];
                    var email = commands[4];
                    var phoneNumber = commands[5];
                    var clientName = scanner.nextLine();
                    var address = scanner.nextLine();
                    if(bank.hasClient(clientId, clientIdType)) {
                        System.out.println("Cliente existente.");
                    } else {
                        bank.createClient(clientId, clientIdType, birthday, email, phoneNumber, clientName, address);
                        System.out.println("Cliente registado com sucesso.");
                    }
                    break;
                case "AC":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    final var clientParams = scanner.nextLine();
                    var splits = clientParams.split(" ");
                    birthday = splits[0];
                    email = splits[1];
                    phoneNumber = splits[2];
                    clientName = scanner.nextLine();
                    address = scanner.nextLine();
                    if(!bank.hasClient(clientId, clientIdType)) {
                        System.out.println("Cliente inexistente.");
                    } else {
                        bank.changeClient(clientId, clientIdType, birthday, email, phoneNumber, clientName, address);
                        System.out.println("Dados de cliente alterados com sucesso.");
                    }
                    break;
                case "LC":
                    if(!bank.hasClients()) {
                        System.out.println("Sem clientes registados.");
                    } else {
                        Collection<Client> clients = bank.getClients();
                        // TODO: sort the client collection
                        for(final var client : clients) {
                            System.out.println("[" + client.getId() + " " + client.getIdTypeSymbol() + "]" +
                                    client.getBirthday() + " " + client.getName() +
                                    "(" + client.getEmail() + ")" +
                                    "(" + client.getPhoneNumber() + ")" +
                                    "(" + client.getAddress() + ")");
                        }
                    }
                    break;
                case "NC":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    final var allowDebtParam = commands[3];
                    final var allowDebt = allowDebtParam.equalsIgnoreCase("Sim");
                    var amount = 0.0;
                    if(commands.length == 5) {
                        amount = Double.parseDouble(commands[4]);
                    }
                    if(!bank.hasClient(clientId, clientIdType)) {
                        System.out.println("Cliente inexistente.");
                    } else if(!bank.isAmountValid(amount, allowDebt)) {
                        System.out.println("Montante não autorizado.");
                    } else {
                        String accountId = bank.createAccount(clientId, clientIdType, allowDebt, amount);
                        System.out.println("Conta criada com o identificador " + accountId);
                    }
                    break;
                case "PC":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    var accountId = commands[3];
                    splits = scanner.nextLine().split(" ");
                    var sharedClientId = splits[0];
                    var sharedClientIdType = splits[1];
                    if(!bank.hasClient(clientId, clientIdType) ||
                        !bank.hasClient(sharedClientId, sharedClientIdType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!bank.hasAccount(accountId)) {
                        System.out.println("Conta inexistente.");
                    }
                    else {
                        bank.shareAccount(clientId, clientIdType, accountId, sharedClientId, sharedClientIdType);
                        System.out.println("Conta partilhada com sucesso.");
                    }
                    break;
                case "M":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    accountId = commands[3];
                    amount = commands[4];
                    if(!bank.hasClient(clientId, clientIdType) || !bank.hasClient(sharedClientId, sharedClientIdType)){
                        System.out.println("Cliente inexistente.");
                    }
                    else if (!bank.hasAccount(accountId)){
                        System.out.println("Conta inexistente");
                    }
                    else if (!bank.shareAccount(clientId, clientIdType, accountId, sharedClientId, sharedClientIdType)){
                        System.out.println("Cliente não autorizado.");
                    }
                    else if (!bank.isCashflowAllowed(accountId, montante)){
                        System.out.println("Montante não autorizado");
                    }
                    else{
                        bank.registerCashflow(clientId, clientIdType, accountId, amount);
                        System.out.println("Movimento efetuado com sucesso.");
                    }
                default:
                    System.out.println("Instrução inválida.");
            }

        }
    }
}
