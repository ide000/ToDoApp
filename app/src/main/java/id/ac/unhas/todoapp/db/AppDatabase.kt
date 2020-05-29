package id.ac.unhas.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.id.ac.unhas.todolist.todolist.Todolist
import com.id.ac.unhas.todolist.todolist.TodolistDao
import id.ac.unhas.todoapp.todolist.Todolist
import id.ac.unhas.todoapp.todolist.TodolistDao


@Database(entities = [Todolist::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todolistDao(): TodolistDao

    companion object {

        private const val DB_NAME = "todolist_DB"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            AppDatabase::class.java,
                            DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }
    }
}