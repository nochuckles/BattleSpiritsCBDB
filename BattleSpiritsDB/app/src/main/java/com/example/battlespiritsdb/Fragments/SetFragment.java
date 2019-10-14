package com.example.battlespiritsdb.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.battlespiritsdb.Card;
import com.example.battlespiritsdb.CardViewModel;
import com.example.battlespiritsdb.NameAdapter;
import com.example.battlespiritsdb.R;
import com.example.battlespiritsdb.RarityAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.example.battlespiritsdb.MainActivity.hideSystemBars;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RarityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RarityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String CB02 = "Collaboration Booster (Digimon Super-Digivolution!)";
    private static final String CB03 = "Collaboration Booster (Digimon Super-Digivolution! Ver. 1.5)";
    private static final String CB05 = "Collaboration Booster (Our Digimon Adventure!";
    private static final String CB07 = "Collaboration Booster (Digimon - Settle it! Card Slash!)";
    private static final String PROMOS = "Promos";
    private static final String SD45 = "Collaboration Starter (The Chosen Children)";
    private static final String BSBG = "Battle Spirits Battler's Goods Set: Digimon";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private CardViewModel cardViewModel;
    private View decorView;
    private LinearLayoutManager layoutManager;
    private boolean isFABOpen = false;
    private FloatingActionButton cb02, cb03, cb05, cb07, promos, sd45, bsbg;

    public SetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RarityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetFragment newInstance(String param1, String param2) {
        SetFragment fragment = new SetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        final RarityAdapter adapter = new RarityAdapter();
        recyclerView.setAdapter(adapter);

        cardViewModel = ViewModelProviders.of(this).get(CardViewModel.class);
        cardViewModel.sortBySet(CB02).observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                adapter.submitList(cards);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        cb02 = (FloatingActionButton) view.findViewById(R.id.cb02);
        cb03 = (FloatingActionButton) view.findViewById(R.id.cb03);
        cb05 = (FloatingActionButton) view.findViewById(R.id.cb05);
        cb07 = (FloatingActionButton) view.findViewById(R.id.cb07);
        promos = (FloatingActionButton) view.findViewById(R.id.promos);
        sd45 = (FloatingActionButton) view.findViewById(R.id.sd45);
        bsbg = (FloatingActionButton) view.findViewById(R.id.bsbg);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }

            }
        });

        cb02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortBySet(CB02).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(cb02);

            }
        });

        cb03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortBySet(CB03).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(cb03);

            }
        });

        cb05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortBySet(CB05).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(cb05);
            }
        });

        cb07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortBySet(CB07).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(cb07);
            }
        });

        promos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortBySet(PROMOS).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(promos);
            }
        });

        sd45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortBySet(SD45).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(sd45);
            }
        });

        bsbg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortBySet(BSBG).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(bsbg);
            }
        });



        return view;
    }

    private void showFABMenu() {
        isFABOpen = true;
        cb02.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        cb03.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        cb05.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
        cb07.animate().translationY(-getResources().getDimension(R.dimen.standard_205));
        promos.animate().translationY(-getResources().getDimension(R.dimen.standard_255));
        sd45.animate().translationY(-getResources().getDimension(R.dimen.standard_305));
        bsbg.animate().translationY(-getResources().getDimension(R.dimen.standard_355));

    }

    private void closeFABMenu() {
        isFABOpen = false;
        cb02.animate().translationY(0);
        cb03.animate().translationY(0);
        cb05.animate().translationY(0);
        cb07.animate().translationY(0);
        promos.animate().translationY(0);
        sd45.animate().translationY(0);
        bsbg.animate().translationY(0);

    }

    private void changeColor(FloatingActionButton button) {
        cb02.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        cb03.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        cb05.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        cb07.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        promos.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        bsbg.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        sd45.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));

        button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        void onFragmentInteraction(Uri uri);
    }
}
