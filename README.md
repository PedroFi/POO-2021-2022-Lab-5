# [Programação Orientada a Objetos 2020 2021](https://elearning.ual.pt/course/view.php?id`2334) - [UAL](https://autonoma.pt/)

## Laboratório 5

Pretende-se a implementação de um sistema bancário.

Um cliente bancário deve ter um nome, número de identificação civil, que pode corresponder a vários tipos de documento (e.g., cartão de cidadão, ou passaporte), data de nascimento, morada, email, e número de contacto telefónico.

Um cliente pode alterar todos os dados associados ao seu registo, exceto o número de identificação civil.

Após o registo de um cliente, este pode criar contas bancárias. Cada conta é identificada com um número único. Este número não pode ser alterado.

Uma conta pertence a um cliente principal, e pode ser partilhada com outros clientes.

A conta tem um montante associado, que pode assumir valores negativos e positivos, com quatro casas decimais. Se o cliente abrir a conta sem efetuar um depósito inicial, esta terá saldo zero.

A alteração de saldo de conta é feita através de movimentos de conta. Estes podem ser de crédito (i.e., adicionar saldo à conta) ou débito (i.e., remover saldo da conta). Cada movimento de conta tem um custo operacional de 0,42€.

O saldo da conta só pode ficar a negativo se for necessário para o pagamento da taxa de movimento, ou se a conta estiver autorizada para movimentos a descoberto.

Todas as classes públicas devem ser testadas com testes unitários. Deve produzir a documentação `javadoc` para todas as classes, atributos, e métodos públicos.

# Tarefas

## Parte 1

- Identifique as classes relevantes para o problema;
- Construa o diagrama de classes do problema.

## Parte 2

- Identifique os métodos públicos necessários para cada classe;
- Identifique os atributos (privados e públicos) de cada classe;
- Altere o diagrama de classes para incluir atributos e métodos.

## Parte 3

Implemente a aplicação de acordo com as operações descritas. Deve implementar todos os cenários de utilização previstos para as operações consideradas.

Documente todas as classes públicas, atributos públicos, e métodos públicos com marcadores `javadoc`.

### Registar cliente (**RC**)

Regista um novo cliente.

`NumId` é o identificador do cliente, `TipoId` é o tipo de identificador (`CC`, `P`), `DataNascimento` é uma data no formato `AAAAMMDD`, `Email` é o endereço de email do cliente, `Telefone` é o número de telefone, `Morada` é a morada de um ciente, e `NomeCliente` é o nome do cliente.

Entrada:

    RC NumId TipoId DataNascimento Email Telefone
    NomeCliente
    Morada

Saída com sucesso:

    Cliente registado com sucesso.

Saída com insucesso:

- Quando já existe um cliente com o identificador indicado.

      Cliente existente.

### Alterar dados de cliente (**AC**)

Altera os dados de um cliente.

`NumId` é o identificador do cliente, `TipoId` é o tipo de identificador (`CC`, `P`), `DataNascimento` é uma data no formato `AAAAMMDD`, `Email` é o endereço de email do cliente, `Telefone` é o número de telefone, `Morada` é a morada de um ciente, e `NomeCliente` é o nome do cliente.

Entrada:

    AC NumId TipoId
    DataNascimento Email Telefone
    NomeCliente
    Morada

Saída com sucesso:

    Dados de cliente alterados com sucesso.

Saída com insucesso:

- Quando o cliente indicado não existe.

      Cliente inexistente.

### Listar clientes (**LC**)

Lista todos os clientes registados, por ordem crescente de data de nascimento, e por ordem de tipo de documento de identificação (`CC`, `P`) dentro da mesma data de nascimento, e por ordem de número de identificação para o mesmo tipo de documento.

`NumId` é o identificador do cliente, `TipoId` é o tipo de identificador (`CC`, `P`), `DataNascimento` é uma data no formato `AAAAMMDD`, `Email` é o endereço de email do cliente, `Telefone` é o número de telefone, `Morada` é a morada de um ciente, e `NomeCliente` é o nome do cliente.

Entrada:

    LC

Saída com sucesso:

    [NumId TipoId] DataNascimento NomeCliente (Email) (Telefone) (Morada)
    [NumId TipoId] DataNascimento NomeCliente (Email) (Telefone) (Morada)
    [NumId TipoId] DataNascimento NomeCliente (Email) (Telefone) (Morada)
    ...

Saída com insucesso:

- Quando não existem clientes registados.

      Sem clientes registados.

### Registar conta (**NC**)

Regista uma nova conta para um cliente.

`NumId` é o identificador do cliente, e `TipoId` é o tipo de identificador (`CC`, `P`). `AutoricaçãoDescoberto` (`Sim`, `Não`) indica se a conta está autorizada a descoberto, e `DepósitoInicial` é o valor (opcional) do primeiro depósito.

`IdentiticadorConta` é o identificador único da conta, único no sistema, gerado automaticamente numa sequência iniciada em 1.

Entrada:

    NC NumId TipoId AutorizaçãoDescoberto [DepósitoInicial]

Saída com sucesso:

    Conta criada com identificador IdentificadorConta.

Saída com insucesso:

- Quando o cliente indicado não existe.

      Cliente inexistente.

- Quando o valor do depósito inicial é inferior a zero, e a conta não permite descoberto.

      Montante não autorizado.

### Partilhar conta (**PC**)

Partilha uma conta entre clientes.

`NumId` é o identificador do cliente que registou a conta, e `TipoId` é o tipo de identificador (`CC`, `P`). `IdentiticadorConta` é o identificador único da conta. `NumIdPartilha` é o identificador do cliente com o qual a conta será partilhada, e `TipoIdPartilha` é o tipo de identificador (`CC`, `P`).

Entrada:

    PC NumId TipoId IdentificadorConta
    NumIdPartilha TipoIdPartilha

Saída com sucesso:

    Conta partilhada com sucesso.

- Quando algum dos clientes indicados não existe.

      Cliente inexistente.

- Quando a conta não existe.

      Conta inexistente.

### Registar movimento (**M**)

Regista um movimento na conta. Os movimentos podem ser de débito ou crédito, de acordo com o sinal do montante indicado.

`NumId` é o identificador do cliente, e `TipoId` é o tipo de identificador (`CC`, `P`). `IdentiticadorConta` é o identificador único da conta, e `Montante` é o montante associado ao movimento.

Entrada:

    M NumId TipoId IdentificadorConta Montante

Saída com sucesso:

    Movimento efetuado com sucesso.

Saída com insucesso:

- Quando o cliente indicado não existe.

      Cliente inexistente.

- Quando a conta não existe.

      Conta inexistente.

- Quando o cliente indicado não tem acesso à conta.

      Cliente não autorizado.

- Quando a conta fica a descoberto sem autorização.

      Montante não autorizado.

### Consultar conta (**SC**)

Consulta a informação de uma conta.

`NumId` é um identificador de um cliente associado à conta, e `TipoId` é o tipo de identificador (`CC`, `P`). `IdentiticadorConta` é o identificador único da conta, `AutorizaçãoDescoberto `(`Sim`, `Não`) é a autorização de descoberto da conta, e `Saldo` é o saldo atual da conta.

Os cliente associados à conta devem ser ordenados por ordem alfabética de nome.

Entrada:

    SC NumId TipoId IdentificadorConta

Saída com sucesso:

    NomeCliente [NumId TipoId]
    NomeCliente [NumId TipoId]
    ...
    AutorizaçãoDescoberto
    Saldo

Saída com insucesso:

- Quando o cliente indicado não existe.

      Cliente inexistente.

- Quando a conta não existe.

      Conta inexistente.

- Quando o cliente indicado não tem acesso à conta.

      Cliente não autorizado.

### Gravar (G)

Grava o estado atual completo do programa num ficheiro.

`NomeFicheiro` é o caminho completo, ou relativo, de um ficheiro a ser criado (se não existir) ou re-escrito.

Entrada:

      G NomeFicheiro

Saída com sucesso:

      Ficheiro gravado com sucesso.

### Ler (L)

Lê o estado do programa de um ficheiro.

`NomeFicheiro` é o caminho completo, ou relativo, de um ficheiro a ser criado ou re-escrito.

Entrada:

      L NomeFicheiro

Saída com sucesso:

      Ficheiro lido com sucesso.

Saída com insucesso:

- Quando o ficheiro não existe

      Ficheiro inexistente.

## Parte 4

- Execute o seu programa com o seguinte cenário:
  - Registe um cliente;
  - Registe um cliente com o mesmo número de identificação civil;
  - Registe um cliente diferente;
  - Registe uma conta de um dos clientes registados;
  - Efetue uma operação de crédito na nova conta;
  - Consulte o saldo da conta;
  - Efetue uma operação de débito na nova conta;
  - Consulte o saldo da conta;
  - Registe uma nova conta a um dos clientes, agora com um depósito inicial.
  - Consulte o saldo da nova conta.
