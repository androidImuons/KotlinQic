package com.ozonetech.qicpic.view.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ozonetech.qicpic.R

class PostsFragment : Fragment() {

    private lateinit var postsViewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        postsViewModel =
            ViewModelProvider(this).get(PostsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_posts, container, false)
        val textView: TextView = root.findViewById(R.id.text_posts)
        postsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}