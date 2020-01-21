import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;//[]array
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;//[]array

public class JSON {
	static ArrayList<Jugador> lista = new ArrayList<Jugador>();
	static String id;

	public static ArrayList<Jugador> parsear() {
		//Preguntamos el nombre del jugador para completar la direccion
		System.out.println("Cual es el nombre del jugador");
		Scanner sc = new Scanner(System.in);
		id = sc.next();

		// TODOuto-generated method stub7
		URL url;
		try {
			//Se completa la direccion anadiendo el nombre del jugador
			url = new URL("https://www.easports.com/fifa/ultimate-team/api/fut/item?name=" + id);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputline = "";
			int responseCode = con.getResponseCode();

			StringBuffer response = new StringBuffer();
			while ((inputline = in.readLine()) != null) {
				response.append(inputline);

			}
			in.close();
			String global = response.toString();
			// System.out.println(global);
			JSONObject json = new JSONObject(global);
			//Nos colocamos en items (Es un JsonArray) para sacar todos los datos que necesitamos 
			JSONArray lista_jugadores = json.getJSONArray("items");
			//Inicializamos las variables
			int edad = 0,altura= 0,peso= 0,media= 0,regates= 0,weakfoot= 0,aceleracion= 0,tirofuerte= 0,resistencia= 0;
			String pos="", piernabuena="";
			for (int index = 0; index < lista_jugadores.length()-1; index++) {
				JSONObject objeto_pregunta = (JSONObject) lista_jugadores.get(index);
				//Aqui sacamos todos los datos que necesitamos
				 pos = objeto_pregunta.getString("position");
				 edad = objeto_pregunta.getInt("age");
				 altura = objeto_pregunta.getInt("height");
				 peso = objeto_pregunta.getInt("weight");
				 piernabuena = objeto_pregunta.getString("foot");
				 media = objeto_pregunta.getInt("rating");
				 regates = objeto_pregunta.getInt("skillMoves");
				 weakfoot = objeto_pregunta.getInt("weakFoot");
				 aceleracion = objeto_pregunta.getInt("acceleration");
				 tirofuerte = objeto_pregunta.getInt("shotpower");
				 resistencia = objeto_pregunta.getInt("stamina");
				//Unicamente los datos que no se van a estar repitiendo necesitamos añadirlos al objeto Jugador
				Jugador player = new Jugador(pos,  tirofuerte, aceleracion, resistencia, media);
				lista.add(player);

			}
			//Mostramos los datos que si que se repiten, como el nombre la edad o el peso.
			System.out.println("STATS GENERALES DE: " + id +"\n tiene una edad de:"  + edad + "\n Con una altura de: " + altura +   
					 "cm\n Con un peso de: " + peso + "Kg \n Pierna buena: " + piernabuena  + 
					 "\n Su habilidad con la pierna mala es: " + weakfoot + 
					 "/5\n Con habilidad de regate de: " + regates + "/5");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Devolvemos la lista de jugadores para mandarselo a la clase "Pantalla"
		return lista;

	}

	

}