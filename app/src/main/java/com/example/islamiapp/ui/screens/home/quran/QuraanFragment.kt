package com.example.islamiapp.ui.screens.home.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.ui.screens.ChapterDetails.ChapterDetailsActivity
import com.example.islamiapp.Model.Constants
import com.example.islamiapp.databinding.FragmentQuraanBinding



class QuraanFragment : Fragment() {
    private lateinit var binding: FragmentQuraanBinding
    private lateinit var chapterAdapter: chapterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuraanBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inializechaterRV()
    }

    private fun inializechaterRV() {
        chapterAdapter = chapterAdapter(Constants.chapters){
            chapter, i -> val intent = Intent(requireActivity(), ChapterDetailsActivity::class.java)
            intent.putExtra(ChapterDetailsActivity.SURA_NAME,chapter.name)
            intent.putExtra(ChapterDetailsActivity.FILE_NAME,"${i +1}.txt")

            startActivity(intent)
        }
        binding.chaptersRecyclerView.adapter = chapterAdapter
    }

}