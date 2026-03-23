package com.blueair.antifake.viewmodel;

import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0016\u0017\u0018\u0019\u001a\u001bB9\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0001\u0006\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage;", "", "title", "", "header", "step", "backBtnEnabled", "", "closeBtnEnabled", "screenName", "", "<init>", "(IIIZZLjava/lang/String;)V", "getTitle", "()I", "getHeader", "getStep", "getBackBtnEnabled", "()Z", "getCloseBtnEnabled", "getScreenName", "()Ljava/lang/String;", "CodeVerifying", "CodeVerifyResult", "SelectDevice", "ResetByWifi", "ScanBluetooth", "ResetByBluetooth", "Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifyResult;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifying;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByWifi;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$ScanBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$SelectDevice;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AntiFakeViewModel.kt */
public abstract class AntiFakePage {
    private final boolean backBtnEnabled;
    private final boolean closeBtnEnabled;
    private final int header;
    private final String screenName;
    private final int step;
    private final int title;

    public /* synthetic */ AntiFakePage(int i, int i2, int i3, boolean z, boolean z2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, z, z2, str);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifying;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class CodeVerifying extends AntiFakePage {
        public static final CodeVerifying INSTANCE = new CodeVerifying();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CodeVerifying)) {
                return false;
            }
            CodeVerifying codeVerifying = (CodeVerifying) obj;
            return true;
        }

        public int hashCode() {
            return -761961110;
        }

        public String toString() {
            return "CodeVerifying";
        }

        private CodeVerifying() {
            super(R.string.anti_counterfeiting, R.string.scan_results, 0, true, true, AnalyticEvent.ScreenViewEvent.ANTIFAKE_RESET_VERIFYING, (DefaultConstructorMarker) null);
        }
    }

    private AntiFakePage(int i, int i2, int i3, boolean z, boolean z2, String str) {
        this.title = i;
        this.header = i2;
        this.step = i3;
        this.backBtnEnabled = z;
        this.closeBtnEnabled = z2;
        this.screenName = str;
    }

    public final boolean getBackBtnEnabled() {
        return this.backBtnEnabled;
    }

    public final boolean getCloseBtnEnabled() {
        return this.closeBtnEnabled;
    }

    public final int getHeader() {
        return this.header;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final int getStep() {
        return this.step;
    }

    public final int getTitle() {
        return this.title;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifyResult;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class CodeVerifyResult extends AntiFakePage {
        public static final CodeVerifyResult INSTANCE = new CodeVerifyResult();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CodeVerifyResult)) {
                return false;
            }
            CodeVerifyResult codeVerifyResult = (CodeVerifyResult) obj;
            return true;
        }

        public int hashCode() {
            return -1347577419;
        }

        public String toString() {
            return "CodeVerifyResult";
        }

        private CodeVerifyResult() {
            super(R.string.anti_counterfeiting, R.string.scan_results, 0, true, true, AnalyticEvent.ScreenViewEvent.ANTIFAKE_RESET_VERIFY_RESULT, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$SelectDevice;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class SelectDevice extends AntiFakePage {
        public static final SelectDevice INSTANCE = new SelectDevice();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelectDevice)) {
                return false;
            }
            SelectDevice selectDevice = (SelectDevice) obj;
            return true;
        }

        public int hashCode() {
            return 439079076;
        }

        public String toString() {
            return "SelectDevice";
        }

        private SelectDevice() {
            super(R.string.reset_filter, R.string.reset_filter_select_device_hint, 1, true, true, AnalyticEvent.ScreenViewEvent.ANTIFAKE_SELECT_DEVICE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByWifi;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "step", "", "<init>", "(I)V", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class ResetByWifi extends AntiFakePage {
        public ResetByWifi(int i) {
            super(R.string.reset_filter, R.string.reset_via_internet, i, false, true, AnalyticEvent.ScreenViewEvent.ANTIFAKE_RESET_BY_WIFI, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$ScanBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class ScanBluetooth extends AntiFakePage {
        public static final ScanBluetooth INSTANCE = new ScanBluetooth();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScanBluetooth)) {
                return false;
            }
            ScanBluetooth scanBluetooth = (ScanBluetooth) obj;
            return true;
        }

        public int hashCode() {
            return 281583807;
        }

        public String toString() {
            return "ScanBluetooth";
        }

        private ScanBluetooth() {
            super(R.string.find_your_device, R.string.connect_via_bluetooth, 1, true, false, AnalyticEvent.ScreenViewEvent.ANTIFAKE_SCAN_BLUETOOTH, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class ResetByBluetooth extends AntiFakePage {
        public static final ResetByBluetooth INSTANCE = new ResetByBluetooth();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResetByBluetooth)) {
                return false;
            }
            ResetByBluetooth resetByBluetooth = (ResetByBluetooth) obj;
            return true;
        }

        public int hashCode() {
            return 11800698;
        }

        public String toString() {
            return "ResetByBluetooth";
        }

        private ResetByBluetooth() {
            super(R.string.reset_filter, R.string.reset_via_bluetooth, 2, false, true, AnalyticEvent.ScreenViewEvent.ANTIFAKE_RESET_BY_BLUETOOTH, (DefaultConstructorMarker) null);
        }
    }
}
