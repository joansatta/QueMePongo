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
import utn.frba.disenio.tp.services.GestorAlertas;
import utn.frba.disenio.tp.services.impl.entities.Alerta;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoAlertaTests {

	@Autowired private AccuWeatherAdapter accuWeatherAdapter;
	//@Autowired private AppProperties prop;
	@Autowired private GestorAlertas gestorAlertas;
	
	//private Date fecha;
	
	
    @BeforeEach
    void init() {
		//fecha = Utils.stringToDate("2019-05-03T01:00:00-03:00", prop.getApiFormatoFecha());
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
