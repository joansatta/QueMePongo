package utn.frba.disenio.tp.usuario;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.NonNull;

public class Guardarropas {

	@NonNull private CategoriaGuardarropas categoria;
	@NonNull private String descripcion;
	@NonNull private Usuario usuarioDuenio;
	@NonNull private Set<Usuario> usuarios;

	public void agregarUsuario(Usuario usuario) {
		if(null==this.usuarios) {
			this.usuarios = new LinkedHashSet<Usuario>();
		}
		this.usuarios.add(usuario);
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
}
