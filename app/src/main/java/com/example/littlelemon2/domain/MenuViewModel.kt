package SKK.littlelemon.Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.littlelemon2.data.cache.AppDatabase
import com.example.littlelemon2.data.cache.MenuItemRoom
import com.example.littlelemon2.data.network.Network
import com.example.littlelemon2.data.toMenuItemRoom
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MenuViewModel(application: Application) : AndroidViewModel(application) {
    private val database: AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        name = "database"
    ).build()

    private val client = HttpClient(Android){
        install(ContentNegotiation){
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val networkSource = Network(
        httpClient = client
    )

    fun getAllDatabaseMenuItems(): LiveData<List<MenuItemRoom>> {
        return database.menuItemDao().getAll()
    }

    fun fetchMenuDataIfNeeded() {
        viewModelScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {
                val response = networkSource.fetchMenuItem()
                println("response: $response")
                database.menuItemDao().insertAll(
                    response.toMenuItemRoom()
                )
            }
        }
    }
}