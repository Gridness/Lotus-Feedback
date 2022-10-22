package com.gridness.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.gridness.assignment.adapters.ExpensesAdapter
import com.gridness.assignment.models.Category
import com.gridness.assignment.models.Expense

class Expenses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        val addFamilyMemberButton: Button = findViewById(R.id.addFamilyMemberButton)
        addFamilyMemberButton.setOnClickListener {
            val intent = Intent(this, AddExpense::class.java)
            startActivity(intent)
            finish()
        }

        val familyButton: ImageButton = findViewById(R.id.familyButton)
        familyButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val spendingButton: ImageButton = findViewById(R.id.spendingButton)
        spendingButton.setOnClickListener {
            val intent = Intent(this, Expenses::class.java)
            startActivity(intent)
            finish()
        }

        val categoriesButton: ImageButton = findViewById(R.id.categoriesButton)
        categoriesButton.setOnClickListener {
            val intent = Intent(this, Categories::class.java)
            startActivity(intent)
            finish()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.expensesList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = ExpensesAdapter()
        recyclerView.adapter = adapter
        ReferenceProvider
            .getBaseReference()
            .child("expenses")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val expensesList = mutableListOf<Expense>()
                    for (child in snapshot.children) {
                        expensesList.add(child.getValue(Expense::class.java) as Expense)
                    }
                    getCategory(adapter, expensesList)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }

    private fun getCategory(adapter: ExpensesAdapter, expensesList: MutableList<Expense>) {
        ReferenceProvider
            .getBaseReference()
            .child("categories")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val categoryList = mutableListOf<Category>()
                    //for(child in snapshot.children) {
                    //    categoryList.add(child.getValue(Category::class.java) as Category)
                    //}
                    expensesList.forEach {
                        it.category =
                            snapshot.child(it.categoryID).getValue(Category::class.java) as Category
                    }
                    adapter.setExpensesList(expensesList)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
    }
}