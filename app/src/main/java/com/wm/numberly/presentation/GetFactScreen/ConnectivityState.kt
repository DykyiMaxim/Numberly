package com.wm.numberly.presentation.GetFactScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import com.wm.numberly.utils.ConnectionState
import com.wm.numberly.utils.currentConnectivityState
import com.wm.numberly.utils.observeConnectivityAsFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
    @Composable
    fun connectivityState(): State<ConnectionState> {
        val context = LocalContext.current

        return produceState(initialValue = context.currentConnectivityState) {
            context.observeConnectivityAsFlow().collect { value = it }
        }
    }
