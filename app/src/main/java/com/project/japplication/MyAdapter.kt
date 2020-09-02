package com.project.japplication

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.japplication.jlpt.Jlpt5Details
import com.project.japplication.orm.entities.KanjiWithPronunciation
import kotlinx.android.synthetic.main.jlpt5_cells.view.*

// I used doc https://developer.android.com/guide/topics/ui/layout/recyclerview
// For function onCreateViewHolder, don't add "as TextView" like it's written in the doc or you'll have a class exception
// And this tutorial https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin


class MyAdapter(private val kanjisList: List<KanjiWithPronunciation>, val activity: Activity) : RecyclerView.Adapter<MyAdapter.Jlpt5Holder>() {

    override fun getItemCount() = kanjisList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Jlpt5Holder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.jlpt5_cells, parent, false)

        return Jlpt5Holder(textView, activity)
    }

    override fun onBindViewHolder(holder: Jlpt5Holder, position: Int) {
        val kanjis = kanjisList[position]
        holder.bind(kanjis)
    }

    class Jlpt5Holder(v: View, activity: Activity) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var kanji: KanjiWithPronunciation? = null
        private var currentActivity: Activity = activity


        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val intent = Intent(currentActivity, Jlpt5Details::class.java)
            intent.putExtra("kanji", this.kanji?.kanji?.kanji_id)
            currentActivity.startActivity(intent)
        }

        fun bind(kanji: KanjiWithPronunciation) {
            this.kanji = kanji
            view.jlpt5_name.text = kanji.kanji.name
            view.jlpt5_description.text = kanji.kanji.description
        }
    }

}