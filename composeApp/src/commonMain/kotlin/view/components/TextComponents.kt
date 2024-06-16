package view.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import view.ui.theme.Orange

@Composable
fun ActiveText(
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = value,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = Orange,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun InactiveText(
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = value,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        color = Color.LightGray,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SecondaryInactiveText(
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = value,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        color = Color.LightGray,
        fontWeight = FontWeight.Bold
    )
}