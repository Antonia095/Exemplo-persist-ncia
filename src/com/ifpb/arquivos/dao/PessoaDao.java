package com.ifpb.arquivos.dao;

import com.ifpb.arquivos.modelo.Pessoa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface PessoaDao {

    Set<Pessoa> getPessoas() throws IOException, ClassNotFoundException, SQLException;
    boolean salvar(Pessoa pessoa) throws IOException, ClassNotFoundException, SQLException;
    boolean deletar(Pessoa pessoa) throws IOException, ClassNotFoundException, SQLException;
    Pessoa buscarPorCpf(String cpf) throws IOException, ClassNotFoundException, SQLException;
    boolean atualizar(Pessoa pessoa) throws IOException, ClassNotFoundException, SQLException;

}
