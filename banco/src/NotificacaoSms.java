public class NotificacaoSms {

    public void enviarSMS(Cliente cliente, String mensagem) {
        String numeroTelefoneCliente = cliente.getNumeroTelefone();
        System.out.println("Enviando SMS para: " + numeroTelefoneCliente);
        System.out.println("Mensagem: " + mensagem);
    }
}
