package com.blueair.android.adapter;

import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/android/adapter/ItemTouchHelperAdapter;", "", "onItemMove", "", "fromPosition", "", "toPosition", "onItemDismiss", "", "position", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface ItemTouchHelperAdapter {
   void onItemDismiss(int var1);

   boolean onItemMove(int var1, int var2);
}
