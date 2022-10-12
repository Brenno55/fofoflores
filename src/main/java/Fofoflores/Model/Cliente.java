package Fofoflores.Model;


   public class Cliente {
        
    private int Id;
    private String Nome;
    private String DataNascimento;
    private String Cpf;
    private String Celular;
    private String Telefone;
    private String Email;
    private String Endereco;
    private int Numero;
    private String Cep;
    private String Bairro;
    private String Cidade;
    private String Complemento;
    
    //CONSTRUTOR
    public Cliente() {
   
    }
    
    //SETTERS E GETTERS
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }
    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getCpf() {
        return Cpf;
    }
    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getCelular() {
        return Celular;
    }
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getTelefone() {
        return Telefone;
    }
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEndereco() {
        return Endereco;
    }
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getNumero() {
        return Numero;
    }
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getCep() {
        return Cep;
    }
    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getBairro() {
        return Bairro;
    }
    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }
    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getComplemento() {
        return Complemento;
    }
    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }
}
