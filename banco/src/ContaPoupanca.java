import java.util.List;
import java.util.Scanner;

class ContaPoupanca extends Conta {
    private double taxaTransferencia;
    private double taxaRendimento;

    public ContaPoupanca(String numeroAgencia, String numeroConta, double saldo, Cliente cliente, double taxaTransferencia, double taxaRendimento) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.taxaTransferencia = taxaTransferencia;
        this.taxaRendimento = taxaRendimento;
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
            System.out.println("6. Voltar");

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
                    System.out.print("Informe o número da conta de destino: ");
                    String numeroContaDestino = scanner.next();
                    Conta contaDestino = Conta.encontrarContaPorNumero(contas, numeroContaDestino);
                    if (contaDestino != null) {
                        System.out.print("Informe o valor da transferência: ");
                        valor = scanner.nextDouble();
                        if (realizarTransferencia(contaDestino, valor)) {
                            System.out.println("Transferência realizada com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Conta de destino não encontrada.");
                    }
                    break;
                case 5:
                    exibirExtrato();
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    @Override
    public boolean realizarTransferencia(Conta destino, double valor) {
        if (valor > 0 && valor <= super.consultarSaldo()) {
            super.saldo -= valor;
            double valorComTaxa = valor + (valor * taxaTransferencia / 100);
            destino.realizarDeposito(valorComTaxa);
            System.out.println("Transferência de R$" + valor + " realizada para a conta " + destino.getNumeroConta() + ".");
            return true;
        }
        return false;
    }

    @Override
    public boolean realizarSaque(double valor) {
        if (valor > 0 && valor <= super.consultarSaldo()) {
            double valorComTaxa = valor - (valor * taxaRendimento / 100);
            super.saldo -= valorComTaxa;
            System.out.println("Saque de R$" + valor + " realizado em sua conta.");
            return true;
        }
        return false;
    }

    @Override
    public void realizarDeposito(double valor) {
        if (valor > 0) {
            double valorComRendimento = valor + (valor * taxaRendimento / 100.0);
            super.saldo += valorComRendimento;
            System.out.println("Depósito de R$" + valor + " realizado em sua conta.");
        }
    }
}
