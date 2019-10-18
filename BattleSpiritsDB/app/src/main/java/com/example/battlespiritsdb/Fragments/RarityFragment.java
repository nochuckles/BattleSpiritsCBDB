package com.example.battlespiritsdb.Fragments;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.battlespiritsdb.Card;
import com.example.battlespiritsdb.CardViewModel;
import com.example.battlespiritsdb.R;
import com.example.battlespiritsdb.RarityAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.List;


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
    private boolean isFABOpen = false;
    private FloatingActionButton fab, none, common, uncommon, rare, master_rare, x_rare, xx_rare, secret;

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
        cardViewModel.sortByRarity(COMMON).observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                adapter.submitList(cards);
            }
        });

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
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
                cardViewModel.sortByRarity(NONE).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(none);
                Toast.makeText(getContext(), "RARITY: " + NONE, Toast.LENGTH_SHORT).show();

            }
        });

        common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortByRarity(COMMON).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(common);
                Toast.makeText(getContext(), "RARITY: " + COMMON, Toast.LENGTH_SHORT).show();
            }
        });

        uncommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortByRarity(UNCOMMON).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(uncommon);
                Toast.makeText(getContext(), "RARITY: " + UNCOMMON, Toast.LENGTH_SHORT).show();
            }
        });

        rare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortByRarity(RARE).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(rare);
                Toast.makeText(getContext(), "RARITY: " + RARE, Toast.LENGTH_SHORT).show();
            }
        });

        master_rare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortByRarity(MASTER_RARE).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(master_rare);
                Toast.makeText(getContext(), "RARITY: " + MASTER_RARE, Toast.LENGTH_SHORT).show();
            }
        });

        x_rare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortByRarity(X_RARE).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(x_rare);
                Toast.makeText(getContext(), "RARITY: " + X_RARE, Toast.LENGTH_SHORT).show();;
            }
        });

        xx_rare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortByRarity(XX_RARE).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(xx_rare);
                Toast.makeText(getContext(), "RARITY: " + XX_RARE, Toast.LENGTH_SHORT).show();
            }
        });

        secret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewModel.sortByRarity(SECRET).observe((LifecycleOwner) getContext(), new Observer<List<Card>>() {
                    @Override
                    public void onChanged(List<Card> cards) {
                        adapter.submitList(cards);
                    }
                });

                changeColor(secret);
                Toast.makeText(getContext(), "RARITY: " + SECRET, Toast.LENGTH_SHORT).show();
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

        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#a31e4f")));

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

        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));

    }

    private void changeColor(FloatingActionButton button) {
        none.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        common.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        uncommon.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        rare.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        master_rare.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        x_rare.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        xx_rare.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
        secret.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));

        button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#a31e4f")));
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
