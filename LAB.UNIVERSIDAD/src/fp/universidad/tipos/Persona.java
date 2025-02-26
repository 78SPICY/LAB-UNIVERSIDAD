package fp.universidad.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

	// 1. Atributos 
	public class Persona implements Comparable<Persona> {
		private String dni;
		private String nombre;
		private String apellidos;
		private LocalDate fechaNacimiento;
		private String email;
		
    // 2. Constructores
    public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email; // null en el caso de que no tuviese
        
    	// Restricciones
        if (dni.length() != 9) {
        	throw new IllegalArgumentException("El DNI debe de tener 9 caracteres. Introduzca uno válido");
		}
	}
  
    // Constructor extra
    public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this(dni, nombre, apellidos, fechaNacimiento, "");
    }
    
    
    // 3. Getters
    public String getDni() {
        return dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }
    
    public Integer getEdad() {
        return fechaNacimiento.until(LocalDate.now()).getYears();
    }
    
    
    // 4. Setters
    public void setDni(String dni) {
    	this.dni = dni;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // 5. Método toString()
    public String toString() {
        return dni + " - " + apellidos + ", " + nombre + " - " + 
               fechaNacimiento.format(DateTimeFormatter.ofPattern("d/M/y"));
    }
    
    
    // 6. Método equals()
    public boolean equals(Object obj) {
    	boolean res = false;
    	if (obj instanceof Persona) {
    		Persona a = (Persona)obj;
    		res = this.getDni().equals(a.getDni()) 
    		&& this.getNombre().equals(a.getNombre()) 
    		&& this.getApellidos().equals(a.getApellidos());
    	}
    	return res;
    }
	
    
    // 7. Método hashCode()
    public int hashCode() {
    	return Objects.hash(dni, nombre, apellidos);
    }
    
    
    // 8. Método toCompare()
    public int compareTo(Persona a) {
    	int res = this.apellidos.compareTo(a.apellidos);
    	if (res == 0) {
    		res = this.nombre.compareTo(a.nombre);
    		if (res == 0) {
    			res = this.dni.compareTo(a.dni);
    		}
    	}
    	return res;	
    }
}