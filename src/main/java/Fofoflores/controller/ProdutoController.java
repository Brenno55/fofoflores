/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fofoflores.controller;

import Fofoflores.DAO.ProdutoDAO;
import Fofoflores.Model.Produto;

/**
 *
 * @author david
 */
public class ProdutoController {
    public static boolean salvar(String pProdutoNome, String pProdutoCor, double pProdutoValor, String ProdutoEspecie){
    
        Produto flor = new Produto();
        flor.setProdutoNome(pProdutoNome);
        flor.setProdutoEspecie(ProdutoEspecie);
        flor.setProdutoValor(pProdutoValor);
        flor.setProdutoCor(pProdutoCor);
        
        return ProdutoDAO.salvar(flor);
    }
            

}
