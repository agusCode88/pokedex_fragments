package com.example.pokedexfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexfragments.R
import com.example.pokedexfragments.adapters.PokemonAdapter
import com.example.pokedexfragments.databinding.FragmentListPokemonBinding
import com.example.pokedexfragments.model.Pokemon


class ListPokemonFragment : Fragment() {

    private lateinit var binding:FragmentListPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentListPokemonBinding.inflate(inflater,container,false)
        initUI()

       return binding.root
    }

    private fun initUI(){
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerPokemons.layoutManager = linearLayoutManager

        val adapterPokemon = PokemonAdapter()
        adapterPokemon.pokemons = Pokemon.pokemonList
        binding.recyclerPokemons.adapter = adapterPokemon

        adapterPokemon.onItemClickListener = {
            Toast.makeText(requireActivity(),it.name,Toast.LENGTH_SHORT).show()
        }
    }

}