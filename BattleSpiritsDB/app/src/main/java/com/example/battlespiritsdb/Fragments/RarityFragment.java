package com.example.battlespiritsdb.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
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
public class RarityFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String NONE = "NONE";
    private static final String COMMON = "COMMON";
    private static final String UNCOMMON = "UNCOMMON";
    private static final String RARE = "RARE";
    private static final String MASTER_RARE = "MASTER RARE";
    private static final String X_RARE = "X RARE";
    private static final String XX_RARE = "XX RARE";
    private static final String SECRET = "SECRET";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private CardViewModel cardViewModel;
    private View decorView;
    private LinearLayoutManager layoutManager;
    private String Rarity = XX_RARE;
    private boolean isFABOpen = false;
    private FloatingActionButton none, common, uncommon, rare, master_rare, x_rare, xx_rare, secret;

    public RarityFragment() {
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
    public static RarityFragment newInstance(String param1, String param2) {
        RarityFragment fragment = new RarityFragment();
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
        View view = inflater.inflate(R.layout.fragment_rarity, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        final RarityAdapter adapter = new RarityAdapter();
        recyclerView.setAdapter(adapter);

        cardViewModel = ViewModelProviders.of(this).get(CardViewModel.class);
        cardViewModel.sortByRarity(Rarity).observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                adapter.submitList(cards);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        none = (FloatingActionButton) view.findViewById(R.id.none);
        common = (FloatingActionButton) view.findViewById(R.id.common);
        uncommon = (FloatingActionButton) view.findViewById(R.id.uncommon);
        rare = (FloatingActionButton) view.findViewById(R.id.rare);
        master_rare = (FloatingActionButton) view.findViewById(R.id.master_rare);
        x_rare = (FloatingActionButton) view.findViewById(R.id.x_rare);
        xx_rare = (FloatingActionButton) view.findViewById(R.id.xx_rare);
        secret = (FloatingActionButton) view.findViewById(R.id.secret);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen) {
                    showFABMenu();
                } else{
                    closeFABMenu();
                }

            }
        });

        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rarity = NONE;
                adapter.notifyDataSetChanged();
            }
        });

        decorView = getActivity().getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0) {
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });

        return view;
    }

    private void showFABMenu() {
        isFABOpen = true;
        none.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        common.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        uncommon.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
        rare.animate().translationY(-getResources().getDimension(R.dimen.standard_205));
        master_rare.animate().translationY(-getResources().getDimension(R.dimen.standard_255));
        x_rare.animate().translationY(-getResources().getDimension(R.dimen.standard_305));
        xx_rare.animate().translationY(-getResources().getDimension(R.dimen.standard_355));
        secret.animate().translationY(-getResources().getDimension(R.dimen.standard_405));

    }

    private void closeFABMenu() {
        isFABOpen = false;
        none.animate().translationY(0);
        common.animate().translationY(0);
        uncommon.animate().translationY(0);
        rare.animate().translationY(0);
        master_rare.animate().translationY(0);
        x_rare.animate().translationY(0);
        xx_rare.animate().translationY(0);
        secret.animate().translationY(0);

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
