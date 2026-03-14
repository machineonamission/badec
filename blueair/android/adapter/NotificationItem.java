package com.blueair.android.adapter;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.NotificationMessage;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0015\u001a\u00020\bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J/\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "},
   d2 = {"Lcom/blueair/android/adapter/NotificationItem;", "", "message", "Lcom/blueair/core/model/NotificationMessage;", "deviceFilters", "", "Lcom/blueair/core/model/FilterInfo;", "hasVideo", "", "<init>", "(Lcom/blueair/core/model/NotificationMessage;Ljava/util/List;Z)V", "getMessage", "()Lcom/blueair/core/model/NotificationMessage;", "getDeviceFilters", "()Ljava/util/List;", "setDeviceFilters", "(Ljava/util/List;)V", "getHasVideo", "()Z", "setHasVideo", "(Z)V", "canBuy", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationItem {
   public static final int $stable = 8;
   private List deviceFilters;
   private boolean hasVideo;
   private final NotificationMessage message;

   public NotificationItem(NotificationMessage var1, List var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "message");
      super();
      this.message = var1;
      this.deviceFilters = var2;
      this.hasVideo = var3;
   }

   // $FF: synthetic method
   public NotificationItem(NotificationMessage var1, List var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static NotificationItem copy$default(NotificationItem var0, NotificationMessage var1, List var2, boolean var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.message;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.deviceFilters;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.hasVideo;
      }

      return var0.copy(var1, var2, var3);
   }

   public final boolean canBuy() {
      List var1 = this.deviceFilters;
      return var1 != null && ((Collection)var1).isEmpty() ^ true;
   }

   public final NotificationMessage component1() {
      return this.message;
   }

   public final List component2() {
      return this.deviceFilters;
   }

   public final boolean component3() {
      return this.hasVideo;
   }

   public final NotificationItem copy(NotificationMessage var1, List var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "message");
      return new NotificationItem(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof NotificationItem)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.message, var1.message)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceFilters, var1.deviceFilters)) {
            return false;
         } else {
            return this.hasVideo == var1.hasVideo;
         }
      }
   }

   public final List getDeviceFilters() {
      return this.deviceFilters;
   }

   public final boolean getHasVideo() {
      return this.hasVideo;
   }

   public final NotificationMessage getMessage() {
      return this.message;
   }

   public int hashCode() {
      int var2 = this.message.hashCode();
      List var3 = this.deviceFilters;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return (var2 * 31 + var1) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasVideo);
   }

   public final void setDeviceFilters(List var1) {
      this.deviceFilters = var1;
   }

   public final void setHasVideo(boolean var1) {
      this.hasVideo = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("NotificationItem(message=");
      var1.append(this.message);
      var1.append(", deviceFilters=");
      var1.append(this.deviceFilters);
      var1.append(", hasVideo=");
      var1.append(this.hasVideo);
      var1.append(')');
      return var1.toString();
   }
}
