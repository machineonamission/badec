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
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWick;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\f\n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u0014B¹\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020\u0019\u0012\b\b\u0002\u0010%\u001a\u00020!\u0012\b\b\u0002\u0010&\u001a\u00020\u0019\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\b\b\u0002\u0010)\u001a\u00020\u0016\u0012\b\b\u0002\u0010*\u001a\u00020\u0016\u0012\b\b\u0002\u0010+\u001a\u00020\u0016\u0012\b\b\u0002\u0010,\u001a\u00020\u0016\u0012\b\b\u0002\u0010-\u001a\u00020\u0016\u0012\b\b\u0002\u0010.\u001a\u00020\u0016\u0012\b\b\u0002\u0010/\u001a\u00020\u0016\u0012\b\b\u0002\u00100\u001a\u00020\u0016\u0012\b\b\u0002\u00101\u001a\u00020\u0016\u0012\b\b\u0002\u00102\u001a\u00020\u0016\u0012\b\b\u0002\u00103\u001a\u00020\u0016\u0012\b\b\u0002\u00104\u001a\u000205\u0012\b\b\u0002\u00106\u001a\u000205\u0012\b\b\u0002\u00107\u001a\u000205\u0012\b\b\u0002\u00108\u001a\u000205\u0012\b\b\u0002\u00109\u001a\u000205\u0012\b\b\u0002\u0010:\u001a\u00020\u0019\u0012\b\b\u0002\u0010;\u001a\u00020!\u0012\b\b\u0002\u0010<\u001a\u00020!\u0012\b\b\u0002\u0010=\u001a\u00020\u0016\u0012\b\b\u0002\u0010>\u001a\u00020\u0016\u0012\b\b\u0002\u0010?\u001a\u00020\u0019\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010C\u001a\u00020\u0019\u0012\b\b\u0002\u0010D\u001a\u00020\u0019\u0012\b\b\u0002\u0010E\u001a\u00020\u0019\u0012\b\b\u0002\u0010F\u001a\u00020(\u0012\b\b\u0002\u0010G\u001a\u00020!\u0012\b\b\u0002\u0010H\u001a\u00020!\u0012\b\b\u0002\u0010I\u001a\u00020\u0019\u0012\b\b\u0002\u0010J\u001a\u00020(\u0012\b\b\u0002\u0010K\u001a\u00020\u0019\u0012\b\b\u0002\u0010L\u001a\u00020!\u0012\b\b\u0002\u0010M\u001a\u00020\u0019\u0012\b\b\u0002\u0010N\u001a\u00020\u0019\u0012\b\b\u0002\u0010O\u001a\u00020\u0019\u0012\b\b\u0002\u0010P\u001a\u00020!\u0012\b\b\u0002\u0010Q\u001a\u00020\u0019\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010S\u001a\u00020\u0019¢\u0006\u0004\bT\u0010UJ\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0019HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010\\J\n\u0010\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\n\u0010\u0001\u001a\u00020!HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010¡\u0001\u001a\u00020!HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010£\u0001\u001a\u00020(HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¯\u0001\u001a\u000205HÆ\u0003J\n\u0010°\u0001\u001a\u000205HÆ\u0003J\n\u0010±\u0001\u001a\u000205HÆ\u0003J\n\u0010²\u0001\u001a\u000205HÆ\u0003J\n\u0010³\u0001\u001a\u000205HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010µ\u0001\u001a\u00020!HÆ\u0003J\n\u0010¶\u0001\u001a\u00020!HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0019HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010BHÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010¿\u0001\u001a\u00020(HÆ\u0003J\n\u0010À\u0001\u001a\u00020!HÆ\u0003J\n\u0010Á\u0001\u001a\u00020!HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020(HÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010Å\u0001\u001a\u00020!HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010É\u0001\u001a\u00020!HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0019HÆ\u0003J\u0012\u0010Ë\u0001\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0003\u0010\u0001J\n\u0010Ì\u0001\u001a\u00020\u0019HÆ\u0003JÄ\u0004\u0010Í\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00162\b\b\u0002\u0010,\u001a\u00020\u00162\b\b\u0002\u0010-\u001a\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00100\u001a\u00020\u00162\b\b\u0002\u00101\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020\u00162\b\b\u0002\u00103\u001a\u00020\u00162\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002052\b\b\u0002\u00107\u001a\u0002052\b\b\u0002\u00108\u001a\u0002052\b\b\u0002\u00109\u001a\u0002052\b\b\u0002\u0010:\u001a\u00020\u00192\b\b\u0002\u0010;\u001a\u00020!2\b\b\u0002\u0010<\u001a\u00020!2\b\b\u0002\u0010=\u001a\u00020\u00162\b\b\u0002\u0010>\u001a\u00020\u00162\b\b\u0002\u0010?\u001a\u00020\u00192\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u00192\b\b\u0002\u0010D\u001a\u00020\u00192\b\b\u0002\u0010E\u001a\u00020\u00192\b\b\u0002\u0010F\u001a\u00020(2\b\b\u0002\u0010G\u001a\u00020!2\b\b\u0002\u0010H\u001a\u00020!2\b\b\u0002\u0010I\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020(2\b\b\u0002\u0010K\u001a\u00020\u00192\b\b\u0002\u0010L\u001a\u00020!2\b\b\u0002\u0010M\u001a\u00020\u00192\b\b\u0002\u0010N\u001a\u00020\u00192\b\b\u0002\u0010O\u001a\u00020\u00192\b\b\u0002\u0010P\u001a\u00020!2\b\b\u0002\u0010Q\u001a\u00020\u00192\n\b\u0002\u0010R\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010S\u001a\u00020\u0019HÆ\u0001¢\u0006\u0003\u0010Î\u0001J\u0007\u0010Ï\u0001\u001a\u00020\u0019J\u0016\u0010Ð\u0001\u001a\u00020!2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u0001HÖ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0019HÖ\u0001J\n\u0010Ô\u0001\u001a\u00020\u0016HÖ\u0001J\u001b\u0010Õ\u0001\u001a\u00030Ö\u00012\b\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\u0019R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0014\u0010\u0017\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010WR\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\n\n\u0002\u0010]\u001a\u0004\b[\u0010\\R\u0014\u0010\u001b\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010ZR\u0014\u0010\u001c\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010WR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010WR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0016\u0010\"\u001a\u0004\u0018\u00010#X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0014\u0010$\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010ZR\u0014\u0010%\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010dR\u0014\u0010&\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010ZR\u0014\u0010'\u001a\u00020(X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0014\u0010)\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010WR\u0014\u0010*\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010WR\u0014\u0010+\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010WR\u0014\u0010,\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010WR\u0014\u0010-\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010WR\u0014\u0010.\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010WR\u0014\u0010/\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010WR\u0014\u00100\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010WR\u0014\u00101\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010WR\u0014\u00102\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010WR\u0014\u00103\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010WR\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0014\u00106\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010wR\u0014\u00107\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010wR\u0014\u00108\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010wR\u0014\u00109\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010wR\u0014\u0010:\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010ZR\u0014\u0010;\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010dR\u0014\u0010<\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010dR\u0014\u0010=\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010WR\u0014\u0010>\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010WR\u0014\u0010?\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010ZR\u0017\u0010@\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0018\u0010A\u001a\u0004\u0018\u00010BX\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010C\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010D\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010E\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010F\u001a\u00020(X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010jR\u0015\u0010G\u001a\u00020!X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0015\u0010H\u001a\u00020!X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0015\u0010I\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010J\u001a\u00020(X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010jR\u0015\u0010K\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010L\u001a\u00020!X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0015\u0010M\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010N\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010O\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u0015\u0010P\u001a\u00020!X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0015\u0010Q\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010ZR\u001b\u0010R\u001a\u0004\u0018\u00010!X\u0004¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010S\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010Z¨\u0006Ú\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceHumidifier20;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasWick;", "Lcom/blueair/core/model/HasMoodLamp;", "Lcom/blueair/core/model/HasWaterLevel;", "Lcom/blueair/core/model/HasWickDryDuration;", "Lcom/blueair/core/model/HasAutoRh;", "Lcom/blueair/core/model/HasRemoveYellowWater;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "waterLevel", "nightLampBrightness", "wickdryDuration", "wickdryDone", "autoRh", "ywrmEnabled", "ywrmUsage", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJZZIJIZIIIZILjava/lang/Boolean;I)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getWaterLevel", "getNightLampBrightness", "getWickdryDuration", "getWickdryDone", "getAutoRh", "getYwrmEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getYwrmUsage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJZZIJIZIIIZILjava/lang/Boolean;I)Lcom/blueair/core/model/DeviceHumidifier20;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceHumidifier20 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasTimer, HasWelcomeHome, HasWick, HasMoodLamp, HasWaterLevel, HasWickDryDuration, HasAutoRh, HasRemoveYellowWater {
    public static final Parcelable.Creator<DeviceHumidifier20> CREATOR = new Creator();
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
    private final int nightLampBrightness;
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
    private final boolean waterShortage;
    private final WelcomeHomeLocation welcomeHome;
    private final int wickUsage;
    private final boolean wickdryDone;
    private final int wickdryDuration;
    private final boolean wickdryEnabled;
    private final int wickdryLeftTime;
    private final long wickdryLeftTimeUpdateTime;
    private final boolean wickdryOn;
    private final String wifiFirmware;
    private final Boolean ywrmEnabled;
    private final int ywrmUsage;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceHumidifier20> {
        public final DeviceHumidifier20 createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
            boolean z5;
            boolean z6;
            Boolean bool;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            Boolean bool2;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z11 = parcel2.readInt() != 0;
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
            boolean z12 = z2;
            long readLong = parcel2.readLong();
            boolean z13 = z12;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z14 = z13;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z15 = z14;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z16 = z15;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z17 = z16;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z18 = z17;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z19 = z18;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z20 = z19;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z21 = z;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z22 = z20;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z4 = z21;
                z21 = z22;
            } else {
                z4 = z21;
            }
            if (parcel2.readInt() != 0) {
                z6 = z22;
                z5 = z4;
            } else {
                z6 = z22;
                z22 = z4;
                z5 = z22;
            }
            String readString16 = parcel2.readString();
            boolean z23 = z6;
            String readString17 = parcel2.readString();
            boolean z24 = z5;
            int readInt6 = parcel2.readInt();
            boolean z25 = z23;
            String readString18 = parcel2.readString();
            WelcomeHomeLocation createFromParcel3 = parcel2.readInt() == 0 ? null : WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            boolean z26 = z25;
            int readInt7 = parcel2.readInt();
            int readInt8 = parcel2.readInt();
            boolean z27 = z26;
            int readInt9 = parcel2.readInt();
            boolean z28 = z27;
            long readLong2 = parcel2.readLong();
            if (parcel2.readInt() != 0) {
                bool = null;
                z7 = z28;
            } else {
                bool = null;
                z7 = z24;
            }
            if (parcel2.readInt() != 0) {
                z8 = z28;
            } else {
                z8 = z28;
                z28 = z24;
            }
            Boolean bool3 = bool;
            int readInt10 = parcel2.readInt();
            boolean z29 = z8;
            long readLong3 = parcel2.readLong();
            Boolean bool4 = bool3;
            int readInt11 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z9 = z29;
            } else {
                z9 = z29;
                z29 = z24;
            }
            Boolean bool5 = bool4;
            int readInt12 = parcel2.readInt();
            boolean z30 = z9;
            int readInt13 = parcel2.readInt();
            Boolean bool6 = bool5;
            int readInt14 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z10 = z30;
            } else {
                z10 = z30;
                z30 = z24;
            }
            Boolean bool7 = bool6;
            int readInt15 = parcel2.readInt();
            if (parcel2.readInt() == 0) {
                bool2 = bool7;
            } else {
                if (parcel2.readInt() != 0) {
                    z24 = z10;
                }
                bool2 = Boolean.valueOf(z24);
            }
            return new DeviceHumidifier20(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z11, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z21, z22, readString16, readString17, readInt6, readString18, createFromParcel3, readInt7, readInt8, readInt9, readLong2, z7, z28, readInt10, readLong3, readInt11, z29, readInt12, readInt13, readInt14, z30, readInt15, bool2, parcel2.readInt());
        }

        public final DeviceHumidifier20[] newArray(int i) {
            return new DeviceHumidifier20[i];
        }
    }

    public static /* synthetic */ DeviceHumidifier20 copy$default(DeviceHumidifier20 deviceHumidifier20, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, int i9, long j2, boolean z5, boolean z6, int i10, long j3, int i11, boolean z7, int i12, int i13, int i14, boolean z8, int i15, Boolean bool, int i16, int i17, int i18, Object obj) {
        long j4;
        String str19;
        DeviceHumidifier20 deviceHumidifier202 = deviceHumidifier20;
        int i19 = i17;
        int i20 = i18;
        String str20 = (i19 & 1) != 0 ? deviceHumidifier202.uid : str;
        String str21 = (i19 & 2) != 0 ? deviceHumidifier202.name : str2;
        int i21 = (i19 & 4) != 0 ? deviceHumidifier202.fanSpeed : i;
        Integer num2 = (i19 & 8) != 0 ? deviceHumidifier202.filterLife : num;
        int i22 = (i19 & 16) != 0 ? deviceHumidifier202.brightness : i2;
        String str22 = (i19 & 32) != 0 ? deviceHumidifier202.autoModeText : str3;
        String str23 = (i19 & 64) != 0 ? deviceHumidifier202.info : str4;
        DeviceUuid deviceUuid3 = (i19 & 128) != 0 ? deviceHumidifier202.deviceUuid : deviceUuid2;
        boolean z9 = (i19 & 256) != 0 ? deviceHumidifier202.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint2 = (i19 & 512) != 0 ? deviceHumidifier202.latestSensorDatapoint : indoorDatapoint;
        int i23 = (i19 & 1024) != 0 ? deviceHumidifier202.lastSelectedSensorTypeIndex : i3;
        boolean z10 = (i19 & 2048) != 0 ? deviceHumidifier202.isChildLockOn : z2;
        int i24 = (i19 & 4096) != 0 ? deviceHumidifier202.connectivityStatusIndex : i4;
        String str24 = str20;
        String str25 = str21;
        long j5 = (i19 & 8192) != 0 ? deviceHumidifier202.lastConnectivityInMillis : j;
        String str26 = (i19 & 16384) != 0 ? deviceHumidifier202.mac : str5;
        String str27 = (i19 & 32768) != 0 ? deviceHumidifier202.mcuFirmware : str6;
        String str28 = (i19 & 65536) != 0 ? deviceHumidifier202.wifiFirmware : str7;
        String str29 = (i17 & 131072) != 0 ? deviceHumidifier202.hardware : str8;
        String str30 = (i17 & 262144) != 0 ? deviceHumidifier202.timeZone : str9;
        String str31 = (i17 & 524288) != 0 ? deviceHumidifier202.serial : str10;
        String str32 = (i17 & 1048576) != 0 ? deviceHumidifier202.purchaseDate : str11;
        String str33 = (i17 & 2097152) != 0 ? deviceHumidifier202.dealerName : str12;
        String str34 = (i17 & 4194304) != 0 ? deviceHumidifier202.dealerCountry : str13;
        String str35 = (i17 & 8388608) != 0 ? deviceHumidifier202.filterType : str14;
        String str36 = (i17 & 16777216) != 0 ? deviceHumidifier202.filterTrigger : str15;
        double[] dArr6 = (i17 & 33554432) != 0 ? deviceHumidifier202.pm1Ranges : dArr;
        double[] dArr7 = (i17 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceHumidifier202.pm10Ranges : dArr2;
        double[] dArr8 = (i17 & 134217728) != 0 ? deviceHumidifier202.pm25Ranges : dArr3;
        double[] dArr9 = (i17 & 268435456) != 0 ? deviceHumidifier202.vocRanges : dArr4;
        double[] dArr10 = (i17 & 536870912) != 0 ? deviceHumidifier202.hchoRanges : dArr5;
        int i25 = (i17 & 1073741824) != 0 ? deviceHumidifier202.updateProgress : i5;
        boolean z11 = (i17 & Integer.MIN_VALUE) != 0 ? deviceHumidifier202.isStandByOn : z3;
        boolean z12 = (i20 & 1) != 0 ? deviceHumidifier202.isG4NightModeOn : z4;
        String str37 = (i20 & 2) != 0 ? deviceHumidifier202.g4NightModeFilterTrigger : str16;
        String str38 = (i20 & 4) != 0 ? deviceHumidifier202.modelName : str17;
        int i26 = (i20 & 8) != 0 ? deviceHumidifier202.typeIndex : i6;
        String str39 = (i20 & 16) != 0 ? deviceHumidifier202.sku : str18;
        WelcomeHomeLocation welcomeHomeLocation2 = (i20 & 32) != 0 ? deviceHumidifier202.welcomeHome : welcomeHomeLocation;
        int i27 = (i20 & 64) != 0 ? deviceHumidifier202.timerStatus : i7;
        int i28 = (i20 & 128) != 0 ? deviceHumidifier202.timerDuration : i8;
        int i29 = (i20 & 256) != 0 ? deviceHumidifier202.timerLeftTime : i9;
        String str40 = str26;
        if ((i20 & 512) != 0) {
            str19 = str27;
            j4 = deviceHumidifier202.timerLeftTimeUpdateTime;
        } else {
            str19 = str27;
            j4 = j2;
        }
        return deviceHumidifier202.copy(str24, str25, i21, num2, i22, str22, str23, deviceUuid3, z9, indoorDatapoint2, i23, z10, i24, j5, str40, str19, str28, str29, str30, str31, str32, str33, str34, str35, str36, dArr6, dArr7, dArr8, dArr9, dArr10, i25, z11, z12, str37, str38, i26, str39, welcomeHomeLocation2, i27, i28, i29, j4, (i20 & 1024) != 0 ? deviceHumidifier202.wickdryEnabled : z5, (i20 & 2048) != 0 ? deviceHumidifier202.wickdryOn : z6, (i20 & 4096) != 0 ? deviceHumidifier202.wickdryLeftTime : i10, (i20 & 8192) != 0 ? deviceHumidifier202.wickdryLeftTimeUpdateTime : j3, (i20 & 16384) != 0 ? deviceHumidifier202.wickUsage : i11, (i20 & 32768) != 0 ? deviceHumidifier202.waterShortage : z7, (i20 & 65536) != 0 ? deviceHumidifier202.waterLevel : i12, (i20 & 131072) != 0 ? deviceHumidifier202.nightLampBrightness : i13, (i20 & 262144) != 0 ? deviceHumidifier202.wickdryDuration : i14, (i20 & 524288) != 0 ? deviceHumidifier202.wickdryDone : z8, (i20 & 1048576) != 0 ? deviceHumidifier202.autoRh : i15, (i20 & 2097152) != 0 ? deviceHumidifier202.ywrmEnabled : bool, (i20 & 4194304) != 0 ? deviceHumidifier202.ywrmUsage : i16);
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

    public final int component39() {
        return this.timerStatus;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final int component40() {
        return this.timerDuration;
    }

    public final int component41() {
        return this.timerLeftTime;
    }

    public final long component42() {
        return this.timerLeftTimeUpdateTime;
    }

    public final boolean component43() {
        return this.wickdryEnabled;
    }

    public final boolean component44() {
        return this.wickdryOn;
    }

    public final int component45() {
        return this.wickdryLeftTime;
    }

    public final long component46() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public final int component47() {
        return this.wickUsage;
    }

    public final boolean component48() {
        return this.waterShortage;
    }

    public final int component49() {
        return this.waterLevel;
    }

    public final int component5() {
        return this.brightness;
    }

    public final int component50() {
        return this.nightLampBrightness;
    }

    public final int component51() {
        return this.wickdryDuration;
    }

    public final boolean component52() {
        return this.wickdryDone;
    }

    public final int component53() {
        return this.autoRh;
    }

    public final Boolean component54() {
        return this.ywrmEnabled;
    }

    public final int component55() {
        return this.ywrmUsage;
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

    public final DeviceHumidifier20 copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, int i9, long j2, boolean z5, boolean z6, int i10, long j3, int i11, boolean z7, int i12, int i13, int i14, boolean z8, int i15, Boolean bool, int i16) {
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
        return new DeviceHumidifier20(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, str16, str17, i6, str18, welcomeHomeLocation, i7, i8, i9, j2, z5, z6, i10, j3, i11, z7, i12, i13, i14, z8, i15, bool, i16);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceHumidifier20)) {
            return false;
        }
        DeviceHumidifier20 deviceHumidifier20 = (DeviceHumidifier20) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceHumidifier20.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceHumidifier20.name) && this.fanSpeed == deviceHumidifier20.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceHumidifier20.filterLife) && this.brightness == deviceHumidifier20.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceHumidifier20.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceHumidifier20.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceHumidifier20.deviceUuid) && this.hasFinishedOnboarding == deviceHumidifier20.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceHumidifier20.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceHumidifier20.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceHumidifier20.isChildLockOn && this.connectivityStatusIndex == deviceHumidifier20.connectivityStatusIndex && this.lastConnectivityInMillis == deviceHumidifier20.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceHumidifier20.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceHumidifier20.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceHumidifier20.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceHumidifier20.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceHumidifier20.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceHumidifier20.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceHumidifier20.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceHumidifier20.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceHumidifier20.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceHumidifier20.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceHumidifier20.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceHumidifier20.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceHumidifier20.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceHumidifier20.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceHumidifier20.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceHumidifier20.hchoRanges) && this.updateProgress == deviceHumidifier20.updateProgress && this.isStandByOn == deviceHumidifier20.isStandByOn && this.isG4NightModeOn == deviceHumidifier20.isG4NightModeOn && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) deviceHumidifier20.g4NightModeFilterTrigger) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceHumidifier20.modelName) && this.typeIndex == deviceHumidifier20.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceHumidifier20.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceHumidifier20.welcomeHome) && this.timerStatus == deviceHumidifier20.timerStatus && this.timerDuration == deviceHumidifier20.timerDuration && this.timerLeftTime == deviceHumidifier20.timerLeftTime && this.timerLeftTimeUpdateTime == deviceHumidifier20.timerLeftTimeUpdateTime && this.wickdryEnabled == deviceHumidifier20.wickdryEnabled && this.wickdryOn == deviceHumidifier20.wickdryOn && this.wickdryLeftTime == deviceHumidifier20.wickdryLeftTime && this.wickdryLeftTimeUpdateTime == deviceHumidifier20.wickdryLeftTimeUpdateTime && this.wickUsage == deviceHumidifier20.wickUsage && this.waterShortage == deviceHumidifier20.waterShortage && this.waterLevel == deviceHumidifier20.waterLevel && this.nightLampBrightness == deviceHumidifier20.nightLampBrightness && this.wickdryDuration == deviceHumidifier20.wickdryDuration && this.wickdryDone == deviceHumidifier20.wickdryDone && this.autoRh == deviceHumidifier20.autoRh && Intrinsics.areEqual((Object) this.ywrmEnabled, (Object) deviceHumidifier20.ywrmEnabled) && this.ywrmUsage == deviceHumidifier20.ywrmUsage;
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
        int hashCode7 = (((((((((((((((((((((((((((((((hashCode6 + (welcomeHomeLocation == null ? 0 : welcomeHomeLocation.hashCode())) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryEnabled)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryOn)) * 31) + this.wickdryLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryLeftTimeUpdateTime)) * 31) + this.wickUsage) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterShortage)) * 31) + this.waterLevel) * 31) + this.nightLampBrightness) * 31) + this.wickdryDuration) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryDone)) * 31) + this.autoRh) * 31;
        Boolean bool = this.ywrmEnabled;
        if (bool != null) {
            i = bool.hashCode();
        }
        return ((hashCode7 + i) * 31) + this.ywrmUsage;
    }

    public String toString() {
        return "DeviceHumidifier20(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", wickdryEnabled=" + this.wickdryEnabled + ", wickdryOn=" + this.wickdryOn + ", wickdryLeftTime=" + this.wickdryLeftTime + ", wickdryLeftTimeUpdateTime=" + this.wickdryLeftTimeUpdateTime + ", wickUsage=" + this.wickUsage + ", waterShortage=" + this.waterShortage + ", waterLevel=" + this.waterLevel + ", nightLampBrightness=" + this.nightLampBrightness + ", wickdryDuration=" + this.wickdryDuration + ", wickdryDone=" + this.wickdryDone + ", autoRh=" + this.autoRh + ", ywrmEnabled=" + this.ywrmEnabled + ", ywrmUsage=" + this.ywrmUsage + ')';
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
        parcel.writeInt(this.timerStatus);
        parcel.writeInt(this.timerDuration);
        parcel.writeInt(this.timerLeftTime);
        parcel.writeLong(this.timerLeftTimeUpdateTime);
        parcel.writeInt(this.wickdryEnabled ? 1 : 0);
        parcel.writeInt(this.wickdryOn ? 1 : 0);
        parcel.writeInt(this.wickdryLeftTime);
        parcel.writeLong(this.wickdryLeftTimeUpdateTime);
        parcel.writeInt(this.wickUsage);
        parcel.writeInt(this.waterShortage ? 1 : 0);
        parcel.writeInt(this.waterLevel);
        parcel.writeInt(this.nightLampBrightness);
        parcel.writeInt(this.wickdryDuration);
        parcel.writeInt(this.wickdryDone ? 1 : 0);
        parcel.writeInt(this.autoRh);
        Boolean bool = this.ywrmEnabled;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.ywrmUsage);
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

    public int getRefresherLifeLeft() {
        return HasRemoveYellowWater.CC.$default$getRefresherLifeLeft(this);
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

    public boolean isInWaterLevel(WaterLevel waterLevel2) {
        return HasWaterLevel.CC.$default$isInWaterLevel(this, waterLevel2);
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

    public WaterLevel waterLevel() {
        return HasWaterLevel.CC.$default$waterLevel(this);
    }

    public DeviceHumidifier20(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, int i9, long j2, boolean z5, boolean z6, int i10, long j3, int i11, boolean z7, int i12, int i13, int i14, boolean z8, int i15, Boolean bool, int i16) {
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
        this.timerStatus = i7;
        this.timerDuration = i8;
        this.timerLeftTime = i9;
        this.timerLeftTimeUpdateTime = j2;
        this.wickdryEnabled = z5;
        this.wickdryOn = z6;
        this.wickdryLeftTime = i10;
        this.wickdryLeftTimeUpdateTime = j3;
        this.wickUsage = i11;
        this.waterShortage = z7;
        this.waterLevel = i12;
        this.nightLampBrightness = i13;
        this.wickdryDuration = i14;
        this.wickdryDone = z8;
        this.autoRh = i15;
        this.ywrmEnabled = bool;
        this.ywrmUsage = i16;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceHumidifier20(java.lang.String r49, java.lang.String r50, int r51, java.lang.Integer r52, int r53, java.lang.String r54, java.lang.String r55, com.blueair.core.model.DeviceUuid r56, boolean r57, com.blueair.core.model.IndoorDatapoint r58, int r59, boolean r60, int r61, long r62, java.lang.String r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.String r70, java.lang.String r71, java.lang.String r72, java.lang.String r73, java.lang.String r74, double[] r75, double[] r76, double[] r77, double[] r78, double[] r79, int r80, boolean r81, boolean r82, java.lang.String r83, java.lang.String r84, int r85, java.lang.String r86, com.blueair.core.model.WelcomeHomeLocation r87, int r88, int r89, int r90, long r91, boolean r93, boolean r94, int r95, long r96, int r98, boolean r99, int r100, int r101, int r102, boolean r103, int r104, java.lang.Boolean r105, int r106, int r107, int r108, kotlin.jvm.internal.DefaultConstructorMarker r109) {
        /*
            r48 = this;
            r0 = r107
            r1 = r108
            r2 = r0 & 2
            if (r2 == 0) goto L_0x000b
            java.lang.String r2 = "Pairing…"
            goto L_0x000d
        L_0x000b:
            r2 = r50
        L_0x000d:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0015
        L_0x0013:
            r3 = r51
        L_0x0015:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001b
            r5 = 0
            goto L_0x001d
        L_0x001b:
            r5 = r52
        L_0x001d:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0023
            r7 = 0
            goto L_0x0025
        L_0x0023:
            r7 = r53
        L_0x0025:
            r8 = r0 & 32
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x002d
            r8 = r9
            goto L_0x002f
        L_0x002d:
            r8 = r54
        L_0x002f:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0035
            r10 = 0
            goto L_0x0037
        L_0x0035:
            r10 = r55
        L_0x0037:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003d
            r11 = 0
            goto L_0x003f
        L_0x003d:
            r11 = r56
        L_0x003f:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0045
            r12 = 0
            goto L_0x0047
        L_0x0045:
            r12 = r57
        L_0x0047:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x004d
            r13 = 0
            goto L_0x004f
        L_0x004d:
            r13 = r58
        L_0x004f:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0055
            r14 = 0
            goto L_0x0057
        L_0x0055:
            r14 = r59
        L_0x0057:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x005d
            r15 = 0
            goto L_0x005f
        L_0x005d:
            r15 = r60
        L_0x005f:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006a
            com.blueair.core.model.ConnectivityStatus r6 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r6 = r6.ordinal()
            goto L_0x006c
        L_0x006a:
            r6 = r61
        L_0x006c:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            r16 = 0
            if (r4 == 0) goto L_0x0075
            r18 = r16
            goto L_0x0077
        L_0x0075:
            r18 = r62
        L_0x0077:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x007d
            r4 = r9
            goto L_0x007f
        L_0x007d:
            r4 = r64
        L_0x007f:
            r20 = 32768(0x8000, float:4.5918E-41)
            r21 = r0 & r20
            if (r21 == 0) goto L_0x0089
            r21 = r9
            goto L_0x008b
        L_0x0089:
            r21 = r65
        L_0x008b:
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = r0 & r22
            if (r23 == 0) goto L_0x0094
            r23 = r9
            goto L_0x0096
        L_0x0094:
            r23 = r66
        L_0x0096:
            r24 = 131072(0x20000, float:1.83671E-40)
            r25 = r0 & r24
            if (r25 == 0) goto L_0x009f
            r25 = r9
            goto L_0x00a1
        L_0x009f:
            r25 = r67
        L_0x00a1:
            r26 = 262144(0x40000, float:3.67342E-40)
            r27 = r0 & r26
            if (r27 == 0) goto L_0x00aa
            r27 = r9
            goto L_0x00ac
        L_0x00aa:
            r27 = r68
        L_0x00ac:
            r28 = 524288(0x80000, float:7.34684E-40)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00b5
            r28 = r9
            goto L_0x00b7
        L_0x00b5:
            r28 = r69
        L_0x00b7:
            r29 = 1048576(0x100000, float:1.469368E-39)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00c0
            r29 = r9
            goto L_0x00c2
        L_0x00c0:
            r29 = r70
        L_0x00c2:
            r30 = 2097152(0x200000, float:2.938736E-39)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00cb
            r30 = r9
            goto L_0x00cd
        L_0x00cb:
            r30 = r71
        L_0x00cd:
            r31 = 4194304(0x400000, float:5.877472E-39)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x00d6
            r31 = r9
            goto L_0x00d8
        L_0x00d6:
            r31 = r72
        L_0x00d8:
            r32 = 8388608(0x800000, float:1.17549435E-38)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x00e1
            r32 = r9
            goto L_0x00e3
        L_0x00e1:
            r32 = r73
        L_0x00e3:
            r33 = 16777216(0x1000000, float:2.3509887E-38)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x00ec
            r33 = r9
            goto L_0x00ee
        L_0x00ec:
            r33 = r74
        L_0x00ee:
            r34 = 33554432(0x2000000, float:9.403955E-38)
            r34 = r0 & r34
            r109 = r2
            r0 = 0
            if (r34 == 0) goto L_0x00fa
            double[] r2 = new double[r0]
            goto L_0x00fc
        L_0x00fa:
            r2 = r75
        L_0x00fc:
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            r34 = r107 & r34
            r51 = r2
            if (r34 == 0) goto L_0x0107
            double[] r2 = new double[r0]
            goto L_0x0109
        L_0x0107:
            r2 = r76
        L_0x0109:
            r34 = 134217728(0x8000000, float:3.85186E-34)
            r34 = r107 & r34
            r52 = r2
            if (r34 == 0) goto L_0x0114
            double[] r2 = new double[r0]
            goto L_0x0116
        L_0x0114:
            r2 = r77
        L_0x0116:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
            r34 = r107 & r34
            r53 = r2
            if (r34 == 0) goto L_0x0121
            double[] r2 = new double[r0]
            goto L_0x0123
        L_0x0121:
            r2 = r78
        L_0x0123:
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            r34 = r107 & r34
            r54 = r2
            if (r34 == 0) goto L_0x012e
            double[] r2 = new double[r0]
            goto L_0x0130
        L_0x012e:
            r2 = r79
        L_0x0130:
            r34 = 1073741824(0x40000000, float:2.0)
            r34 = r107 & r34
            if (r34 == 0) goto L_0x0139
            r34 = r0
            goto L_0x013b
        L_0x0139:
            r34 = r80
        L_0x013b:
            r35 = -2147483648(0xffffffff80000000, float:-0.0)
            r35 = r107 & r35
            if (r35 == 0) goto L_0x0144
            r35 = r0
            goto L_0x0146
        L_0x0144:
            r35 = r81
        L_0x0146:
            r36 = r1 & 1
            if (r36 == 0) goto L_0x014d
            r36 = r0
            goto L_0x014f
        L_0x014d:
            r36 = r82
        L_0x014f:
            r37 = r1 & 2
            if (r37 == 0) goto L_0x0156
            r37 = r9
            goto L_0x0158
        L_0x0156:
            r37 = r83
        L_0x0158:
            r38 = r1 & 4
            if (r38 == 0) goto L_0x015d
            goto L_0x015f
        L_0x015d:
            r9 = r84
        L_0x015f:
            r38 = r1 & 8
            if (r38 == 0) goto L_0x016a
            com.blueair.core.model.DeviceType$Humidifier20 r38 = com.blueair.core.model.DeviceType.Humidifier20.INSTANCE
            int r38 = r38.getIndex()
            goto L_0x016c
        L_0x016a:
            r38 = r85
        L_0x016c:
            r39 = r1 & 16
            if (r39 == 0) goto L_0x0173
            r39 = 0
            goto L_0x0175
        L_0x0173:
            r39 = r86
        L_0x0175:
            r40 = r1 & 32
            if (r40 == 0) goto L_0x017c
            r40 = 0
            goto L_0x017e
        L_0x017c:
            r40 = r87
        L_0x017e:
            r41 = r1 & 64
            if (r41 == 0) goto L_0x0185
            r41 = r0
            goto L_0x0187
        L_0x0185:
            r41 = r88
        L_0x0187:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018d
            r0 = 0
            goto L_0x018f
        L_0x018d:
            r0 = r89
        L_0x018f:
            r56 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0197
            r0 = 0
            goto L_0x0199
        L_0x0197:
            r0 = r90
        L_0x0199:
            r57 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01a2
            r42 = r16
            goto L_0x01a4
        L_0x01a2:
            r42 = r91
        L_0x01a4:
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01aa
            r0 = 0
            goto L_0x01ac
        L_0x01aa:
            r0 = r93
        L_0x01ac:
            r58 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01b4
            r0 = 0
            goto L_0x01b6
        L_0x01b4:
            r0 = r94
        L_0x01b6:
            r59 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01be
            r0 = 0
            goto L_0x01c0
        L_0x01be:
            r0 = r95
        L_0x01c0:
            r60 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01c7
            goto L_0x01c9
        L_0x01c7:
            r16 = r96
        L_0x01c9:
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01cf
            r0 = 0
            goto L_0x01d1
        L_0x01cf:
            r0 = r98
        L_0x01d1:
            r20 = r1 & r20
            if (r20 == 0) goto L_0x01d8
            r20 = 0
            goto L_0x01da
        L_0x01d8:
            r20 = r99
        L_0x01da:
            r22 = r1 & r22
            if (r22 == 0) goto L_0x01e1
            r22 = 0
            goto L_0x01e3
        L_0x01e1:
            r22 = r100
        L_0x01e3:
            r24 = r1 & r24
            if (r24 == 0) goto L_0x01ea
            r24 = 0
            goto L_0x01ec
        L_0x01ea:
            r24 = r101
        L_0x01ec:
            r26 = r1 & r26
            if (r26 == 0) goto L_0x01f3
            r26 = 0
            goto L_0x01f5
        L_0x01f3:
            r26 = r102
        L_0x01f5:
            r44 = 524288(0x80000, float:7.34684E-40)
            r44 = r1 & r44
            if (r44 == 0) goto L_0x01fe
            r44 = 0
            goto L_0x0200
        L_0x01fe:
            r44 = r103
        L_0x0200:
            r45 = 1048576(0x100000, float:1.469368E-39)
            r45 = r1 & r45
            if (r45 == 0) goto L_0x0209
            r45 = 50
            goto L_0x020b
        L_0x0209:
            r45 = r104
        L_0x020b:
            r46 = 2097152(0x200000, float:2.938736E-39)
            r46 = r1 & r46
            if (r46 == 0) goto L_0x0214
            r46 = 0
            goto L_0x0216
        L_0x0214:
            r46 = r105
        L_0x0216:
            r47 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r47
            if (r1 == 0) goto L_0x021f
            r108 = 0
            goto L_0x0221
        L_0x021f:
            r108 = r106
        L_0x0221:
            r50 = r48
            r77 = r51
            r78 = r52
            r79 = r53
            r80 = r54
            r91 = r56
            r92 = r57
            r95 = r58
            r96 = r59
            r97 = r60
            r52 = r109
            r100 = r0
            r81 = r2
            r53 = r3
            r66 = r4
            r54 = r5
            r63 = r6
            r55 = r7
            r56 = r8
            r86 = r9
            r57 = r10
            r58 = r11
            r59 = r12
            r60 = r13
            r61 = r14
            r62 = r15
            r98 = r16
            r64 = r18
            r101 = r20
            r67 = r21
            r102 = r22
            r68 = r23
            r103 = r24
            r69 = r25
            r104 = r26
            r70 = r27
            r71 = r28
            r72 = r29
            r73 = r30
            r74 = r31
            r75 = r32
            r76 = r33
            r82 = r34
            r83 = r35
            r84 = r36
            r85 = r37
            r87 = r38
            r88 = r39
            r89 = r40
            r90 = r41
            r93 = r42
            r105 = r44
            r106 = r45
            r107 = r46
            r51 = r49
            r50.<init>(r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r95, r96, r97, r98, r100, r101, r102, r103, r104, r105, r106, r107, r108)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceHumidifier20.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, int, int, int, long, boolean, boolean, int, long, int, boolean, int, int, int, boolean, int, java.lang.Boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public int getWaterLevel() {
        return this.waterLevel;
    }

    public int getNightLampBrightness() {
        return this.nightLampBrightness;
    }

    public int getWickdryDuration() {
        return this.wickdryDuration;
    }

    public boolean getWickdryDone() {
        return this.wickdryDone;
    }

    public int getAutoRh() {
        return this.autoRh;
    }

    public Boolean getYwrmEnabled() {
        return this.ywrmEnabled;
    }

    public int getYwrmUsage() {
        return this.ywrmUsage;
    }
}
