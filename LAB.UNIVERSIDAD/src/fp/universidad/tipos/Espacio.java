package fp.universidad.tipos;
import java.util.Objects;

	// 1. Atributos
	public class Espacio implements Comparable<Espacio> {
		private TipoEspacio tipoEspacio;
		private String nombre;
		private Integer capacidad;
		private Planta planta;
		
	
	// 2. Constructores
	public Espacio(TipoEspacio tipoEspacio, String nombre, Integer capacidad, Planta planta) {
		this.tipoEspacio = tipoEspacio;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
		
		// Restricciones
			if (capacidad < 0) {
				throw new IllegalArgumentException("Un espacio no puede poseer una capacidad negativa. Introduzca uno nuevo");
		}
	}
	
	// 3. Getters
	public TipoEspacio getTipoEspacio() {
		return tipoEspacio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}
	
	public Planta getPlanta() {
		return planta;
	}
	
	// 4. Setters
	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	// 5. Método toString()
	public String toString() {
		return nombre + " (planta " + planta.getPlanta() + ")";
	}
	
	// 6. Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Espacio) {
			Espacio a = (Espacio)obj;
			res = this.getNombre().equals(a.getNombre()) && this.getPlanta().equals(a.getPlanta());
		}
		return res;
	}
	
	// 7. Método hashCode()
	public int hashCode() {
		return Objects.hash(nombre, planta);
	}
	
	// 8. Método toCompare()
	public int compareTo(Espacio a) {
		int res = this.planta.compareTo(a.planta);
		if (res == 0) {
			res = this.nombre.compareTo(a.nombre);
		}
		return res;
	}
} 