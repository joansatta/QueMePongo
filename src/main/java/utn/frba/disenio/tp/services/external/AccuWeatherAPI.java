package utn.frba.disenio.tp.services.external;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface AccuWeatherAPI {

	public List<Map<String, Object>> getWeather(String ciudad);

}
