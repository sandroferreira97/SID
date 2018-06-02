import java.util.Timer;
import java.util.TimerTask;
public class teste {

	public static void main(String[] args) {
		
		int MINUTES = 2; 
		Timer timer = new Timer();
		 timer.schedule(new TimerTask() {
		    @Override
		    public void run() { 
		    	Sbc a =new Sbc("dba","sql");
		    }
		 }, 0, 1000 * 60 * MINUTES);
		
		
	}
	
	
	
}
