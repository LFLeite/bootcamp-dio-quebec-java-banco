package dio.java.challenges.bank;
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, Banco banco) { super(cliente, banco); }

    public ContaCorrente(Cliente cliente, Banco banco, double saldo) {
        super(cliente, banco, saldo);
    }

    public ContaCorrente(Cliente cliente, Banco banco, int agencia) { super(cliente, banco, agencia); }

    public ContaCorrente(Cliente cliente, Banco banco, int agencia, double saldo) { super(cliente, banco, agencia, saldo); }

    public void imprimirDados()
    {
        System.out.println("\n" +
                "<<< Dados da conta corrente: >>>");
        super.imprimirDados();
    }
}
