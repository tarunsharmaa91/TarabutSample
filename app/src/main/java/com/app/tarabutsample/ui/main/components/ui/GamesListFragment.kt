package com.app.blog.ui.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.blog.ui.component.post_list.adapter.GamesListAdapter
import com.app.tarabutsample.databinding.GameListFragmentBinding
import com.app.tarabutsample.ui.main.components.viewmodel.GamesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesListFragment : Fragment() {

    @VisibleForTesting
    val viewModel: GamesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = GameListFragmentBinding.inflate(inflater)

        //To allow data binding to observe live data with life cycle of fragment
        binding.lifecycleOwner = this

        //Now I have to give binding access to AdListViewModel
        binding.viewModel = viewModel

        binding.adList.adapter = GamesListAdapter(GamesListAdapter.OnClickListener {
            viewModel.displayGameDetail(it)
        })

        viewModel.navigateToGameDetail.observe(viewLifecycleOwner, {
            if (null != it) {
                 this.findNavController().navigate(GamesListFragmentDirections.actionShowDetail(it))
                viewModel.displayGameDetailComplete()
            }
        })

        return binding.root
    }


}
