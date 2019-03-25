package com.ifpb.arquivos.dao;

import com.ifpb.arquivos.banco.ConFactory;
import com.ifpb.arquivos.modelo.Pessoa;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PessoaDaoBanco implements PessoaDao {

    private ConFactory factory;

    public PessoaDaoBanco(){
        factory = new ConFactory();
    }

    @Override
    public Set<Pessoa> getPessoas() throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM pessoa"
            );

            ResultSet resultSet = statement.executeQuery();
            Set<Pessoa> pessoas = new HashSet<>();

            while(resultSet.next()){
                String cpf1 = resultSet.getString("cpf");
                String nome = resultSet.getString(2);
                LocalDate nascimento = resultSet
                        .getDate("nascimento").toLocalDate();

                pessoas.add(new Pessoa(cpf1, nome,nascimento));
            }

            return pessoas;
        }
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
    public boolean deletar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM pessoa WHERE cpf = ?"
            );

            statement.setString(1, pessoa.getCpf());

            return statement.executeUpdate()>0;
        }
    }

    @Override
    public Pessoa buscarPorCpf(String cpf) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM pessoa WHERE cpf = ?"
            );

            stmt.setString(1, cpf);

            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){
                String cpf1 = resultSet.getString("cpf");
                String nome = resultSet.getString(2);
                LocalDate nascimento = resultSet
                        .getDate("nascimento").toLocalDate();

                return new Pessoa(cpf1, nome, nascimento);

            }else{
                return null;
            }

        }
    }

    @Override
    public boolean atualizar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE pessoa SET nome=?, nascimento=? WHERE cpf=?"
            );

            statement.setString(1,pessoa.getNome());
            statement.setDate(2, Date.valueOf(pessoa.getNascimento()));
            statement.setString(3, pessoa.getCpf());

            return statement.executeUpdate()>0;

        }
    }
}
