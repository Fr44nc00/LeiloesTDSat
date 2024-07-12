/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public int cadastrarProduto (ProdutosDTO produto){
        
        conn = new conectaDAO().connectDB();
        PreparedStatement st;
        int status;
        try {
            //preparando a string sql com o código de inserção para o banco de dados
            st = conn.prepareStatement("INSERT INTO produtos(nome, valor, status)"
                    + "VALUES(?,?,?)");
            //setando os parâmetros
            st.setString(1, produto.getNome());
            st.setInt(2, produto.getValor());
            st.setString(3, produto.getStatus());
            //executando a query
            status = st.executeUpdate();
            //retornando o valor da query
            return status;
        } catch (SQLException ex) {
            //mensagem de erro caso o programa não consiga se conectar com o banco de dados
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar dados do filme: "
                    + ex.getMessage());
            return ex.getErrorCode();
        }
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

