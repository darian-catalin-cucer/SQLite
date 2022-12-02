package cucerdariancatalin.sqlite.repository

import android.content.Context
import cucerdariancatalin.sqlite.model.CityModel
import cucerdariancatalin.sqlite.viewmodel.CityDao

class CityRepository(private var cityDao: CityDao) {
    fun loadCities(context: Context): ArrayList<CityModel> =
        cityDao.loadCities(context)

    fun closeDatabase(context: Context) = cityDao.closeDatabase(context)

    companion object {
        @Volatile private var instance: CityRepository? = null

        fun getInstance(cityDao: CityDao) = instance ?:
        synchronized(this) {
            instance ?: CityRepository(cityDao).also { instance = it }
        }
    }
}