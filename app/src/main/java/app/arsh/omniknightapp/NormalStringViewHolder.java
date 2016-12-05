package app.arsh.omniknightapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by arash on 12/5/16.
 */

public class NormalStringViewHolder extends RecyclerView.ViewHolder {

  private TextView rowNumberTextView;

  public NormalStringViewHolder(View itemView) {
    super(itemView);
    setupView(itemView);
  }

  private void setupView(View itemView) {
    rowNumberTextView = (TextView) itemView.findViewById(R.id.rowNumberTextView);
  }

  TextView getRowNumberTextView() {
    return rowNumberTextView;
  }
}
