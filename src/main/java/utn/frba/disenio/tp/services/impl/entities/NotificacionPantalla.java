package utn.frba.disenio.tp.services.impl.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificacionPantalla implements Notificacion {

	private Evento evento;
	
	@Override
	public Evento getEvento() {
		return evento;
	}

	@Override
	public String getMensaje() {
		return evento.getMensaje();
	}

}
