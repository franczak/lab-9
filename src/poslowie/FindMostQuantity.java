package poslowie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FindMostQuantity {
	private String name;
	private int max=0;
	private int z=0;
	private Map<String,String> meps = new HashMap<String,String>();
	QuantityDep dep;
	public String FindName(String cadency) throws IOException{
		if(cadency.equals("8")){
			Meps8 mep=new Meps8();
			meps=mep.update8Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				dep=new QuantityDep();
				z=0;
				z=dep.CountDep(Integer.parseInt(entry.getValue()));
				if(z>max){
					max=z;
					name=entry.getKey();
			}
		}
		}else{
				Meps7 mep=new Meps7();
				meps=mep.update7Cadency();
				for (Map.Entry<String, String> entry : meps.entrySet()){
					dep=new QuantityDep();
					z=0;
					z=dep.CountDep(Integer.parseInt(entry.getValue()));
					if(z>max){
						max=z;
						name=entry.getKey();
					}
				}
		}
		return name;
	
	}
}

