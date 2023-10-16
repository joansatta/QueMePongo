package utn.frba.disenio.tp.guardarropas;

import utn.frba.disenio.tp.prenda.Prenda;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({"EI_EXPOSE_REP"})

public class PropuestaPrenda {

	private Prenda prenda;
	private Boolean aceptada;
	private AccionesPropuesta accion;

	public PropuestaPrenda(Prenda prenda, AccionesPropuesta accion) {
		super();
		this.prenda = prenda.clonar();
		this.accion = accion;
		this.aceptada = false;
	}

	public Boolean getAceptada() {
		return aceptada;
	}

	public void aceptar() {
		this.aceptada = true;
	}
	
	public void rechazar() {
		this.aceptada = false;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public AccionesPropuesta getAccion() {
		return accion;
	}
	
	
	
	
}
