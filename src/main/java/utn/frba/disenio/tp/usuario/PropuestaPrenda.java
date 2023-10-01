package utn.frba.disenio.tp.usuario;

import utn.frba.disenio.tp.prenda.Prenda;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class PropuestaPrenda {

	private Prenda prenda;
	private Guardarropas guardarropas;
	private Boolean aceptada;
	private AccionesPropuesta accion;

    @SuppressFBWarnings("EI_EXPOSE_REP2")
	public PropuestaPrenda(Prenda prenda, Guardarropas guardarropas,AccionesPropuesta accion) {
		super();
		this.prenda = prenda.clonar();
		this.guardarropas = guardarropas;
		this.accion = accion;
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

    @SuppressFBWarnings("EI_EXPOSE_REP")
	public Guardarropas getGuardarropas() {
		return guardarropas;
	}

	public AccionesPropuesta getAccion() {
		return accion;
	}
	
	
	
	
}
