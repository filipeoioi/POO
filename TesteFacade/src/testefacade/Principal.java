package testefacade;

import java.awt.List;
import java.util.ArrayList;



//Fornece uma fachada para executar uma sequencia de metodos
//Simplifica a chamada de varios métodos

public class Principal {
    
    public class Caixa{
        
    }
    public class Empregado{
        
    }
    public class Produto{
        
    }
    public class FacadeSupermercado{
        private ArrayList<Caixa> caixas;
        private ArrayList<Empregado> empregados;
        private ArrayList<Produto> produtos;
        
        public void start(){
            caixas = new ArrayList<>();
            empregados = new ArrayList<>();
            produtos = new ArrayList<>();
            caixas.add(new Caixa());
            empregados.add(new Empregado());
            produtos.add(new Produto());
        }
    }
    
    public Principal(){
        FacadeSupermercado facade = new FacadeSupermercado();
        facade.start();
    }
    
    public static void main(String[] args) {
        new Principal();
    }
    
}
