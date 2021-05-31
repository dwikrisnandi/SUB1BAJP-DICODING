package com.dkn.subsatubajp.fragment.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dkn.subsatubajp.adapter.MoviesAdapter
import com.dkn.subsatubajp.data.Movie
import com.dkn.subsatubajp.databinding.FragmentMoviesBinding
import com.dkn.subsatubajp.detail.DetailActivity
import com.dkn.subsatubajp.utilis.Extra
import com.dkn.subsatubajp.utilis.TYPE

class MoviesFragment : Fragment(), MoviesAdapter.IMovie {

    private val viewModel: MovieViewModel by viewModels()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter

    companion object {
        fun newInstance() = MoviesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val data = viewModel.getListMovie()
        moviesAdapter = MoviesAdapter(data, requireContext(), this)
        binding.rvMovie.adapter = moviesAdapter
    }

    override fun onMovieClicked(movie: Movie) {
        Intent(requireActivity(), DetailActivity::class.java).apply {
            putExtra(Extra.ID, movie.id.toString())
            putExtra(Extra.TYPE, TYPE.MOVIE.name)
            startActivity(this)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
