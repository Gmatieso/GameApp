package com.example.gameapp.domain

import com.example.gameapp.domain.items.GameItem
import com.example.gameapp.repo.GameRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(private val gameRepository: GameRepository){

    //Defines usecase for retrieving a list of GameItem objects from a datasource and shuffle their order
    suspend operator fun invoke(): List<GameItem> {
        return gameRepository.getGames().shuffled()
    }
}