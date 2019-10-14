package com.example.battlespiritsdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CardViewModel extends AndroidViewModel {

    private CardRepository repository;
    private LiveData<List<Card>> allCards, sortedCards, sortByName;

    public CardViewModel(@NonNull Application application) {
        super(application);
        repository = new CardRepository(application);
        allCards = repository.getAllCards();
        sortedCards = repository.getSortedCards();
        sortByName = repository.sortByName();
    }

    public void insert(Card card) { repository.insert(card); }

    public void update(Card card) { repository.update(card); }

    public void delete(Card card) { repository.delete(card); }

    public void deleteAllCards() { repository.DeleteAllCards(); }

    public LiveData<List<Card>> getAllCards() { return allCards; }

    public void updateField(int id, int quant) { repository.UpdateField(id, quant); }

    public LiveData<List<Card>> getSortedCards() { return sortedCards; }

    public int cardsGot() { return repository.cardsGot(); }

    public int countCards() { return repository.countCards(); }

    public LiveData<List<Card>> sortByName() { return sortByName; }

    public LiveData<List<Card>> sortBySet(String set) { return repository.sortBySet(set); }

    public LiveData<List<Card>> sortByRarity(String rarity) { return repository.sortByRarity(rarity); }

}
