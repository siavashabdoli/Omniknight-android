package app.arsh.omniknightapp.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.view.adapters.viewholder.CountryViewHolder;
import com.squareup.picasso.Picasso;
import java.util.List;
import rx.Observer;

/**
 * Created by arash on 10/21/16.
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    private Context context;
    private List<Country> countries;
    private Observer<Country> onClickSubject;

    public CountriesAdapter(List<Country> countries, Observer<Country> onClickSubject) {
        this.countries = countries;
        this.onClickSubject = onClickSubject;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);

        CountryViewHolder viewHolder = new CountryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        final Country country = countries.get(position);
        holder.getCountryName().setText(country.getName());
        holder.getCountryCapital().setText(country.getCapital());
        holder.getCountryPopulation().setText(String.valueOf(country.getPopulation()));

        String imageURL = new StringBuilder().append(context.getString(R.string.images_base_url)).
                append(country.getAlpha2Code().toLowerCase()).append(context.getString(R.string.png_post_fix)).toString();
        // Use Picasso to load the image
        // Temporarily have a placeholder in case it's slow to load
        Picasso.with(context)
                .load(imageURL)
                .fit()
                .placeholder(R.drawable.ic_flag_black_48dp)
                .error(R.drawable.ic_error_outline_black_48dp)
                .into(holder.getCountryFlag());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSubject.onNext(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

}
