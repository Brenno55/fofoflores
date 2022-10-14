
package Fofoflores.Model;

public class Vendas {
    
    private String CpfCliente;
    private String NomeCliente;
    private String NomeVendedor;
    private String Produto;
    private String Espécie;
    private String Cor;
    private int Quantidade;
    private Double Valor;
    private Double Total;
    private String codigo;

    
    //CONSTRUTOR
    public Vendas() {
    }
    
    //GETTERS E SETTERS 
    public String getCpfCliente() {
        return CpfCliente;
    }

    public void setCpfCliente(String CpfCliente) {
        this.CpfCliente = CpfCliente;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getNomeVendedor() {
        return NomeVendedor;
    }

    public void setNomeVendedor(String NomeVendedor) {
        this.NomeVendedor = NomeVendedor;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public String getEspécie() {
        return Espécie;
    }

    public void setEspécie(String Espécie) {
        this.Espécie = Espécie;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
