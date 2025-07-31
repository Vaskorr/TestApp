package com.vaskorr.testapp.presentation.screen.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.vaskorr.testapp.R
import com.vaskorr.testapp.presentation.navigation.Routes
import com.vaskorr.testapp.presentation.ui.components.button.BackButton
import com.vaskorr.testapp.presentation.ui.components.button.PrimaryButton
import com.vaskorr.testapp.presentation.ui.components.textfield.TestAppTextField
import com.vaskorr.testapp.presentation.ui.theme.TestAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: RegisterViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    RegisterScreenContent(
        modifier = modifier,
        state = uiState,
        onFurtherClick = {
            viewModel.onAction(RegisterAction.GoFurther)
            navController.navigate(Routes.MAIN_SCREEN)
        },
        onBackClick = { navController.navigate(Routes.MAIN_SCREEN) },
        onBankNumberChange = { viewModel.onAction(RegisterAction.OnBankNumberChange(it)) },
        onBankCodeChange = { viewModel.onAction(RegisterAction.OnBankCodeChange(it)) },
        onNameChange = { viewModel.onAction(RegisterAction.OnNameChange(it)) },
        onSurnameChange = { viewModel.onAction(RegisterAction.OnSurnameChange(it)) }
    )
}

@Composable
fun RegisterScreenContent(
    modifier: Modifier = Modifier,
    state: RegisterScreenState,
    onBankNumberChange: (String) -> Unit = {},
    onBankCodeChange: (String) -> Unit = {},
    onNameChange: (String) -> Unit = {},
    onSurnameChange: (String) -> Unit = {},
    onFurtherClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.by_pressing_you_agree)
                )
                Spacer(modifier = Modifier.height(8.dp))
                PrimaryButton(
                    text = stringResource(R.string.further),
                    enabled = state.isButtonEnabled,
                    onClick = onFurtherClick
                )
            }
        },
        topBar = {
            BackButton(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                onClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier
                .padding(paddingValues)
                .padding(32.dp)
                .verticalScroll(rememberScrollState())
                .imePadding()
        ) {
            Text(
                text = stringResource(R.string.registration_for_clients),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TestAppTextField(
                text = state.bankNumber ?: "",
                placeholder = stringResource(R.string.member_number),
                description = stringResource(R.string.number_from_bank),
                isError = !state.isBankNumberCorrect,
                onTextChange = onBankNumberChange
            )
            Spacer(modifier = Modifier.height(16.dp))
            TestAppTextField(
                text = state.bankCode ?: "",
                placeholder = stringResource(R.string.code),
                description = stringResource(R.string.code_from_bank),
                isError = !state.isBankCodeCorrect,
                onTextChange = onBankCodeChange
            )
            Spacer(modifier = Modifier.height(16.dp))
            TestAppTextField(
                text = state.name ?: "",
                placeholder = stringResource(R.string.name),
                description = stringResource(R.string.name_latin_from_passport),
                isError = !state.isNameCorrect,
                onTextChange = onNameChange
            )
            Spacer(modifier = Modifier.height(16.dp))
            TestAppTextField(
                text = state.surname ?: "",
                placeholder = stringResource(R.string.surname),
                description = stringResource(R.string.surname_latin_from_passport),
                isError = !state.isSurnameCorrect,
                onTextChange = onSurnameChange
            )

        }
    }
}

@Preview
@Composable
private fun Preview() {
    TestAppTheme {
        RegisterScreenContent(
            state = RegisterScreenState()
        )
    }
}