package com.example.articleapp.feature.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.articleapp.common.CustomAppBar
import com.example.articleapp.feature.home.HomeViewModel

@Composable
fun DetailsScreen(onBackClicked: () -> Unit,viewModel: HomeViewModel) {
    val article = viewModel.selectedArticle
    Scaffold(
        topBar = {
            CustomAppBar(
                title = article.value?.title ?: "New One",
                hasBack = true,
                onClicked = {
                    onBackClicked()
                }
            )
        }
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(28.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            ){
                Column(modifier = Modifier.padding(16.dp)) {
                    article.value?.apply {

                        thumbnail?.let {

                            if (it.isNotEmpty()) AsyncImage(
                                model = it,
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        Text(text = description ?: "", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = authorName ?: "", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.align(
                            Alignment.End
                        ))
                    }
                }
            }

        }
    }
}