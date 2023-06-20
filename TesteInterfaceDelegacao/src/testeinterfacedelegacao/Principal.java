package testeinterfacedelegacao;

public class Principal {
    
    public interface IFrutas{
        public abstract String nome();
    }
    public static class FrutaVendas implements IFrutas{
        @Override
        public String nome() {
            return "Fruta Venda" + "";
        }
    }
    public static class FrutaDeposito implements IFrutas{
        @Override
        public String nome() {
            return "Fruta Deposito" + "";
        }
    }
    public static class FrutaDescarte implements IFrutas{
        @Override
        public String nome() {
            return "Fruta Descarte" + "";
        }
    }
    public static class Prateleira{
        private IFrutas iFrutas;
        public Prateleira(IFrutas fruta){
            setFruta(fruta);
        }
        public void setFruta(IFrutas fruta){
            this.iFrutas = fruta;
        }
        public void alternarFruta(IFrutas fruta){
            setFruta(fruta);
        }
        @Override
        public String toString(){
            return this.iFrutas.nome() + "";
        }
    }
    
    public Principal(){
        Prateleira prateleira = new Prateleira(new FrutaDeposito());
        System.out.println(prateleira);
        prateleira.alternarFruta(new FrutaVendas());
        System.out.println(prateleira);
        prateleira.alternarFruta(new FrutaDescarte());
        System.out.println(prateleira);
    }
    public static void main(String[] args) {
        new Principal();
    }
    
}
