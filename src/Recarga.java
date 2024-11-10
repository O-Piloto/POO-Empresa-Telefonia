import java.util.Date;

public class Recarga {
    private Date data;
    private float valor;

    public Recarga(Date data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    public String toString() {
        return "Recarga{" +
                "data=" + data +
                ", valor=R$ " + valor +
                '}';
    }
}
