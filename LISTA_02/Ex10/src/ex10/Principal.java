package ex10;
/*------------------------
a) Equipe: Filipe Augusto Parreira Almeida
b) A entrada está correta.
c) Nova interface: ICardapio
 Pergunta ao usuario se deseja ver o cardápio, caso sim, exibe com cardápio com os pratos
      
d) Entrada:
   10
   20
   1
   1
   5 
   10
   9
   s

   Saída:
   Saldo insuficiente
   Todas as mesas estao ocupadas
   A avaliacao do restaurante e: 5.0
   Desconto aplicado com sucesso o valor a ser pago agora eh de: 1.0
   Cardápio: 
	1- Spaghetti à Bolonhesa
	2- Lasanha de Queijo e Presunto
	3- Strogonoff de Frango
	4- Frango à Parmegiana
	5- Hambúrguer Artesanal com Batatas Fritas
---------------------------*/



import java.util.Scanner;

public class Principal {

	public interface IRestaurante {

    	public abstract void lerSaldo();
	}

	public interface IPagamento {

    	public abstract void pagamento();
	}

	public interface ILotacao {

    	public abstract void lotacao();
	}

	public interface IAvaliacao {

    	public abstract void receberAvaliacao();
	}
        public interface IDesconto{
            
        public abstract void aplicarDesconto();
        }
        
        public interface ICardapio {
            public abstract void exibirCardapio();
        }

	public class Restaurante implements IRestaurante, IPagamento, ILotacao, IAvaliacao, IDesconto, ICardapio {

    	Scanner entrada = new Scanner(System.in);
    	float valor;
    	int mesas;
    	float avaliacao;
        String pratos[] = {"Spaghetti à Bolonhesa", "Lasanha de Queijo e Presunto", "Strogonoff de Frango", 
        "Frango à Parmegiana", "Hambúrguer Artesanal com Batatas Fritas"};

    	public void lerSaldo() {
        	System.out.print("Ler saldo:");
        	valor = entrada.nextFloat();
    	}

    	public void pagamento() {
        	System.out.print("Digite o valor a ser pago: ");
        	float pagamento = entrada.nextFloat();
        	if (getValor() - pagamento < 0) {
            	System.out.println("Saldo insuficiente");
        	} else {
            	setValor(getValor() - pagamento);
            	System.out.println("Pagamento feito com sucesso, seu saldo agora e: " + getValor());
        	}

    	}

    	public float getValor() {
        	return this.valor;
    	}

    	public void setValor(float valor) {
        	this.valor = valor;
    	}

    	public void lotacao() {
        	System.out.print("Digite a quatidade total de mesas do seu restauarante: ");
        	mesas = entrada.nextInt();
        	if (mesas <= 0) {
            	System.out.println("Valor invalido");
            	System.out.print("Digite novamente a quatidade total de mesas do seu restauarante: ");
            	mesas = entrada.nextInt();
        	}

        	System.out.print("Digite a quatidade de mesas ocupadas: ");
        	int ocupadas = entrada.nextInt();
        	if (ocupadas <= 0) {
            	System.out.println("Valor invalido");
            	System.out.print("Digite novamente a quatidade de mesas ocupadas: ");
            	ocupadas = entrada.nextInt();
        	}

        	if (getMesas() == ocupadas || ocupadas > getMesas()) {
            	System.out.println("Todas as mesas estao ocupadas");
        	} else {
            	setMesas(getMesas() - ocupadas);
            	System.out.println("A quantidade de mesas disponiveis e: " + getMesas());
        	}

    	}

    	public int getMesas() {
        	return this.mesas;
    	}

    	public void setMesas(int mesas) {
        	this.mesas = mesas;
    	}

    	public void receberAvaliacao() {
        	System.out.print("Digite a avaliacao do restaurante (de 1 a 5): ");
        	float avaliacao = entrada.nextFloat();
        	if (avaliacao < 1 || avaliacao > 5) {
            	System.out.println("Valor invalido");
            	System.out.print("Digite a avaliacao do restaurante (de 1 a 5): ");
            	avaliacao = entrada.nextFloat();
        	}
        	setAvaliacao(avaliacao);
        	System.out.println("A avaliacao do restaurante e: " + getAvaliacao());
    	}

    	public float getAvaliacao() {
        	return this.avaliacao;
    	}

    	public void setAvaliacao(float avaliacao) {
        	this.avaliacao = avaliacao;
    	}

        public void aplicarDesconto(){
        System.out.print("Digite o valor a ser pago: ");
        setValor(entrada.nextFloat());
        System.out.print("Digite o valor do desconto: ");
        float desconto = entrada.nextFloat();

        if (desconto < 0 || desconto > getValor()) {
                  System.out.println("Valor invalido");
                  System.out.print("Digite novamente o valor do desconto a ser aplicado: ");
                  desconto = entrada.nextFloat();
              }
              setValor(getValor() - desconto);
              System.out.println("Desconto aplicado com sucesso o valor a ser pago agora eh de: " + getValor());

        }
        
        public void exibirCardapio(){
            System.out.print("Deseja ver o cardápio? [s/n] ");
            String escolha = entrada.next();
            if (escolha.equalsIgnoreCase("s")){
                int count = 1;
                System.out.println("\nCardápio: ");
                for (String prato : pratos){
                    System.out.println("\t" + count + "- " + prato);
                    count++;
                }
                System.out.println("");
            } else if (escolha.equalsIgnoreCase("n")){
                System.out.println("Tudo bem.");
            } else {
                System.out.println("Escolha inválida.");
            }                
        }

	}//restaurante

	public void iniciar() {

    	Restaurante RU = new Restaurante();
    	RU.lerSaldo();
    	RU.pagamento();
    	RU.lotacao();
    	RU.receberAvaliacao();
        RU.aplicarDesconto();
        RU.exibirCardapio();
	}

	public static void main(String[] args) {
    	Principal p = new Principal();
    	p.iniciar();
	}
}
 