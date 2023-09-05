package utn.frba.disenio.tp.prenda;

import lombok.Getter;

@Getter
public class Material {

	private String descripcion;
	private Trama trama;

	public Material clonar() {
		return new Material(descripcion,trama);
	}

	public Material(String descripcion, Trama trama) {
		super();
		this.descripcion = descripcion;
		this.trama = trama.clonar();
	}
	
	public Trama getTrama() {
		return trama.clonar();
	}
	
	
}
