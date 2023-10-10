package com.cronocode.moviecatalog.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id") val id : String?,
    @SerializedName("title") val title : String?,
    @SerializedName("poster_path") val poster : String?,
    @SerializedName("release_date") val release : String?,
    @SerializedName("vote_count") val voteCount : Int?,
    @SerializedName("budget") val budget : Int?,
    @SerializedName("status") val status : String?
) : Parcelable {
    constructor() : this("", "", "", "", 0, 0, "")
}