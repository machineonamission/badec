package com.blueair.viewcore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.viewcore.databinding.ConfirmationDialogBinding;
import de.mateware.snacky.Snacky;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001=B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011Jf\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\u0010\"Jb\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\u0010%J\"\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u0002022\b\b\u0001\u00103\u001a\u00020\u0005Jj\u00104\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\b\u0002\u00105\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0013\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\r2:\b\u0002\u00108\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(:\u0012\u0013\u0012\u00110;¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\b\u0018\u000109R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"},
   d2 = {"Lcom/blueair/viewcore/ViewUtils;", "", "<init>", "()V", "requestCodeCounter", "", "genRequestCode", "showError", "", "activity", "Landroid/app/Activity;", "messageResId", "message", "", "showInfo", "showSnackbar", "type", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "view", "Landroid/view/View;", "showConfirmation", "context", "Landroid/content/Context;", "titleText", "bodyText", "positiveTextResId", "negativeTextResId", "topImageResId", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "confirmed", "(Landroid/content/Context;IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "positiveText", "negativeText", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "colorGradient", "Landroid/graphics/drawable/PaintDrawable;", "colors", "", "positions", "", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "shouldShowFilterDoorPopup", "device", "Lcom/blueair/core/model/HasSafetySwitch;", "createTimePickerShowAccessibilityDelegate", "Landroidx/core/view/AccessibilityDelegateCompat;", "contentDescriptionPatternResourceId", "setAccessibilityDelegate", "kClass", "Lkotlin/reflect/KClass;", "tooltip", "initializer", "Lkotlin/Function2;", "host", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "MessageType", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ViewUtils {
   public static final ViewUtils INSTANCE = new ViewUtils();
   private static volatile int requestCodeCounter;

   // $FF: synthetic method
   public static void $r8$lambda$bk393CA7ZKXGNPT1_5SlWFGeij0(Function1 var0, DialogInterface var1, int var2) {
      showConfirmation$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$p3YuyFI_B7zBcSIjb7xs9a_avss/* $FF was: $r8$lambda$p3YuyFI-B7zBcSIjb7xs9a-avss*/(Function1 var0, DialogInterface var1, int var2) {
      showConfirmation$lambda$2(var0, var1, var2);
   }

   private ViewUtils() {
   }

   // $FF: synthetic method
   public static PaintDrawable colorGradient$default(ViewUtils var0, int[] var1, float[] var2, GradientDrawable.Orientation var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = Orientation.TL_BR;
      }

      return var0.colorGradient(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void setAccessibilityDelegate$default(ViewUtils var0, View var1, KClass var2, String var3, Function2 var4, int var5, Object var6) {
      if ((var5 & 2) != 0) {
         var2 = null;
      }

      if ((var5 & 4) != 0) {
         var3 = null;
      }

      if ((var5 & 8) != 0) {
         var4 = null;
      }

      var0.setAccessibilityDelegate(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void showConfirmation$default(ViewUtils var0, Context var1, int var2, int var3, int var4, Integer var5, Integer var6, Function1 var7, int var8, Object var9) {
      if ((var8 & 16) != 0) {
         var5 = null;
      }

      if ((var8 & 32) != 0) {
         var6 = null;
      }

      var0.showConfirmation(var1, var2, var3, var4, var5, var6, var7);
   }

   private static final void showConfirmation$lambda$0(Function1 var0, DialogInterface var1, int var2) {
      var0.invoke(true);
   }

   private static final void showConfirmation$lambda$2(Function1 var0, DialogInterface var1, int var2) {
      var0.invoke(false);
   }

   public final PaintDrawable colorGradient(int[] var1, float[] var2, GradientDrawable.Orientation var3) {
      Intrinsics.checkNotNullParameter(var1, "colors");
      Intrinsics.checkNotNullParameter(var3, "orientation");
      ShapeDrawable.ShaderFactory var4 = new ShapeDrawable.ShaderFactory(var1, var2, var3) {
         final int[] $colors;
         final GradientDrawable.Orientation $orientation;
         final float[] $positions;

         // $FF: synthetic method
         public static float $r8$lambda$_rKO_iWYAUWWqkgpX0Wg3V__hrI/* $FF was: $r8$lambda$-rKO_iWYAUWWqkgpX0Wg3V-_hrI*/(GradientDrawable.Orientation var0, int var1) {
            return resize$lambda$6(var0, var1);
         }

         // $FF: synthetic method
         public static float $r8$lambda$O399EFwbt0NewRA09gRTKZaqbFk(GradientDrawable.Orientation var0, int var1) {
            return resize$lambda$2(var0, var1);
         }

         // $FF: synthetic method
         public static float $r8$lambda$uruRyTtEqMzdfO_REvEQsDiiGMo(GradientDrawable.Orientation var0, int var1) {
            return resize$lambda$4(var0, var1);
         }

         // $FF: synthetic method
         public static float $r8$lambda$wnCPhtTAtKDtsYqD0zHCE2nfhW8(GradientDrawable.Orientation var0, int var1) {
            return resize$lambda$0(var0, var1);
         }

         {
            this.$colors = var1;
            this.$positions = var2;
            this.$orientation = var3;
         }

         private static final float resize$lambda$0(GradientDrawable.Orientation var0, int var1) {
            switch (null.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()]) {
               case 1:
               case 2:
               case 3:
                  return 0.0F;
               case 4:
               case 5:
               case 6:
                  return (float)var1;
               case 7:
               case 8:
                  return (float)var1 / 2.0F;
               default:
                  throw new NoWhenBranchMatchedException();
            }
         }

         private static final float resize$lambda$1(Lazy var0) {
            return ((Number)var0.getValue()).floatValue();
         }

         private static final float resize$lambda$2(GradientDrawable.Orientation var0, int var1) {
            switch (null.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()]) {
               case 1:
               case 2:
               case 3:
                  return (float)var1;
               case 4:
               case 5:
               case 6:
                  return 0.0F;
               case 7:
               case 8:
                  return (float)var1 / 2.0F;
               default:
                  throw new NoWhenBranchMatchedException();
            }
         }

         private static final float resize$lambda$3(Lazy var0) {
            return ((Number)var0.getValue()).floatValue();
         }

         private static final float resize$lambda$4(GradientDrawable.Orientation var0, int var1) {
            switch (null.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()]) {
               case 1:
               case 4:
               case 7:
                  return 0.0F;
               case 2:
               case 5:
                  return (float)var1 / 2.0F;
               case 3:
               case 6:
               case 8:
                  return (float)var1;
               default:
                  throw new NoWhenBranchMatchedException();
            }
         }

         private static final float resize$lambda$5(Lazy var0) {
            return ((Number)var0.getValue()).floatValue();
         }

         private static final float resize$lambda$6(GradientDrawable.Orientation var0, int var1) {
            switch (null.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()]) {
               case 1:
               case 4:
               case 7:
                  return (float)var1;
               case 2:
               case 5:
                  return (float)var1 / 2.0F;
               case 3:
               case 6:
               case 8:
                  return 0.0F;
               default:
                  throw new NoWhenBranchMatchedException();
            }
         }

         private static final float resize$lambda$7(Lazy var0) {
            return ((Number)var0.getValue()).floatValue();
         }

         public Shader resize(int var1, int var2) {
            Lazy var5 = LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda0(this.$orientation, var1));
            Lazy var4 = LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda1(this.$orientation, var1));
            Lazy var3 = LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda2(this.$orientation, var2));
            Lazy var6 = LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda3(this.$orientation, var2));
            return (Shader)(new LinearGradient(resize$lambda$1(var5), resize$lambda$5(var3), resize$lambda$3(var4), resize$lambda$7(var6), this.$colors, this.$positions, TileMode.REPEAT));
         }

         // $FF: synthetic class
         @Metadata(
            k = 3,
            mv = {2, 2, 0},
            xi = 48
         )
         public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
               int[] var0 = new int[Orientation.values().length];

               try {
                  var0[Orientation.TL_BR.ordinal()] = 1;
               } catch (NoSuchFieldError var9) {
               }

               try {
                  var0[Orientation.LEFT_RIGHT.ordinal()] = 2;
               } catch (NoSuchFieldError var8) {
               }

               try {
                  var0[Orientation.BL_TR.ordinal()] = 3;
               } catch (NoSuchFieldError var7) {
               }

               try {
                  var0[Orientation.TR_BL.ordinal()] = 4;
               } catch (NoSuchFieldError var6) {
               }

               try {
                  var0[Orientation.RIGHT_LEFT.ordinal()] = 5;
               } catch (NoSuchFieldError var5) {
               }

               try {
                  var0[Orientation.BR_TL.ordinal()] = 6;
               } catch (NoSuchFieldError var4) {
               }

               try {
                  var0[Orientation.TOP_BOTTOM.ordinal()] = 7;
               } catch (NoSuchFieldError var3) {
               }

               try {
                  var0[Orientation.BOTTOM_TOP.ordinal()] = 8;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$0 = var0;
            }
         }
      };
      PaintDrawable var5 = new PaintDrawable();
      var5.setShape((Shape)(new RectShape()));
      var5.setShaderFactory(var4);
      return var5;
   }

   public final AccessibilityDelegateCompat createTimePickerShowAccessibilityDelegate(int var1) {
      return new AccessibilityDelegateCompat(var1) {
         final int $contentDescriptionPatternResourceId;

         {
            this.$contentDescriptionPatternResourceId = var1;
         }

         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            Resources var4 = var1.getResources();
            String var3 = var4.getString(R.string.show_time_picker_action_description);
            Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
            var2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, (CharSequence)var3));
            var2.setRoleDescription((CharSequence)var4.getString(R.string.button_role));
            var2.setContentDescription((CharSequence)var4.getString(this.$contentDescriptionPatternResourceId, new Object[]{((TextView)var1).getText()}));
         }
      };
   }

   public final int genRequestCode() {
      synchronized(this){}

      int var1;
      try {
         var1 = requestCodeCounter++;
      } catch (Throwable var8) {
         Throwable var10000 = var8;
         boolean var10001 = false;

         while(true) {
            Throwable var2 = var10000;

            try {
               throw var2;
            } catch (Throwable var7) {
               var10000 = var7;
               var10001 = false;
               continue;
            }
         }
      }

      return var1;
   }

   public final void setAccessibilityDelegate(View var1, KClass var2, String var3, Function2 var4) {
      Intrinsics.checkNotNullParameter(var1, "view");
      ViewCompat.setAccessibilityDelegate(var1, new AccessibilityDelegateCompat(var2, var3, var4) {
         final Function2 $initializer;
         final KClass $kClass;
         final String $tooltip;

         {
            this.$kClass = var1;
            this.$tooltip = var2;
            this.$initializer = var3;
         }

         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            KClass var3 = this.$kClass;
            if (var3 != null) {
               var2.setClassName((CharSequence)JvmClassMappingKt.getJavaClass(var3).getName());
            }

            String var4 = this.$tooltip;
            if (var4 != null) {
               var2.setTooltipText((CharSequence)var4);
            }

            Function2 var5 = this.$initializer;
            if (var5 != null) {
               var5.invoke(var1, var2);
            }

         }
      });
   }

   public final boolean shouldShowFilterDoorPopup(HasSafetySwitch var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return var1.getConnectivityStatus() == ConnectivityStatus.ONLINE && !var1.isSafetySwitchOn();
   }

   public final void showConfirmation(Context var1, int var2, int var3, int var4, Integer var5, Integer var6, Function1 var7) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var7, "result");
      String var11;
      if (var5 == null) {
         var11 = null;
      } else {
         var11 = var1.getString(var5);
      }

      String var10 = var1.getString(var2);
      Intrinsics.checkNotNullExpressionValue(var10, "getString(...)");
      String var9 = var1.getString(var3);
      Intrinsics.checkNotNullExpressionValue(var9, "getString(...)");
      String var8 = var1.getString(var4);
      Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
      this.showConfirmation(var1, var10, var9, var8, var11, var6, var7);
   }

   public final void showConfirmation(Context var1, String var2, String var3, String var4, String var5, Integer var6, Function1 var7) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "titleText");
      Intrinsics.checkNotNullParameter(var3, "bodyText");
      Intrinsics.checkNotNullParameter(var4, "positiveText");
      Intrinsics.checkNotNullParameter(var7, "result");
      AlertDialog.Builder var10 = new AlertDialog.Builder(var1, 16974394);
      boolean var9 = true;
      AlertDialog.Builder var13 = var10.setCancelable(true).setPositiveButton((CharSequence)var4, new ViewUtils$$ExternalSyntheticLambda0(var7));
      ConfirmationDialogBinding var14 = ConfirmationDialogBinding.inflate(LayoutInflater.from(var1));
      Intrinsics.checkNotNullExpressionValue(var14, "inflate(...)");
      if (var6 != null) {
         int var8 = ((Number)var6).intValue();
         var14.imageTop.setImageResource(var8);
      }

      ImageView var11 = var14.imageTop;
      Intrinsics.checkNotNullExpressionValue(var11, "imageTop");
      View var15 = (View)var11;
      if (var6 == null) {
         var9 = false;
      }

      io.flatcircle.viewhelper.ViewExtensionsKt.show(var15, var9);
      var14.titleTextView.setText((CharSequence)var2);
      var14.messageTextView.setText((CharSequence)var3);
      var13.setView((View)var14.getRoot());
      AlertDialog var12;
      if (var5 != null) {
         var12 = var13.setNegativeButton((CharSequence)var5, new ViewUtils$$ExternalSyntheticLambda1(var7)).show();
      } else {
         var12 = var13.show();
      }

      var12.getButton(-2).setTextColor(ContextCompat.getColor(var1, R.color.colorPrimaryText));
      var12.getButton(-1).setTextColor(ContextCompat.getColor(var1, R.color.colorPrimaryText));
   }

   public final void showError(Activity var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      this.showSnackbar(var1, var2, ViewUtils.MessageType.ERROR.INSTANCE);
   }

   public final void showError(Activity var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      Intrinsics.checkNotNullParameter(var2, "message");
      this.showSnackbar(var1, var2, ViewUtils.MessageType.ERROR.INSTANCE);
   }

   public final void showInfo(Activity var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      this.showSnackbar(var1, var2, ViewUtils.MessageType.INFO.INSTANCE);
   }

   public final void showInfo(Activity var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      Intrinsics.checkNotNullParameter(var2, "message");
      this.showSnackbar(var1, var2, ViewUtils.MessageType.INFO.INSTANCE);
   }

   public final void showSnackbar(Activity var1, int var2, MessageType var3) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      Intrinsics.checkNotNullParameter(var3, "type");
      String var4 = var1.getString(var2);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      this.showSnackbar(var1, var4, var3);
   }

   public final void showSnackbar(Activity var1, String var2, MessageType var3) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      Intrinsics.checkNotNullParameter(var2, "message");
      Intrinsics.checkNotNullParameter(var3, "type");
      Snacky.Builder var4 = Snacky.builder().setActivity(var1).setText((CharSequence)var2).setDuration(3000);
      if (Intrinsics.areEqual(var3, ViewUtils.MessageType.SUCCESS.INSTANCE)) {
         var4.success().show();
      } else if (Intrinsics.areEqual(var3, ViewUtils.MessageType.WARNING.INSTANCE)) {
         var4.warning().show();
      } else if (Intrinsics.areEqual(var3, ViewUtils.MessageType.ERROR.INSTANCE)) {
         var4.error().show();
      } else if (Intrinsics.areEqual(var3, ViewUtils.MessageType.INFO.INSTANCE)) {
         var4.info().show();
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }

   public final void showSnackbar(View var1, int var2, MessageType var3) {
      Intrinsics.checkNotNullParameter(var1, "view");
      Intrinsics.checkNotNullParameter(var3, "type");
      String var4 = var1.getContext().getString(var2);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      this.showSnackbar(var1, var4, var3);
   }

   public final void showSnackbar(View var1, String var2, MessageType var3) {
      Intrinsics.checkNotNullParameter(var1, "view");
      Intrinsics.checkNotNullParameter(var2, "message");
      Intrinsics.checkNotNullParameter(var3, "type");
      Snacky.Builder var4 = Snacky.builder().setView(var1).setText((CharSequence)var2).setDuration(3000);
      if (Intrinsics.areEqual(var3, ViewUtils.MessageType.SUCCESS.INSTANCE)) {
         var4.success().show();
      } else if (Intrinsics.areEqual(var3, ViewUtils.MessageType.WARNING.INSTANCE)) {
         var4.warning().show();
      } else if (Intrinsics.areEqual(var3, ViewUtils.MessageType.ERROR.INSTANCE)) {
         var4.error().show();
      } else if (Intrinsics.areEqual(var3, ViewUtils.MessageType.INFO.INSTANCE)) {
         var4.info().show();
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"},
      d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType;", "", "<init>", "()V", "SUCCESS", "WARNING", "INFO", "ERROR", "Lcom/blueair/viewcore/ViewUtils$MessageType$ERROR;", "Lcom/blueair/viewcore/ViewUtils$MessageType$INFO;", "Lcom/blueair/viewcore/ViewUtils$MessageType$SUCCESS;", "Lcom/blueair/viewcore/ViewUtils$MessageType$WARNING;", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class MessageType {
      private MessageType() {
      }

      // $FF: synthetic method
      public MessageType(DefaultConstructorMarker var1) {
         this();
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$ERROR;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class ERROR extends MessageType {
         public static final ERROR INSTANCE = new ERROR();

         private ERROR() {
            super((DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$INFO;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class INFO extends MessageType {
         public static final INFO INSTANCE = new INFO();

         private INFO() {
            super((DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$SUCCESS;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SUCCESS extends MessageType {
         public static final SUCCESS INSTANCE = new SUCCESS();

         private SUCCESS() {
            super((DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$WARNING;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WARNING extends MessageType {
         public static final WARNING INSTANCE = new WARNING();

         private WARNING() {
            super((DefaultConstructorMarker)null);
         }
      }
   }
}
