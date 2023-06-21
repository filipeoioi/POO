package testeiterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
    public interface IFrutas{
        public abstract String nome();
    }
    public static class FrutasVendas implements IFrutas{
        @Override
        public String nome(){
            return "Fruta Vendas";
        }
    }
    public static class FrutasDeposito implements IFrutas{

        @Override
        public String nome() {
            return "Frutas Depósito";
        }
        
    }
    public static class FrutasDescarte implements IFrutas{

        @Override
        public String nome() {
            return "Frutas Descarte";
        }
        
    }
    
    public static class Prateleira{
        private IFrutas fruta;
        public Prateleira(){
            setFruta(fruta);
        }

        private void setFruta(IFrutas fruta) {
            this.fruta = fruta;
        }
        public IFrutas alternarFruta(IFrutas fruta){
            setFruta(fruta);
            return this.fruta;
        }
        @Override
        public String toString(){
            return this.fruta.nome() + "";
        }
    }
    
    public Principal(){
        ArrayList<IFrutas> lista = new ArrayList<>();
        
        Prateleira prateleira = new Prateleira();
        
        lista.add(prateleira.alternarFruta(new FrutasDeposito()));
        lista.add(prateleira.alternarFruta(new FrutasVendas()));
        lista.add(prateleira.alternarFruta(new FrutasDescarte()));
        
        Iterator iterator = lista.iterator();
        
        while(iterator.hasNext()){
            IFrutas fruta = (IFrutas)iterator.next();
            System.out.println(fruta.nome());
        }
        
    }
    public static void main(String[] args) {
        new Principal();
    }
    
}
