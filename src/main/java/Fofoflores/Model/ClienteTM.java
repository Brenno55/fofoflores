/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fofoflores.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Caio Santos
 */
public class ClienteTM extends AbstractTableModel {

    private List<Cliente> linhas;
    private String[] colunas = new String[]{"Mat.", "Nome", "CPF", "Data Nasc.", "Celular", "Telefone", "Email"};

    public ClienteTM() {
        linhas = new ArrayList<Cliente>();
    }

    public ClienteTM(List<Cliente> lista) {
        linhas = new ArrayList<Cliente>(lista);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getMatricula();
            case 1:
                return c.getNome();
            case 2:
                return c.getCPF();
            case 3:
                return c.getCelular();
            case 4:
                return c.getDataNascimento();
            case 5:
                return c.getTelefone();
            case 6:
                return c.getEmail();
            

            default:
                throw new IndexOutOfBoundsException("ColumnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente c = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                c.setMatricula(aValue.toString());
                break;
            case 1:
                c.setNome(aValue.toString());
                break;
            case 2:
                c.setCPF(aValue.toString());
                break;
            case 3:
                c.setCelular(aValue.toString());
                break;
            case 4:
                c.setDataNascimento(aValue.toString());
                break;
            case 5:
                c.setTelefone(aValue.toString());
                break;
            case 6:
                c.setEmail(aValue.toString());
                break;
            default:
        }
           fireTableCellUpdated(rowIndex, columnIndex) ;
    }

    public void setValueAt(Cliente aValue, int rowIndex) {
        Cliente c = linhas.get(rowIndex);

        c.setMatricula(aValue.getMatricula());
        c.setNome(aValue.getNome());
        c.setCPF(aValue.getCPF());
        c.setCelular(aValue.getCelular());
        c.setDataNascimento(aValue.getDataNascimento());
        c.setTelefone(aValue.getTelefone());
        c.setEmail(aValue.getEmail());
        
       

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);
       
        

    }

    public boolean IsCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    public Cliente getCliente(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    public void addCliente(Cliente c) {
        linhas.add(c);
        int ultimoIndice = getRowCount() -1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    public void remove(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        
    }
    public void addLista(List<Cliente> c) {
        int tamanhoAntigo = getRowCount();
        
        linhas.addAll(c);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() -1);
    }
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
    public boolean isEmpty() {
        return linhas.isEmpty();
    }
}
