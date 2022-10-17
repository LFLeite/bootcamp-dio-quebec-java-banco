package dio.java.challenges.bank;

public class Cliente {
    private static int SEQUENCIAL = 1;
    private String nome;
    private final int clienteID;

    public Cliente(String nome) {
        this.nome = nome;
        this.clienteID = SEQUENCIAL++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
