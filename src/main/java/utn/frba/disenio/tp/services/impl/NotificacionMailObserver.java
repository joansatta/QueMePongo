package utn.frba.disenio.tp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.services.AlertasObserver;
import utn.frba.disenio.tp.services.external.MailSender;
import utn.frba.disenio.tp.services.external.impl.MailSenderImpl;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Evento;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;
import utn.frba.disenio.tp.services.impl.entities.NotificacionEmail;
import utn.frba.disenio.tp.usuario.Usuario;

@Service
public class NotificacionMailObserver implements AlertasObserver {

	private MailSender mailSender;
	private Stack<Notificacion> ultimasNotificaciones;
	private List<Evento> eventos;
	
	//init
	{
		ultimasNotificaciones = new Stack<Notificacion>();
		mailSender = new MailSenderImpl();
		eventos = new ArrayList<Evento>();
	}
	
	@Override
	public void notificarAlertas(List<Alerta> alertas) {
		for(Evento evento:eventos) {
			for(Usuario usuario:evento.getUsuariosANotificar()) {
				mailSender.send(usuario.getCorreoElectronico(),evento.getMensaje());
			}
			ultimasNotificaciones.push(new NotificacionEmail(evento));
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
