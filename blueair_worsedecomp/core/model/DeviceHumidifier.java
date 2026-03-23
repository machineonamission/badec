package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWick;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b{\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u0010Bû\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020\u0012\u0012\b\b\u0002\u0010&\u001a\u00020\u0012\u0012\b\b\u0002\u0010'\u001a\u00020\u0012\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\b\b\u0002\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\b\b\u0002\u0010+\u001a\u00020\u0012\u0012\b\b\u0002\u0010,\u001a\u00020\u0012\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u0012\u0012\b\b\u0002\u00100\u001a\u000201\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u00103\u001a\u000201\u0012\b\b\u0002\u00104\u001a\u000201\u0012\b\b\u0002\u00105\u001a\u000201\u0012\b\b\u0002\u00106\u001a\u00020\u0015\u0012\b\b\u0002\u00107\u001a\u00020\u001d\u0012\b\b\u0002\u00108\u001a\u00020\u001d\u0012\b\b\u0002\u00109\u001a\u00020\u0012\u0012\b\b\u0002\u0010:\u001a\u00020\u0012\u0012\b\b\u0002\u0010;\u001a\u00020\u0015\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010?\u001a\u00020\u001d\u0012\b\b\u0002\u0010@\u001a\u00020\u001d\u0012\b\b\u0002\u0010A\u001a\u00020\u0015\u0012\b\b\u0002\u0010B\u001a\u00020$\u0012\b\b\u0002\u0010C\u001a\u00020\u0015\u0012\b\b\u0002\u0010D\u001a\u00020\u001d\u0012\b\b\u0002\u0010E\u001a\u00020\u0015\u0012\b\b\u0002\u0010F\u001a\u00020\u0015\u0012\b\b\u0002\u0010G\u001a\u00020\u0015\u0012\b\b\u0002\u0010H\u001a\u00020\u0015\u0012\b\b\u0002\u0010I\u001a\u00020$¢\u0006\u0004\bJ\u0010KJ\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010RJ\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001dHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020$HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010 \u0001\u001a\u000201HÆ\u0003J\n\u0010¡\u0001\u001a\u000201HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010>HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010«\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010­\u0001\u001a\u00020$HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010´\u0001\u001a\u00020$HÆ\u0003J\u0004\u0010µ\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u001d2\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u0010+\u001a\u00020\u00122\b\b\u0002\u0010,\u001a\u00020\u00122\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u0002012\b\b\u0002\u00105\u001a\u0002012\b\b\u0002\u00106\u001a\u00020\u00152\b\b\u0002\u00107\u001a\u00020\u001d2\b\b\u0002\u00108\u001a\u00020\u001d2\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u00152\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010?\u001a\u00020\u001d2\b\b\u0002\u0010@\u001a\u00020\u001d2\b\b\u0002\u0010A\u001a\u00020\u00152\b\b\u0002\u0010B\u001a\u00020$2\b\b\u0002\u0010C\u001a\u00020\u00152\b\b\u0002\u0010D\u001a\u00020\u001d2\b\b\u0002\u0010E\u001a\u00020\u00152\b\b\u0002\u0010F\u001a\u00020\u00152\b\b\u0002\u0010G\u001a\u00020\u00152\b\b\u0002\u0010H\u001a\u00020\u00152\b\b\u0002\u0010I\u001a\u00020$HÆ\u0001¢\u0006\u0003\u0010¶\u0001J\u0007\u0010·\u0001\u001a\u00020\u0015J\u0016\u0010¸\u0001\u001a\u00020\u001d2\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001HÖ\u0003J\n\u0010»\u0001\u001a\u00020\u0015HÖ\u0001J\n\u0010¼\u0001\u001a\u00020\u0012HÖ\u0001J\u001b\u0010½\u0001\u001a\u00030¾\u00012\b\u0010¿\u0001\u001a\u00030À\u00012\u0007\u0010Á\u0001\u001a\u00020\u0015R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0014\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010MR\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\n\n\u0002\u0010S\u001a\u0004\bQ\u0010RR\u0014\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010PR\u0014\u0010\u0018\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010MR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010MR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0014\u0010 \u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010PR\u0014\u0010!\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010ZR\u0014\u0010\"\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010PR\u0014\u0010#\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0014\u0010%\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010MR\u0014\u0010&\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010MR\u0014\u0010'\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010MR\u0014\u0010(\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010MR\u0014\u0010)\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010MR\u0014\u0010*\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010MR\u0014\u0010+\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010MR\u0014\u0010,\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010MR\u0014\u0010-\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010MR\u0014\u0010.\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010MR\u0014\u0010/\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010MR\u0014\u00100\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0014\u00102\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010mR\u0014\u00103\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010mR\u0014\u00104\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010mR\u0014\u00105\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010mR\u0014\u00106\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010PR\u0014\u00107\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010ZR\u0014\u00108\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010ZR\u0014\u00109\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010MR\u0014\u0010:\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010MR\u0014\u0010;\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010PR\u0016\u0010<\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010MR\u0016\u0010=\u001a\u0004\u0018\u00010>X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0014\u0010?\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010ZR\u0014\u0010@\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010ZR\u0014\u0010A\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010PR\u0014\u0010B\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010`R\u0014\u0010C\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010PR\u0014\u0010D\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010ZR\u0014\u0010E\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010PR\u0015\u0010F\u001a\u00020\u0015X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0015\u0010G\u001a\u00020\u0015X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0015\u0010H\u001a\u00020\u0015X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0015\u0010I\u001a\u00020$X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010`¨\u0006Â\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceHumidifier;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasWick;", "Lcom/blueair/core/model/HasAutoRh;", "Lcom/blueair/core/model/HasTimer;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJ)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJ)Lcom/blueair/core/model/DeviceHumidifier;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceHumidifier implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasWelcomeHome, HasWick, HasAutoRh, HasTimer {
    public static final Parcelable.Creator<DeviceHumidifier> CREATOR = new Creator();
    private final String autoModeText;
    private final int autoRh;
    private final int brightness;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
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
    private final boolean waterShortage;
    private final WelcomeHomeLocation welcomeHome;
    private final int wickUsage;
    private final boolean wickdryEnabled;
    private final int wickdryLeftTime;
    private final long wickdryLeftTimeUpdateTime;
    private final boolean wickdryOn;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceHumidifier> {
        public final DeviceHumidifier createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            WelcomeHomeLocation welcomeHomeLocation = null;
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z9 = parcel2.readInt() != 0;
            IndoorDatapoint createFromParcel2 = parcel2.readInt() == 0 ? null : IndoorDatapoint.CREATOR.createFromParcel(parcel2);
            int readInt3 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z2 = true;
                z = false;
                indoorDatapoint = createFromParcel2;
                z3 = true;
            } else {
                z2 = true;
                indoorDatapoint = createFromParcel2;
                z3 = false;
                z = false;
            }
            int readInt4 = parcel2.readInt();
            boolean z10 = z2;
            long readLong = parcel2.readLong();
            boolean z11 = z10;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z12 = z11;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z13 = z12;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z14 = z13;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z15 = z14;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z16 = z15;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z17 = z16;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z18 = z;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z19 = z17;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z20 = z18;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z21 = z19;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z4 = z20;
                z20 = z21;
            } else {
                z4 = z20;
            }
            if (parcel2.readInt() != 0) {
                z6 = z21;
                z5 = z4;
            } else {
                z6 = z21;
                z21 = z4;
                z5 = z21;
            }
            String readString16 = parcel2.readString();
            boolean z22 = z6;
            String readString17 = parcel2.readString();
            boolean z23 = z5;
            int readInt6 = parcel2.readInt();
            boolean z24 = z22;
            String readString18 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                welcomeHomeLocation = WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            }
            WelcomeHomeLocation welcomeHomeLocation2 = welcomeHomeLocation;
            if (parcel2.readInt() != 0) {
                z7 = z24;
            } else {
                z7 = z24;
                z24 = z23;
            }
            if (parcel2.readInt() != 0) {
                z8 = z7;
            } else {
                z8 = z7;
                z7 = z23;
            }
            boolean z25 = z8;
            int readInt7 = parcel2.readInt();
            long readLong2 = parcel2.readLong();
            boolean z26 = z25;
            int readInt8 = parcel2.readInt();
            if (parcel2.readInt() == 0) {
                z26 = z23;
            }
            return new DeviceHumidifier(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z9, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z20, z21, readString16, readString17, readInt6, readString18, welcomeHomeLocation2, z24, z7, readInt7, readLong2, readInt8, z26, parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readLong());
        }

        public final DeviceHumidifier[] newArray(int i) {
            return new DeviceHumidifier[i];
        }
    }

    public static /* synthetic */ DeviceHumidifier copy$default(DeviceHumidifier deviceHumidifier, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, boolean z5, boolean z6, int i7, long j2, int i8, boolean z7, int i9, int i10, int i11, int i12, long j3, int i13, int i14, Object obj) {
        long j4;
        String str19;
        long j5;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z8;
        int i19;
        long j6;
        int i20;
        boolean z9;
        boolean z10;
        WelcomeHomeLocation welcomeHomeLocation2;
        String str20;
        int i21;
        String str21;
        String str22;
        boolean z11;
        boolean z12;
        int i22;
        double[] dArr6;
        double[] dArr7;
        double[] dArr8;
        double[] dArr9;
        double[] dArr10;
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
        String str33;
        long j7;
        int i23;
        boolean z13;
        int i24;
        IndoorDatapoint indoorDatapoint2;
        boolean z14;
        DeviceUuid deviceUuid3;
        String str34;
        String str35;
        int i25;
        Integer num2;
        int i26;
        DeviceHumidifier deviceHumidifier2 = deviceHumidifier;
        int i27 = i13;
        int i28 = i14;
        String str36 = (i27 & 1) != 0 ? deviceHumidifier2.uid : str;
        String str37 = (i27 & 2) != 0 ? deviceHumidifier2.name : str2;
        int i29 = (i27 & 4) != 0 ? deviceHumidifier2.fanSpeed : i;
        Integer num3 = (i27 & 8) != 0 ? deviceHumidifier2.filterLife : num;
        int i30 = (i27 & 16) != 0 ? deviceHumidifier2.brightness : i2;
        String str38 = (i27 & 32) != 0 ? deviceHumidifier2.autoModeText : str3;
        String str39 = (i27 & 64) != 0 ? deviceHumidifier2.info : str4;
        DeviceUuid deviceUuid4 = (i27 & 128) != 0 ? deviceHumidifier2.deviceUuid : deviceUuid2;
        boolean z15 = (i27 & 256) != 0 ? deviceHumidifier2.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint3 = (i27 & 512) != 0 ? deviceHumidifier2.latestSensorDatapoint : indoorDatapoint;
        int i31 = (i27 & 1024) != 0 ? deviceHumidifier2.lastSelectedSensorTypeIndex : i3;
        boolean z16 = (i27 & 2048) != 0 ? deviceHumidifier2.isChildLockOn : z2;
        int i32 = (i27 & 4096) != 0 ? deviceHumidifier2.connectivityStatusIndex : i4;
        String str40 = str36;
        String str41 = str37;
        long j8 = (i27 & 8192) != 0 ? deviceHumidifier2.lastConnectivityInMillis : j;
        String str42 = (i27 & 16384) != 0 ? deviceHumidifier2.mac : str5;
        String str43 = (i27 & 32768) != 0 ? deviceHumidifier2.mcuFirmware : str6;
        String str44 = (i27 & 65536) != 0 ? deviceHumidifier2.wifiFirmware : str7;
        String str45 = (i13 & 131072) != 0 ? deviceHumidifier2.hardware : str8;
        String str46 = (i13 & 262144) != 0 ? deviceHumidifier2.timeZone : str9;
        String str47 = (i13 & 524288) != 0 ? deviceHumidifier2.serial : str10;
        String str48 = (i13 & 1048576) != 0 ? deviceHumidifier2.purchaseDate : str11;
        String str49 = (i13 & 2097152) != 0 ? deviceHumidifier2.dealerName : str12;
        String str50 = (i13 & 4194304) != 0 ? deviceHumidifier2.dealerCountry : str13;
        String str51 = (i13 & 8388608) != 0 ? deviceHumidifier2.filterType : str14;
        String str52 = (i13 & 16777216) != 0 ? deviceHumidifier2.filterTrigger : str15;
        double[] dArr11 = (i13 & 33554432) != 0 ? deviceHumidifier2.pm1Ranges : dArr;
        double[] dArr12 = (i13 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceHumidifier2.pm10Ranges : dArr2;
        double[] dArr13 = (i13 & 134217728) != 0 ? deviceHumidifier2.pm25Ranges : dArr3;
        double[] dArr14 = (i13 & 268435456) != 0 ? deviceHumidifier2.vocRanges : dArr4;
        double[] dArr15 = (i13 & 536870912) != 0 ? deviceHumidifier2.hchoRanges : dArr5;
        int i33 = (i13 & 1073741824) != 0 ? deviceHumidifier2.updateProgress : i5;
        boolean z17 = (i13 & Integer.MIN_VALUE) != 0 ? deviceHumidifier2.isStandByOn : z3;
        boolean z18 = (i28 & 1) != 0 ? deviceHumidifier2.isG4NightModeOn : z4;
        String str53 = (i28 & 2) != 0 ? deviceHumidifier2.g4NightModeFilterTrigger : str16;
        String str54 = (i28 & 4) != 0 ? deviceHumidifier2.modelName : str17;
        int i34 = (i28 & 8) != 0 ? deviceHumidifier2.typeIndex : i6;
        String str55 = (i28 & 16) != 0 ? deviceHumidifier2.sku : str18;
        WelcomeHomeLocation welcomeHomeLocation3 = (i28 & 32) != 0 ? deviceHumidifier2.welcomeHome : welcomeHomeLocation;
        boolean z19 = (i28 & 64) != 0 ? deviceHumidifier2.wickdryEnabled : z5;
        boolean z20 = (i28 & 128) != 0 ? deviceHumidifier2.wickdryOn : z6;
        int i35 = (i28 & 256) != 0 ? deviceHumidifier2.wickdryLeftTime : i7;
        String str56 = str42;
        if ((i28 & 512) != 0) {
            str19 = str43;
            j4 = deviceHumidifier2.wickdryLeftTimeUpdateTime;
        } else {
            str19 = str43;
            j4 = j2;
        }
        String str57 = str19;
        int i36 = (i28 & 1024) != 0 ? deviceHumidifier2.wickUsage : i8;
        boolean z21 = (i28 & 2048) != 0 ? deviceHumidifier2.waterShortage : z7;
        int i37 = (i28 & 4096) != 0 ? deviceHumidifier2.autoRh : i9;
        int i38 = (i28 & 8192) != 0 ? deviceHumidifier2.timerStatus : i10;
        int i39 = (i28 & 16384) != 0 ? deviceHumidifier2.timerDuration : i11;
        int i40 = (i28 & 32768) != 0 ? deviceHumidifier2.timerLeftTime : i12;
        if ((i28 & 65536) != 0) {
            String str58 = str57;
            dArr7 = dArr14;
            str32 = str58;
            i15 = i40;
            j5 = deviceHumidifier2.timerLeftTimeUpdateTime;
            i16 = i39;
            str21 = str54;
            i21 = i34;
            str20 = str55;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            z10 = z19;
            z9 = z20;
            i20 = i35;
            i19 = i36;
            z8 = z21;
            i18 = i37;
            i17 = i38;
            j6 = j4;
            num2 = num3;
            str26 = str49;
            str25 = str50;
            str24 = str51;
            str23 = str52;
            dArr10 = dArr11;
            dArr9 = dArr12;
            dArr8 = dArr13;
            dArr6 = dArr15;
            i22 = i33;
            z12 = z17;
            z11 = z18;
            str22 = str53;
            str33 = str56;
            indoorDatapoint2 = indoorDatapoint3;
            i24 = i31;
            z13 = z16;
            i23 = i32;
            j7 = j8;
            str31 = str44;
            str30 = str45;
            str29 = str46;
            str28 = str47;
            str27 = str48;
            i26 = i29;
            i25 = i30;
            str35 = str38;
            str34 = str39;
            deviceUuid3 = deviceUuid4;
            z14 = z15;
        } else {
            String str59 = str57;
            dArr7 = dArr14;
            str32 = str59;
            j5 = j3;
            i15 = i40;
            i16 = i39;
            str22 = str53;
            str21 = str54;
            i21 = i34;
            str20 = str55;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            z10 = z19;
            z9 = z20;
            i20 = i35;
            i19 = i36;
            z8 = z21;
            i18 = i37;
            i17 = i38;
            j6 = j4;
            num2 = num3;
            str27 = str48;
            str26 = str49;
            str25 = str50;
            str24 = str51;
            str23 = str52;
            dArr10 = dArr11;
            dArr9 = dArr12;
            dArr8 = dArr13;
            dArr6 = dArr15;
            i22 = i33;
            z12 = z17;
            z11 = z18;
            str33 = str56;
            z14 = z15;
            indoorDatapoint2 = indoorDatapoint3;
            i24 = i31;
            z13 = z16;
            i23 = i32;
            j7 = j8;
            str31 = str44;
            str30 = str45;
            str29 = str46;
            str28 = str47;
            i26 = i29;
            i25 = i30;
            str35 = str38;
            str34 = str39;
            deviceUuid3 = deviceUuid4;
        }
        return deviceHumidifier2.copy(str40, str41, i26, num2, i25, str35, str34, deviceUuid3, z14, indoorDatapoint2, i24, z13, i23, j7, str33, str32, str31, str30, str29, str28, str27, str26, str25, str24, str23, dArr10, dArr9, dArr8, dArr7, dArr6, i22, z12, z11, str22, str21, i21, str20, welcomeHomeLocation2, z10, z9, i20, j6, i19, z8, i18, i17, i16, i15, j5);
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

    public final WelcomeHomeLocation component38() {
        return this.welcomeHome;
    }

    public final boolean component39() {
        return this.wickdryEnabled;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final boolean component40() {
        return this.wickdryOn;
    }

    public final int component41() {
        return this.wickdryLeftTime;
    }

    public final long component42() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public final int component43() {
        return this.wickUsage;
    }

    public final boolean component44() {
        return this.waterShortage;
    }

    public final int component45() {
        return this.autoRh;
    }

    public final int component46() {
        return this.timerStatus;
    }

    public final int component47() {
        return this.timerDuration;
    }

    public final int component48() {
        return this.timerLeftTime;
    }

    public final long component49() {
        return this.timerLeftTimeUpdateTime;
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

    public final DeviceHumidifier copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, boolean z5, boolean z6, int i7, long j2, int i8, boolean z7, int i9, int i10, int i11, int i12, long j3) {
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
        return new DeviceHumidifier(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, str16, str17, i6, str18, welcomeHomeLocation, z5, z6, i7, j2, i8, z7, i9, i10, i11, i12, j3);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceHumidifier)) {
            return false;
        }
        DeviceHumidifier deviceHumidifier = (DeviceHumidifier) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceHumidifier.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceHumidifier.name) && this.fanSpeed == deviceHumidifier.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceHumidifier.filterLife) && this.brightness == deviceHumidifier.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceHumidifier.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceHumidifier.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceHumidifier.deviceUuid) && this.hasFinishedOnboarding == deviceHumidifier.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceHumidifier.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceHumidifier.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceHumidifier.isChildLockOn && this.connectivityStatusIndex == deviceHumidifier.connectivityStatusIndex && this.lastConnectivityInMillis == deviceHumidifier.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceHumidifier.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceHumidifier.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceHumidifier.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceHumidifier.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceHumidifier.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceHumidifier.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceHumidifier.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceHumidifier.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceHumidifier.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceHumidifier.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceHumidifier.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceHumidifier.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceHumidifier.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceHumidifier.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceHumidifier.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceHumidifier.hchoRanges) && this.updateProgress == deviceHumidifier.updateProgress && this.isStandByOn == deviceHumidifier.isStandByOn && this.isG4NightModeOn == deviceHumidifier.isG4NightModeOn && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) deviceHumidifier.g4NightModeFilterTrigger) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceHumidifier.modelName) && this.typeIndex == deviceHumidifier.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceHumidifier.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceHumidifier.welcomeHome) && this.wickdryEnabled == deviceHumidifier.wickdryEnabled && this.wickdryOn == deviceHumidifier.wickdryOn && this.wickdryLeftTime == deviceHumidifier.wickdryLeftTime && this.wickdryLeftTimeUpdateTime == deviceHumidifier.wickdryLeftTimeUpdateTime && this.wickUsage == deviceHumidifier.wickUsage && this.waterShortage == deviceHumidifier.waterShortage && this.autoRh == deviceHumidifier.autoRh && this.timerStatus == deviceHumidifier.timerStatus && this.timerDuration == deviceHumidifier.timerDuration && this.timerLeftTime == deviceHumidifier.timerLeftTime && this.timerLeftTimeUpdateTime == deviceHumidifier.timerLeftTimeUpdateTime;
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
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        if (welcomeHomeLocation != null) {
            i = welcomeHomeLocation.hashCode();
        }
        return ((((((((((((((((((((((hashCode6 + i) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryEnabled)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryOn)) * 31) + this.wickdryLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryLeftTimeUpdateTime)) * 31) + this.wickUsage) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterShortage)) * 31) + this.autoRh) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime);
    }

    public String toString() {
        return "DeviceHumidifier(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ", wickdryEnabled=" + this.wickdryEnabled + ", wickdryOn=" + this.wickdryOn + ", wickdryLeftTime=" + this.wickdryLeftTime + ", wickdryLeftTimeUpdateTime=" + this.wickdryLeftTimeUpdateTime + ", wickUsage=" + this.wickUsage + ", waterShortage=" + this.waterShortage + ", autoRh=" + this.autoRh + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ')';
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
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        if (welcomeHomeLocation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            welcomeHomeLocation.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.wickdryEnabled ? 1 : 0);
        parcel.writeInt(this.wickdryOn ? 1 : 0);
        parcel.writeInt(this.wickdryLeftTime);
        parcel.writeLong(this.wickdryLeftTimeUpdateTime);
        parcel.writeInt(this.wickUsage);
        parcel.writeInt(this.waterShortage ? 1 : 0);
        parcel.writeInt(this.autoRh);
        parcel.writeInt(this.timerStatus);
        parcel.writeInt(this.timerDuration);
        parcel.writeInt(this.timerLeftTime);
        parcel.writeLong(this.timerLeftTimeUpdateTime);
    }

    public double[] airRatingsFor(SensorType sensorType) {
        return HasSensorData.CC.$default$airRatingsFor(this, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(double d, SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, d, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, sensorType);
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

    public int getWickDryLeftSeconds() {
        return HasWick.CC.$default$getWickDryLeftSeconds(this);
    }

    public int getWickLifeLeft() {
        return HasWick.CC.$default$getWickLifeLeft(this);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public TimerState timerStatus() {
        return HasTimer.CC.$default$timerStatus(this);
    }

    public DeviceHumidifier(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, boolean z5, boolean z6, int i7, long j2, int i8, boolean z7, int i9, int i10, int i11, int i12, long j3) {
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
        this.welcomeHome = welcomeHomeLocation;
        this.wickdryEnabled = z5;
        this.wickdryOn = z6;
        this.wickdryLeftTime = i7;
        this.wickdryLeftTimeUpdateTime = j2;
        this.wickUsage = i8;
        this.waterShortage = z7;
        this.autoRh = i9;
        this.timerStatus = i10;
        this.timerDuration = i11;
        this.timerLeftTime = i12;
        this.timerLeftTimeUpdateTime = j3;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceHumidifier(java.lang.String r43, java.lang.String r44, int r45, java.lang.Integer r46, int r47, java.lang.String r48, java.lang.String r49, com.blueair.core.model.DeviceUuid r50, boolean r51, com.blueair.core.model.IndoorDatapoint r52, int r53, boolean r54, int r55, long r56, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, java.lang.String r63, java.lang.String r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, double[] r69, double[] r70, double[] r71, double[] r72, double[] r73, int r74, boolean r75, boolean r76, java.lang.String r77, java.lang.String r78, int r79, java.lang.String r80, com.blueair.core.model.WelcomeHomeLocation r81, boolean r82, boolean r83, int r84, long r85, int r87, boolean r88, int r89, int r90, int r91, int r92, long r93, int r95, int r96, kotlin.jvm.internal.DefaultConstructorMarker r97) {
        /*
            r42 = this;
            r0 = r95
            r1 = r96
            r2 = r0 & 2
            if (r2 == 0) goto L_0x000b
            java.lang.String r2 = "Pairing…"
            goto L_0x000d
        L_0x000b:
            r2 = r44
        L_0x000d:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0015
        L_0x0013:
            r3 = r45
        L_0x0015:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001b
            r5 = 0
            goto L_0x001d
        L_0x001b:
            r5 = r46
        L_0x001d:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0023
            r7 = 0
            goto L_0x0025
        L_0x0023:
            r7 = r47
        L_0x0025:
            r8 = r0 & 32
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x002d
            r8 = r9
            goto L_0x002f
        L_0x002d:
            r8 = r48
        L_0x002f:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0035
            r10 = 0
            goto L_0x0037
        L_0x0035:
            r10 = r49
        L_0x0037:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003d
            r11 = 0
            goto L_0x003f
        L_0x003d:
            r11 = r50
        L_0x003f:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0045
            r12 = 0
            goto L_0x0047
        L_0x0045:
            r12 = r51
        L_0x0047:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x004d
            r13 = 0
            goto L_0x004f
        L_0x004d:
            r13 = r52
        L_0x004f:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0055
            r14 = 0
            goto L_0x0057
        L_0x0055:
            r14 = r53
        L_0x0057:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x005d
            r15 = 0
            goto L_0x005f
        L_0x005d:
            r15 = r54
        L_0x005f:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006a
            com.blueair.core.model.ConnectivityStatus r6 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r6 = r6.ordinal()
            goto L_0x006c
        L_0x006a:
            r6 = r55
        L_0x006c:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            r16 = 0
            if (r4 == 0) goto L_0x0075
            r18 = r16
            goto L_0x0077
        L_0x0075:
            r18 = r56
        L_0x0077:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x007d
            r4 = r9
            goto L_0x007f
        L_0x007d:
            r4 = r58
        L_0x007f:
            r20 = 32768(0x8000, float:4.5918E-41)
            r21 = r0 & r20
            if (r21 == 0) goto L_0x0089
            r21 = r9
            goto L_0x008b
        L_0x0089:
            r21 = r59
        L_0x008b:
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = r0 & r22
            if (r23 == 0) goto L_0x0094
            r23 = r9
            goto L_0x0096
        L_0x0094:
            r23 = r60
        L_0x0096:
            r24 = 131072(0x20000, float:1.83671E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x009f
            r24 = r9
            goto L_0x00a1
        L_0x009f:
            r24 = r61
        L_0x00a1:
            r25 = 262144(0x40000, float:3.67342E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00aa
            r25 = r9
            goto L_0x00ac
        L_0x00aa:
            r25 = r62
        L_0x00ac:
            r26 = 524288(0x80000, float:7.34684E-40)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00b5
            r26 = r9
            goto L_0x00b7
        L_0x00b5:
            r26 = r63
        L_0x00b7:
            r27 = 1048576(0x100000, float:1.469368E-39)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00c0
            r27 = r9
            goto L_0x00c2
        L_0x00c0:
            r27 = r64
        L_0x00c2:
            r28 = 2097152(0x200000, float:2.938736E-39)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00cb
            r28 = r9
            goto L_0x00cd
        L_0x00cb:
            r28 = r65
        L_0x00cd:
            r29 = 4194304(0x400000, float:5.877472E-39)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00d6
            r29 = r9
            goto L_0x00d8
        L_0x00d6:
            r29 = r66
        L_0x00d8:
            r30 = 8388608(0x800000, float:1.17549435E-38)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00e1
            r30 = r9
            goto L_0x00e3
        L_0x00e1:
            r30 = r67
        L_0x00e3:
            r31 = 16777216(0x1000000, float:2.3509887E-38)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x00ec
            r31 = r9
            goto L_0x00ee
        L_0x00ec:
            r31 = r68
        L_0x00ee:
            r32 = 33554432(0x2000000, float:9.403955E-38)
            r32 = r0 & r32
            r97 = r2
            r0 = 0
            if (r32 == 0) goto L_0x00fa
            double[] r2 = new double[r0]
            goto L_0x00fc
        L_0x00fa:
            r2 = r69
        L_0x00fc:
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            r32 = r95 & r32
            r45 = r2
            if (r32 == 0) goto L_0x0107
            double[] r2 = new double[r0]
            goto L_0x0109
        L_0x0107:
            r2 = r70
        L_0x0109:
            r32 = 134217728(0x8000000, float:3.85186E-34)
            r32 = r95 & r32
            r46 = r2
            if (r32 == 0) goto L_0x0114
            double[] r2 = new double[r0]
            goto L_0x0116
        L_0x0114:
            r2 = r71
        L_0x0116:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
            r32 = r95 & r32
            r47 = r2
            if (r32 == 0) goto L_0x0121
            double[] r2 = new double[r0]
            goto L_0x0123
        L_0x0121:
            r2 = r72
        L_0x0123:
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            r32 = r95 & r32
            r48 = r2
            if (r32 == 0) goto L_0x012e
            double[] r2 = new double[r0]
            goto L_0x0130
        L_0x012e:
            r2 = r73
        L_0x0130:
            r32 = 1073741824(0x40000000, float:2.0)
            r32 = r95 & r32
            if (r32 == 0) goto L_0x0139
            r32 = r0
            goto L_0x013b
        L_0x0139:
            r32 = r74
        L_0x013b:
            r33 = -2147483648(0xffffffff80000000, float:-0.0)
            r33 = r95 & r33
            if (r33 == 0) goto L_0x0144
            r33 = r0
            goto L_0x0146
        L_0x0144:
            r33 = r75
        L_0x0146:
            r34 = r1 & 1
            if (r34 == 0) goto L_0x014d
            r34 = r0
            goto L_0x014f
        L_0x014d:
            r34 = r76
        L_0x014f:
            r35 = r1 & 2
            if (r35 == 0) goto L_0x0156
            r35 = r9
            goto L_0x0158
        L_0x0156:
            r35 = r77
        L_0x0158:
            r36 = r1 & 4
            if (r36 == 0) goto L_0x015d
            goto L_0x015f
        L_0x015d:
            r9 = r78
        L_0x015f:
            r36 = r1 & 8
            if (r36 == 0) goto L_0x016a
            com.blueair.core.model.DeviceType$Humidifier r36 = com.blueair.core.model.DeviceType.Humidifier.INSTANCE
            int r36 = r36.getIndex()
            goto L_0x016c
        L_0x016a:
            r36 = r79
        L_0x016c:
            r37 = r1 & 16
            if (r37 == 0) goto L_0x0173
            r37 = 0
            goto L_0x0175
        L_0x0173:
            r37 = r80
        L_0x0175:
            r38 = r1 & 32
            if (r38 == 0) goto L_0x017c
            r38 = 0
            goto L_0x017e
        L_0x017c:
            r38 = r81
        L_0x017e:
            r39 = r1 & 64
            if (r39 == 0) goto L_0x0185
            r39 = r0
            goto L_0x0187
        L_0x0185:
            r39 = r82
        L_0x0187:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018d
            r0 = 0
            goto L_0x018f
        L_0x018d:
            r0 = r83
        L_0x018f:
            r49 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0197
            r0 = 0
            goto L_0x0199
        L_0x0197:
            r0 = r84
        L_0x0199:
            r50 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01a2
            r40 = r16
            goto L_0x01a4
        L_0x01a2:
            r40 = r85
        L_0x01a4:
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01aa
            r0 = 0
            goto L_0x01ac
        L_0x01aa:
            r0 = r87
        L_0x01ac:
            r51 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01b4
            r0 = 0
            goto L_0x01b6
        L_0x01b4:
            r0 = r88
        L_0x01b6:
            r52 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01bf
            r0 = 50
            goto L_0x01c1
        L_0x01bf:
            r0 = r89
        L_0x01c1:
            r53 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01c9
            r0 = 0
            goto L_0x01cb
        L_0x01c9:
            r0 = r90
        L_0x01cb:
            r54 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01d3
            r0 = 0
            goto L_0x01d5
        L_0x01d3:
            r0 = r91
        L_0x01d5:
            r20 = r1 & r20
            if (r20 == 0) goto L_0x01dc
            r20 = 0
            goto L_0x01de
        L_0x01dc:
            r20 = r92
        L_0x01de:
            r1 = r1 & r22
            if (r1 == 0) goto L_0x01e5
            r95 = r16
            goto L_0x01e7
        L_0x01e5:
            r95 = r93
        L_0x01e7:
            r44 = r42
            r71 = r45
            r72 = r46
            r73 = r47
            r74 = r48
            r85 = r49
            r86 = r50
            r89 = r51
            r90 = r52
            r91 = r53
            r92 = r54
            r46 = r97
            r93 = r0
            r75 = r2
            r47 = r3
            r60 = r4
            r48 = r5
            r57 = r6
            r49 = r7
            r50 = r8
            r80 = r9
            r51 = r10
            r52 = r11
            r53 = r12
            r54 = r13
            r55 = r14
            r56 = r15
            r58 = r18
            r94 = r20
            r61 = r21
            r62 = r23
            r63 = r24
            r64 = r25
            r65 = r26
            r66 = r27
            r67 = r28
            r68 = r29
            r69 = r30
            r70 = r31
            r76 = r32
            r77 = r33
            r78 = r34
            r79 = r35
            r81 = r36
            r82 = r37
            r83 = r38
            r84 = r39
            r87 = r40
            r45 = r43
            r44.<init>(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r89, r90, r91, r92, r93, r94, r95)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceHumidifier.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, boolean, boolean, int, long, int, boolean, int, int, int, int, long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public WelcomeHomeLocation getWelcomeHome() {
        return this.welcomeHome;
    }

    public boolean getWickdryEnabled() {
        return this.wickdryEnabled;
    }

    public boolean getWickdryOn() {
        return this.wickdryOn;
    }

    public int getWickdryLeftTime() {
        return this.wickdryLeftTime;
    }

    public long getWickdryLeftTimeUpdateTime() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public int getWickUsage() {
        return this.wickUsage;
    }

    public boolean getWaterShortage() {
        return this.waterShortage;
    }

    public int getAutoRh() {
        return this.autoRh;
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
}
