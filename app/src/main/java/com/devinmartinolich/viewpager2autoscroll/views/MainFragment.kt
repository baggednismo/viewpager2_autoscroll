package com.devinmartinolich.viewpager2autoscroll.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devinmartinolich.viewpager2autoscroll.controllers.MainActivity
import com.devinmartinolich.viewpager2autoscroll.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    companion object {
        private const val TAG = "MainFragment"
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var mActivity : MainActivity? = null

    var mView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "-> onCreateView()")
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        mView = binding.root
        mActivity = (activity as MainActivity)

        return mView
    }
}