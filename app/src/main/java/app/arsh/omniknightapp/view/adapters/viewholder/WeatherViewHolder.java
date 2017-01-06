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

    TextView temperture;
    TextView humidity;
    TextView cityName;
    ImageView weatherImage;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        temperture = (TextView) itemView.findViewById(R.id.countryNameTextView);
        humidity = (TextView) itemView.findViewById(R.id.capitalTextView);
        cityName = (TextView) itemView.findViewById(R.id.populationTextView);
        weatherImage = (ImageView) itemView.findViewById(R.id.countryFlagImageView);
        cv = (CardView)itemView.findViewById(R.id.cardView);

    }

    private final CardView cv;

    public TextView getCityName() {
        return cityName;
    }

    public void setCityName(TextView cityName) {
        this.cityName = cityName;
    }

    public CardView getCv() {
        return cv;
    }

    public TextView getHumidity() {
        return humidity;
    }

    public void setHumidity(TextView humidity) {
        this.humidity = humidity;
    }

    public TextView getTemperture() {
        return temperture;
    }

    public void setTemperture(TextView temperture) {
        this.temperture = temperture;
    }

    public ImageView getWeatherImage() {
        return weatherImage;
    }

    public void setWeatherImage(ImageView weatherImage) {
        this.weatherImage = weatherImage;
    }

}
