package app.arsh.omniknightapp.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.view.adapters.viewholder.WeatherViewHolder;
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
        notifyDataSetChanged();
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
        holder.getCityName().setText(weather.getWeather().get(0).getDescription());
        holder.getcityWeatherDescriptionTextView().setText(weather.getName());
        holder.getCapitalTextView().setText(String.valueOf(weather.getWind().getSpeed()));

        holder.itemView.setOnClickListener(view -> onClickSubject.onNext(weather));
    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

}
