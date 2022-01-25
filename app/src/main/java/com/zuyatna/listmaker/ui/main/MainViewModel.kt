package com.zuyatna.listmaker.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.zuyatna.listmaker.models.TaskList

class MainViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    lateinit var list: TaskList

    lateinit var onTaskAdded: (() -> Unit)

    lateinit var onListsAdded: (() -> Unit)

    val lists: MutableList<TaskList> by lazy {
        retrieveLists()
    }

    fun addTask(task: String) {
        list.tasks.add(task)
        onTaskAdded.invoke()
    }

    private fun retrieveLists(): MutableList<TaskList> {

        val sharedPreferencesContents = sharedPreferences.all
        val taskLists = ArrayList<TaskList>()

        for (taskList in sharedPreferencesContents) {
            val itemsHashSet = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, itemsHashSet)
            taskLists.add(list)
        }

        return taskLists
    }

    fun saveList(list: TaskList) {
        sharedPreferences.edit().putStringSet(list.name, list.tasks.toHashSet()).apply()
        lists.add(list)
        onListsAdded.invoke()
    }

    fun updateList(parcelableExtra: TaskList) {
        sharedPreferences.edit()
            .putStringSet(parcelableExtra.name, parcelableExtra.tasks.toHashSet()).apply()
        lists.add(parcelableExtra)
    }

    fun refreshLists() {
        lists.clear()
        lists.addAll(retrieveLists())
    }
}