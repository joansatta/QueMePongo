package utn.frba.disenio.tp.guardarropas;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.NonNull;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.constructores.excepciones.CategoriaInvalidaException;

class CategorizacionPrendas {

	@NonNull private Set<Prenda> partesInferiores;
	@NonNull private Set<Prenda> partesSuperiores;
	@NonNull private Set<Prenda> calzados;
	@NonNull private Set<Prenda> accesorios;

	public CategorizacionPrendas() {
		super();
		this.accesorios = new LinkedHashSet<Prenda>();
		this.calzados = new LinkedHashSet<Prenda>();
		this.partesInferiores = new LinkedHashSet<Prenda>();
		this.partesSuperiores = new LinkedHashSet<Prenda>();
	}
	
	public void agregarPrenda(Prenda prenda) {
		identificarLista(prenda).add(prenda);
	}
	
	public void removerPrenda(Prenda prenda) {
		identificarLista(prenda).remove(prenda);
	}
	
	private Set<Prenda> identificarLista(Prenda prenda) {
		switch (prenda.getCategoria()) {
		case Accesorio: {
			return accesorios;
		}
		case Calzado: {
			return calzados;
		}
		case ParteInferior: {
			return partesInferiores;
		}
		case ParteSuperior:{
			return partesSuperiores;
		}
		default: {
			throw new CategoriaInvalidaException(prenda.getCategoria().toString());
		}

		}
	}

	public int getCantidadPartesSuperiores() {
		return partesSuperiores.size();
	}

	public int getCantidadPartesInferiores() {
		return partesInferiores.size();
	}

	public int getCantidadAccesorios() {
		return accesorios.size();
	}

	public Integer getCantidadCalzados() {
		return calzados.size();
	}

}
