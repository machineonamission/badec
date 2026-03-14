package com.blueair.viewcore.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u0088\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u0005J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u001a¨\u0006?"},
   d2 = {"Lcom/blueair/viewcore/dialog/StepGuides;", "Landroid/os/Parcelable;", "requestKey", "", "headTitle", "", "headMessage", "headBtn", "stepTitle", "stepBtn", "stepMessages", "", "completeTitle", "completeMessage", "completeBtn", "minLines", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/util/List;IIII)V", "getRequestKey", "()Ljava/lang/String;", "getHeadTitle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeadMessage", "getHeadBtn", "getStepTitle", "()I", "getStepBtn", "getStepMessages", "()Ljava/util/List;", "getCompleteTitle", "getCompleteMessage", "getCompleteBtn", "getMinLines", "stepSize", "getStepSize", "pageSize", "getPageSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/util/List;IIII)Lcom/blueair/viewcore/dialog/StepGuides;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StepGuides implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int completeBtn;
   private final int completeMessage;
   private final int completeTitle;
   private final Integer headBtn;
   private final Integer headMessage;
   private final Integer headTitle;
   private final int minLines;
   private final String requestKey;
   private final int stepBtn;
   private final List stepMessages;
   private final int stepTitle;

   public StepGuides(String var1, Integer var2, Integer var3, Integer var4, int var5, int var6, List var7, int var8, int var9, int var10, int var11) {
      Intrinsics.checkNotNullParameter(var1, "requestKey");
      Intrinsics.checkNotNullParameter(var7, "stepMessages");
      super();
      this.requestKey = var1;
      this.headTitle = var2;
      this.headMessage = var3;
      this.headBtn = var4;
      this.stepTitle = var5;
      this.stepBtn = var6;
      this.stepMessages = var7;
      this.completeTitle = var8;
      this.completeMessage = var9;
      this.completeBtn = var10;
      this.minLines = var11;
   }

   // $FF: synthetic method
   public static StepGuides copy$default(StepGuides var0, String var1, Integer var2, Integer var3, Integer var4, int var5, int var6, List var7, int var8, int var9, int var10, int var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.requestKey;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.headTitle;
      }

      if ((var12 & 4) != 0) {
         var3 = var0.headMessage;
      }

      if ((var12 & 8) != 0) {
         var4 = var0.headBtn;
      }

      if ((var12 & 16) != 0) {
         var5 = var0.stepTitle;
      }

      if ((var12 & 32) != 0) {
         var6 = var0.stepBtn;
      }

      if ((var12 & 64) != 0) {
         var7 = var0.stepMessages;
      }

      if ((var12 & 128) != 0) {
         var8 = var0.completeTitle;
      }

      if ((var12 & 256) != 0) {
         var9 = var0.completeMessage;
      }

      if ((var12 & 512) != 0) {
         var10 = var0.completeBtn;
      }

      if ((var12 & 1024) != 0) {
         var11 = var0.minLines;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final String component1() {
      return this.requestKey;
   }

   public final int component10() {
      return this.completeBtn;
   }

   public final int component11() {
      return this.minLines;
   }

   public final Integer component2() {
      return this.headTitle;
   }

   public final Integer component3() {
      return this.headMessage;
   }

   public final Integer component4() {
      return this.headBtn;
   }

   public final int component5() {
      return this.stepTitle;
   }

   public final int component6() {
      return this.stepBtn;
   }

   public final List component7() {
      return this.stepMessages;
   }

   public final int component8() {
      return this.completeTitle;
   }

   public final int component9() {
      return this.completeMessage;
   }

   public final StepGuides copy(String var1, Integer var2, Integer var3, Integer var4, int var5, int var6, List var7, int var8, int var9, int var10, int var11) {
      Intrinsics.checkNotNullParameter(var1, "requestKey");
      Intrinsics.checkNotNullParameter(var7, "stepMessages");
      return new StepGuides(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof StepGuides)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.requestKey, var1.requestKey)) {
            return false;
         } else if (!Intrinsics.areEqual(this.headTitle, var1.headTitle)) {
            return false;
         } else if (!Intrinsics.areEqual(this.headMessage, var1.headMessage)) {
            return false;
         } else if (!Intrinsics.areEqual(this.headBtn, var1.headBtn)) {
            return false;
         } else if (this.stepTitle != var1.stepTitle) {
            return false;
         } else if (this.stepBtn != var1.stepBtn) {
            return false;
         } else if (!Intrinsics.areEqual(this.stepMessages, var1.stepMessages)) {
            return false;
         } else if (this.completeTitle != var1.completeTitle) {
            return false;
         } else if (this.completeMessage != var1.completeMessage) {
            return false;
         } else if (this.completeBtn != var1.completeBtn) {
            return false;
         } else {
            return this.minLines == var1.minLines;
         }
      }
   }

   public final int getCompleteBtn() {
      return this.completeBtn;
   }

   public final int getCompleteMessage() {
      return this.completeMessage;
   }

   public final int getCompleteTitle() {
      return this.completeTitle;
   }

   public final Integer getHeadBtn() {
      return this.headBtn;
   }

   public final Integer getHeadMessage() {
      return this.headMessage;
   }

   public final Integer getHeadTitle() {
      return this.headTitle;
   }

   public final int getMinLines() {
      return this.minLines;
   }

   public final int getPageSize() {
      int var2 = this.getStepSize();
      byte var1;
      if (this.headTitle == null) {
         var1 = 1;
      } else {
         var1 = 2;
      }

      return var2 + var1;
   }

   public final String getRequestKey() {
      return this.requestKey;
   }

   public final int getStepBtn() {
      return this.stepBtn;
   }

   public final List getStepMessages() {
      return this.stepMessages;
   }

   public final int getStepSize() {
      return this.stepMessages.size();
   }

   public final int getStepTitle() {
      return this.stepTitle;
   }

   public int hashCode() {
      int var4 = this.requestKey.hashCode();
      Integer var5 = this.headTitle;
      int var3 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      var5 = this.headMessage;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      var5 = this.headBtn;
      if (var5 != null) {
         var3 = var5.hashCode();
      }

      return (((((((((var4 * 31 + var1) * 31 + var2) * 31 + var3) * 31 + this.stepTitle) * 31 + this.stepBtn) * 31 + this.stepMessages.hashCode()) * 31 + this.completeTitle) * 31 + this.completeMessage) * 31 + this.completeBtn) * 31 + this.minLines;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("StepGuides(requestKey=");
      var1.append(this.requestKey);
      var1.append(", headTitle=");
      var1.append(this.headTitle);
      var1.append(", headMessage=");
      var1.append(this.headMessage);
      var1.append(", headBtn=");
      var1.append(this.headBtn);
      var1.append(", stepTitle=");
      var1.append(this.stepTitle);
      var1.append(", stepBtn=");
      var1.append(this.stepBtn);
      var1.append(", stepMessages=");
      var1.append(this.stepMessages);
      var1.append(", completeTitle=");
      var1.append(this.completeTitle);
      var1.append(", completeMessage=");
      var1.append(this.completeMessage);
      var1.append(", completeBtn=");
      var1.append(this.completeBtn);
      var1.append(", minLines=");
      var1.append(this.minLines);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.requestKey);
      Integer var3 = this.headTitle;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3);
      }

      var3 = this.headMessage;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3);
      }

      var3 = this.headBtn;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3);
      }

      var1.writeInt(this.stepTitle);
      var1.writeInt(this.stepBtn);
      List var6 = this.stepMessages;
      var1.writeInt(var6.size());
      Iterator var7 = var6.iterator();

      while(var7.hasNext()) {
         var1.writeInt(((Number)var7.next()).intValue());
      }

      var1.writeInt(this.completeTitle);
      var1.writeInt(this.completeMessage);
      var1.writeInt(this.completeBtn);
      var1.writeInt(this.minLines);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final StepGuides createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var9 = var1.readString();
         int var2 = var1.readInt();
         Integer var8 = null;
         Integer var6;
         if (var2 == 0) {
            var6 = null;
         } else {
            var6 = var1.readInt();
         }

         Integer var7;
         if (var1.readInt() == 0) {
            var7 = null;
         } else {
            var7 = var1.readInt();
         }

         if (var1.readInt() != 0) {
            var8 = var1.readInt();
         }

         int var3 = var1.readInt();
         int var4 = var1.readInt();
         int var5 = var1.readInt();
         ArrayList var10 = new ArrayList(var5);

         for(int var11 = 0; var11 != var5; ++var11) {
            var10.add(var1.readInt());
         }

         return new StepGuides(var9, var6, var7, var8, var3, var4, (List)var10, var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt());
      }

      public final StepGuides[] newArray(int var1) {
         return new StepGuides[var1];
      }
   }
}
