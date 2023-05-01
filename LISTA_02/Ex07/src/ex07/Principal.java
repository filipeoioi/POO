package ex07;

import java.util.ArrayList;

public class Principal {

    public interface IOperacoes{
        public abstract void setOperando1(float operando1);
        public abstract void setOperando2(float operando2);
        public abstract float getResultado();
        public abstract String getNome();
        public abstract int getQuantidade();
    }
    
    public class Adicao implements IOperacoes{
        private float operando1;
        private float operando2;
        private static int quantidade = 0;
        
        public Adicao(){
            this.operando1 = 0;
            this.operando2 = 0;
            quantidade++;
        }
        public Adicao(float operando1){
            this.operando1 = operando1;
            this.operando2 = 0;
            quantidade++;
        }
        public Adicao(float operando1, float operando2){
            this.operando1 = operando1;
            this.operando2 = operando2;
            quantidade++;
        }

        public float getOperando1() {
            return operando1;
        }
        @Override
        public void setOperando1(float operando1) {
            this.operando1 = operando1;
        }
        public float getOperando2() {
            return operando2;
        }
        @Override
        public void setOperando2(float operando2) {
            this.operando2 = operando2;
        }
        
        @Override
        public float getResultado(){
            return this.getOperando1() + this.getOperando2();
        }
        @Override
        public String getNome(){
            return this.getClass().getSimpleName();
        }
        @Override
        public int getQuantidade(){
            return quantidade;
        }
    }
    
    public class Subtracao implements IOperacoes{
        private float operando1;
        private float operando2;
        private static int quantidade = 0;
        
        public Subtracao(){
            this.operando1 = 0;
            this.operando2 = 0;
            quantidade++;
        }
        public Subtracao(float operando1){
            this.operando1 = operando1;
            this.operando2 = 0;
            quantidade++;
        }
        public Subtracao(float operando1, float operando2){
            this.operando1 = operando1;
            this.operando2 = operando2;
            quantidade++;
        }

        public float getOperando1() {
            return operando1;
        }
        @Override
        public void setOperando1(float operando1) {
            this.operando1 = operando1;
        }
        public float getOperando2() {
            return operando2;
        }
        @Override
        public void setOperando2(float operando2) {
            this.operando2 = operando2;
        }
        
        @Override
        public float getResultado(){
            return this.getOperando1() - this.getOperando2();
        }
        @Override
        public String getNome(){
            return this.getClass().getSimpleName();
        }
        @Override
        public int getQuantidade(){
            return quantidade;
        }
    }
    
    public class Multiplicacao implements IOperacoes{
        private float operando1;
        private float operando2;
        private static int quantidade = 0;
        
        public Multiplicacao(){
            this.operando1 = 0;
            this.operando2 = 0;
            quantidade++;
        }
        public Multiplicacao(float operando1){
            this.operando1 = operando1;
            this.operando2 = 0;
            quantidade++;
        }
        public Multiplicacao(float operando1, float operando2){
            this.operando1 = operando1;
            this.operando2 = operando2;
            quantidade++;
        }

        public float getOperando1() {
            return operando1;
        }
        @Override
        public void setOperando1(float operando1) {
            this.operando1 = operando1;
        }
        public float getOperando2() {
            return operando2;
        }
        @Override
        public void setOperando2(float operando2) {
            this.operando2 = operando2;
        }
        
        @Override
        public float getResultado(){
            return this.getOperando1() * this.getOperando2();
        }
        @Override
        public String getNome(){
            return this.getClass().getSimpleName();
        }
        @Override
        public int getQuantidade(){
            return quantidade;
        }
    }
    
    public class Divisao implements IOperacoes{
        private float operando1;
        private float operando2;
        private static int quantidade = 0;
        
        public Divisao(){
            this.operando1 = 0;
            this.operando2 = 1;
            quantidade++;
        }
        public Divisao(float operando1){
            this.operando1 = operando1;
            this.operando2 = 1;
            quantidade++;
        }
        public Divisao(float operando1, float operando2){
            this.operando1 = operando1;
            if (operando2 == 0){
                operando2 = 1;
            }
            this.operando2 = operando2;
            quantidade++;
        }

        public float getOperando1() {
            return operando1;
        }
        @Override
        public void setOperando1(float operando1) {
            this.operando1 = operando1;
        }
        public float getOperando2() {
            return operando2;
        }
        @Override
        public void setOperando2(float operando2) {
            if (operando2 == 0){
                operando2 = 1;
            }
            this.operando2 = operando2;
        }
        
        @Override
        public float getResultado(){
            return this.getOperando1() / this.getOperando2();
        }
        @Override
        public String getNome(){
            return this.getClass().getSimpleName();
        }
        @Override
        public int getQuantidade(){
            return quantidade;
        }
    }
    
    public void iniciar(){
        ArrayList<IOperacoes> lista = new ArrayList<>();
        lista.add(new Adicao(2, 2));
        lista.add(new Adicao(3,2));
        lista.add(new Subtracao(5, 2));
        lista.add(new Multiplicacao(6, 3));
        lista.add(new Divisao(10, 5));
        lista.add(new Divisao(5, 10));
        
        for (IOperacoes item : lista){
            System.out.println("--->" + item.getNome() + "\nResultado: " + item.getResultado() + "\nQuantidade: " + item.getQuantidade() +
                    "\n");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Principal p = new Principal();
        p.iniciar();
    }
    
}
