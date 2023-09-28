package utn.frba.disenio.tp.services;

import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;

public interface AccuWeatherAdapter {

	public AccuWeatherResponse obtenerTemperatura(String ciudad);
}
