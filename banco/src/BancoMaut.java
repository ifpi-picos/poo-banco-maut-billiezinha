import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoMaut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Conta> contas = new ArrayList<>();

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Abrir uma Nova Conta");
            System.out.println("2. Selecionar uma Conta");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consuma a nova linha pendente

            switch (escolha) {
                case 1:
                    Cliente novoCliente = criarCliente(scanner);
                    Conta novaConta = criarConta(novoCliente);
                    contas.add(novaConta);
                    break;
                case 2:
                    System.out.println("Selecione o número da conta:");
                    for (int i = 0; i < contas.size(); i++) {
                        System.out.println(i + ". Conta " + contas.get(i).getNumeroConta());
                    }
                    int indiceConta = scanner.nextInt();
                    scanner.nextLine(); // Consuma a nova linha pendente
                    if (indiceConta >= 0 && indiceConta < contas.size()) {
                        Conta contaSelecionada = contas.get(indiceConta);
                        contaSelecionada.operarConta(scanner, contas);
                    } else {
                        System.out.println("Índice de conta inválido.");
                    }
                    break;
                case 3:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static Cliente criarCliente(Scanner scanner) {
        System.out.println("Cadastro do Cliente:");
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfCliente = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimentoCliente = scanner.nextLine();

        System.out.println("Endereço do Cliente:");
        System.out.print("Logradouro: ");
        String logradouroCliente = scanner.nextLine();
        System.out.print("Número: ");
        String numeroCliente = scanner.nextLine();
        System.out.print("Complemento: ");
        String complementoCliente = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidadeCliente = scanner.nextLine();
        System.out.print("Estado: ");
        String estadoCliente = scanner.nextLine();
        System.out.print("CEP: ");
        String cepCliente = scanner.nextLine();

        Endereco enderecoCliente = new Endereco(logradouroCliente, numeroCliente, complementoCliente, cidadeCliente,
                estadoCliente, cepCliente);

        return new Cliente(nomeCliente, cpfCliente, dataNascimentoCliente, enderecoCliente);
    }

    private static Conta criarConta(Cliente novoCliente) {
        return new Conta(null, null, 0, novoCliente);
    }
}
