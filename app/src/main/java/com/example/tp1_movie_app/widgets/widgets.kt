package com.example.tp1_movie_app.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tp1_movie_app.model.Movie
import com.example.tp1_movie_app.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()

            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp,
            ) {

                AsyncImage(
                    model = movie.images[0],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )

                /*Image(painter = rememberImagePainter(data = movie.images[0]),
                    contentDescription = "Poster")*/
            }

            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Director : ${movie.director}",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "Released : ${movie.year}",
                    style = MaterialTheme.typography.labelMedium
                )

                AnimatedVisibility(visible = expanded) {
                    Column {
                        /*Text(text = "Actors : ${movie.actors}",
                            style = MaterialTheme.typography.labelMedium)
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                                fontSize = 13.sp, fontWeight = FontWeight.Bold
                            )){
                                append("Plot : ")
                            }
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                                fontSize = 13.sp
                            )){
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))*/
                        Divider()
                        Text(
                            text = "Actors : ${movie.actors}",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = "Genre : ${movie.genre}",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = "Rating : ${movie.rating}",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }


                }


                Icon(
                    imageVector =
                    if (!expanded) Icons.Filled.KeyboardArrowDown
                    else Icons.Filled.KeyboardArrowUp,
                    contentDescription = "details",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { expanded = !expanded },
                    tint = Color.DarkGray
                )
            }
        }

    }
}
