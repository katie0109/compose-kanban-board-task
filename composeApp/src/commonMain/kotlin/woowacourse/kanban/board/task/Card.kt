package woowacourse.kanban.board.task

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskCard(title: String, contents: String? = null, tagNames: List<String> = emptyList(), contactName: String) {
    Column(
        modifier = Modifier
            .width(286.dp)
            .border(2.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .padding(start = 22.5.dp, end = 22.5.dp, top = 22.5.dp, bottom = 22.5.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TaskTitle(title)
        if (contents != null) TaskContents(contents)
        if (tagNames.isNotEmpty()) TaskTags(tagNames)
        TaskContact(contactName)
    }
}
