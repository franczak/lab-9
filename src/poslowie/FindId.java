package poslowie;

import java.util.HashMap;
import java.util.Map;

public class FindId {
	private String name;
	private Map<String,String> meps8 = new HashMap<String,String>();
	private Map<String,String> meps7 = new HashMap<String,String>();
	private boolean bool=false;
	public FindId(){
		
	}
	public String IdFromName(String firstName, String lastName) throws Exception{
			name=firstName+" "+lastName;
			Meps8 mep=new Meps8();
			meps8=mep.update8Cadency();
				for (Map.Entry<String, String> entry : meps8.entrySet()){
				if(name.equals(entry.getKey())){
					bool=true;
					return entry.getValue();
				}
				}
			if(!bool){
				Meps7 mep1=new Meps7();
				meps7 = mep1.update7Cadency();
				for (Map.Entry<String, String> entry : meps7.entrySet()){
				if(name.equals(entry.getKey())){
					return entry.getValue();
				}
				}
			}
	return "0";
}
}
