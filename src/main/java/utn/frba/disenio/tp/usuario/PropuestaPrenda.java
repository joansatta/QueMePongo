package utn.frba.disenio.tp.usuario;

import utn.frba.disenio.tp.prenda.Prenda;

public class PropuestaPrenda {

	private Prenda prenda;
	private Guardarropas guardarropas;
	private Boolean aceptada;
	
	public PropuestaPrenda(Prenda prenda, Guardarropas guardarropas) {
		super();
		this.prenda = prenda.clonar();
		this.guardarropas = guardarropas;
		this.aceptada = false;
	}

	public Boolean getAceptada() {
		return aceptada;
	}

	public void aceptar(Boolean aceptada) {
		this.aceptada = aceptada;
	}

	public Prenda getPrenda() {
		return prenda.clonar();
	}

	public Guardarropas getGuardarropas() {
		return guardarropas;
	}
	
	
}
