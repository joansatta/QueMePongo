package utn.frba.disenio.tp.usuario;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.NonNull;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.constructores.excepciones.CategoriaInvalidaException;

public class Guardarropas {

	@NonNull private CategoriaGuardarropas categoria;
	@NonNull private String descripcion;
	@NonNull private Usuario usuarioDuenio;
	@NonNull private Set<Usuario> usuarios;
	@NonNull private Set<Prenda> partesInferiores;
	@NonNull private Set<Prenda> partesSuperiores;
	@NonNull private Set<Prenda> calzados;
	@NonNull private Set<Prenda> accesorios;

	public Guardarropas(@NonNull CategoriaGuardarropas categoria, @NonNull String descripcion,
			@NonNull Usuario usuarioDuenio) {
		super();
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.usuarioDuenio = usuarioDuenio;
		this.accesorios = new LinkedHashSet<Prenda>();
		this.calzados = new LinkedHashSet<Prenda>();
		this.partesInferiores = new LinkedHashSet<Prenda>();
		this.partesSuperiores = new LinkedHashSet<Prenda>();
		this.usuarios = new LinkedHashSet<Usuario>();
		agregarUsuario(usuarioDuenio);
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.integrarGuardarropas(this);
	}


	public Boolean usuarioPertenece(Usuario usuario) {
		return usuarios.contains(usuario);
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
