package utn.frba.disenio.tp.services;

import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;

public interface AccuWeatherAdapter {

	public AccuWeatherResponse obtenerTemperaturaCompleta(String ciudad);
	public Integer obtenerTemperaturaFarenheit(String ciudad);

}
