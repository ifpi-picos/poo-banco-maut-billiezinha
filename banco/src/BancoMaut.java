import java.util.ArrayList;
import java.util.InputMismatchException;
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
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Cliente novoCliente = criarCliente(scanner);
                    Conta novaConta = criarConta(novoCliente, scanner);
                    contas.add(novaConta);
                    break;

                case 2:
                if (contas.isEmpty()) {
                    System.out.println("Nenhuma conta cadastrada.");
                } else {
                    System.out.println("Selecione o número da conta:");
                    for (int i = 0; i < contas.size(); i++) {
                        System.out.println(i + ". Conta " + contas.get(i).getNumeroConta());
                    }

                    int indiceConta = -1;
                    try {
                        indiceConta = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Índice de conta inválido. Certifique-se de inserir um número.");
                        break;
                    } finally {
                        scanner.nextLine();
                    }

                    if (indiceConta >= 0 && indiceConta < contas.size()) {
                        Conta contaSelecionada = contas.get(indiceConta);
                        contaSelecionada.operarConta(scanner, contas);
                    } else {
                        System.out.println("Índice de conta inválido. Certifique-se de escolher um número válido.");
                    }
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

        System.out.print("E-mail: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Número de Telefone: ");
        String numeroTelefoneCliente = scanner.nextLine();

        Endereco enderecoCliente = new Endereco(logradouroCliente, numeroCliente, complementoCliente, cidadeCliente,
                estadoCliente, cepCliente);

        return new Cliente(nomeCliente, cpfCliente, dataNascimentoCliente, enderecoCliente, emailCliente, numeroTelefoneCliente);
    }

    private static Conta criarConta(Cliente novoCliente, Scanner scanner) {
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int escolhaTipoConta = scanner.nextInt();
        scanner.nextLine();
    
        if (escolhaTipoConta == 1) {
            double valorChequeEspecial = 1000.0;
            return new ContaCorrente(null, null, valorChequeEspecial, escolhaTipoConta, novoCliente);
        } else if (escolhaTipoConta == 2) {
            double taxaTransferencia = 0.10; 
            double rendimento = 0.10; 
            return new ContaPoupanca(null, null, 0, novoCliente, taxaTransferencia, rendimento);
        } else {
            System.out.println("Tipo de conta inválido. A conta não foi criada.");
            return null;
        }
    }
    
    
}
