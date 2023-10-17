package utn.frba.disenio.tp.services.external.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import utn.frba.disenio.tp.services.AlertasObserver;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;

@Slf4j
public class NotificacionPantallaObserver implements AlertasObserver{

	private Stack<Notificacion> ultimasNotificaciones;
	
	//init
	{
		ultimasNotificaciones = new Stack<Notificacion>();
	}
	
	@Override
	public void notificarAlertas(List<Alerta> alertas) {
		log.info(String.format("Se notifican por pantalla las alertas", alertas));
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
