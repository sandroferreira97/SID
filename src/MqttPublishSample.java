
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublishSample implements MqttCallback {

	ArrayList<Medicao> medicoes = new ArrayList<>();
	Medicao m1 = new Medicao ("a", "b", "c", "d");
	String topic = "sid_lab_2018";
	String content = "Message from MqttPublishSample";
	int qos = 2;
	String broker = "tcp://iot.eclipse.org:1883";
	String clientId = "JavaSample";
	MqttClient sampleClient;

	public MqttPublishSample() {
		medicoes.add(m1);
		try {
			sampleClient = new MqttClient(broker, clientId);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + broker);
			sampleClient.connect(connOpts);
			System.out.println("Connected");
			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);
			sampleClient.setCallback(this);

			sampleClient.subscribe(topic);
			System.out.println("Subscribed to " + topic);
			try {
				System.in.read();
				System.out.println(123445);
			} catch (IOException e) {
			}
			sampleClient.disconnect();
			System.out.println("disconnected");
			System.exit(0);
		}catch(

	MqttException me)
	{
		System.out.println("reason " + me.getReasonCode());
		System.out.println("msg " + me.getMessage());
		System.out.println("loc " + me.getLocalizedMessage());
		System.out.println("cause " + me.getCause());
		System.out.println("excep " + me);
		me.printStackTrace();
	}
	}

	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		System.out.println(topic);
		System.out.println(arg1.toString());
		String[] msg = arg1.toString().split(",");
		System.out.println("ola");
		new MongoConnect(medicoes.get(medicoes.size() - 1));
		System.out.println("adeus");
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

}
