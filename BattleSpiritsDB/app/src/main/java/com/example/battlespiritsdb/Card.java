package com.example.battlespiritsdb;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cards_table")
public class Card {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int cardImage;
    private String cardCode;
    private String cardName;
    private String cardSet;
    private int quantity;
    private String rarity;

    public Card(int cardImage, String cardCode, String cardName, String cardSet, int quantity, String rarity) {
        this.cardImage = cardImage;
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.cardSet = cardSet;
        this.quantity = quantity;
        this.rarity = rarity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCardImage() {
        return cardImage;
    }

    public String getCardCode() {
        return cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    String getCardSet() {
        return cardSet;
    }

    int getQuantity() {
        return quantity;
    }

    public String getRarity() {
        return rarity;
    }
}
