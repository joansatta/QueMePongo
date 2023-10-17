package utn.frba.disenio.tp.services;

import java.util.List;

import utn.frba.disenio.tp.services.impl.entities.Alerta;

public interface HistorialAlertas {

	public List<Alerta> obtenerUltimasAlertasMeteorologicas(String ciudad);
	public void agregarAlertas(List<Alerta> alertas);
	
}
