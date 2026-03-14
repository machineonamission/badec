package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"},
   d2 = {"Lcom/blueair/core/model/Filter;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "ParticleFilter", "SmokeStopFilter", "UnknownFilter", "Companion", "Lcom/blueair/core/model/Filter$ParticleFilter;", "Lcom/blueair/core/model/Filter$SmokeStopFilter;", "Lcom/blueair/core/model/Filter$UnknownFilter;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class Filter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String name;

   private Filter(String var1) {
      this.name = var1;
   }

   // $FF: synthetic method
   public Filter(String var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final String getName() {
      return this.name;
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"},
      d2 = {"Lcom/blueair/core/model/Filter$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/Filter;", "value", "", "toServerValue", "fromName", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final Filter fromName(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         if (Intrinsics.areEqual(var1, "particle_filter")) {
            return Filter.ParticleFilter.INSTANCE;
         } else {
            return Intrinsics.areEqual(var1, "smoke_stop_filter") ? (Filter)Filter.SmokeStopFilter.INSTANCE : (Filter)Filter.ParticleFilter.INSTANCE;
         }
      }

      public final Filter fromServerValue(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         if (((CharSequence)var1).length() == 0) {
            return Filter.ParticleFilter.INSTANCE;
         } else if (Intrinsics.areEqual(var1, "row")) {
            return Filter.ParticleFilter.INSTANCE;
         } else {
            return Intrinsics.areEqual(var1, "cn") ? (Filter)Filter.SmokeStopFilter.INSTANCE : (Filter)Filter.ParticleFilter.INSTANCE;
         }
      }

      public final String toServerValue(Filter var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         if (Intrinsics.areEqual(var1, Filter.ParticleFilter.INSTANCE)) {
            return "row";
         } else if (Intrinsics.areEqual(var1, Filter.SmokeStopFilter.INSTANCE)) {
            return "cn";
         } else if (Intrinsics.areEqual(var1, Filter.UnknownFilter.INSTANCE)) {
            return "row";
         } else {
            throw new NoWhenBranchMatchedException();
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/Filter$ParticleFilter;", "Lcom/blueair/core/model/Filter;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ParticleFilter extends Filter {
      public static final ParticleFilter INSTANCE = new ParticleFilter();

      private ParticleFilter() {
         super("particle_filter", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/Filter$SmokeStopFilter;", "Lcom/blueair/core/model/Filter;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SmokeStopFilter extends Filter {
      public static final SmokeStopFilter INSTANCE = new SmokeStopFilter();

      private SmokeStopFilter() {
         super("smoke_stop_filter", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/Filter$UnknownFilter;", "Lcom/blueair/core/model/Filter;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class UnknownFilter extends Filter {
      public static final UnknownFilter INSTANCE = new UnknownFilter();

      private UnknownFilter() {
         super("unknown_filter", (DefaultConstructorMarker)null);
      }
   }
}
