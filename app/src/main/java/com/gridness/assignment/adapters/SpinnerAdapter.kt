package com.gridness.assignment.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.gridness.assignment.R

class SpinnerAdapter(
    private val mContext: Context,
    private val textResourceID: Int,
    private val list: MutableList<String>
) : ArrayAdapter<String>(mContext, textResourceID, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var newView = convertView

        if(newView == null) {
            newView = View.inflate(mContext, textResourceID, null)
        }

        (newView as TextView).text = list[position]
        return newView
    }
}