
public class Medicao {

	private String temperatura = new String();
	private String humidade = new String(); 
	private String data = new String(); 
	private String hora = new String();
	
	
	public Medicao(String temperatura, String humidade, String data, String hora) {
		this.temperatura = temperatura;
		this.humidade = humidade;
		this.data = data;
		this.hora = hora;
	}


	@Override
	public String toString() {
		return  "temperatura: "+temperatura+" humidade:"+humidade+" data:"+data+" hora:"+hora;
	}


	public String getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}


	public String getHumidade() {
		return humidade;
	}


	public void setHumidade(String humidade) {
		this.humidade = humidade;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	
}
