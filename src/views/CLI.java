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
                    final var clientID = commands[1];
                    final var clientIDType = commands[2];
                    final var birthday = commands[3];
                    final var email = commands[4];
                    final var phoneNumber = commands[5];
                    final var clientName = scanner.nextLine();
                    final var address = scanner.nextLine();
                    if(bank.hasClient(clientID, clientIDType)) {
                        System.out.println("Cliente existente.");
                    } else {
                        bank.createClient(clientID, clientIDType, birthday, email, phoneNumber, clientName, address);
                        System.out.println("Cliente registado com sucesso.");
                    }
                    break;
                case "AC":
                    final var clientID = commands[1];
                    final var clientIDType = commands[2];
                    final var clientParams = scanner.nextLine();
                    var splits = clientParams.split(" ");
                    final var birthday = splits[0];
                    final var email = splits[1];
                    final var phoneNumber = splits[2];
                    final var clientName = scanner.nextLine();
                    final var address = scanner.nextLine();
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
                    final var clientID = commands[1];
                    final var clientIDType = commands[2];
                    final var allowDebtParam = commands[3];
                    final var allowDebt = allowDebtParam.equalsIgnoreCase("Sim");
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
                    final var clientID = commands[1];
                    final var clientIDType = commands[2];
                    final var accountID = commands[3];
                    var splits = scanner.nextLine().split(" ");
                    final var sharedclientID = splits[0];
                    final var sharedclientIDType = splits[1];
                    if(!bank.hasClient(clientID, clientIDType) || !bank.hasClient(sharedclientID, sharedclientIDType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!bank.hasAccount(accountID)) {
                        System.out.println("Conta inexistente.");
                    }
                    else {
                        bank.shareAccount(clientID, clientIDType, accountID, sharedclientID, sharedclientIDType);
                        System.out.println("Conta partilhada com sucesso.");
                    }
                    break;
                case "M":
                    final var clientID = commands[1];
                    final var clientIDType = commands[2];
                    final var accountID = commands[3];
                    final var amount = (double)commands[4];
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
