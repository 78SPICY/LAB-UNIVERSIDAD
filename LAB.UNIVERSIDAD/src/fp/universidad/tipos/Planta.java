package fp.universidad.tipos;

public record Planta(Integer planta) implements Comparable<Planta> {

	public Integer getPlanta() {
		return planta;
	}
	
	public int compareTo(Planta a) {
		return this.planta.compareTo(a.planta);
	}
	
}
