package com.example.greg.nhldata.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.greg.nhldata.R
import com.example.greg.nhldata.ui.main.viewmodel.LeagueViewModel

class LeagueFragment : Fragment() {

    companion object {
        fun newInstance() = LeagueFragment()
    }

    private val viewModel: LeagueViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.
    }

}
