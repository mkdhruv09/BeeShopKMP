package com.jetbrains.kmpapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil3.compose.AsyncImage
import com.jetbrains.kmpapp.theme.BeeShopTheme
import kotlin.math.ceil
import kotlin.math.floor


@Composable
fun AppToolbar(
    title: String = "",
    showBack: Boolean = false,
    showDivider: Boolean = true,
    onBackPress: () -> Unit = {},
    endWidget: @Composable () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding())
            .fillMaxWidth()
            .height(40.dp)
    )
    {
        if (showBack) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "back",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(vertical = 5.dp, horizontal = 10.dp)
                    .clickable {
                        onBackPress()
                    }
            )
        }
        Text(
            textAlign = TextAlign.Center,
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 30.dp),
            style = MaterialTheme.typography.headlineSmall,
            maxLines = 1
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)

        ) {
            endWidget()
        }
        if (showDivider) {
            SmallDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun SearchView(modifier: Modifier = Modifier, text: String = "") {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(
                width = BORDER_WIDTH,
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(50)
            )
    )
    {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 50.dp),
            style = MaterialTheme.typography.labelMedium
        )
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
        )
    }
}

data class BottomBarDestination(
    val title: String,
    val icon: ImageVector,
    val key: String
)

@Composable
fun AppNavigationBar(
    listItems: List<BottomBarDestination> = emptyList(),
    selected: String,
    onNavigationChange: (key: String) -> Unit = {}
) {
    NavigationBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        windowInsets = WindowInsets.navigationBars
    ) {
        listItems.forEach { destination ->
            NavigationBarItem(
                selected = selected == destination.key,
                onClick = {
                    onNavigationChange(destination.key)
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    indicatorColor = MaterialTheme.colorScheme.onPrimary
                ),
            )
        }
    }
}


@Composable
fun FullButton(modifier: Modifier = Modifier, text: String = "Button", onClick: () -> Unit = {}) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(color = MaterialTheme.colorScheme.primary)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RectangleShape
            )
            .clickable { onClick() }
    )
    {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Center),
            style = MaterialTheme.typography.titleMedium
        )
    }
}


@Composable
fun NoDataView(modifier: Modifier = Modifier, message: String = "No data found") {
    Box(modifier = modifier)
    {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Filled.Notifications,
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = message,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}


@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    icon: ImageVector? = null,
    text: String = "Button",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
        enabled = isEnabled
    ) {
        icon?.let {
            Icon(imageVector = icon, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun AppSmallButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    withBorder: Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(100)
            )
            .run {
                if (withBorder) {
                    border(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(100),
                        width = BORDER_WIDTH
                    )
                } else this
            }
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickable { onClick() },
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun AppOutlinedButton(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    text: String = "Button",
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
        border = BorderStroke(width = BORDER_WIDTH, color = MaterialTheme.colorScheme.onPrimary),
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onPrimary)
    ) {
        icon?.let {
            Icon(imageVector = icon, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
        }

        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    placeHolder: String = "",
    onValueChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        modifier = modifier,
        value = value,
        placeholder = {
            Text(text = placeHolder, color = MaterialTheme.colorScheme.onPrimary)
        },
        onValueChange = onValueChange,
        shape = RoundedCornerShape(100),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary
        ),
        maxLines = 1
    )
}

@Composable
fun SmallDivider(
    modifier: Modifier = Modifier,
    isLight: Boolean = false
) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(BORDER_WIDTH)
            .background(
                color = if (isLight) {
                    MaterialTheme.colorScheme.onPrimary.copy(0.5f)
                } else {
                    MaterialTheme.colorScheme.onPrimary
                }
            )
    )
}


@Composable
fun ListHeader(title: String = "Header", showViewAll: Boolean = true) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.headlineMedium,
        )
        if (showViewAll) {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable { }, verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "View all",
                    modifier = Modifier.padding(horizontal = 2.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelMedium
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "next",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}


@Composable
fun AppScreenScaffold(
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = containerColor,
        topBar = topBar,
        bottomBar = bottomBar
    ) { paddingValues ->
        BeeShopTheme {
            content(paddingValues)
        }
    }
}


@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5
) {
    val starsColor: Color = MaterialTheme.colorScheme.onPrimary
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))
    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(imageVector = Icons.Filled.Star, contentDescription = null, tint = starsColor)
        }
        if (halfStar) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = starsColor
            )
        }
        repeat(unfilledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = starsColor
            )
        }
    }
}


@Composable
fun AppDialog(
    title: String = "Title here",
    message: String = "Message here",
    positiveAction: Pair<String, (() -> Unit)?>? = null,
    negativeAction: Pair<String, (() -> Unit)?>? = null,
    onDismiss: () -> Unit = { },
) {
    BeeShopTheme {
        Dialog(
            onDismissRequest = {
                onDismiss()
            },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
        ) {
            AppDialogContent(title, message, negativeAction, onDismiss, positiveAction)
        }
    }
}


@Composable
fun AppDialogContent(
    title: String = "Title",
    message: String = "Message",
    negativeAction: Pair<String, (() -> Unit)?>? = null,
    onDismiss: () -> Unit = {},
    positiveAction: Pair<String, (() -> Unit)?>? = null
) {
    Column(modifier = Modifier) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(15),
                )
                .clip(RoundedCornerShape(15))
                .border(
                    width = BORDER_WIDTH,
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(15)
                ),
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.primary)
                        .padding(vertical = 16.dp, horizontal = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                SmallDivider(isLight = true)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = message,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.size(15.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        AppButton(onClick = {
                            negativeAction?.second?.invoke()
                            onDismiss()
                        }, text = negativeAction?.first ?: "")

                        AppOutlinedButton(onClick = {
                            positiveAction?.second?.invoke()
                            onDismiss()
                        }, text = positiveAction?.first ?: "")
                    }
                }
            }
        }
    }
}


@Composable
fun Avatar(modifier: Modifier = Modifier, url: String = "", name: String = "") {
    val nameInitials = name.replace(Regex("^\\s*([a-zA-Z]).*\\s+([a-zA-Z])\\S+\$\n"), "$1$2")
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .border(
                width = BORDER_WIDTH,
                shape = CircleShape,
                color = MaterialTheme.colorScheme.onPrimary
            )
    )
    {
        Text(
            text = "KM",
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}


@Composable
fun ChipViews(items: List<String>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        itemsIndexed(items) { index, item ->
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                text = item,
                modifier = Modifier
                    .run {
                        if (index == 4) {
                            background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(100)
                            )
                        } else this
                    }
                    .border(
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(100),
                        width = BORDER_WIDTH
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
    }
}

@Composable
fun GlideImage(
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    model: String,
    contentDescription: String = "",
) {
    AsyncImage(
        model = model,
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
fun AppSwitch(value: Boolean, onValueChange: (Boolean) -> Unit = {}) {
    val trackColor = MaterialTheme.colorScheme.onPrimary
    val thumbColorChecked = MaterialTheme.colorScheme.primary
    Switch(
        checked = value,
        onCheckedChange = {
            onValueChange.invoke(it)
        },
        modifier = Modifier.height(20.dp),
        colors = SwitchDefaults.colors(
            uncheckedBorderColor = trackColor,
            uncheckedTrackColor = trackColor,
            checkedBorderColor = trackColor,
            checkedTrackColor = trackColor,
            checkedThumbColor = thumbColorChecked,
            uncheckedThumbColor = thumbColorChecked.copy(alpha = 0.7f),
        ),
        thumbContent = if (value) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                    tint = trackColor
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun BottomSheetContainer(title: String, modifier: Modifier, content: @Composable () -> Unit = {}) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topStartPercent = 5, topEndPercent = 5))
            .border(
                width = BORDER_WIDTH,
                shape = RoundedCornerShape(topEndPercent = 5, topStartPercent = 5),
                color = MaterialTheme.colorScheme.onPrimary
            )
    ) {
        AppToolbar(title = title, showDivider = true)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            content()
        }
    }
}

@Composable
fun Modifier.roundedBackground(color: Color) = this.then(
    Modifier.background(
        color = color,
        shape = RoundedCornerShape(10.dp)
    )
)

@Composable
fun Modifier.roundedBordered() = this.then(
    Modifier
        .border(
            width = BORDER_WIDTH,
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
        .clip(RoundedCornerShape(10.dp))
)


@Composable
fun Modifier.roundedUnBordered() = this.then(
    Modifier.clip(RoundedCornerShape(10.dp))
)