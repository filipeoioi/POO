package ex06;

import java.util.ArrayList;

public class Principal {

    public abstract class Empregado{
        protected String nome;
        protected String sobrenome;
        protected float salarioBase;

        public Empregado(String nome, String sobrenome, float salarioBase) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.salarioBase = salarioBase;
        }
        
        public abstract void ganhos();
        public abstract void imprimir();
    }
    
    public abstract class Assalariado extends Empregado{
        protected float salarioSemanal;

        public Assalariado(String nome, String sobrenome, float salarioBase, float salarioSemanal){
            super(nome, sobrenome, salarioBase);
            this.salarioSemanal = salarioSemanal;
        }
               
        @Override
        public abstract void ganhos();
        @Override
        public abstract void imprimir();
    }
    
    public class Bonificado extends Assalariado{
        private float bonificacao;
        
        public Bonificado(String nome, String sobrenome, float salarioBase, float bonificacao, float salarioSemanal){
            super(nome, sobrenome, salarioBase, salarioSemanal);
            this.bonificacao = bonificacao;
        }

        public float getBonificacao() {
            return bonificacao;
        }
        public void setBonificacao(float bonificacao) {
            this.bonificacao = bonificacao;
        }
        
        @Override
        public void ganhos(){
            System.out.printf("Ganhos: R$ %.2f\n", (this.bonificacao + this.salarioBase));
        }
        @Override
        public void imprimir(){
            System.out.printf("Nome: %s %s\nSalario Base: R$ %.2f\nSalario Semanal: R$ %.2f\nBonificação: R$ %.2f\n", 
                    this.nome, this.sobrenome, this.salarioBase, this.salarioSemanal, this.bonificacao);
        }
    }
    
    public class Comissionado extends Empregado{
        private float taxaComissao;
        
        public Comissionado(String nome, String sobrenome, float salarioBase, float taxaComissao){
            super(nome, sobrenome, salarioBase);
            this.taxaComissao = taxaComissao;
        }

        public float getTaxaComissao() {
            return taxaComissao;
        }
        public void setTaxaComissao(float taxaComissao) {
            this.taxaComissao = taxaComissao;
        }
        
        @Override
        public void ganhos(){
            System.out.printf("Ganhos: %.2f\n", this.getTaxaComissao() + super.salarioBase);
        }
        @Override 
        public void imprimir(){
            System.out.printf("Nome: %s %s\nSalario Base: R$ %.2f\nTaxa de Comissão: R$ %.2f\n", 
                    this.nome, this.sobrenome, super.salarioBase, this.getTaxaComissao());
        }
    }
    
    public class Horista extends Empregado{
        private int horas;
        
        public Horista(String nome, String sobrenome, float salarioBase, int horas){
            super(nome, sobrenome, salarioBase);
            this.horas = horas;
        }

        public int getHoras() {
            return horas;
        }
        public void setHoras(int horas) {
            this.horas = horas;
        }
        
        @Override
        public void ganhos(){
            System.out.printf("Ganhos: R$%.2f, Horas: %d horas\n", super.salarioBase, this.getHoras());
        }
        @Override
        public void imprimir(){
            System.out.printf("Nome: %s %s\nSalario Base: R$ %.2f\nHoras: %d horas\n", 
                    this.nome, this.sobrenome, super.salarioBase, this.getHoras());
        }
    }
    
    public void iniciar(){
        Bonificado b1 = new Bonificado("Joao","Silva", 3624.4f, 391.7f, 906.1f);
        Comissionado c1 = new Comissionado("Maria","Soares", 2158.1f, 461.7f);
        Horista h1 = new Horista("Jomar","Silva Soares", 1562.9f, 29);
        
        System.out.println("--------Item A--------");
        System.out.println("--------BONIFICADO--------");
        b1.ganhos();
        b1.imprimir();
        System.out.println("--------COMISSIONADO--------");
        c1.ganhos();
        c1.imprimir();
        System.out.println("--------HORISTA--------");
        h1.ganhos();
        h1.imprimir();
        
        System.out.println("\n\n--------Item B--------");
        ArrayList<Empregado> lista = new ArrayList<>();
        lista.add(b1);
        lista.add(c1);
        lista.add(h1);
        
        for (Empregado emp : lista){
            System.out.println("----------" + emp.getClass().getSimpleName() + "----------");
            emp.ganhos();
            emp.imprimir();
        }
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
