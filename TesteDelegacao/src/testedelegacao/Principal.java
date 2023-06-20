package testedelegacao;

//Uma classe implementa delega algumas funções para que outras classes implementem
//Com o polimorfismo, o objeto podera mudar de classe

public class Principal {
    public static class Fruta{
        @Override
        public String toString(){
            return "Fruta";
        }            
    }
    public static class FrutaVendas extends Fruta{
        @Override
        public String toString(){
            return "Fruta Vendas";
        }
    }
    public static class FrutaDeposito extends Fruta{
        @Override 
        public String toString(){
            return "Fruta Deposito";
        }
    }
    public static class FrutaDescarte extends Fruta{
        @Override
        public String toString(){
            return "Fruta Descarte";
        }
    }
    
    public static class Prateleira {
        private Fruta fruta;
        public Prateleira(Fruta fruta){
            setFruta(fruta);
        }
        public void setFruta(Fruta fruta){
            this.fruta = fruta;
        }
        public void alterarFruta(Fruta fruta){
            setFruta(fruta);
        }
        @Override
        public String toString(){
            return this.fruta + "";
        }
    }
    
    public Principal(){
        Prateleira p1 = new Prateleira(new Fruta());
        System.out.println(p1);
        p1.alterarFruta(new FrutaVendas());
        System.out.println(p1);
        p1.alterarFruta(new FrutaDeposito());
        System.out.println(p1);
        p1.alterarFruta(new FrutaDescarte());
        System.out.println(p1);
        p1.alterarFruta(new Fruta());
        System.out.println(p1);
    }
    
    public static void main(String[] args) {
        new Principal();
    }
    
}
