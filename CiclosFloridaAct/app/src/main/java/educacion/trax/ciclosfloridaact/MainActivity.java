package educacion.trax.ciclosfloridaact;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellIdentityLte;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements Titulaciones.OnFragmentInteractionListener,Ciclos.OnFragmentInteractionListener{
    ArrayList<CicleFlorida> llistat_titulacions;
    ArrayList<CicleFlorida> esports_array;
    ArrayList<CicleFlorida> inf_array;
    ArrayList<CicleFlorida> empresa_array;
    FragmentManager fm;
    Fragment tit;
    Fragment ciclo;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creaDades();
        fm = getFragmentManager();
        tit = fm.findFragmentById(R.id.titulaciones);

    }

    @Override
    public void empresaListener() {
        int temp=-1;
        Boolean mitja=false;
        Boolean sup=false;
        Iterator it=llistat_titulacions.iterator();
        empresa_array=new ArrayList<CicleFlorida>();
        while (it.hasNext()){
            CicleFlorida c= (CicleFlorida) it.next();
            if (c.getFamiliaProfessional().equalsIgnoreCase("EMPRESA")){
                empresa_array.add(c);
            }
        }
        Iterator it2=empresa_array.iterator();
        while (it2.hasNext()) {
            CicleFlorida c = (CicleFlorida) it2.next();
            if (c.getTipus().equalsIgnoreCase("Mitjà")) {
                mitja = true;
            }
            if (c.getTipus().equalsIgnoreCase("Superior")) {
                sup = true;
            }
        }
        if (mitja==true && sup==true){
            temp=2;
        }else if (sup==true){
            temp=1;
        }else {
            temp=0;
        }
        ciclo=Ciclos.newInstance(empresa_array,temp);
        FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.tipos_ciclo,ciclo);
        ft.commit();
    }

    @Override
    public void infListener() {
        int temp=-1;
        Boolean mitja=false;
        Boolean sup=false;
        id=1;
        Iterator it=llistat_titulacions.iterator();
        inf_array=new ArrayList<CicleFlorida>();
        while (it.hasNext()){
            CicleFlorida c= (CicleFlorida) it.next();
            if (c.getFamiliaProfessional().equalsIgnoreCase("INFORMÀTICA")){
                inf_array.add(c);
            }
        }
        Iterator it2=inf_array.iterator();
        while (it2.hasNext()) {
            CicleFlorida c = (CicleFlorida) it2.next();
            if (c.getTipus().equalsIgnoreCase("Mitjà")) {
                mitja = true;
            }
            if (c.getTipus().equalsIgnoreCase("Superior")) {
                sup = true;
            }
        }
        if (mitja==true && sup==true){
            temp=2;
        }else if (sup==true){
            temp=1;
        }else {
            temp=0;
        }
        ciclo=Ciclos.newInstance(inf_array,temp);
        FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.tipos_ciclo,ciclo);
        ft.commit();
    }

    @Override
    public void esportsListener() {
        int temp=-1;
        Boolean mitja=false;
        Boolean sup=false;
        id=2;
        Iterator it=llistat_titulacions.iterator();
        esports_array=new ArrayList<CicleFlorida>();
        while (it.hasNext()){
            CicleFlorida c= (CicleFlorida) it.next();
            if (c.getFamiliaProfessional().equalsIgnoreCase("ESPORT")){
                esports_array.add(c);
            }
        }
        Iterator it2=esports_array.iterator();
        while (it2.hasNext()) {
            CicleFlorida c = (CicleFlorida) it2.next();
            if (c.getTipus().equalsIgnoreCase("Mitjà")) {
                mitja = true;
            }
            if (c.getTipus().equalsIgnoreCase("Superior")) {
                sup = true;
            }
        }
        if (mitja==true && sup==true){
            temp=2;
        }else if (sup==true){
            temp=1;
        }else {
            temp=0;
        }
        ciclo=Ciclos.newInstance(esports_array,temp);
        FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.tipos_ciclo,ciclo);
        ft.commit();
    }
    @Override
    public void mitjaListener() {

    }

    @Override
    public void supListener() {

    }

    public void creaDades(){
        CicleFlorida c;
        llistat_titulacions= new ArrayList<CicleFlorida>();
        c = new CicleFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        llistat_titulacions.add(c);
    }


}

