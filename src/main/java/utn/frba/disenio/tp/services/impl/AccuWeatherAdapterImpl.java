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

	public AccuWeatherResponse obtenerTemperatura(String ciudad) {
		Map<String,Object> tempRes = accuWheatherApi.getWeather(ciudad).get(0);
		AccuWeatherResponse res = new AccuWeatherResponse();
		res.setDiaClaro((Boolean)tempRes.get("IsDaylight"));
		res.setFecha(Utils.stringToDate(tempRes.get("DateTime").toString(), "yyyy-MM-dd'T'HH:mm:ssXXX"));
		res.setProbabilidadLluvia(Integer.parseInt(tempRes.get("PrecipitationProbability").toString()));
		@SuppressWarnings("unchecked")
		Map<String,Object> tempMap = (Map<String,Object>)tempRes.get("Temperature");
		Temperatura temperatura = new Temperatura();
		temperatura.setTipoUnidad(Integer.parseInt(tempMap.get("UnitType").toString()));
		temperatura.setValor(Integer.parseInt(tempMap.get("Value").toString()));
		temperatura.setUnidad(tempMap.get("Unit").toString());
		res.setTemperatura(temperatura);
		return res;
	}

}
