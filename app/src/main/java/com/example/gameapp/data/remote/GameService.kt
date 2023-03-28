package com.example.gameapp.data.remote

import com.example.gameapp.data.remote.models.GameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameService @Inject constructor(private val gameApi: GameApi) {


//retrieve list of GameModel objects from an API using Retrofit library and coroutine's
    suspend fun getGames(): List<GameModel> {
        return withContext(Dispatchers.IO) {
            val games = gameApi.getGames()
            games.body()?: emptyList()
        }
    }
}