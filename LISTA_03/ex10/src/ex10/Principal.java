package ex10;

/*------------------------
a) Equipe: Filipe Augusto Parreira 
b) Design Pattern: Adapter
---------------------------*/



import java.util.Scanner;

public class Principal {

    public interface IPrefeitura {

        public abstract boolean lerSaldo();

        public abstract boolean lerCracha();

        public abstract boolean prepararRefeicao();
    }

    public class Prefeitura implements IPrefeitura {

        @Override
        public boolean prepararRefeicao() {
            return true;
        }

        @Override
        public boolean lerSaldo() {
            boolean result = false;
            Scanner entrada = new Scanner(System.in);
            System.out.print("Ler saldo:");
            float valor = entrada.nextFloat();
            if (valor > 3.5) {
                result = true;
            }
            return result;
        }

        @Override
        public boolean lerCracha() {
            boolean result = false;
            Scanner entrada = new Scanner(System.in);
            System.out.print("Ler cracha:");
            boolean presente = entrada.nextBoolean();
            if (presente) {
                result = true;
            }
            return result;
        }
    }
    
    public class Visitante extends Prefeitura implements IPrefeitura{

        @Override 
        public boolean lerSaldo(){
            boolean result = false;
            Scanner entrada = new Scanner(System.in);
            System.out.print("Ler saldo:");
            float valor = entrada.nextFloat();
            if (valor > 8.5) {
                result = true;
            }
            return result;
        }
    }
    
    public void iniciar() {
        IPrefeitura RU = new Prefeitura();
        System.out.println("----" + RU.getClass().getSimpleName() + "----");
        
        boolean v1 = RU.prepararRefeicao();
        boolean v2 = RU.lerSaldo();
        boolean v3 = RU.lerCracha();
        if (v1 && v2 && v3) {
            System.out.println("Acesso autorizado.");
        } else {
            System.out.println("Acesso não-autorizado.");
        }

        System.out.println("\n----" + RU.getClass().getSimpleName() + "----");
        
        RU = new Visitante();
        v1 = RU.prepararRefeicao();
        v2 = RU.lerSaldo();
        v3 = RU.lerCracha();
        if (v1 && v2 && v3) {
            System.out.println("Acesso autorizado.");
        } else {
            System.out.println("Acesso não-autorizado.");
        }
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
}
