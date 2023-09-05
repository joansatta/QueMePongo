package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Tipo implements Cloneable {

	@NonNull private String descripcion;
	@NonNull private CategoriaEnum categoria;
	@NonNull private Trama trama;

	public Tipo clone() {
		try {
			trama = trama.clone();
			return (Tipo)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
