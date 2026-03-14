package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/model/FilterConfig;", "", "video", "Lcom/blueair/core/model/AwsLinkConfig;", "videoThumbnail", "", "filters", "", "Lcom/blueair/core/model/FilterInfo;", "<init>", "(Lcom/blueair/core/model/AwsLinkConfig;ILjava/util/List;)V", "getVideo", "()Lcom/blueair/core/model/AwsLinkConfig;", "getVideoThumbnail", "()I", "getFilters", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterConfig {
   private final List filters;
   private final AwsLinkConfig video;
   private final int videoThumbnail;

   public FilterConfig(AwsLinkConfig var1, int var2, List var3) {
      Intrinsics.checkNotNullParameter(var3, "filters");
      super();
      this.video = var1;
      this.videoThumbnail = var2;
      this.filters = var3;
   }

   // $FF: synthetic method
   public static FilterConfig copy$default(FilterConfig var0, AwsLinkConfig var1, int var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.video;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.videoThumbnail;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.filters;
      }

      return var0.copy(var1, var2, var3);
   }

   public final AwsLinkConfig component1() {
      return this.video;
   }

   public final int component2() {
      return this.videoThumbnail;
   }

   public final List component3() {
      return this.filters;
   }

   public final FilterConfig copy(AwsLinkConfig var1, int var2, List var3) {
      Intrinsics.checkNotNullParameter(var3, "filters");
      return new FilterConfig(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof FilterConfig)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.video, var1.video)) {
            return false;
         } else if (this.videoThumbnail != var1.videoThumbnail) {
            return false;
         } else {
            return Intrinsics.areEqual(this.filters, var1.filters);
         }
      }
   }

   public final List getFilters() {
      return this.filters;
   }

   public final AwsLinkConfig getVideo() {
      return this.video;
   }

   public final int getVideoThumbnail() {
      return this.videoThumbnail;
   }

   public int hashCode() {
      AwsLinkConfig var2 = this.video;
      int var1;
      if (var2 == null) {
         var1 = 0;
      } else {
         var1 = var2.hashCode();
      }

      return (var1 * 31 + this.videoThumbnail) * 31 + this.filters.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("FilterConfig(video=");
      var1.append(this.video);
      var1.append(", videoThumbnail=");
      var1.append(this.videoThumbnail);
      var1.append(", filters=");
      var1.append(this.filters);
      var1.append(')');
      return var1.toString();
   }
}
