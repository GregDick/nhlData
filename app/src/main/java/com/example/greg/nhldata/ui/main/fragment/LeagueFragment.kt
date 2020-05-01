package com.example.greg.nhldata.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greg.nhldata.R
import com.example.greg.nhldata.databinding.MainFragmentBinding
import com.example.greg.nhldata.ui.main.adapter.LeagueAdapter
import com.example.greg.nhldata.ui.main.viewmodel.LeagueViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class LeagueFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var leagueAdapter: LeagueAdapter

    private val viewModel: LeagueViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            leagueAdapter = LeagueAdapter(it)
            league_recycler.adapter = leagueAdapter
            league_recycler.layoutManager = LinearLayoutManager(it)
        }

        viewModel.loadingState.observe(viewLifecycleOwner, Observer {
            binding.loading = it
        })

        viewModel.teams.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                leagueAdapter.teamsList = it
                leagueAdapter.notifyDataSetChanged()
            }
        })
    }

    companion object {
        fun newInstance() = LeagueFragment()
    }
}
