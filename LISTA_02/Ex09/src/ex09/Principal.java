package ex09;

import java.io.IOException;

public class Principal {
    
    public class ExceptionA extends Exception{
        public ExceptionA(String mensagem){
            super(mensagem);
        }
    }
    
    public class ExceptionB extends ExceptionA{
        public ExceptionB(String mensagem) {
            super(mensagem);
        }
    }
    
    public void iniciar(){
        try{
            throw new ExceptionB("Mensagem de exceção em B");
        } catch (Exception e){
            System.out.println("Exceção: " + e.getMessage());
        }
        try{
            throw new ExceptionA("Mensagem de exceção em A");
        } catch (Exception e){
            System.out.println("Exceção: " + e.getMessage());
        }
        try{
            throw new NullPointerException("Mensagem de exceção para erro de vetor nulo.");
        } catch (Exception e){
            System.out.println("Exceção: " + e.getMessage());
        }
        try{
            throw new IOException("Mensagem de exceção para erro de I/O");
        } catch (Exception e){
            System.out.println("Exceção: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
