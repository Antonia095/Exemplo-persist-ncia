package com.ifpb.arquivos.visao;

import com.ifpb.arquivos.dao.PessoaDao;
import com.ifpb.arquivos.dao.PessoaDaoArquivo;
import com.ifpb.arquivos.modelo.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class TelaCadastroPessoa extends JFrame {
    private PessoaDao dao;
    private DateTimeFormatter formatter;
    private JButton buscarButton;
    private JTextField textField2;
    private JButton salvarEditarButton;
    private JButton excluirButton;
    private JTextField textField1;
    private JTextField textField3;
    private JPanel painel;

    public TelaCadastroPessoa(){
        super("Tela de cadastro de pessoas");

        try {
            dao = new PessoaDaoArquivo();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha na conexão com o arquivo");
        }

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setLocationRelativeTo(null);
        setContentPane(painel);
        pack();
        inicializarComponentes();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa pessoa = null;

                try {
                    pessoa = dao.buscarPorCpf(textField1.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Falha na conexão com o arquivo");
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Classe não encontrada");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Falha na conexão com o banco");
                }

                if(pessoa == null){
                    JOptionPane.showMessageDialog(null,
                            "Pessoa não encontrada");
                }else{
                    textField2.setText(pessoa.getNome());
                    textField3.setText(pessoa.getNascimento()
                            .format(formatter));
                }

            }
        });

    }

    private void inicializarComponentes() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
