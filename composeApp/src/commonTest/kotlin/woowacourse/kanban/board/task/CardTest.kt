package woowacourse.kanban.board.task

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import woowacourse.kanban.board.domain.Task

@OptIn(ExperimentalTestApi::class)
class CardTest {

    @Test
    fun `제목 설명 태그 담당자 모두 노출`() = runComposeUiTest {
        val task = Task(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagNames = listOf("컴포넌트", "성능"),
            contactName = "다이노",
        )
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", useUnmergedTree = true).assertExists()
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertExists()
        onNodeWithText("성능", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `제목 태그 담당자만 노출`() = runComposeUiTest {
        val task = Task(
            title = "LazyColumn 컴포넌트 구현",
            contents = null,
            tagNames = listOf("컴포넌트"),
            contactName = "다이노",
        )
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `제목 설명 담당자만 노출`() = runComposeUiTest {
        val task = Task(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagNames = emptyList(),
            contactName = "다이노",
        )
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `제목 담당자만 노출`() = runComposeUiTest {
        val task = Task(
            title = "LazyColumn 컴포넌트 구현",
            contents = null,
            tagNames = emptyList(),
            contactName = "다이노",
        )
        setContent {
            TaskCard(task = task)
        }
        onNodeWithText("LazyColumn 컴포넌트 구현", useUnmergedTree = true).assertExists()
        onNodeWithText("다이노", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `태그 2개 노출`() = runComposeUiTest {
        val task = Task(
            title = "태스크",
            contents = null,
            tagNames = listOf("컴포넌트", "성능"),
            contactName = "다이노",
        )
        setContent {
            TaskCard(task = task)
        }
        val buttonMatcher = SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button)
        onAllNodes(buttonMatcher, useUnmergedTree = true).assertCountEquals(2)
    }
}
