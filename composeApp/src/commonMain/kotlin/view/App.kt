package view
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import view.screens.CalculateComponent
import view.screens.HeightSlider
import view.screens.MetricComponent
import view.screens.SignComponents
import view.screens.WeightAndAgeComponent
import view.ui.theme.DarkColorScheme
import view.ui.theme.LightColorScheme

@Composable
fun BMICalculatorTheme(content: @Composable () -> Unit) {
    val colorScheme = if (isSystemInDarkTheme()) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme
    ) {
        content()
    }
}

@Composable
fun App() {
    BMICalculatorTheme {
        Scaffold(
            modifier = Modifier.statusBarsPadding(),
        ) {
            Column {
                MetricComponent()
                SignComponents()
                HeightSlider()
                WeightAndAgeComponent()
                CalculateComponent()
            }
        }
    }


}