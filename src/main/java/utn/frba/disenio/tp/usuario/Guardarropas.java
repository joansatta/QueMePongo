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


	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.integrarGuardarropas(this);
	}

	public String getUsuarioDuenio() {
		return usuarioDuenio.getUsername();
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public String getCategoria() {
		return categoria.getDescripcion();
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

	public Integer getCantidadTotalPrendas() {
		Integer calzadosInt = getCantidadCalzados();
		Integer accesoriosInt = getCantidadAccesorios();
		Integer partesInferioresInt = getCantidadPartesInferiores();
		Integer partesSuperioresInt =getCantidadPartesSuperiores();
		return calzadosInt+accesoriosInt+partesInferioresInt+partesSuperioresInt;
	}

	private int getCantidadPartesSuperiores() {
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

}
