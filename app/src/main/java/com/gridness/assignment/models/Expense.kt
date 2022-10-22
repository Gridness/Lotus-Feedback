package com.gridness.assignment.models

class Expense(
    val expenseName: String = "",
    val categoryID: String = "",
    val cost: String = "",
    var category: Category? = null
) {

}