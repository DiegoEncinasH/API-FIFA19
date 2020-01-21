import java.util.ArrayList;

public class Pantalla {

		public static void mostrar(ArrayList<Jugador> lista) {
			//Inicializamos una variable para numerar las cartas que tiene el jugador
			int var = 1;
			for (Jugador player : lista) {
				//Se muestran los datos que si varian del jugador, como la aceleracion o la potencia de tiro.
				System.out.println("La carta numero: " + var + " Con media de:  " + player.getMedia()+ "\n Juega en la posicion: " + player.getPos()	
				+ " \n Con una potencia de tiro de: " + player.getTirofuerte()
				+ "/100 \n Con una capacidad de aceleracion de : " + player.getAceleracion()
				+ "/100 \n Con una resistencia de: " + player.getResistencia() + "/100");
				var++;
			}
		}
}
