package utn.frba.disenio.tp.services.impl.entities;

import java.util.Date;

import lombok.NonNull;
import lombok.Getter;

@Getter
public class AccuWeatherResponse {
	
	@NonNull private Date fecha;
	@NonNull private Boolean diaClaro;
	@NonNull private Integer probabilidadLluvia;
	@NonNull private Temperatura temperatura;

	public Date getFecha() {
		return new Date(fecha.getTime());
	}
	
	public Temperatura getTemperatura() {
		return temperatura.clonar();
	}

	public AccuWeatherResponse(@NonNull Date fecha, @NonNull Boolean diaClaro, @NonNull Integer probabilidadLluvia, @NonNull Temperatura temperatura) {
		super();
		this.fecha = new Date(fecha.getTime());
		this.diaClaro = diaClaro;
		this.probabilidadLluvia = probabilidadLluvia;
		this.temperatura = temperatura.clonar();
	}
	
	

}
