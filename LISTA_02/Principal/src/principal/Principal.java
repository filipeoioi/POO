package principal;

import java.util.ArrayList;

public class Principal {
    
    public interface IComodo{
        public abstract void emitirComanda(String pedido); //Fazer recebendo 3 paramentros: pedido, restaurante, cozinha.
        public abstract void calcularPagamento();
        public abstract void calcularCompras();
    }
    
    public class Comodo implements IComodo{
        private String nome;
        private static final ArrayList<String> pedidos = new ArrayList<>();
        
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
        
        public void limparComanda(){
            pedidos.clear();
        }
        @Override
        public void emitirComanda(String pedido){
            this.setPedidos(pedido);
        }
        public void emitirComanda(){
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
        } 
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
        public void emitirComanda(String pedido){
            this.setPedidos(pedido);
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
        
        public void emitirComanda(){
            ArrayList<String> pedidosC = getPedidos();
            if (!(pedidosC.isEmpty())){
                int countC = 0;
                System.out.println("");
                for (String item : pedidosC){
                    countC++;
                    System.out.println("Fazendo o pedido " + countC + ": " + item);
                }
                super.limparComanda();
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

        @Override
        public String toString() {
            return "Padaria{" + "nome=" + nome + ", dono=" + dono + ", endereco=" + endereco + ", vendasMensais=" + vendasMensais + ", qtdeMaxPaes=" + qtdeMaxPaes + ", qtdeFuncionarios=" + qtdeFuncionarios + ", cozinha=" + cozinha + ", restaurante=" + restaurante + '}';
        }
    }
    
    public void iniciar(){
        ArrayList<Comodo> lista = new ArrayList<>();
        Comodo cozinha1 = new Cozinha(5, 12, "Cozinha1");
        Comodo cozinha2 = new Cozinha(2, 10);
        Comodo restaurante1 = new Restaurante(12, 6, "Restaurante1");
        Comodo restaurante2 = new Restaurante(24, 12);
        
        lista.add(cozinha1);
        lista.add(restaurante1);
        lista.add(cozinha2);
        lista.add(restaurante2);
        
        System.out.println("Item 1:");
        for (Comodo comodo : lista){
            System.out.println(comodo);
        }
        
        System.out.println("\nItem 2:");
        restaurante1.emitirComanda("Batata frita, X-Burguer, Refrigerante");
        restaurante1.emitirComanda("Porção de Batata Frita c/ Carne Bovina, Suco 2l");
        ((Restaurante) restaurante1).exibirComanda();
        cozinha1.emitirComanda();
        restaurante1.emitirComanda("Prato Executivo, Refrigerante Diet");
        ((Restaurante) restaurante1).exibirComanda();
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
