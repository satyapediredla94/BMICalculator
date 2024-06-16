package view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import view.components.MeasurementCard
import viewmodel.BMICalculatorEvent
import viewmodel.BMICalculatorMainViewModel

@Composable
fun WeightAndAgeComponent(modifier: Modifier = Modifier) {
    val viewModel = viewModel { BMICalculatorMainViewModel() }
    val state by viewModel.bmiState.collectAsState()
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MeasurementCard(
            modifier = modifier.weight(1.0f)
                .padding(end = 4.dp),
            value = state.weight,
            onValueIncreased = {
                viewModel.handleViewEvent(BMICalculatorEvent.WeightChanged(state.weight + 1))
            },
            onValueDecreased = {
                viewModel.handleViewEvent(BMICalculatorEvent.WeightChanged(state.weight - 1))
            },
        ) {
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Weight",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(in kg)",
                    modifier = Modifier.padding(start = 2.dp).align(Alignment.CenterVertically),
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        MeasurementCard(
            modifier = modifier.weight(1.0f)
                .padding(start = 4.dp),
            value = state.age,
            onValueIncreased = {
                viewModel.handleViewEvent(BMICalculatorEvent.AgeChanged(state.age + 1))
            },
            onValueDecreased = {
                viewModel.handleViewEvent(BMICalculatorEvent.AgeChanged(state.age - 1))
            },
        ) {
            Text(
                text = "Age",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
        }
    }
}