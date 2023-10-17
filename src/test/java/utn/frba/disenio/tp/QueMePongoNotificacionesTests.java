package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoNotificacionesTests {

	@Autowired private AccuWeatherAdapter accuWeatherAdapter;
	private AlertasObserver notificacionPantallaObserver;
	private AlertasObserver notificacionMailObserver;	
	
    @BeforeEach
    void init() {
    	notificacionPantallaObserver = new NotificacionPantallaObserver();
    	notificacionMailObserver = new NotificacionMailObserver();
    }
	
	@Test 
	void notificarPorPantallaTormenta() {
		accuWeatherAdapter.agregarObserver(notificacionPantallaObserver);
		assertEquals(0, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		assertEquals(1, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
	}

	@Test 
	void notificarPorMailAlerta() {
		accuWeatherAdapter.agregarObserver(notificacionMailObserver);
		assertEquals(0, notificacionPantallaObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		assertEquals(1, notificacionMailObserver.obtenerUltimasNotificaciones().size());
	}

}
