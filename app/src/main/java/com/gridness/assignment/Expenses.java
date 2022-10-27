package com.gridness.assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.gridness.assignment.adapters.ExpensesAdapter;
import com.gridness.assignment.models.Category;
import com.gridness.assignment.models.Expense;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"},
        d2 = {"Lcom/gridness/assignment/Expenses;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "getCategory", "", "adapter", "Lcom/gridness/assignment/adapters/ExpensesAdapter;", "expensesList", "", "Lcom/gridness/assignment/models/Expense;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class Expenses extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActionBar var10000 = this.getSupportActionBar();
        if (var10000 != null) {
            var10000.hide();
        }

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_expenses);
        View var9 = this.findViewById(R.id.addFamilyMemberButton);
        Intrinsics.checkNotNullExpressionValue(var9, "findViewById(R.id.addFamilyMemberButton)");
        Button addFamilyMemberButton = (Button)var9;
        addFamilyMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAdd();
            }
        });
        //addFamilyMemberButton.setOnClickListener(Expenses::onCreate$lambda-0);
        var9 = this.findViewById(R.id.familyButton);
        Intrinsics.checkNotNullExpressionValue(var9, "findViewById(R.id.familyButton)");
        ImageButton familyButton = (ImageButton)var9;
        familyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFamilyScreen();
            }
        });
        //familyButton.setOnClickListener(Expenses::onCreate$lambda-1);
        var9 = this.findViewById(R.id.spendingButton);
        Intrinsics.checkNotNullExpressionValue(var9, "findViewById(R.id.spendingButton)");
        ImageButton spendingButton = (ImageButton)var9;
        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToExpensesScreen();
            }
        });
        //spendingButton.setOnClickListener(Expenses::onCreate$lambda-2);
        var9 = this.findViewById(R.id.categoriesButton);
        Intrinsics.checkNotNullExpressionValue(var9, "findViewById(R.id.categoriesButton)");
        ImageButton categoriesButton = (ImageButton)var9;
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCategoriesScreen();
            }
        });
        //categoriesButton.setOnClickListener(Expenses::onCreate$lambda-3);
        RecyclerView recyclerView = (RecyclerView)this.findViewById(R.id.expensesList);
        LinearLayoutManager layoutManager = new LinearLayoutManager((Context)this);
        recyclerView.setLayoutManager((LayoutManager)layoutManager);
        final ExpensesAdapter adapter = new ExpensesAdapter();
        recyclerView.setAdapter((Adapter)adapter);
        ReferenceProvider.INSTANCE.getBaseReference().child("expenses").addListenerForSingleValueEvent((ValueEventListener)(new ValueEventListener() {
            public void onDataChange(@NotNull DataSnapshot snapshot) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                List expensesList = (List)(new ArrayList());
                Iterator var3 = snapshot.getChildren().iterator();

                while(var3.hasNext()) {
                    DataSnapshot child = (DataSnapshot)var3.next();
                    Object var10001 = child.getValue(Expense.class);
                    Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type com.gridness.assignment.models.Expense");
                    expensesList.add((Expense)var10001);
                }

                Expenses.this.getCategory(adapter, expensesList);
            }

            public void onCancelled(@NotNull DatabaseError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                String var2 = "Not yet implemented";
                throw new NotImplementedError("An operation is not implemented: " + var2);
            }
        }));
    }

    private final void getCategory(final ExpensesAdapter adapter, final List expensesList) {
        ReferenceProvider.INSTANCE.getBaseReference().child("categories").addListenerForSingleValueEvent((ValueEventListener)(new ValueEventListener() {
            public void onDataChange(@NotNull DataSnapshot snapshot) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                List categoryList = (List)(new ArrayList());
                Iterable $this$forEach$iv = (Iterable)expensesList;
                //int $i$f$forEach = false;
                Iterator var5 = $this$forEach$iv.iterator();

                while(var5.hasNext()) {
                    Object element$iv = var5.next();
                    Expense it = (Expense)element$iv;
                    //int var8 = false;
                    Object var10001 = snapshot.child(it.getCategoryID()).getValue(Category.class);
                    Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type com.gridness.assignment.models.Category");
                    it.setCategory((Category)var10001);
                }

                adapter.setExpensesList(expensesList);
            }

            public void onCancelled(@NotNull DatabaseError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                String var2 = "Not yet implemented";
                throw new NotImplementedError("An operation is not implemented: " + var2);
            }
        }));
    }

    private final void goAdd() {
        Intent intent = new Intent((Context)this, AddExpense.class);
        startActivity(intent);
        finish();
    }

    private final void goToFamilyScreen() {
        Intent intent = new Intent((Context)this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private final void goToExpensesScreen() {
        Intent intent = new Intent((Context)this, Expenses.class);
        startActivity(intent);
        finish();
    }

    private final void goToCategoriesScreen() {
        Intent intent = new Intent((Context)this, Categories.class);
        startActivity(intent);
        finish();
    }

    private static final void onCreate$lambda_0/* $FF was: onCreate$lambda-0*/(Expenses this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, AddExpense.class);
        this$0.startActivity(intent);
        this$0.finish();
    }

    private static final void onCreate$lambda_1/* $FF was: onCreate$lambda-1*/(Expenses this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, MainActivity.class);
        this$0.startActivity(intent);
        this$0.finish();
    }

    private static final void onCreate$lambda_2/* $FF was: onCreate$lambda-2*/(Expenses this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Expenses.class);
        this$0.startActivity(intent);
        this$0.finish();
    }

    private static final void onCreate$lambda_3/* $FF was: onCreate$lambda-3*/(Expenses this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent((Context)this$0, Categories.class);
        this$0.startActivity(intent);
        this$0.finish();
    }
}
