package utn.frba.disenio.tp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.services.AlertasObserver;
import utn.frba.disenio.tp.services.external.ScreenNotificationService;
import utn.frba.disenio.tp.services.external.impl.ScreenNotificationServiceImpl;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Evento;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;
import utn.frba.disenio.tp.services.impl.entities.NotificacionPantalla;
import utn.frba.disenio.tp.usuario.Usuario;

@Service
public class NotificacionPantallaObserver implements AlertasObserver {

	private ScreenNotificationService notificacionService;
	private Stack<Notificacion> ultimasNotificaciones;
	private List<Evento> eventos;
	
	//init
	{
		ultimasNotificaciones = new Stack<Notificacion>();
		notificacionService = new ScreenNotificationServiceImpl();
		eventos = new ArrayList<Evento>();
	}
	
	
	@Override
	public void notificarAlertas(List<Alerta> alertas) {
		for(Evento evento:eventos) {
			for(Usuario usuario:evento.getUsuariosANotificar()) {
				notificacionService.notify(usuario.getUsername(),evento.getMensaje());
			}
			ultimasNotificaciones.push(new NotificacionPantalla(evento));
		}
	}
	
	@Override
	public void agregarEvento(Evento evento) {
		eventos.add(evento);
	}

	@Override
	public List<Notificacion> obtenerUltimasNotificaciones(){
		List<Notificacion> notificacionesRet = new ArrayList<Notificacion>();
		Integer notificacionesSize = ultimasNotificaciones.size();
		for(int i=0;i<notificacionesSize;i++) {
			notificacionesRet.add(ultimasNotificaciones.pop());
		}
		return notificacionesRet;
	}

}
