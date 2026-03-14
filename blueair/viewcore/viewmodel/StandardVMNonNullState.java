package com.blueair.viewcore.viewmodel;

import android.os.Parcelable;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00028\u0000X¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/StandardVMNonNullState;", "S", "Landroid/os/Parcelable;", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModelNonNullState;", "<init>", "()V", "stateLock", "", "getStateLock", "()Ljava/lang/Object;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "defaultState", "getDefaultState", "()Landroid/os/Parcelable;", "value", "state", "getState", "setState", "(Landroid/os/Parcelable;)V", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class StandardVMNonNullState implements MvvmCustomViewModelNonNullState {
   private final MutableLiveData liveData = new MutableLiveData();
   private final Object stateLock = new Object();

   protected abstract Parcelable getDefaultState();

   public MutableLiveData getLiveData() {
      return this.liveData;
   }

   public Parcelable getState() {
      Object var3 = this.stateLock;
      synchronized(var3){}

      Throwable var10000;
      label75: {
         Parcelable var2;
         try {
            var2 = (Parcelable)this.getLiveData().getValue();
         } catch (Throwable var9) {
            var10000 = var9;
            boolean var10001 = false;
            break label75;
         }

         Parcelable var1 = var2;
         if (var2 != null) {
            return var1;
         }

         label66:
         try {
            var1 = this.getDefaultState();
            return var1;
         } catch (Throwable var8) {
            var10000 = var8;
            boolean var11 = false;
            break label66;
         }
      }

      Throwable var10 = var10000;
      throw var10;
   }

   protected final Object getStateLock() {
      return this.stateLock;
   }

   public void setState(Parcelable var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      Object var2 = this.stateLock;
      synchronized(var2){}

      try {
         this.getLiveData().setValue(var1);
         Unit var5 = Unit.INSTANCE;
      } finally {
         ;
      }

   }
}
