package app.arsh.omniknightapp.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.view.adapters.viewholder.WeatherViewHolder;
import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;
import java.util.List;
import rx.Observer;

/**
 * Created by arash on 10/21/16.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private Context context;
    private List<Weather> weathers;
    private Observer<Weather> onClickSubject;

    public WeatherAdapter(List<Weather> weathers, Observer<Weather> onClickSubject) {
        this.weathers = weathers;
        this.onClickSubject = onClickSubject;
    }

    public void addWeather(Weather weather) {
        weathers.add(weather);
    }

    public void resetData() {
        weathers = null;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);

        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        final Weather weather = weathers.get(position);
        holder.getCityName().setText(weather.getName()+" ("+weather.getCountry().getName()+")");
        weather.getMain().setTemp(weather.getMain().getTemp()-273.15);
        weather.getMain().setTempMin(weather.getMain().getTempMin()-273.15);
        weather.getMain().setTempMax(weather.getMain().getTempMax()-273.15);
        holder.getWeatherCondition().setText(String.valueOf(weather.getMain().getTemp().intValue())
            +" ("+weather.getMain().getTempMin().intValue()
            +" to "+weather.getMain().getTempMin().intValue()+") Celsius");
        holder.getcityWeatherDescriptionTextView().setText(weather.getWeather().get(0).getDescription());

        String imageURL = new StringBuilder().append(context.getString(R.string.images_base_url)).
            append(weather.getCountry().getAlpha2Code().toLowerCase()).append(context.getString(R.string.png_post_fix)).toString();
        // Use Picasso to load the image
        // Temporarily have a placeholder in case it's slow to load
        Picasso.with(context)
            .load(imageURL)
            .fit()
            .placeholder(R.drawable.ic_flag_black_48dp)
            .error(R.drawable.ic_error_outline_black_48dp)
            .into(holder.getWeatherImage());

        if (onClickSubject != null) RxView.clicks(holder.itemView).subscribe(view -> onClickSubject.onNext(weather));
    }


    @Override
    public int getItemCount() {
        return weathers == null ? 0 : weathers.size();
    }

}
