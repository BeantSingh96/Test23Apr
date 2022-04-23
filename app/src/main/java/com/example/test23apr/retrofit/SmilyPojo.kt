package com.example.test23apr.retrofit

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class SmilyPojo : Serializable {

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("category")
    @Expose
    private var category: String? = null

    @SerializedName("group")
    @Expose
    private var group: String? = null

    @SerializedName("htmlCode")
    @Expose
    private var htmlCode: List<String?>? = null

    @SerializedName("unicode")
    @Expose
    private var unicode: List<String?>? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String?) {
        this.category = category
    }

    fun getGroup(): String? {
        return group
    }

    fun setGroup(group: String?) {
        this.group = group
    }

    fun getHtmlCode(): List<String?>? {
        return htmlCode
    }

    fun setHtmlCode(htmlCode: List<String?>?) {
        this.htmlCode = htmlCode
    }

    fun getUnicode(): List<String?>? {
        return unicode
    }

    fun setUnicode(unicode: List<String?>?) {
        this.unicode = unicode
    }

}