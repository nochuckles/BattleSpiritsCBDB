package com.example.battlespiritsdb;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class StockAdapter extends ListAdapter<Card, StockAdapter.CardHolder> {

    private OnItemClickListener listener;
    private Context mContext;
    private CardViewModel cardViewModel;

    protected StockAdapter(Application application) {

        super(DIFF_CALLBACK);
        cardViewModel = new CardViewModel(application);

    }

    private static final DiffUtil.ItemCallback<Card> DIFF_CALLBACK = new DiffUtil.ItemCallback<Card>() {
        @Override
        public boolean areItemsTheSame(Card oldItem, Card newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Card oldItem, Card newItem) {
            return oldItem.getCardImage() == newItem.getCardImage() &&
                    oldItem.getCardName().equals(newItem.getCardName()) &&
                    oldItem.getCardCode().equals(newItem.getCardCode());

        }
    };

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_item, parent, false);
        mContext = parent.getContext();
        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        final Card currentCard = getItem(position);

        Picasso.with(mContext).load(currentCard.getCardImage()).fit().centerInside().into(holder.cardImage);
        holder.cardName.setText(currentCard.getCardName());
        holder.cardCode.setText(currentCard.getCardCode());

        holder.aSwitch.setOnCheckedChangeListener(null);

        if (currentCard.getQuantity() == 1) {
            holder.aSwitch.setChecked(true);
        } else {
            holder.aSwitch.setChecked(false);
        }

        holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    cardViewModel.updateField(currentCard.getId(), 1);
                    Toast.makeText(mContext, "Una menos, quedan solo pff o mas", Toast.LENGTH_SHORT).show();
                } else {
                    cardViewModel.updateField(currentCard.getId(), 0);
                }
            }
        });



    }


    class CardHolder extends RecyclerView.ViewHolder {

        private ImageView cardImage;
        private TextView cardName;
        private TextView cardCode;
        private Switch aSwitch;

        public CardHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardName = itemView.findViewById(R.id.cardName);
            cardCode = itemView.findViewById(R.id.cardCode);
            aSwitch = itemView.findViewById(R.id.switchQuantity);

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
