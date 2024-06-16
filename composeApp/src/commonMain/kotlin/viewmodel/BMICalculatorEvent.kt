package viewmodel

sealed interface BMICalculatorEvent {
    data class HeightChanged(val height: Float) : BMICalculatorEvent
    data class WeightChanged(val weight: Int) : BMICalculatorEvent
    data class AgeChanged(val age: Int) : BMICalculatorEvent
    data class SexChanged(val sex: String) : BMICalculatorEvent
    data object CalculateClicked : BMICalculatorEvent
}