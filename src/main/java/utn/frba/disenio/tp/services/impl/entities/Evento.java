package utn.frba.disenio.tp.services.impl.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import utn.frba.disenio.tp.usuario.Usuario;

@Getter
public class Evento {

	private List<Usuario> usuariosANotificar;
	private Alerta alerta;
	private String mensaje;

	public Evento(Alerta alerta,String mensaje) {
		super();
		this.alerta = alerta;
		this.mensaje = mensaje;
		this.usuariosANotificar = new ArrayList<Usuario>();
	}
	
	public Evento(Alerta alerta,List<Usuario> usuarios) {
		super();
		this.alerta = alerta;
		this.usuariosANotificar = clonarListaUsuarios(usuarios);
	}

	public List<Usuario> getUsuariosANotificar(){
		return clonarListaUsuarios(usuariosANotificar);
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuariosANotificar.add(usuario.clonar());
	}
	
	public Evento clonar() {
		return new Evento(alerta,usuariosANotificar);
	}
	
	private List<Usuario> clonarListaUsuarios(List<Usuario> usuariosANotificar) {
		return usuariosANotificar.stream().map(usuario -> usuario.clonar()).collect(Collectors.toList());
	}

	

}
