package cucerdariancatalin.sqlite.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityModel(val id: String?, val country: String?, val city: String?, val population: Int?) : Parcelable