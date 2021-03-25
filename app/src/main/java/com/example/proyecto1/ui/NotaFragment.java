package com.example.proyecto1.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto1.R;
import com.example.proyecto1.db.entity.NotaEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
//    private NotasInteractionListener mListener;
    private List<NotaEntity> notaEntityList;
    private MyNotaRecyclerViewAdapter adapterNotas;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
//            Evaluar direccion de pantalla y decidir el layout que se debe mostrar
            if (view.getId() == R.id.listPortrait)
                {
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                }else {
//                Forma para identificar el ancho y alto de la pantalla del dispositivo donde se ejecuta la APP
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
//                Ancho de la pantalla en pixeles
                float  dwith = displayMetrics.widthPixels / displayMetrics.density;
//                Definir el numero de columnas que pueden caber segun los pixeles de anchura
                int numeroColumnas = (int)(dwith / 180);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas,StaggeredGridLayoutManager.VERTICAL));
            }
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
////                Forma para identificar el ancho y alto de la pantalla del dispositivo donde se ejecuta la APP
//                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
////                Ancho de la pantalla en pixeles
//                float  dwith = displayMetrics.widthPixels / displayMetrics.density;
////                Definir el numero de columnas que pueden caber segun los pixeles de anchura
//                int numeroColumnas = (int)(dwith / 180);
//                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas,StaggeredGridLayoutManager.VERTICAL));
//            }
            notaEntityList = new ArrayList<>();
            notaEntityList.add(new NotaEntity("Lista de la compra","Comprar pan tostado",true, android.R.color.holo_blue_light));
            notaEntityList.add(new NotaEntity("Rocordar","Deje parqueado el carrro en la calle",false, android.R.color.holo_green_light));
            notaEntityList.add(new NotaEntity("¿De dónde viene?","El trozo estándar de lorem ipsum utilizado desde el siglo XVI se reproduce a continuación para los interesados. Las secciones 1.10.32 y 1.10.33 de \"Extremes of Good and Evil\" de Cicerón también se reproducen en su forma original exacta, acompañadas de versiones en inglés de la traducción de 1914 de H. Rackham.",true, android.R.color.holo_orange_light));
            notaEntityList.add(new NotaEntity("¿Por qué lo usamos?","Es un hecho establecido desde hace mucho tiempo que un lector se distraerá con el contenido legible de una página cuando mire su diseño. El objetivo de usar lorem ipsum es que tiene una distribución de letras más o menos normal, en lugar de usar 'Contenido aquí, contenido aquí', lo que hace que parezca un inglés legible.",false, android.R.color.holo_orange_light));
            notaEntityList.add(new NotaEntity("¿dónde conseguirlo?","Hay muchas variaciones de pasajes de lorem ipsum disponibles, pero la mayoría han sufrido alteraciones de alguna forma, por humor inyectado o palabras aleatorias que no parecen ni un poco creíbles. Si va a utilizar un pasaje de lorem ipsum, debe asegurarse de que no haya nada vergonzoso escondido en medio del texto. ",true, android.R.color.holo_blue_light));
//            notaList.add(new Nota("Lista de la compra","Comprar pan tostado",true, android.R.color.holo_blue_light));

            adapterNotas = new MyNotaRecyclerViewAdapter(notaEntityList,getActivity());
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof NotasInteractionListener){
//            mListener = (NotasInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + "must implement NotasInteractionListener");
//        }
//    }
}