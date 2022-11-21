
package Fofoflores.DAO;

import java.util.*;
import static Fofoflores.DAO.VendasDAO.login;
import static Fofoflores.DAO.VendasDAO.senha;
import static Fofoflores.DAO.VendasDAO.url;
import Fofoflores.Model.Cliente;
import Fofoflores.Model.Vendas;
import View.TelaCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClienteDAO {
    
    public static  String url="jdbc:mysql://localhost/fofoflores";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Cliente obj) {
        
        boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO cliente (cpf, nome, data_nascimento, celular, telefone, email, endereco, numero_casa, cep, bairro, cidade, complemento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            comandoSQL.setString(1, obj.getCpf());
            comandoSQL.setString(2, obj.getNome());
            comandoSQL.setString(3, obj.getDataNascimento());
            comandoSQL.setString(4, obj.getCelular());
            comandoSQL.setString(5, obj.getTelefone());
            comandoSQL.setString(6, obj.getEmail());
            comandoSQL.setString(7, obj.getEndereco());
            comandoSQL.setString(8, obj.getNumero());
            comandoSQL.setString(9, obj.getCep());
            comandoSQL.setString(10, obj.getBairro());
            comandoSQL.setString(11, obj.getCidade());
            comandoSQL.setString(12, obj.getComplemento());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                  retorno = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            retorno = false;
        }
        return retorno;
    }
    public static ArrayList<Cliente> listarFiltro(String Cpf){
        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        
        Connection conexao = null;
        
        try{
            //1) Carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Abrir a conexao
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3) Criar objeto de conexão
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf =?");
            comandoSQL.setString(1, Cpf);
            
            
            //4) Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();
            
            
            if(rs != null){
                
                //Enquanto existirem linhas
                while(rs.next()){
                    //Resgato o valor de cada linha e passo para o objeto
                    Cliente novoObjeto = new Cliente();
                    novoObjeto.setNome(rs.getString("nome"));
                    novoObjeto.setDataNascimento(rs.getString("data_nascimento"));
                    novoObjeto.setCpf(rs.getString("cpf"));
                    novoObjeto.setCelular(rs.getString("celular"));
                    novoObjeto.setTelefone(rs.getString("telefone"));
                    novoObjeto.setEmail(rs.getString("email"));
                    novoObjeto.setEndereco(rs.getString("endereco"));
                    novoObjeto.setNumero(rs.getString("numero_casa"));
                    novoObjeto.setCep(rs.getString("cep"));
                    novoObjeto.setBairro(rs.getString("bairro"));
                    novoObjeto.setCidade(rs.getString("cidade"));
                    novoObjeto.setComplemento(rs.getString("complemento"));
                    
                    
                    //Em seguida, adiciono o objeto à lista
                    listaRetorno.add(novoObjeto);
                
                }

            }       
        }catch(ClassNotFoundException ex){
            listaRetorno = null;
        }catch (SQLException ex) {
            listaRetorno = null;
        }
        
        return listaRetorno;
    }
}
