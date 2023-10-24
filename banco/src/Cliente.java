class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private Endereco endereco;
    private String email;
    private String numeroTelefone;

    public Cliente(String nome, String cpf, String dataNascimento, Endereco endereco, String email, String numeroTelefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    // Adicione métodos para enviar notificações por e-mail e SMS.
    public void enviarEmail(String mensagem) {
        // Lógica para enviar um e-mail para this.email com a mensagem fornecida.
    }

    public void enviarSMS(String mensagem) {
        // Lógica para enviar um SMS para this.numeroTelefone com a mensagem fornecida.
    }
}
