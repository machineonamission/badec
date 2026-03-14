package com.blueair.viewcore.viewmodel;

import android.os.Parcelable;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u000f\u0010\r\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\nR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000eÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModelNonNullState;", "S", "Landroid/os/Parcelable;", "", "liveData", "Landroidx/lifecycle/MutableLiveData;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "state", "getState", "()Landroid/os/Parcelable;", "setState", "(Landroid/os/Parcelable;)V", "onSaveState", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface MvvmCustomViewModelNonNullState {
   MutableLiveData getLiveData();

   Parcelable getState();

   Parcelable onSaveState();

   void setState(Parcelable var1);
}
