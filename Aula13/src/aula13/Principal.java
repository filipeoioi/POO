package aula13;

public class Principal {
    public interface Anonima{
        public abstract void imprimir();
        public abstract void imprimir2();
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        Anonima sub = new Anonima(){
            @Override
            public void imprimir(){
                System.out.println("Texto imprimir 1");
            }
            @Override
            public void imprimir2(){
                System.out.println("Texto imprimir 2");
            }
        };
        sub.imprimir();
        sub.imprimir2();
    }
    
}
