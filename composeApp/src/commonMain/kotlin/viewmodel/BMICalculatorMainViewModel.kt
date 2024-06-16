package viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class BMICalculatorMainViewModel : ViewModel() {

    var bmiState = MutableStateFlow(State())
        private set

    fun handleViewEvent(event: BMICalculatorEvent) {
        when (event) {
            is BMICalculatorEvent.HeightChanged -> {
                updateState(bmiState.value.copy(height = event.height))
            }

            is BMICalculatorEvent.AgeChanged -> {
                updateState(bmiState.value.copy(age = event.age))
            }

            is BMICalculatorEvent.SexChanged -> {
                updateState(bmiState.value.copy(sex = event.sex))
            }

            BMICalculatorEvent.CalculateClicked -> calculateBMI()

            is BMICalculatorEvent.WeightChanged -> {
                updateState(bmiState.value.copy(weight = event.weight))
            }
        }
    }

    private fun calculateBMI() {
        TODO("Not yet implemented")
    }

    private fun updateState(state: State) {
        bmiState.update { state }
    }

    data class State(
        val sex: String = "",
        val height: Float = 150f,
        val weight: Int = 50,
        val age: Int = 25
    )
}