package poslowie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AvgExpenses {
	private Map<String,String> meps = new HashMap<String,String>();
	private String cadency="0";
	private double avg=0.0;
	private int i=0;
	AllExpenses posel=new AllExpenses();
	
	public AvgExpenses(String cadency){
		this.cadency=cadency;
	}
	
	public double AverageExpenses() throws IOException{
		if(cadency.equals("8")){
			Meps8 mep=new Meps8();
			meps=mep.update8Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				i++;
				avg+=posel.AllExp(entry.getValue());
			}
		}
		if(cadency.equals("7")){
			Meps7 mep=new Meps7();
			meps=mep.update7Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				i++;
				avg+=posel.AllExp(entry.getValue());
			}
		}
	return avg/i;
	}
}
