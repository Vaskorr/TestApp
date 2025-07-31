package com.vaskorr.testapp.presentation.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.vaskorr.testapp.R
import com.vaskorr.testapp.presentation.navigation.Routes
import com.vaskorr.testapp.presentation.ui.components.button.BackButton
import com.vaskorr.testapp.presentation.ui.components.card.ClickableTextCard
import com.vaskorr.testapp.presentation.ui.components.card.EmailCard
import com.vaskorr.testapp.presentation.ui.components.card.LanguageCard
import com.vaskorr.testapp.presentation.ui.components.card.ToggleCard
import com.vaskorr.testapp.presentation.ui.theme.TestAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MainViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MainScreenContent(
        modifier = modifier,
        state = uiState,
        onPurchasesClick = { navController.navigate(Routes.PURCHASES_SCREEN) },
        onRegisterClick = { navController.navigate(Routes.REGISTER_SCREEN) },
        onBackClick = { }
    )
}

@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    state: MainScreenState,
    onPurchasesClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            BackButton(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                onClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(32.dp)
        ) {

            Text(
                text = state.user?.name ?: stringResource(R.string.art),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.user?.surname ?: stringResource(R.string.art),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.random_phone),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.my_purchases),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ClickableTextCard(
                text = stringResource(R.string.my_purchases),
                onClick = onPurchasesClick
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.settings),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            EmailCard(
                email = stringResource(R.string.random_email),
                onClick = { }
            )
            Spacer(modifier = Modifier.height(8.dp))
            ToggleCard(
                text = stringResource(R.string.biometric_enter)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ClickableTextCard(
                text = stringResource(R.string.change_4_symbols_code),
                onClick = { }
            )
            Spacer(modifier = Modifier.height(8.dp))
            ClickableTextCard(
                text = stringResource(R.string.registration_for_clients),
                onClick = onRegisterClick
            )
            Spacer(modifier = Modifier.height(8.dp))
            LanguageCard(
                text = stringResource(R.string.language),
                value = stringResource(R.string.russian),
                onClick = { }
            )

        }
    }
}

@Preview
@Composable
private fun Preview() {
    TestAppTheme {
        MainScreenContent(
            state = MainScreenState()
        )
    }
}