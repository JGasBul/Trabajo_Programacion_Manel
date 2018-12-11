package educacion.trax.ciclosfloridaact;

import android.os.Parcel;
import android.os.Parcelable;

public class CicleFlorida implements Parcelable {
    private String familiaProfessional;
    private String tipus;
    private String titol;
    private String Descripcio;

    public CicleFlorida(String familiaProfessional, String tipus, String titol, String descripcio) {

        this.familiaProfessional = familiaProfessional;
        this.tipus = tipus;
        this.titol = titol;
        Descripcio = descripcio;
    }

    public String getFamiliaProfessional() {
        return familiaProfessional;
    }

    public void setFamiliaProfessional(String familiaProfessional) {
        this.familiaProfessional = familiaProfessional;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }

    protected CicleFlorida(Parcel in) {
        familiaProfessional = in.readString();
        tipus = in.readString();
        titol = in.readString();
        Descripcio = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(familiaProfessional);
        dest.writeString(tipus);
        dest.writeString(titol);
        dest.writeString(Descripcio);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CicleFlorida> CREATOR = new Parcelable.Creator<CicleFlorida>() {
        @Override
        public CicleFlorida createFromParcel(Parcel in) {
            return new CicleFlorida(in);
        }

        @Override
        public CicleFlorida[] newArray(int size) {
            return new CicleFlorida[size];
        }
    };
}