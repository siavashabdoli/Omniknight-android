package app.arsh.omniknightapp.view.adapters.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import app.arsh.omniknightapp.R;

/**
 * Created by arash on 10/21/16.
 */

public class CountryViewHolder extends RecyclerView.ViewHolder {

    private final CardView cv;
    TextView countryName;
    TextView countryCapital;
    TextView countryPopulation;
    ImageView countryFlag;

    public CountryViewHolder(View itemView) {
        super(itemView);
        countryName = (TextView) itemView.findViewById(R.id.countryNameTextView);
        countryCapital = (TextView) itemView.findViewById(R.id.capitalTextView);
        countryPopulation = (TextView) itemView.findViewById(R.id.populationTextView);
        countryFlag = (ImageView) itemView.findViewById(R.id.countryFlagImageView);
        cv = (CardView)itemView.findViewById(R.id.cardView);

    }

    public TextView getCountryPopulation() {
        return countryPopulation;
    }

    public TextView getCountryCapital() {
        return countryCapital;
    }

    public ImageView getCountryFlag() {
        return countryFlag;
    }

    public TextView getCountryName() {
        return countryName;
    }
}
