package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class AllExpenses {
	private URL link;
	private double exp=0.0;
	public AllExpenses(){
	}
	
	public double AllExp(String id) throws IOException{
			link = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/"+id+".json?layers[]=krs&layers[]=wydatki");
			Gson json = new Gson();
			WydatkiPojo pojo;
			pojo = json.fromJson(new JsonReader(new InputStreamReader(link.openStream())), WydatkiPojo.class);
			exp=SumRoczniki(pojo);
			return exp;
	}
	
	private double SumRoczniki(WydatkiPojo pojo){
		double exp=0.0;
		for(Roczniki rocz : pojo.getSpendings().getWydatki().getRoczniki()){
			exp=exp+SumPola(rocz);
		}
		return exp;
	}
	
	private double SumPola(Roczniki rocz){
		double exp=0.0;
		for(int i=0; i<rocz.getPola().length; i++)
		exp+=Double.parseDouble(rocz.getPola()[i]);
		return exp;
	}
	
}

