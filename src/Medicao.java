import java.io.Serializable;

import com.mongodb.DBObject;

public class Medicao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public Medicao(DBObject a) {
		String info = a.toString();
		this.temperatura = info.split(",")[1].split(":")[1].replace("'", "").replace(" ","");
		this.humidade = info.split(",")[2].split(":")[1].replace("'", "").replace(" ","");
		this.data = info.split(",")[3].split(":")[1].replace("'", "").replace(" ","");
		this.hora = (info.split(",")[4].split(":")[1]+info.split(",")[4].split(":")[2]+info.split(",")[4].split(":")[3]).replace("}","").replace("'", "").replace(" ","");
		
		System.out.println(temperatura);
		System.out.println(humidade);
		System.out.println(data);
		System.out.println(hora);
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
