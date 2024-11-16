package com.example.task_023

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class GridViewAdapter (
    private val list: List<GridViewModal>,
    private val context: Context
) :
    BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var textNameUrlTV: TextView
    private lateinit var textDataUrlTV: TextView

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.gridview_item, null)
        }
        textNameUrlTV = convertView!!.findViewById(R.id.textNameUrlTV)
        textDataUrlTV = convertView.findViewById(R.id.textDataUrlTV)

        textNameUrlTV.text = list[position].name
        textDataUrlTV.text = list[position].dataUrl

        return  convertView
    }
}
