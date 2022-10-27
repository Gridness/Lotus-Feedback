package com.gridness.assignment.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"},
        d2 = {"Lcom/gridness/assignment/models/Category;", "", "categoryName", "", "income", "(Ljava/lang/String;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getIncome", "app_debug"}
)
public final class Category {
    @NotNull
    private final String categoryName;
    @NotNull
    private final String income;

    public Category(@NotNull String categoryName, @NotNull String income) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(income, "income");
        //super();
        this.categoryName = categoryName;
        this.income = income;
    }

    // $FF: synthetic method
    public Category(String var1, String var2, int var3, DefaultConstructorMarker var4) {
        this(var1, var2);
        if ((var3 & 1) != 0) {
            var1 = "";
        }

        if ((var3 & 2) != 0) {
            var2 = "";
        }

        //this(var1, var2);
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getIncome() {
        return this.income;
    }

    public Category() {
        this((String)"", (String)"", 3, (DefaultConstructorMarker)null);
    }
}
