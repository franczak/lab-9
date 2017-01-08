package poslowie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MostExpensiveTravel {
	private Map<String,String> meps = new HashMap<String,String>();
	private TravelCost travel;
	private double tmp=0.0;
	public double max = 0.0;
	public String name;
	
	public MostExpensiveTravel(){
	}
	
	public String FindMostExpensive(int cadency) throws IOException{
		if(cadency==8){
			Meps8 mep=new Meps8();
			meps=mep.update8Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				travel=new TravelCost();
				tmp=travel.FindMaxCost(entry.getValue());
				if(tmp>max){
					max=tmp;
					name=entry.getKey();
			}
		}
	}
		else{
			Meps7 mep=new Meps7();
			meps=mep.update7Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				travel=new TravelCost();
				tmp=travel.FindMaxCost(entry.getValue());
				if(tmp>max){
					max=tmp;
					name=entry.getKey();
			}
		}
		}
	return name;	
	}
}
	

