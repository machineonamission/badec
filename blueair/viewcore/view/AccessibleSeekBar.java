package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"},
   d2 = {"Lcom/blueair/viewcore/view/AccessibleSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isAccessibilityProgressStartPosted", "", "lastAccessibilityProgressChangeTime", "", "accessibilityProgressCheckDelay", "getAccessibilityProgressCheckDelay", "()J", "setAccessibilityProgressCheckDelay", "(J)V", "setOnSeekBarChangeListener", "", "listener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AccessibleSeekBar extends AppCompatSeekBar {
   private long accessibilityProgressCheckDelay;
   private boolean isAccessibilityProgressStartPosted;
   private long lastAccessibilityProgressChangeTime;

   public AccessibleSeekBar(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 2, (DefaultConstructorMarker)null);
   }

   public AccessibleSeekBar(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2);
      this.accessibilityProgressCheckDelay = 3000L;
   }

   // $FF: synthetic method
   public AccessibleSeekBar(Context var1, AttributeSet var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   public final long getAccessibilityProgressCheckDelay() {
      return this.accessibilityProgressCheckDelay;
   }

   public final void setAccessibilityProgressCheckDelay(long var1) {
      this.accessibilityProgressCheckDelay = var1;
   }

   public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener var1) {
      if (var1 != null) {
         var1 = new SeekBar.OnSeekBarChangeListener(var1, this) {
            private final SeekBar.OnSeekBarChangeListener $$delegate_0;
            final SeekBar.OnSeekBarChangeListener $listener;
            final AccessibleSeekBar this$0;

            // $FF: synthetic method
            public static void $r8$lambda$1gRdZZZB50WCN4DD9eF615rHCDk(AccessibleSeekBar var0, SeekBar.OnSeekBarChangeListener var1, SeekBar var2) {
               onProgressChanged$lambda$0(var0, var1, var2);
            }

            {
               this.$listener = var1;
               this.this$0 = var2;
               this.$$delegate_0 = var1;
            }

            private static final void onProgressChanged$lambda$0(AccessibleSeekBar var0, SeekBar.OnSeekBarChangeListener var1, SeekBar var2) {
               if (var0.isAccessibilityProgressStartPosted && System.currentTimeMillis() - var0.lastAccessibilityProgressChangeTime > var0.getAccessibilityProgressCheckDelay() - (long)100) {
                  var0.isAccessibilityProgressStartPosted = false;
                  var1.onStopTrackingTouch(var2);
               }

            }

            public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
               if (this.this$0.isAccessibilityFocused()) {
                  if (!this.this$0.isAccessibilityProgressStartPosted) {
                     this.this$0.isAccessibilityProgressStartPosted = true;
                     this.$listener.onStartTrackingTouch(var1);
                  }

                  this.this$0.lastAccessibilityProgressChangeTime = System.currentTimeMillis();
                  this.$listener.onProgressChanged(var1, var2, var3);
                  AccessibleSeekBar var4 = this.this$0;
                  var4.postDelayed(new AccessibleSeekBar$setOnSeekBarChangeListener$1$1$$ExternalSyntheticLambda0(var4, this.$listener, var1), this.this$0.getAccessibilityProgressCheckDelay());
               } else {
                  this.$listener.onProgressChanged(var1, var2, var3);
               }
            }

            public void onStartTrackingTouch(SeekBar var1) {
               this.$$delegate_0.onStartTrackingTouch(var1);
            }

            public void onStopTrackingTouch(SeekBar var1) {
               this.$$delegate_0.onStopTrackingTouch(var1);
            }
         };
      } else {
         var1 = null;
      }

      super.setOnSeekBarChangeListener(var1);
   }
}
