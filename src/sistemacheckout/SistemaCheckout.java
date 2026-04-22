package sistemacheckout;

import java.util.Scanner;


public class SistemaCheckout {

    public static void main(String[] args) {

 Scanner leitor = new Scanner(System.in); //entrada
 //apresentação
 System.out.println("--- SISTEMA DE CHECKOUT V1.0 ---");
 //valor inteiro
 System.out.print("Valor dos produtos: ");
 double valorBruto = leitor.nextDouble();
 //leitura do cupom
 System.out.print("Cupom de desconto: ");
 String cupom = leitor.next();
//chamada das funções
 double porcentagem = validarCupom(cupom);// 1. Chamar validarCupom
 double desconto = calcularDesconto(valorBruto,porcentagem);// 2. Chamar calcularDesconto
 double frete = verificarFreteGratis(valorBruto - desconto);// 3. Chamar verificarFreteGratis
 //fixme
 exibirResumo(valorBruto,(int) porcentagem, desconto, frete);// 4. Chamar exibirResumo
 }
 // TODO: Implementar as funções aqui embaixo (fora do main)
//o valor que vai descontar
 public static double calcularDesconto(double total, double porcentagem) {
 return total * (porcentagem / 100);
 }
 // ... implementar as demais ...
public static double validarCupom(String cupom){ //validação de cupom
//se o cupom existe vai validar, se não vai o valor direto
    if (cupom.equals("PROMO10")) {
        return 10.0;
    }else if (cupom.equals("PROMO20")){
        return 20.0;
    }else {
        return 0;
    }

}
public static double verificarFreteGratis(double total){ //verifica se vai ter frete ou não
        //se a compra for mais de 200 não tem frete, caso contrário, 15 R$
        if (total > 200){
           return 0;
        }else{
            return 15;
        }
}
public static void exibirResumo(double vb,int porcentagem,double da,double frete){
        //resumo de tudo, o recibo
    System.out.println("\n--- RESUMO DA COMPRA ---");
    System.out.printf("Valor Bruto: R$ %.2f%n", vb);
    System.out.printf("Desconto aplicado (%d%%): R$ %.2f%n",porcentagem,da);
    if (frete == 0){
        System.out.printf("Frete: R$ %.2f (Grátis acima de 200)%n",frete);
    }else {
        System.out.printf("Frete: R$ %.2f%n",frete);
    }
    System.out.println("---------------------------------");
    double total = vb - da + frete;
    System.out.printf("VALOR TOTAL A PAGAR: R$ %.2f",total);
}

}



