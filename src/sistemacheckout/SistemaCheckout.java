package sistemacheckout;

import java.util.Scanner;


public class SistemaCheckout {

    public static void main(String[] args) {
//entrada
 Scanner leitor = new Scanner(System.in);

 //apresentação
 System.out.println("--- SISTEMA DE CHECKOUT V1.0 ---");

 //leitura do valor inicial
 System.out.print("Valor dos produtos: ");
 double valorBruto = leitor.nextDouble();

 //leitura do cupom
 System.out.print("Cupom de desconto: ");
 String cupom = leitor.next();

//chamada das funções
 double porcentagem = validarCupom(cupom);// 1. Chamar validarCupom
 double desconto = calcularDesconto(valorBruto,porcentagem);// 2. Chamar calcularDesconto
 double frete = verificarFreteGratis(valorBruto - desconto);// 3. Chamar verificarFreteGratis
 exibirResumo(valorBruto,(int) porcentagem, desconto, frete);// 4. Chamar exibirResumo
 }

 // TODO: Implementar as funções aqui embaixo (fora do main)

//o valor que vai descontar
 public static double calcularDesconto(double total, double porcentagem) {
 return total * (porcentagem / 100);
 }
 // ... implementar as demais ...

//validação de cupom
public static double validarCupom(String cupom){

//se o cupom existe vai validar, se não vai o valor direto
    if (cupom.equals("PROMO10")) {
        return 10.0;
    }else if (cupom.equals("PROMO20")){
        return 20.0;
    }else {
        return 0;
    }

}

//verifica se vai ter frete ou não
public static double verificarFreteGratis(double total){

//se a compra for mais de 200 não tem frete, caso contrário, 15 R$
        if (total > 200){
           return 0;
        }else{
            return 15;
        }
}
public static void exibirResumo(double valorBruto,int porcentagem,double descontoAplicado,double frete){

//resumo de tudo, o recibo

    //apresentação
    System.out.println("\n--- RESUMO DA COMPRA ---");

    //valor bruto com duas casas decimais e pulando linha
    System.out.printf("Valor Bruto: R$ %.2f%n", valorBruto);

    //mostra quanto de desconto foi aplicado e o valor com ele inserido
    System.out.printf("Desconto aplicado (%d%%): R$ %.2f%n",porcentagem,descontoAplicado);

    //se o frete for 0, avisar que o frete é grátis acima de 200
    if (frete == 0){
        System.out.printf("Frete: R$ %.2f (Grátis acima de R$ 200)%n",frete);
    }else {
        System.out.printf("Frete: R$ %.2f%n",frete);
    }

    //apresentação
    System.out.println("---------------------------------");

    //mostrando o valor final
    double total = valorBruto - descontoAplicado + frete;
    System.out.printf("VALOR TOTAL A PAGAR: R$ %.2f",total);
}

}



