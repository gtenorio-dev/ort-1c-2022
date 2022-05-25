package locomotora.del.oeste;

public class Vagon {

	private String numeroSerie;
	private boolean enReparacion;
	private TipoVagon tipo;

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public boolean enReparacion() {
		return enReparacion;
	}

	public void setEnReparacion(boolean enReparacion) {
		this.enReparacion = enReparacion;
	}

	public TipoVagon getTipo() {
		return tipo;
	}

	public void setTipo(TipoVagon tipo) {
		this.tipo = tipo;
	}

}
