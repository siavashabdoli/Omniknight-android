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
    TextView weatherCondition;
    ImageView weatherImage;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        cityName = (TextView) itemView.findViewById(R.id.cityNameTextView);
        cityWeatherDescriptionTextView = (TextView) itemView.findViewById(R.id.cityWeatherDescriptionTextView);
        weatherCondition = (TextView) itemView.findViewById(R.id.weatherCondition);
        weatherImage = (ImageView) itemView.findViewById(R.id.cityFlagImageView);
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
    public TextView getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(TextView capitalTextView) {
        this.weatherCondition = capitalTextView;
    }

}
