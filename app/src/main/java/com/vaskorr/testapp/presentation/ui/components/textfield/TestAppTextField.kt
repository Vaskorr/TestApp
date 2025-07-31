package com.vaskorr.testapp.presentation.ui.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vaskorr.testapp.R
import com.vaskorr.testapp.presentation.ui.theme.TestAppTheme

@Composable
fun TestAppTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    text: String,
    singleLine: Boolean = true,
    onTextChange: (String) -> Unit,
    isError: Boolean = false,
    description: String? = null
) {
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = text,
            isError = isError,
            onValueChange = onTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                errorContainerColor = MaterialTheme.colorScheme.primaryContainer,
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
            ),
            supportingText = {
                Text(
                    text = if (isError) stringResource(R.string.wrong_data) else description ?: "",
                )
            },
            singleLine = singleLine,
            shape = RoundedCornerShape(16.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    TestAppTheme {
        Surface {
            Column {
                TestAppTextField(
                    modifier = Modifier.padding(16.dp),
                    text = "",
                    placeholder = "placeholder",
                    description = "description",
                    onTextChange = {}
                )
                TestAppTextField(
                    modifier = Modifier.padding(16.dp),
                    text = "123",
                    placeholder = "placeholder",
                    description = "description",
                    onTextChange = {},
                    isError = true
                )
            }
        }
    }
}