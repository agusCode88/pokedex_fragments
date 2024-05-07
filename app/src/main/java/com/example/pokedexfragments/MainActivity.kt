package com.example.pokedexfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.pokedexfragments.fragments.DetailPokemonFragment
import com.example.pokedexfragments.fragments.ListPokemonFragment
import com.example.pokedexfragments.fragments.ListPokemonFragmentDirections
import com.example.pokedexfragments.model.Pokemon

class MainActivity : AppCompatActivity() , ListPokemonFragment.PokemonSelectListener{

    private lateinit var detailPokemonFragment: DetailPokemonFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onPokemonSelected(pokemon: Pokemon) {
            findNavController(R.id.navigation_container).
            navigate(ListPokemonFragmentDirections.actionListPokemonFragmentToDetailNavPokemonFragment())
    }

}