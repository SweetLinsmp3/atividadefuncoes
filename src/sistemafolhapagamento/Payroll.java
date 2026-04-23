package sistemafolhapagamento;

import java.util.Scanner;

public class Payroll {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("--- DEPARTAMENTO PESSOAL ---");
        System.out.print("Informe o salário bruto: R$ ");
        double salarioBruto = input.nextDouble();

        double valorINSS = calcularINSS(salarioBruto);
        double baseIR = salarioBruto - valorINSS;
        double valorIR = calcularImpostoRenda(baseIR);
        double salarioLiquido = calcularSalarioLiquido(salarioBruto, valorINSS, valorIR);

        imprimirHolerite(salarioBruto, valorINSS, valorIR, salarioLiquido);

        input.close();
    }

    public static double calcularINSS(double salario) {
        if (salario <= 1500) {
            return salario * 0.08;
        } else if (salario <= 3000) {
            return salario * 0.09;
        } else {
            return salario * 0.11;
        }
    }

    public static double calcularImpostoRenda(double base) {
        if (base < 2259) {
            return 0.0;
        } else {
            return base * 0.075;
        }
    }

    public static double calcularSalarioLiquido(double bruto, double inss, double ir) {
        return bruto - inss - ir;
    }

    public static void imprimirHolerite(double bruto, double inss, double ir, double liquido) {
        System.out.println("HOLERITE");
        System.out.printf("Salário Bruto: R$ %.2f%n", bruto);
        System.out.printf("Desconto INSS: R$ %.2f%n", inss);
        System.out.printf("Desconto IR:   R$ %.2f%n", ir);
        System.out.println("____");
        System.out.printf("Salário Líquido: R$ %.2f%n", liquido);
    }
}
