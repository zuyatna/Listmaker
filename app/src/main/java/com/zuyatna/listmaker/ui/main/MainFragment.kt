package com.zuyatna.listmaker.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zuyatna.listmaker.databinding.MainFragmentBinding
import com.zuyatna.listmaker.models.MainViewModel

class MainFragment : Fragment(), LifecycleObserver {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater, container, false)

        binding.listsRecyclerview.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(requireActivity()))
        )[MainViewModel::class.java]

        val recyclerViewAdapter = ListSelectionRecyclerViewAdapter(viewModel.lists)

        binding.listsRecyclerview.adapter = recyclerViewAdapter

        viewModel.onListsAdded = {
            recyclerViewAdapter.listsUpdated()
        }
    }
}