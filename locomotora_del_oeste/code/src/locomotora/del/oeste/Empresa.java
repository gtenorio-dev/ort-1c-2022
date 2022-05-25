package locomotora.del.oeste;

import java.util.ArrayList;

public class Empresa {

	// private static String TERMINAL = "Avellaneda 1241";

	private ArrayList<Vagon> vagonesLibres;
	private ArrayList<Tren> trenes;
	private ArrayList<Maquinista> maquinistas;

	public void armarTren(int cantidadCarga, int cantidadPasajeros, String destino, String dniMaquinista) {
		ArrayList<Vagon> locomotoras = dameVagones(TipoVagon.LOCOMOTORA, 1);
		ArrayList<Vagon> vagones = new ArrayList<>();

		if (!locomotoras.isEmpty()) {
			Vagon locomotora = locomotoras.get(0);

			ArrayList<Vagon> vagonesCarga = dameVagones(TipoVagon.CARGA, cantidadCarga);
			vagones.addAll(vagonesCarga);

			if (vagonesCarga.size() == cantidadCarga) {
				ArrayList<Vagon> vagonesPersona = dameVagones(TipoVagon.PASAJERO, cantidadPasajeros);
				vagones.addAll(vagonesPersona);

				if (vagonesPersona.size() == cantidadPasajeros) {
					Tren tren = new Tren(locomotora, destino);
					tren.agregarVagones(vagonesCarga);
					tren.agregarVagones(vagonesPersona);

					agregarTrenAMaquinista(dniMaquinista, tren);
					trenes.add(tren);

				} else {
					System.out.println("Vagones de Pasajeros insuficientes");
					devolverVagones(locomotora, vagones);
				}
			} else {
				System.out.println("Vagones de Carga insuficientes");
				devolverVagones(locomotora, vagones);
			}
		} else {
			System.out.println("No hay locomotoras");
		}
	}

	private void devolverVagones(Vagon locomotora, ArrayList<Vagon> vagones) {
		vagonesLibres.add(locomotora);

		for (Vagon vagon : vagones) {
			vagonesLibres.add(vagon);
		}
	}

	public void armarTrenClasico(String destino, String dniMaquinista) {
		armarTren(0, 8, destino, dniMaquinista);
	}

	private void agregarTrenAMaquinista(String dniMaquinista, Tren tren) {
		Maquinista maquinista = dameMaquinista(dniMaquinista);

		if (maquinista != null && maquinista.getTren() == null) {
			maquinista.setTren(tren);
		} else {
			System.out.println("Maquinista no quiere laburar");
		}
	}

	private Maquinista dameMaquinista(String dniMaquinista) {
		Maquinista maquinistaRes = null;
		int i = 0;
		boolean encontreMaquinista = false;
		while (i < maquinistas.size() && !encontreMaquinista) {
			Maquinista maquinista = maquinistas.get(i);

			if (maquinista.getDni().equals(dniMaquinista)) {
				maquinistaRes = maquinista;
				encontreMaquinista = true;
			}
			i++;
		}
		return maquinistaRes;
	}

	private ArrayList<Vagon> dameVagones(TipoVagon tipo, int cantidad) {
		ArrayList<Vagon> vagones = new ArrayList<>();
		int i = 0;
		int cantAgregados = 0;
		while (i < vagonesLibres.size() && cantAgregados < cantidad) {
			Vagon vagon = vagonesLibres.get(i);

			if (vagon.getTipo().equals(tipo) && !vagon.enReparacion()) {
				vagones.add(vagon);
				cantAgregados++;
				vagonesLibres.remove(vagon);
			}
			i++;
		}
		return vagones;
	}

}
