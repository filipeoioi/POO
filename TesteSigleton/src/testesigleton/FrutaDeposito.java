package testesigleton;

public class FrutaDeposito implements IFrutas{
    private static final FrutaDeposito fruta  = new FrutaDeposito();
    private FrutaDeposito(){
        super();
    }
    public static FrutaDeposito getFruta(){
        return fruta;
    }
    
    @Override
    public String toString(){
        return "Fruta Deposito";
    }
    
    @Override
    public int operacao1() {
        return 222;
    }
    
}
