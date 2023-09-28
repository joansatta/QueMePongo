package utn.frba.disenio.tp.services.impl.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccuWeatherResponse {
	
	private Date fecha;
	private Boolean diaClaro;
	private Integer probabilidadLluvia;
	private Temperatura temperatura;

}
