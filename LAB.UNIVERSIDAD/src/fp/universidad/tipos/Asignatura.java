package fp.universidad.tipos;

	// 1. Atributos
	public record Asignatura(
		String nombre,
		String codigo,
		Double creditos,
		TipoAsignatura tipoAsignatura,
		Integer curso) implements Comparable<Asignatura> {
	
	// Restricciones
	public Asignatura {
		if (codigo.length() > 7) {
			throw new IllegalArgumentException("El código no puede tener más de 7 caractéres. Introduzca uno válido");
		}
		if (creditos <= 0) {
			throw new IllegalArgumentException("El número de créditos de la asignatura debe de ser un número positivo. Instroduzca uno válido");
		}
	}
		
	// Pendiente
	public String getAcronimo() {
		return null;
	}
	
	
	// 2. Método toString()
	public String toString() {
		return "(" + codigo + ") " + nombre;
	}
	
	
	// 3. Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Asignatura) {
			Asignatura a = (Asignatura)obj;
			res = this.codigo().equals(a.codigo());
			}
		return res;
		}
	
	
	// 4. Método hashCode()
	public int hashCode() {
		return codigo.hashCode();
	}
	
	
	// 5. Método compareTo()
	public int compareTo(Asignatura a) {
		return codigo.compareTo(a.codigo);
	}
	
}
