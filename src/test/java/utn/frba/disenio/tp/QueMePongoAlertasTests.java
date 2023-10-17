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
import utn.frba.disenio.tp.services.HistorialAlertas;
import utn.frba.disenio.tp.services.impl.entities.Alerta;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoAlertasTests {

	@Autowired private AccuWeatherAdapter accuWeatherAdapter;
	@Autowired private HistorialAlertas gestorAlertas;
	
	
    @BeforeEach
    void init() {

    }
	
	@Test 
	void obtenerAlertasBuenosAires() {
		List<Alerta> alertas= accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		List<Alerta> ultimasAlertas = gestorAlertas.obtenerUltimasAlertasMeteorologicas("Buenos Aires");
		for(int i=0;i<alertas.size();i++) {
			assertEquals(alertas.get(i),ultimasAlertas.get(i));
		}
	}
	

}
