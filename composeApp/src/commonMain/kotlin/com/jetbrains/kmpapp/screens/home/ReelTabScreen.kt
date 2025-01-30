package com.jetbrains.kmpapp.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.AppSmallButton
import com.jetbrains.kmpapp.components.GlideImage
import com.jetbrains.kmpapp.data.model.Product

@Composable
fun ReelsTabScreen() {
    Scaffold(containerColor = MaterialTheme.colorScheme.primary) { paddingValues ->
        Box {
            VerticalPager(state = rememberPagerState(initialPage = 0, pageCount = { 10 })) {
                ReelItem(onProductClick = {

                })
            }
        }
    }
}

@Composable
private fun ReelItem(onProductClick: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize()) {
        GlideImage(
            model = "https://picsum.photos/800/1400",
            contentDescription = "",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        )
        {
            //YouTubePlayerWrapper(videoId = "4ujYxSW3chw", modifier = Modifier.fillMaxHeight())
            GlideImage(
                model = Product.SAMPLE_IMAGE,
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(20))
                    .clickable { onProductClick() },
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Automatic Needle Threading Device (Multicolor)",
                    color = Color.White,
                    modifier = Modifier,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "₹ 375",
                    color = Color.White,
                    modifier = Modifier,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            AppSmallButton(
                text = "Add to Cart",
                withBorder = true,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 100.dp)
                .padding(16.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(100)
                )
                .padding(vertical = 8.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Filled.Share,
                contentDescription = "share",
                modifier = Modifier.padding(8.dp),
                tint = Color.White
            )
            Text(text = "Share", color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "like",
                modifier = Modifier.padding(8.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(text = "Like", color = Color.White)
        }
    }
}
