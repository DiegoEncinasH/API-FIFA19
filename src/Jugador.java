
public class Jugador {
	//Objeto Jugador con las estadisticas que son variables en funcion de la carta del jugador
	private String pos;
	private int tirofuerte;
	private int aceleracion;
	private int resistencia;
	private int media;
	
	public Jugador(String pos, int tirofuerte, int aceleracion, int resistencia, int media) {
		super();
		this.pos = pos;
		this.tirofuerte = tirofuerte;
		this.aceleracion = aceleracion;
		this.resistencia = resistencia;
		this.media = media;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public int getTirofuerte() {
		return tirofuerte;
	}
	public void setTirofuerte(int tirofuerte) {
		this.tirofuerte = tirofuerte;
	}
	public int getAceleracion() {
		return aceleracion;
	}
	public void setAceleracion(int aceleracion) {
		this.aceleracion = aceleracion;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	public int getMedia() {
		return media;
	}
	public void setMedia(int media) {
		this.media = media;
	}
	
}
	
	
	