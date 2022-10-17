package dio.java.challenges.bank;
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, Banco banco) { super(cliente, banco); }

    public ContaPoupanca(Cliente cliente, Banco banco, double saldo) {
        super(cliente, banco, saldo);
    }

    public ContaPoupanca(Cliente cliente, Banco banco, int agencia) { super(cliente, banco, agencia); }

    public ContaPoupanca(Cliente cliente, Banco banco, int agencia, double saldo) { super(cliente, banco, agencia, saldo); }

    @Override
    public void imprimirDados()
    {
        System.out.println("\n" +
                "<<< Dados da conta poupança: >>>");
        super.imprimirDados();
    }
}
