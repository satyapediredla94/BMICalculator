package view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import view.components.ActiveText
import view.components.InactiveText
import view.components.SecondaryInactiveText
import view.ui.theme.Orange
import viewmodel.BMICalculatorEvent
import viewmodel.BMICalculatorMainViewModel

@Composable
fun HeightSlider(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel { BMICalculatorMainViewModel() }
    val state by viewModel.bmiState.collectAsState()

    Card(
        modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 8.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Height",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(in cm)",
                    modifier = Modifier.padding(start = 2.dp),
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
            }

            Slider(
                value = state.height,
                onValueChange = { viewModel.handleViewEvent(BMICalculatorEvent.HeightChanged(it)) },
                steps = 300,
                valueRange = 0f..300f,
                colors = SliderDefaults.colors(
                    thumbColor = Orange,
                    activeTrackColor = Orange,
                    inactiveTrackColor = Color.LightGray,
                )
            )
            val current = state.height.toInt()
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            ) {
                SecondaryInactiveText(
                    value = if (current > 2) (current - 2).toString() else "",
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        )
                )

                InactiveText(
                    value = if (current > 1) (current - 1).toString() else "",
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        )
                )

                ActiveText(
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        ),
                    value = current.toString()
                )

                InactiveText(
                    value = if (current < 300) (current + 1).toString() else "",
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        )
                )

                SecondaryInactiveText(
                    value = if (current < 299) (current + 2).toString() else "",
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        )
                )

            }
        }
    }
}