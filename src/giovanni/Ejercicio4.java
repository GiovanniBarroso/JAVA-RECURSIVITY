package giovanni;
import java.util.*;
public class Ejercicio4 {

	public static int numeroTarot(int num) {
		if (num <= 9) {
			return num;
		}

		int suma = sumaDigitos(num);

		return numeroTarot(suma);
	}

	private static int sumaDigitos(int num) {
		if (num == 0) {
			return 0;
		}

		return num % 10 + sumaDigitos(num / 10);
	}
	private static int diasEnMes(int mes, int anio) {
		switch (mes) {
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			return esBisiesto(anio) ? 29 : 28;
		default:
			return 31;
		}
	}

	private static boolean esBisiesto(int anio) {
		return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
	}



	public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int dia = 0, mes = 0, anio = 0;
        String fecha, partesFecha, fecha1;

        while (!salir) {
            System.out.println("Menu");
            System.out.println("1. Calcular número del tarot.");
            System.out.println("-1 Salir del programa.");
            System.out.println("Elige una opción:");

            if (sn.hasNextInt()) {
                int option = sn.nextInt();
                sn.nextLine(); // Consumir la nueva línea pendiente después de leer el entero

                switch (option) {
                    case 1:
                        try {
                            System.out.println("Introduce una fecha de nacimiento (dd mm aaaa) para calcular su número del tarot:");
                            fecha = sn.nextLine();
                            fecha1 = fecha.replace(" ", "");
                            partesFecha = fecha1.replace("/", "");

                            if (partesFecha.length() == 8) {
                                String dia1 = partesFecha.substring(0, 2);
                                String mes1 = partesFecha.substring(2, 4);
                                String anio1 = partesFecha.substring(4, 8);

                                dia = Integer.parseInt(dia1);
                                mes = Integer.parseInt(mes1);
                                anio = Integer.parseInt(anio1);

                                if (dia >= 1 && mes >= 1 && mes <= 12 && anio >= 1 && anio <= 2023 && dia <= diasEnMes(mes, anio)) {
                                    int numTarot = numeroTarot(dia + mes + anio);
                                    System.out.println("El número de tarot de la fecha " + fecha + " es: " + numTarot);
                                } else {
                                    System.out.println("Error, la fecha no es válida.");
                                }
                            } else {
                                System.out.println("Error, formato de fecha incorrecto.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error, introduce una fecha válida.");
                        }
                        break;
                    case -1:
                        System.out.println("Saliendo del programa. ¡Gracias!");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida, introduce 1 para calcular o -1 para salir.");
                        break;
                }
            } else {
                System.out.println("Error, introduce una opción válida.");
                sn.next(); // Consumir la entrada no válida para evitar un bucle infinito
            }
        }
        sn.close();
    }
}