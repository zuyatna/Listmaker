package com.zuyatna.listmaker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.zuyatna.listmaker.MainActivity
import com.zuyatna.listmaker.R
import com.zuyatna.listmaker.databinding.ListDetailActivityBinding
import com.zuyatna.listmaker.models.TaskList

class ListDetailActivity : AppCompatActivity() {

    lateinit var binding: ListDetailActivityBinding
    lateinit var viewModel: ListDetailViewModel
    lateinit var fragment: ListDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ListDetailActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addTaskButton.setOnClickListener {
            showCreateDialog()
        }

        viewModel = ViewModelProvider(this)[ListDetailViewModel::class.java]
        viewModel.list = intent.getParcelableExtra(MainActivity.INTENT_TEST_KEY)

        title = viewModel.list.name

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListDetailFragment.newInstance())
                .commitNow()
        }
    }

    private fun showCreateDialog() {
        TODO("Not yet implemented")
    }
}