package poslowie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MostDaysInTravel {
	private String name;
	private int max=0;
	private int z=0;
	private Map<String,String> meps = new HashMap<String,String>();
	private DaysInTravel pro;
	public MostDaysInTravel(){
		
	}
	
	public String FindName(String cadency) throws IOException{
		if(cadency.equals("8")){
			Meps8 mep=new Meps8();
			meps=mep.update8Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				pro=new DaysInTravel();
				z=0;
				z=pro.DaysInTrv(entry.getValue());
				if(z>max){
					max=z;
					name=entry.getKey();
			}
		}
		}else{
			Meps7 mep=new Meps7();
			meps=mep.update7Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				pro=new DaysInTravel();
				z=0;
				z=pro.DaysInTrv(entry.getValue());
				if(z>max){
					max=z;
					name=entry.getKey();
			}
		}
		}
		return name;
	}
}
