package dio.java.challenges.bank;

public class Main {
    static Banco bancoBrasil = new Banco("Banco do Brasil");
    static Banco bancoItau = new Banco("Banco Itau");
    static Cliente clienteJoao = new Cliente("Joao");
    static Cliente clienteMaria = new Cliente("Maria");
    static Conta cc1 = new ContaCorrente(clienteJoao, bancoBrasil);
    static Conta cc2 = new ContaCorrente(clienteMaria, bancoItau,41.52);
    static Conta cc3 = new ContaCorrente(clienteMaria, bancoBrasil,74.18);

    static Conta cp1 = new ContaPoupanca(clienteJoao, bancoBrasil,5);
    static Conta cp2 = new ContaPoupanca(clienteJoao, bancoItau,3,624.12);

    public static void main(String[] args) {
        System.out.println("\nImpressão de dados individuais de cada conta:");
        cc1.imprimirDados();
        cc2.imprimirDados();
        cc3.imprimirDados();

        cp1.imprimirDados();
        cp2.imprimirDados();

        System.out.println("\nImpressão de listas de clientes para cada banco:");
        bancoBrasil.listaClientes();
        bancoItau.listaClientes();

        System.out.println("\nImpressão das informações do cliente em determinado banco");
        bancoBrasil.infoCliente(clienteJoao);
        bancoBrasil.infoCliente(clienteMaria);

        bancoItau.infoCliente(clienteJoao);
        bancoItau.infoCliente(clienteMaria);

        System.out.println("\nOperações entre contas.");
        cc1.imprimirDados();
        cc2.imprimirDados();

        System.out.println("\nTransferindo 12.50 entre as contas");
        cc1.transferir(12.50, cc2);

        cc1.imprimirDados();
        cc2.imprimirDados();

        cp1.imprimirDados();
        System.out.println("\nDepositando 416.32");
        cp1.depositar(416.32);
        cp1.imprimirDados();

        cp2.imprimirDados();
        System.out.println("\nSacando 50");
        cp2.retirar(50);
        cp2.imprimirDados();

        System.out.println("\nImpressão de listas de contas para cada banco (com filtragem opcional por tipo):");
        bancoBrasil.listaContas(Conta.class);
        bancoBrasil.listaContas(ContaCorrente.class);
        bancoBrasil.listaContas(ContaPoupanca.class);

        bancoItau.listaContas(Conta.class);
        bancoItau.listaContas(ContaCorrente.class);
        bancoItau.listaContas(ContaPoupanca.class);
    }
}
