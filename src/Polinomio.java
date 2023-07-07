
public class Polinomio {

	private int grado;
	private int[] factores;

	public Polinomio(int grado, int[] factores) {
		this.grado = grado;
		this.factores = factores;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int[] getFactores() {
		return factores;
	}

	public void setFactores(int[] factores) {
		this.factores = factores;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int x = this.grado;

		for (int i = 0; i < factores.length; i++) {
			if (factores[i] > 0 && i != 0) {
				sb.append("+");
			}
			sb.append(factores[i]);
			if(x==1) {
				sb.append("x");
			}else if(x!=0) {
				sb.append("x^" + x);
			}
			x--;
		}
		sb.append(" = 0");
		return sb.toString();
	}

	public double eval(double num) {
		double res = 0;
		int x = this.grado;
		for (int i = 0; i < factores.length; i++) {
			res = res + (factores[i] * Math.pow(num, x));
			System.out.println(res);
			x--;
		}
		return res;
	}
}
