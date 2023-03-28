package com.example.gameapp.domain

import com.example.gameapp.repo.GameRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(private val gameRepository: GameRepository){
}