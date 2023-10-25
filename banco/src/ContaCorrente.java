import java.util.List;
import java.util.Scanner;

class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciasRealizadas;
    private double taxa = 0.05;

    public ContaCorrente(String numeroAgencia, String numeroConta, double saldo, double chequeEspecial, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasRealizadas = 0;
        this.taxa = taxa;
    }

    public void exibirChequeEspecial() {
        System.out.println("Cheque Especial: R$" + chequeEspecial);
    }

    @Override
    public void operarConta(Scanner scanner, List<Conta> contas) {
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Realizar Transferência");
            System.out.println("5. Exibir Extrato");
            System.out.println("6. Consultar Cheque Especial");
            System.out.println("7. Sair");

            int escolha = scanner.nextInt();
            double valor;

            switch (escolha) {
                case 1:
                    System.out.println("Saldo: R$" + consultarSaldo());
                    break;
                case 2:
                    System.out.print("Informe o valor do depósito: ");
                    valor = scanner.nextDouble();
                    realizarDeposito(valor);
                    break;
                case 3:
                    System.out.print("Informe o valor do saque: ");
                    valor = scanner.nextDouble();
                    if (realizarSaque(valor)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 4:
                    if (transferenciasRealizadas < 2) {
                        System.out.print("Informe o número da conta de destino: ");
                        String numeroContaDestino = scanner.next();
                        Conta contaDestino = Conta.encontrarContaPorNumero(contas, numeroContaDestino);
                        if (contaDestino != null) {
                            System.out.print("Informe o valor da transferência: ");
                            valor = scanner.nextDouble();
                            transfere(valor, contaDestino);
                            transferenciasRealizadas++;
                            System.out.println("Transferência realizada com sucesso.");
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Você atingiu o limite de transferências gratuitas.");
                    }
                    break;
                case 5:
                    exibirExtrato();
                    break;
                case 6:
                    exibirChequeEspecial();
                    break;
                case 7:
                    sair = true;
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    public void transfere(double valor, Conta destino) {
        if (transferenciasRealizadas > 2) {
            double taxaTransferencia = this.taxa;
            this.saldo -= valor + (valor * taxaTransferencia);
        } else {
            saldo -= valor;
            destino.saldo += valor;
        }
    }
}
