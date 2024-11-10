import java.util.ArrayList;

public class Assinante {
    private long cpf;
    String nome;
    int numero;
    protected ArrayList<Chamada> chamadas;
    protected int numChamadas;

    public Assinante(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new ArrayList<>();
        this.numChamadas = 0;
    }

    public long getCpf() {
        return cpf;
    }

    public String toString() {
        return "Assinante{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                ", numChamadas=" + numChamadas +
                '}';
    }
}

