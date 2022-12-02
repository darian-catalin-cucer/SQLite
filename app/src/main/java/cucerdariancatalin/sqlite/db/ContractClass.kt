package cucerdariancatalin.sqlite.db

class ContractClass private constructor() {
    companion object class City {
        companion object {
            const val TABLE_NAME = "cities"
            const val COL_ID = "id"
            const val COL_COUNTRY = "country"
            const val COL_CITY = "city"
            const val COL_POPULATION = "population"

            const val CREATE_CITY_TABLE = "CREATE TABLE $TABLE_NAME (" +
                    "$COL_ID VARCHAR(256) PRIMARY KEY, " +
                    "$COL_COUNTRY VARCHAR(256), " +
                    "$COL_CITY VARCHAR(256), " +
                    "$COL_POPULATION INTEGER" +
                    ")"
        }
    }
}