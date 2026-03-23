package com.blueair.adddevice.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.DialogUtils;
import io.flatcircle.connectivityhelper.NetUtil;
import io.reactivex.Single;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0012J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$0#R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006'"}, d2 = {"Lcom/blueair/adddevice/utils/AddDeviceUtils;", "", "<init>", "()V", "LOG_TAG", "", "getLOG_TAG", "()Ljava/lang/String;", "LOG_TAG$delegate", "Lkotlin/Lazy;", "screenDoesNotAllowBack", "", "screen", "Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "screenAllowsBack", "screenHasNoToolbar", "shouldChangeScreen", "oldState", "Lcom/blueair/adddevice/model/AddDeviceState;", "nuState", "getScreen", "state", "validateNet", "Lio/reactivex/Single;", "Lcom/blueair/adddevice/utils/AddDeviceUtils$NetValidation;", "context", "Landroid/content/Context;", "deviceModelType", "", "showEnableLocationBluetooth", "fragment", "Landroidx/fragment/app/Fragment;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "AddDeviceScreen", "NetValidation", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceUtils.kt */
public final class AddDeviceUtils {
    public static final AddDeviceUtils INSTANCE = new AddDeviceUtils();
    private static final Lazy LOG_TAG$delegate = LazyKt.lazy(new AddDeviceUtils$$ExternalSyntheticLambda2());

    private AddDeviceUtils() {
    }

    private final String getLOG_TAG() {
        Object value = LOG_TAG$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    /* access modifiers changed from: private */
    public static final String LOG_TAG_delegate$lambda$0() {
        return "AddDeviceUtils";
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SELECT_DEVICE", "SETUP_TEXT", "AUTO_STEP_1", "AUTO_STEP_2", "CONFIG_NETWORK", "AUTO_PROGRESS", "MANUAL_STEP_1", "MANUAL_STEP_2", "MANUAL_PROGRESS", "MANUAL_VALIDATE", "NAME_DEVICE", "AUTO_FAIL_STEP_1", "AUTO_FAIL_STEP_2", "MANUAL_FAIL", "RESET_DEVICE", "SUCCESS", "ICP_ADD_DEVICE", "ICP_SETUP_DEVICE", "ICP_PAIR_DEVICE", "ICP_SAVE_DEVICE", "ICP_NAME_DEVICE", "MIGRATION_OTA", "TROUBLESHOOT", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceUtils.kt */
    public enum AddDeviceScreen {
        NONE,
        SELECT_DEVICE,
        SETUP_TEXT,
        AUTO_STEP_1,
        AUTO_STEP_2,
        CONFIG_NETWORK,
        AUTO_PROGRESS,
        MANUAL_STEP_1,
        MANUAL_STEP_2,
        MANUAL_PROGRESS,
        MANUAL_VALIDATE,
        NAME_DEVICE,
        AUTO_FAIL_STEP_1,
        AUTO_FAIL_STEP_2,
        MANUAL_FAIL,
        RESET_DEVICE,
        SUCCESS,
        ICP_ADD_DEVICE,
        ICP_SETUP_DEVICE,
        ICP_PAIR_DEVICE,
        ICP_SAVE_DEVICE,
        ICP_NAME_DEVICE,
        MIGRATION_OTA,
        TROUBLESHOOT;

        public static EnumEntries<AddDeviceScreen> getEntries() {
            return $ENTRIES;
        }

        static {
            AddDeviceScreen[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final boolean screenDoesNotAllowBack(AddDeviceScreen addDeviceScreen) {
        return addDeviceScreen == null || addDeviceScreen == AddDeviceScreen.NAME_DEVICE || addDeviceScreen == AddDeviceScreen.SETUP_TEXT || addDeviceScreen == AddDeviceScreen.MANUAL_PROGRESS || addDeviceScreen == AddDeviceScreen.MANUAL_VALIDATE || addDeviceScreen == AddDeviceScreen.MANUAL_FAIL || addDeviceScreen == AddDeviceScreen.AUTO_PROGRESS || addDeviceScreen == AddDeviceScreen.AUTO_FAIL_STEP_1 || addDeviceScreen == AddDeviceScreen.SUCCESS || addDeviceScreen == AddDeviceScreen.SELECT_DEVICE || addDeviceScreen == AddDeviceScreen.MIGRATION_OTA;
    }

    public final boolean screenAllowsBack(AddDeviceScreen addDeviceScreen) {
        return !screenDoesNotAllowBack(addDeviceScreen);
    }

    public final boolean screenHasNoToolbar(AddDeviceScreen addDeviceScreen) {
        return addDeviceScreen == null || addDeviceScreen == AddDeviceScreen.SUCCESS;
    }

    public final boolean shouldChangeScreen(AddDeviceState addDeviceState, AddDeviceState addDeviceState2) {
        Intrinsics.checkNotNullParameter(addDeviceState, "oldState");
        Intrinsics.checkNotNullParameter(addDeviceState2, "nuState");
        if (addDeviceState2.getDeviceType() == 0) {
            return true;
        }
        if (addDeviceState.getDeviceType() == 0 && addDeviceState.getDeviceType() != addDeviceState2.getDeviceType()) {
            return true;
        }
        if ((!addDeviceState.getInitialTextSeen() && addDeviceState2.getInitialTextSeen()) || addDeviceState2.getAutoStepsCompleted() > addDeviceState.getAutoStepsCompleted() || addDeviceState2.getManualStepsCompleted() > addDeviceState.getManualStepsCompleted()) {
            return true;
        }
        if (!addDeviceState.getNetworkInfoSet() && addDeviceState2.getNetworkInfoSet()) {
            return true;
        }
        if ((!addDeviceState.getAutoFailed() && addDeviceState2.getAutoFailed()) || addDeviceState.getAutoFailStepsCompleted() != addDeviceState2.getAutoFailStepsCompleted()) {
            return true;
        }
        if (addDeviceState.getAutoMode() && !addDeviceState2.getAutoMode()) {
            return true;
        }
        if (!addDeviceState.getManualFailed() && addDeviceState2.getManualFailed()) {
            return true;
        }
        if (!addDeviceState.getManualValidated() && addDeviceState2.getManualValidated()) {
            return true;
        }
        if (!addDeviceState.isReadyForNaming() && addDeviceState2.isReadyForNaming()) {
            return true;
        }
        if (addDeviceState.getResetDevice() || !addDeviceState2.getResetDevice()) {
            return ((addDeviceState.getSuccessScreen() || !addDeviceState2.getSuccessScreen()) && addDeviceState2.getIcpStepsCompleted() == addDeviceState.getIcpStepsCompleted() && addDeviceState2.getMigrationOtaCheckCompleted() == addDeviceState.getMigrationOtaCheckCompleted() && addDeviceState2.getTroubleshoot() == addDeviceState.getTroubleshoot()) ? false : true;
        }
        return true;
    }

    public final AddDeviceScreen getScreen(AddDeviceState addDeviceState) {
        Intrinsics.checkNotNullParameter(addDeviceState, "state");
        if (addDeviceState.getTroubleshoot()) {
            return AddDeviceScreen.TROUBLESHOOT;
        }
        if (addDeviceState.getDeviceType() == 40) {
            if (!addDeviceState.getAutoFailed()) {
                if (addDeviceState.isSuccess() && addDeviceState.getSuccessScreen()) {
                    return AddDeviceScreen.SUCCESS;
                }
                if (addDeviceState.getIcpStepsCompleted() == 0) {
                    return AddDeviceScreen.ICP_SETUP_DEVICE;
                }
                if (addDeviceState.getIcpStepsCompleted() == 1) {
                    return AddDeviceScreen.ICP_PAIR_DEVICE;
                }
                if (addDeviceState.getIcpStepsCompleted() == 2 && !addDeviceState.isReadyForNaming()) {
                    return AddDeviceScreen.ICP_SAVE_DEVICE;
                }
                if (addDeviceState.getIcpStepsCompleted() == 2 && addDeviceState.isReadyForNaming()) {
                    return AddDeviceScreen.ICP_NAME_DEVICE;
                }
            }
            return AddDeviceScreen.ICP_ADD_DEVICE;
        } else if (addDeviceState.getDeviceType() == 0) {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.SELECT_DEVICE", new Object[0]);
            return AddDeviceScreen.SELECT_DEVICE;
        } else if (!addDeviceState.getInitialTextSeen()) {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.SETUP_TEXT", new Object[0]);
            return AddDeviceScreen.SETUP_TEXT;
        } else if (addDeviceState.getResetDevice()) {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.RESET_DEVICE", new Object[0]);
            return AddDeviceScreen.RESET_DEVICE;
        } else if (addDeviceState.getDeviceType() != 0 && addDeviceState.getDeviceType() != 3 && addDeviceState.getAutoMode() && addDeviceState.getAutoStepsCompleted() == 0) {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_STEP_1", new Object[0]);
            return AddDeviceScreen.AUTO_STEP_1;
        } else if (addDeviceState.getAutoMode() && ((addDeviceState.getAutoStepsCompleted() == 1 && addDeviceState.getDeviceType() != 3) || (addDeviceState.getAutoStepsCompleted() == 0 && addDeviceState.getDeviceType() == 3))) {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_STEP_2", new Object[0]);
            return AddDeviceScreen.AUTO_STEP_2;
        } else if (addDeviceState.getDeviceInfo() != null || addDeviceState.getAutoFailed() || addDeviceState.getNetworkInfoSet() || !(addDeviceState.getAutoStepsCompleted() == 2 || (addDeviceState.getAutoStepsCompleted() == 1 && addDeviceState.getDeviceType() == 3))) {
            if (addDeviceState.getNetworkInfoSet() && ((addDeviceState.getDeviceInfo() == null || (!addDeviceState.getOtaCheckCompleted() && !addDeviceState.getAutoFailed())) && addDeviceState.getCurrentConfigMode() == 0 && !addDeviceState.getAutoFailed())) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_PROGRESS", new Object[0]);
                return AddDeviceScreen.AUTO_PROGRESS;
            } else if (addDeviceState.getDeviceInfo() == null && addDeviceState.getCurrentConfigMode() == 1 && addDeviceState.getManualStepsCompleted() == 0) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_STEP_1", new Object[0]);
                return AddDeviceScreen.MANUAL_STEP_1;
            } else if (addDeviceState.getManualStepsCompleted() == 1 && !addDeviceState.getManualFailed()) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_STEP_2", new Object[0]);
                return AddDeviceScreen.MANUAL_STEP_2;
            } else if (addDeviceState.getManualStepsCompleted() == 2 && addDeviceState.getDeviceInfo() == null && !addDeviceState.getNetworkInfoSet()) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.CONFIG_NETWORK", new Object[0]);
                return AddDeviceScreen.CONFIG_NETWORK;
            } else if (addDeviceState.getNetworkInfoSet() && addDeviceState.getCurrentConfigMode() == 1 && (((addDeviceState.getDeviceInfo() == null && !addDeviceState.getManualValidated()) || (addDeviceState.getDeviceInfo() != null && addDeviceState.getManualValidated())) && !addDeviceState.isReadyForNaming() && !addDeviceState.getManualFailed())) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_PROGRESS", new Object[0]);
                return AddDeviceScreen.MANUAL_PROGRESS;
            } else if (addDeviceState.getNetworkInfoSet() && addDeviceState.getCurrentConfigMode() == 1 && addDeviceState.getDeviceInfo() != null && !addDeviceState.getManualValidated() && !addDeviceState.getManualFailed()) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_VALIDATE", new Object[0]);
                return AddDeviceScreen.MANUAL_VALIDATE;
            } else if (addDeviceState.getCurrentConfigMode() == 0 && addDeviceState.getDeviceInfo() != null && addDeviceState.isReadyForNaming() && addDeviceState.getDeviceName() == null) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.NAME_DEVICE", new Object[0]);
                return AddDeviceScreen.NAME_DEVICE;
            } else if (addDeviceState.getCurrentConfigMode() == 1 && addDeviceState.getDeviceInfo() != null && addDeviceState.getManualValidated() && addDeviceState.isReadyForNaming() && addDeviceState.getDeviceName() == null) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.NAME_DEVICE", new Object[0]);
                return AddDeviceScreen.NAME_DEVICE;
            } else if (addDeviceState.getCurrentConfigMode() == 0 && addDeviceState.getAutoFailed() && addDeviceState.getAutoFailStepsCompleted() < 1) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_FAIL_STEP_1", new Object[0]);
                return AddDeviceScreen.AUTO_FAIL_STEP_1;
            } else if (addDeviceState.getCurrentConfigMode() == 0 && addDeviceState.getAutoFailed() && addDeviceState.getAutoFailStepsCompleted() > 0) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_FAIL_STEP_2", new Object[0]);
                return AddDeviceScreen.AUTO_FAIL_STEP_2;
            } else if (addDeviceState.getCurrentConfigMode() == 1 && addDeviceState.getManualFailed()) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_FAIL", new Object[0]);
                return AddDeviceScreen.MANUAL_FAIL;
            } else if (addDeviceState.isReadyForMigrationOta()) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.MIGRATION_OTA", new Object[0]);
                return AddDeviceScreen.MIGRATION_OTA;
            } else if (!addDeviceState.isSuccess() || !addDeviceState.getSuccessScreen()) {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.NONE", new Object[0]);
                return AddDeviceScreen.NONE;
            } else {
                Timber.Forest.d("getScreen() -> AddDeviceScreen.SUCCESS", new Object[0]);
                return AddDeviceScreen.SUCCESS;
            }
        } else if (addDeviceState.getDeviceType() == 40) {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_PROGRESS", new Object[0]);
            return AddDeviceScreen.AUTO_PROGRESS;
        } else {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.CONFIG_NETWORK", new Object[0]);
            return AddDeviceScreen.CONFIG_NETWORK;
        }
    }

    public final Single<NetValidation> validateNet(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Single<NetValidation> fromCallable = Single.fromCallable(new AddDeviceUtils$$ExternalSyntheticLambda1(context, i));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable(...)");
        return fromCallable;
    }

    /* access modifiers changed from: private */
    public static final NetValidation validateNet$lambda$1(Context context, int i) {
        String activeWifiSSID = NetUtil.INSTANCE.getActiveWifiSSID(context);
        String manualModeWiFiSSID = DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(i);
        boolean isProbablyOnline = NetUtil.INSTANCE.isProbablyOnline(context);
        Timber.Forest forest = Timber.Forest;
        forest.d("validateNet: isNetworkConnected = " + isProbablyOnline + ", connectedWifiSSID = " + activeWifiSSID + ", notAllowedWiFISSID = " + manualModeWiFiSSID + ", deviceModelType = " + i, new Object[0]);
        return new NetValidation(activeWifiSSID, manualModeWiFiSSID, isProbablyOnline);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/blueair/adddevice/utils/AddDeviceUtils$NetValidation;", "", "connectedWifiSSID", "", "notAllowedWiFISSID", "isOnline", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getConnectedWifiSSID", "()Ljava/lang/String;", "getNotAllowedWiFISSID", "()Z", "valid", "getValid", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceUtils.kt */
    public static final class NetValidation {
        private final String connectedWifiSSID;
        private final boolean isOnline;
        private final String notAllowedWiFISSID;

        public static /* synthetic */ NetValidation copy$default(NetValidation netValidation, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = netValidation.connectedWifiSSID;
            }
            if ((i & 2) != 0) {
                str2 = netValidation.notAllowedWiFISSID;
            }
            if ((i & 4) != 0) {
                z = netValidation.isOnline;
            }
            return netValidation.copy(str, str2, z);
        }

        public final String component1() {
            return this.connectedWifiSSID;
        }

        public final String component2() {
            return this.notAllowedWiFISSID;
        }

        public final boolean component3() {
            return this.isOnline;
        }

        public final NetValidation copy(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str2, "notAllowedWiFISSID");
            return new NetValidation(str, str2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetValidation)) {
                return false;
            }
            NetValidation netValidation = (NetValidation) obj;
            return Intrinsics.areEqual((Object) this.connectedWifiSSID, (Object) netValidation.connectedWifiSSID) && Intrinsics.areEqual((Object) this.notAllowedWiFISSID, (Object) netValidation.notAllowedWiFISSID) && this.isOnline == netValidation.isOnline;
        }

        public int hashCode() {
            String str = this.connectedWifiSSID;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.notAllowedWiFISSID.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isOnline);
        }

        public String toString() {
            return "NetValidation(connectedWifiSSID=" + this.connectedWifiSSID + ", notAllowedWiFISSID=" + this.notAllowedWiFISSID + ", isOnline=" + this.isOnline + ')';
        }

        public NetValidation(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str2, "notAllowedWiFISSID");
            this.connectedWifiSSID = str;
            this.notAllowedWiFISSID = str2;
            this.isOnline = z;
        }

        public final String getConnectedWifiSSID() {
            return this.connectedWifiSSID;
        }

        public final String getNotAllowedWiFISSID() {
            return this.notAllowedWiFISSID;
        }

        public final boolean isOnline() {
            return this.isOnline;
        }

        public final boolean getValid() {
            return this.isOnline;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0117 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean showEnableLocationBluetooth(androidx.fragment.app.Fragment r21, com.blueair.core.util.LocationPermissionTracker r22, androidx.activity.result.ActivityResultLauncher<java.lang.String[]> r23) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "locationPermissionTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "resultLauncher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            android.content.Context r3 = r0.requireContext()
            java.lang.String r4 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            com.blueair.bluetooth.utils.BluetoothUtils r5 = com.blueair.bluetooth.utils.BluetoothUtils.INSTANCE
            boolean r5 = r5.hasBluetoothPermissions(r3)
            if (r5 != 0) goto L_0x0047
            int r1 = com.blueair.viewcore.R.string.permission_request
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = com.blueair.viewcore.R.string.hint_allow_nearby_devices
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r5 = com.blueair.viewcore.R.string.add_device_success_btn_okay
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda3 r6 = new com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda3
            r6.<init>(r2)
            r4.element = r6
        L_0x0044:
            r9 = r5
            goto L_0x00bc
        L_0x0047:
            com.blueair.bluetooth.utils.BluetoothUtils r2 = com.blueair.bluetooth.utils.BluetoothUtils.INSTANCE
            boolean r2 = r2.isBluetoothEnabled(r3)
            if (r2 != 0) goto L_0x006a
            int r1 = com.blueair.viewcore.R.string.enable_bluetooth
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = com.blueair.viewcore.R.string.hint_turn_on_bluetooth
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r5 = com.blueair.viewcore.R.string.enable
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda4 r6 = new com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda4
            r6.<init>(r3)
            r4.element = r6
        L_0x0068:
            r3 = r2
            goto L_0x0044
        L_0x006a:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r2 >= r5) goto L_0x0093
            com.blueair.core.util.LocationUtils r2 = com.blueair.core.util.LocationUtils.INSTANCE
            boolean r2 = r2.isLocationPermissionGranted(r3)
            if (r2 != 0) goto L_0x0093
            int r2 = com.blueair.viewcore.R.string.permission_request
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = com.blueair.viewcore.R.string.hint_allow_nearby_devices
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r5 = com.blueair.viewcore.R.string.add_device_success_btn_okay
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda5 r6 = new com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda5
            r6.<init>(r1, r0)
            r4.element = r6
            r1 = r2
            goto L_0x0044
        L_0x0093:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 >= r5) goto L_0x00b9
            com.blueair.core.util.LocationUtils r1 = com.blueair.core.util.LocationUtils.INSTANCE
            boolean r1 = r1.isLocationEnabled(r3)
            if (r1 != 0) goto L_0x00b9
            int r1 = com.blueair.viewcore.R.string.enable_locations
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = com.blueair.viewcore.R.string.hint_allow_nearby_devices
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r5 = com.blueair.viewcore.R.string.action_settings
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda6 r6 = new com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda6
            r6.<init>(r3)
            r4.element = r6
            goto L_0x0068
        L_0x00b9:
            r1 = 0
            r3 = r1
            r9 = r3
        L_0x00bc:
            if (r1 == 0) goto L_0x0117
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            java.lang.String r2 = "getChildFragmentManager(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Class<com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned> r2 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.class
            java.lang.String r2 = "getSimpleName(...)"
            java.lang.String r5 = "ConfirmationDialogLeftAligned"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            androidx.fragment.app.Fragment r2 = r0.findFragmentByTag(r5)
            boolean r2 = r2 instanceof com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned
            if (r2 != 0) goto L_0x0115
            boolean r2 = r0.isStateSaved()
            if (r2 != 0) goto L_0x0115
            r2 = r5
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned$Companion r5 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion
            java.lang.Number r1 = (java.lang.Number) r1
            int r6 = r1.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            int r8 = r3.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r1 = com.blueair.viewcore.R.string.btn_cancel
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda7 r1 = new com.blueair.adddevice.utils.AddDeviceUtils$$ExternalSyntheticLambda7
            r1.<init>(r4)
            r18 = 1632(0x660, float:2.287E-42)
            r19 = 0
            r7 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 1
            r15 = 0
            r16 = 0
            r17 = r1
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned r1 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion.newInstance$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            androidx.fragment.app.DialogFragment r1 = (androidx.fragment.app.DialogFragment) r1
            r1.show((androidx.fragment.app.FragmentManager) r0, (java.lang.String) r2)
        L_0x0115:
            r0 = 1
            return r0
        L_0x0117:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.utils.AddDeviceUtils.showEnableLocationBluetooth(androidx.fragment.app.Fragment, com.blueair.core.util.LocationPermissionTracker, androidx.activity.result.ActivityResultLauncher):boolean");
    }

    /* access modifiers changed from: private */
    public static final Unit showEnableLocationBluetooth$lambda$2(ActivityResultLauncher activityResultLauncher) {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_bluetooth, R.string.permission_request_message_bluetooth);
        activityResultLauncher.launch(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"});
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showEnableLocationBluetooth$lambda$3(Context context) {
        Object systemService = context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        if (Build.VERSION.SDK_INT >= 33) {
            context.startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
        } else {
            adapter.enable();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showEnableLocationBluetooth$lambda$5(LocationPermissionTracker locationPermissionTracker, Fragment fragment) {
        locationPermissionTracker.requestLocationPermission(fragment, new AddDeviceUtils$$ExternalSyntheticLambda0());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showEnableLocationBluetooth$lambda$5$lambda$4() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_bluetooth, R.string.permission_request_message_location_bluetooth);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showEnableLocationBluetooth$lambda$7(Context context) {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(268435456);
        context.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showEnableLocationBluetooth$lambda$9$lambda$8(Ref.ObjectRef objectRef, boolean z) {
        Function0 function0;
        if (z && (function0 = (Function0) objectRef.element) != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
