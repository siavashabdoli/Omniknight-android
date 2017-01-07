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

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    TextView cityName;
    TextView cityWeatherDescriptionTextView;
    TextView capitalTextView;
    ImageView weatherImage;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        cityName = (TextView) itemView.findViewById(R.id.cityNameTextView);
        cityWeatherDescriptionTextView = (TextView) itemView.findViewById(R.id.cityWeatherDescriptionTextView);
        capitalTextView = (TextView) itemView.findViewById(R.id.capitalTextView);
        weatherImage = (ImageView) itemView.findViewById(R.id.countryFlagImageView);
        cv = (CardView)itemView.findViewById(R.id.cardView);

    }

    private final CardView cv;

    public CardView getCv() {
        return cv;
    }

    public TextView getcityWeatherDescriptionTextView() {
        return cityWeatherDescriptionTextView;
    }

    public void setcityWeatherDescriptionTextView(TextView humidity) {
        this.cityWeatherDescriptionTextView = humidity;
    }

    public TextView getCityName() {
        return cityName;
    }

    public void setCityName(TextView cityName) {
        this.cityName = cityName;
    }

    public ImageView getWeatherImage() {
        return weatherImage;
    }

    public void setWeatherImage(ImageView weatherImage) {
        this.weatherImage = weatherImage;
    }
    public TextView getCapitalTextView() {
        return capitalTextView;
    }

    public void setCapitalTextView(TextView capitalTextView) {
        this.capitalTextView = capitalTextView;
    }

}
