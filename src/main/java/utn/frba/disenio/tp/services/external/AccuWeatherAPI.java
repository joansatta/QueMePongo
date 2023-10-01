package utn.frba.disenio.tp.services.external;

import java.util.List;
import java.util.Map;

public interface AccuWeatherAPI {

	public List<Map<String, Object>> getWeather(String ciudad);
	public Map<String, Object> getAlerts(String ciudad);


}
