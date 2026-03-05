package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.task.TaskCard

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 62.5.dp, vertical = 60.dp)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.5.dp)
            ){
                val tagNames = listOf("컴포넌트", "성능")
                TaskCard("LazyColumn 컴포넌트 구현", "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", tagNames, "다이노")

                val tagNames02 = listOf("컴포넌트", "성능")
                TaskCard("LazyColumn 컴포넌트 구현", "", tagNames02, "다이노")

                val tagNames03 = emptyList<String>()
                TaskCard("LazyColumn 컴포넌트 구현", "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", tagNames03, "다이노")

                val tagNames04 = emptyList<String>()
                TaskCard("LazyColumn 컴포넌트 구현", ".", tagNames04, "다이노")

                val tagNames05 = listOf("너무너무", "성능", "긴 태그", "최대로", "5자까지", "5개제한임")
                TaskCard("너무너무긴제목은 한줄까지만 노출됩니다.", "너무너무 긴 설명은 두 줄깢만 노출하고 말줄임표로 처리합니다. 너무너무 긴 설명은 두 줄깢만 노출하고 말줄임표로 처리합니다.", tagNames05, "너무너무너무 긴 담당자도 한 줄로 표시됩니다.")


            }

            }
        }
    }
