package utn.frba.disenio.tp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.services.AlertasObserver;
import utn.frba.disenio.tp.services.external.ScreenNotificationService;
import utn.frba.disenio.tp.services.external.impl.ScreenNotificationServiceImpl;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;

@Service
public class NotificacionPantallaObserver implements AlertasObserver {

	private ScreenNotificationService notificacionService;
	private Stack<Notificacion> ultimasNotificaciones;
	
	//init
	{
		ultimasNotificaciones = new Stack<Notificacion>();
		notificacionService = new ScreenNotificationServiceImpl();
	}
	
	@Override
	public void notificarAlertas(List<Alerta> alertas) {
		//TODO: filtrar para que mande correos cuando corresponda
		notificacionService.notify(String.format("Se notifican por pantalla las alertas", alertas));
		ultimasNotificaciones.push(new Notificacion());
	}
	
	public List<Notificacion> obtenerUltimasNotificaciones(){
		List<Notificacion> notificacionesRet = new ArrayList<Notificacion>();
		Integer notificacionesSize = ultimasNotificaciones.size();
		for(int i=0;i<notificacionesSize;i++) {
			notificacionesRet.add(ultimasNotificaciones.pop());
		}
		return notificacionesRet;
	}

}
