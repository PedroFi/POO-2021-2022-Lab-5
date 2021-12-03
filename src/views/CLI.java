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
                    var clientID = commands[1];
                    var clientIDType = commands[2];
                    var birthday = commands[3];
                    var email = commands[4];
                    var phoneNumber = commands[5];
                    var clientName = scanner.nextLine();
                    var address = scanner.nextLine();
                    if(bank.hasClient(clientID, clientIDType)) {
                        System.out.println("Cliente existente.");
                    } else {
                        bank.createClient(clientID, clientIDType, birthday, email, phoneNumber, clientName, address);
                        System.out.println("Cliente registado com sucesso.");
                    }
                    break;
                case "AC":
                    clientID = commands[1];
                    clientIDType = commands[2];
                    var clientParams = scanner.nextLine();
                    var splits = clientParams.split(" ");
                    birthday = splits[0];
                    email = splits[1];
                    phoneNumber = splits[2];
                    clientName = scanner.nextLine();
                    address = scanner.nextLine();
                    if(!bank.hasClient(clientID, clientIDType)) {
                        System.out.println("Cliente inexistente.");
                    } else {
                        bank.changeClient(clientID, clientIDType, birthday, email, phoneNumber, clientName, address);
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
                    clientID = commands[1];
                    clientIDType = commands[2];
                    var allowDebtParam = commands[3];
                    var allowDebt = allowDebtParam.equalsIgnoreCase("Sim");
                    var amount = 0.0;
                    if(commands.length == 5) {
                        amount = Double.parseDouble(commands[4]);
                    }
                    if(!bank.hasClient(clientID, clientIDType)) {
                        System.out.println("Cliente inexistente.");
                    } else if(!bank.isAmountValid(amount, allowDebt)) {
                        System.out.println("Montante não autorizado.");
                    } else {
                        String accountID = bank.createAccount(clientID, clientIDType, allowDebt, amount);
                        System.out.println("Conta criada com o identificador " + accountID);
                    }
                    break;
                case "PC":
                    clientID = commands[1];
                    clientIDType = commands[2];
                    var accountID = commands[3];
                    splits = scanner.nextLine().split(" ");
                    var sharedClientID = splits[0];
                    var sharedClientIDType = splits[1];
                    if(!bank.hasClient(clientID, clientIDType) || !bank.hasClient(sharedClientID, sharedClientIDType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!bank.hasAccount(accountID)) {
                        System.out.println("Conta inexistente.");
                    }
                    else {
                        bank.shareAccount(clientID, clientIDType, accountID, sharedClientID, sharedClientIDType);
                        System.out.println("Conta partilhada com sucesso.");
                    }
                    break;
                case "M":
                    clientID = commands[1];
                    clientIDType = commands[2];
                    accountID = commands[3];
                    amount = Double.parseDouble(commands[4]);
                    if(!bank.hasClient(clientID, clientIDType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!bank.hasAccount(accountID)) {
                        System.out.println("Conta inexistente.");
                    }
                    else if(!bank.isAuthorized(clientID, clientIDType, accountID)) {
                        System.out.println("Cliente não autorizado.");
                    }
                    else if(!bank.isAmountValid(amount, bank.getAccount(accountID).getAllowDebt())) {
                        System.out.println("Montante não autorizado.");
                    }
                    else {
                        System.out.println("Movimento efetuado com sucesso.");
                    }
                    break;
                default:
                    System.out.println("Instrução inválida.");
            }
        }
    }
}
