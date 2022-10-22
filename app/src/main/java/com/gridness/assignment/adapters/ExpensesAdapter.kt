package com.gridness.assignment.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gridness.assignment.R
import com.gridness.assignment.models.Expense

class ExpensesAdapter : RecyclerView.Adapter<ExpensesAdapter.ExpensesViewHolder>() {
    private var expensesList = mutableListOf<Expense>()

    class ExpensesViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, expense: Expense) {
            if (position != 0) {
                itemView.findViewById<View>(R.id.dividerTop).visibility = View.GONE
            }

            itemView.findViewById<TextView>(R.id.categoryNameItem).text = expense.expenseName
            itemView.findViewById<TextView>(R.id.categoryTypeItem).text =
                expense.category?.categoryName

            if(expense.category?.income == "Доход") {
                itemView.findViewById<TextView>(R.id.costExpenseItem).text = expense.cost + "р"
                itemView.findViewById<TextView>(R.id.costExpenseItem).setTextColor(Color.parseColor("#d00000"))
            } else {
                itemView.findViewById<TextView>(R.id.costExpenseItem).text = "+" + expense.cost + "р"
                itemView.findViewById<TextView>(R.id.costExpenseItem).setTextColor(Color.parseColor("#0ed33a"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.expense_item, parent, false)
        return ExpensesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        holder.bind(position, expensesList[position])
    }

    override fun getItemCount(): Int {
        return expensesList.size
    }

    fun setExpensesList(expensesList: MutableList<Expense>) {
        this.expensesList = expensesList
        notifyDataSetChanged()
    }
}