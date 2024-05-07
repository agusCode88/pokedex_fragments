package com.example.pokedexfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.pokedexfragments.fragments.ListPokemonFragment
import com.example.pokedexfragments.fragments.ListPokemonFragmentDirections
import com.example.pokedexfragments.model.Pokemon

class MainActivity : AppCompatActivity() , ListPokemonFragment.PokemonSelectListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onPokemonSelected(pokemon: Pokemon) {
            findNavController(R.id.navigation_container).
            navigate(ListPokemonFragmentDirections.actionListPokemonFragmentToDetailNavPokemonFragment(pokemon))
    }

}