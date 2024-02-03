package giovanni;
import java.util.*;
public class Ejercicio2 {


	public static int cuentaDigitos(long numero, int n) {
		if (numero == 0) {
			return 0;
		} else {
			int digito = (int) (numero % 10);
			return (int) (Math.pow(digito, n) + cuentaDigitos(numero / 10, n));
		}
	}

	public static boolean esNarcisista(long numero) {
		int n = String.valueOf(numero).length();
		int sumaDigitos = cuentaDigitos(numero, n);
		return numero == sumaDigitos;
	}

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		long numero = 0;

		while (true) {

			System.out.println("Menú:");
			System.out.println("1. Comprobar número narcisista");
			System.out.println("2. Salir");
			System.out.print("Seleccione una opción: ");

			String entrada = sn.nextLine();

			try {
				int option = Integer.parseInt(entrada);

				switch (option) {
				case 1:
					System.out.println("Introduce un valor para comprobar si es narcisista o no.");

					long tempNumero = 0;
					boolean validInput = false;

					while (!validInput) {
						String input = sn.nextLine().replaceAll("\\s", "");

						try {
							tempNumero = Long.parseLong(input);

							if (tempNumero <= 0) {
								System.out.println("Error, dame un valor mayor que 0");
							} else {
								validInput = true;
							}
						} catch (NumberFormatException ex) {
							System.out.println("Error, ingresa un número válido.");


						}
					}

					numero = tempNumero;

					if (esNarcisista(numero)) {
						System.out.println("El número " + numero + " es narcisista");
					} else {
						System.out.println("El número " + numero + " no es narcisista");
					}
					break;

				case 2:
					System.out.println("Saliendo del programa. ¡Adios!");
					sn.close();
					return; 
				default:
					System.out.println("Opción inválida");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error, ingresa un número válido.");
				// Limpiar el buffer del scanner en caso de error
				//				sn.nextLine();
			}
		}
	}
}