package com.dkn.subsatubajp.fragment.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dkn.subsatubajp.adapter.TvShowsAdapter
import com.dkn.subsatubajp.data.TvShowsData
import com.dkn.subsatubajp.databinding.FragmentTvShowsBinding
import com.dkn.subsatubajp.detail.DetailActivity
import com.dkn.subsatubajp.utilis.*

class TvShowsFragment : Fragment(), TvShowsAdapter.IMovie {

    private val viewModel: TvShowViewModel by viewModels()

    private var _binding: FragmentTvShowsBinding? = null
    private val binding get() = _binding!!
    private lateinit var tvShowAdapter: TvShowsAdapter

    companion object {
        fun newInstance() = TvShowsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val data = viewModel.getListTvShow()
        tvShowAdapter = TvShowsAdapter(data, requireContext(), this)
        binding.rvTvShows.adapter = tvShowAdapter
    }

    override fun onMovieClicked(tvShow: TvShowsData) {
        Intent(requireActivity(), DetailActivity::class.java).apply {
            putExtra(Extra.ID, tvShow.id.toString())
            putExtra(Extra.TYPE, TYPE.TV_SHOW.name)
            startActivity(this)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}