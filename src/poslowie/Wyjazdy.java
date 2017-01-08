package poslowie;

import com.google.gson.annotations.SerializedName;

public class Wyjazdy {

    private String kraj;

    private String od;
    @SerializedName("koszt_suma")
    private String kosztSuma;

    @SerializedName("do")
    private String Do;

    public String getKraj ()
    {
        return kraj;
    }

    public void setKraj (String kraj)
    {
        this.kraj = kraj;
    }

    public String getOd ()
    {
        return od;
    }

    public void setOd (String od)
    {
        this.od = od;
    }

    public String getDo ()
    {
        return Do;
    }

    public void setDo (String Do)
    {
        this.Do = Do;
    }
    public String getKosztSuma ()
    {
        return kosztSuma;
    }

    public void setKosztSuma (String kosztSuma)
    {
        this.kosztSuma = kosztSuma;
    }
}