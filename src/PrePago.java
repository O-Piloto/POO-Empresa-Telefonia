import java.util.ArrayList;
import java.util.Date;

public class PrePago extends Assinante {
    private float creditos;
    private ArrayList<Recarga> recargas;
    private int numRecargas;

    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.creditos = 0.0f;
        this.recargas = new ArrayList<>();
        this.numRecargas = 0;
    }

    public void fazerChamada(Date data, int duracao) {
        float custoChamada = 1.45f * duracao;

        if (creditos >= custoChamada) {
            creditos -= custoChamada;
            Chamada chamada = new Chamada(data, duracao);
            chamadas.add(chamada);
            numChamadas++;
            System.out.println("Chamada registrada com sucesso!");
        } else {
            System.out.println("Créditos insuficientes para realizar a chamada.");
        }
    }

    public void recarregar(Date data, float valor) {
        Recarga recarga = new Recarga(data, valor);
        recargas.add(recarga);
        numRecargas++;
        creditos += valor;
        System.out.println("Recarga realizada com sucesso!");
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura do Assinante Pré-Pago:");
        System.out.println("CPF: " + getCpf());
        System.out.println("Nome: " + nome);
        System.out.println("Número: " + numero);

        float totalChamadas = 0;
        System.out.println("\nChamadas realizadas no mês " + mes + ":");
        for (Chamada chamada : chamadas) {
            if (chamada.getData().getMonth() == mes - 1) {
                float custo = chamada.getDuracao() * 1.45f;
                totalChamadas += custo;
                System.out.println("Data: " + chamada.getData() + ", Duração: " + chamada.getDuracao() + " minutos, Custo: R$ " + custo);
            }
        }

        float totalRecargas = 0;
        System.out.println("\nRecargas realizadas no mês " + mes + ":");
        for (Recarga recarga : recargas) {
            if (recarga.getData().getMonth() == mes - 1) {
                totalRecargas += recarga.getValor();
                System.out.println("Data: " + recarga.getData() + ", Valor: R$ " + recarga.getValor());
            }
        }

        System.out.println("\nTotal gasto com chamadas: R$ " + totalChamadas);
        System.out.println("Total de recargas: R$ " + totalRecargas);
        System.out.println("Créditos restantes: R$ " + creditos);
    }
}
