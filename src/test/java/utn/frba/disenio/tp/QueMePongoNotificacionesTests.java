package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import utn.frba.disenio.tp.config.TestConfig;
import utn.frba.disenio.tp.services.AccuWeatherAdapter;
import utn.frba.disenio.tp.services.AlertasObserver;
import utn.frba.disenio.tp.services.impl.NotificacionMailObserver;
import utn.frba.disenio.tp.services.impl.NotificacionPantallaObserver;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Evento;
import utn.frba.disenio.tp.services.impl.entities.Notificacion;
import utn.frba.disenio.tp.usuario.Usuario;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoNotificacionesTests {

	@Autowired private AccuWeatherAdapter accuWeatherAdapter;
	private AlertasObserver notificacionPantallaObserver;
	private AlertasObserver notificacionEmailObserver;	
	Alerta alertaTormenta;
	Alerta alertaGranizo;
	
    @BeforeEach
    void init() {
    	notificacionPantallaObserver = new NotificacionPantallaObserver();
    	notificacionEmailObserver = new NotificacionMailObserver();
		List<Alerta> alertas = accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		alertaTormenta = alertas.stream().filter(alerta->"STORM".equals(alerta.getDescripcion())).findFirst().get();
		alertaGranizo = alertas.stream().filter(alerta->"HAIL".equals(alerta.getDescripcion())).findFirst().get();
		notificacionPantallaObserver.obtenerUltimasNotificaciones();
		notificacionEmailObserver.obtenerUltimasNotificaciones();
    }
	
	@Test 
	void notificarPorPantallaTormenta() {
		accuWeatherAdapter.agregarObserver(notificacionPantallaObserver);
		Evento eventoTormenta = new Evento(alertaTormenta,"Llevá Paraguas");
		notificacionPantallaObserver.agregarEvento(eventoTormenta);
		assertEquals(0, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");		
		assertEquals(1, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
	}

	@Test 
	void notificarPorMailAlerta() {
		accuWeatherAdapter.agregarObserver(notificacionEmailObserver);
		Evento eventoTormenta = new Evento(alertaTormenta,"Llevá Paraguas");
		notificacionEmailObserver.agregarEvento(eventoTormenta);
		assertEquals(0, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		assertEquals(1, notificacionEmailObserver.obtenerUltimasNotificaciones().size());
	}
	
	@Test
	void notificarParaguasAnteTormentaAUsuarioPuntual() {
		accuWeatherAdapter.agregarObserver(notificacionPantallaObserver);
		Usuario usuario = new Usuario("jsatta", "jsatta@gmail.com");
		Evento eventoTormenta = new Evento(alertaTormenta,"Llevá Paraguas");
		eventoTormenta.agregarUsuario(usuario);
		notificacionPantallaObserver.agregarEvento(eventoTormenta);
		assertEquals(0, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		List<Notificacion> notificacionesPantalla = notificacionPantallaObserver.obtenerUltimasNotificaciones();
		
		assertEquals("jsatta", notificacionesPantalla.get(0).getEvento().getUsuariosANotificar().get(0).getUsername());
		assertEquals("Llevá Paraguas",notificacionesPantalla.get(0).getEvento().getMensaje());
	}
	
	@Test
	void notificarSalirSinAutoAnteGranizoAUsuarioPuntual() {
		accuWeatherAdapter.agregarObserver(notificacionPantallaObserver);
		Usuario usuario = new Usuario("jsatta", "jsatta@gmail.com");
		Evento eventoTormenta = new Evento(alertaGranizo,"Salí sin el auto");
		eventoTormenta.agregarUsuario(usuario);
		notificacionPantallaObserver.agregarEvento(eventoTormenta);
		assertEquals(0, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");

		List<Notificacion> notificacionesPantalla = notificacionPantallaObserver.obtenerUltimasNotificaciones();
		
		assertEquals("jsatta", notificacionesPantalla.get(0).getEvento().getUsuariosANotificar().get(0).getUsername());
		assertEquals("Salí sin el auto",notificacionesPantalla.get(0).getEvento().getMensaje());
	}
	
	
	@Test
	void notificarPorMailAlertasAUsuarioPuntual() {
		accuWeatherAdapter.agregarObserver(notificacionEmailObserver);
		Usuario usuario = new Usuario("jsatta", "jsatta@gmail.com");
		Evento eventoGranizo = new Evento(alertaGranizo,"Salí sin el auto");
		Evento eventoTormenta = new Evento(alertaTormenta,"Salí con paraguas");
		eventoGranizo.agregarUsuario(usuario);
		notificacionEmailObserver.agregarEvento(eventoGranizo);
		eventoTormenta.agregarUsuario(usuario);
		notificacionEmailObserver.agregarEvento(eventoTormenta);
		assertEquals(0, notificacionEmailObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");

		List<Notificacion> notificacionesEmail = notificacionEmailObserver.obtenerUltimasNotificaciones();
		
		assertEquals("jsatta@gmail.com", notificacionesEmail.get(0).getEvento().getUsuariosANotificar().get(0).getCorreoElectronico());
		assertEquals("Salí con paraguas",notificacionesEmail.get(0).getEvento().getMensaje());
		assertEquals("jsatta@gmail.com", notificacionesEmail.get(1).getEvento().getUsuariosANotificar().get(0).getCorreoElectronico());
		assertEquals("Salí sin el auto",notificacionesEmail.get(1).getEvento().getMensaje());

	}


}
