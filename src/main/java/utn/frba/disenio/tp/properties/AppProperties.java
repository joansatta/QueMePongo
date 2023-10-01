package utn.frba.disenio.tp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

//@Setter
@Getter
@Component
public class AppProperties {

	@Value("${api.formato.fecha}") private String apiFormatoFecha;
}
