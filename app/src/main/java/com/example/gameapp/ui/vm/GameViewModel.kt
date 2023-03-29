package com.example.gameapp.ui.vm

import androidx.lifecycle.ViewModel
import com.example.gameapp.domain.GetGameByIdUseCase
import com.example.gameapp.domain.GetGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGameUseCase: GetGameUseCase,
    private val getGameByIdUseCase: GetGameByIdUseCase
): ViewModel() {
    /*TODO*/
}