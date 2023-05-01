package ex08;

public class Principal {
    
    public class ExceptionA extends Exception{
        public ExceptionA(String mensagemC){
            super(mensagemC);
        }
    }
    public class ExceptionB extends ExceptionA{
        public ExceptionB(String mensagemC){
            super(mensagemC);
        }
    }
    public class ExceptionC extends ExceptionB{
        public ExceptionC(){
            super("Mensagem de exceção em C, ocorreu uma divisão por zero.");
        }
    }
    
    public interface IOperacoes{
        public abstract void setOperando1(float operando1);
        public abstract void setOperando2(float operando2);
        public abstract float getResultado() throws ExceptionC;
        public abstract String getNome();
        public abstract int getQuantidade();
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
        public void setOperando2(float operando2){
            this.operando2 = operando2;
        }
        
        @Override
        public float getResultado() throws ExceptionC {
            if (this.getOperando2() == 0){
                throw new ExceptionC();
            }
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
        IOperacoes op = new Divisao(9,0);
        try{
            System.out.println("Resultado: "+ op.getResultado());
        }catch (ExceptionA e){
            System.out.println("A exceção capturada é: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
    
}
