package educacion.trax.ciclosfloridaact;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Ciclos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Ciclos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ciclos extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // TODO: Rename and change types of parameters
    private OnFragmentInteractionListener mListener;
    private ArrayList<CicleFlorida> listado;
    private int ciclo;

    public Ciclos() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Ciclos newInstance(ArrayList array,int x) {
        Ciclos fragment = new Ciclos();
        Bundle args = new Bundle();
        args.putInt("ciclo",x);
        args.putParcelableArrayList("listado",array);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listado = getArguments().getParcelableArrayList("listado");
            ciclo = getArguments().getInt("ciclo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_ciclos, container, false);
        final Button mitja=v.findViewById(R.id.mitja);
        mitja.setOnClickListener(this);
        final Button sup=v.findViewById(R.id.sup);
        sup.setOnClickListener(this);
        if (ciclo==0){
            sup.setVisibility(View.INVISIBLE);
        }else if (ciclo==1){
            mitja.setVisibility(View.INVISIBLE);
        }
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

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.mitja){
            mListener.mitjaListener();
        }
        if (v.getId()==R.id.sup){
            mListener.supListener();
        }

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
        void mitjaListener();
        void supListener();
    }
}
