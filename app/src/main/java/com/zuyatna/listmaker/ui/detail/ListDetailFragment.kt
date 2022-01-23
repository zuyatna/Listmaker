package com.zuyatna.listmaker.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zuyatna.listmaker.R
import com.zuyatna.listmaker.databinding.ListDetailFragmentBinding

class ListDetailFragment : Fragment() {

    lateinit var binding: ListDetailFragmentBinding

    companion object {
        fun newInstance() = ListDetailFragment()
    }

    private lateinit var viewModel: ListDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListDetailFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ListDetailViewModel::class.java]
        // TODO: Use the ViewModel
    }

}