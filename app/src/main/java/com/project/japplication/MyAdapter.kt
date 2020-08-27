package com.project.japplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.japplication.orm.entities.Jlpt5
import kotlinx.android.synthetic.main.jlpt5_cells.view.*

// I used doc https://developer.android.com/guide/topics/ui/layout/recyclerview
// For function onCreateViewHolder, don't add "as TextView" like it's written in the doc or you'll have a class exception
// And this tutorial https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin


class MyAdapter(private val kanjisList: List<Jlpt5>) : RecyclerView.Adapter<MyAdapter.Jlpt5Holder>() {

    override fun getItemCount() = kanjisList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Jlpt5Holder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.jlpt5_cells, parent, false)

        return Jlpt5Holder(textView)
    }

    override fun onBindViewHolder(holder: Jlpt5Holder, position: Int) {
        val kanjis = kanjisList[position]
        holder.bind(kanjis)
    }

    class Jlpt5Holder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var kanji: Jlpt5? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.i("TAG", "CLICKED")
        }

        fun bind(kanji: Jlpt5) {
            this.kanji = kanji
            view.jlpt5_name.text = kanji.name
            view.jlpt5_description.text = kanji.description.toString()
        }
    }

}