public class BancoMaut {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Joao", null, null,
                new Endereco(null, null, null, null, null, null), null, null);

        Conta cc = new ContaCorrente("1", "123", 0, 100, cliente);
        Conta cp = new ContaPoupanca("1", "456", 100, cliente, 0.1, 0.1);

        cc.exibirExtrato();
        cc.realizarDeposito(100);
        cc.realizarSaque(50);
        cc.exibirExtrato();
        cc.realizarTransferencia(cp, 10);
        cc.realizarTransferencia(cp, 10);
        cc.realizarTransferencia(cp, 10);
        cc.realizarTransferencia(cp, 10);
        cc.realizarTransferencia(cp, 10);
        cc.exibirExtrato();
        // transferencia não está cobrando as taxas e não está sendo efetivada com cheque especial
        cc.realizarTransferencia(cp, 50);
        cc.exibirExtrato();

        cp.exibirExtrato();
        // não está cobrando taxa de saque
        cp.realizarSaque(100);
        cp.exibirExtrato();
    }


}
