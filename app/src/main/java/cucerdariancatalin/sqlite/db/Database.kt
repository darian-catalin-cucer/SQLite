package cucerdariancatalin.sqlite.db

import cucerdariancatalin.sqlite.viewmodel.CityDao

class Database() {

    var cityDao = CityDao()

    companion object {
        @Volatile private var instance: Database? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: Database().also { instance = it }
        }
    }
}