package ex06;

/*
Exercicio 06
Autor(es): Filipe Augusto Parreira
Data: 15/06/2023
*/

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Ex06 {
    
    public class FuncionarioController{
        private List<Funcionario> funcionarios;

        public FuncionarioController() {
            this.funcionarios = new ArrayList<>();
        }

        public boolean criarFuncionario(String nome, String cargo, double salario, String departamento) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equals(nome)) {
                    return false;
                }
            }

            Funcionario novoFuncionario = new Funcionario(nome, cargo, salario, departamento);
            funcionarios.add(novoFuncionario);
            return true;
        }

        public List<Funcionario> listarFuncionarios() {
            return funcionarios;
        }
    }
    
    public class RHFacade {
        private FuncionarioController funcionarioController;

        public RHFacade() {
            this.funcionarioController = new FuncionarioController();
        }

        public void cadastrarFuncionario() {
            String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
            String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário:");
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário:"));
            String departamento = JOptionPane.showInputDialog("Digite o departamento do funcionário:");

            boolean sucesso = funcionarioController.criarFuncionario(nome, cargo, salario, departamento);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário.");
            }
        }
    }

    
    public void iniciar(){
        RHFacade rh = new RHFacade();
        rh.cadastrarFuncionario();
    }
    
    public static void main(String[] args) {
        Ex06 principal = new Ex06();
        principal.iniciar();
    }
    
}
