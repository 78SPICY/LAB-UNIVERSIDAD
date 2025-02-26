package fp.universidad.tipos;

import java.util.Objects;

	// 1. Constructores
	public record Nota(	
		Asignatura asignatura,
		Integer curso,
		Convocatoria convocatoria,
		Double valor,
		Boolean mencionHonor) implements Comparable<Nota> {

		public Nota {
			if (valor < 0 || valor > 10) {
				throw new IllegalArgumentException("Las notas deben de ser entre 0 y diez. Introduzca otro nuevo");
			}
			if (mencionHonor == true && valor < 9) {
				throw new IllegalArgumentException("Solo se puede obtener una mención de honor con una nota de 9 o más.");
			}
		}
		
	// Constructor extra
    public Nota(Asignatura asignatura, Integer curso, Convocatoria convocatoria, Double valor) {
        this(asignatura, curso, convocatoria, valor, false); 
    }
    
    // Método para obtener la calificación
	private Calificacion getCalificacion() {
		Calificacion res = null;
		if (valor < 5) {
			res = Calificacion.SUSPENSO;
		}
		
		else if (valor < 7) {
			res = Calificacion.APDOBADO;
		}
		
		else if (valor < 9) {
			res = Calificacion.NOTABLE;
		}
		
		else if (mencionHonor) {
			res = Calificacion.MATRICULA_DE_HONOR;
		}
		
		else {
			res = Calificacion.SOBRESALIENTE;
		}
		return res;
	}
	

	// 2. Método toString()
	public String toString() {
		return "(" + asignatura.codigo() + ")" 
		+ " " + asignatura.nombre() + ", " + curso 
		+ "-" + (curso - 1) + ", " + convocatoria 
		+ ", " + valor + ", " + getCalificacion();
	}
	
	// 3. Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Nota) {
			Nota a = (Nota)obj;
			res = this.curso.equals(a.curso) 
			&& this.asignatura.equals(a.asignatura) 
			&& this.convocatoria.equals(a.convocatoria);
		}
	return res;
	}
	
	// 4. Método hashCode()
	public int hashCode() {
		return Objects.hash(curso, asignatura, convocatoria);
	}
	
	// 5. Método toCompare()
	public int compareTo(Nota a) {
		int res = this.curso.compareTo(a.curso);
		if (res == 0) {
			res = this.asignatura.compareTo(a.asignatura);
			if (res == 0) {
				res = this.convocatoria.compareTo(a.convocatoria);
			}
		}
		return res;
	}
}
