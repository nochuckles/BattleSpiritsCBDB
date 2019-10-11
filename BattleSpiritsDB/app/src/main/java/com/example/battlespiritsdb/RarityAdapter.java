package com.example.battlespiritsdb;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RarityAdapter extends ListAdapter<Card, RarityAdapter.CardHolder> {

    private OnItemClickListener listener;
    private Context mContext;

    public RarityAdapter() {

        super(DIFF_CALLBACK);

    }

    private static final DiffUtil.ItemCallback<Card> DIFF_CALLBACK = new DiffUtil.ItemCallback<Card>() {
        @Override
        public boolean areItemsTheSame(Card oldItem, Card newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Card oldItem, Card newItem) {
            return oldItem.getCardImage() == newItem.getCardImage();

        }
    };

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rarity_item, parent, false);
        mContext = parent.getContext();
        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        final Card currentCard = getItem(position);

        Picasso.with(mContext).load(currentCard.getCardImage()).fit().centerInside().into(holder.cardImage);


    }


    class CardHolder extends RecyclerView.ViewHolder {

        private ImageView cardImage;

        public CardHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }

        public ImageView getCardImage() {
            return cardImage;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Card card);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
