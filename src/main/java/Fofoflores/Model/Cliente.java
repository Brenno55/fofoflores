package Fofoflores.Model;


   public class Cliente {
        
    private String Matricula;
    private String Nome;
    private String CPF;
    private String DataNascimento;
    private String Celular;
    private String Telefone;
    private String Email;
    private String Endereco;
    public Cliente() {
   
 }
 public Cliente(String Matricula,String Nome,String CPF,String DataNascimento,String Celular,String Telefone,String Email,String Endereco) {
     this.Matricula = Matricula;
     this.Nome = Nome;
     this.CPF = CPF;
     this.Celular = Celular;
     this.DataNascimento = DataNascimento;
     this.Telefone = Telefone;
     this.Email = Email;
     this.Endereco = Endereco;
 }
 public String getMatricula() {
     return Matricula;
 }
 
 public void setMatricula(String Matricula) {
     this.Matricula = Matricula;
 }
 
 public String getNome() {
     return Nome;
 }
 
 public void setNome(String Nome) {
     this.Nome = Nome;
 }
 public String getCPF() {
     return CPF;
 }
 
 public void setCPF(String CPF) {
     this.CPF = CPF;
 }
 public String getCelular() {
     return Celular;
 }
 
 public void setCelular(String Celular) {
     this.Celular = Celular;
 }
 public String getDataNascimento() {
     return DataNascimento;
 }
 
 public void setDataNascimento(String DataNascimento) {
     this.DataNascimento = DataNascimento;
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
 
 public void setEndereço(String Endereco) {
     this.Endereco = Endereco;
 }
    
    
    
}
