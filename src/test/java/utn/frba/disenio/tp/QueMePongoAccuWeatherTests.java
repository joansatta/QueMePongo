package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import utn.frba.disenio.tp.config.TestConfig;
import utn.frba.disenio.tp.properties.AppProperties;
import utn.frba.disenio.tp.services.AccuWeatherAdapter;
import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;
import utn.frba.disenio.tp.utils.Utils;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoAccuWeatherTests {

	@Autowired private AccuWeatherAdapter accuWeatherAdapter;
	@Autowired private AppProperties prop;
	private Date fecha;
	
	
    @BeforeEach
    void init() {
		fecha = Utils.stringToDate("2019-05-03T01:00:00-03:00", prop.getApiFormatoFecha());
    }
	
	@Test 
	void obtenerClima() {
		AccuWeatherResponse res = accuWeatherAdapter.obtenerTemperaturaCompleta("Buenos Aires");
		assertEquals(0,res.getProbabilidadLluvia());
	}
	
	@Test 
	void obtenerAlertasBuenosAires() {
		String[] alertas= accuWeatherAdapter.obtenerAlertasMeteorologicas("Buenos Aires");
		String[] alertasEsperadasBuenosAires = new String[] {"STORM", "HAIL"};
		assertArrayEquals(alertasEsperadasBuenosAires,alertas);
	}
	
	@Test 
	void obtenerTemperaturaFarenheit() {
		Integer far = accuWeatherAdapter.obtenerTemperaturaFarenheit("Buenos Aires");
		assertEquals(57,far);
	}
	
	@Test 
	void obtenerTipoUnidad() {
		Integer tipoUnidad = accuWeatherAdapter.obtenerTipoUnidad("Buenos Aires");
		assertEquals(18,tipoUnidad);
	}

	
	@Test 
	void obtenerUnidadTemperatura() {
		String unidad = accuWeatherAdapter.obtenerUnidadTemperatura("Buenos Aires");
		assertEquals("F",unidad);
	}
	
	@Test 
	void obtenerEsDiaClaro() {
		Boolean esDiaClaro = accuWeatherAdapter.esDiaClaro("Buenos Aires");
		assertEquals(false,esDiaClaro);
	}
	
	@Test 
	void obtenerFechaConsultaApi() {
		Date fechaApi = accuWeatherAdapter.obtenerFecha("Buenos Aires");
		assertEquals(fecha,fechaApi);
	}

}
