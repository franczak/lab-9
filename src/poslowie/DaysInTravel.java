package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DaysInTravel {
	private URL link;
	private int days=0;
	DateTimeFormatter formatter=DateTimeFormat.forPattern("yyyy-MM-dd");
	private int tmp=0;
	
	public DaysInTravel(){
		
	}
	
	public int DaysInTrv(String id) throws IOException{

			link = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/"+id+".json?layers[]=krs&layers[]=wyjazdy");
			Gson json = new Gson();
			WyjazdyPojo pojo;
			 try {
			pojo = json.fromJson(new JsonReader(new InputStreamReader(link.openStream())), WyjazdyPojo.class);
			days=CountDays(pojo);
			return days;
			 }
			 catch(Exception e){
				 return 0;
			 }
			 
	}
	
	private int CountDays(WyjazdyPojo pojo){
		for(Wyjazdy dep : pojo.getDepartures().getWyjazdy()){
			DateTime from = formatter.parseDateTime(dep.getOd());
			DateTime to = formatter.parseDateTime(dep.getDo());
			tmp+=Days.daysBetween(from, to).getDays()+1;
			}
		
		return tmp;
		}

}
