package utn.frba.disenio.tp.services;

import java.util.Date;
import java.util.List;

import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;
import utn.frba.disenio.tp.services.impl.entities.Alerta;

public interface AccuWeatherAdapter {

	public AccuWeatherResponse obtenerTemperaturaCompleta(String ciudad);
	public Integer obtenerTemperaturaFarenheit(String ciudad);
	public String obtenerUnidadTemperatura(String ciudad);
	public Integer obtenerTipoUnidad(String ciudad);
	public Date obtenerFecha(String ciudad);
	public Boolean esDiaClaro(String ciudad);
	public List<Alerta> obtenerAlertasMeteorologicas(String ciudad);
	public void agregarObserver(AlertasObserver observer);

}
