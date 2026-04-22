/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadenotas;

import java.util.Scanner;

/**
 *
 * @author dti
 */
public class Sistemadenotas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
            double n1,n2,n3;
            String aprovacao;
            
            System.out.println("Digite a primeira nota: ");
            n1 = ler.nextDouble();
            System.out.println("Digite a segunda nota: ");
            n2 = ler.nextDouble();
            System.out.println("Digite a terceira nota: ");
            n3 = ler.nextDouble();
            
        aprovacao = CalcularMedia(n1,n2,n3);
        System.out.println("Voce esta: "+aprovacao);
        
    }
    //as funções precisam estar dentro de um classe para serem declaradas
    public static String CalcularMedia(double n1, double n2, double n3){
        double media = (n1+n2+n3)/3;
        if (media >= 7){
            return "Aprovado";
        }       
        
        else if(media >= 5){
            return "Recuperacao";
        }

        else {
        return "Reprovado";
        }
    }
}    
    
    
    

