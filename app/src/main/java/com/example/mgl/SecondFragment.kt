package com.example.mgl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult


class SecondFragment : Fragment(R.layout.fragment_second ){

    private var nombre:String? =""
    private var edad:Int? = 0

    // Acceso a los argumentos 1° metodo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = requireArguments().getString(n)
        edad = requireArguments().getInt(e)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txt_output)
        val button = view.findViewById<Button>(R.id.btn_send_data)
        button.setOnClickListener {
            val result = "Resultado"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
        text.text = "nombre $nombre $edad"
    }
    // Variables estaticas para poder ser accedido desde otro lugar
    companion object{
        private const val n = "nombre"
        private const val e = "edad"

        fun newInstance(nombre:String,edad:Int) = SecondFragment().apply {
            arguments = bundleOf(n to  nombre, e to edad)

        }
    }

}