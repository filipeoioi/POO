package ex08;

/*
Exercicio 08
Autor(es): Filipe Augusto Parreira Almeida
Data: 15/06/2023
*/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Janela extends JFrame {
    
    public static Janela janela=null;
    private JTextField campoNome;
    private JTextField campoCargo;
    private JTextField campoSalario;
    private JTextField campoDepartamento;
    private JLabel labelNome;
    private JLabel labelCargo;
    private JLabel labelSalario;
    private JLabel labelDepartamento;
    private JButton botaoCadastrar;
    
    public static Janela iniciar(){
        if(janela==null)
            janela = new Janela();
        return janela;
    }
    public static Janela fechar(){
        janela = null;
        return janela;
    }
    
    private Janela(){        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(240,480);
        setVisible(true);    
        this.setLayout(new FlowLayout());
        
        campoNome = new JTextField("", 20);
        campoCargo = new JTextField("", 20);
        campoSalario = new JTextField("", 10);
        campoDepartamento = new JTextField("", 20);
        
        labelNome = new JLabel("Nome: ");
        labelCargo = new JLabel("Cargo: ");
        labelSalario = new JLabel("Salario: R$");
        labelDepartamento = new JLabel("Departamento: ");
        
        botaoCadastrar = new JButton("Cadastrar!");
        botaoCadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nome = campoNome.getText();
                String cargo = campoCargo.getText();
                double salario;
                try{
                    salario = Double.parseDouble(campoSalario.getText());
                    String departamento = campoDepartamento.getText();
                    Funcionario funcionario = new Funcionario(nome, cargo, salario, departamento);
                    JOptionPane.showMessageDialog(null, "Funcionario: " + funcionario.getNome() + ", cadastrado com sucesso!!", "Ex08", JOptionPane.PLAIN_MESSAGE);
                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Erro, digitou uma letra no campo salario!", "Erro", JOptionPane.ERROR_MESSAGE);
                }               
            }
        });
        
        add(labelNome);
        add(campoNome);
        add(labelCargo);
        add(campoCargo);
        add(labelSalario);
        add(campoSalario);
        add(labelDepartamento);
        add(campoDepartamento);
        add(botaoCadastrar);
    }
}

