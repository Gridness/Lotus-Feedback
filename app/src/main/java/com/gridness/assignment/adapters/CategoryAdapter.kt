package com.gridness.assignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gridness.assignment.R
import com.gridness.assignment.models.Category

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var categoryList = mutableListOf<Category>()

    class CategoryViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, category: Category) {
            if(position != 0) {
                itemView.findViewById<View>(R.id.dividerTop).visibility = View.GONE
            }

            itemView.findViewById<TextView>(R.id.categoryNameItem).text = category.categoryName
            itemView.findViewById<TextView>(R.id.categoryTypeItem).text = category.income
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(position, categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setCategoryList(categoryList: MutableList<Category>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }
}