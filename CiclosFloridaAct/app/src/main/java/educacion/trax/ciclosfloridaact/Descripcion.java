package educacion.trax.ciclosfloridaact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Descripcion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Descripcion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Descripcion extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // TODO: Rename and change types of parameters
    private ArrayList<CicleFlorida> datos;
    private LinearLayout datos_layout;
    private OnFragmentInteractionListener mListener;
    private View v;

    public Descripcion() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Descripcion newInstance(ArrayList datos) {
        Descripcion fragment = new Descripcion();
        Bundle args = new Bundle();
        args.putParcelableArrayList("datos",datos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            datos = getArguments().getParcelableArrayList("datos");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_descripcion, container, false);
        datos_layout=v.findViewById(R.id.datos_layout);
        darValor();
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void darValor(){
        int num=1;
        TextView texto = new TextView(getContext());
        texto.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        String mensaje;
        Iterator it=datos.iterator();
        while (it.hasNext()){

            CicleFlorida c= (CicleFlorida) it.next();
            mensaje=num+": Nombre: "+c.getTitol()+". Descripción: "+c.getDescripcio();
            texto.setText(texto.getText()+"\n"+"\n"+mensaje);
            num++;
        }
        datos_layout.addView(texto);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

    }
}
