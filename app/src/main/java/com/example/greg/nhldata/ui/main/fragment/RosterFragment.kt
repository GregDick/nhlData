package com.example.greg.nhldata.ui.main.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greg.nhldata.R
import com.example.greg.nhldata.databinding.RosterFragmentBinding
import com.example.greg.nhldata.ui.main.adapter.RosterAdapter
import com.example.greg.nhldata.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.roster_fragment.*

class RosterFragment : Fragment() {

    private lateinit var binding: RosterFragmentBinding
    private lateinit var rosterAdapter: RosterAdapter

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.roster_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            rosterAdapter = RosterAdapter(it)
            roster_recycler.adapter = rosterAdapter
            roster_recycler.layoutManager = LinearLayoutManager(it)
        }

        viewModel.roster.observe(viewLifecycleOwner, Observer {
            Log.v("viewmodel", "player list: $it")
            rosterAdapter.playerList = it
            rosterAdapter.notifyDataSetChanged()
        })
    }

    companion object {
        fun newInstance() = RosterFragment()
    }
}