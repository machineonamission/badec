package com.blueair.core.util;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u0004\u0018\u00018\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR-\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0018\u0010\u0015¨\u0006#"},
   d2 = {"Lcom/blueair/core/util/MoshiSerializer;", "T", "Lcom/blueair/core/util/JsonSerializer;", "type", "Ljava/lang/reflect/Type;", "extraAdapters", "", "", "<init>", "(Ljava/lang/reflect/Type;[Ljava/lang/Object;)V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "Lkotlin/Lazy;", "mapAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "getMapAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "mapAdapter$delegate", "jsonAdapter", "getJsonAdapter", "jsonAdapter$delegate", "toJson", "t", "(Ljava/lang/Object;)Ljava/lang/String;", "fromJson", "serialized", "(Ljava/lang/String;)Ljava/lang/Object;", "fromMap", "map", "(Ljava/util/Map;)Ljava/lang/Object;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MoshiSerializer implements JsonSerializer {
   private final Lazy jsonAdapter$delegate;
   private final Lazy mapAdapter$delegate;
   private final Lazy moshi$delegate;
   private final Type type;

   // $FF: synthetic method
   public static Moshi $r8$lambda$2CWdDt01_fwfJixIdBsHowtk1_A/* $FF was: $r8$lambda$2CWdDt01-fwfJixIdBsHowtk1-A*/(Object[] var0) {
      return moshi_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static JsonAdapter $r8$lambda$2R_84uHyXAlKg9UEtVpc5jjHyxQ(MoshiSerializer var0) {
      return mapAdapter_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static JsonAdapter $r8$lambda$4J7SJYKC_RF8EGEf_sMHhQMU8Ds/* $FF was: $r8$lambda$4J7SJYKC-RF8EGEf_sMHhQMU8Ds*/(MoshiSerializer var0) {
      return jsonAdapter_delegate$lambda$3(var0);
   }

   public MoshiSerializer(Type var1, Object... var2) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "extraAdapters");
      super();
      this.type = var1;
      this.moshi$delegate = LazyKt.lazy(new MoshiSerializer$$ExternalSyntheticLambda0(var2));
      this.mapAdapter$delegate = LazyKt.lazy(new MoshiSerializer$$ExternalSyntheticLambda1(this));
      this.jsonAdapter$delegate = LazyKt.lazy(new MoshiSerializer$$ExternalSyntheticLambda2(this));
   }

   private final JsonAdapter getJsonAdapter() {
      Object var1 = this.jsonAdapter$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (JsonAdapter)var1;
   }

   private final JsonAdapter getMapAdapter() {
      Object var1 = this.mapAdapter$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (JsonAdapter)var1;
   }

   private final Moshi getMoshi() {
      Object var1 = this.moshi$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (Moshi)var1;
   }

   private static final JsonAdapter jsonAdapter_delegate$lambda$3(MoshiSerializer var0) {
      return var0.getMoshi().adapter(var0.type);
   }

   private static final JsonAdapter mapAdapter_delegate$lambda$2(MoshiSerializer var0) {
      return var0.getMoshi().adapter((Type)Types.newParameterizedType((Type)Map.class, new Type[]{String.class, Object.class}));
   }

   private static final Moshi moshi_delegate$lambda$1(Object[] var0) {
      Moshi.Builder var3 = new Moshi.Builder();
      int var2 = var0.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         var3.add(var0[var1]);
      }

      var3.add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory()));
      return var3.build();
   }

   public Object fromJson(String var1) {
      Intrinsics.checkNotNullParameter(var1, "serialized");
      return ((CharSequence)var1).length() > 0 ? this.getJsonAdapter().fromJson(var1) : null;
   }

   public final Object fromMap(Map var1) {
      Intrinsics.checkNotNullParameter(var1, "map");
      String var2 = this.getMapAdapter().toJson(var1);
      Intrinsics.checkNotNull(var2);
      return this.fromJson(var2);
   }

   public String toJson(Object var1) {
      String var2 = this.getJsonAdapter().toJson(var1);
      Intrinsics.checkNotNullExpressionValue(var2, "toJson(...)");
      return var2;
   }
}
