package utn.frba.disenio.tp.services;

import java.util.List;

import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Evento;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;

public interface AlertasObserver {

	public void notificarAlertas(List<Alerta> alertas);
	public List<Notificacion> obtenerUltimasNotificaciones();
	public void agregarEvento(Evento evento);
}
