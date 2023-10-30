import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Nome da classe diferente do nome do arquivo
class Conta {
    private String numeroConta;
    public double saldo;
    private List<Transacao> transacoes;

    public Conta(String numeroAgencia, String numeroConta, double saldo, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.transacoes = new ArrayList<>();
    }

    public void operarConta(Scanner scanner, List<Conta> contas) {}

    public double consultarSaldo() {
        return saldo;
    }

    public void realizarDeposito(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado em sua conta.");
            registrarTransacao("Depósito", valor);
        }
    }

    public boolean realizarSaque(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado em sua conta.");
            registrarTransacao("Saque", valor);
            return true;
        }
        return false;
    }

    public boolean realizarTransferencia(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.realizarDeposito(valor);
            System.out.println("Transferência de R$" + valor + " realizada para a conta "
                    + destino.getNumeroConta() + ".");
            registrarTransacao("Transferência", valor);
            return true;
        }
        return false;
    }

    public void exibirExtrato() {
        System.out.println("Extrato da Conta " + numeroConta + ":");
        System.out.println("Saldo: R$" + saldo);

        System.out.println("Histórico de Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println("Tipo: " + transacao.getTipo());
            System.out.println("Valor: R$" + transacao.getValor());
            System.out.println("Data: " + transacao.getData());
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    private void registrarTransacao(String tipo, double valor) {
        Transacao transacao = new Transacao(tipo, valor);
        transacoes.add(transacao);
    }

    public static Conta encontrarContaPorNumero(List<Conta> contas, String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    private class Transacao {
        private String tipo;
        private double valor;
        private String data;

        public Transacao(String tipo, double valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        public String getTipo() {
            return tipo;
        }

        public double getValor() {
            return valor;
        }

        public String getData() {
            return data;
        }
    }
}
