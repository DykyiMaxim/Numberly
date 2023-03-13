package com.wm.numberly.presentation.GetFactScreen



import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wm.numberly.data.local.FactListingEntity
import com.wm.numberly.data.local.FactsDB
import com.wm.numberly.domain.model.Fact
import com.wm.numberly.domain.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NumbersRepository, private val db: FactsDB
) : ViewModel() {
    private val _factState = MutableStateFlow(GetFactState())
    val FactState: StateFlow<GetFactState> = _factState.asStateFlow()
    var list by mutableStateOf(listOf<FactListingEntity>())


    init {
        updateList()
    }

    suspend fun getFact(Number: String) {
        viewModelScope.launch {
            val pick = repository.getNumber(Number)
            val entity = FactListingEntity(
                text = pick.data!!.text, number = pick.data.number
            )
            db.dao.insertFact(entity)
            _factState.value =
                GetFactState(Fact(text = pick.data.text, number = pick.data.number, false))

        }
    }


    suspend fun getRandomFact() {
        viewModelScope.launch {
            val randomFact = repository.getRandomNumber()
            val entity = FactListingEntity(
                text = randomFact.data!!.text, number = randomFact.data.number
            )
            db.dao.insertFact(entity)
            _factState.value = GetFactState(
                Fact(
                    randomFact.data.text, randomFact.data.number, randomFact.data.found
                ), false, ""
            )
        }
    }



    fun updateList() {
        viewModelScope.launch {
            val res = db.dao.getAllFacts()
            list = res
        }
    }


}



