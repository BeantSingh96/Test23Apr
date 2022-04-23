package com.example.test23apr.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.core.text.bold
import com.example.test23apr.R
import com.example.test23apr.retrofit.SmilyPojo

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        init()
    }

    private fun init() {

        val model = intent.getSerializableExtra("model") as SmilyPojo

        val tvCategory = findViewById<TextView>(R.id.tvCategory)
        val tvEmoji = findViewById<TextView>(R.id.tvEmoji)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvGroup = findViewById<TextView>(R.id.tvGroup)

        tvCategory.text = "Category : " + model.getCategory()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvEmoji.text = Html.fromHtml(model.getHtmlCode()!![0], Html.FROM_HTML_MODE_COMPACT)
        } else {
            tvEmoji.text = Html.fromHtml(model.getHtmlCode()!![0])
        }
        tvName.text = SpannableStringBuilder().bold { append("Name : ") }
            .append(model.getName())

        tvGroup.text = SpannableStringBuilder().bold { append("Group : ") }
            .append(model.getGroup())
//        tvGroup.text = "Group : " + model.getGroup()
    }
}