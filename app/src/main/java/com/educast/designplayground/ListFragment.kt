package com.educast.designplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*

@ContentView(R.layout.fragment_list)
class ListFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = ListAdapter()
    }

    class ListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
            return ListViewHolder(view)
        }

        override fun getItemCount(): Int {
            return 50
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            // do nothing
        }

        class ListViewHolder(view: View): RecyclerView.ViewHolder(view)
    }
}