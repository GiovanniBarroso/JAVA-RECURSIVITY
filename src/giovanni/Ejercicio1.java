package giovanni;
import java.util.*;
public class Ejercicio1 {


	public static long Elegante(long numero) {
		if (numero == 1 || numero == 4) {
			return numero;
		} else if (numero == 0) {
			return 0;
		} else {
			numero = Separar(numero);
			long resultado = Elegante(numero);
			return resultado;
		}
	}

	public static long Separar(long numero) {
		long sumaCuadrados = 0;
		if (numero < 10) {
			sumaCuadrados += numero * numero;
			return sumaCuadrados;
		}
		long digito = numero % 10;
		numero /= 10;
		long digitoelevado = digito * digito;
		sumaCuadrados = digitoelevado + Separar(numero);
		return sumaCuadrados;
	}

	public static void main(String[] Args) {
		Scanner sn = new Scanner(System.in);
		long numero = 0;
		long resultado = 0;

		do {
			try {
				System.out.println("Introduce un número para calcular si es elegante o no");
				String entrada = sn.nextLine();
				entrada = entrada.replaceAll("\\s", "");
				numero = Long.parseLong(entrada);

				if (numero >= 0) {
					resultado = Elegante(numero);

					if (resultado == 1) {
						System.out.println("El número " + numero + " es elegante");

					} else if (resultado == 0) {
						System.out.println("Error, el número 0 es un valor inválido");

					} else if (resultado == 4) {
						System.out.println("El número " + numero + " no es elegante");

					}
				} else {
					System.out.println("Error, ingresa un valor no negativo.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error, introduce un valor numérico.");
			}
		} while (resultado == 0);

		sn.close();
	}
}