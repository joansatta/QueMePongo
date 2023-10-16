package utn.frba.disenio.tp.services.impl.entities;

import java.util.Date;

import lombok.Getter;

@Getter
public class Alerta {

	private Date fechaConsulta;
	private String descripcion;
	
	public Alerta(Date fechaConsulta, String descripcion) {
		super();
		this.fechaConsulta = new Date(fechaConsulta.getTime());
		this.descripcion = descripcion;
	}
	
	public Date getFechaConsulta() {
		return new Date(fechaConsulta.getTime());	
	}
	
	
}
