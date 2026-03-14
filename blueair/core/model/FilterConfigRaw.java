package com.blueair.core.model;

import com.blueair.core.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u000fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J%\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"},
   d2 = {"Lcom/blueair/core/model/FilterConfigRaw;", "", "video", "", "filters", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getVideo", "()Ljava/lang/String;", "getFilters", "()Ljava/util/List;", "toFilterConfig", "Lcom/blueair/core/model/FilterConfig;", "linkMap", "", "Lcom/blueair/core/model/AwsLinkConfig;", "filterInfoMap", "Lcom/blueair/core/model/FilterInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterConfigRaw {
   private final List filters;
   private final String video;

   public FilterConfigRaw(String var1, List var2) {
      Intrinsics.checkNotNullParameter(var2, "filters");
      super();
      this.video = var1;
      this.filters = var2;
   }

   // $FF: synthetic method
   public static FilterConfigRaw copy$default(FilterConfigRaw var0, String var1, List var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.video;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.filters;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.video;
   }

   public final List component2() {
      return this.filters;
   }

   public final FilterConfigRaw copy(String var1, List var2) {
      Intrinsics.checkNotNullParameter(var2, "filters");
      return new FilterConfigRaw(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof FilterConfigRaw)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.video, var1.video)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.filters, var1.filters);
         }
      }
   }

   public final List getFilters() {
      return this.filters;
   }

   public final String getVideo() {
      return this.video;
   }

   public int hashCode() {
      String var2 = this.video;
      int var1;
      if (var2 == null) {
         var1 = 0;
      } else {
         var1 = var2.hashCode();
      }

      return var1 * 31 + this.filters.hashCode();
   }

   public final FilterConfig toFilterConfig(Map var1, Map var2) {
      int var3;
      label69: {
         Intrinsics.checkNotNullParameter(var1, "linkMap");
         Intrinsics.checkNotNullParameter(var2, "filterInfoMap");
         var8 = (AwsLinkConfig)var1.get(this.video);
         SkuConfigurationKt.access$logNotFoundError("filter_config.video", this.video, var8);
         if (var4 != null) {
            switch (var4) {
               case "v_humidifier20":
                  var3 = R.drawable.vt_humidifier20;
                  break label69;
               case "v_combo2in1":
                  var3 = R.drawable.vt_combo2in1;
                  break label69;
               case "v_combo3in1":
                  var3 = R.drawable.vt_combo3in1;
                  break label69;
               case "v_g4":
                  var3 = R.drawable.vt_g4;
                  break label69;
               case "v_nb":
                  var3 = R.drawable.vt_nb;
                  break label69;
               case "v_nc":
                  var3 = R.drawable.vt_nc;
                  break label69;
               case "v_mrest":
                  var3 = R.drawable.vt_mrest;
                  break label69;
               case "v_pet20":
                  var3 = R.drawable.vt_pet20;
                  break label69;
               case "v_blue40":
                  var3 = R.drawable.vt_blue40;
                  break label69;
               case "v_nb_511":
                  var3 = R.drawable.vt_nb_511;
                  break label69;
               case "v_humidifier":
                  var3 = R.drawable.vt_humidifier;
                  break label69;
            }
         }

         var3 = 0;
      }

      SkuConfigurationKt.access$logNotFoundError("filter_config.video_thumbnail", this.video, var3);
      List var5 = (List)(new ArrayList());

      for(String var9 : (Iterable)this.filters) {
         FilterInfo var7 = (FilterInfo)var2.get(var9);
         if (var7 != null) {
            var5.add(var7);
         }

         SkuConfigurationKt.access$logNotFoundError("filter_config.filters", var9, var7);
      }

      return new FilterConfig(var8, var3, var5);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("FilterConfigRaw(video=");
      var1.append(this.video);
      var1.append(", filters=");
      var1.append(this.filters);
      var1.append(')');
      return var1.toString();
   }
}
