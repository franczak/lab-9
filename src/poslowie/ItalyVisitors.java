package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ItalyVisitors {
	private Map<String,String> meps = new HashMap<String,String>();
	private URL link;
	
	public ItalyVisitors(){
		
	}
	
	public void FindVisitors(int cadency) throws IOException{
		if(cadency==8){
			Meps8 mep=new Meps8();
			meps=mep.update8Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				if(SetName(entry.getValue())){
					System.out.println(entry.getKey());
				}
			}
		}else{
			Meps7 mep=new Meps7();
			meps=mep.update7Cadency();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				if(SetName(entry.getValue())){
					System.out.println(entry.getKey());
				}
			}
		}
}

	private boolean SetName(String id) throws IOException{
		link = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/"+id+".json?layers[]=krs&layers[]=wyjazdy");
		Gson json = new Gson();
		WyjazdyPojo pojo;
		 try {
		pojo = json.fromJson(new JsonReader(new InputStreamReader(link.openStream())), WyjazdyPojo.class);
		if(HasBeen(pojo))
			return true;
		else return false;
		 }
		 catch(Exception e){
			 return false;
		 }

}

	
	private boolean HasBeen(WyjazdyPojo pojo){
		for(Wyjazdy dep : pojo.getDepartures().getWyjazdy()){
			if(dep.getKraj().equals("W³ochy")){
				return true;
			}
		}
		return false;
	}
}
