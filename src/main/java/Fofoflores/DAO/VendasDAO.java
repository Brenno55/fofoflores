package Fofoflores.DAO;

import Fofoflores.Model.Cliente;
import Fofoflores.Model.Vendas;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendasDAO {

    public static String url = "jdbc:mysql://localhost:3306/fofoflores";
    public static String login = "root";
    public static String senha = "";

    public static ArrayList<Vendas> buscarPeriodo(Date dataInicio, Date dataFinal) {
        ArrayList<Vendas> listaRetorno = new ArrayList<>();

        Connection conn = null;
        PreparedStatement sql = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, senha);
            
            sql = conn.prepareStatement("SELECT a.nome, b.id_venda, b.data_venda, b.valor_venda FROM cliente a inner join vendas b on a.cpf = b.cpf WHERE b.data_venda BETWEEN ? AND ?;");
            sql.setDate(1, new java.sql.Date(dataInicio.getTime()));
            sql.setDate(2, new java.sql.Date(dataFinal.getTime() + 86399999));
            rs = sql.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Vendas objeto = new Vendas();
                    objeto.setCliente(rs.getString("nome"));
                    objeto.setID(rs.getInt("id_venda"));
                    objeto.setDataVenda(String.valueOf(rs.getTimestamp("data_venda")));
                    objeto.setTotal(rs.getDouble("valor_venda"));
                    listaRetorno.add(objeto);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            listaRetorno = null;
        }
        return listaRetorno;
    }
    
    public static ArrayList<Vendas> buscarDetalhes(int id) {

        ArrayList<Vendas> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT nome_produto, valor_produto, quantidade FROM detalhes_venda WHERE id_venda = ?;");
            comandoSQL.setInt(1, id);
            ResultSet rs = comandoSQL.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Vendas objeto = new Vendas();
                    objeto.setProduto(rs.getString("nome_produto"));
                    objeto.setValor(rs.getDouble("valor_produto"));
                    objeto.setQuantidade(rs.getInt("quantidade"));
                    listaRetorno.add(objeto);
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na SQL");
        }
        return listaRetorno;
    }

    public static boolean salvar(Vendas obj) {
        boolean retorno = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO vendas (cpf,vendedor,valor_venda) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, obj.getCpfCliente());
            comandoSQL.setString(2, obj.getVendedor());
            comandoSQL.setDouble(3, obj.getTotal());

            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    for (Vendas item : obj.getListaVendas()) {
                        PreparedStatement comandoSQLItem = conexao.prepareStatement("INSERT INTO detalhes_venda (id_venda,id_produto,nome_produto,quantidade,valor_produto) VALUES (?,?,?,?,?)");
                        comandoSQLItem.setInt(1, id);
                        comandoSQLItem.setInt(2, item.getCodigoProduto());
                        comandoSQLItem.setString(3, item.getProduto());
                        comandoSQLItem.setInt(4, item.getQuantidade());
                        comandoSQLItem.setDouble(5, item.getValor());

                        int linhasAfetadasItem = comandoSQLItem.executeUpdate();
                        if (linhasAfetadasItem > 0) {
                            retorno = true;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    public static Cliente listar1(String cpf) {

        Cliente novoObjeto = new Cliente();
        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT nome from cliente WHERE cpf = ?;");
            
            comandoSQL.setString(1, cpf);
            ResultSet rs = comandoSQL.executeQuery();
           
            novoObjeto.setNome("vazio");
            if (rs != null) {
                while(rs.next()){
                    novoObjeto.setNome(rs.getString("nome"));
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na SQL");
        }
        return novoObjeto;

    }
    
        public static Vendas listar(int id) {

        Vendas novoObjeto = new Vendas();
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT produto, valor from produto WHERE codigo_produto = ?;");
            comandoSQL.setInt(1, id);
            ResultSet rs = comandoSQL.executeQuery();
            if (rs != null) {
                while(rs.next()){
                novoObjeto.setProduto(rs.getString("produto"));
                novoObjeto.setValor(rs.getDouble("valor"));
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na SQL");
        }
        return novoObjeto;
    }
}
