package com.saiph.crudtodo.ui.todo_list

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saiph.crudtodo.data.Todo
import com.saiph.crudtodo.ui.theme.md_theme_dark_onSurfaceVariant
import com.saiph.crudtodo.ui.theme.md_theme_dark_surfaceVariant


@Composable
fun TodoItem(
    todo: Todo,
    onEvent: (TodoListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(start = 16.dp, top = 8.dp, end = 24.dp, bottom = 8.dp),
    ) {
        Row (
            modifier = modifier
                .padding(start = 16.dp, top = 8.dp, end = 24.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Checkbox(
                checked = todo.isDone,
                onCheckedChange = { isChecked ->
                    onEvent(TodoListEvent.OnDoneChange(todo, isChecked)) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = todo.title,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                }
                todo.description?.let {
                    Text(
                        text = it,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                }
            }
            IconButton(
                onClick = {
                    onEvent(TodoListEvent.DeleteTodo(todo))
                }) {
                Icon(imageVector = Icons.Outlined.Delete , contentDescription = "Delete Todo")
            }
        }
    }
}
