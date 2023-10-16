package utn.frba.disenio.tp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.services.GestorAlertas;
import utn.frba.disenio.tp.services.impl.entities.Alerta;

@Service
public class GestorAlertasImpl implements GestorAlertas {

	private List<Alerta> alertas = new ArrayList<Alerta>();
	
	@Override
	public List<Alerta> obtenerUltimasAlertasMeteorologicas(String ciudad) {
		List<Alerta> alertasAux = new ArrayList<Alerta>();
		alertasAux.addAll(this.alertas);
		return alertasAux;
	}

	@Override
	public void agregarAlertas(List<Alerta> alertas) {
		List<Alerta> alertasAux = new ArrayList<Alerta>();
		alertasAux.addAll(this.alertas);
		this.alertas=new ArrayList<Alerta>();
		this.alertas.addAll(alertas);
		this.alertas.addAll(alertasAux);
	}

}
