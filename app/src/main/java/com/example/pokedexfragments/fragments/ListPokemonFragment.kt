package com.example.pokedexfragments.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexfragments.MainActivity
import com.example.pokedexfragments.adapters.PokemonAdapter
import com.example.pokedexfragments.databinding.FragmentListPokemonBinding
import com.example.pokedexfragments.model.Pokemon


class ListPokemonFragment : Fragment() {

    interface PokemonSelectListener {
        fun onPokemonSelected(pokemon:Pokemon)
    }

    private lateinit var binding:FragmentListPokemonBinding
    private lateinit var pokemonSelectListener: PokemonSelectListener

    // Con esta interface obligamos a que la actividad lo implemente
    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonSelectListener = try{
            context as PokemonSelectListener
        } catch (e: ClassCastException){
            throw ClassCastException("$context must implement PokemonSelectListener")
        }

    }

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
            pokemonSelectListener.onPokemonSelected(it)
           // (activity as MainActivity).iAmYourFatherActivity(it)
            //Toast.makeText(requireActivity(),it.name,Toast.LENGTH_SHORT).show()
        }
    }

}