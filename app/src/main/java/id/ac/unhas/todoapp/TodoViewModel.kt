package id.ac.unhas.todoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.id.ac.unhas.todolist.todolist.Todolist
import com.id.ac.unhas.todolist.todolist.TodolistRepository

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private var todoRepository = TodolistRepository(application)
    private var todos: LiveData<List<Todolist>>? = todoRepository.getTodolists()


    fun getTodos(): LiveData<List<Todolist>>? {
        return todos
    }

    fun insertTodo(todolist: Todolist) {
        todoRepository.insert(todolist)
    }

    fun deleteTodo(todolist: Todolist) {
        todoRepository.delete(todolist)
    }

    fun updateTodo(todolist: Todolist) {
        todoRepository.update(todolist)
    }
}