package com.example.camp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BookMarkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_mark, container, false)
    }

    fun newInstant() : BookMarkFragment
    {
        val args = Bundle()
        val frag = BookMarkFragment()
        frag.arguments = args
        return frag
    }
}