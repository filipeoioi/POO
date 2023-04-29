package principal;

public class Principal {
    
    public interface IComodo{
        public abstract void emitirComanda();
        public abstract void calcularPagamento();
        public abstract void calcularCompras();
    }
    
    public class Comodo implements IComodo{
        private String nome;
        
        public Comodo(){
            this.nome = "";
        }
        public Comodo(String nome) {
            this.nome = nome;
        }
        
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        
        @Override
        public void emitirComanda(){}
        @Override
        public void calcularPagamento(){}
        @Override 
        public void calcularCompras(){}
    }
    
    public class Restaurante extends Comodo{
        private int qtdeCadeiras;
        private int qtdeMesas;
        
        public Restaurante(int qtdeCadeiras, int qtdeMesas) {
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
        }

        public int getQtdeCadeiras() {
            return qtdeCadeiras;
        }
        public void setQtdeCadeiras(int qtdeCadeiras) {
            this.qtdeCadeiras = qtdeCadeiras;
        }
        public int getQtdeMesas() {
            return qtdeMesas;
        }
        public void setQtdeMesas(int qtdeMesas) {
            this.qtdeMesas = qtdeMesas;
        }
    }
    
    public class Cozinha extends Comodo{
        private int tiposRefeicao;
        private int qtdePanelas;

        public Cozinha(int tiposRefeicao, int qtdePanelas) {
            this.tiposRefeicao = tiposRefeicao;
            this.qtdePanelas = qtdePanelas;
        }

        public int getTiposRefeicao() {
            return tiposRefeicao;
        }
        public void setTiposRefeicao(int tiposRefeicao) {
            this.tiposRefeicao = tiposRefeicao;
        }
        public int getQtdePanelas() {
            return qtdePanelas;
        }
        public void setQtdePanelas(int qtdePanelas) {
            this.qtdePanelas = qtdePanelas;
        }
    }
    
    public void iniciar(){
        
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
