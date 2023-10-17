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
import utn.frba.disenio.tp.services.impl.NotificacionPantallaObserver;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoNotificacionesTests {

	@Autowired private AccuWeatherAdapter accuWeatherAdapter;
	private AlertasObserver notificacionObserver;
		
	
    @BeforeEach
    void init() {
    	notificacionObserver = new NotificacionPantallaObserver();
    }
	
	@Test 
	void notificarPorTormenta() {
		accuWeatherAdapter.agregarObserver(notificacionObserver);
		assertEquals(0, notificacionObserver.obtenerUltimasNotificaciones().size());
		accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		assertEquals(1, notificacionObserver.obtenerUltimasNotificaciones().size());
	}
	

}
