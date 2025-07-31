package com.vaskorr.testapp.presentation.screen.purchases

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.vaskorr.testapp.presentation.navigation.Routes
import com.vaskorr.testapp.presentation.ui.components.button.BackButton
import com.vaskorr.testapp.presentation.ui.components.card.ClickableTextCard
import com.vaskorr.testapp.presentation.ui.theme.TestAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PurchasesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: PurchasesViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PurchasesScreenContent(
        modifier = modifier,
        state = uiState,
        onBackClick = { navController.navigate(Routes.MAIN_SCREEN) }
    )
}

@Composable
fun PurchasesScreenContent(
    modifier: Modifier = Modifier,
    state: PurchasesScreenState,
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
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            state.purchasesData.forEach { dateItems ->
                Text(
                    text = dateItems.key.toString(),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    dateItems.value.forEach { purchase ->
                        ClickableTextCard(
                            text = purchase,
                            onClick = { }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    TestAppTheme {
        PurchasesScreenContent(
            state = PurchasesScreenState()
        )
    }
}