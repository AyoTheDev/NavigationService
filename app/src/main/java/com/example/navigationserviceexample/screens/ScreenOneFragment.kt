package com.example.navigationserviceexample.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationserviceexample.MainActivity
import com.example.navigationserviceexample.databinding.FragmentScreenOneBinding

class ScreenOneFragment : Fragment() {

    private var _binding: FragmentScreenOneBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //todo should be injected better
    private val navigationService by lazy { (requireActivity() as MainActivity).navigationService }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreenOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding?.btnScreen2?.setOnClickListener { navigationService.openExampleScreenTwo() }
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}