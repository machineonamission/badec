package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.Device;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.gigya.android.sdk.GigyaDefinitions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0&\u0012\u0006\u0012\u0004\u0018\u00010'0%H\u0002¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020#0,R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_requesting", "Landroidx/lifecycle/MutableLiveData;", "", "requesting", "Landroidx/lifecycle/LiveData;", "getRequesting", "()Landroidx/lifecycle/LiveData;", "fullTimezoneList", "", "Ljava/util/TimeZone;", "getFullTimezoneList", "()Ljava/util/List;", "_timezoneList", "timezoneList", "getTimezoneList", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "value", "", "searchText", "getSearchText", "()Ljava/lang/String;", "setSearchText", "(Ljava/lang/String;)V", "launchRequest", "", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "setDeviceTimezone", "timezone", "onSuccess", "Lkotlin/Function0;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSetTimezoneViewModel.kt */
public final class DeviceSetTimezoneViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _requesting;
    private final MutableLiveData<List<TimeZone>> _timezoneList;
    public Device device;
    private final List<TimeZone> fullTimezoneList;
    private final LiveData<Boolean> requesting;
    private String searchText = "";
    private final LiveData<List<TimeZone>> timezoneList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceSetTimezoneViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._requesting = mutableLiveData;
        this.requesting = mutableLiveData;
        List<TimeZone> timezones = TimezoneUtils.INSTANCE.getTimezoneList(application).getTimezones();
        this.fullTimezoneList = timezones;
        MutableLiveData<List<TimeZone>> mutableLiveData2 = new MutableLiveData<>(timezones);
        this._timezoneList = mutableLiveData2;
        this.timezoneList = mutableLiveData2;
    }

    public final LiveData<Boolean> getRequesting() {
        return this.requesting;
    }

    public final List<TimeZone> getFullTimezoneList() {
        return this.fullTimezoneList;
    }

    public final LiveData<List<TimeZone>> getTimezoneList() {
        return this.timezoneList;
    }

    public final Device getDevice() {
        Device device2 = this.device;
        if (device2 != null) {
            return device2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "<set-?>");
        this.device = device2;
    }

    public final String getSearchText() {
        return this.searchText;
    }

    public final void setSearchText(String str) {
        List<TimeZone> list;
        Intrinsics.checkNotNullParameter(str, "value");
        if (!Intrinsics.areEqual((Object) this.searchText, (Object) str)) {
            this.searchText = str;
            MutableLiveData<List<TimeZone>> mutableLiveData = this._timezoneList;
            if (str.length() == 0) {
                list = this.fullTimezoneList;
            } else {
                char[] charArray = str.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                Collection arrayList = new ArrayList();
                for (char c : charArray) {
                    if (c != ' ') {
                        arrayList.add(Character.valueOf(c));
                    }
                }
                Regex regex = new Regex(CollectionsKt.joinToString$default((List) arrayList, ".*", ".*", ".*", 0, (CharSequence) null, (Function1) null, 56, (Object) null), RegexOption.IGNORE_CASE);
                Collection arrayList2 = new ArrayList();
                for (Object next : this.fullTimezoneList) {
                    TimeZone timeZone = (TimeZone) next;
                    String displayName = TimezoneUtils.INSTANCE.getDisplayName(getApplication(), timeZone);
                    if (!regex.matches(displayName + timeZone.getID())) {
                        if (!regex.matches(timeZone.getID() + displayName)) {
                        }
                    }
                    arrayList2.add(next);
                }
                list = (List) arrayList2;
            }
            mutableLiveData.setValue(list);
        }
    }

    private final void launchRequest(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        if (!Intrinsics.areEqual((Object) this.requesting.getValue(), (Object) true)) {
            this._requesting.setValue(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new DeviceSetTimezoneViewModel$launchRequest$1(function1, this, (Continuation<? super DeviceSetTimezoneViewModel$launchRequest$1>) null), 3, (Object) null);
        }
    }

    public final void setDeviceTimezone(TimeZone timeZone, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(timeZone, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        launchRequest(new DeviceSetTimezoneViewModel$setDeviceTimezone$1(this, timeZone, function0, (Continuation<? super DeviceSetTimezoneViewModel$setDeviceTimezone$1>) null));
    }
}
