package woowacourse.kanban.board.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskTags(tagNames: List<String>) {
    val checkedTageNames = tagNames.map {
        checkTageName(it)
    }.subList(0, minOf(tagNames.size, 5))
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        checkedTageNames.forEach {
            TaskTag(it)
        }
    }
}
@Composable
private fun TaskTag(tagName: String) {
    Button(
        modifier = Modifier
            .height(32.dp),
        onClick = {
        },
        shape = RoundedCornerShape(21.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
        contentPadding = PaddingValues(vertical = 5.dp, horizontal = 10.dp),
    ) {
        Text(
            text = tagName,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontSize = 12.sp,
        )
    }
}

private fun checkTageName(tagName: String): String = tagName.take(5)

