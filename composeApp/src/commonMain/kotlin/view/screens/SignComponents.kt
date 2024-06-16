package view.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import bmicalculator.composeapp.generated.resources.Res
import bmicalculator.composeapp.generated.resources.baseline_female
import bmicalculator.composeapp.generated.resources.baseline_male
import bmicalculator.composeapp.generated.resources.baseline_transgender
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import view.ui.theme.Orange

enum class Gender(
    val resource: DrawableResource,
    val label: String,
    val colorFilter: Color
) {
    Male(resource = Res.drawable.baseline_male, label = "Male", colorFilter = Color(0xFF5870a7)),
    Female(
        resource = Res.drawable.baseline_female,
        label = "Female",
        colorFilter = Color(0xFFe878e0)
    ),
    Other(
        resource = Res.drawable.baseline_transgender,
        label = "Other",
        colorFilter = Color.LightGray
    ),
    Unknown(
        resource = Res.drawable.baseline_transgender,
        label = "Unknown",
        colorFilter = Color.Gray
    )
}

@Composable
fun SignComponents(modifier: Modifier = Modifier) {
    var isSelected by remember {
        mutableStateOf(Gender.Unknown)
    }
    val genders = listOf(
        Gender.Male,
        Gender.Female,
        Gender.Other
    )
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        genders.forEach {
            GenderComponent(
                modifier = Modifier.weight(1f)
                    .align(Alignment.CenterVertically),
                gender = it,
                isSelected = isSelected == it
            ) {
                isSelected = it
            }
        }
    }
}

@Composable
@Preview
fun GenderComponent(
    modifier: Modifier = Modifier,
    gender: Gender, contentDescription: String? = null,
    isSelected: Boolean,
    onClick: () -> Unit = {}
) {
    val borderColor = if (isSelected) {
        if (isSystemInDarkTheme()) {
            Color.White
        } else Orange
    } else {
        Color.Transparent
    }
    Card(
        modifier = modifier.height(100.dp).padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = if (isSelected) 2.dp else 1.dp,
            color = borderColor
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(gender.resource),
                contentDescription = contentDescription,
                tint = gender.colorFilter,
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
            )
            Text(
                text = gender.label,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 4.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}