package utn.frba.disenio.tp.usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;
import utn.frba.disenio.tp.guardarropas.AccionesPropuesta;
import utn.frba.disenio.tp.guardarropas.CategoriaGuardarropas;
import utn.frba.disenio.tp.guardarropas.Guardarropas;
import utn.frba.disenio.tp.guardarropas.PropuestaPrenda;
import utn.frba.disenio.tp.prenda.Prenda;

public class Usuario {

	@NonNull private String username;
	@NonNull private Set<Guardarropas> guardarropasPropios;
	@NonNull private Set<Guardarropas> guardarropasIntegrados;
	private List<CategoriaGuardarropas> categorias;
	
	public Usuario(@NonNull String username) {
		super();
		this.username = username;
		this.guardarropasPropios = new LinkedHashSet<Guardarropas>();
		this.guardarropasIntegrados = new LinkedHashSet<Guardarropas>();
	}
	
	public CategoriaGuardarropas crearCategoria(String descripcion) {
		if(null==categorias) {
			categorias = new ArrayList<CategoriaGuardarropas>();
		}
		CategoriaGuardarropas categoria = new CategoriaGuardarropas(descripcion);
		categorias.add(categoria);
		return categoria;
	}
	
	public Guardarropas crearGuardarropasPropio(String descripcion,CategoriaGuardarropas categoria) {
		Guardarropas guardarropas = new Guardarropas(categoria, descripcion, this);
		this.guardarropasPropios.add(guardarropas);
		return guardarropas;
	}
	
	public PropuestaPrenda crearPropuesta(Prenda prenda,AccionesPropuesta accion) {
		return new PropuestaPrenda(prenda,accion);
	}
	
	public void aceptarPropuesta(Guardarropas guardarropas, PropuestaPrenda propuesta) {
		if(propuesta.getAccion().equals(AccionesPropuesta.AGREGAR)){
			guardarropas.agregarPrenda(propuesta.getPrenda());
		} else if (propuesta.getAccion().equals(AccionesPropuesta.REMOVER)) {
			guardarropas.removerPrenda(propuesta.getPrenda());
		}
		propuesta.aceptar();
	}
	
	public void rechazarPropuesta(Guardarropas guardarropas,PropuestaPrenda propuesta) {
		if(propuesta.getAceptada()) {
			if(propuesta.getAccion().equals(AccionesPropuesta.REMOVER)){
				guardarropas.agregarPrenda(propuesta.getPrenda());
			} else if (propuesta.getAccion().equals(AccionesPropuesta.AGREGAR)) {
				guardarropas.removerPrenda(propuesta.getPrenda());
			}
		}
		propuesta.rechazar();
	}
	
	public void integrarGuardarropas(Guardarropas guardarropas) {
		this.guardarropasIntegrados.add(guardarropas);
	}
	
	public Set<Guardarropas> getGuardarropas() {
		Set<Guardarropas> guardarropas = new HashSet<Guardarropas>();
		guardarropas.addAll(guardarropasPropios);
		return guardarropas;
	}
	
	public String getUsername() {
		return username;
	}


}
