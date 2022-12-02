package cucerdariancatalin.sqlite.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import cucerdariancatalin.sqlite.model.CityModel
import cucerdariancatalin.sqlite.repository.CityRepository

class CityViewModel(private val cityRepository: CityRepository): ViewModel() {
    fun loadCities(context: Context): ArrayList<CityModel> =
        cityRepository.loadCities(context)

    fun closeDatabase(context: Context) = cityRepository.closeDatabase(context)
}