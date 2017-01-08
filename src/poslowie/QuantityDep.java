package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class QuantityDep {
	private int quantity=0;
	private URL link;
	public QuantityDep(){
	}
	
	public int CountDep(int id) throws IOException{
		try{
		link = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/"+id+".json?layers[]=krs&layers[]=wyjazdy");
		Gson json = new Gson();
		WyjazdyPojo pojo;
		pojo = json.fromJson(new JsonReader(new InputStreamReader(link.openStream())), WyjazdyPojo.class);
		quantity=pojo.getDepartures().getWyjazdy().length;
		return quantity;
		} catch(Exception e){
			return 0;
		}
		
	}
	
}
