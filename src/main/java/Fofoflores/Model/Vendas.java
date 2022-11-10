
package Fofoflores.Model;

import java.sql.Date;

public class Vendas {
    
    private int ID;
    private int codigoProduto;
    private int idCliente;
    private String cpfCliente;
    private String cliente;
    private String vendedor;
    private int quantidade;
    private Double valor;
    private Double total;
    private Date dataVenda;
    private double totaldaCompra;
    

    public Vendas() {
    }
    public Vendas(String cpfCliente, double totaldaCompra){
        this.cpfCliente = cpfCliente;
        this.totaldaCompra = totaldaCompra;
        // ID da venda Auto incremental
        // data da venda Auto incremental
    }
    public Vendas(String nomedoVendedor, int codigoproduto, int quantidade, double valor){
        this.vendedor = nomedoVendedor;
        this.codigoProduto = codigoproduto;
        this.quantidade = quantidade;
        this.valor = valor;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public double getTotaldaCompra() {
        return totaldaCompra;
    }

    public void setTotaldaCompra(double totaldaCompra) {
        this.totaldaCompra = totaldaCompra;
    }
}
