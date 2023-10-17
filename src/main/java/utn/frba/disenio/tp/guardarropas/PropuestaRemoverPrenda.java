package utn.frba.disenio.tp.guardarropas;

import utn.frba.disenio.tp.prenda.Prenda;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({"EI_EXPOSE_REP"})

public class PropuestaRemoverPrenda implements PropuestaPrenda {

	private Prenda prenda;
	private Boolean aceptada;

	public PropuestaRemoverPrenda(Prenda prenda) {
		super();
		this.prenda = prenda.clonar();
		this.aceptada = false;
	}

	public Boolean getAceptada() {
		return aceptada;
	}

	public void aceptar(Guardarropas guardarropas) {
		guardarropas.removerPrenda(prenda);
		this.aceptada = true;
	}
	
	public void rechazar(Guardarropas guardarropas) {
		guardarropas.agregarPrenda(prenda);
		this.aceptada = false;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	
}
