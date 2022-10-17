package dio.java.challenges.bank;

public interface IConta {
    void depositar(double valor);

    void retirar(double valor);

    void transferir(double valor, IConta conta);

    void imprimirDados();
}