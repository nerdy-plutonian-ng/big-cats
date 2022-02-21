package com.nerdymykl.bigcats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nerdymykl.bigcats.adapter.CatsAdapter
import com.nerdymykl.bigcats.databinding.FragmentCatsBinding
import com.nerdymykl.bigcats.datasource.cats


class CatsFragment : Fragment() {

    private lateinit var _binding : FragmentCatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatsBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding.recyclerview.adapter = CatsAdapter(cats = cats)
    }
}