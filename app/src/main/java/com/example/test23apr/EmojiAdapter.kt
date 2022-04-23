package com.example.test23apr

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test23apr.retrofit.SmilyPojo

class EmojiAdapter(
    private val context: Context,
    private val list: ArrayList<SmilyPojo>?,
    private val listener: OnItemClick
) : RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_emoji, parent, false)

        return EmojiViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {

        holder.bind(list!![position], listener)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    interface OnItemClick {

        fun onClick(position: Int)
    }

    class EmojiViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val ivEmoji: TextView = view.findViewById(R.id.tvEmoji)
        private val emojiName: TextView = view.findViewById(R.id.emojiName)

        fun bind(pojo: SmilyPojo, listener: OnItemClick) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ivEmoji.text = Html.fromHtml(pojo.getHtmlCode()!![0], Html.FROM_HTML_MODE_COMPACT)
            } else {
                ivEmoji.text = Html.fromHtml(pojo.getHtmlCode()!![0])
            }

            emojiName.text = pojo.getName()

            view.setOnClickListener {

                listener.onClick(adapterPosition)
            }
        }
    }
}