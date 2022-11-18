package Fofoflores.Model;

import java.util.ArrayList;

public class Produto{
    
    private int codigo;
    private String produto;
    private String especie;
    private double valor;
    private String validade;
    private int quantidade;
    private String cor;
    
    private ArrayList<Produto> ListaProduto = null;

    public Produto() {
        
    }
    public Produto(String Especie, String Cor, String Produto, Double Valor, int Quantidade, int Codigo,
            String Validade){
        
        this.especie = Especie;
        this.codigo = Codigo;
        this.produto = Produto;
        this.valor = Valor;
        this.quantidade = Quantidade;
        this.validade = Validade;
        this.cor = Cor;
 
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    } 

    public ArrayList<Produto> getListaProduto() {
        return ListaProduto;
    }

    public void setListaProduto(ArrayList<Produto> ListaProduto) {
        this.ListaProduto = ListaProduto;
    }

}