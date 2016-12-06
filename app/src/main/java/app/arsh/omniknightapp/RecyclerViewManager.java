package app.arsh.omniknightapp;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

/**
 * Created by arash on 12/5/16.
 */

public class RecyclerViewManager {

  private MainActivity mainActivity;
  private ArrayList<String> adapterData = new ArrayList<>();

  public RecyclerViewManager(MainActivity mainActivity) {

    this.mainActivity = mainActivity;
    setupView();
  }

  public void setupView() {
    for (int i = 0; i < 100; i++) {
      adapterData.add(String.valueOf(i));
    }

    RecyclerView recyclerView = (RecyclerView) mainActivity.findViewById(R.id.sampleRecyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false));
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    NormalStringAdapter normalStringAdapter = new NormalStringAdapter(adapterData);
    recyclerView.setAdapter(normalStringAdapter);

  }
}
