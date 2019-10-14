package com.example.battlespiritsdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CardRepository {

    private CardDao cardDao;
    private LiveData<List<Card>> allCards, sortedCards, sortByName;

    public CardRepository(Application application) {
        CardDatabase database = CardDatabase.getInstance(application);
        cardDao = database.cardDao();
        allCards = cardDao.getAllCards();
        sortedCards = cardDao.getSortedCards();
        sortByName = cardDao.sortByName();
    }

    public void insert(Card card) { new InsertCardAsyncTask(cardDao).execute(card); }

    public void update(Card card) { new UpdateCardAsyncTask(cardDao).execute(card); }

    public void delete(Card card) { new DeleteCardAsyncTask(cardDao).execute(card); }

    public void DeleteAllCards() { new DeleteAllCardsAsyncTask(cardDao).execute(); }

    public LiveData<List<Card>> getAllCards() { return allCards; }

    public void UpdateField(int id, int quant) { new UpdateFieldAsyncTask(cardDao, id).execute(quant); }

    public LiveData<List<Card>> getSortedCards() { return sortedCards; }

    public int cardsGot() { return cardDao.cardsGot(); }

    public int countCards() { return cardDao.countCards(); }

    public LiveData<List<Card>> sortByName() { return sortByName; }

    public LiveData<List<Card>> sortByRarity(String rarity) { return cardDao.sortByRarity(rarity); }

    public LiveData<List<Card>> sortBySet(String set) { return cardDao.sortBySet(set); }


    private static class InsertCardAsyncTask extends AsyncTask<Card, Void, Void> {

        private CardDao cardDao;
        private InsertCardAsyncTask(CardDao cardDao) { this.cardDao = cardDao; }

        @Override
        protected Void doInBackground(Card... cards) {
            cardDao.insert(cards[0]);
            return null;
        }
    }

    private static class UpdateCardAsyncTask extends AsyncTask<Card, Void, Void> {

        private CardDao cardDao;
        private UpdateCardAsyncTask(CardDao cardDao) { this.cardDao = cardDao; }

        @Override
        protected Void doInBackground(Card... cards) {
            cardDao.update(cards[0]);
            return null;
        }
    }

    private static class DeleteCardAsyncTask extends AsyncTask<Card, Void, Void> {

        private CardDao cardDao;
        private DeleteCardAsyncTask(CardDao cardDao) { this.cardDao = cardDao; }

        @Override
        protected Void doInBackground(Card... cards) {
            cardDao.delete(cards[0]);
            return null;
        }
    }

    private static class DeleteAllCardsAsyncTask extends AsyncTask<Void, Void, Void> {

        private CardDao cardDao;
        private DeleteAllCardsAsyncTask(CardDao cardDao) { this.cardDao = cardDao; }

        @Override
        protected Void doInBackground(Void... voids) {
            cardDao.deleteAllCards();
            return null;
        }
    }

    private static class UpdateFieldAsyncTask extends AsyncTask<Integer, Void, Void> {

        private CardDao cardDao;
        private int id;
        private UpdateFieldAsyncTask(CardDao cardDao, int id) { this.cardDao = cardDao; this.id = id; }

        @Override
        protected Void doInBackground(Integer... quant) {
            cardDao.updateField(id, quant[0]);
            return null;
        }
    }


}

