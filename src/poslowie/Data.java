package poslowie;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("poslowie.nazwa")
    private String nazwa;

    public Data(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa ()
    {
        return nazwa;
}
}
