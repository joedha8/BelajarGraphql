package id.rackspira.belajargraphql.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("data")
    @Expose
    var data: Data? = null

}