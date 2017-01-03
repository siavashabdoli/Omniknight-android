package app.arsh.omniknightapp.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arash on 10/25/16.
 */

public class Clouds {

    @SerializedName("all")
    private Integer all;

    /**
     *
     * @return
     * The all
     */
    public Integer getAll() {
        return all;
    }

    /**
     *
     * @param all
     * The all
     */
    public void setAll(Integer all) {
        this.all = all;
    }

}