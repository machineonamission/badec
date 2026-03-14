package com.blueair.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"},
   d2 = {"Lcom/blueair/core/util/BasicTwoWayBindingThrottle;", "", "allowUpdateTimeout", "", "<init>", "(J)V", "getAllowUpdateTimeout", "()J", "lastUpdateSent", "notifyUpdateSent", "", "allowReceiveUpdate", "", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BasicTwoWayBindingThrottle {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final long DEFAULT_ALLOW_UPDATE_TIMEOUT = 3000L;
   private final long allowUpdateTimeout;
   private long lastUpdateSent;

   public BasicTwoWayBindingThrottle() {
      this(0L, 1, (DefaultConstructorMarker)null);
   }

   public BasicTwoWayBindingThrottle(long var1) {
      this.allowUpdateTimeout = var1;
   }

   // $FF: synthetic method
   public BasicTwoWayBindingThrottle(long var1, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 1) != 0) {
         var1 = 3000L;
      }

      this(var1);
   }

   public final boolean allowReceiveUpdate() {
      synchronized(this){}

      Throwable var10000;
      label164: {
         boolean var1;
         label157: {
            label156: {
               try {
                  if (Math.abs(System.currentTimeMillis() - this.lastUpdateSent) > this.allowUpdateTimeout) {
                     break label156;
                  }
               } catch (Throwable var14) {
                  var10000 = var14;
                  boolean var10001 = false;
                  break label164;
               }

               var1 = false;
               break label157;
            }

            var1 = true;
         }

         if (var1) {
            return var1;
         }

         label149:
         try {
            Timber.Forest.v("allowReceiveUpdate: block update", new Object[0]);
            return var1;
         } catch (Throwable var13) {
            var10000 = var13;
            boolean var15 = false;
            break label149;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var12) {
            var10000 = var12;
            boolean var16 = false;
            continue;
         }
      }
   }

   public final long getAllowUpdateTimeout() {
      return this.allowUpdateTimeout;
   }

   public final void notifyUpdateSent() {
      synchronized(this){}

      try {
         this.lastUpdateSent = System.currentTimeMillis();
      } catch (Throwable var7) {
         Throwable var10000 = var7;
         boolean var10001 = false;

         while(true) {
            Throwable var1 = var10000;

            try {
               throw var1;
            } catch (Throwable var6) {
               var10000 = var6;
               var10001 = false;
               continue;
            }
         }
      }

   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/util/BasicTwoWayBindingThrottle$Companion;", "", "<init>", "()V", "DEFAULT_ALLOW_UPDATE_TIMEOUT", "", "core_otherRelease"},
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
   }
}
