package com.saiph.crudtodo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo (todo: Todo)

    @Delete
    suspend fun deleteTodo (todo: Todo)

    @Query(value = "SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id:Int) : Todo?

    @Query(value = "SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>
}