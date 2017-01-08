package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Meps8 {
	private MyPojo json;
    private Map<String, String> nameMap8 = new HashMap<String, String>();


    public Meps8 (){
    }
    
   public Map<String,String> update8Cadency() throws IOException {
        String link = "https:\\//api-v3.mojepanstwo.pl\\/dane\\/poslowie.json?conditions[poslowie.kadencja]=8";
        createObject(link);
        while(json.getLinks().getNext()!=null) {
            addJsonToMap(nameMap8);
            createObject(json.getLinks().getNext());
        }
        addJsonToMap(nameMap8);
        return nameMap8;
}
    private void createObject(String link) throws IOException {
        URL url = new URL(fixLink(link));
        Gson gson = new Gson();
        json = gson.fromJson(new JsonReader(new InputStreamReader(url.openStream())), MyPojo.class);
}
    private void addJsonToMap(Map<String, String> map) {
        for (int i = 0; i < json.getDataobject().length; i++) {
            map.put(json.getDataobject()[i].getData().getNazwa(), json.getDataobject()[i].getId());
        }
    }
    private String fixLink(String link){
        String fixed = link.replace("\\/", "/");
        return fixed;
    }
    
}