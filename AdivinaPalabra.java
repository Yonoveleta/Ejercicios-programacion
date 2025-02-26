package ejercicios;

import java.util.Random;
import java.util.Scanner;

public class AdivinaPalabra {
	
	// array con las palabras que pueden tocar para ser adivinadas
	public static final String[] PALABRAS = {
			"ejemplar",
			"amistoso",
			"brillante",
			"fortaleza",
			"mariposas",
			"felicidad",
			"descubrir",
			"naturales",
			"sindrome"
	}; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		// escoger aleatoriamente una palabra del array de palabras
		String palabra = PALABRAS[rd.nextInt(PALABRAS.length)];
		
		// array para indicar que letras de la palabra han sido adivinadas(true) o no(false)
		boolean[] adivinadas = new boolean[palabra.length()];
		
		// numero de intentos del usuario
		int intentos = 10;
		
		// mientas el numero de intentos sea mayor que 0 (queda algun intento)
		// y la palabra no a sido adivinada 
		while(intentos > 0 && !adivinada(adivinadas)) {
			// mostrar el numero de intentos restantes
			System.out.printf("\nIntentos: %d\n", intentos);
			
			// mostrar la palabra (se muestran las letras adivinadas y las que no se muestra '-')
			mostrar(palabra, adivinadas);
			
			// pedir al usuario una letra
			System.out.print("Introduce una letra: ");
			
			// se guarda la letra que mete el usuario en esta variable
			// se usa toLowerCase por si acaso el usuario usa mayusculas
			// y charAt(0) porque sc.next() devuelve un string y necesitamos un char
			char letra = sc.next().toLowerCase().charAt(0);
			
			// comprobar si alguna letra de la palabra coincide con la que ha metido el usuario
			// y si es asi poner la posicion de esa letra a 'true' en el array de letras adivinadas
 			comprobar(letra, palabra, adivinadas);
 			
 			// se resta un intento
			intentos--;
		}
		
		// comprobamos si la palabra ha sido adivinada o no y en funcion de ello devolvemos un mensaje
		String result = adivinada(adivinadas) ? 
				"Enhorabuena, has adivinado la palabra %s" : 
				"Vaya, otra vez será\nLa palabra era %s";
		
		System.out.println(String.format(result, palabra));
		
		// cerramos el scanner
		sc.close();
	}
	/**
	 * Muestra las letras de la palabra a adivinar que han sido adivinadas y muestra guiones('-')
	 * para las que aun no han sido adivinadas 
	 * 
	 * @param palabra 		la palabra que el usuario tiene que adivinar
	 * @param adivinadas	el array que tiene la informacion sobre que letras han sido adivinadas
	 */
	private static void mostrar(String palabra, boolean[] adivinadas) {
		String linea = "";
		for(int i = 0; i < adivinadas.length; i++) {
			linea += adivinadas[i] ? palabra.charAt(i) : '-';
		}
		System.out.println(linea);
	}
	
	/**
	 * Comprueba si <i>letra</i> esta en alguna posicion de la palabra y indica en el array de letras adivinadas
	 * estas posiciones, pasando de <i>false</i> a <i>true</i> 
	 * 
	 * 
	 * @param letra			la letra que se debe comprobar
	 * @param palabra		la palabra que el usuario tiene que adivinar
	 * @param adivinadas	el array que tiene la informacion sobre que letras han sido adivinadas	
	 */
	private static void comprobar(char letra, String palabra, boolean[] adivinadas) {
		for(int i = 0; i < adivinadas.length; i++) {
			if(palabra.charAt(i) == letra) {
				if(!adivinadas[i]) adivinadas[i] = true; 
			}
		}
	}
	
	/**
	 * Comprueba si todas las letras de la palabra han sido adivinadas o no
	 * 
	 * @param adivinadas	el array que tiene la informacion sobre que letras han sido adivinadas	
	 * @return true si todas las letras han sido adivinadas(y por tanto la palabra), o false si aun quedan letras por adivinar
	 */
	private static boolean adivinada(boolean[] adivinadas) {
		for(boolean adivinada : adivinadas) {
			if(!adivinada) return false;
		}
		
		return true;
	}

}
