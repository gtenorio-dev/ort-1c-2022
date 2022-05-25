package locomotora.del.oeste;

import java.util.ArrayList;

public class Tren {

	private ArrayList<Vagon> vagones;
	private String destino;

	public Tren(Vagon locomotora, String destino) {
		vagones = new ArrayList<>();
		agregarVagon(locomotora);

		this.destino = destino;
	}

	private void agregarVagon(Vagon vagon) {
		vagones.add(vagon);
	}

	public void agregarVagones(ArrayList<Vagon> vagones) {
		for (Vagon vagon : vagones) {
			agregarVagon(vagon);
		}
	}

}
