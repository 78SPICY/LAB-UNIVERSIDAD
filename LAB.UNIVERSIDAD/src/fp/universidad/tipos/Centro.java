package fp.universidad.tipos;
import java.util.Set;

public class Centro implements Comparable<Centro> {
	
	// 1. Atributos
	private String nombre;
	private String direccion;
	private Integer cantidadPlantas;
	private Integer cantidadSotanos;
	private Set<Espacio> conjuntoEspacios;
	
	// 2. Constructor
	public Centro(String nombre, String direccion, Integer cantidadPlantas, Integer cantidadSotanos, Set<Espacio> conjuntoEspacios) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cantidadPlantas = cantidadPlantas;
		this.cantidadSotanos = cantidadSotanos;
		this.conjuntoEspacios = conjuntoEspacios;
		
		// Restricciones
		if (cantidadPlantas == 0 || cantidadPlantas < 0) {
			throw new IllegalArgumentException("Un centro debe de tener al menos una planta. Introduzca una planta.");
		}
		if (cantidadSotanos < 0) {
			throw new IllegalArgumentException("No se puede tener una cantidad negativa de sótanos. Introduzca una cantidad correcta");
		}
	}

	// Método para añadir nuevos espacios
	public void nuevoEspacio(Espacio e) {
		if (e.getPlanta().planta() < (cantidadSotanos*(-1)) && e.getPlanta().planta() > (cantidadPlantas - 1)) {
			throw new IllegalArgumentException("La planta no está en el intervalo " + "[" + cantidadPlantas + ", " +cantidadSotanos + "]");
		} else {
			conjuntoEspacios.add(e);
		}
	}
	
	// Método para eliminar espacios
	public void eliminarEspacio(Espacio e) {
		conjuntoEspacios.remove(e);
	}
	
		
	// 3. Getters
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public Integer getCantidadPlantas() {
		return cantidadPlantas;
	}
	
	public Integer getCantidadSotanos() {
		return cantidadSotanos;
	}
	
	
	// 4. Método toString()
	public String toString() {
		return nombre;
	}
	
	
	// 5. Método equals(){
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Centro) {
			Centro a = (Centro)obj;
			res = this.nombre.equals(a.nombre);
		}
	return res;
	}
	
	
	// 6. Método hashCode(){
	public int hashCode() {
		return nombre.hashCode();
	}
	
	
	// 7. Método compareTo(){
	public int compareTo(Centro a) {
		return nombre.compareTo(a.nombre);
	}
	
	
	// 8. Operaciones
	public Integer[] getConteoEspacios() {
		return null;
	}
	
	public String getDespachos() {
		return null;
	}
	
	public String getProfesores() {
		return null;
	}
	
	public Espacio getEspacioMayorCapacidad() {
		return null;
	}
}
	
