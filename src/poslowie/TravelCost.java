package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class TravelCost {
	private double cost=0.0;
	private double tmp=0.0;
	private URL link;
	private double max=0.0;
	
	public TravelCost(){
		
	}
	
	public double FindMaxCost(String id) throws IOException{
		link = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/"+id+".json?layers[]=krs&layers[]=wyjazdy");
		Gson json = new Gson();
		WyjazdyPojo pojo;
		 try {
		pojo = json.fromJson(new JsonReader(new InputStreamReader(link.openStream())), WyjazdyPojo.class);
		cost=MaxCost(pojo);
		return cost;
		 }
		 catch(Exception e){
			 return 0.0;
		 }
	}
	
	private double MaxCost(WyjazdyPojo pojo){
		for(Wyjazdy dep : pojo.getDepartures().getWyjazdy()){
			tmp=Double.parseDouble(dep.getKosztSuma());
			if(tmp>max){
				max=tmp;
			}
		}
		return max;
	}
}
