package com.example.battlespiritsdb;

import android.app.Application;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class CardsLeftAdapter extends ListAdapter<Card, CardsLeftAdapter.CardHolder> {

    private OnItemClickListener listener;
    private Context mContext;

    protected CardsLeftAdapter(Application application) {

        super(DIFF_CALLBACK);

    }

    private static final DiffUtil.ItemCallback<Card> DIFF_CALLBACK = new DiffUtil.ItemCallback<Card>() {
        @Override
        public boolean areItemsTheSame(Card oldItem, Card newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Card oldItem, Card newItem) {
            return oldItem.getCardImage() == newItem.getCardImage() &&
                    oldItem.getCardCode().equals(newItem.getCardCode());

        }
    };

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_card_item, parent, false);
        mContext = parent.getContext();
        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        final Card currentCard = getItem(position);

        Picasso.with(mContext).load(currentCard.getCardImage()).fit().centerInside().into(holder.cardImage);
        holder.cardCode.setText(currentCard.getCardCode());

        if (currentCard.getQuantity() == 0) {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);

            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            holder.cardImage.setColorFilter(filter);


        } else {

            holder.cardImage.setColorFilter(null);
        }


    }


    class CardHolder extends RecyclerView.ViewHolder {

        private ImageView cardImage;
        private TextView cardCode;

        private CardHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardCode = itemView.findViewById(R.id.cardCode);

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