package teste;

import java.util.ArrayList;

public class Teste {
    public class Pai {
    private static final ArrayList<Integer> informacoesCompartilhadas = new ArrayList<>();

        public void setInformacaoCompartilhada(int informacao) {
            informacoesCompartilhadas.add(informacao);
        }

        public ArrayList<Integer> getInformacoesCompartilhadas() {
            return informacoesCompartilhadas;
        }
    }

    public class Filho1 extends Pai {
        public void compartilharInformacao() {
            int informacao = 10;
            setInformacaoCompartilhada(informacao);
        }
    }

    public class Filho2 extends Pai {
        public void usarInformacoesCompartilhadas() {
            ArrayList<Integer> informacoes = getInformacoesCompartilhadas();
            
            // Use as informações compartilhadas
            for (Integer item : informacoes){
                System.out.println(item);
            }
        }
    }
    
    public void iniciar(){
        Filho1 f1 = new Filho1();
        Filho2 f2 = new Filho2();
        f1.compartilharInformacao();
        f2.usarInformacoesCompartilhadas();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Teste t = new Teste();
        t.iniciar();
        
    }
    
}
