package com.wm.numberly.presentation.FactDetailsScreen


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.wm.numberly.domain.model.Fact
import com.wm.numberly.presentation.GetFactScreen.MainViewModel
import com.wm.numberly.presentation.destinations.GetFactScreenDestination
import kotlinx.coroutines.launch
@Destination
@Composable
fun DetailScreen(
    navigator: DestinationsNavigator,
    fact: Fact,
    viewModel: MainViewModel = hiltViewModel(),
) {


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 60.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(color = Color.LightGray),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(bottom = 110.dp),
                    text = fact.number,
                    style = TextStyle(
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.padding(all = 15.dp),
                    text = fact.text,
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
            }
            BackHandler(enabled = true) {
                viewModel.viewModelScope.launch {
                    viewModel.updateList()
                    navigator.navigate(GetFactScreenDestination)
                }

            }

        }

    }
}
