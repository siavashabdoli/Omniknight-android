package app.arsh.omniknightapp.model.entity;

/**
 * Created by arash on 10/18/16.
 */

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Translations implements Parcelable{

    @SerializedName("de")
    @Expose
    private String de;
    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("fr")
    @Expose
    private String fr;
    @SerializedName("ja")
    @Expose
    private String ja;
    @SerializedName("it")
    @Expose
    private String it;

    /**
     * @return The de
     */
    public String getDe() {
        return de;
    }

    /**
     * @param de The de
     */
    public void setDe(String de) {
        this.de = de;
    }

    public Translations withDe(String de) {
        this.de = de;
        return this;
    }

    /**
     * @return The es
     */
    public String getEs() {
        return es;
    }

    /**
     * @param es The es
     */
    public void setEs(String es) {
        this.es = es;
    }

    public Translations withEs(String es) {
        this.es = es;
        return this;
    }

    /**
     * @return The fr
     */
    public String getFr() {
        return fr;
    }

    /**
     * @param fr The fr
     */
    public void setFr(String fr) {
        this.fr = fr;
    }

    public Translations withFr(String fr) {
        this.fr = fr;
        return this;
    }

    /**
     * @return The ja
     */
    public String getJa() {
        return ja;
    }

    /**
     * @param ja The ja
     */
    public void setJa(String ja) {
        this.ja = ja;
    }

    public Translations withJa(String ja) {
        this.ja = ja;
        return this;
    }

    protected Translations(Parcel in){
        this.de = in.readString();
        this.es = in.readString();
        this.fr = in.readString();
        this.it = in.readString();
        this.ja = in.readString();
    }

    public static final Creator<Translations> CREATOR = new Creator<Translations>() {
        @Override
        public Translations createFromParcel(Parcel source) {
            return new Translations(source);
        }

        @Override
        public Translations[] newArray(int size) {
            return new Translations[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.es);
        parcel.writeString(this.ja);
        parcel.writeString(this.it);
        parcel.writeString(this.fr);
        parcel.writeString(this.de);
    }
}


