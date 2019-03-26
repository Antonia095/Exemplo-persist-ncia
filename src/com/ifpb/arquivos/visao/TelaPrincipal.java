package com.ifpb.arquivos.visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    private JButton gerenciarPessoasButton;
    private JPanel painel;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public TelaPrincipal(){
        super("Tela Principal");
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painel);
        pack();

        gerenciarPessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroPessoa cadastroPessoa = new TelaCadastroPessoa();
                cadastroPessoa.setVisible(true);
                dispose();
            }
        });

    }

    private void createUIComponents() {

        ImageIcon icon = new ImageIcon("imagens/pessoas.png");
        gerenciarPessoasButton = new JButton();
        gerenciarPessoasButton.setIcon(icon);

    }
}
