
package Fofoflores.Model;

import java.sql.Date;
import java.util.ArrayList;

public class Vendas {
    
    private int ID;
    private int codigoProduto;
    private int idCliente;
    private String cpfCliente;
    private String cliente;
    private String vendedor;
    private int quantidade;
    private double valor;
    private double total;
    private String dataVenda;
    private String produto;

    private ArrayList<Vendas> listaVendas = null;

    public Vendas() {
    }
    public Vendas(String cpfCliente, double total){
        this.cpfCliente = cpfCliente;
        this.total = total;
        // ID da venda Auto incremental
        // data da venda Auto incremental
    }
    public Vendas(String nomedoVendedor, int codigoproduto, int quantidade, double valor, String produto){
        this.vendedor = nomedoVendedor;
        this.codigoProduto = codigoproduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.produto = produto;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
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
        return total;
    }

    public void setTotaldaCompra(double total) {
        this.total = total;
    }
     public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    public ArrayList<Vendas> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(ArrayList<Vendas> listaItens) {
        this.listaVendas = listaItens;
    }
}
