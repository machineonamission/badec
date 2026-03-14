package com.blueair.database.entity;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086\b¢\u0006\u0002\u0010\u0007¨\u0006\b"},
   d2 = {"getAttribute", "T", "HasT", "device", "Lcom/blueair/core/model/Device;", "property", "Lkotlin/reflect/KProperty1;", "(Lcom/blueair/core/model/Device;Lkotlin/reflect/KProperty1;)Ljava/lang/Object;", "database_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceEntityKt {
   // $FF: synthetic method
   public static final Object getAttribute(Device var0, KProperty1 var1) {
      Intrinsics.checkNotNullParameter(var0, "device");
      Intrinsics.checkNotNullParameter(var1, "property");
      Intrinsics.reifiedOperationMarker(3, "HasT");
      return var0 instanceof Object ? var1.get(var0) : null;
   }
}
