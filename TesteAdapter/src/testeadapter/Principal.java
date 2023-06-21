package testeadapter;

public class Principal {
    
    public interface IFrutas{
        public abstract String nome();
        public abstract int operacao();
    }
    
    public static class FrutaVendas implements IFrutas{

        @Override
        public String nome() {
            return "Fruta Vendas";
        }

        @Override
        public int operacao() {
            return 111;
        }
        
    }
    
    public static class FrutaDeposito implements IFrutas{

        @Override
        public String nome() {
            return "Fruta Deposito";
        }

        @Override
        public int operacao() {
            return 222;
        }
        
    }
    
    public static class FrutaDescarte implements IFrutas{

        @Override
        public String nome() {
            return "Fruta Descarte";
        }

        @Override
        public int operacao() {
            return 333;
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
            return this.fruta + "";
        }
    }
    
    
    public Principal(){
        IFrutas f1 = new FrutaDeposito();
        System.out.println(f1.nome());
        System.out.println(f1.operacao());
        
        f1 = new FrutaVendas();
        System.out.println(f1.nome());
        System.out.println(f1.operacao());
        
        f1 = new FrutaDescarte();
        System.out.println(f1.nome());
        System.out.println(f1.operacao());
    }
    
    public static void main(String[] args) {
       new Principal();
    }
    
}
