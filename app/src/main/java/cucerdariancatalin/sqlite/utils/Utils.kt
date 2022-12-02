package cucerdariancatalin.sqlite.utils

import cucerdariancatalin.sqlite.db.Database
import cucerdariancatalin.sqlite.repository.CityRepository
import cucerdariancatalin.sqlite.viewmodel.CityViewModelFactory

object Utils {
    fun provideViewModelFactory() : CityViewModelFactory {
        var repository = CityRepository.getInstance(Database.getInstance().cityDao)
        return CityViewModelFactory(repository)
    }
}