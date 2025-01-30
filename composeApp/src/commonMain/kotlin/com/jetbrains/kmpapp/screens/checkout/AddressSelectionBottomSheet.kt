package com.jetbrains.kmpapp.screens.checkout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.AppSmallButton
import com.jetbrains.kmpapp.components.BottomSheetContainer
import com.jetbrains.kmpapp.components.SCREEN_PADDING
import com.jetbrains.kmpapp.components.roundedBordered

@Composable
fun AddressSelectionBottomSheet(onNewAddressSelection: () -> Unit = {}) {
    BottomSheetContainer(title = "Select Address", modifier = Modifier.fillMaxWidth()) {
        LazyColumn(
            contentPadding = PaddingValues(SCREEN_PADDING),
            verticalArrangement = Arrangement.spacedBy(
                SCREEN_PADDING
            )
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onNewAddressSelection()
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AddCircle,
                        contentDescription = "add",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Add New address",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
            items(10) {
                AddressItem(isForDelivery = true)
            }
        }
    }
}

@Composable
fun AddressItem(isForDelivery: Boolean = false) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .roundedBordered()
            .padding(SCREEN_PADDING)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Krupal Mehta",
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "+91 9662143557",
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Text(
            text = "D-12/138 Nandanvan appt, Nava Vadaj, Ahmedabad",
            modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "380013",
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyMedium
            )

            AppSmallButton(
                text = if (isForDelivery) "Deliver Here" else "Edit"
            )
        }
    }
}