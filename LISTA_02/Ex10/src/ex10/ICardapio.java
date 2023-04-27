/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ex10;

/**
 *
 * @author filipe
 */
public interface ICardapio {
            public abstract void exibirCardapio();
}

/*
String pratos[] = {"Spaghetti à Bolonhesa", "Lasanha de Queijo e Presunto", "Strogonoff de Frango", 
        "Frango à Parmegiana", "Hambúrguer Artesanal com Batatas Fritas"};
        
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
            } else if (escolha.equalsIgnoreCase("n")){
                System.out.println("Tudo bem.");
            } else {
                System.out.println("Escolha inválida.");
            }                
        }
*/