package com.example.battlespiritsdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CardDao {

    @Insert
    void insert(Card card);

    @Update
    void update(Card card);

    @Delete
    void delete(Card card);

    @Query("DELETE FROM cards_table")
    void deleteAllCards();

    @Query("SELECT * FROM cards_table ORDER BY id ASC")
    LiveData<List<Card>> getAllCards();

    @Query("UPDATE cards_table SET quantity = :quant WHERE id = :id")
    int updateField(int id, int quant);

    @Query("SELECT * FROM cards_table ORDER BY quantity ASC")
    LiveData<List<Card>> getSortedCards();

    @Query("SELECT count(cardName) FROM cards_table WHERE quantity = 1")
    int cardsGot();

    @Query("SELECT count(cardName) FROM cards_table")
    int countCards();

    @Query("SELECT * FROM cards_table ORDER BY cardName")
    LiveData<List<Card>> sortByName();

    @Query("SELECT * FROM cards_table WHERE cardSet = :set")
    LiveData<List<Card>> sortBySet(String set);

    @Query("SELECT * FROM cards_table WHERE rarity = :rarity ")
    LiveData<List<Card>> sortByRarity(String rarity);



}
