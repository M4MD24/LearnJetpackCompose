package barmajaa.m4md24.learnjetpackcompose.concepts.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import barmajaa.m4md24.learnjetpackcompose.concepts.layouts.ui.PreviewUI

class Layouts : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}

val margin = 5.dp
val padding = 40.dp
val edgeDistance = 20.dp
@Composable
private fun Texts() {
    Text("First")
    Text("Second")
    Text("Third")
}
@Composable
fun Box() = Box(
    modifier = Modifier
        .padding(margin)/*padding*/
        .background(Color.Blue)
        .padding(padding)/*margin*/
) {
    Texts()
}
@Composable
fun ConstraintLayout() = ConstraintLayout(
    modifier = Modifier
        .size(200.dp)
        .padding(margin)/*padding*/
        .background(Color.Gray)
        .padding(padding)/*margin*/
) {
    val (
        topStart,
        topTop,
        topEnd,
        startStart,
        center,
        endEnd,
        bottomStart,
        bottomBottom,
        bottomEnd
    ) = createRefs()

    Text(
        modifier = Modifier.constrainAs(
            topStart
        ) {
            top.linkTo(
                parent.top,
                edgeDistance
            )
            start.linkTo(
                parent.start,
                edgeDistance
            )
        },
        text = "┌"
    )

    Text(
        modifier = Modifier.constrainAs(
            topTop
        ) {
            top.linkTo(
                parent.top
            )
            start.linkTo(
                parent.start
            )
            end.linkTo(
                parent.end
            )
        },
        text = "─"
    )

    Text(
        modifier = Modifier.constrainAs(
            topEnd
        ) {
            top.linkTo(
                parent.top,
                edgeDistance
            )
            end.linkTo(
                parent.end,
                edgeDistance
            )
        },
        text = "┐"
    )

    Text(
        modifier = Modifier.constrainAs(
            startStart
        ) {
            top.linkTo(
                parent.top
            )
            start.linkTo(
                parent.start
            )
            bottom.linkTo(
                parent.bottom
            )
        },
        text = "│"
    )

    Text(
        modifier = Modifier.constrainAs(
            center
        ) {
            top.linkTo(
                parent.top
            )
            start.linkTo(
                parent.start
            )
            end.linkTo(
                parent.end
            )
            bottom.linkTo(
                parent.bottom
            )
        },
        text = "■"
    )

    Text(
        modifier = Modifier.constrainAs(
            endEnd
        ) {
            top.linkTo(
                parent.top
            )
            end.linkTo(
                parent.end
            )
            bottom.linkTo(
                parent.bottom
            )
        },
        text = "│"
    )


    Text(
        modifier = Modifier.constrainAs(
            bottomStart
        ) {
            start.linkTo(
                parent.start,
                edgeDistance
            )
            bottom.linkTo(
                parent.bottom,
                edgeDistance
            )
        },
        text = "└"
    )

    Text(
        modifier = Modifier.constrainAs(
            bottomBottom
        ) {
            start.linkTo(
                parent.start
            )
            end.linkTo(
                parent.end
            )
            bottom.linkTo(
                parent.bottom
            )
        },
        text = "─"
    )

    Text(
        modifier = Modifier.constrainAs(
            bottomEnd
        ) {
            end.linkTo(
                parent.end,
                edgeDistance
            )
            bottom.linkTo(
                parent.bottom,
                edgeDistance
            )
        },
        text = "┘"
    )
}