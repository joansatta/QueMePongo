package utn.frba.disenio.tp.guardarropas;

import utn.frba.disenio.tp.prenda.Prenda;


public interface PropuestaPrenda {

	public Boolean getAceptada();
	public void aceptar(Guardarropas guardarropas);
	public void rechazar(Guardarropas guardarropas);
	public Prenda getPrenda();
	
}
