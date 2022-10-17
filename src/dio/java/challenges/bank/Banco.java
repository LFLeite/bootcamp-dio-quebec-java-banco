package dio.java.challenges.bank;

import java.util.*;

public class Banco {
    private final int AGENCIA_PADRAO = 1;
    private int SEQUENCIAL = 1;
    private final String nome;
    private final List<Conta> contas = new ArrayList<>();

    public Banco(String nome) { this.nome = nome; }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public int getAgenciaPadrao() {
        return AGENCIA_PADRAO;
    }

    public int newAccountNumber() {
        return SEQUENCIAL++;
    }

    public void novaConta(Conta conta) {
        contas.add(conta);
    }

    public void infoCliente(Cliente cliente) {
        boolean isClient = false;

        System.out.printf("<<< Consultando contas do cliente %s no %s: >>>\n", cliente.getNome(), this.nome);

        for (Conta conta : contas) {
            if (conta.getTitular() == cliente) {
                isClient = true;
                String tipoConta;

                if (conta instanceof ContaCorrente)
                    tipoConta = "Conta Corrente";
                else
                    tipoConta = "Conta Poupança";

                System.out.printf("Agencia %d  - %s %d\n", conta.getAgencia(), tipoConta, conta.getNumeroConta());
            }
        }

        if (!isClient)
            System.out.printf("%s não é um cliente do %s.\n", cliente.getNome(), this.nome);

        System.out.println();
    }

    public void listaClientes() {
        if (contas.isEmpty()) {
            System.out.printf("<<< Não há clientes cadastrados no %s. >>>\n", this.nome);
            return;
        }

        List<Cliente> clientes = new ArrayList<>();

        System.out.printf("<<< Clientes cadastrados no %s: >>>\n", this.nome);

        for (Conta conta : contas) {
            if (!clientes.contains(conta.getTitular())) {
                clientes.add(conta.getTitular());
                System.out.printf("%s\n", conta.getTitular().getNome());
            }
        }
        System.out.println();
    }

    public <T extends Conta> void listaContas(Class<T> className) {
        if (className == ContaCorrente.class)
            System.out.printf("\nLista de contas corrente no %s:\n", this.nome);
        else if (className == ContaPoupanca.class)
            System.out.printf("\nLista de contas poupança no %s:\n", this.nome);
        else if (className == Conta.class)
            System.out.printf("\nLista de contas no %s:\n", this.nome);

        for (Conta conta : contas) {
            if (conta.getClass() == className || className == Conta.class) {
                System.out.printf("Titular: %s\n", conta.getTitular().getNome());
                System.out.printf("Agencia %d  -  Conta %d\n", conta.getAgencia(), conta.getNumeroConta());
            }
        }
    }
}
