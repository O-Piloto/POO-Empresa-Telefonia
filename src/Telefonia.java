import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Telefonia {
    private ArrayList<PrePago> prePagos;
    private ArrayList<PosPago> posPagos;

    public Telefonia() {
        prePagos = new ArrayList<>();
        posPagos = new ArrayList<>();
    }

    public void cadastrarAssinante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de assinante (1 - Pré-pago, 2 - Pós-pago): ");
        int tipo = scanner.nextInt();

        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Digite o nome do assinante: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o número do telefone: ");
        int numero = scanner.nextInt();

        if (tipo == 1) {
            PrePago novoPrePago = new PrePago(cpf, nome, numero);
            prePagos.add(novoPrePago);
            System.out.println("Assinante pré-pago cadastrado com sucesso!");
        } else if (tipo == 2) {
            System.out.println("Digite o valor da assinatura: ");
            float assinatura = scanner.nextFloat();
            PosPago novoPosPago = new PosPago(cpf, nome, numero, assinatura);
            posPagos.add(novoPosPago);
            System.out.println("Assinante pós-pago cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de assinante inválido.");
        }
    }

    public void listarAssinantes() {
        System.out.println("Assinantes Pré-Pagos:");
        for (PrePago prePago : prePagos) {
            System.out.println(prePago);
        }

        System.out.println("\nAssinantes Pós-Pagos:");
        for (PosPago posPago : posPagos) {
            System.out.println(posPago);
        }
    }

    public void fazerChamada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de assinante (1 - Pré-pago, 2 - Pós-pago): ");
        int tipo = scanner.nextInt();

        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        System.out.println("Digite a duração da chamada em minutos: ");
        int duracao = scanner.nextInt();
        System.out.println("Digite a data da chamada (em milissegundos desde 01/01/1970): ");
        long dataMillis = scanner.nextLong();
        Date data = new Date(dataMillis);

        if (tipo == 1) { // Pré-pago
            PrePago assinante = localizarPrePago(cpf);
            if (assinante != null) {
                assinante.fazerChamada(data, duracao);
            } else {
                System.out.println("Assinante pré-pago não encontrado.");
            }
        } else if (tipo == 2) { // Pós-pago
            PosPago assinante = localizarPosPago(cpf);
            if (assinante != null) {
                assinante.fazerChamada(data, duracao);
            } else {
                System.out.println("Assinante pós-pago não encontrado.");
            }
        } else {
            System.out.println("Tipo de assinante inválido.");
        }
    }

    public void fazerRecarga() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante pré-pago: ");
        long cpf = scanner.nextLong();
        System.out.println("Digite o valor da recarga: ");
        float valor = scanner.nextFloat();
        System.out.println("Digite a data da recarga (em milissegundos desde 01/01/1970): ");
        long dataMillis = scanner.nextLong();
        Date data = new Date(dataMillis);

        PrePago assinante = localizarPrePago(cpf);
        if (assinante != null) {
            assinante.recarregar(data, valor);
        } else {
            System.out.println("Assinante pré-pago não encontrado.");
        }
    }

    public void imprimirFaturas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o mês (1-12) para gerar as faturas: ");
        int mes = scanner.nextInt();

        System.out.println("Faturas dos Assinantes Pré-Pagos:");
        for (PrePago prePago : prePagos) {
            prePago.imprimirFatura(mes);
        }

        System.out.println("\nFaturas dos Assinantes Pós-Pagos:");
        for (PosPago posPago : posPagos) {
            posPago.imprimirFatura(mes);
        }
    }

    public PrePago localizarPrePago(long cpf) {
        for (PrePago prePago : prePagos) {
            if (prePago.getCpf() == cpf) {
                return prePago;
            }
        }
        return null;
    }

    public PosPago localizarPosPago(long cpf) {
        for (PosPago posPago : posPagos) {
            if (posPago.getCpf() == cpf) {
                return posPago;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Telefonia sistema = new Telefonia();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Assinante");
            System.out.println("2 - Listar Assinantes");
            System.out.println("3 - Fazer Chamada");
            System.out.println("4 - Fazer Recarga");
            System.out.println("5 - Imprimir Faturas");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    sistema.cadastrarAssinante();
                    break;
                case 2:
                    sistema.listarAssinantes();
                    break;
                case 3:
                    sistema.fazerChamada();
                    break;
                case 4:
                    sistema.fazerRecarga();
                    break;
                case 5:
                    sistema.imprimirFaturas();
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
    }
}
