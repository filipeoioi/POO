package ex03;

import java.util.ArrayList;

public class Principal {
    
    public interface IComodo{
        public abstract void emitirComanda();
        public abstract void calcularPagamento();
        public abstract void calcularCompras();
    }
    
    public abstract class Comodo implements IComodo{
        private String nome;
        
        public Comodo(){
            this.nome = "";
        }
        public Comodo(String nome){
            this.nome = nome;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        @Override
        public void emitirComanda(){};
        @Override
        public void calcularPagamento(){};
        @Override
        public void calcularCompras(){};
        
        public abstract void adicionarPrato(String prato);
        public abstract void removerPrato(String prato);
        public abstract void exibirMenu();
        public abstract void realizarLimpeza();
        public abstract void receberPagamento(float valor);
    }
    
    public class Restaurante extends Comodo{
        private int qtdeCadeiras;
        private int qtdeMesas;
        private Cozinha cozinha;
        private float caixa;

        public Restaurante() {
            super();
            this.qtdeCadeiras = 0;
            this.qtdeMesas = 0;
            this.caixa = 0f;
            this.cozinha = new Cozinha();
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas) {
            super();
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
            this.cozinha = new Cozinha();
            this.caixa = 0f;
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas, Cozinha cozinha) {
            super();
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
            this.cozinha = cozinha;
            this.caixa = 0f;
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas, String nome) {
            super(nome);
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
            this.cozinha = new Cozinha();
            this.caixa = 0f;
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas, String nome, Cozinha cozinha) {
            super(nome);
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
            this.cozinha = cozinha;
            this.caixa = 0f;
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
        
        @Override
        public void adicionarPrato(String prato){
            this.cozinha.adicionarPrato(prato);
        }
        @Override
        public void removerPrato(String prato){
            this.cozinha.removerPrato(prato);
        }
        @Override
        public void exibirMenu(){
            this.cozinha.exibirMenu();
        }
        @Override
        public void realizarLimpeza(){
            this.cozinha.realizarLimpeza();
        }
        @Override 
        public void receberPagamento(float valor){
            this.caixa += valor;
            System.out.println("O pagamento de R$" + valor + " foi recebido com sucesso.");
            System.out.println("Saldo atual do caixa: R$" + this.caixa);
            this.cozinha.sujeira += 5;
        }
        
        @Override
        public String toString() {
            return "Restaurante{" + "nome=" + this.getNome() + ", qtdeCadeiras=" + this.getQtdeCadeiras() + ", qtdeMesas=" + this.getQtdeMesas() + '}';
        }
    }
    
    public class Cozinha extends Comodo{
        private int tiposRefeicao;
        private int qtdePanelas;
        private ArrayList<String> pratos = new ArrayList<>();
        private int sujeira;

        public Cozinha() {
            super();
            this.qtdePanelas = 0;
            this.tiposRefeicao = 0;
            this.sujeira = 0;
        }
        public Cozinha(int tiposRefeicao, int qtdePanelas) {
            super();
            this.tiposRefeicao = tiposRefeicao;
            this.qtdePanelas = qtdePanelas;
            this.sujeira = 0;
        }
        public Cozinha(int tiposRefeicao, int qtdePanelas, String nome) {
            super(nome);
            this.tiposRefeicao = tiposRefeicao;
            this.qtdePanelas = qtdePanelas;
            this.sujeira = 0;
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
        public void verificarSujeira(){
            if (this.sujeira >= 70){
                System.out.println("Alerta!! Ambiente sujo, recomenda-se limpeza");
            } else if (this.sujeira == 100){
                System.out.println("O ambiente está em estado crítico, realizando limpeza");
                this.realizarLimpeza();
            }
        }
        
        @Override
        public void adicionarPrato(String prato){
            pratos.add(prato);
            System.out.println(prato + " foi adicionado com sucesso ao menu.");
            this.sujeira += 5;
        }
        @Override
        public void removerPrato(String prato){
            int count = 0;
            boolean removido = false;
            for (String item : pratos){
                if (item.equalsIgnoreCase(prato)){
                    pratos.remove(count);
                    System.out.println(prato + " foi removido com sucesso do menu.");
                    removido = true;
                }
                count++;
            }
            if (!removido){
                System.out.println(prato + " não consta no menu.");
            }
            this.sujeira += 5;
        }
        @Override
        public void exibirMenu(){
            System.out.println("Menu: ");
            for (String item : pratos){
                System.out.println("\t-" + item);
            }
            this.sujeira += 5;
        }
        @Override
        public void realizarLimpeza(){
            this.sujeira = 0;
            System.out.println("Ambiente limpo.");
        }
        @Override
        public void receberPagamento(float valor){
            System.out.println("Cozinha não recebe pagamento.");
        }
        
        @Override
        public String toString() {
            return "Cozinha{" + "nome=" + this.getNome() + ", tiposRefeicao=" + this.getTiposRefeicao() + ", qtdePanelas=" + this.getQtdePanelas() + '}';
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

        public Padaria() {
            this.nome = "";
            this.dono = "";
            this.endereco = "";
            this.vendasMensais = 0;
            this.qtdeMaxPaes = 0;
            this.qtdeFuncionarios = 0;
        }
        public Padaria(String nome, String dono, String endereco, float vendasMensais, int qtdeMaxPaes, 
                int qtdeFuncionarios, ArrayList<Cozinha> cozinha, ArrayList<Restaurante> restaurante) {
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

        @Override
        public String toString() {
            return "Padaria{" + "nome=" + nome + ", dono=" + dono + ", endereco=" + endereco + ", vendasMensais=" + vendasMensais + ", qtdeMaxPaes=" + qtdeMaxPaes + ", qtdeFuncionarios=" + qtdeFuncionarios + ", cozinha=" + cozinha + ", restaurante=" + restaurante + '}';
        }
    }
    
    public void iniciar(){
        Restaurante restaurante = new Restaurante(16, 4);
        Cozinha cozinha = new Cozinha(5, 12);
        
        System.out.println("----------RESTAURANTE----------");
        restaurante.adicionarPrato("Lasanha");
        restaurante.adicionarPrato("Hamburguer");
        restaurante.adicionarPrato("Pão na chapa");
        restaurante.exibirMenu();
        restaurante.removerPrato("Hamburguer");
        restaurante.exibirMenu();
        restaurante.receberPagamento(24.5f);
        restaurante.receberPagamento(40f);
        restaurante.realizarLimpeza();
        
        System.out.println("\n----------COZINHA----------");
        cozinha.adicionarPrato("Lasanha");
        cozinha.adicionarPrato("Hamburguer");
        cozinha.adicionarPrato("Pão na chapa");
        cozinha.exibirMenu();
        cozinha.removerPrato("Hamburguer");
        cozinha.exibirMenu();
        cozinha.receberPagamento(24.5f);
        cozinha.receberPagamento(40f);
        cozinha.realizarLimpeza();
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
