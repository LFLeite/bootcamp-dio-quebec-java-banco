package dio.java.challenges.bank;

public abstract class Conta implements IConta{
    private final Banco banco;
    private final int agencia;
    private final int numeroConta;
    private double saldo = 0.0;
    private final Cliente Titular;


    protected Conta(Cliente Titular, Banco banco, int agencia) {
        this.Titular = Titular;
        this.agencia = agencia;
        this.banco = banco;
        this.numeroConta = banco.newAccountNumber();

        banco.novaConta(this);
    }

    protected Conta(Cliente Titular, Banco banco, int agencia, double saldo) {
        this(Titular,banco,agencia);
        this.saldo = saldo;
    }

    protected Conta(Cliente Titular, Banco banco) {
        this(Titular,banco,banco.getAgenciaPadrao());
    }

    protected Conta(Cliente Titular, Banco banco, double saldo) {
        this(Titular,banco,banco.getAgenciaPadrao(),saldo);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getTitular() {
        return Titular;
    }

    public void depositar(double valor) {
        saldo+=valor;
    }

    public void retirar(double valor) {
        saldo-=valor;
    }

    public void transferir(double valor, IConta conta) {
        retirar(valor);
        conta.depositar(valor);
    }

    public void imprimirDados() {
        System.out.printf("Banco: %s\n", banco.getNome());
        System.out.printf("Titular: %s\n", Titular.getNome());
        System.out.printf("Agencia %d  -  Conta %d\n", agencia, numeroConta);
        System.out.printf("Saldo:  %.2f\n", saldo);
    }
}