package com.example.battlespiritsdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.battlespiritsdb.MainActivity.hideSystemBars;

public class CardsLeftActivity extends AppCompatActivity {

    private CardViewModel cardViewModel;
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_left);

        RecyclerView recyclerView = findViewById(R.id.gridView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);

        final CardsLeftAdapter adapter = new CardsLeftAdapter(getApplication());
        recyclerView.setAdapter(adapter);

        cardViewModel = ViewModelProviders.of(this).get(CardViewModel.class);
        cardViewModel.getSortedCards().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                adapter.submitList(cards);
            }
        });

        trackLeft();

    }



    private void trackLeft() {

        TextView cardsLeft = findViewById(R.id.cardsLeft);

        final AtomicInteger cardsGot = new AtomicInteger();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = cardViewModel.cardsGot();
                cardsGot.set(num);
            }
        });

        final AtomicInteger countCards = new AtomicInteger();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = cardViewModel.countCards();
                countCards.set(num);
            }
        });


        t.setPriority(10);
        t2.setPriority(10);
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String trackLeft = String.valueOf(cardsGot) + "/" + String.valueOf(countCards);


        cardsLeft.setText(trackLeft);

    }



}
