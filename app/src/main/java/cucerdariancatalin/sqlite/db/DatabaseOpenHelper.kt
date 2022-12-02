package cucerdariancatalin.sqlite.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class DatabaseOpenHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        const val DATABASE_NAME = "utopia_cities.db"
        const val DATABASE_VERSION = 1
    }

    //Secondary Constructor
    constructor(context: Context?) : this(context, DATABASE_NAME, null, DATABASE_VERSION)

    init {
        // Check if the database already copied to the device.
        val dbExist = checkDatabase(context)
        if (dbExist) {
            // if already copied then don't do anything.
            Log.e("-----", "Database exist")
        } else {
            // else copy the database to the device.
            Log.e("-----", "Database doesn't exist")
            createDatabase(context)
        }
    }

    // Copy the database
    private fun createDatabase(context: Context?) {
        copyDatabase(context)
    }

    // Check if the database already copied to the device.
    private fun checkDatabase(context: Context?): Boolean {
        val dbFile = File(context!!.getDatabasePath(DATABASE_NAME).path)
        return dbFile.exists()
    }

    // Copy the database
    private fun copyDatabase(context: Context?) {

        val inputStream = context!!.assets.open("dbs/$DATABASE_NAME")

        val outputFile = File(context.getDatabasePath(DATABASE_NAME).path)
        val outputStream = FileOutputStream(outputFile)

        val bytesCopied = inputStream.copyTo(outputStream)
        Log.e("bytesCopied", "$bytesCopied")
        inputStream.close()

        outputStream.flush()
        outputStream.close()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        Log.i("DatabaseOpenHelper", "onCreate db");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.i("DatabaseOpenHelper", "onUpgrade db");
    }
}