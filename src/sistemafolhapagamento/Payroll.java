package sistemafolhapagamento;

import java.util.Scanner;

public class Payroll {
    
    public static double calcularINSS(double SB){
        
        double desc=0;
        int faixa;
        
        if(SB<=1621)faixa=1;
        else if(SB<=2902.84)faixa=2;
            else if(SB <= 4354.27)faixa=3;
            else if (SB <=8157.41)faixa=4;
            else faixa=5;
        switch (faixa) {
            case 1:
                desc = SB*0.075;
                
                break;
                
            case 2:
                desc = 121.57+(SB-1621)*0.09;
                
                break;
                
            case 3:
                desc = 121.57+115.36+(SB-2902.84)*0.12;
                
                break;
                
            case 4:
                desc = 121.57+115.36+174.17+(SB-4354.27)*0.14;
                
                break;
                
            case 5:
                desc = 988.07;
                break;
        }

     return desc;   
    }
    
    public static double calculaIR(double valorBase){
        if(valorBase< 2259) return 0;
        return (valorBase*0.075);
    }
    
    public static double calcularSL(double SB){
        double desc_inss,ir;
        desc_inss = calcularINSS(SB);
        ir = calculaIR(SB - desc_inss);
        return SB - desc_inss - ir;
    }

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        double salariob;
        
        System.out.println("Digite seu salario em R$: ");
        salariob = ler.nextDouble();
        
        System.out.printf("Seu salario liquido equivale a: %.2f%n", calcularSL(salariob));
        
    }
}
