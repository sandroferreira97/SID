import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.mongodb.DBObject;

public class Medicao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String temperatura = new String();
	private String humidade = new String(); 
	private java.sql.Date Ddata ;
	private java.sql.Timestamp Thora ;
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
		String x = info.split(",")[3].split(":")[1].split("'")[1].split("/")[2] + "-" + info.split(",")[3].split(":")[1].split("'")[1].split("/")[1] + "-" + info.split(",")[3].split(":")[1].split("'")[1].split("/")[0];
		String y = info.split(",")[4].split(" : \"'")[1].replaceAll("'\" }", "");
		this.temperatura = info.split(",")[1].split(":")[1];
		this.humidade = info.split(",")[2].split(":")[1];
		this.Ddata = Date.valueOf(x);
		this.Thora = Timestamp.valueOf(x + " " + y);
		
		System.out.println(temperatura);
		System.out.println(humidade);
		System.out.println(Ddata);
		System.out.println(Thora);
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


	public java.sql.Date getDdata() {
		return Ddata;
	}
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public java.sql.Timestamp getTHora() {
		return Thora;
	}
	
	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	
}
