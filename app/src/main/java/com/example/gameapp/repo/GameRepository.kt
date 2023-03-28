package com.example.gameapp.repo

import com.example.gameapp.data.remote.GameService
import com.example.gameapp.domain.items.GameItem
import com.example.gameapp.domain.items.SpecificGameItem
import com.example.gameapp.domain.items.toGameItem
import com.example.gameapp.domain.items.toSpecificGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService) {

    /*
    retrieves a list of GameModel objects from an API using Retrofit library
    maps them to a list of GameItem object using map fun
     */
    suspend fun getGames(): List<GameItem> {
        return gameService.getGames().map {
            it.toGameItem()
        }
    }

    suspend fun getGameById(id:Int): SpecificGameItem {
        return gameService.getGameById(id).toSpecificGameItem()
    }
}