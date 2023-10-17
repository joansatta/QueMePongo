package utn.frba.disenio.tp.guardarropas;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import utn.frba.disenio.tp.prenda.Prenda;

@SuppressFBWarnings({"EI_EXPOSE_REP"})

public class PropuestaAgregarPrenda implements PropuestaPrenda {

	private Prenda prenda;
	private Boolean aceptada;

	public PropuestaAgregarPrenda(Prenda prenda) {
		super();
		this.prenda = prenda.clonar();
		this.aceptada = false;
	}

	/*
	public Boolean getAceptada() {
		return aceptada;
	}
	*/

	public void aceptar(Guardarropas guardarropas) {
		if(!this.aceptada) {
			guardarropas.agregarPrenda(prenda);
		}
		this.aceptada = true;
	}
	
	public void rechazar(Guardarropas guardarropas) {
		if(this.aceptada) {
			guardarropas.removerPrenda(prenda);
		}
		this.aceptada = false;
	}

/*	public Prenda getPrenda() {
		return prenda;
	}
	*/

	
}
