package com.example.pokedexfragments.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfragments.R
import com.example.pokedexfragments.databinding.PokemonListItemBinding
import com.example.pokedexfragments.model.Pokemon

class PokemonAdapter:  RecyclerView.Adapter< PokemonAdapter.ViewHolder >() {

    var pokemons = mutableListOf<Pokemon>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val binding = PokemonListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //val view: View = LayoutInflater.from(parent.context).inflate(R.layout.eq_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        val pokemon: Pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    inner class ViewHolder(private var binding: PokemonListItemBinding)
               : RecyclerView.ViewHolder(binding.root) {

       fun bind(pokemon: Pokemon){
           binding.pokemonId.text = pokemon.id.toString()
           binding.pokemonName.text = pokemon.name

           val imageId: Int = when(pokemon.type){
               Pokemon.PokemonType.GRASS -> R.drawable.grass_icon
               Pokemon.PokemonType.WATER -> R.drawable.water_icon
               Pokemon.PokemonType.FIRE -> R.drawable.fire_icon
               Pokemon.PokemonType.FIGHTER -> R.drawable.fight_icon
               Pokemon.PokemonType.ELECTRIC -> R.drawable.electric_icon
           }

           binding.pokemonTypeImage.setImageResource(imageId)
       }


    }

}