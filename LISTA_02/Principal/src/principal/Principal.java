package principal;

import java.util.ArrayList;

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
    
    public class Padaria{
        private String nome;
        private String dono;
        private String endereco;
        private float vendasMensais;
        private int qtdeMaxPaes;
        private int qtdeFuncionarios;
        ArrayList<Cozinha> cozinha;
        ArrayList<Restaurante> restaurante;

        public Padaria(String nome, String dono, String endereco, float vendasMensais, int qtdeMaxPaes, int qtdeFuncionarios, ArrayList<Cozinha> cozinha, ArrayList<Restaurante> restaurante) {
            this.nome = nome;
            this.dono = dono;
            this.endereco = endereco;
            this.vendasMensais = vendasMensais;
            this.qtdeMaxPaes = qtdeMaxPaes;
            this.qtdeFuncionarios = qtdeFuncionarios;
            this.cozinha = cozinha;
            this.restaurante = restaurante;
        }

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getDono() {
            return dono;
        }
        public void setDono(String dono) {
            this.dono = dono;
        }
        public String getEndereco() {
            return endereco;
        }
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
        public float getVendasMensais() {
            return vendasMensais;
        }
        public void setVendasMensais(float vendasMensais) {
            this.vendasMensais = vendasMensais;
        }
        public int getQtdeMaxPaes() {
            return qtdeMaxPaes;
        }
        public void setQtdeMaxPaes(int qtdeMaxPaes) {
            this.qtdeMaxPaes = qtdeMaxPaes;
        }
        public int getQtdeFuncionarios() {
            return qtdeFuncionarios;
        }
        public void setQtdeFuncionarios(int qtdeFuncionarios) {
            this.qtdeFuncionarios = qtdeFuncionarios;
        }
        public ArrayList<Cozinha> getCozinha() {
            return cozinha;
        }
        public void setCozinha(ArrayList<Cozinha> cozinha) {
            this.cozinha = cozinha;
        }
        public ArrayList<Restaurante> getRestaurante() {
            return restaurante;
        }
        public void setRestaurante(ArrayList<Restaurante> restaurante) {
            this.restaurante = restaurante;
        }
        
        
    }
    
    public void iniciar(){
        
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
