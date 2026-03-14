package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"},
   d2 = {"getSupportedFilters", "", "Lcom/blueair/core/model/Filter;", "Lcom/blueair/core/model/HasFanSpeed;", "core_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterKt {
   public static final List getSupportedFilters(HasFanSpeed var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      if (var0 instanceof DeviceSense) {
         return CollectionsKt.listOf(Filter.ParticleFilter.INSTANCE);
      } else {
         return !(var0 instanceof DeviceClassic) && !(var0 instanceof DeviceClassicWithoutSensors) ? CollectionsKt.emptyList() : CollectionsKt.listOf(new Filter[]{Filter.ParticleFilter.INSTANCE, Filter.SmokeStopFilter.INSTANCE});
      }
   }
}
