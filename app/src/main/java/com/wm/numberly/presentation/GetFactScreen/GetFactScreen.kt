package com.wm.numberly.presentation.GetFactScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.rememberMessageBarState
import com.wm.numberly.domain.model.Fact
import com.wm.numberly.presentation.GetFactScreen.destinations.DetailsScreenDestination
import com.wm.numberly.utils.ConnectionState
import com.wm.numberly.utils.isInteger
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
@Destination(start = true)
@Composable
fun GetFactScreen(
    navigator: DestinationsNavigator,
    viewModel: MainViewModel = hiltViewModel(),
) {

    val factState by viewModel.FactState.collectAsState()
    var textFieldText by remember { mutableStateOf("") }
    val messageBarState = rememberMessageBarState()
    val connection by connectivityState()
    val isConnected = connection === ConnectionState.Available





    ContentWithMessageBar(messageBarState = messageBarState) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Interesting facts about numbers",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(value = textFieldText,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text("Search for Number") },
                onValueChange = { textFieldText = it })
            Spacer(modifier = Modifier.height(8.dp))


            Button(onClick = {
                viewModel.viewModelScope.launch {
                    if (isConnected) {
                        if (textFieldText.isInteger(textFieldText)) {
                            viewModel.getFact(textFieldText)
                            delay(500)
                            val fact = factState.fact
                            navigator.navigate(DetailsScreenDestination(fact))
                        } else {
                            messageBarState.addError(exception = Exception("Input valid integer number)"))
                        }
                    } else {
                        messageBarState.addError(exception = Exception("Check your internet connection"))
                    }
                }


            }) {
                Text(text = "Search")
            }
            Button(onClick = {
                if (isConnected) {
                    viewModel.viewModelScope.launch {
                        viewModel.getRandomFact()
                        delay(500)
                        val fact = factState.fact

                        navigator.navigate(DetailsScreenDestination(fact))

                    }
                } else {
                    messageBarState.addError(exception = Exception("Check your internet connection"))
                }


            }) {
                Text(text = "Random Number")
            }
            Divider()
            Text(text = "Search History")
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.list.size) { i ->
                    val roomEntryFact = viewModel.list[i]
                    FactItem(fact = roomEntryFact,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .clickable {

                                navigator.navigate(
                                    DetailsScreenDestination(
                                        Fact(
                                            number = roomEntryFact.number,
                                            text = roomEntryFact.text,
                                            found = true
                                        )
                                    )
                                )


                            }

                    )
                }

            }

        }
    }
}
