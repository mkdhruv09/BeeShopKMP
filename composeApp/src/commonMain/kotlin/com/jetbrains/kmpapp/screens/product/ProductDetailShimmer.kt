package com.jetbrains.kmpapp.screens.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.BORDER_WIDTH
import com.jetbrains.kmpapp.components.SCREEN_PADDING
import com.jetbrains.kmpapp.theme.ShimmerBorderColor
import com.jetbrains.kmpapp.theme.ShimmerColor

@Composable
fun ProductDetailShimmer() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(SCREEN_PADDING))
        val pagerState = rememberPagerState(pageCount = {
            3
        }, initialPage = 1)
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 60.dp),
            pageSpacing = 8.dp
        ) {
            Box(modifier = Modifier) {
                Spacer(
                    modifier = Modifier
                        .aspectRatio(1.0f)
                        .clip(RoundedCornerShape(5))
                        .background(
                            color = ShimmerColor,
                            shape = RoundedCornerShape(10)
                        )
                        .border(
                            width = BORDER_WIDTH,
                            color = ShimmerBorderColor,
                            shape = RoundedCornerShape(10)
                        )
                        .carouselTransition(it, pagerState)
                )

                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    tint = ShimmerBorderColor
                )
            }
        }


        Column(
            modifier = Modifier.padding(SCREEN_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(10) {
                    Spacer(
                        modifier = Modifier
                            .size(80.dp)
                            .background(
                                color = ShimmerColor,
                                shape = RoundedCornerShape(10)
                            )
                            .border(
                                width = BORDER_WIDTH,
                                color = ShimmerBorderColor,
                                shape = RoundedCornerShape(10)
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        color = ShimmerColor,
                        shape = RoundedCornerShape(10)
                    )
                    .border(
                        width = BORDER_WIDTH,
                        color = ShimmerBorderColor,
                        shape = RoundedCornerShape(10)
                    )
            )

            Spacer(modifier = Modifier.weight(1f))
            Spacer(
                modifier = Modifier
                    .width(180.dp)
                    .height(40.dp)
                    .background(
                        color = ShimmerColor,
                        shape = RoundedCornerShape(100)
                    )
                    .border(
                        width = BORDER_WIDTH,
                        color = ShimmerBorderColor,
                        shape = RoundedCornerShape(100)
                    )
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}