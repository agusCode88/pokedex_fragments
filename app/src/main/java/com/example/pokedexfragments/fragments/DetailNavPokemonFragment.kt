package com.example.pokedexfragments.fragments

import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.pokedexfragments.R
import com.example.pokedexfragments.databinding.FragmentDetailNavPokemonBinding
import com.example.pokedexfragments.databinding.FragmentDetailPokemonBinding
import com.example.pokedexfragments.model.Pokemon


class DetailNavPokemonFragment : Fragment() {

    private val args: DetailNavPokemonFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailNavPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailNavPokemonBinding.inflate(inflater,container,false)

        val pokemon: Pokemon? = args.pokemon
        binding.pokemonName.text = args.pokemon?.name

        if (pokemon != null) {
            initUI(pokemon)
        }

        return binding.root
    }

    private fun initUI(pokemon: Pokemon){
        setDownloadPokemonImage(pokemon)
        binding.txtPokemonHp.text = getString(R.string.hp_format, pokemon.hp)
        binding.txtPokemonAttack.text = getString(R.string.attack_format, pokemon.attack)
        binding.txtPokemonDefense.text = getString(R.string.defense_format, pokemon.defense)
        binding.txtPokemonVelocity.text = getString(R.string.velocity_format, pokemon.speed)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(requireActivity(),pokemon.soundId)
        mediaPlayer.start()

    }

    private fun setDownloadPokemonImage(pokemon: Pokemon){

        binding.pbImg.visibility = View.VISIBLE
        Glide.with(this).load(pokemon.imageUrl).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>,
                isFirstResource: Boolean
            ): Boolean {
                binding.pbImg.visibility = View.GONE
                binding.imgPokemon.setImageResource(R.drawable.ic_image_not_supported_black)
                return false
            }

            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: Target<Drawable>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                binding.pbImg.visibility = View.GONE
                return false
            }
        })
            .error(R.drawable.ic_image_not_supported_black)
            .into(binding.imgPokemon);
    }

}