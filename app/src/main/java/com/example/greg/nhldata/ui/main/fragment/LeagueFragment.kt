package com.example.greg.nhldata.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.greg.nhldata.R
import com.example.greg.nhldata.ui.main.datamodel.Team
import com.example.greg.nhldata.ui.main.viewmodel.LeagueViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
        viewModel.teams.observe(viewLifecycleOwner, Observer { teamList ->
            if (teamList.isNotEmpty()) {
                var textString = ""
                teamList.forEach {
                    textString += it.toString() + "\n\n"
                }
                text_view.text = textString
            }
        })
    }

    override fun onResume() {
        super.onResume()
    }

}
