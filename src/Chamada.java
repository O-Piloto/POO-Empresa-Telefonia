import java.util.Date;

public class Chamada {
    private Date data;
    private int duracao;

    public Chamada(Date data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }

    public Date getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    public String toString() {
        return "Chamada{" +
                "data=" + data +
                ", duracao=" + duracao + " minutos" +
                '}';
    }
}
