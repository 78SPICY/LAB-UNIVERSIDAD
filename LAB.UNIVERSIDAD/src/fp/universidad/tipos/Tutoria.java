package fp.universidad.tipos;

import java.time.LocalTime;
import java.util.Objects;
import java.time.Duration;

	// 1. Atributos
	public record Tutoria(
		char diaSemana, 
		LocalTime horaComienzo,
		LocalTime horaFin,
		long duracion) implements Comparable<Tutoria>{

		// Restricciones
		public Tutoria {
			if (diaSemana == 'S' || diaSemana == 'D') {
				throw new IllegalArgumentException("Las tutorías deben de darse en días lectivos. Introduzca un día nuevo");
			}
			if (Duration.between(horaComienzo, horaFin).toMinutes() < 15 || duracion < 15) {
				throw new IllegalArgumentException("Las tutorías deben de durar por lo menos 15 minutos.");
			}
		}
		
	// 2. Constructores
	public Tutoria(char diaSemana, LocalTime horaComienzo, LocalTime horaFin) {
		this(diaSemana, horaComienzo, horaFin, Duration.between(horaComienzo, horaFin).toMinutes());
	}
	
	
	public Tutoria(char diaSemana, LocalTime horaComienzo, long duracion) {
		this(diaSemana, horaComienzo, horaComienzo.plusMinutes(duracion), duracion);
	}
	
	
	// 3. Método toString()
	public String toString() {
		return diaSemana + " " + horaComienzo + "-" + horaFin;
	}

	// 4. Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Tutoria) {
			Tutoria a = (Tutoria)obj;
			res = this.diaSemana == a.diaSemana
			// debido a que diaSemana es un 'char' (tipo primitivo), no tiene métodos y se tiene que usar == para compararlo
			&& this.horaComienzo.equals(a.horaComienzo);
		}
		return res;
	}
	
	// 5. Método hashCode()
	public int hashCode() {
		return Objects.hash(diaSemana, horaComienzo);
	}
	
	// 6. Método compareTo()
	public int compareTo(Tutoria a) {
		int res = Character.compare(this.diaSemana, a.diaSemana);
		if (res == 0) {
			res = this.horaComienzo.compareTo(a.horaComienzo);
		}
		return res;
	}
}




 