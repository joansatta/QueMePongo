package utn.frba.disenio.tp.usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;
import utn.frba.disenio.tp.prenda.Prenda;

public class Usuario {

	@NonNull private String username;
	@NonNull private Set<Guardarropas> guardarropasPropios;
	@NonNull private Set<Guardarropas> guardarropasIntegrados;
	private List<PropuestaPrenda> propuestas;
	private List<CategoriaGuardarropas> categorias;
	
	public CategoriaGuardarropas crearCategoria(String descripcion) {
		if(null==categorias) {
			categorias = new ArrayList<CategoriaGuardarropas>();
		}
		CategoriaGuardarropas categoria = new CategoriaGuardarropas(descripcion);
		categorias.add(categoria);
		return categoria;
	}
	
	public Guardarropas crearGuardarropasPropio(String descripcion,CategoriaGuardarropas categoria) {
		if(null==guardarropasPropios) {
			guardarropasPropios = new LinkedHashSet<Guardarropas>();
		}
		Guardarropas guardarropas = new Guardarropas(categoria, descripcion, this);
		this.guardarropasPropios.add(guardarropas);
		return guardarropas;
	}

	public Usuario(@NonNull String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public PropuestaPrenda crearPropuesta(Prenda prenda,Guardarropas guardarropas,AccionesPropuesta accion) {
		return new PropuestaPrenda(prenda, guardarropas);
	}
	
	public void agregarPropuesta(PropuestaPrenda propuesta) {
		if(null==propuestas) {
			propuestas = new ArrayList<PropuestaPrenda>();
		}
		propuestas.add(propuesta);
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
}
