package aplicação;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double salarioLiquido;
		
		System.out.println("--------------Calculando imposto de renda--------------");
		System.out.println();
		
		System.out.print("Informe o seu salário Bruto: R$ ");
		double salarioBruto = sc.nextDouble();
		System.out.print("Informe a quantidade de dependentes: ");
		int numDependentes = sc.nextInt();
		
		
		double inss = 0.0;
		if(salarioBruto <= 1045.00) {
			 inss =  salarioBruto * 0.075;
		}
		else if(salarioBruto > 1045.00 && salarioBruto <= 2089.60) {
			 inss = 1045.00 * 0.075 + (salarioBruto - 1045.01) * 0.09;
		}
		else if(salarioBruto > 2089.60 && salarioBruto <= 3134.40) {
			 inss = 1045.00 * 0.075 + (2089.60 - 1045.01) * 0.09 + (salarioBruto - 2089.61) *0.12;
		}
		else if(salarioBruto > 3134.40 && salarioBruto <= 6101.06) {
			 inss = 1045.00 * 0.075 + (2089.60 - 1045.01) * 0.09 + (3134.40 - 2089.61) *0.12 + (salarioBruto - 3134.41) * 0.14;
		}
		else{
			 inss = 1045.00 * 0.075 + (2089.60 - 1045.01) * 0.09 + (3134.40 - 2089.61) *0.12 + (6101.06 - 3134.41) * 0.14;
		}

		double baseCalculo = salarioBruto - inss - (numDependentes * 189.59); 
		
		
		double impostoRenda = 0.0;
		if(baseCalculo > 1903.98 && baseCalculo <= 2826.65) {
			impostoRenda =  baseCalculo * 0.075;
		}
		else if(baseCalculo > 2826.65 && baseCalculo <= 3751.05) {
			impostoRenda = baseCalculo * 0.15;
		}
		else if(baseCalculo > 3751.05 && baseCalculo <= 4664.68) {
			impostoRenda = baseCalculo * 0.225;
		}
		else {
			impostoRenda = baseCalculo * 0.27;
		}
		
		System.out.println("Desconto do Inss: R$ " + String.format("%.2f", inss));
		if(baseCalculo > 1903.98) {
			System.out.println("Desconto do imposto de renda: R$ " + String.format("%.2f", impostoRenda));
		}
		
		salarioLiquido = salarioBruto - inss;
		if(baseCalculo > 1903.98) {
			salarioLiquido -= impostoRenda;
		}
		System.out.println();
		System.out.println("Salario líquido: R$ " + String.format("%.2f", salarioLiquido));
		
		
		sc.close();
	}

}
