package utn.frba.disenio.tp.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.properties.AppProperties;
import utn.frba.disenio.tp.services.AccuWeatherAdapter;
import utn.frba.disenio.tp.services.GestorAlertas;
import utn.frba.disenio.tp.services.external.AccuWeatherAPI;
import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;
import utn.frba.disenio.tp.services.impl.entities.Alerta;
import utn.frba.disenio.tp.services.impl.entities.Temperatura;
import utn.frba.disenio.tp.utils.Utils;

@Service
public class AccuWeatherAdapterImpl implements AccuWeatherAdapter {

	@Autowired private AccuWeatherAPI accuWheatherApi;
	@Autowired private AppProperties prop;
	@Autowired private GestorAlertas gestorAlertas;

	@SuppressWarnings("unchecked")
	public AccuWeatherResponse obtenerTemperaturaCompleta(String ciudad) {
		Map<String,Object> tempRes = accuWheatherApi.getWeather(ciudad).get(0);
		Map<String,Object> tempMap = (Map<String,Object>)tempRes.get("Temperature");
		AccuWeatherResponse res = new AccuWeatherResponse(
				Utils.stringToDate(tempRes.get("DateTime").toString(), prop.getApiFormatoFecha())
				,(Boolean)tempRes.get("IsDaylight")
				,Integer.parseInt(tempRes.get("PrecipitationProbability").toString())
				,new Temperatura(
						Integer.parseInt(tempMap.get("Value").toString())
						,tempMap.get("Unit").toString()
						,Integer.parseInt(tempMap.get("UnitType").toString())
						)
				);
		return res;
	}

	@Override
	public Integer obtenerTemperaturaFarenheit(String ciudad) {
		return obtenerTemperaturaCompleta(ciudad).getTemperatura().getValor();
	}

	@Override
	public List<Alerta> obtenerAlertasMeteorologicas(String ciudad) {
		String[] alertasAux = (String[])accuWheatherApi.getAlerts(ciudad).get("CurrentAlerts");
		Date fechaConsulta = new Date();
		List<Alerta> alertas = new ArrayList<Alerta>();
		for(String alertaDesc:alertasAux) {
			alertas.add(new Alerta(fechaConsulta, alertaDesc));
		}
		gestorAlertas.agregarAlertas(alertas);
		return alertas;
	}

	@Override
	public String obtenerUnidadTemperatura(String ciudad) {
		return obtenerTemperaturaCompleta(ciudad).getTemperatura().getUnidad();
	}

	@Override
	public Integer obtenerTipoUnidad(String ciudad) {
		return obtenerTemperaturaCompleta(ciudad).getTemperatura().getTipoUnidad();
	}

	@Override
	public Boolean esDiaClaro(String ciudad) {
		return obtenerTemperaturaCompleta(ciudad).getDiaClaro();
	}

	@Override
	public Date obtenerFecha(String ciudad) {
		return obtenerTemperaturaCompleta(ciudad).getFecha();
	}

}
