package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.UiAutoMode;
import com.blueair.core.model.UiG4NightMode;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.ModeIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u0002002\u0006\u00108\u001a\u0002092\b\b\u0002\u00103\u001a\u000204H\u0016J\u001a\u0010:\u001a\u0002002\u0006\u0010;\u001a\u0002042\b\b\u0002\u00103\u001a\u000204H\u0016J\u001a\u0010<\u001a\u0002002\u0006\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u000204H\u0016J\u0010\u0010?\u001a\u0002002\u0006\u0010@\u001a\u000204H\u0002J\u001a\u0010A\u001a\u0002002\u0006\u0010B\u001a\u0002042\b\b\u0002\u00103\u001a\u000204H\u0016J\u001a\u0010C\u001a\u0002002\u0006\u0010D\u001a\u0002042\b\b\u0002\u00103\u001a\u000204H\u0016J4\u0010E\u001a\u0002002\b\u0010F\u001a\u0004\u0018\u00010\n2\b\u0010G\u001a\u0004\u0018\u00010\u000e2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002042\u0006\u00103\u001a\u000204H\u0016R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\fR\u0014\u0010!\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010R\u0014\u0010#\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\bR\u0014\u0010%\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\fR\u0014\u0010'\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0014\u0010)\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\bR\u0014\u0010+\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\fR\u0014\u0010-\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0010¨\u0006K"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/ModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "autoModeRoot", "getAutoModeRoot", "()Landroid/view/View;", "autoModeTitleView", "Landroid/widget/TextView;", "getAutoModeTitleView", "()Landroid/widget/TextView;", "autoModeImageView", "Landroid/widget/ImageView;", "getAutoModeImageView", "()Landroid/widget/ImageView;", "nightModeRoot", "getNightModeRoot", "nightModeTitleView", "getNightModeTitleView", "nightModeImageView", "getNightModeImageView", "standByModeRoot", "getStandByModeRoot", "standByModeTitleView", "getStandByModeTitleView", "standByModeBackground", "getStandByModeBackground", "manualModeRoot", "getManualModeRoot", "manualModeTitleView", "getManualModeTitleView", "manualModeImageView", "getManualModeImageView", "childLockRoot", "getChildLockRoot", "childLockTitleView", "getChildLockTitleView", "childLockImageView", "getChildLockImageView", "disinfectionRoot", "getDisinfectionRoot", "disinfectionTitleView", "getDisinfectionTitleView", "disinfectionImageView", "getDisinfectionImageView", "updateAutoModeBtnViews", "", "autoMode", "Lcom/blueair/core/model/UiAutoMode;", "isStandMode", "", "device", "Lcom/blueair/core/model/Device;", "updateNightModeBtnViews", "uiG4NightMode", "Lcom/blueair/core/model/UiG4NightMode;", "updateManualModeBtnViews", "isManualMode", "updateStandbyModeBtnViews", "isStandByMode", "isAddSchedule", "setClickEnable", "isClick", "updateChildLockBtnViews", "isChildLockOn", "updateDisinfectionBtnViews", "isDisinfectionOn", "updateModeBtnViews", "titleView", "imageView", "modeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "isModeOn", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class ModeButtonsHolder extends DeviceAttributeHolder {
   public ModeButtonsHolder(View var1) {
      Intrinsics.checkNotNullParameter(var1, "itemView");
      super(var1);
   }

   private final void setClickEnable(boolean var1) {
      View var2 = this.getManualModeRoot();
      if (var2 != null) {
         var2.setEnabled(var1);
      }

      var2 = this.getAutoModeRoot();
      if (var2 != null) {
         var2.setEnabled(var1);
      }

      var2 = this.getNightModeRoot();
      if (var2 != null) {
         var2.setEnabled(var1);
      }

      var2 = this.getChildLockRoot();
      if (var2 != null) {
         var2.setEnabled(var1);
      }

      var2 = this.getDisinfectionRoot();
      if (var2 != null) {
         var2.setEnabled(var1);
      }

   }

   // $FF: synthetic method
   public static void updateAutoModeBtnViews$default(ModeButtonsHolder var0, UiAutoMode var1, boolean var2, Device var3, int var4, Object var5) {
      if (var5 == null) {
         if ((var4 & 2) != 0) {
            var2 = false;
         }

         if ((var4 & 4) != 0) {
            var3 = null;
         }

         var0.updateAutoModeBtnViews(var1, var2, var3);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAutoModeBtnViews");
      }
   }

   // $FF: synthetic method
   public static void updateChildLockBtnViews$default(ModeButtonsHolder var0, boolean var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         var0.updateChildLockBtnViews(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateChildLockBtnViews");
      }
   }

   // $FF: synthetic method
   public static void updateDisinfectionBtnViews$default(ModeButtonsHolder var0, boolean var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         var0.updateDisinfectionBtnViews(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDisinfectionBtnViews");
      }
   }

   // $FF: synthetic method
   public static void updateManualModeBtnViews$default(ModeButtonsHolder var0, boolean var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         var0.updateManualModeBtnViews(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateManualModeBtnViews");
      }
   }

   // $FF: synthetic method
   public static void updateNightModeBtnViews$default(ModeButtonsHolder var0, UiG4NightMode var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         var0.updateNightModeBtnViews(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateNightModeBtnViews");
      }
   }

   // $FF: synthetic method
   public static void updateStandbyModeBtnViews$default(ModeButtonsHolder var0, boolean var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         var0.updateStandbyModeBtnViews(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStandbyModeBtnViews");
      }
   }

   public abstract ImageView getAutoModeImageView();

   public abstract View getAutoModeRoot();

   public abstract TextView getAutoModeTitleView();

   public abstract ImageView getChildLockImageView();

   public abstract View getChildLockRoot();

   public abstract TextView getChildLockTitleView();

   public abstract ImageView getDisinfectionImageView();

   public abstract View getDisinfectionRoot();

   public abstract TextView getDisinfectionTitleView();

   public abstract ImageView getManualModeImageView();

   public abstract View getManualModeRoot();

   public abstract TextView getManualModeTitleView();

   public abstract ImageView getNightModeImageView();

   public abstract View getNightModeRoot();

   public abstract TextView getNightModeTitleView();

   public abstract ImageView getStandByModeBackground();

   public abstract View getStandByModeRoot();

   public abstract TextView getStandByModeTitleView();

   public void updateAutoModeBtnViews(UiAutoMode var1, boolean var2, Device var3) {
      Intrinsics.checkNotNullParameter(var1, "autoMode");
      this.updateModeBtnViews(this.getAutoModeTitleView(), this.getAutoModeImageView(), ModeIcon.AUTO.proofread(var3), Intrinsics.areEqual(var1, UiAutoMode.On.INSTANCE), var2);
      View var4 = this.getAutoModeRoot();
      if (var4 != null) {
         var4.setSelected(Intrinsics.areEqual(var1, UiAutoMode.On.INSTANCE));
      }

   }

   public void updateChildLockBtnViews(boolean var1, boolean var2) {
      this.updateModeBtnViews(this.getChildLockTitleView(), this.getChildLockImageView(), ModeIcon.CHILD_LOCK, var1, var2);
      View var3 = this.getChildLockRoot();
      if (var3 != null) {
         var3.setSelected(var1);
      }

   }

   public void updateDisinfectionBtnViews(boolean var1, boolean var2) {
      this.updateModeBtnViews(this.getDisinfectionTitleView(), this.getDisinfectionImageView(), ModeIcon.DISINFECTION, var1, var2);
      View var3 = this.getDisinfectionRoot();
      if (var3 != null) {
         var3.setSelected(var1);
      }

   }

   public void updateManualModeBtnViews(boolean var1, boolean var2) {
      this.updateModeBtnViews(this.getManualModeTitleView(), this.getManualModeImageView(), ModeIcon.FAN_SPEED, var1, var2);
      View var3 = this.getManualModeRoot();
      if (var3 != null) {
         var3.setSelected(var1);
      }

   }

   public void updateModeBtnViews(TextView var1, ImageView var2, ModeIcon var3, boolean var4, boolean var5) {
      Intrinsics.checkNotNullParameter(var3, "modeIcon");
      int var6;
      if (var5) {
         if (var4) {
            var6 = var3.getOnIconDisabled();
         } else {
            var6 = var3.getOffIconDisabled();
         }
      } else if (var4) {
         var6 = var3.getOnIcon();
      } else {
         var6 = var3.getOffIcon();
      }

      if (var2 != null) {
         var2.setImageResource(var6);
      }

      boolean var7 = var4;
      if (var3 == ModeIcon.STANDBY) {
         if (!var4) {
            var7 = true;
         } else {
            var7 = false;
         }
      }

      if (var1 != null) {
         Context var8 = this.itemView.getContext();
         if (var7) {
            var6 = R.font.apercu_bold;
         } else {
            var6 = R.font.apercu_regular;
         }

         var1.setTypeface(ResourcesCompat.getFont(var8, var6));
      }

      if (var1 != null) {
         Context var9 = this.itemView.getContext();
         if (var5) {
            var6 = R.color.light_gray;
         } else {
            var6 = R.color.colorPrimary;
         }

         var1.setTextColor(ContextCompat.getColor(var9, var6));
      }

   }

   public void updateNightModeBtnViews(UiG4NightMode var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "uiG4NightMode");
      this.updateModeBtnViews(this.getNightModeTitleView(), this.getNightModeImageView(), ModeIcon.NIGHT, Intrinsics.areEqual(var1, UiG4NightMode.On.INSTANCE), var2);
      View var3 = this.getNightModeRoot();
      if (var3 != null) {
         var3.setSelected(Intrinsics.areEqual(var1, UiG4NightMode.On.INSTANCE));
      }

   }

   public void updateStandbyModeBtnViews(boolean var1, boolean var2) {
      this.updateModeBtnViews(this.getStandByModeTitleView(), this.getStandByModeBackground(), ModeIcon.STANDBY, var1, false);
      if (var1) {
         if (!var2) {
            this.setClickEnable(false);
         }

         if (this instanceof DeviceModeButtonsHolder) {
            ((DeviceModeButtonsHolder)this).getStandByModeTitleView().setText(this.itemView.getContext().getText(R.string.turn_on));
         }
      } else {
         if (!var2) {
            this.setClickEnable(true);
         }

         if (this instanceof DeviceModeButtonsHolder) {
            ((DeviceModeButtonsHolder)this).getStandByModeTitleView().setText(this.itemView.getContext().getText(R.string.on));
         }
      }

      View var3 = this.getStandByModeRoot();
      if (var3 != null) {
         var3.setSelected(true ^ var1);
      }

   }
}
