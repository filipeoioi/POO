package ex07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex07 extends JFrame {
      
    public static class FuncionarioCollection{
        private List<Funcionario> funcionarios;

        public FuncionarioCollection() {
            this.funcionarios = new ArrayList<>();
        }

        public void adicionarFuncionario(Funcionario funcionario) {
            funcionarios.add(funcionario);
        }

        public Iterator<Funcionario> criarIterator() {
            return funcionarios.iterator();
        }
    }
    
    private FuncionarioCollection funcionarios;
    private Iterator<Funcionario> iterator;
    private JLabel labelNome;
    private JLabel labelNome1;
    private JLabel labelCargo;
    private JLabel labelCargo1;
    private JButton botaoProximo;

    public Ex07() {
        funcionarios = new FuncionarioCollection();
        
        funcionarios.adicionarFuncionario(new Funcionario("João", "Administrativo", 1500, "Administração"));
        funcionarios.adicionarFuncionario(new Funcionario("Maria", "Técnica", 1300, "T.I"));
        
        iterator = funcionarios.criarIterator();
        
        labelNome = new JLabel();
        labelCargo = new JLabel();
        labelNome1 = new JLabel("Nome: ");
        labelCargo1 = new JLabel("Cargo: ");
        botaoProximo = new JButton("Próximo");
        
        botaoProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iterator.hasNext()) {
                    Funcionario funcionario = iterator.next();
                    labelNome.setText(funcionario.getNome());
                    labelCargo.setText(funcionario.getCargo());
                } else {
                    labelNome.setText("Fim da lista");
                    labelNome1.setText("");
                    labelCargo1.setText("");
                    labelCargo.setText("");
                }
            }
        });

        setLayout(new FlowLayout());
        add(labelNome1);
        add(labelNome);
        add(labelCargo1);
        add(labelCargo);
        add(botaoProximo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex07();
            }
        });
    }
}
