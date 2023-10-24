public class NotificacaoEmail {

    public void enviarEmail(Cliente cliente, String mensagem) {
        String emailCliente = cliente.getEmail();
        System.out.println("Enviando e-mail para: " + emailCliente);
        System.out.println("Mensagem: " + mensagem);
    }
}
