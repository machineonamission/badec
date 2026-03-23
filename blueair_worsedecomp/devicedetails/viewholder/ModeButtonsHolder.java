package com.blueair.devicedetails.viewholder;

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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u0002002\u0006\u00108\u001a\u0002092\b\b\u0002\u00103\u001a\u000204H\u0016J\u001a\u0010:\u001a\u0002002\u0006\u0010;\u001a\u0002042\b\b\u0002\u00103\u001a\u000204H\u0016J\u001a\u0010<\u001a\u0002002\u0006\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u000204H\u0016J\u0010\u0010?\u001a\u0002002\u0006\u0010@\u001a\u000204H\u0002J\u001a\u0010A\u001a\u0002002\u0006\u0010B\u001a\u0002042\b\b\u0002\u00103\u001a\u000204H\u0016J\u001a\u0010C\u001a\u0002002\u0006\u0010D\u001a\u0002042\b\b\u0002\u00103\u001a\u000204H\u0016J4\u0010E\u001a\u0002002\b\u0010F\u001a\u0004\u0018\u00010\n2\b\u0010G\u001a\u0004\u0018\u00010\u000e2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002042\u0006\u00103\u001a\u000204H\u0016R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\fR\u0014\u0010!\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010R\u0014\u0010#\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\bR\u0014\u0010%\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\fR\u0014\u0010'\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0014\u0010)\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\bR\u0014\u0010+\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\fR\u0014\u0010-\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0010¨\u0006K"}, d2 = {"Lcom/blueair/devicedetails/viewholder/ModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "autoModeRoot", "getAutoModeRoot", "()Landroid/view/View;", "autoModeTitleView", "Landroid/widget/TextView;", "getAutoModeTitleView", "()Landroid/widget/TextView;", "autoModeImageView", "Landroid/widget/ImageView;", "getAutoModeImageView", "()Landroid/widget/ImageView;", "nightModeRoot", "getNightModeRoot", "nightModeTitleView", "getNightModeTitleView", "nightModeImageView", "getNightModeImageView", "standByModeRoot", "getStandByModeRoot", "standByModeTitleView", "getStandByModeTitleView", "standByModeBackground", "getStandByModeBackground", "manualModeRoot", "getManualModeRoot", "manualModeTitleView", "getManualModeTitleView", "manualModeImageView", "getManualModeImageView", "childLockRoot", "getChildLockRoot", "childLockTitleView", "getChildLockTitleView", "childLockImageView", "getChildLockImageView", "disinfectionRoot", "getDisinfectionRoot", "disinfectionTitleView", "getDisinfectionTitleView", "disinfectionImageView", "getDisinfectionImageView", "updateAutoModeBtnViews", "", "autoMode", "Lcom/blueair/core/model/UiAutoMode;", "isStandMode", "", "device", "Lcom/blueair/core/model/Device;", "updateNightModeBtnViews", "uiG4NightMode", "Lcom/blueair/core/model/UiG4NightMode;", "updateManualModeBtnViews", "isManualMode", "updateStandbyModeBtnViews", "isStandByMode", "isAddSchedule", "setClickEnable", "isClick", "updateChildLockBtnViews", "isChildLockOn", "updateDisinfectionBtnViews", "isDisinfectionOn", "updateModeBtnViews", "titleView", "imageView", "modeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "isModeOn", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ModeButtonsHolder.kt */
public abstract class ModeButtonsHolder extends DeviceAttributeHolder {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModeButtonsHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public static /* synthetic */ void updateAutoModeBtnViews$default(ModeButtonsHolder modeButtonsHolder, UiAutoMode uiAutoMode, boolean z, Device device, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                device = null;
            }
            modeButtonsHolder.updateAutoModeBtnViews(uiAutoMode, z, device);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAutoModeBtnViews");
    }

    public void updateAutoModeBtnViews(UiAutoMode uiAutoMode, boolean z, Device device) {
        Intrinsics.checkNotNullParameter(uiAutoMode, "autoMode");
        updateModeBtnViews(getAutoModeTitleView(), getAutoModeImageView(), ModeIcon.AUTO.proofread(device), Intrinsics.areEqual((Object) uiAutoMode, (Object) UiAutoMode.On.INSTANCE), z);
        View autoModeRoot = getAutoModeRoot();
        if (autoModeRoot != null) {
            autoModeRoot.setSelected(Intrinsics.areEqual((Object) uiAutoMode, (Object) UiAutoMode.On.INSTANCE));
        }
    }

    public static /* synthetic */ void updateNightModeBtnViews$default(ModeButtonsHolder modeButtonsHolder, UiG4NightMode uiG4NightMode, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            modeButtonsHolder.updateNightModeBtnViews(uiG4NightMode, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateNightModeBtnViews");
    }

    public void updateNightModeBtnViews(UiG4NightMode uiG4NightMode, boolean z) {
        Intrinsics.checkNotNullParameter(uiG4NightMode, "uiG4NightMode");
        updateModeBtnViews(getNightModeTitleView(), getNightModeImageView(), ModeIcon.NIGHT, Intrinsics.areEqual((Object) uiG4NightMode, (Object) UiG4NightMode.On.INSTANCE), z);
        View nightModeRoot = getNightModeRoot();
        if (nightModeRoot != null) {
            nightModeRoot.setSelected(Intrinsics.areEqual((Object) uiG4NightMode, (Object) UiG4NightMode.On.INSTANCE));
        }
    }

    public static /* synthetic */ void updateManualModeBtnViews$default(ModeButtonsHolder modeButtonsHolder, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            modeButtonsHolder.updateManualModeBtnViews(z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateManualModeBtnViews");
    }

    public void updateManualModeBtnViews(boolean z, boolean z2) {
        boolean z3 = z;
        updateModeBtnViews(getManualModeTitleView(), getManualModeImageView(), ModeIcon.FAN_SPEED, z3, z2);
        View manualModeRoot = getManualModeRoot();
        if (manualModeRoot != null) {
            manualModeRoot.setSelected(z3);
        }
    }

    public static /* synthetic */ void updateStandbyModeBtnViews$default(ModeButtonsHolder modeButtonsHolder, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            modeButtonsHolder.updateStandbyModeBtnViews(z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStandbyModeBtnViews");
    }

    public void updateStandbyModeBtnViews(boolean z, boolean z2) {
        boolean z3 = z;
        updateModeBtnViews(getStandByModeTitleView(), getStandByModeBackground(), ModeIcon.STANDBY, z3, false);
        if (z3) {
            if (!z2) {
                setClickEnable(false);
            }
            if (this instanceof DeviceModeButtonsHolder) {
                ((DeviceModeButtonsHolder) this).getStandByModeTitleView().setText(this.itemView.getContext().getText(R.string.turn_on));
            }
        } else {
            if (!z2) {
                setClickEnable(true);
            }
            if (this instanceof DeviceModeButtonsHolder) {
                ((DeviceModeButtonsHolder) this).getStandByModeTitleView().setText(this.itemView.getContext().getText(R.string.on));
            }
        }
        View standByModeRoot = getStandByModeRoot();
        if (standByModeRoot != null) {
            standByModeRoot.setSelected(true ^ z3);
        }
    }

    private final void setClickEnable(boolean z) {
        View manualModeRoot = getManualModeRoot();
        if (manualModeRoot != null) {
            manualModeRoot.setEnabled(z);
        }
        View autoModeRoot = getAutoModeRoot();
        if (autoModeRoot != null) {
            autoModeRoot.setEnabled(z);
        }
        View nightModeRoot = getNightModeRoot();
        if (nightModeRoot != null) {
            nightModeRoot.setEnabled(z);
        }
        View childLockRoot = getChildLockRoot();
        if (childLockRoot != null) {
            childLockRoot.setEnabled(z);
        }
        View disinfectionRoot = getDisinfectionRoot();
        if (disinfectionRoot != null) {
            disinfectionRoot.setEnabled(z);
        }
    }

    public static /* synthetic */ void updateChildLockBtnViews$default(ModeButtonsHolder modeButtonsHolder, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            modeButtonsHolder.updateChildLockBtnViews(z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateChildLockBtnViews");
    }

    public void updateChildLockBtnViews(boolean z, boolean z2) {
        boolean z3 = z;
        updateModeBtnViews(getChildLockTitleView(), getChildLockImageView(), ModeIcon.CHILD_LOCK, z3, z2);
        View childLockRoot = getChildLockRoot();
        if (childLockRoot != null) {
            childLockRoot.setSelected(z3);
        }
    }

    public static /* synthetic */ void updateDisinfectionBtnViews$default(ModeButtonsHolder modeButtonsHolder, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            modeButtonsHolder.updateDisinfectionBtnViews(z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDisinfectionBtnViews");
    }

    public void updateDisinfectionBtnViews(boolean z, boolean z2) {
        boolean z3 = z;
        updateModeBtnViews(getDisinfectionTitleView(), getDisinfectionImageView(), ModeIcon.DISINFECTION, z3, z2);
        View disinfectionRoot = getDisinfectionRoot();
        if (disinfectionRoot != null) {
            disinfectionRoot.setSelected(z3);
        }
    }

    public void updateModeBtnViews(TextView textView, ImageView imageView, ModeIcon modeIcon, boolean z, boolean z2) {
        int i;
        Intrinsics.checkNotNullParameter(modeIcon, "modeIcon");
        if (z2) {
            i = z ? modeIcon.getOnIconDisabled() : modeIcon.getOffIconDisabled();
        } else {
            i = z ? modeIcon.getOnIcon() : modeIcon.getOffIcon();
        }
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        if (modeIcon == ModeIcon.STANDBY) {
            z = !z;
        }
        if (textView != null) {
            textView.setTypeface(ResourcesCompat.getFont(this.itemView.getContext(), z ? R.font.apercu_bold : R.font.apercu_regular));
        }
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), z2 ? R.color.light_gray : R.color.colorPrimary));
        }
    }
}
