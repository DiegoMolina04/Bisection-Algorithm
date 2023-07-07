import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] fact;
		Polinomio pol;
		int grado = 0;
		String[] datos;
		String[] inter;
//		leer datos de entrada

		grado = Integer.parseInt(leerDato("Ingrese el grado del polinomio"));
		datos = leerDato(
				"Ingrese los factores del polinomio separados por un espacio \n (Ej. x^3-8x^2+3x+2 = 0    => ingresar 1 -8 3 2)")
						.split(" ");
		inter = leerDato("Ingrese el intervalo separado por un espacio").split(" ");

		fact = new int[grado + 1];
		for (int i = 0; i < datos.length; i++) {
			fact[i] = Integer.parseInt(datos[i]);
		}

		pol = new Polinomio(grado, fact);

		System.out.println("Polinomio: ");
		System.out.println(pol.toString());
		System.out.println("Intervalo: [ " + Integer.parseInt(inter[0]) + " , " + Integer.parseInt(inter[1]) + " ] ");
		System.out.println(
				"Raiz del polinomio " + calcularRaiz(pol, Integer.parseInt(inter[0]), Integer.parseInt(inter[1]),0));
	}

//	Calcular raiz de un polinomio

	public static double calcularRaiz(Polinomio pol, double a, double b, int count) {
		double fa = pol.eval(a);
		double fb = pol.eval(b);
		double m = (a + b) / 2;
		double sol = 0;
		int counter = count;

		if (fa * fb > 0) {
			System.out.println("la raiz no se encuentra en ese intervalo");
		} else {
			double fm = pol.eval(m);
			if (counter == 1000) {
				sol = m;
			} else {
				if (fm == 0) {
					sol = m;
				} else {
					if (fm * fa > 0) {
						counter++;
						sol = calcularRaiz(pol, m, b, counter);
					} else {
						counter++;
						sol = calcularRaiz(pol, a, m, counter);
					}
				}
			}
		}
		return sol;
	}

//	leer dato de entrada
	public static String leerDato(String text) {
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		return sc.nextLine();
	}
}
