package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u0011Bå\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0016\u0012\b\b\u0002\u0010\"\u001a\u00020\u001e\u0012\b\b\u0002\u0010#\u001a\u00020\u0016\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\b\b\u0002\u0010&\u001a\u00020\u0013\u0012\b\b\u0002\u0010'\u001a\u00020\u0013\u0012\b\b\u0002\u0010(\u001a\u00020\u0013\u0012\b\b\u0002\u0010)\u001a\u00020\u0013\u0012\b\b\u0002\u0010*\u001a\u00020\u0013\u0012\b\b\u0002\u0010+\u001a\u00020\u0013\u0012\b\b\u0002\u0010,\u001a\u00020\u0013\u0012\b\b\u0002\u0010-\u001a\u00020\u0013\u0012\b\b\u0002\u0010.\u001a\u00020\u0013\u0012\b\b\u0002\u0010/\u001a\u00020\u0013\u0012\b\b\u0002\u00100\u001a\u00020\u0013\u0012\b\b\u0002\u00101\u001a\u000202\u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u00104\u001a\u000202\u0012\b\b\u0002\u00105\u001a\u000202\u0012\b\b\u0002\u00106\u001a\u000202\u0012\b\b\u0002\u00107\u001a\u00020\u0016\u0012\b\b\u0002\u00108\u001a\u00020\u001e\u0012\b\b\u0002\u00109\u001a\u00020\u001e\u0012\b\b\u0002\u0010:\u001a\u00020\u0013\u0012\b\b\u0002\u0010;\u001a\u00020\u0013\u0012\b\b\u0002\u0010<\u001a\u00020\u0016\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010>\u001a\u00020\u0016\u0012\b\b\u0002\u0010?\u001a\u00020\u0016\u0012\b\b\u0002\u0010@\u001a\u00020\u0016\u0012\b\b\u0002\u0010A\u001a\u00020%\u0012\b\b\u0002\u0010B\u001a\u00020\u0016\u0012\b\b\u0002\u0010C\u001a\u00020\u0016\u0012\b\b\u0002\u0010D\u001a\u00020\u0016\u0012\b\b\u0002\u0010E\u001a\u00020\u0016\u0012\b\b\u0002\u0010F\u001a\u00020\u0016\u0012\b\b\u0002\u0010G\u001a\u00020\u001e¢\u0006\u0004\bH\u0010IJ\t\u0010\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010PJ\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020%HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0016HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010§\u0001\u001a\u00020%HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u001eHÆ\u0003Jð\u0003\u0010®\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u00162\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00132\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020\u00132\b\b\u0002\u0010+\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u00132\b\b\u0002\u0010-\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u00132\b\b\u0002\u0010/\u001a\u00020\u00132\b\b\u0002\u00100\u001a\u00020\u00132\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u0002022\b\b\u0002\u00105\u001a\u0002022\b\b\u0002\u00106\u001a\u0002022\b\b\u0002\u00107\u001a\u00020\u00162\b\b\u0002\u00108\u001a\u00020\u001e2\b\b\u0002\u00109\u001a\u00020\u001e2\b\b\u0002\u0010:\u001a\u00020\u00132\b\b\u0002\u0010;\u001a\u00020\u00132\b\b\u0002\u0010<\u001a\u00020\u00162\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010>\u001a\u00020\u00162\b\b\u0002\u0010?\u001a\u00020\u00162\b\b\u0002\u0010@\u001a\u00020\u00162\b\b\u0002\u0010A\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020\u00162\b\b\u0002\u0010D\u001a\u00020\u00162\b\b\u0002\u0010E\u001a\u00020\u00162\b\b\u0002\u0010F\u001a\u00020\u00162\b\b\u0002\u0010G\u001a\u00020\u001eHÆ\u0001¢\u0006\u0003\u0010¯\u0001J\u0007\u0010°\u0001\u001a\u00020\u0016J\u0016\u0010±\u0001\u001a\u00020\u001e2\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001HÖ\u0003J\n\u0010´\u0001\u001a\u00020\u0016HÖ\u0001J\n\u0010µ\u0001\u001a\u00020\u0013HÖ\u0001J\u001b\u0010¶\u0001\u001a\u00030·\u00012\b\u0010¸\u0001\u001a\u00030¹\u00012\u0007\u0010º\u0001\u001a\u00020\u0016R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0014\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010KR\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010PR\u0014\u0010\u0018\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010NR\u0014\u0010\u0019\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010KR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010KR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 X\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0014\u0010!\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010NR\u0014\u0010\"\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010XR\u0014\u0010#\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010NR\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0014\u0010&\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010KR\u0014\u0010'\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010KR\u0014\u0010(\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010KR\u0014\u0010)\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010KR\u0014\u0010*\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010KR\u0014\u0010+\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010KR\u0014\u0010,\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010KR\u0014\u0010-\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010KR\u0014\u0010.\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010KR\u0014\u0010/\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010KR\u0014\u00100\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010KR\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0014\u00103\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010kR\u0014\u00104\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010kR\u0014\u00105\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010kR\u0014\u00106\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010kR\u0014\u00107\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010NR\u0014\u00108\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010XR\u0014\u00109\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010XR\u0014\u0010:\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010KR\u0014\u0010;\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010KR\u0014\u0010<\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010NR\u0016\u0010=\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010KR\u0014\u0010>\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010NR\u0014\u0010?\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010NR\u0014\u0010@\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010NR\u0014\u0010A\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010^R\u0014\u0010B\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010NR\u0014\u0010C\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010NR\u0014\u0010D\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010NR\u0014\u0010E\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010NR\u0014\u0010F\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010NR\u0014\u0010G\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010X¨\u0006»\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceDehumidifier;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasDehumidifierMainMode;", "Lcom/blueair/core/model/HasAutoRh;", "Lcom/blueair/core/model/HasWaterLevel;", "Lcom/blueair/core/model/HasWaterTank;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "autoRh", "mainMode", "apSubMode", "dehSubMode", "waterLevel", "waterTankFailure", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIJIIIIIZ)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getAutoRh", "getMainMode", "getApSubMode", "getDehSubMode", "getWaterLevel", "getWaterTankFailure", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIJIIIIIZ)Lcom/blueair/core/model/DeviceDehumidifier;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceDehumidifier implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasTimer, HasDehumidifierMainMode, HasAutoRh, HasWaterLevel, HasWaterTank {
    public static final Parcelable.Creator<DeviceDehumidifier> CREATOR = new Creator();
    private final int apSubMode;
    private final String autoModeText;
    private final int autoRh;
    private final int brightness;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final int dehSubMode;
    private final DeviceUuid deviceUuid;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String g4NightModeFilterTrigger;
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final double[] hchoRanges;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isG4NightModeOn;
    private final boolean isStandByOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String mac;
    private final int mainMode;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final String serial;
    private final String sku;
    private final String timeZone;
    private final int timerDuration;
    private final int timerLeftTime;
    private final long timerLeftTimeUpdateTime;
    private final int timerStatus;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final int waterLevel;
    private final boolean waterTankFailure;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceDehumidifier> {
        public final DeviceDehumidifier createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            IndoorDatapoint indoorDatapoint = null;
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z4 = parcel2.readInt() != 0;
            if (parcel2.readInt() != 0) {
                indoorDatapoint = IndoorDatapoint.CREATOR.createFromParcel(parcel2);
            }
            IndoorDatapoint indoorDatapoint2 = indoorDatapoint;
            boolean z5 = false;
            int readInt3 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z = false;
                z5 = true;
            } else {
                z = false;
            }
            boolean z6 = z;
            int readInt4 = parcel2.readInt();
            long readLong = parcel2.readLong();
            boolean z7 = z6;
            String readString5 = parcel2.readString();
            boolean z8 = z7;
            String readString6 = parcel2.readString();
            boolean z9 = z8;
            String readString7 = parcel2.readString();
            boolean z10 = z9;
            String readString8 = parcel2.readString();
            boolean z11 = z10;
            String readString9 = parcel2.readString();
            boolean z12 = z11;
            String readString10 = parcel2.readString();
            boolean z13 = z12;
            String readString11 = parcel2.readString();
            boolean z14 = z13;
            String readString12 = parcel2.readString();
            boolean z15 = z14;
            String readString13 = parcel2.readString();
            boolean z16 = z15;
            String readString14 = parcel2.readString();
            boolean z17 = z16;
            String readString15 = parcel2.readString();
            boolean z18 = z17;
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z19 = z18;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z20 = z19;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z21 = z20;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z22 = z21;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z23 = z22;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z2 = z23;
                z23 = true;
            } else {
                z2 = z23;
            }
            if (parcel2.readInt() != 0) {
                z3 = z2;
                z2 = true;
            } else {
                z3 = z2;
            }
            boolean z24 = z3;
            String readString16 = parcel2.readString();
            String readString17 = parcel2.readString();
            boolean z25 = z24;
            int readInt6 = parcel2.readInt();
            boolean z26 = z25;
            String readString18 = parcel2.readString();
            boolean z27 = z26;
            int readInt7 = parcel2.readInt();
            boolean z28 = z27;
            int readInt8 = parcel2.readInt();
            boolean z29 = z28;
            int readInt9 = parcel2.readInt();
            boolean z30 = z29;
            long readLong2 = parcel2.readLong();
            boolean z31 = z30;
            int readInt10 = parcel2.readInt();
            boolean z32 = z31;
            int readInt11 = parcel2.readInt();
            boolean z33 = z32;
            int readInt12 = parcel2.readInt();
            boolean z34 = z33;
            int readInt13 = parcel2.readInt();
            boolean z35 = z34;
            int readInt14 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z35 = true;
            }
            return new DeviceDehumidifier(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z4, indoorDatapoint2, readInt3, z5, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z23, z2, readString16, readString17, readInt6, readString18, readInt7, readInt8, readInt9, readLong2, readInt10, readInt11, readInt12, readInt13, readInt14, z35);
        }

        public final DeviceDehumidifier[] newArray(int i) {
            return new DeviceDehumidifier[i];
        }
    }

    public static /* synthetic */ DeviceDehumidifier copy$default(DeviceDehumidifier deviceDehumidifier, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, int i13, int i14, boolean z5, int i15, int i16, Object obj) {
        long j3;
        String str19;
        DeviceDehumidifier deviceDehumidifier2 = deviceDehumidifier;
        int i17 = i15;
        int i18 = i16;
        String str20 = (i17 & 1) != 0 ? deviceDehumidifier2.uid : str;
        String str21 = (i17 & 2) != 0 ? deviceDehumidifier2.name : str2;
        int i19 = (i17 & 4) != 0 ? deviceDehumidifier2.fanSpeed : i;
        Integer num2 = (i17 & 8) != 0 ? deviceDehumidifier2.filterLife : num;
        int i20 = (i17 & 16) != 0 ? deviceDehumidifier2.brightness : i2;
        String str22 = (i17 & 32) != 0 ? deviceDehumidifier2.autoModeText : str3;
        String str23 = (i17 & 64) != 0 ? deviceDehumidifier2.info : str4;
        DeviceUuid deviceUuid3 = (i17 & 128) != 0 ? deviceDehumidifier2.deviceUuid : deviceUuid2;
        boolean z6 = (i17 & 256) != 0 ? deviceDehumidifier2.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint2 = (i17 & 512) != 0 ? deviceDehumidifier2.latestSensorDatapoint : indoorDatapoint;
        int i21 = (i17 & 1024) != 0 ? deviceDehumidifier2.lastSelectedSensorTypeIndex : i3;
        boolean z7 = (i17 & 2048) != 0 ? deviceDehumidifier2.isChildLockOn : z2;
        int i22 = (i17 & 4096) != 0 ? deviceDehumidifier2.connectivityStatusIndex : i4;
        String str24 = str20;
        String str25 = str21;
        long j4 = (i17 & 8192) != 0 ? deviceDehumidifier2.lastConnectivityInMillis : j;
        String str26 = (i17 & 16384) != 0 ? deviceDehumidifier2.mac : str5;
        String str27 = (32768 & i17) != 0 ? deviceDehumidifier2.mcuFirmware : str6;
        String str28 = (i17 & 65536) != 0 ? deviceDehumidifier2.wifiFirmware : str7;
        String str29 = (i15 & 131072) != 0 ? deviceDehumidifier2.hardware : str8;
        String str30 = (i15 & 262144) != 0 ? deviceDehumidifier2.timeZone : str9;
        String str31 = (i15 & 524288) != 0 ? deviceDehumidifier2.serial : str10;
        String str32 = (i15 & 1048576) != 0 ? deviceDehumidifier2.purchaseDate : str11;
        String str33 = (i15 & 2097152) != 0 ? deviceDehumidifier2.dealerName : str12;
        String str34 = (i15 & 4194304) != 0 ? deviceDehumidifier2.dealerCountry : str13;
        String str35 = (i15 & 8388608) != 0 ? deviceDehumidifier2.filterType : str14;
        String str36 = (i15 & 16777216) != 0 ? deviceDehumidifier2.filterTrigger : str15;
        double[] dArr6 = (i15 & 33554432) != 0 ? deviceDehumidifier2.pm1Ranges : dArr;
        double[] dArr7 = (i15 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceDehumidifier2.pm10Ranges : dArr2;
        double[] dArr8 = (i15 & 134217728) != 0 ? deviceDehumidifier2.pm25Ranges : dArr3;
        double[] dArr9 = (i15 & 268435456) != 0 ? deviceDehumidifier2.vocRanges : dArr4;
        double[] dArr10 = (i15 & 536870912) != 0 ? deviceDehumidifier2.hchoRanges : dArr5;
        int i23 = (i15 & 1073741824) != 0 ? deviceDehumidifier2.updateProgress : i5;
        boolean z8 = (i15 & Integer.MIN_VALUE) != 0 ? deviceDehumidifier2.isStandByOn : z3;
        boolean z9 = (i18 & 1) != 0 ? deviceDehumidifier2.isG4NightModeOn : z4;
        String str37 = (i18 & 2) != 0 ? deviceDehumidifier2.g4NightModeFilterTrigger : str16;
        String str38 = (i18 & 4) != 0 ? deviceDehumidifier2.modelName : str17;
        int i24 = (i18 & 8) != 0 ? deviceDehumidifier2.typeIndex : i6;
        String str39 = (i18 & 16) != 0 ? deviceDehumidifier2.sku : str18;
        int i25 = (i18 & 32) != 0 ? deviceDehumidifier2.timerStatus : i7;
        int i26 = (i18 & 64) != 0 ? deviceDehumidifier2.timerDuration : i8;
        int i27 = (i18 & 128) != 0 ? deviceDehumidifier2.timerLeftTime : i9;
        String str40 = str26;
        if ((i18 & 256) != 0) {
            str19 = str27;
            j3 = deviceDehumidifier2.timerLeftTimeUpdateTime;
        } else {
            str19 = str27;
            j3 = j2;
        }
        return deviceDehumidifier2.copy(str24, str25, i19, num2, i20, str22, str23, deviceUuid3, z6, indoorDatapoint2, i21, z7, i22, j4, str40, str19, str28, str29, str30, str31, str32, str33, str34, str35, str36, dArr6, dArr7, dArr8, dArr9, dArr10, i23, z8, z9, str37, str38, i24, str39, i25, i26, i27, j3, (i18 & 512) != 0 ? deviceDehumidifier2.autoRh : i10, (i18 & 1024) != 0 ? deviceDehumidifier2.mainMode : i11, (i18 & 2048) != 0 ? deviceDehumidifier2.apSubMode : i12, (i18 & 4096) != 0 ? deviceDehumidifier2.dehSubMode : i13, (i18 & 8192) != 0 ? deviceDehumidifier2.waterLevel : i14, (i18 & 16384) != 0 ? deviceDehumidifier2.waterTankFailure : z5);
    }

    public final String component1() {
        return this.uid;
    }

    public final IndoorDatapoint component10() {
        return this.latestSensorDatapoint;
    }

    public final int component11() {
        return this.lastSelectedSensorTypeIndex;
    }

    public final boolean component12() {
        return this.isChildLockOn;
    }

    public final int component13() {
        return this.connectivityStatusIndex;
    }

    public final long component14() {
        return this.lastConnectivityInMillis;
    }

    public final String component15() {
        return this.mac;
    }

    public final String component16() {
        return this.mcuFirmware;
    }

    public final String component17() {
        return this.wifiFirmware;
    }

    public final String component18() {
        return this.hardware;
    }

    public final String component19() {
        return this.timeZone;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.serial;
    }

    public final String component21() {
        return this.purchaseDate;
    }

    public final String component22() {
        return this.dealerName;
    }

    public final String component23() {
        return this.dealerCountry;
    }

    public final String component24() {
        return this.filterType;
    }

    public final String component25() {
        return this.filterTrigger;
    }

    public final double[] component26() {
        return this.pm1Ranges;
    }

    public final double[] component27() {
        return this.pm10Ranges;
    }

    public final double[] component28() {
        return this.pm25Ranges;
    }

    public final double[] component29() {
        return this.vocRanges;
    }

    public final int component3() {
        return this.fanSpeed;
    }

    public final double[] component30() {
        return this.hchoRanges;
    }

    public final int component31() {
        return this.updateProgress;
    }

    public final boolean component32() {
        return this.isStandByOn;
    }

    public final boolean component33() {
        return this.isG4NightModeOn;
    }

    public final String component34() {
        return this.g4NightModeFilterTrigger;
    }

    public final String component35() {
        return this.modelName;
    }

    public final int component36() {
        return this.typeIndex;
    }

    public final String component37() {
        return this.sku;
    }

    public final int component38() {
        return this.timerStatus;
    }

    public final int component39() {
        return this.timerDuration;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final int component40() {
        return this.timerLeftTime;
    }

    public final long component41() {
        return this.timerLeftTimeUpdateTime;
    }

    public final int component42() {
        return this.autoRh;
    }

    public final int component43() {
        return this.mainMode;
    }

    public final int component44() {
        return this.apSubMode;
    }

    public final int component45() {
        return this.dehSubMode;
    }

    public final int component46() {
        return this.waterLevel;
    }

    public final boolean component47() {
        return this.waterTankFailure;
    }

    public final int component5() {
        return this.brightness;
    }

    public final String component6() {
        return this.autoModeText;
    }

    public final String component7() {
        return this.info;
    }

    public final DeviceUuid component8() {
        return this.deviceUuid;
    }

    public final boolean component9() {
        return this.hasFinishedOnboarding;
    }

    public final DeviceDehumidifier copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, int i13, int i14, boolean z5) {
        String str19 = str;
        Intrinsics.checkNotNullParameter(str19, "uid");
        String str20 = str2;
        Intrinsics.checkNotNullParameter(str20, "name");
        String str21 = str3;
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        Intrinsics.checkNotNullParameter(str5, AnalyticEvent.KEY_MAC);
        String str22 = str6;
        Intrinsics.checkNotNullParameter(str22, "mcuFirmware");
        String str23 = str7;
        Intrinsics.checkNotNullParameter(str23, "wifiFirmware");
        String str24 = str8;
        Intrinsics.checkNotNullParameter(str24, "hardware");
        String str25 = str9;
        Intrinsics.checkNotNullParameter(str25, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str26 = str10;
        Intrinsics.checkNotNullParameter(str26, "serial");
        String str27 = str11;
        Intrinsics.checkNotNullParameter(str27, "purchaseDate");
        String str28 = str12;
        Intrinsics.checkNotNullParameter(str28, "dealerName");
        String str29 = str13;
        Intrinsics.checkNotNullParameter(str29, "dealerCountry");
        String str30 = str14;
        Intrinsics.checkNotNullParameter(str30, "filterType");
        String str31 = str15;
        Intrinsics.checkNotNullParameter(str31, "filterTrigger");
        double[] dArr6 = dArr;
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        Intrinsics.checkNotNullParameter(str17, "modelName");
        String str32 = str22;
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        String str41 = str31;
        double[] dArr7 = dArr6;
        return new DeviceDehumidifier(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, str16, str17, i6, str18, i7, i8, i9, j2, i10, i11, i12, i13, i14, z5);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceDehumidifier)) {
            return false;
        }
        DeviceDehumidifier deviceDehumidifier = (DeviceDehumidifier) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceDehumidifier.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceDehumidifier.name) && this.fanSpeed == deviceDehumidifier.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceDehumidifier.filterLife) && this.brightness == deviceDehumidifier.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceDehumidifier.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceDehumidifier.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceDehumidifier.deviceUuid) && this.hasFinishedOnboarding == deviceDehumidifier.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceDehumidifier.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceDehumidifier.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceDehumidifier.isChildLockOn && this.connectivityStatusIndex == deviceDehumidifier.connectivityStatusIndex && this.lastConnectivityInMillis == deviceDehumidifier.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceDehumidifier.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceDehumidifier.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceDehumidifier.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceDehumidifier.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceDehumidifier.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceDehumidifier.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceDehumidifier.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceDehumidifier.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceDehumidifier.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceDehumidifier.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceDehumidifier.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceDehumidifier.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceDehumidifier.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceDehumidifier.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceDehumidifier.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceDehumidifier.hchoRanges) && this.updateProgress == deviceDehumidifier.updateProgress && this.isStandByOn == deviceDehumidifier.isStandByOn && this.isG4NightModeOn == deviceDehumidifier.isG4NightModeOn && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) deviceDehumidifier.g4NightModeFilterTrigger) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceDehumidifier.modelName) && this.typeIndex == deviceDehumidifier.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceDehumidifier.sku) && this.timerStatus == deviceDehumidifier.timerStatus && this.timerDuration == deviceDehumidifier.timerDuration && this.timerLeftTime == deviceDehumidifier.timerLeftTime && this.timerLeftTimeUpdateTime == deviceDehumidifier.timerLeftTimeUpdateTime && this.autoRh == deviceDehumidifier.autoRh && this.mainMode == deviceDehumidifier.mainMode && this.apSubMode == deviceDehumidifier.apSubMode && this.dehSubMode == deviceDehumidifier.dehSubMode && this.waterLevel == deviceDehumidifier.waterLevel && this.waterTankFailure == deviceDehumidifier.waterTankFailure;
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.brightness) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        DeviceUuid deviceUuid2 = this.deviceUuid;
        int hashCode4 = (((hashCode3 + (deviceUuid2 == null ? 0 : deviceUuid2.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding)) * 31;
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        int hashCode5 = (((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn)) * 31) + this.g4NightModeFilterTrigger.hashCode()) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((((((((((((((((hashCode5 + i) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31) + this.autoRh) * 31) + this.mainMode) * 31) + this.apSubMode) * 31) + this.dehSubMode) * 31) + this.waterLevel) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterTankFailure);
    }

    public String toString() {
        return "DeviceDehumidifier(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", autoRh=" + this.autoRh + ", mainMode=" + this.mainMode + ", apSubMode=" + this.apSubMode + ", dehSubMode=" + this.dehSubMode + ", waterLevel=" + this.waterLevel + ", waterTankFailure=" + this.waterTankFailure + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.fanSpeed);
        Integer num = this.filterLife;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.brightness);
        parcel.writeString(this.autoModeText);
        parcel.writeString(this.info);
        DeviceUuid deviceUuid2 = this.deviceUuid;
        if (deviceUuid2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            deviceUuid2.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.hasFinishedOnboarding ? 1 : 0);
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        if (indoorDatapoint == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            indoorDatapoint.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.lastSelectedSensorTypeIndex);
        parcel.writeInt(this.isChildLockOn ? 1 : 0);
        parcel.writeInt(this.connectivityStatusIndex);
        parcel.writeLong(this.lastConnectivityInMillis);
        parcel.writeString(this.mac);
        parcel.writeString(this.mcuFirmware);
        parcel.writeString(this.wifiFirmware);
        parcel.writeString(this.hardware);
        parcel.writeString(this.timeZone);
        parcel.writeString(this.serial);
        parcel.writeString(this.purchaseDate);
        parcel.writeString(this.dealerName);
        parcel.writeString(this.dealerCountry);
        parcel.writeString(this.filterType);
        parcel.writeString(this.filterTrigger);
        parcel.writeDoubleArray(this.pm1Ranges);
        parcel.writeDoubleArray(this.pm10Ranges);
        parcel.writeDoubleArray(this.pm25Ranges);
        parcel.writeDoubleArray(this.vocRanges);
        parcel.writeDoubleArray(this.hchoRanges);
        parcel.writeInt(this.updateProgress);
        parcel.writeInt(this.isStandByOn ? 1 : 0);
        parcel.writeInt(this.isG4NightModeOn ? 1 : 0);
        parcel.writeString(this.g4NightModeFilterTrigger);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.typeIndex);
        parcel.writeString(this.sku);
        parcel.writeInt(this.timerStatus);
        parcel.writeInt(this.timerDuration);
        parcel.writeInt(this.timerLeftTime);
        parcel.writeLong(this.timerLeftTimeUpdateTime);
        parcel.writeInt(this.autoRh);
        parcel.writeInt(this.mainMode);
        parcel.writeInt(this.apSubMode);
        parcel.writeInt(this.dehSubMode);
        parcel.writeInt(this.waterLevel);
        parcel.writeInt(this.waterTankFailure ? 1 : 0);
    }

    public double[] airRatingsFor(SensorType sensorType) {
        return HasSensorData.CC.$default$airRatingsFor(this, sensorType);
    }

    public ApSubMode apSubMode() {
        return HasMainMode.CC.$default$apSubMode(this);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(double d, SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, d, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, sensorType);
    }

    public DehSubMode dehSubMode() {
        return HasDehumidifierMainMode.CC.$default$dehSubMode(this);
    }

    public IndoorAirRatingRanges getAirRatingRanges() {
        return HasSensorData.CC.$default$getAirRatingRanges(this);
    }

    public AutoMode getAutoMode() {
        return HasFanSpeed.CC.$default$getAutoMode(this);
    }

    public Brightness getBrightnessEnum() {
        return HasBrightness.CC.$default$getBrightnessEnum(this);
    }

    public ConnectivityStatus getConnectivityStatus() {
        return Device.CC.$default$getConnectivityStatus(this);
    }

    public FanSpeedEnum getFanSpeedEnum() {
        return HasFanSpeed.CC.$default$getFanSpeedEnum(this);
    }

    public Filter getFilter() {
        return HasFanSpeed.CC.$default$getFilter(this);
    }

    public FilterTrigger getG4NightModeTrigger() {
        return HasG4NightMode.CC.$default$getG4NightModeTrigger(this);
    }

    public boolean getHasGear0() {
        return HasFanSpeed.CC.$default$getHasGear0(this);
    }

    public boolean getHasGear4() {
        return HasFanSpeed.CC.$default$getHasGear4(this);
    }

    public SensorType getLastSelectedSensorType() {
        return HasSensorData.CC.$default$getLastSelectedSensorType(this);
    }

    public int getLeftSeconds() {
        return HasTimer.CC.$default$getLeftSeconds(this);
    }

    public int getRealTimerLeftTime(long j) {
        return HasTimer.CC.$default$getRealTimerLeftTime(this, j);
    }

    public TimeZone getTimezone(Context context) {
        return Device.CC.$default$getTimezone(this, context);
    }

    public FilterTrigger getTrigger() {
        return HasFanSpeed.CC.$default$getTrigger(this);
    }

    public DeviceType getType() {
        return Device.CC.$default$getType(this);
    }

    public UiAutoMode getUiAutoMode() {
        return HasFanSpeed.CC.$default$getUiAutoMode(this);
    }

    public UiG4NightMode getUiG4NightMode() {
        return HasG4NightMode.CC.$default$getUiG4NightMode(this);
    }

    public boolean isInApSubMode(ApSubMode apSubMode2) {
        return HasMainMode.CC.$default$isInApSubMode(this, apSubMode2);
    }

    public boolean isInDehSubMode(DehSubMode dehSubMode2) {
        return HasDehumidifierMainMode.CC.$default$isInDehSubMode(this, dehSubMode2);
    }

    public boolean isInMainMode(MainMode mainMode2) {
        return HasMainMode.CC.$default$isInMainMode(this, mainMode2);
    }

    public boolean isInWaterLevel(WaterLevel waterLevel2) {
        return HasWaterLevel.CC.$default$isInWaterLevel(this, waterLevel2);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public MainMode mainMode() {
        return HasMainMode.CC.$default$mainMode(this);
    }

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public TimerState timerStatus() {
        return HasTimer.CC.$default$timerStatus(this);
    }

    public WaterLevel waterLevel() {
        return HasWaterLevel.CC.$default$waterLevel(this);
    }

    public DeviceDehumidifier(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, int i13, int i14, boolean z5) {
        String str19 = str;
        String str20 = str2;
        String str21 = str3;
        String str22 = str5;
        String str23 = str6;
        String str24 = str7;
        String str25 = str8;
        String str26 = str9;
        String str27 = str10;
        String str28 = str11;
        String str29 = str12;
        String str30 = str13;
        String str31 = str14;
        String str32 = str15;
        Intrinsics.checkNotNullParameter(str19, "uid");
        Intrinsics.checkNotNullParameter(str20, "name");
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        Intrinsics.checkNotNullParameter(str22, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str23, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str24, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str25, "hardware");
        Intrinsics.checkNotNullParameter(str26, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str27, "serial");
        Intrinsics.checkNotNullParameter(str28, "purchaseDate");
        Intrinsics.checkNotNullParameter(str29, "dealerName");
        Intrinsics.checkNotNullParameter(str30, "dealerCountry");
        Intrinsics.checkNotNullParameter(str31, "filterType");
        Intrinsics.checkNotNullParameter(str32, "filterTrigger");
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        String str33 = str17;
        Intrinsics.checkNotNullParameter(str33, "modelName");
        this.uid = str19;
        this.name = str20;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str21;
        this.info = str4;
        this.deviceUuid = deviceUuid2;
        this.hasFinishedOnboarding = z;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i3;
        this.isChildLockOn = z2;
        this.connectivityStatusIndex = i4;
        this.lastConnectivityInMillis = j;
        this.mac = str22;
        this.mcuFirmware = str23;
        this.wifiFirmware = str24;
        this.hardware = str25;
        this.timeZone = str26;
        this.serial = str27;
        this.purchaseDate = str28;
        this.dealerName = str29;
        this.dealerCountry = str30;
        this.filterType = str31;
        this.filterTrigger = str32;
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
        this.updateProgress = i5;
        this.isStandByOn = z3;
        this.isG4NightModeOn = z4;
        this.g4NightModeFilterTrigger = str16;
        this.modelName = str33;
        this.typeIndex = i6;
        this.sku = str18;
        this.timerStatus = i7;
        this.timerDuration = i8;
        this.timerLeftTime = i9;
        this.timerLeftTimeUpdateTime = j2;
        this.autoRh = i10;
        this.mainMode = i11;
        this.apSubMode = i12;
        this.dehSubMode = i13;
        this.waterLevel = i14;
        this.waterTankFailure = z5;
    }

    public String getUid() {
        return this.uid;
    }

    public /* synthetic */ DeviceDehumidifier(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, int i13, int i14, boolean z5, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        double[] dArr6;
        boolean z6;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        long j3;
        int i22;
        int i23;
        int i24;
        String str19;
        int i25;
        String str20;
        String str21;
        boolean z7;
        boolean z8;
        int i26;
        double[] dArr7;
        double[] dArr8;
        double[] dArr9;
        double[] dArr10;
        double[] dArr11;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        long j4;
        int i27;
        boolean z9;
        int i28;
        IndoorDatapoint indoorDatapoint2;
        boolean z10;
        DeviceUuid deviceUuid3;
        String str33;
        String str34;
        int i29;
        Integer num2;
        int i30;
        String str35;
        String str36;
        DeviceDehumidifier deviceDehumidifier;
        int i31 = i15;
        int i32 = i16;
        String str37 = (i31 & 2) != 0 ? "Pairing…" : str2;
        int i33 = (i31 & 4) != 0 ? 0 : i;
        Integer num3 = (i31 & 8) != 0 ? null : num;
        int i34 = (i31 & 16) != 0 ? 0 : i2;
        String str38 = "";
        String str39 = (i31 & 32) != 0 ? str38 : str3;
        String str40 = (i31 & 64) != 0 ? null : str4;
        DeviceUuid deviceUuid4 = (i31 & 128) != 0 ? null : deviceUuid2;
        boolean z11 = (i31 & 256) != 0 ? false : z;
        IndoorDatapoint indoorDatapoint3 = (i31 & 512) != 0 ? null : indoorDatapoint;
        int i35 = (i31 & 1024) != 0 ? 0 : i3;
        boolean z12 = (i31 & 2048) != 0 ? false : z2;
        int ordinal = (i31 & 4096) != 0 ? ConnectivityStatus.ONLINE.ordinal() : i4;
        long j5 = 0;
        long j6 = (i31 & 8192) != 0 ? 0 : j;
        String str41 = (i31 & 16384) != 0 ? str38 : str5;
        String str42 = (i31 & 32768) != 0 ? str38 : str6;
        String str43 = (i31 & 65536) != 0 ? str38 : str7;
        String str44 = (i31 & 131072) != 0 ? str38 : str8;
        String str45 = (i31 & 262144) != 0 ? str38 : str9;
        String str46 = (i31 & 524288) != 0 ? str38 : str10;
        String str47 = (i31 & 1048576) != 0 ? str38 : str11;
        String str48 = (i31 & 2097152) != 0 ? str38 : str12;
        String str49 = (i31 & 4194304) != 0 ? str38 : str13;
        String str50 = (i31 & 8388608) != 0 ? str38 : str14;
        String str51 = (i31 & 16777216) != 0 ? str38 : str15;
        String str52 = str37;
        if ((i31 & 33554432) != 0) {
            dArr6 = new double[0];
        } else {
            dArr6 = dArr;
        }
        double[] dArr12 = dArr6;
        double[] dArr13 = (i15 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? new double[0] : dArr2;
        double[] dArr14 = (i15 & 134217728) != 0 ? new double[0] : dArr3;
        double[] dArr15 = (i15 & 268435456) != 0 ? new double[0] : dArr4;
        double[] dArr16 = (i15 & 536870912) != 0 ? new double[0] : dArr5;
        int i36 = (i15 & 1073741824) != 0 ? 0 : i5;
        boolean z13 = (i15 & Integer.MIN_VALUE) != 0 ? false : z3;
        boolean z14 = (i32 & 1) != 0 ? false : z4;
        String str53 = (i32 & 2) != 0 ? str38 : str16;
        str38 = (i32 & 4) == 0 ? str17 : str38;
        int index = (i32 & 8) != 0 ? DeviceType.Dehumidifier.INSTANCE.getIndex() : i6;
        String str54 = (i32 & 16) != 0 ? null : str18;
        int i37 = (i32 & 32) != 0 ? 0 : i7;
        int i38 = (i32 & 64) != 0 ? 0 : i8;
        int i39 = (i32 & 128) != 0 ? 0 : i9;
        j5 = (i32 & 256) == 0 ? j2 : j5;
        int i40 = (i32 & 512) != 0 ? 50 : i10;
        int i41 = (i32 & 1024) != 0 ? 0 : i11;
        int i42 = (i32 & 2048) != 0 ? 2 : i12;
        int i43 = (i32 & 4096) != 0 ? 1 : i13;
        int i44 = (i32 & 8192) != 0 ? 0 : i14;
        if ((i32 & 16384) != 0) {
            z6 = false;
            deviceDehumidifier = this;
            dArr11 = dArr12;
            dArr10 = dArr13;
            dArr9 = dArr14;
            dArr8 = dArr15;
            i22 = i39;
            i21 = i40;
            i20 = i41;
            i19 = i42;
            i18 = i43;
            str35 = str52;
            i17 = i44;
            dArr7 = dArr16;
            i30 = i33;
            str32 = str41;
            num2 = num3;
            i27 = ordinal;
            i29 = i34;
            str34 = str39;
            str20 = str38;
            str33 = str40;
            deviceUuid3 = deviceUuid4;
            z10 = z11;
            indoorDatapoint2 = indoorDatapoint3;
            i28 = i35;
            z9 = z12;
            j3 = j5;
            j4 = j6;
            str31 = str42;
            str30 = str43;
            str29 = str44;
            str28 = str45;
            str27 = str46;
            str26 = str47;
            str25 = str48;
            str24 = str49;
            str23 = str50;
            str22 = str51;
            i26 = i36;
            z8 = z13;
            z7 = z14;
            str21 = str53;
            i25 = index;
            str19 = str54;
            i24 = i37;
            i23 = i38;
            str36 = str;
        } else {
            z6 = z5;
            deviceDehumidifier = this;
            dArr11 = dArr12;
            dArr10 = dArr13;
            dArr9 = dArr14;
            dArr8 = dArr15;
            i22 = i39;
            i21 = i40;
            i20 = i41;
            i19 = i42;
            str35 = str52;
            i17 = i44;
            dArr7 = dArr16;
            i30 = i33;
            str32 = str41;
            num2 = num3;
            i27 = ordinal;
            i29 = i34;
            str34 = str39;
            str20 = str38;
            str33 = str40;
            deviceUuid3 = deviceUuid4;
            indoorDatapoint2 = indoorDatapoint3;
            i28 = i35;
            z9 = z12;
            j3 = j5;
            j4 = j6;
            str31 = str42;
            str30 = str43;
            str29 = str44;
            str28 = str45;
            str27 = str46;
            str26 = str47;
            str25 = str48;
            str24 = str49;
            str23 = str50;
            str22 = str51;
            i26 = i36;
            z8 = z13;
            z7 = z14;
            str21 = str53;
            i25 = index;
            str19 = str54;
            i24 = i37;
            i23 = i38;
            str36 = str;
            i18 = i43;
            z10 = z11;
        }
        new DeviceDehumidifier(str36, str35, i30, num2, i29, str34, str33, deviceUuid3, z10, indoorDatapoint2, i28, z9, i27, j4, str32, str31, str30, str29, str28, str27, str26, str25, str24, str23, str22, dArr11, dArr10, dArr9, dArr8, dArr7, i26, z8, z7, str21, str20, i25, str19, i24, i23, i22, j3, i21, i20, i19, i18, i17, z6);
    }

    public String getName() {
        return this.name;
    }

    public int getFanSpeed() {
        return this.fanSpeed;
    }

    public Integer getFilterLife() {
        return this.filterLife;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getAutoModeText() {
        return this.autoModeText;
    }

    public String getInfo() {
        return this.info;
    }

    public DeviceUuid getDeviceUuid() {
        return this.deviceUuid;
    }

    public boolean getHasFinishedOnboarding() {
        return this.hasFinishedOnboarding;
    }

    public IndoorDatapoint getLatestSensorDatapoint() {
        return this.latestSensorDatapoint;
    }

    public int getLastSelectedSensorTypeIndex() {
        return this.lastSelectedSensorTypeIndex;
    }

    public boolean isChildLockOn() {
        return this.isChildLockOn;
    }

    public int getConnectivityStatusIndex() {
        return this.connectivityStatusIndex;
    }

    public long getLastConnectivityInMillis() {
        return this.lastConnectivityInMillis;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public String getWifiFirmware() {
        return this.wifiFirmware;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getDealerName() {
        return this.dealerName;
    }

    public String getDealerCountry() {
        return this.dealerCountry;
    }

    public String getFilterType() {
        return this.filterType;
    }

    public String getFilterTrigger() {
        return this.filterTrigger;
    }

    public double[] getPm1Ranges() {
        return this.pm1Ranges;
    }

    public double[] getPm10Ranges() {
        return this.pm10Ranges;
    }

    public double[] getPm25Ranges() {
        return this.pm25Ranges;
    }

    public double[] getVocRanges() {
        return this.vocRanges;
    }

    public double[] getHchoRanges() {
        return this.hchoRanges;
    }

    public int getUpdateProgress() {
        return this.updateProgress;
    }

    public boolean isStandByOn() {
        return this.isStandByOn;
    }

    public boolean isG4NightModeOn() {
        return this.isG4NightModeOn;
    }

    public String getG4NightModeFilterTrigger() {
        return this.g4NightModeFilterTrigger;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public String getSku() {
        return this.sku;
    }

    public int getTimerStatus() {
        return this.timerStatus;
    }

    public int getTimerDuration() {
        return this.timerDuration;
    }

    public int getTimerLeftTime() {
        return this.timerLeftTime;
    }

    public long getTimerLeftTimeUpdateTime() {
        return this.timerLeftTimeUpdateTime;
    }

    public int getAutoRh() {
        return this.autoRh;
    }

    public int getMainMode() {
        return this.mainMode;
    }

    public int getApSubMode() {
        return this.apSubMode;
    }

    public int getDehSubMode() {
        return this.dehSubMode;
    }

    public int getWaterLevel() {
        return this.waterLevel;
    }

    public boolean getWaterTankFailure() {
        return this.waterTankFailure;
    }
}
