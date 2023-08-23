package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Prenda {
	
	@NonNull private CategoriaEnum categoria;
	@NonNull private Composicion composicion;
	@NonNull private Tipo tipo;
	@NonNull private Color colorPrimario;
	private Color colorSecundario;

	public String getComposicion() {
		return this.composicion.getDescripcion();
	}	
	
	public String getTipo() {
		return this.tipo.getDescripcion();
	}	
	
	public String getColorPrimario() {
		return this.colorPrimario.getDescripcion();
	}
	
	public String getColorSecundario() {
		return this.colorSecundario!=null?this.colorSecundario.getDescripcion():null;
	}
	
}
