package utn.frba.disenio.tp.guardarropas;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.usuario.Usuario;

public class Guardarropas {

	@NonNull private CategoriaGuardarropas categoria;
	@NonNull private String descripcion;
	@NonNull private Usuario usuarioDuenio;
	@NonNull private Set<Usuario> usuarios;
	@NonNull private CategorizacionPrendas categorizacionPrendas;
	private List<PropuestaPrenda> propuestas;


	public Guardarropas(@NonNull CategoriaGuardarropas categoria, @NonNull String descripcion,
			@NonNull Usuario usuarioDuenio) {
		super();
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.usuarioDuenio = usuarioDuenio;
		this.usuarios = new LinkedHashSet<Usuario>();
		this.categorizacionPrendas = new CategorizacionPrendas();
		this.propuestas = new ArrayList<PropuestaPrenda>();
		agregarUsuario(usuarioDuenio);
	}
	
	public void aceptarPropuesta(PropuestaPrenda propuesta) {
		usuarioDuenio.aceptarPropuesta(this,propuesta);
	}
	
	public void rechazarPropuesta(PropuestaPrenda propuesta) {
		usuarioDuenio.rechazarPropuesta(this, propuesta);
	}
	
	public void agregarPropuesta(PropuestaPrenda propuesta) {
		propuestas.add(propuesta);
	}
	
	public List<PropuestaPrenda> getPropuestas(){
		List<PropuestaPrenda> propuestasAux = new ArrayList<PropuestaPrenda>();
		propuestasAux.addAll(this.propuestas);
		return propuestasAux;
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.integrarGuardarropas(this);
	}

	public Boolean usuarioPertenece(Usuario usuario) {
		return usuarios.contains(usuario);
	}

	public void agregarPrenda(Prenda prenda) {
		categorizacionPrendas.agregarPrenda(prenda);
	}
	
	public void removerPrenda(Prenda prenda) {
		categorizacionPrendas.removerPrenda(prenda);
	}
	
	public String getUsuarioDuenio() {
		return usuarioDuenio.getUsername();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCategoria() {
		return categoria.getDescripcion();
	}

	public int getCantidadPartesSuperiores() {
		return categorizacionPrendas.getCantidadPartesSuperiores();
	}

	public int getCantidadPartesInferiores() {
		return categorizacionPrendas.getCantidadPartesInferiores();
	}

	public int getCantidadAccesorios() {
		return categorizacionPrendas.getCantidadAccesorios();
	}

	public Integer getCantidadCalzados() {
		return categorizacionPrendas.getCantidadCalzados();
	}

}
