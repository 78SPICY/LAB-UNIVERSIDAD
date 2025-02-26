package fp.universidad.tipos;
import java.util.List;
import java.util.ArrayList;

public class Expediente {
	
	// Atributos
	private List<Nota> listaNotas;
	
	// Constructores
	public Expediente() {
		this.listaNotas = new ArrayList<>(); // El constructor está definido sin parámetros, el tipo se inicializa a partir de una lista vacía
	}
	
	// Método para obtener la nota media
	public double getNotaMedia() {
		int suma = 0;
		int contador = 0;
		for (Nota n : listaNotas) {
			if (n.valor() >= 5) {
				suma += n.valor();
				contador++;
			}
		}
		if (contador > 0) {
				return (double) suma/contador;
			} else {
				return 0.0;
			}
	}

	// Método para añadir nuevas notas
	public void nuevaNota(Nota a) {
		boolean encontrada = false;
		for (Nota n : listaNotas) {
			if (n.equals(a)) {
				listaNotas.remove(n);
				listaNotas.add(a);
				encontrada = true;
				break;
			}
			if (encontrada = false) {
				listaNotas.add(a);
			}
		}
	}
	
	// 3. Getters
	public List<Nota> getListaNotas() {
		return listaNotas;
	}
	
	// 4. Método toString()
	public String getExpediente() {
		return "[" + listaNotas + "]";
	}
	
	// 5. Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Expediente) {
			Expediente a = (Expediente)obj;
			if (a.listaNotas.size() == this.listaNotas.size()) { 
				for (int i = 0; i < a.listaNotas.size(); i++) {
					if (a.listaNotas.get(i).equals(this.listaNotas.get(i))) {
						res = true;
						break;
					}
				}
			}
		}
		return res;
	}
	
	
	
}

