package com.vaskorr.testapp.presentation.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vaskorr.testapp.presentation.ui.theme.TestAppTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(50.dp),
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = text,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
private fun Preview() {
    TestAppTheme {
        Surface {
            PrimaryButton(
                modifier = Modifier.padding(16.dp),
                text = "Text"
            )
        }
    }
}