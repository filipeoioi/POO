package classesinternasanonimas;

public class Principal {
    private String texto = "Texte Externo";
    public interface Anonima{
        public abstract void imprime();
    }
    public static void main(String[] args) {
        Principal p = new Principal();
        Anonima a = new Anonima(){
            @Override
            public void imprime(){
                System.out.println("Texte alterado");
            }
        };
        a.imprime();
    }
    
}
