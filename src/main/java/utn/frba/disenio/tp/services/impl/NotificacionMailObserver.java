package utn.frba.disenio.tp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.services.AlertasObserver;
import utn.frba.disenio.tp.services.external.MailSender;
import utn.frba.disenio.tp.services.external.impl.MailSenderImpl;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;

@Service
public class NotificacionMailObserver implements AlertasObserver {

	private MailSender mailSender;
	private Stack<Notificacion> ultimasNotificaciones;
	
	//init
	{
		ultimasNotificaciones = new Stack<Notificacion>();
		mailSender = new MailSenderImpl();
	}
	
	@Override
	public void notificarAlertas(List<Alerta> alertas) {
		mailSender.send("",String.format("Se notifican por correo las %d alertas ",alertas.size()));
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
