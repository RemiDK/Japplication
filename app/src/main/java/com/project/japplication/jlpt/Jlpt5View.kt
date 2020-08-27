package com.project.japplication.jlpt

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.japplication.MyAdapter
import com.project.japplication.R
import com.project.japplication.orm.Jlpt5Database
import com.project.japplication.orm.database.prepopulateDbJlpt5

class Jlpt5View : Activity() {

    private var db: Jlpt5Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jlpt5)
        title = "JLPT 5"

        // TODO Change to coroutine
        db = Jlpt5Database.getKanjisDataBase(this)
        prepopulateDbJlpt5(this)

        val res = db?.jlpt5Dao()?.getAll()


        if (res != null) {
            val recyclerView: RecyclerView = findViewById(R.id.jlpt5_recycler_view)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = MyAdapter(res)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}