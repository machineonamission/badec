package com.blueair.viewcore.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelEvent;", "T", "", "action", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "variable", "<init>", "(Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;Ljava/lang/Object;)V", "getAction", "()Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "getVariable", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;Ljava/lang/Object;)Lcom/blueair/viewcore/viewmodel/BaseViewModelEvent;", "equals", "", "other", "hashCode", "", "toString", "", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BaseViewModelEvent {
   private final BaseViewModelAction action;
   private final Object variable;

   public BaseViewModelEvent(BaseViewModelAction var1, Object var2) {
      Intrinsics.checkNotNullParameter(var1, "action");
      super();
      this.action = var1;
      this.variable = var2;
   }

   // $FF: synthetic method
   public static BaseViewModelEvent copy$default(BaseViewModelEvent var0, BaseViewModelAction var1, Object var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.action;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.variable;
      }

      return var0.copy(var1, var2);
   }

   public final BaseViewModelAction component1() {
      return this.action;
   }

   public final Object component2() {
      return this.variable;
   }

   public final BaseViewModelEvent copy(BaseViewModelAction var1, Object var2) {
      Intrinsics.checkNotNullParameter(var1, "action");
      return new BaseViewModelEvent(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BaseViewModelEvent)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.action, var1.action)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.variable, var1.variable);
         }
      }
   }

   public final BaseViewModelAction getAction() {
      return this.action;
   }

   public final Object getVariable() {
      return this.variable;
   }

   public int hashCode() {
      int var2 = this.action.hashCode();
      Object var3 = this.variable;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return var2 * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BaseViewModelEvent(action=");
      var1.append(this.action);
      var1.append(", variable=");
      var1.append(this.variable);
      var1.append(')');
      return var1.toString();
   }
}
