package com.example.gameapp.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameapp.domain.GetGameByIdUseCase
import com.example.gameapp.domain.GetGameUseCase
import com.example.gameapp.domain.items.GameItem
import com.example.gameapp.domain.items.SpecificGameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGamesUseCase: GetGameUseCase,
    private val getGameByIdUseCase: GetGameByIdUseCase
): ViewModel() {
    /*
    How Kotlin coroutines and liveData can be used
    together to implement asynchronous data fetching and stateManagement in ViewModel
     */
    private val _games = MutableLiveData<List<GameItem>>()
    val games: LiveData<List<GameItem>> get() = _games

    private val _game = MutableLiveData<SpecificGameItem>()
    val game: LiveData<SpecificGameItem> get() = _game

    init {
        getGames()
    }

    //Use kotlin coroutines to asynchronously fetch data from a remote datasource
    // and update state viewModel
    private fun getGames() {
        //launch new coroutine in viewmodelScope
        viewModelScope.launch {

            try {
                //fetch list of games from a remote data source
                val games = getGamesUseCase()
                _games.value = games

            } catch (_: Exception) {}   //if exception occurs caught using catch

        }

    }

    fun getGameById(id: Int) {

        viewModelScope.launch {

            try {

                val game = getGameByIdUseCase(id)
                _game.value = game

            } catch (_: Exception) {}

        }

    }

}
}