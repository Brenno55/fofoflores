/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fofoflores.Model;

/**
 *
 * @author david
 */
public class Produto{
    
    private int produtoId;
    private String produtoNome;
    private String produtoCor;
    private double produtoValor;
    private String produtoEspecie;

    public Produto() {
        //TODO: Definir comportamento padrao
    }

    
    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoCor() {
        return produtoCor;
    }

    public void setProdutoCor(String produtoCor) {
        this.produtoCor = produtoCor;
    }

    public double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public String getProdutoEspecie() {
        return produtoEspecie;
    }

    public void setProdutoEspecie(String produtoEspecie) {
        this.produtoEspecie = produtoEspecie;
    }
    
    
}




