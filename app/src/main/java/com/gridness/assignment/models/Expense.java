package com.gridness.assignment.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"},
        d2 = {"Lcom/gridness/assignment/models/Expense;", "", "expenseName", "", "categoryID", "cost", "category", "Lcom/gridness/assignment/models/Category;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/gridness/assignment/models/Category;)V", "getCategory", "()Lcom/gridness/assignment/models/Category;", "setCategory", "(Lcom/gridness/assignment/models/Category;)V", "getCategoryID", "()Ljava/lang/String;", "getCost", "getExpenseName", "app_debug"}
)
public final class Expense {
    @NotNull
    private final String expenseName;
    @NotNull
    private final String categoryID;
    @NotNull
    private final String cost;
    @Nullable
    private Category category;

    public Expense(@NotNull String expenseName, @NotNull String categoryID, @NotNull String cost, @Nullable Category category) {
        Intrinsics.checkNotNullParameter(expenseName, "expenseName");
        Intrinsics.checkNotNullParameter(categoryID, "categoryID");
        Intrinsics.checkNotNullParameter(cost, "cost");
        //super();
        this.expenseName = expenseName;
        this.categoryID = categoryID;
        this.cost = cost;
        this.category = category;
    }

    // $FF: synthetic method
    public Expense(String var1, String var2, String var3, Category var4, int var5, DefaultConstructorMarker var6) {
        this(var1, var2, var3, var4);
        if ((var5 & 1) != 0) {
            var1 = "";
        }

        if ((var5 & 2) != 0) {
            var2 = "";
        }

        if ((var5 & 4) != 0) {
            var3 = "";
        }

        if ((var5 & 8) != 0) {
            var4 = null;
        }

        //this(var1, var2, var3, var4);
    }

    @NotNull
    public final String getExpenseName() {
        return this.expenseName;
    }

    @NotNull
    public final String getCategoryID() {
        return this.categoryID;
    }

    @NotNull
    public final String getCost() {
        return this.cost;
    }

    @Nullable
    public final Category getCategory() {
        return this.category;
    }

    public final void setCategory(@Nullable Category var1) {
        this.category = var1;
    }

    public Expense() {
        this((String)"", (String)"", (String)"", (Category)null, 15, (DefaultConstructorMarker)null);
    }
}
