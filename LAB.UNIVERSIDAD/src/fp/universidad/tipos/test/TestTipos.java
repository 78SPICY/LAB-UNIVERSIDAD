package fp.universidad.tipos.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidad.tipos.*;

public class TestTipos {

	public static void main(String[] args) {
		
		
	// Prueba de Agisnatura
		
		TipoAsignatura a = TipoAsignatura.PRIMER_CUATRIMESTRE;
		TipoAsignatura b = TipoAsignatura.SEGUNDO_CUATRIMESTRE;
		
		Asignatura fisica = new Asignatura("Fundamentos Físicos de la Informática", "2060009", 6.0, a, 2025);
		
		Asignatura estructuras = new Asignatura("Estructura de Computadores", "2060008", 6.0, b, 2025);
		
		System.out.println("Prueba del tipo Asignatura ===> " + fisica);
		System.out.println("Hashcode del tipo Asignatura ===> " + fisica.hashCode());
		System.out.println("Comparador del tipo Asignatura ===> " + fisica.compareTo(estructuras));
		System.out.println("Comparador del tipo Asignatura ===> " + fisica.compareTo(estructuras));
		
		
	/// Prueba de Persona
	
		Persona jesus = new Persona("53916213G", "Jesús", "Valenzuela Alves", LocalDate.of(2006, 12, 3));
		Persona pedro = new Persona("25915704V", "Pedro", "Valenzuela Alves", LocalDate.of(1947, 4, 12), "pvg640@hotmail.com");
		
		jesus.setEmail("jvalenzuelaalves@gmail.com");
		
		System.out.println("Prueba del tipo Persona ===> " + jesus);
		System.out.println("Hashcode del tipo Persona ===> " + jesus.hashCode());
		System.out.println("Comparador del tipo Persona ===> " + jesus.compareTo(pedro));
		
	/// Prueba de Clase
		
		Planta z = new Planta(1); 
		Planta x = new Planta(3); 
		
		Espacio clase = new Espacio(TipoEspacio.TEORIA, "H0.10", 80, z);
		Espacio clase2 = new Espacio(TipoEspacio.EXAMEN, "A2.13", 200, x);
		
		System.out.println("Prueba del tipo Clase ===> " + clase); 
		System.out.println("Hashcode del tipo Clase ===> " + clase.hashCode()); 
		System.out.println("Comparador del tipo Clase ===> " + clase.compareTo(clase2)); 

		
	/// Prueba de Nota
		
		Convocatoria c = Convocatoria.SEGUNDA;
		Convocatoria d = Convocatoria.PRIMERA;
		
		Nota nota = new Nota(fisica, fisica.curso(), c, 9.5, false);
		Nota nota2 = new Nota(estructuras, estructuras.curso(), d, 9.8, true);
		
		System.out.println("Prueba del tipo Nota ===> " + nota);
		System.out.println("Hashcode del tipo Nota ===> " + nota.hashCode());
		System.out.println("Comparador del tipo Nota ===> " + nota.compareTo(nota2));
	
		
	/// Prueba de Tutoría

		Tutoria tutoria = new Tutoria('X', LocalTime.of(12, 0), LocalTime.of(12, 30));
		Tutoria tutoria2 = new Tutoria('M', LocalTime.of(12, 30), 30);
		
		System.out.println("Prueba del tipo Tutoría ===> " + tutoria);
		System.out.println("Hashcode del tipo Tutoría ===> " + tutoria.hashCode());
		System.out.println("Comparador del tipo Tutoría ===> " + tutoria.compareTo(tutoria2));
		}
}
