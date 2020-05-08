package com.example.navigationserviceexample.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationserviceexample.MainActivity
import com.example.navigationserviceexample.databinding.FragmentScreenTwoBinding

class ScreenTwoFragment : Fragment() {

    private var _binding: FragmentScreenTwoBinding? = null

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
        _binding = FragmentScreenTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnScreen1.setOnClickListener { navigationService.openExampleScreenOne(null) }
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}