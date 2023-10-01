package utn.frba.disenio.tp.services;

import java.util.Date;

import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;

public interface AccuWeatherAdapter {

	public AccuWeatherResponse obtenerTemperaturaCompleta(String ciudad);
	public Integer obtenerTemperaturaFarenheit(String ciudad);
	public String obtenerUnidadTemperatura(String ciudad);
	public Integer obtenerTipoUnidad(String ciudad);
	public Date obtenerFecha(String ciudad);
	public Boolean esDiaClaro(String ciudad);
	public String[] obtenerAlertasMeteorologicas(String ciudad);

}
