package views;

import controllers.Bank;
import models.Account;
import models.Client;

import java.util.*;

public class CLI {
    public CLI() {
        final Scanner scanner = new Scanner(System.in);
        final Bank bank = new Bank();
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
                        final List<Client> clients = (List<Client>)bank.getClients();
                        Collections.sort(clients);
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
                        final String accountId = bank.createAccount(clientId, clientIdType, allowDebt, amount);
                        System.out.println("Conta criada com o identificador " + accountId);
                    }
                    break;
                case "PC":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    var accountId = commands[3];
                    splits = scanner.nextLine().split(" ");
                    final var sharedclientId = splits[0];
                    final var sharedclientIdType = splits[1];
                    if(!bank.hasClient(clientId, clientIdType) || !bank.hasClient(sharedclientId, sharedclientIdType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!bank.hasAccount(accountId)) {
                        System.out.println("Conta inexistente.");
                    }
                    else {
                        bank.shareAccount(clientId, clientIdType, accountId, sharedclientId, sharedclientIdType);
                        System.out.println("Conta partilhada com sucesso.");
                    }
                    break;
                case "M":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    accountId = commands[3];
                    amount = Double.parseDouble(commands[4]);
                    if(!bank.hasClient(clientId, clientIdType)){
                        System.out.println("Cliente inexistente.");
                    }
                    else if (!bank.hasAccount(accountId)){
                        System.out.println("Conta inexistente.");
                    }
                    else if (!bank.isAuthorized(clientId, clientIdType, accountId)){
                        System.out.println("Cliente não autorizado.");
                    }
                    else if (!bank.isCashFlowAllowed(accountId, amount)){
                        System.out.println("Montante não autorizado.");
                    }
                    else{
                        bank.registerCashFlow(clientId, clientIdType, accountId, amount);
                        System.out.println("Movimento efetuado com sucesso.");
                    }
                    break;
                case "SC":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    accountId = commands[3];
                    if(!bank.hasClient(clientId, clientIdType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!bank.hasAccount(accountId)) {
                        System.out.println("Conta inexistente.");
                    }
                    else if(!bank.isAuthorized(clientId, clientIdType, accountId)) {
                        System.out.println("Cliente não autorizado.");
                    }
                    else {
                        final Account account = bank.getAccount(accountId);
                        final List<Client> clients = (List<Client>)account.getSharedClients();
                        Collections.sort(clients);
                        for(final var client : clients) {
                            System.out.println(client.getName() + "[" + client.getId() + " " + client.getIdTypeSymbol() + "]\n");
                        }
                        System.out.print(account.getAllowDept() + "\n" + account.getBalance());
                    }
                    break;
                default:
                    System.out.println("Instrução inválida.");
            }
        }
    }
}