package utn.frba.disenio.tp.usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.constructores.excepciones.GuardarropasNoValidoExcepcion;

public class Usuario {

	@NonNull private String username;
	@NonNull private Set<Guardarropas> guardarropasPropios;
	@NonNull private Set<Guardarropas> guardarropasIntegrados;
	private List<PropuestaPrenda> propuestas;
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
	
	public PropuestaPrenda crearPropuesta(Prenda prenda,Guardarropas guardarropas,AccionesPropuesta accion) {
		return new PropuestaPrenda(prenda, guardarropas,accion);
	}
	
	public void agregarPropuesta(PropuestaPrenda propuesta) {
		if(null==propuestas) {
			propuestas = new ArrayList<PropuestaPrenda>();
		}
		propuestas.add(propuesta);
	}
	
	public void aceptarPropuesta(PropuestaPrenda propuesta) {
		validarGuardarropas(propuesta);
		Guardarropas guardarropas = propuesta.getGuardarropas();
		if(propuesta.getAccion().equals(AccionesPropuesta.AGREGAR)){
			guardarropas.agregarPrenda(propuesta.getPrenda());
		} else if (propuesta.getAccion().equals(AccionesPropuesta.REMOVER)) {
			guardarropas.removerPrenda(propuesta.getPrenda());
		}
		propuesta.aceptar();
	}
	
	public void rechazarPropuesta(PropuestaPrenda propuesta) {
		validarGuardarropas(propuesta);
		Guardarropas guardarropas = propuesta.getGuardarropas();
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

	private void validarGuardarropas(PropuestaPrenda propuesta) {
		if(!this.guardarropasPropios.stream().anyMatch(guardarropas -> guardarropas==propuesta.getGuardarropas())) {
			throw new GuardarropasNoValidoExcepcion(username);
		}
	}
	
	
	public List<PropuestaPrenda> getPropuestas(){
		List<PropuestaPrenda> propuestasAux = new ArrayList<PropuestaPrenda>();
		propuestasAux.addAll(this.propuestas);
		return propuestasAux;
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
