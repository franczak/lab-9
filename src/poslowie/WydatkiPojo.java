package poslowie;

import com.google.gson.annotations.SerializedName;

public class WydatkiPojo {
        @SerializedName("layers")
        private WydatkiObject wydatkiobj;

        public WydatkiObject getSpendings ()
        {
            return wydatkiobj;
        }

        public void setLayers (WydatkiObject layers)
        {
            this.wydatkiobj = layers;
        }

}

