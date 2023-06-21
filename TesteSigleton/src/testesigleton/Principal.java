package testesigleton;

public class Principal {
    
    public static class Prateleira{
        private IFrutas fruta;
        public Prateleira(){
            setFruta(fruta);
        }
        private void setFruta(IFrutas fruta){
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
    
    public static void main(String[] args) {
        FrutaDeposito f1 = FrutaDeposito.getFruta();
        System.out.println(f1.g);
    }
    
}
