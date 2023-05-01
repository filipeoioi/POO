package principal;

/*
Exercicio 02
Autor(es): Filipe Augusto Parreira Almeida
Data: 01/05/2023
*/

import java.util.ArrayList;

public class Principal {
    
    public interface IComodo{
        public abstract void emitirComanda(String pedido);
        public abstract float calcularPagamento(String pedido);
        public abstract void calcularCompras();
    }
    
    public class Comodo implements IComodo{
        private String nome;
        private static final ArrayList<String> pedidos = new ArrayList<>();
        private static Float valorC;
        private static String pedido;
        
        public Comodo(){
            this.nome = "";
        }
        public Comodo(String nome) {
            this.nome = nome;
        }

        public ArrayList<String> getPedidos() {
            return pedidos;
        }
        public void setPedidos(String pedido) {
            pedidos.add(pedido);
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setValorC(Float valor){
            Comodo.valorC = valor;
        }
        public Float getValorC(){
            return Comodo.valorC;
        }
        public void setPedido(String pedido){
            Comodo.pedido = pedido;
        }
        public String getPedido(){
            return Comodo.pedido;
        }
            
        
        @Override
        public void emitirComanda(String pedido){
            if (this.getClass().getSimpleName().equals("Restaurante")){
                this.setPedidos(pedido);
            } else {
                System.out.println("Cozinha não anota pedido.");
            }
        }
        public void emitirComanda(){
            if (this.getClass().getSimpleName().equals("Cozinha")){
                ArrayList<String> pedidosC = getPedidos();
                if (!(pedidosC.isEmpty())){
                    int countC = 0;
                    System.out.println("");
                    for (String item : pedidosC){
                        countC++;
                        System.out.println("Fazendo o pedido " + countC + ": " + item);
                    }
                    this.limparComanda();
                }
            } else {
                System.out.println("Restaurante não prepara pedido.");
            }
            
        } 
        public void limparComanda(){
            pedidos.clear();
        }
        @Override
        public float calcularPagamento(String pedido){ 
            float valor = 0;
            if (this.getClass().getSimpleName().equals("Restaurante")){
                setPedido(pedido);
                calcularPagamento();
                valor = getValorC();
            } else {
                System.out.println("Cozinha não recebe pedido do principal");
                valor = -999f;
            }
            return (valor + (valor*0.1f));
        }
        
        public void calcularPagamento(){
            String[][] pedidos = {{"Batata frita, X-Burguer, Refrigerante", "20"}, {"Porção de Batata Frita c/ Carne Bovina, Suco 2l", "35"}, 
            {"Prato Executivo, Refrigerante Diet", "23"}, {"HotDog Completo, Refrigentante", "15"}, {"Misto-Quente, Café", "7"}};
            String pedido = getPedido();
            Float valor = 0f;
            for (String[] pedido1 : pedidos) {
                if (pedido1[0].equals(pedido)) {
                    valor = Float.valueOf(pedido1[1]);
                }
            }
            System.out.println("Valor em cozinha: R$ " + valor);
            setValorC(valor);
        }
        @Override 
        public void calcularCompras(){}
    }
    
    public class Restaurante extends Comodo{
        private int qtdeCadeiras;
        private int qtdeMesas;
        private int qtdePedidos;

        public Restaurante() {
            this.qtdeCadeiras = 0;
            this.qtdeMesas = 0;
            this.qtdePedidos = 0;
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas) {
            super();
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
            this.qtdePedidos = 0;
        }
        public Restaurante(int qtdeCadeiras, int qtdeMesas, String nome) {
            super(nome);
            this.qtdeCadeiras = qtdeCadeiras;
            this.qtdeMesas = qtdeMesas;
            this.qtdePedidos = 0;
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
        public int getQtdePedidos() {
            return qtdePedidos;
        }
        public void setQtdePedidos(int qtdePedidos) {
            this.qtdePedidos = qtdePedidos;
        }
        
        
        @Override
        public void emitirComanda(String pedido){
            this.setPedidos(pedido);
            this.setQtdePedidos(this.getQtdePedidos() + 1);
            this.calcularCompras();
        }
        public void exibirComanda(){
            ArrayList<String> pedidos = this.getPedidos();
            int count = 0;
            System.out.println("\nPedidos até o momento: ");
            for (String item : pedidos){
                count++;
                System.out.println("Pedido " + count + ": " + item);
            }
        }
        
        
        @Override
        public float calcularPagamento(String pedido){
            float valor = super.calcularPagamento(pedido);
            return valor;
        }
            
        
        @Override 
        public void calcularCompras(){
            if (this.getQtdePedidos() >= 10){
                System.out.println("\nALERTA: Necessário comprar mantimentos para o restaurante");
            }
        }
        
        @Override
        public String toString() {
            return "Restaurante{" + "nome=" + this.getNome() + ", qtdeCadeiras=" + this.getQtdeCadeiras() + ", qtdeMesas=" + this.getQtdeMesas() + '}';
        }
    }
    
    public class Cozinha extends Comodo{
        private int tiposRefeicao;
        private int qtdePanelas;
        private int qtdeRefeicoes;

        public Cozinha() {
            super();
            this.qtdePanelas = 0;
            this.tiposRefeicao = 0;
            this.qtdeRefeicoes = 0;
        }
        public Cozinha(int tiposRefeicao, int qtdePanelas) {
            super();
            this.tiposRefeicao = tiposRefeicao;
            this.qtdePanelas = qtdePanelas;
            this.qtdeRefeicoes = 0;
        }
        public Cozinha(int tiposRefeicao, int qtdePanelas, String nome) {
            super(nome);
            this.tiposRefeicao = tiposRefeicao;
            this.qtdePanelas = qtdePanelas;
            this.qtdeRefeicoes = 0;
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
        public int getQtdeRefeicoes() {
            return qtdeRefeicoes;
        }
        public void setQtdeRefeicoes(int qtdeRefeicoes) {
            this.qtdeRefeicoes = qtdeRefeicoes;
        }
        
        
        @Override
        public void emitirComanda(){
            ArrayList<String> pedidosC = getPedidos();
            if (!(pedidosC.isEmpty())){
                int countC = 0;
                System.out.println("");
                for (String item : pedidosC){
                    countC++;
                    System.out.println("Fazendo o pedido " + countC + ": " + item);
                    this.setQtdeRefeicoes(this.getQtdeRefeicoes() + 1);
                    this.calcularCompras();
                }
                super.limparComanda();
            }
        }
        
        @Override
        public void calcularCompras(){
            if (this.getQtdeRefeicoes() >= 15){
                System.out.println("\nALERTA: Necessário comprar mantimentos para cozinha");
            }
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
        String[] pedidos = {"Batata frita, X-Burguer, Refrigerante", "Porção de Batata Frita c/ Carne Bovina, Suco 2l",  
            "Prato Executivo, Refrigerante Diet", "HotDog Completo, Refrigentante", "Misto-Quente, Café"};
        Restaurante restaurante = new Restaurante(12, 6, "Restaurante do João");
        Cozinha cozinha = new Cozinha(5, 13, "Cozinha do João");

        restaurante.emitirComanda(pedidos[0]);
        restaurante.emitirComanda(pedidos[1]);
        restaurante.exibirComanda();
        cozinha.emitirComanda();
        restaurante.emitirComanda(pedidos[2]);
        restaurante.emitirComanda(pedidos[3]);
        restaurante.exibirComanda();
        restaurante.emitirComanda(pedidos[4]);
        restaurante.emitirComanda(pedidos[4]);
        restaurante.emitirComanda(pedidos[2]);
        restaurante.emitirComanda(pedidos[0]);
        restaurante.emitirComanda(pedidos[0]);
        restaurante.emitirComanda(pedidos[0]);
        restaurante.emitirComanda(pedidos[1]);
        restaurante.emitirComanda(pedidos[3]);
        restaurante.emitirComanda(pedidos[3]);
        restaurante.emitirComanda(pedidos[2]);
        restaurante.emitirComanda(pedidos[1]);
        cozinha.emitirComanda();
        
        System.out.println("Valor em restaurante: R$ " + restaurante.calcularPagamento(pedidos[0]));
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
