package com.example.test23apr.ui

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test23apr.adapter.EmojiAdapter
import com.example.test23apr.R
import com.example.test23apr.retrofit.EmojiViewModel
import com.example.test23apr.retrofit.SmilyPojo

class MainActivity : AppCompatActivity() {

    private lateinit var emojiViewModel: EmojiViewModel

    private lateinit var emojiRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        val progressCircular = findViewById<ProgressBar>(R.id.progress_circular)

        emojiRecycler = findViewById(R.id.emojiRecycler)
        emojiRecycler.layoutManager = GridLayoutManager(this, 2)

        emojiViewModel = ViewModelProvider(this)[EmojiViewModel::class.java]

        progressCircular.visibility = VISIBLE

        emojiViewModel.loadData()!!.observe(this) {

            progressCircular.visibility = GONE

            if (!it.isNullOrEmpty()) {

                if (it.size > 0) {

                    setData(it)
                }
            }
        }
    }

    private fun setData(it: java.util.ArrayList<SmilyPojo>) {

        emojiRecycler.adapter = EmojiAdapter(
            this, it, object : EmojiAdapter.OnItemClick {
                override fun onClick(position: Int) {

                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtra("model", it[position])
                    startActivity(intent)
                }
            }
        )
    }
}