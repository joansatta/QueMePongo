package utn.frba.disenio.tp.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.frba.disenio.tp.services.AccuWeatherAdapter;
import utn.frba.disenio.tp.services.external.AccuWeatherAPI;
import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;
import utn.frba.disenio.tp.services.impl.entities.Temperatura;
import utn.frba.disenio.tp.utils.Utils;

@Service
public class AccuWeatherAdapterImpl implements AccuWeatherAdapter {

	@Autowired private AccuWeatherAPI accuWheatherApi;

	@SuppressWarnings("unchecked")
	public AccuWeatherResponse obtenerTemperaturaCompleta(String ciudad) {
		Map<String,Object> tempRes = accuWheatherApi.getWeather(ciudad).get(0);
		Map<String,Object> tempMap = (Map<String,Object>)tempRes.get("Temperature");
		AccuWeatherResponse res = new AccuWeatherResponse(
				Utils.stringToDate(tempRes.get("DateTime").toString(), "yyyy-MM-dd'T'HH:mm:ssXXX")
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
	public String[] obtenerAlertasMeteorologicas(String ciudad) {
		return (String[])accuWheatherApi.getAlerts(ciudad).get("CurrentAlerts");
	}

}
