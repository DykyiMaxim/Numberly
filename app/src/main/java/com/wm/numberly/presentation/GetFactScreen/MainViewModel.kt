package com.wm.numberly.presentation.GetFactScreen

import androidx.lifecycle.ViewModel
import com.wm.numberly.data.local.FactsDB
import com.wm.numberly.domain.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NumbersRepository,
    private val db: FactsDB
) : ViewModel() {

}
