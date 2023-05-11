package revisao;

import java.util.ArrayList;

public class Revisao {
    public abstract class SistemaAcademico{
        private float nota;
        public float getNota(){
            return this.nota;
        }
    }
    public abstract class EngenhariaComputacao extends SistemaAcademico{
        
    }
    public class POO extends EngenhariaComputacao implements IPOO{
        @Override
        public float getNota(){
            return super.nota;
        }
        @Override
        public void setNota(float nota){
            
        }
        
    }
    public interface IPOO extends IDisciplinas{}
    public interface IDisciplinas{
        public abstract void setNota(float nota);
    }
    public void iniciar(){
        
    }
    public static void main(String[] args) {
        Revisao p = new Revisao();
        p.iniciar();
    }
    
}
