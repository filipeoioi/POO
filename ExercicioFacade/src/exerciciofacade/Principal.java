package exerciciofacade;

import javax.swing.JOptionPane;

public class Principal {
    
    public abstract class Facade{
        public abstract void iniciar();
    }
    public class Funcionario{
        private String nome;
        private String cargo;
        private String setor;
        public Funcionario(){
            nome = "";
            cargo = "";
            setor = "";
        }
        public String getNome() {
            return nome;
        }
        private void setNome(String nome) {
            this.nome = nome;
        }
        public String getCargo() {
            return cargo;
        }
        private void setCargo(String cargo) {
            this.cargo = cargo;
        }
        public String getSetor() {
            return setor;
        }
        private void setSetor(String setor) {
            this.setor = setor;
        }
        
        public void cadastrarNome(String nome){
            this.setNome(nome);
        }
        public void cadastrarCargo(String cargo){
            this.setCargo(cargo);
        }
        public void cadastrarSetor(String setor){
            this.setSetor(setor);
        }
    }
    public class RH extends Facade{
        private Funcionario funcionario;
        @Override
        public void iniciar() {
            funcionario = new Funcionario();
            JOptionPane.showMessageDialog(null, "Cadastro De Funcionario");
            String nome = JOptionPane.showInputDialog("Insira o nome do funcionário: ");
            String cargo = JOptionPane.showInputDialog("Cargo que o " + nome + " vai oculpar: ");
            String setor = JOptionPane.showInputDialog("Setor em que " + nome + " vai trabalhar: ");
            funcionario.cadastrarNome(nome);
            funcionario.cadastrarCargo(cargo);
            funcionario.cadastrarSetor(setor);
            String mensagem = "Dados do funcionario: \nNome: " + funcionario.getNome() + "\nCargo: " + funcionario.getCargo() + "\nSetor: " + funcionario.getSetor();
            JOptionPane.showMessageDialog(null, mensagem);
        }
        
    }
    
    public Principal(){
        RH rh = new RH();
        rh.iniciar();
    }
    public static void main(String[] args) {
        new Principal();
    }
    
}
