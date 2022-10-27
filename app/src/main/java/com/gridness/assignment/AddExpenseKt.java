package com.gridness.assignment;

import com.gridness.assignment.models.Category;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;

@Metadata(
        mv = {1, 7, 1},
        k = 2,
        xi = 48,
        d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¨\u0006\u0005"},
        d2 = {"toStringList", "", "", "", "Lcom/gridness/assignment/models/Category;", "app_debug"}
)
public final class AddExpenseKt {
    private static final List toStringList(Map $this$toStringList) {
        List stringList = (List)(new ArrayList());
        boolean $i$f$forEach = false;
        Iterator var4 = $this$toStringList.entrySet().iterator();

        while(var4.hasNext()) {
            Entry element$iv = (Entry)var4.next();
            boolean var7 = false;
            stringList.add(((Category)element$iv.getValue()).getCategoryName());
        }

        return stringList;
    }

    // $FF: synthetic method
    public static final List access$toStringList(Map $receiver) {
        return toStringList($receiver);
    }
}
