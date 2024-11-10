import java.util.ArrayList;
import java.util.Date;

public class PosPago extends Assinante {
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, int duracao) {
        float custoChamada = 1.04f * duracao;
        Chamada chamada = new Chamada(data, duracao);
        chamadas.add(chamada);
        numChamadas++;
        System.out.println("Chamada registrada com sucesso!");
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura do Assinante Pós-Pago:");
        System.out.println("CPF: " + getCpf());
        System.out.println("Nome: " + nome);
        System.out.println("Número: " + numero);

        float totalChamadas = 0;
        System.out.println("\nChamadas realizadas no mês " + mes + ":");
        for (Chamada chamada : chamadas) {
            if (chamada.getData().getMonth() == mes - 1) {
                float custo = chamada.getDuracao() * 1.04f;
                totalChamadas += custo;
                System.out.println("Data: " + chamada.getData() + ", Duração: " + chamada.getDuracao() + " minutos, Custo: R$ " + custo);
            }
        }

        float totalFatura = assinatura + totalChamadas;
        System.out.println("\nValor da assinatura: R$ " + assinatura);
        System.out.println("Total gasto com chamadas: R$ " + totalChamadas);
        System.out.println("Valor total da fatura: R$ " + totalFatura);
    }
}
