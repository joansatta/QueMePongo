package utn.frba.disenio.tp.usuario;

import utn.frba.disenio.tp.guardarropas.Guardarropas;
import utn.frba.disenio.tp.prenda.Prenda;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({"EI_EXPOSE_REP","EI_EXPOSE_REP2"})

public class PropuestaPrenda {

	private Prenda prenda;
	private Guardarropas guardarropas;
	private Boolean aceptada;
	private AccionesPropuesta accion;

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

	public void aceptar() {
		this.aceptada = true;
	}
	
	public void rechazar() {
		this.aceptada = false;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public Guardarropas getGuardarropas() {
		return guardarropas;
	}

	public AccionesPropuesta getAccion() {
		return accion;
	}
	
	
	
	
}
