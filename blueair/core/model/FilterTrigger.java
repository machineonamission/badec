package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"},
   d2 = {"Lcom/blueair/core/model/FilterTrigger;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Particles", "ParticlesAndGases", "UnknownTrigger", "Companion", "Lcom/blueair/core/model/FilterTrigger$Particles;", "Lcom/blueair/core/model/FilterTrigger$ParticlesAndGases;", "Lcom/blueair/core/model/FilterTrigger$UnknownTrigger;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class FilterTrigger {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String name;

   private FilterTrigger(String var1) {
      this.name = var1;
   }

   // $FF: synthetic method
   public FilterTrigger(String var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final String getName() {
      return this.name;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/FilterTrigger$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/FilterTrigger;", "value", "", "core_otherRelease"},
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

      public final FilterTrigger fromServerValue(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         if (((CharSequence)var1).length() == 0) {
            return FilterTrigger.UnknownTrigger.INSTANCE;
         } else {
            int var2 = var1.hashCode();
            if (var2 != -1929983181) {
               if (var2 != -984891512) {
                  if (var2 != 2557) {
                     if (var2 == 3581 && var1.equals("pm")) {
                        return FilterTrigger.Particles.INSTANCE;
                     }
                  } else if (var1.equals("PM")) {
                     return FilterTrigger.Particles.INSTANCE;
                  }

                  return FilterTrigger.UnknownTrigger.INSTANCE;
               }

               if (!var1.equals("pm_voc")) {
                  return FilterTrigger.UnknownTrigger.INSTANCE;
               }
            } else if (!var1.equals("PMtVOC")) {
               return FilterTrigger.UnknownTrigger.INSTANCE;
            }

            return FilterTrigger.ParticlesAndGases.INSTANCE;
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/FilterTrigger$Particles;", "Lcom/blueair/core/model/FilterTrigger;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Particles extends FilterTrigger {
      public static final Particles INSTANCE = new Particles();

      private Particles() {
         super("particles", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/FilterTrigger$ParticlesAndGases;", "Lcom/blueair/core/model/FilterTrigger;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ParticlesAndGases extends FilterTrigger {
      public static final ParticlesAndGases INSTANCE = new ParticlesAndGases();

      private ParticlesAndGases() {
         super("particles and gases", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/FilterTrigger$UnknownTrigger;", "Lcom/blueair/core/model/FilterTrigger;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class UnknownTrigger extends FilterTrigger {
      public static final UnknownTrigger INSTANCE = new UnknownTrigger();

      private UnknownTrigger() {
         super("unknown_trigger", (DefaultConstructorMarker)null);
      }
   }
}
