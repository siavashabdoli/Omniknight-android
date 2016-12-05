package app.arsh.omniknightapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by arash on 12/5/16.
 */

public class NormalStringAdapter extends RecyclerView.Adapter<NormalStringViewHolder> {

  private ArrayList<String> adapterData = new ArrayList<>();

  public NormalStringAdapter() {
  }

  public NormalStringAdapter(ArrayList<String> adapterData) {
    this.adapterData = adapterData;
  }

  public void updateData(ArrayList<String> adapterData) {
    this.adapterData = adapterData;
    notifyDataSetChanged();
  }

  @Override public NormalStringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_string_view_item, parent, false);
    Log.d(TAG, "onCreateViewHolder: called");
    return new NormalStringViewHolder(view);
  }

  @Override public void onBindViewHolder(NormalStringViewHolder holder, int position) {
      holder.getRowNumberTextView().setText(adapterData.get(holder.getAdapterPosition()));
    Log.d(TAG, "onBindViewHolder: called");
  }

  @Override public int getItemCount() {
    return adapterData.size();
  }
}
