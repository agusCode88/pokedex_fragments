package com.example.pokedexfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexfragments.R
import com.example.pokedexfragments.adapters.PokemonAdapter
import com.example.pokedexfragments.databinding.FragmentListPokemonBinding
import com.example.pokedexfragments.model.Pokemon


class ListPokemonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       val binding= FragmentListPokemonBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment

        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerPokemons.layoutManager = linearLayoutManager

        val adapterPokemon = PokemonAdapter()
        adapterPokemon.pokemons = Pokemon.pokemonList
        binding.recyclerPokemons.adapter = adapterPokemon


       return binding.root
    }

}