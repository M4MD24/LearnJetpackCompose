package barmajaa.m4md24.learnjetpackcompose.concepts.dialogs

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import barmajaa.m4md24.learnjetpackcompose.concepts.buttons.DURATION_TOAST
import barmajaa.m4md24.learnjetpackcompose.concepts.dialogs.ui.PreviewUI

class Dialogs : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Normal(
    onDismissRequest : () -> Unit,
    onConfirmation : () -> Unit,
    painter : Painter
) {
    val context = LocalContext.current
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(300.dp),
                    painter = painter,
                    contentDescription = "Coffee",
                    contentScale = ContentScale.Fit
                )

                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "Would you like coffee?",
                    fontSize = 20.sp
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = Modifier
                            .width(100.dp)
                            .weight(1F),
                        onClick = {
                            onDismissRequest()

                            onConfirmation

                            Toast.makeText(
                                context,
                                "Sure",
                                DURATION_TOAST
                            ).show()
                        }
                    ) {
                        Text("Yes")
                    }

                    Spacer(modifier = Modifier.weight(0.25F))

                    Button(
                        modifier = Modifier
                            .width(100.dp)
                            .weight(1F),
                        onClick = {
                            onDismissRequest()

                            onDismissRequest

                            Toast.makeText(
                                context,
                                "No Problem",
                                DURATION_TOAST
                            ).show()
                        }
                    ) {
                        Text("No")
                    }
                }
            }
        }
    }
}