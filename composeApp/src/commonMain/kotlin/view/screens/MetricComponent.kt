package view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import view.ext.noRippleClickable
import view.ui.theme.LightColorScheme
import view.ui.theme.Orange

enum class System {
    Imperial, Metric
}

@Composable
fun MetricComponent(modifier: Modifier = Modifier) {
    var isSelected by remember {
        mutableStateOf(System.Imperial)
    }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier.padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            SelectableRoundedButton(
                text = System.Imperial.name,
                isSelected = isSelected == System.Imperial,
                modifier = Modifier.weight(1f)
                    .padding(end = 2.dp)
            ) {
                isSelected = System.Imperial
            }
            SelectableRoundedButton(
                text = System.Metric.name,
                isSelected = isSelected == System.Metric,
                modifier = Modifier.weight(1f)
                    .padding(start = 2.dp)
            ) {
                isSelected = System.Metric
            }
        }
    }
}

@Composable
fun SelectableRoundedButton(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    onClick: () -> Unit
) {
    val cardElevation =
        if (isSelected) CardDefaults.cardElevation(defaultElevation = 8.dp) else CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    Card(
        modifier = modifier.fillMaxWidth()
            .background(
                shape = RoundedCornerShape(cornerRadius),
                color = LightColorScheme.surface
            )
            .noRippleClickable {
                onClick()
            },
        elevation = cardElevation,
        shape = if (isSelected) RoundedCornerShape(cornerRadius) else RoundedCornerShape(0.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = if (isSelected) Orange else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.Center)
            )
        }

    }
}