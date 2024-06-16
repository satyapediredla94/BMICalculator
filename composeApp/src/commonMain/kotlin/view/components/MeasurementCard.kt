package view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MeasurementCard(
    modifier: Modifier = Modifier,
    value: Int,
    onValueIncreased: () -> Unit,
    onValueDecreased: () -> Unit,
    text: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            text()
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            ) {

                InactiveText(
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        ),
                    value = if (value > 0) (value - 1).toString() else ""
                )

                ActiveText(
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        ),
                    value = value.toString()
                )
                InactiveText(
                    value = (value + 1).toString(),
                    modifier = Modifier.weight(1.0f)
                        .align(
                            alignment = Alignment.CenterVertically
                        )
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.weight(1.0f)
                        .padding(16.dp)
                ) {
                    IconButton(
                        onClick = { onValueDecreased() },
                        enabled = value > 0
                    ) {
                        Text("-")
                    }
                }
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.weight(1.0f)
                        .padding(16.dp)
                ) {
                    IconButton(
                        onClick = { onValueIncreased() },
                    ) {
                        Image(imageVector = Icons.Default.Add, contentDescription = "")
                    }
                }
            }
        }

    }

}
