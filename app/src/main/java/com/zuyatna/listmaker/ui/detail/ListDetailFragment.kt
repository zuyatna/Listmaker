package com.zuyatna.listmaker.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zuyatna.listmaker.MainActivity
import com.zuyatna.listmaker.databinding.ListDetailFragmentBinding
import com.zuyatna.listmaker.models.TaskList
import com.zuyatna.listmaker.ui.main.MainViewModel
import com.zuyatna.listmaker.ui.main.MainViewModelFactory

class ListDetailFragment : Fragment() {

    private lateinit var binding: ListDetailFragmentBinding

    companion object {
        fun newInstance() = ListDetailFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListDetailFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity(),
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(requireActivity()))
        )[MainViewModel::class.java]

        val list: TaskList? = arguments?.getParcelable(MainActivity.INTENT_LIST_KEY)
        if (list != null) {
            viewModel.list = list
            requireActivity().title = list.name
        }

        val recyclerAdapter = ListItemsRecyclerViewAdapter(viewModel.list)
        binding.listItemsRecyclerview.adapter = recyclerAdapter
        binding.listItemsRecyclerview.layoutManager = LinearLayoutManager(requireContext())

        viewModel.onTaskAdded = {
            recyclerAdapter.notifyDataSetChanged()
        }
    }


    /*
     onActivityCreated is deprecated

     The onActivityCreated() method is now deprecated. Code touching the fragment's view
     should be done in onViewCreated() (which is called immediately before onActivityCreated())
     and other initialization code should be in onCreate(). To receive a callback specifically
     when the activity's onCreate() is complete, a LifeCycleObserver should be registered on
     the activity's Lifecycle in onAttach(), and removed once the onCreate() callback is received.
     */
}