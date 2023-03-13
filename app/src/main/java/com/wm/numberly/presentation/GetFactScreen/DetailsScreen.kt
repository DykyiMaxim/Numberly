package com.wm.numberly.presentation.GetFactScreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.wm.numberly.domain.model.Fact

@Destination
@Composable
fun DetailsScreen(
    navigator: DestinationsNavigator,
    fact: Fact,
    viewModel: MainViewModel = hiltViewModel(),
) {
    Text(text = "Hi")
}