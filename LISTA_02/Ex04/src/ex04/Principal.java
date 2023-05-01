package ex04;

import java.util.ArrayList;

public class Principal {
    
    public interface IComodo{
        public abstract void emitirComanda();
        public abstract void calcularPagamento();
        public abstract void calcularCompras();
    }
    
    public interface IMoeda{
        public void calcularTroco(float valorPago, float valorCompra);
    }
    
    public class Euro implements IMoeda{
        private float valorAtual;
        
        public Euro(){
            this.valorAtual = 5.47f;
        }
                
        @Override
        public void calcularTroco(float valorPago, float valorCompra){
            float valorReal = valorPago * this.valorAtual;
            float troco = valorReal - valorCompra;
            if (troco < 0){
                System.out.printf("Está faltando R$ %.2f ou Є %.2f\n", (troco*-1), ((troco*-1)/this.valorAtual));
            } else {
                System.out.printf("O troco é de R$ %.2f ou Є %.2f\n", troco, (troco/this.valorAtual));
            }
        } 
    }
    
    public class Real implements IMoeda{
        @Override
        public void calcularTroco(float valorPago, float valorCompra){
            float troco = valorPago - valorCompra;
            if (troco < 0){
                System.out.printf("Está faltando R$ %.2f\n", (troco*-1));
            } else{
                System.out.printf("O troco é de R$ %.2f\n", troco);
            }
        }
    }
    
    public class BitCoin implements IMoeda{
        private float valorAtual;
        
        public BitCoin(){
            this.valorAtual = 140276.17f;
        }
        
        @Override
        public void calcularTroco(float valorPago, float valorCompra){
            float valorReal = valorPago * this.valorAtual;
            float troco = valorReal - valorCompra;
            if (troco < 0){
                System.out.printf("Está faltando R$ %.2f ou %.2f BTC\n", (troco*-1), ((troco*-1)/this.valorAtual));
            } else {
                System.out.printf("O troco é de R$ %.2f ou %.7f BTC\n", troco, troco/this.valorAtual);
            }
        }        
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

        public Restaurante() {
            this.qtdeCadeiras = 0;
            this.qtdeMesas = 0;
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas) {
            super();
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas, String nome) {
            super(nome);
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
        
        @Override
        public String toString() {
            return "Restaurante{" + "nome=" + this.getNome() + ", qtdeCadeiras=" + this.getQtdeCadeiras() + ", qtdeMesas=" + this.getQtdeMesas() + '}';
        }
    }
    
    public class Cozinha extends Comodo{
        private int tiposRefeicao;
        private int qtdePanelas;

        public Cozinha() {
            super();
            this.qtdePanelas = 0;
            this.tiposRefeicao = 0;
        }
        public Cozinha(int tiposRefeicao, int qtdePanelas) {
            super();
            this.tiposRefeicao = tiposRefeicao;
            this.qtdePanelas = qtdePanelas;
        }
        public Cozinha(int tiposRefeicao, int qtdePanelas, String nome) {
            super(nome);
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
        ArrayList<IMoeda> moedas = new ArrayList<>();
        moedas.add(new Real());
        moedas.add(new Euro());
        moedas.add(new BitCoin());
        
        float valorCompra = 45.2f;
        float valorReal = 50f;
        float valorEuro = 9.14f;
        float valorBTC = 0.00036f;
        
        for (IMoeda item : moedas){
            if (item.getClass().getSimpleName().equals("Real")){
                item.calcularTroco(valorReal, valorCompra);
            }
            if (item.getClass().getSimpleName().equals("Euro")){
                item.calcularTroco(valorEuro, valorCompra);
            }
            if (item.getClass().getSimpleName().equals("BitCoin")){
                item.calcularTroco(valorBTC, valorCompra);
            }
        }
        
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
