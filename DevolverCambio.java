package ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class DevolverCambio {
	
	private static int[] BILLETES = {
		100, 50, 20, 10, 5	
	};
	
	private static double[] MONEDAS = {
		2, 1, 0.5, 0.20, 0.10, 0.05, 0.01
	};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Pedir el total de la compra
		System.out.print("Total compra: ");
		double total = sc.nextDouble();
		
		// Pedir el dinero que ha sido entregado
		System.out.print("Cantidad entregada: ");
		double entregado = sc.nextDouble();
		
		// Calcular el cambio(llamado restante)
		// Convertir el cambio en BigDecimal por motivos de precision decimal
		BigDecimal restante = BigDecimal.valueOf(entregado - total);
		// Especificar redondeo a 2 decimales
		restante = restante.setScale(2, RoundingMode.HALF_EVEN);
		
		System.out.printf("Cambio a devolver: %.2f\n", restante);
		
		// Recorrer el array de billetes
		for(int i = 0; i < BILLETES.length; i++) {
			int cantidad = 0; // cantidad del billete actual 
			
			// Mientras el cambio restante sea mayor que el valor del billete actual
			while(restante.intValue() >= BILLETES[i]) {
				cantidad++; 
				restante = restante.subtract(BigDecimal.valueOf(BILLETES[i]));
			}
			
			if(cantidad > 0) {
				System.out.printf("%d billete(s) de %d€\n", cantidad, BILLETES[i]);
			}
		}
		
		// Recorrer el array de Monedas
		for(int i = 0; i < MONEDAS.length; i++) {
			int cantidad = 0; // cantidad de la moneda actual
			
			// Mientras el cambio restante sea mayor que el valor de la moneda actual
			while(restante.doubleValue() >= MONEDAS[i]) {
				cantidad++;
				restante = restante.subtract(BigDecimal.valueOf(MONEDAS[i]));
			}
			
			if(cantidad > 0) {
				System.out.printf("%d monedas(s) de %.2f€\n", cantidad, MONEDAS[i]);
			}	
		}
		
		sc.close();
		
	}

}