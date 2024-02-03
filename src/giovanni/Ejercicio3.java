package giovanni;
import java.util.*;
public class Ejercicio3 {

	public static String invertirCadena(String cadena) {
		if (cadena.isEmpty()) {
			return cadena;
		}
		return invertirCadena(cadena.substring(1)) + cadena.charAt(0);
	}

	public static String convertirBinario(int numDecimal) {
		if (numDecimal <= 1) {
			return String.valueOf(numDecimal);
		}
		return convertirBinario(numDecimal / 2) + numDecimal % 2;
	}

	private static boolean esPerfecto(long numero) {
		int sumaDivisores = 0;
		for (int i = 1; i <= numero / 2; i++) {
			if (numero % i == 0) {
				sumaDivisores += i;
			}
		}
		return sumaDivisores == numero;
	}

	public static long elegante(long numero) {
		if (numero == 1 || numero == 4) {
			return numero;
		} else if (numero == 0) {
			return 0;
		} else {
			numero = separar(numero);
			long resultado = elegante(numero);
			return resultado;
		}
	}

	public static long separar(long numero) {
		long sumaCuadrados = 0;
		if (numero < 10) {
			sumaCuadrados += numero * numero;
			return sumaCuadrados;
		}
		long digito = numero % 10;
		numero /= 10;
		long digitoElevado = digito * digito;
		sumaCuadrados = digitoElevado + separar(numero);
		return sumaCuadrados;
	}

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		boolean salir = false;

		long resultado = 0;
		long numero = 0;

		while (!salir) {
			try {
				System.out.println("Menú de Opciones:");
				System.out.println("1. Invertir una cadena de texto");
				System.out.println("2. Convertir un número decimal a binario");
				System.out.println("3. Verificar si un número es perfecto y/o elegante");
				System.out.println("4. Salir");
				System.out.print("Ingrese el número de la opción deseada: ");

				int opcion = sn.nextInt();
				sn.nextLine(); // Limpiar el buffer de entrada

				switch (opcion) {
				case 1:

					System.out.print("Ingrese una cadena de texto: ");
					String cadena = sn.nextLine();
					String cadenaInvertida = invertirCadena(cadena);
					System.out.println("Cadena invertida: " + cadenaInvertida);
					break;

				case 2:
					try {
						System.out.print("Ingresa un número decimal: ");
						String entrada = sn.nextLine().replaceAll("\\s", "");
						int numDecimal = Integer.parseInt(entrada);
						String binario = convertirBinario(numDecimal);
						System.out.println("Número en binario: " + binario);
					} catch (NumberFormatException e) {
						System.out.println("Error, introduce un valor numérico válido.");
					}
					break;

				case 3:
					System.out.print("Ingrese un número para verificar si es perfecto y/o elegante: ");
					try {
						numero = Long.parseLong(sn.nextLine());
						if (numero < 0) {
							System.out.println("Error, ingresa un valor no negativo.");
						} else {
							if (esPerfecto(numero)) {
								System.out.println(numero + " es un número perfecto.");
							} else {
								System.out.println(numero + " no es un número perfecto.");
							}

							resultado = elegante(numero);

							if (resultado == 1) {
								System.out.println("El número " + numero + " es elegante");
							} else if (resultado == 0) {
								System.out.println("Error, el número 0 es un valor inválido");
							} else if (resultado == 4) {
								System.out.println("El número " + numero + " no es elegante");
							}
						}
					} catch (NumberFormatException e) {
						System.out.println("Error, introduce un valor numérico válido.");
					}
					break;
				case 4:
					System.out.println("Saliendo del programa.");
					salir = true;
					break;
				default:
					System.out.println("Opción no válida. Por favor, elija una opción válida.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Error, introduce un valor numérico válido.");
				sn.next(); // Limpiar el buffer de entrada
			}
		}
		sn.close();
	}
}