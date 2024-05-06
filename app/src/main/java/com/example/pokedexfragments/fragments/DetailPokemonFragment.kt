package com.example.pokedexfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedexfragments.R
import com.example.pokedexfragments.databinding.FragmentDetailPokemonBinding
import com.example.pokedexfragments.databinding.FragmentListPokemonBinding
import com.example.pokedexfragments.model.Pokemon

class DetailPokemonFragment : Fragment() {

    private lateinit var binding: FragmentDetailPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentDetailPokemonBinding.inflate(inflater,container,false)

        return binding.root

    }

    fun initUI(pokemon: Pokemon){
        binding.txtPokemonHp.text =getString(R.string.hp_format, pokemon.hp)
        binding.txtPokemonAttack.text = getString(R.string.attack_format, pokemon.attack)
        binding.txtPokemonDefense.text = getString(R.string.defense_format, pokemon.defense)
        binding.txtPokemonVelocity.text = getString(R.string.velocity_format, pokemon.speed)

    }

}