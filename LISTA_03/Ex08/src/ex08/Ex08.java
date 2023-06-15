package ex08;

/*
Exercicio 08
Autor(es): Filipe Augusto Parreira Almeida
Data: 15/06/2023
*/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex08 extends JFrame {

    private JButton botaoJanela;

    public class JanelaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
          Janela janela = Janela.iniciar();
          janela.addWindowListener(new WindowAdapter(){
              @Override
              public void windowClosing(WindowEvent e){
                  Janela.fechar();
              }
          });
        }
    }
    
    public Ex08(){
        setLayout(new FlowLayout());       
        botaoJanela = new JButton("Cadastrar Funcionario");
        botaoJanela.addActionListener(new JanelaListener());
        add(botaoJanela);
    }    

    public static void main(String[] args) {
        Ex08 principal = new Ex08();
        principal.setDefaultCloseOperation(EXIT_ON_CLOSE);
        principal.setSize(240,480);
        principal.setVisible(true);
    }
    
}


