package com.educast.designplayground

import android.os.Bundle
import android.view.*
import androidx.annotation.ContentView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_grid.*

@ContentView(R.layout.fragment_grid)
class GridFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = GridAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_grid, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.span_count) {
            MaterialAlertDialogBuilder(context)
                .setTitle("그리드 열 수")
                .setSingleChoiceItems(R.array.span_count_array, -1) { dialog, position ->
                    (recyclerView.layoutManager as GridLayoutManager).spanCount = position + 1
                    dialog.dismiss()
                }
                .show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    class GridAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_item, parent, false)
            return GridViewHolder(view)
        }

        override fun getItemCount(): Int {
            return 50
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            // do nothing
        }

        class GridViewHolder(view: View): RecyclerView.ViewHolder(view)
    }
}