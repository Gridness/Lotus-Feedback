package com.gridness.assignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gridness.assignment.R
import com.gridness.assignment.models.FamilyMember

class FamilyMembersAdapter: RecyclerView.Adapter<FamilyMembersAdapter.FamilyMemberViewHolder>() {
    private var familyMemberList = mutableListOf<FamilyMember>()

    class FamilyMemberViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, familyMember: FamilyMember) {
            if (position != 0) {
                itemView.findViewById<View>(R.id.dividerTop).visibility = View.GONE
            }

            itemView.findViewById<TextView>(R.id.categoryNameItem).text = familyMember.familyMemberName
            itemView.findViewById<TextView>(R.id.categoryTypeItem).text = familyMember.income
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyMemberViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.category_item, parent, false)
        return FamilyMemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: FamilyMemberViewHolder, position: Int) {
        holder.bind(position, familyMemberList[position])
    }

    override fun getItemCount(): Int {
        return familyMemberList.size
    }

    fun setFamilyMemberList(familyMemberList: MutableList<FamilyMember>) {
        this.familyMemberList = familyMemberList
        notifyDataSetChanged()
    }
}