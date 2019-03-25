package com.ifpb.arquivos.dao;

import com.ifpb.arquivos.banco.ConFactory;
import com.ifpb.arquivos.modelo.Pessoa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class PessoaDaoBanco implements PessoaDao {

    private ConFactory factory;

    public PessoaDaoBanco(){
        factory = new ConFactory();
    }

    @Override
    public Set<Pessoa> getPessoas() {
        return null;
    }

    @Override
    public boolean salvar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO pessoa (cpf,nome,nascimento) VALUES (?,?,?)");

            stmt.setString(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setDate(3, Date.valueOf(pessoa.getNascimento()));

            return stmt.executeUpdate()>0;
        }
    }

    @Override
    public boolean deletar(Pessoa pessoa) {
        return false;
    }

    @Override
    public Pessoa buscarPorCpf(String cpf) {
        return null;
    }

    @Override
    public boolean atualizar(Pessoa pessoa) {
        return false;
    }
}
