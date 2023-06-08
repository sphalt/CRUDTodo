package com.saiph.crudtodo.ui.todo_list

import com.saiph.crudtodo.data.Todo

sealed class TodoListEvent {
    //delete
    data class DeleteTodo(val todo: Todo): TodoListEvent()
    //edit
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    //done
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    //add
    object OnAddTodoClick: TodoListEvent()
    //undo
    object OnUndoDeleteClick: TodoListEvent()
}
