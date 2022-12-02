package cucerdariancatalin.sqlite.viewmodel

import android.content.Context
import android.database.Cursor
import android.os.AsyncTask
import android.widget.Toast
import cucerdariancatalin.sqlite.db.ContractClass
import cucerdariancatalin.sqlite.db.DatabaseOpenHelper
import cucerdariancatalin.sqlite.model.CityModel

class CityDao {

    val contractClass = ContractClass.City
    val cities = ArrayList<CityModel>()

    fun loadCities(context: Context): ArrayList<CityModel> {

        val db = DatabaseOpenHelper(context)
        val database = db.readableDatabase


        val columns = arrayOf(
            contractClass.COL_ID,
            contractClass.COL_COUNTRY,
            contractClass.COL_CITY,
            contractClass.COL_POPULATION
        )

        class LoadStuff : AsyncTask<Void, Void, Cursor>() {
            override fun doInBackground(vararg params: Void): Cursor {
                return database.query(
                    contractClass.TABLE_NAME,
                    columns,
                    null, null, null, null, null
                )
            }

            override fun onProgressUpdate(vararg values: Void?) {
                Toast.makeText(context, "Cities Loading", Toast.LENGTH_LONG).show()
            }

            override fun onPostExecute(result: Cursor) {
                val idIndex = result.getColumnIndex(contractClass.COL_ID)
                val countryIndex = result.getColumnIndex(contractClass.COL_COUNTRY)
                val cityIndex = result.getColumnIndex(contractClass.COL_CITY)
                val populationIndex = result.getColumnIndex(contractClass.COL_POPULATION)

                if(cities.size != 0) {
                    cities.clear()
                }

                while (result.moveToNext()) {
                    val id = result.getString(idIndex)
                    val country = result.getString(countryIndex)
                    val city = result.getString(cityIndex)
                    val population = result.getString(populationIndex).toInt()

                    val cityP = CityModel(id, country, city, population)
                    cities.add(cityP)
                }
                result.close()
            }
        }

        val task = LoadStuff()
        task.execute()

        return cities
    }

    fun closeDatabase(context: Context) {
        val database = DatabaseOpenHelper(context)
        database.close()
    }
}