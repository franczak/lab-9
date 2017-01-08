package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class IncidentalExpenses{
	private URL link;
	private String expense;
	public IncidentalExpenses(){
	}
	
	public String InciExp(String id) throws IOException{
			link = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/"+id+".json?layers[]=krs&layers[]=wydatki");
			Gson json = new Gson();
			WydatkiPojo pojo;
			pojo = json.fromJson(new JsonReader(new InputStreamReader(link.openStream())), WydatkiPojo.class);
			expense = pojo.getSpendings().getWydatki().getRoczniki()[0].getPola()[12].toString();
			return expense;
	}
}
