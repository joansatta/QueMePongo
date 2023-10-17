package utn.frba.disenio.tp.services.external.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.services.AlertasObserver;
import utn.frba.disenio.tp.services.external.NotificationService;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;

@Service
public class NotificacionPantallaObserver implements AlertasObserver{

	@Autowired private NotificationService notificacionService;
	private Stack<Notificacion> ultimasNotificaciones;
	
	//init
	{
		ultimasNotificaciones = new Stack<Notificacion>();
	}
	
	@Override
	public void notificarAlertas(List<Alerta> alertas) {
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
