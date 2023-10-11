import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoMaut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();
        Endereco enderecoCliente;

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

        enderecoCliente = new Endereco(logradouroCliente, numeroCliente, complementoCliente, cidadeCliente, estadoCliente, cepCliente);
        Cliente cliente = new Cliente(nomeCliente, cpfCliente, dataNascimentoCliente, enderecoCliente);

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Abrir uma Nova Conta");
            System.out.println("2. Selecionar uma Conta");
            System.out.println("3. Exibir Saldo da Conta");
            System.out.println("4. Realizar Depósito");
            System.out.println("5. Realizar Saque");
            System.out.println("6. Realizar Transferência");
            System.out.println("7. Exibir Extrato da Conta");
            System.out.println("8. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numeroConta = scanner.nextLine();
                    Conta novaConta = new Conta(numeroConta, "12345-6", 0.0, cliente);
                    contas.add(novaConta);
                    break;
                case 2:
                    System.out.println("Selecione o número da conta:");
                    for (int i = 0; i < contas.size(); i++) {
                        System.out.println(i + ". Conta " + contas.get(i).getNumeroConta());
                    }
                    int indiceConta = scanner.nextInt();
                    scanner.nextLine(); 
                    if (indiceConta >= 0 && indiceConta < contas.size()) {
                        Conta contaSelecionada = contas.get(indiceConta);
                    } else {
                        System.out.println("Índice de conta inválido.");
                    }
                    break;
                case 3:
                    System.out.println("Exibir Saldo da Conta");
                    break;
                case 4:
                    System.out.println("Realizar Depósito");
                    break;
                case 5:
                    System.out.println("Realizar Saque");
                    break;
                case 6:
                    System.out.println("Realizar Transferência");
                    break;
                case 7:
                    System.out.println("Exibir Extrato da Conta");
                    break;
                case 8:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
