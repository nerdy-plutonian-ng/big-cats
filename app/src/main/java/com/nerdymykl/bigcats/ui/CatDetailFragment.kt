package com.nerdymykl.bigcats.ui

import android.os.Bundle
import android.transition.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nerdymykl.bigcats.databinding.FragmentCatDetailBinding
import com.nerdymykl.bigcats.datasource.cats
import com.nerdymykl.bigcats.datasource.favourites
import com.nerdymykl.bigcats.models.Cat


class CatDetailFragment : Fragment() {

    private lateinit var cat : Cat
    private lateinit var _binding : FragmentCatDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            cat = Cat.fromJson(it.getString("cat").toString())!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatDetailBinding.inflate(inflater,container,false)
        return  _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.nameTV.text = cat.name
        _binding.catImageIv.setImageResource(cat.image)
        _binding.descTV.text = getString(cat.description)
        if(!favourites.contains(cat.id)){
            _binding.favIV.visibility = View.GONE
        }
    }

}