package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMainMode;
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

@Metadata(d1 = {"\u0000µ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\n\n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u00152\u00020\u00162\u00020\u0017Bá\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0019\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010'\u001a\u00020\u001c\u0012\b\b\u0002\u0010(\u001a\u00020$\u0012\b\b\u0002\u0010)\u001a\u00020\u001c\u0012\b\b\u0002\u0010*\u001a\u00020+\u0012\b\b\u0002\u0010,\u001a\u00020\u0019\u0012\b\b\u0002\u0010-\u001a\u00020\u0019\u0012\b\b\u0002\u0010.\u001a\u00020\u0019\u0012\b\b\u0002\u0010/\u001a\u00020\u0019\u0012\b\b\u0002\u00100\u001a\u00020\u0019\u0012\b\b\u0002\u00101\u001a\u00020\u0019\u0012\b\b\u0002\u00102\u001a\u00020\u0019\u0012\b\b\u0002\u00103\u001a\u00020\u0019\u0012\b\b\u0002\u00104\u001a\u00020\u0019\u0012\b\b\u0002\u00105\u001a\u00020\u0019\u0012\b\b\u0002\u00106\u001a\u00020\u0019\u0012\b\b\u0002\u00107\u001a\u000208\u0012\b\b\u0002\u00109\u001a\u000208\u0012\b\b\u0002\u0010:\u001a\u000208\u0012\b\b\u0002\u0010;\u001a\u000208\u0012\b\b\u0002\u0010<\u001a\u000208\u0012\b\b\u0002\u0010=\u001a\u00020\u001c\u0012\b\b\u0002\u0010>\u001a\u00020$\u0012\b\b\u0002\u0010?\u001a\u00020\u0019\u0012\b\b\u0002\u0010@\u001a\u00020\u001c\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010D\u001a\u00020$\u0012\b\b\u0002\u0010E\u001a\u00020$\u0012\b\b\u0002\u0010F\u001a\u00020\u001c\u0012\b\b\u0002\u0010G\u001a\u00020+\u0012\b\b\u0002\u0010H\u001a\u00020\u001c\u0012\b\b\u0002\u0010I\u001a\u00020$\u0012\b\b\u0002\u0010J\u001a\u00020\u001c\u0012\b\b\u0002\u0010K\u001a\u00020\u001c\u0012\b\b\u0002\u0010L\u001a\u00020\u001c\u0012\b\b\u0002\u0010M\u001a\u00020\u001c\u0012\b\b\u0002\u0010N\u001a\u00020+\u0012\b\b\u0002\u0010O\u001a\u00020\u001c\u0012\b\b\u0002\u0010P\u001a\u00020\u001c\u0012\b\b\u0002\u0010Q\u001a\u00020\u001c\u0012\b\b\u0002\u0010R\u001a\u00020$\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010T\u001a\u00020\u001c\u0012\b\b\u0002\u0010U\u001a\u00020\u001c\u0012\b\b\u0002\u0010V\u001a\u00020\u001c\u0012\b\b\u0002\u0010W\u001a\u00020\u001c\u0012\b\b\u0002\u0010X\u001a\u00020$\u0012\b\b\u0002\u0010Y\u001a\u00020$\u0012\b\b\u0002\u0010Z\u001a\u00020$¢\u0006\u0004\b[\u0010\\J\n\u0010¡\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u001cHÆ\u0003J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010cJ\n\u0010¥\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0019HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\n\u0010©\u0001\u001a\u00020$HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010¬\u0001\u001a\u00020$HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010®\u0001\u001a\u00020+HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010º\u0001\u001a\u000208HÆ\u0003J\n\u0010»\u0001\u001a\u000208HÆ\u0003J\n\u0010¼\u0001\u001a\u000208HÆ\u0003J\n\u0010½\u0001\u001a\u000208HÆ\u0003J\n\u0010¾\u0001\u001a\u000208HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010À\u0001\u001a\u00020$HÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0019HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u001cHÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010CHÆ\u0003J\n\u0010Å\u0001\u001a\u00020$HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020$HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010È\u0001\u001a\u00020+HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ê\u0001\u001a\u00020$HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ï\u0001\u001a\u00020+HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ó\u0001\u001a\u00020$HÆ\u0003J\u0012\u0010Ô\u0001\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0003\u0010\u0001J\n\u0010Õ\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010×\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010Ù\u0001\u001a\u00020$HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020$HÆ\u0003J\n\u0010Û\u0001\u001a\u00020$HÆ\u0003Jì\u0004\u0010Ü\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u00192\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u00192\b\b\u0002\u00100\u001a\u00020\u00192\b\b\u0002\u00101\u001a\u00020\u00192\b\b\u0002\u00102\u001a\u00020\u00192\b\b\u0002\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\u00192\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u0002082\b\b\u0002\u0010;\u001a\u0002082\b\b\u0002\u0010<\u001a\u0002082\b\b\u0002\u0010=\u001a\u00020\u001c2\b\b\u0002\u0010>\u001a\u00020$2\b\b\u0002\u0010?\u001a\u00020\u00192\b\b\u0002\u0010@\u001a\u00020\u001c2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010D\u001a\u00020$2\b\b\u0002\u0010E\u001a\u00020$2\b\b\u0002\u0010F\u001a\u00020\u001c2\b\b\u0002\u0010G\u001a\u00020+2\b\b\u0002\u0010H\u001a\u00020\u001c2\b\b\u0002\u0010I\u001a\u00020$2\b\b\u0002\u0010J\u001a\u00020\u001c2\b\b\u0002\u0010K\u001a\u00020\u001c2\b\b\u0002\u0010L\u001a\u00020\u001c2\b\b\u0002\u0010M\u001a\u00020\u001c2\b\b\u0002\u0010N\u001a\u00020+2\b\b\u0002\u0010O\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020\u001c2\b\b\u0002\u0010Q\u001a\u00020\u001c2\b\b\u0002\u0010R\u001a\u00020$2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010T\u001a\u00020\u001c2\b\b\u0002\u0010U\u001a\u00020\u001c2\b\b\u0002\u0010V\u001a\u00020\u001c2\b\b\u0002\u0010W\u001a\u00020\u001c2\b\b\u0002\u0010X\u001a\u00020$2\b\b\u0002\u0010Y\u001a\u00020$2\b\b\u0002\u0010Z\u001a\u00020$HÆ\u0001¢\u0006\u0003\u0010Ý\u0001J\u0007\u0010Þ\u0001\u001a\u00020\u001cJ\u0016\u0010ß\u0001\u001a\u00020$2\n\u0010à\u0001\u001a\u0005\u0018\u00010á\u0001HÖ\u0003J\n\u0010â\u0001\u001a\u00020\u001cHÖ\u0001J\n\u0010ã\u0001\u001a\u00020\u0019HÖ\u0001J\u001b\u0010ä\u0001\u001a\u00030å\u00012\b\u0010æ\u0001\u001a\u00030ç\u00012\u0007\u0010è\u0001\u001a\u00020\u001cR\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0014\u0010\u001a\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010^R\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\n\n\u0002\u0010d\u001a\u0004\bb\u0010cR\u0014\u0010\u001e\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010aR\u0014\u0010\u001f\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010^R\u0016\u0010 \u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010^R\u0016\u0010!\u001a\u0004\u0018\u00010\"X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0014\u0010#\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0014\u0010'\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010aR\u0014\u0010(\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010kR\u0014\u0010)\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010aR\u0014\u0010*\u001a\u00020+X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0014\u0010,\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010^R\u0014\u0010-\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010^R\u0014\u0010.\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010^R\u0014\u0010/\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010^R\u0014\u00100\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010^R\u0014\u00101\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010^R\u0014\u00102\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010^R\u0014\u00103\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010^R\u0014\u00104\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010^R\u0014\u00105\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010^R\u0014\u00106\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010^R\u0014\u00107\u001a\u000208X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0014\u00109\u001a\u000208X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010~R\u0015\u0010:\u001a\u000208X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010~R\u0015\u0010;\u001a\u000208X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010~R\u0015\u0010<\u001a\u000208X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010~R\u0015\u0010=\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0014\u0010>\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010kR\u0015\u0010?\u001a\u00020\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010^R\u0015\u0010@\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0017\u0010A\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010^R\u0018\u0010B\u001a\u0004\u0018\u00010CX\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010D\u001a\u00020$X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010kR\u0015\u0010E\u001a\u00020$X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010kR\u0015\u0010F\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010G\u001a\u00020+X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010qR\u0015\u0010H\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010I\u001a\u00020$X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010kR\u0015\u0010J\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010K\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010L\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010M\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010N\u001a\u00020+X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010qR\u0015\u0010O\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010P\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010Q\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010R\u001a\u00020$X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010kR\u001b\u0010S\u001a\u0004\u0018\u00010$X\u0004¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010T\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010U\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010V\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010W\u001a\u00020\u001cX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0015\u0010X\u001a\u00020$X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010kR\u0014\u0010Y\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010kR\u0015\u0010Z\u001a\u00020$X\u0004¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010k¨\u0006é\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceCombo2in120;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasWick;", "Lcom/blueair/core/model/HasWickDryDuration;", "Lcom/blueair/core/model/HasAutoRh;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasWaterLevel;", "Lcom/blueair/core/model/HasWaterTank;", "Lcom/blueair/core/model/HasSafetySwitch;", "Lcom/blueair/core/model/HasHumMainMode;", "Lcom/blueair/core/model/HasMoodLamp;", "Lcom/blueair/core/model/HasRemoveYellowWater;", "Lcom/blueair/core/model/HasWaterInfill;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "waterLevel", "nightLampBrightness", "wickdryDuration", "wickdryDone", "ywrmEnabled", "ywrmUsage", "mainMode", "apSubMode", "humSubMode", "waterTankFailure", "isSafetySwitchOn", "waterInfill", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJIIIZLjava/lang/Boolean;IIIIZZZ)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getWaterLevel", "getNightLampBrightness", "getWickdryDuration", "getWickdryDone", "getYwrmEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getYwrmUsage", "getMainMode", "getApSubMode", "getHumSubMode", "getWaterTankFailure", "getWaterInfill", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJIIIZLjava/lang/Boolean;IIIIZZZ)Lcom/blueair/core/model/DeviceCombo2in120;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceCombo2in120 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasScheduling, HasSKU, HasWelcomeHome, HasWick, HasWickDryDuration, HasAutoRh, HasTimer, HasWaterLevel, HasWaterTank, HasSafetySwitch, HasHumMainMode, HasMoodLamp, HasRemoveYellowWater, HasWaterInfill {
    public static final Parcelable.Creator<DeviceCombo2in120> CREATOR = new Creator();
    private final int apSubMode;
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
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final double[] hchoRanges;
    private final int humSubMode;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isSafetySwitchOn;
    private final boolean isStandByOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String mac;
    private final int mainMode;
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
    private final boolean waterInfill;
    private final int waterLevel;
    private final boolean waterShortage;
    private final boolean waterTankFailure;
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
    public static final class Creator implements Parcelable.Creator<DeviceCombo2in120> {
        public final DeviceCombo2in120 createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
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
            boolean z13 = parcel2.readInt() != 0;
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
            boolean z14 = z2;
            long readLong = parcel2.readLong();
            boolean z15 = z14;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z16 = z15;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z17 = z16;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z18 = z17;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z19 = z18;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z20 = z19;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z21 = z20;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z22 = z21;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z23 = z;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z24 = z22;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z5 = z23;
                z23 = z24;
                z4 = z23;
            } else {
                z5 = z23;
                z4 = z24;
            }
            String readString16 = parcel2.readString();
            boolean z25 = z5;
            int readInt6 = parcel2.readInt();
            boolean z26 = z4;
            String readString17 = parcel2.readString();
            WelcomeHomeLocation createFromParcel3 = parcel2.readInt() == 0 ? null : WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            if (parcel2.readInt() != 0) {
                z6 = z26;
            } else {
                z6 = z26;
                z26 = z25;
            }
            if (parcel2.readInt() != 0) {
                z8 = z6;
                z7 = z8;
            } else {
                z8 = z25;
                z7 = z6;
            }
            int readInt7 = parcel2.readInt();
            boolean z27 = z7;
            long readLong2 = parcel2.readLong();
            int readInt8 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z9 = z27;
            } else {
                z9 = z27;
                z27 = z25;
            }
            int readInt9 = parcel2.readInt();
            boolean z28 = z9;
            int readInt10 = parcel2.readInt();
            int readInt11 = parcel2.readInt();
            boolean z29 = z28;
            int readInt12 = parcel2.readInt();
            long readLong3 = parcel2.readLong();
            int readInt13 = parcel2.readInt();
            boolean z30 = z29;
            int readInt14 = parcel2.readInt();
            Boolean bool = null;
            int readInt15 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z10 = z30;
            } else {
                z10 = z30;
                z30 = z25;
            }
            if (parcel2.readInt() != 0) {
                bool = Boolean.valueOf(parcel2.readInt() != 0 ? z10 : z25);
            }
            boolean z31 = z10;
            int readInt16 = parcel2.readInt();
            boolean z32 = z31;
            int readInt17 = parcel2.readInt();
            boolean z33 = z32;
            int readInt18 = parcel2.readInt();
            boolean z34 = z33;
            int readInt19 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z11 = z34;
            } else {
                z11 = z34;
                z34 = z25;
            }
            if (parcel2.readInt() != 0) {
                z12 = z11;
            } else {
                z12 = z11;
                z11 = z25;
            }
            if (parcel2.readInt() == 0) {
                z12 = z25;
            }
            return new DeviceCombo2in120(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z13, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z23, readString16, readInt6, readString17, createFromParcel3, z26, z8, readInt7, readLong2, readInt8, z27, readInt9, readInt10, readInt11, readInt12, readLong3, readInt13, readInt14, readInt15, z30, bool, readInt16, readInt17, readInt18, readInt19, z34, z11, z12);
        }

        public final DeviceCombo2in120[] newArray(int i) {
            return new DeviceCombo2in120[i];
        }
    }

    public static /* synthetic */ DeviceCombo2in120 copy$default(DeviceCombo2in120 deviceCombo2in120, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, String str16, int i6, String str17, WelcomeHomeLocation welcomeHomeLocation, boolean z4, boolean z5, int i7, long j2, int i8, boolean z6, int i9, int i10, int i11, int i12, long j3, int i13, int i14, int i15, boolean z7, Boolean bool, int i16, int i17, int i18, int i19, boolean z8, boolean z9, boolean z10, int i20, int i21, Object obj) {
        long j4;
        String str18;
        boolean z11;
        boolean z12;
        boolean z13;
        int i22;
        int i23;
        int i24;
        int i25;
        Boolean bool2;
        boolean z14;
        int i26;
        int i27;
        int i28;
        long j5;
        int i29;
        int i30;
        int i31;
        int i32;
        boolean z15;
        int i33;
        long j6;
        int i34;
        boolean z16;
        boolean z17;
        WelcomeHomeLocation welcomeHomeLocation2;
        String str19;
        int i35;
        String str20;
        boolean z18;
        int i36;
        double[] dArr6;
        double[] dArr7;
        double[] dArr8;
        double[] dArr9;
        double[] dArr10;
        String str21;
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
        int i37;
        boolean z19;
        int i38;
        IndoorDatapoint indoorDatapoint2;
        boolean z20;
        DeviceUuid deviceUuid3;
        String str32;
        String str33;
        int i39;
        Integer num2;
        DeviceCombo2in120 deviceCombo2in1202 = deviceCombo2in120;
        int i40 = i20;
        int i41 = i21;
        String str34 = (i40 & 1) != 0 ? deviceCombo2in1202.uid : str;
        String str35 = (i40 & 2) != 0 ? deviceCombo2in1202.name : str2;
        int i42 = (i40 & 4) != 0 ? deviceCombo2in1202.fanSpeed : i;
        Integer num3 = (i40 & 8) != 0 ? deviceCombo2in1202.filterLife : num;
        int i43 = (i40 & 16) != 0 ? deviceCombo2in1202.brightness : i2;
        String str36 = (i40 & 32) != 0 ? deviceCombo2in1202.autoModeText : str3;
        String str37 = (i40 & 64) != 0 ? deviceCombo2in1202.info : str4;
        DeviceUuid deviceUuid4 = (i40 & 128) != 0 ? deviceCombo2in1202.deviceUuid : deviceUuid2;
        boolean z21 = (i40 & 256) != 0 ? deviceCombo2in1202.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint3 = (i40 & 512) != 0 ? deviceCombo2in1202.latestSensorDatapoint : indoorDatapoint;
        int i44 = (i40 & 1024) != 0 ? deviceCombo2in1202.lastSelectedSensorTypeIndex : i3;
        boolean z22 = (i40 & 2048) != 0 ? deviceCombo2in1202.isChildLockOn : z2;
        int i45 = (i40 & 4096) != 0 ? deviceCombo2in1202.connectivityStatusIndex : i4;
        String str38 = str34;
        String str39 = str35;
        long j7 = (i40 & 8192) != 0 ? deviceCombo2in1202.lastConnectivityInMillis : j;
        String str40 = (i40 & 16384) != 0 ? deviceCombo2in1202.mac : str5;
        String str41 = (i40 & 32768) != 0 ? deviceCombo2in1202.mcuFirmware : str6;
        String str42 = (i40 & 65536) != 0 ? deviceCombo2in1202.wifiFirmware : str7;
        String str43 = (i20 & 131072) != 0 ? deviceCombo2in1202.hardware : str8;
        String str44 = (i20 & 262144) != 0 ? deviceCombo2in1202.timeZone : str9;
        String str45 = (i20 & 524288) != 0 ? deviceCombo2in1202.serial : str10;
        String str46 = (i20 & 1048576) != 0 ? deviceCombo2in1202.purchaseDate : str11;
        String str47 = (i20 & 2097152) != 0 ? deviceCombo2in1202.dealerName : str12;
        String str48 = (i20 & 4194304) != 0 ? deviceCombo2in1202.dealerCountry : str13;
        String str49 = (i20 & 8388608) != 0 ? deviceCombo2in1202.filterType : str14;
        String str50 = (i20 & 16777216) != 0 ? deviceCombo2in1202.filterTrigger : str15;
        double[] dArr11 = (i20 & 33554432) != 0 ? deviceCombo2in1202.pm1Ranges : dArr;
        double[] dArr12 = (i20 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceCombo2in1202.pm10Ranges : dArr2;
        double[] dArr13 = (i20 & 134217728) != 0 ? deviceCombo2in1202.pm25Ranges : dArr3;
        double[] dArr14 = (i20 & 268435456) != 0 ? deviceCombo2in1202.vocRanges : dArr4;
        double[] dArr15 = (i20 & 536870912) != 0 ? deviceCombo2in1202.hchoRanges : dArr5;
        int i46 = (i20 & 1073741824) != 0 ? deviceCombo2in1202.updateProgress : i5;
        boolean z23 = (i20 & Integer.MIN_VALUE) != 0 ? deviceCombo2in1202.isStandByOn : z3;
        String str51 = (i41 & 1) != 0 ? deviceCombo2in1202.modelName : str16;
        int i47 = (i41 & 2) != 0 ? deviceCombo2in1202.typeIndex : i6;
        String str52 = (i41 & 4) != 0 ? deviceCombo2in1202.sku : str17;
        WelcomeHomeLocation welcomeHomeLocation3 = (i41 & 8) != 0 ? deviceCombo2in1202.welcomeHome : welcomeHomeLocation;
        boolean z24 = (i41 & 16) != 0 ? deviceCombo2in1202.wickdryEnabled : z4;
        boolean z25 = (i41 & 32) != 0 ? deviceCombo2in1202.wickdryOn : z5;
        int i48 = (i41 & 64) != 0 ? deviceCombo2in1202.wickdryLeftTime : i7;
        String str53 = str40;
        if ((i41 & 128) != 0) {
            str18 = str41;
            j4 = deviceCombo2in1202.wickdryLeftTimeUpdateTime;
        } else {
            str18 = str41;
            j4 = j2;
        }
        String str54 = str18;
        int i49 = (i41 & 256) != 0 ? deviceCombo2in1202.wickUsage : i8;
        boolean z26 = (i41 & 512) != 0 ? deviceCombo2in1202.waterShortage : z6;
        int i50 = (i41 & 1024) != 0 ? deviceCombo2in1202.autoRh : i9;
        int i51 = (i41 & 2048) != 0 ? deviceCombo2in1202.timerStatus : i10;
        int i52 = (i41 & 4096) != 0 ? deviceCombo2in1202.timerDuration : i11;
        int i53 = (i41 & 8192) != 0 ? deviceCombo2in1202.timerLeftTime : i12;
        long j8 = (i41 & 16384) != 0 ? deviceCombo2in1202.timerLeftTimeUpdateTime : j3;
        int i54 = (i21 & 32768) != 0 ? deviceCombo2in1202.waterLevel : i13;
        int i55 = (i21 & 65536) != 0 ? deviceCombo2in1202.nightLampBrightness : i14;
        int i56 = i54;
        int i57 = (i21 & 131072) != 0 ? deviceCombo2in1202.wickdryDuration : i15;
        boolean z27 = (i21 & 262144) != 0 ? deviceCombo2in1202.wickdryDone : z7;
        Boolean bool3 = (i21 & 524288) != 0 ? deviceCombo2in1202.ywrmEnabled : bool;
        int i58 = (i21 & 1048576) != 0 ? deviceCombo2in1202.ywrmUsage : i16;
        int i59 = (i21 & 2097152) != 0 ? deviceCombo2in1202.mainMode : i17;
        int i60 = (i21 & 4194304) != 0 ? deviceCombo2in1202.apSubMode : i18;
        int i61 = (i21 & 8388608) != 0 ? deviceCombo2in1202.humSubMode : i19;
        boolean z28 = (i21 & 16777216) != 0 ? deviceCombo2in1202.waterTankFailure : z8;
        boolean z29 = (i21 & 33554432) != 0 ? deviceCombo2in1202.isSafetySwitchOn : z9;
        if ((i21 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
            z12 = z29;
            z11 = deviceCombo2in1202.waterInfill;
            i28 = i56;
            i31 = i51;
            i30 = i52;
            i29 = i53;
            j5 = j8;
            i26 = i57;
            z14 = z27;
            bool2 = bool3;
            i25 = i58;
            i24 = i59;
            i23 = i60;
            i22 = i61;
            z13 = z28;
            i27 = i55;
            j6 = j4;
            num2 = num3;
            i36 = i46;
            z18 = z23;
            str20 = str51;
            i35 = i47;
            str19 = str52;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            z17 = z24;
            z16 = z25;
            i34 = i48;
            i33 = i49;
            z15 = z26;
            i32 = i50;
            str28 = str43;
            str27 = str44;
            str26 = str45;
            str25 = str46;
            str24 = str47;
            str23 = str48;
            str22 = str49;
            str21 = str50;
            dArr10 = dArr11;
            dArr8 = dArr13;
            dArr7 = dArr14;
            dArr6 = dArr15;
            str30 = str54;
            str31 = str53;
            str33 = str36;
            str32 = str37;
            deviceUuid3 = deviceUuid4;
            z20 = z21;
            indoorDatapoint2 = indoorDatapoint3;
            i38 = i44;
            z19 = z22;
            i37 = i45;
            str29 = str42;
            dArr9 = dArr12;
            i39 = i43;
        } else {
            z11 = z10;
            z12 = z29;
            i28 = i56;
            i32 = i50;
            i31 = i51;
            i30 = i52;
            i29 = i53;
            j5 = j8;
            i26 = i57;
            z14 = z27;
            bool2 = bool3;
            i25 = i58;
            i24 = i59;
            i23 = i60;
            i22 = i61;
            z13 = z28;
            i27 = i55;
            j6 = j4;
            num2 = num3;
            dArr6 = dArr15;
            i36 = i46;
            z18 = z23;
            str20 = str51;
            i35 = i47;
            str19 = str52;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            z17 = z24;
            z16 = z25;
            i34 = i48;
            i33 = i49;
            z15 = z26;
            str29 = str42;
            str28 = str43;
            str27 = str44;
            str26 = str45;
            str25 = str46;
            str24 = str47;
            str23 = str48;
            str22 = str49;
            str21 = str50;
            dArr10 = dArr11;
            dArr8 = dArr13;
            dArr7 = dArr14;
            str30 = str54;
            str31 = str53;
            i39 = i43;
            str33 = str36;
            str32 = str37;
            deviceUuid3 = deviceUuid4;
            z20 = z21;
            indoorDatapoint2 = indoorDatapoint3;
            i38 = i44;
            z19 = z22;
            i37 = i45;
            dArr9 = dArr12;
        }
        return deviceCombo2in1202.copy(str38, str39, i42, num2, i39, str33, str32, deviceUuid3, z20, indoorDatapoint2, i38, z19, i37, j7, str31, str30, str29, str28, str27, str26, str25, str24, str23, str22, str21, dArr10, dArr9, dArr8, dArr7, dArr6, i36, z18, str20, i35, str19, welcomeHomeLocation2, z17, z16, i34, j6, i33, z15, i32, i31, i30, i29, j5, i28, i27, i26, z14, bool2, i25, i24, i23, i22, z13, z12, z11);
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

    public final String component33() {
        return this.modelName;
    }

    public final int component34() {
        return this.typeIndex;
    }

    public final String component35() {
        return this.sku;
    }

    public final WelcomeHomeLocation component36() {
        return this.welcomeHome;
    }

    public final boolean component37() {
        return this.wickdryEnabled;
    }

    public final boolean component38() {
        return this.wickdryOn;
    }

    public final int component39() {
        return this.wickdryLeftTime;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final long component40() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public final int component41() {
        return this.wickUsage;
    }

    public final boolean component42() {
        return this.waterShortage;
    }

    public final int component43() {
        return this.autoRh;
    }

    public final int component44() {
        return this.timerStatus;
    }

    public final int component45() {
        return this.timerDuration;
    }

    public final int component46() {
        return this.timerLeftTime;
    }

    public final long component47() {
        return this.timerLeftTimeUpdateTime;
    }

    public final int component48() {
        return this.waterLevel;
    }

    public final int component49() {
        return this.nightLampBrightness;
    }

    public final int component5() {
        return this.brightness;
    }

    public final int component50() {
        return this.wickdryDuration;
    }

    public final boolean component51() {
        return this.wickdryDone;
    }

    public final Boolean component52() {
        return this.ywrmEnabled;
    }

    public final int component53() {
        return this.ywrmUsage;
    }

    public final int component54() {
        return this.mainMode;
    }

    public final int component55() {
        return this.apSubMode;
    }

    public final int component56() {
        return this.humSubMode;
    }

    public final boolean component57() {
        return this.waterTankFailure;
    }

    public final boolean component58() {
        return this.isSafetySwitchOn;
    }

    public final boolean component59() {
        return this.waterInfill;
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

    public final DeviceCombo2in120 copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, String str16, int i6, String str17, WelcomeHomeLocation welcomeHomeLocation, boolean z4, boolean z5, int i7, long j2, int i8, boolean z6, int i9, int i10, int i11, int i12, long j3, int i13, int i14, int i15, boolean z7, Boolean bool, int i16, int i17, int i18, int i19, boolean z8, boolean z9, boolean z10) {
        String str18 = str;
        Intrinsics.checkNotNullParameter(str18, "uid");
        String str19 = str2;
        Intrinsics.checkNotNullParameter(str19, "name");
        String str20 = str3;
        Intrinsics.checkNotNullParameter(str20, "autoModeText");
        Intrinsics.checkNotNullParameter(str5, AnalyticEvent.KEY_MAC);
        String str21 = str6;
        Intrinsics.checkNotNullParameter(str21, "mcuFirmware");
        String str22 = str7;
        Intrinsics.checkNotNullParameter(str22, "wifiFirmware");
        String str23 = str8;
        Intrinsics.checkNotNullParameter(str23, "hardware");
        String str24 = str9;
        Intrinsics.checkNotNullParameter(str24, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str25 = str10;
        Intrinsics.checkNotNullParameter(str25, "serial");
        String str26 = str11;
        Intrinsics.checkNotNullParameter(str26, "purchaseDate");
        String str27 = str12;
        Intrinsics.checkNotNullParameter(str27, "dealerName");
        String str28 = str13;
        Intrinsics.checkNotNullParameter(str28, "dealerCountry");
        String str29 = str14;
        Intrinsics.checkNotNullParameter(str29, "filterType");
        String str30 = str15;
        Intrinsics.checkNotNullParameter(str30, "filterTrigger");
        double[] dArr6 = dArr;
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "modelName");
        String str31 = str21;
        String str32 = str22;
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        double[] dArr7 = dArr6;
        return new DeviceCombo2in120(str18, str19, i, num, i2, str20, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, str16, i6, str17, welcomeHomeLocation, z4, z5, i7, j2, i8, z6, i9, i10, i11, i12, j3, i13, i14, i15, z7, bool, i16, i17, i18, i19, z8, z9, z10);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceCombo2in120)) {
            return false;
        }
        DeviceCombo2in120 deviceCombo2in120 = (DeviceCombo2in120) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceCombo2in120.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceCombo2in120.name) && this.fanSpeed == deviceCombo2in120.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceCombo2in120.filterLife) && this.brightness == deviceCombo2in120.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceCombo2in120.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceCombo2in120.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceCombo2in120.deviceUuid) && this.hasFinishedOnboarding == deviceCombo2in120.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceCombo2in120.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceCombo2in120.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceCombo2in120.isChildLockOn && this.connectivityStatusIndex == deviceCombo2in120.connectivityStatusIndex && this.lastConnectivityInMillis == deviceCombo2in120.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceCombo2in120.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceCombo2in120.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceCombo2in120.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceCombo2in120.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceCombo2in120.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceCombo2in120.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceCombo2in120.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceCombo2in120.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceCombo2in120.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceCombo2in120.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceCombo2in120.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceCombo2in120.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceCombo2in120.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceCombo2in120.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceCombo2in120.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceCombo2in120.hchoRanges) && this.updateProgress == deviceCombo2in120.updateProgress && this.isStandByOn == deviceCombo2in120.isStandByOn && Intrinsics.areEqual((Object) this.modelName, (Object) deviceCombo2in120.modelName) && this.typeIndex == deviceCombo2in120.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceCombo2in120.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceCombo2in120.welcomeHome) && this.wickdryEnabled == deviceCombo2in120.wickdryEnabled && this.wickdryOn == deviceCombo2in120.wickdryOn && this.wickdryLeftTime == deviceCombo2in120.wickdryLeftTime && this.wickdryLeftTimeUpdateTime == deviceCombo2in120.wickdryLeftTimeUpdateTime && this.wickUsage == deviceCombo2in120.wickUsage && this.waterShortage == deviceCombo2in120.waterShortage && this.autoRh == deviceCombo2in120.autoRh && this.timerStatus == deviceCombo2in120.timerStatus && this.timerDuration == deviceCombo2in120.timerDuration && this.timerLeftTime == deviceCombo2in120.timerLeftTime && this.timerLeftTimeUpdateTime == deviceCombo2in120.timerLeftTimeUpdateTime && this.waterLevel == deviceCombo2in120.waterLevel && this.nightLampBrightness == deviceCombo2in120.nightLampBrightness && this.wickdryDuration == deviceCombo2in120.wickdryDuration && this.wickdryDone == deviceCombo2in120.wickdryDone && Intrinsics.areEqual((Object) this.ywrmEnabled, (Object) deviceCombo2in120.ywrmEnabled) && this.ywrmUsage == deviceCombo2in120.ywrmUsage && this.mainMode == deviceCombo2in120.mainMode && this.apSubMode == deviceCombo2in120.apSubMode && this.humSubMode == deviceCombo2in120.humSubMode && this.waterTankFailure == deviceCombo2in120.waterTankFailure && this.isSafetySwitchOn == deviceCombo2in120.isSafetySwitchOn && this.waterInfill == deviceCombo2in120.waterInfill;
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
        int hashCode5 = (((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        int hashCode7 = (((((((((((((((((((((((((((((((hashCode6 + (welcomeHomeLocation == null ? 0 : welcomeHomeLocation.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryEnabled)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryOn)) * 31) + this.wickdryLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryLeftTimeUpdateTime)) * 31) + this.wickUsage) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterShortage)) * 31) + this.autoRh) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31) + this.waterLevel) * 31) + this.nightLampBrightness) * 31) + this.wickdryDuration) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryDone)) * 31;
        Boolean bool = this.ywrmEnabled;
        if (bool != null) {
            i = bool.hashCode();
        }
        return ((((((((((((((hashCode7 + i) * 31) + this.ywrmUsage) * 31) + this.mainMode) * 31) + this.apSubMode) * 31) + this.humSubMode) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterTankFailure)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isSafetySwitchOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterInfill);
    }

    public String toString() {
        return "DeviceCombo2in120(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ", wickdryEnabled=" + this.wickdryEnabled + ", wickdryOn=" + this.wickdryOn + ", wickdryLeftTime=" + this.wickdryLeftTime + ", wickdryLeftTimeUpdateTime=" + this.wickdryLeftTimeUpdateTime + ", wickUsage=" + this.wickUsage + ", waterShortage=" + this.waterShortage + ", autoRh=" + this.autoRh + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", waterLevel=" + this.waterLevel + ", nightLampBrightness=" + this.nightLampBrightness + ", wickdryDuration=" + this.wickdryDuration + ", wickdryDone=" + this.wickdryDone + ", ywrmEnabled=" + this.ywrmEnabled + ", ywrmUsage=" + this.ywrmUsage + ", mainMode=" + this.mainMode + ", apSubMode=" + this.apSubMode + ", humSubMode=" + this.humSubMode + ", waterTankFailure=" + this.waterTankFailure + ", isSafetySwitchOn=" + this.isSafetySwitchOn + ", waterInfill=" + this.waterInfill + ')';
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
        parcel.writeInt(this.waterLevel);
        parcel.writeInt(this.nightLampBrightness);
        parcel.writeInt(this.wickdryDuration);
        parcel.writeInt(this.wickdryDone ? 1 : 0);
        Boolean bool = this.ywrmEnabled;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.ywrmUsage);
        parcel.writeInt(this.mainMode);
        parcel.writeInt(this.apSubMode);
        parcel.writeInt(this.humSubMode);
        parcel.writeInt(this.waterTankFailure ? 1 : 0);
        parcel.writeInt(this.isSafetySwitchOn ? 1 : 0);
        parcel.writeInt(this.waterInfill ? 1 : 0);
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

    public int getWickDryLeftSeconds() {
        return HasWick.CC.$default$getWickDryLeftSeconds(this);
    }

    public int getWickLifeLeft() {
        return HasWick.CC.$default$getWickLifeLeft(this);
    }

    public HumSubMode humSubMode() {
        return HasHumMainMode.CC.$default$humSubMode(this);
    }

    public boolean isInApSubMode(ApSubMode apSubMode2) {
        return HasMainMode.CC.$default$isInApSubMode(this, apSubMode2);
    }

    public boolean isInHumSubMode(HumSubMode humSubMode2) {
        return HasHumMainMode.CC.$default$isInHumSubMode(this, humSubMode2);
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

    public DeviceCombo2in120(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, String str16, int i6, String str17, WelcomeHomeLocation welcomeHomeLocation, boolean z4, boolean z5, int i7, long j2, int i8, boolean z6, int i9, int i10, int i11, int i12, long j3, int i13, int i14, int i15, boolean z7, Boolean bool, int i16, int i17, int i18, int i19, boolean z8, boolean z9, boolean z10) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str5;
        String str22 = str6;
        String str23 = str7;
        String str24 = str8;
        String str25 = str9;
        String str26 = str10;
        String str27 = str11;
        String str28 = str12;
        String str29 = str13;
        String str30 = str14;
        String str31 = str15;
        Intrinsics.checkNotNullParameter(str18, "uid");
        Intrinsics.checkNotNullParameter(str19, "name");
        Intrinsics.checkNotNullParameter(str20, "autoModeText");
        Intrinsics.checkNotNullParameter(str21, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str22, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str23, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str24, "hardware");
        Intrinsics.checkNotNullParameter(str25, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str26, "serial");
        Intrinsics.checkNotNullParameter(str27, "purchaseDate");
        Intrinsics.checkNotNullParameter(str28, "dealerName");
        Intrinsics.checkNotNullParameter(str29, "dealerCountry");
        Intrinsics.checkNotNullParameter(str30, "filterType");
        Intrinsics.checkNotNullParameter(str31, "filterTrigger");
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        String str32 = str16;
        Intrinsics.checkNotNullParameter(str32, "modelName");
        this.uid = str18;
        this.name = str19;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str20;
        this.info = str4;
        this.deviceUuid = deviceUuid2;
        this.hasFinishedOnboarding = z;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i3;
        this.isChildLockOn = z2;
        this.connectivityStatusIndex = i4;
        this.lastConnectivityInMillis = j;
        this.mac = str21;
        this.mcuFirmware = str22;
        this.wifiFirmware = str23;
        this.hardware = str24;
        this.timeZone = str25;
        this.serial = str26;
        this.purchaseDate = str27;
        this.dealerName = str28;
        this.dealerCountry = str29;
        this.filterType = str30;
        this.filterTrigger = str31;
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
        this.updateProgress = i5;
        this.isStandByOn = z3;
        this.modelName = str32;
        this.typeIndex = i6;
        this.sku = str17;
        this.welcomeHome = welcomeHomeLocation;
        this.wickdryEnabled = z4;
        this.wickdryOn = z5;
        this.wickdryLeftTime = i7;
        this.wickdryLeftTimeUpdateTime = j2;
        this.wickUsage = i8;
        this.waterShortage = z6;
        this.autoRh = i9;
        this.timerStatus = i10;
        this.timerDuration = i11;
        this.timerLeftTime = i12;
        this.timerLeftTimeUpdateTime = j3;
        this.waterLevel = i13;
        this.nightLampBrightness = i14;
        this.wickdryDuration = i15;
        this.wickdryDone = z7;
        this.ywrmEnabled = bool;
        this.ywrmUsage = i16;
        this.mainMode = i17;
        this.apSubMode = i18;
        this.humSubMode = i19;
        this.waterTankFailure = z8;
        this.isSafetySwitchOn = z9;
        this.waterInfill = z10;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceCombo2in120(java.lang.String r52, java.lang.String r53, int r54, java.lang.Integer r55, int r56, java.lang.String r57, java.lang.String r58, com.blueair.core.model.DeviceUuid r59, boolean r60, com.blueair.core.model.IndoorDatapoint r61, int r62, boolean r63, int r64, long r65, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.String r70, java.lang.String r71, java.lang.String r72, java.lang.String r73, java.lang.String r74, java.lang.String r75, java.lang.String r76, java.lang.String r77, double[] r78, double[] r79, double[] r80, double[] r81, double[] r82, int r83, boolean r84, java.lang.String r85, int r86, java.lang.String r87, com.blueair.core.model.WelcomeHomeLocation r88, boolean r89, boolean r90, int r91, long r92, int r94, boolean r95, int r96, int r97, int r98, int r99, long r100, int r102, int r103, int r104, boolean r105, java.lang.Boolean r106, int r107, int r108, int r109, int r110, boolean r111, boolean r112, boolean r113, int r114, int r115, kotlin.jvm.internal.DefaultConstructorMarker r116) {
        /*
            r51 = this;
            r0 = r114
            r1 = r115
            r2 = r0 & 2
            if (r2 == 0) goto L_0x000b
            java.lang.String r2 = "Pairing…"
            goto L_0x000d
        L_0x000b:
            r2 = r53
        L_0x000d:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0015
        L_0x0013:
            r3 = r54
        L_0x0015:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001b
            r5 = 0
            goto L_0x001d
        L_0x001b:
            r5 = r55
        L_0x001d:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0023
            r7 = 0
            goto L_0x0025
        L_0x0023:
            r7 = r56
        L_0x0025:
            r8 = r0 & 32
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x002d
            r8 = r9
            goto L_0x002f
        L_0x002d:
            r8 = r57
        L_0x002f:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0035
            r10 = 0
            goto L_0x0037
        L_0x0035:
            r10 = r58
        L_0x0037:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003d
            r11 = 0
            goto L_0x003f
        L_0x003d:
            r11 = r59
        L_0x003f:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0045
            r12 = 0
            goto L_0x0047
        L_0x0045:
            r12 = r60
        L_0x0047:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x004d
            r13 = 0
            goto L_0x004f
        L_0x004d:
            r13 = r61
        L_0x004f:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0055
            r14 = 0
            goto L_0x0057
        L_0x0055:
            r14 = r62
        L_0x0057:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x005d
            r15 = 0
            goto L_0x005f
        L_0x005d:
            r15 = r63
        L_0x005f:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006a
            com.blueair.core.model.ConnectivityStatus r6 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r6 = r6.ordinal()
            goto L_0x006c
        L_0x006a:
            r6 = r64
        L_0x006c:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            r16 = 0
            if (r4 == 0) goto L_0x0075
            r18 = r16
            goto L_0x0077
        L_0x0075:
            r18 = r65
        L_0x0077:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x007d
            r4 = r9
            goto L_0x007f
        L_0x007d:
            r4 = r67
        L_0x007f:
            r20 = 32768(0x8000, float:4.5918E-41)
            r21 = r0 & r20
            if (r21 == 0) goto L_0x0089
            r21 = r9
            goto L_0x008b
        L_0x0089:
            r21 = r68
        L_0x008b:
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = r0 & r22
            if (r23 == 0) goto L_0x0094
            r23 = r9
            goto L_0x0096
        L_0x0094:
            r23 = r69
        L_0x0096:
            r24 = 131072(0x20000, float:1.83671E-40)
            r25 = r0 & r24
            if (r25 == 0) goto L_0x009f
            r25 = r9
            goto L_0x00a1
        L_0x009f:
            r25 = r70
        L_0x00a1:
            r26 = 262144(0x40000, float:3.67342E-40)
            r27 = r0 & r26
            if (r27 == 0) goto L_0x00aa
            r27 = r9
            goto L_0x00ac
        L_0x00aa:
            r27 = r71
        L_0x00ac:
            r28 = 524288(0x80000, float:7.34684E-40)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00b5
            r28 = r9
            goto L_0x00b7
        L_0x00b5:
            r28 = r72
        L_0x00b7:
            r29 = 1048576(0x100000, float:1.469368E-39)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00c0
            r29 = r9
            goto L_0x00c2
        L_0x00c0:
            r29 = r73
        L_0x00c2:
            r30 = 2097152(0x200000, float:2.938736E-39)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00cb
            r30 = r9
            goto L_0x00cd
        L_0x00cb:
            r30 = r74
        L_0x00cd:
            r31 = 4194304(0x400000, float:5.877472E-39)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x00d6
            r31 = r9
            goto L_0x00d8
        L_0x00d6:
            r31 = r75
        L_0x00d8:
            r32 = 8388608(0x800000, float:1.17549435E-38)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x00e1
            r32 = r9
            goto L_0x00e3
        L_0x00e1:
            r32 = r76
        L_0x00e3:
            r33 = 16777216(0x1000000, float:2.3509887E-38)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x00ec
            r33 = r9
            goto L_0x00ee
        L_0x00ec:
            r33 = r77
        L_0x00ee:
            r34 = 33554432(0x2000000, float:9.403955E-38)
            r34 = r0 & r34
            r116 = r2
            r0 = 0
            if (r34 == 0) goto L_0x00fa
            double[] r2 = new double[r0]
            goto L_0x00fc
        L_0x00fa:
            r2 = r78
        L_0x00fc:
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            r34 = r114 & r34
            r54 = r2
            if (r34 == 0) goto L_0x0107
            double[] r2 = new double[r0]
            goto L_0x0109
        L_0x0107:
            r2 = r79
        L_0x0109:
            r34 = 134217728(0x8000000, float:3.85186E-34)
            r34 = r114 & r34
            r55 = r2
            if (r34 == 0) goto L_0x0114
            double[] r2 = new double[r0]
            goto L_0x0116
        L_0x0114:
            r2 = r80
        L_0x0116:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
            r34 = r114 & r34
            r56 = r2
            if (r34 == 0) goto L_0x0121
            double[] r2 = new double[r0]
            goto L_0x0123
        L_0x0121:
            r2 = r81
        L_0x0123:
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            r34 = r114 & r34
            r57 = r2
            if (r34 == 0) goto L_0x012e
            double[] r2 = new double[r0]
            goto L_0x0130
        L_0x012e:
            r2 = r82
        L_0x0130:
            r34 = 1073741824(0x40000000, float:2.0)
            r34 = r114 & r34
            if (r34 == 0) goto L_0x0139
            r34 = r0
            goto L_0x013b
        L_0x0139:
            r34 = r83
        L_0x013b:
            r35 = -2147483648(0xffffffff80000000, float:-0.0)
            r35 = r114 & r35
            if (r35 == 0) goto L_0x0144
            r35 = r0
            goto L_0x0146
        L_0x0144:
            r35 = r84
        L_0x0146:
            r36 = r1 & 1
            if (r36 == 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r9 = r85
        L_0x014d:
            r36 = r1 & 2
            if (r36 == 0) goto L_0x0158
            com.blueair.core.model.DeviceType$Combo2in120 r36 = com.blueair.core.model.DeviceType.Combo2in120.INSTANCE
            int r36 = r36.getIndex()
            goto L_0x015a
        L_0x0158:
            r36 = r86
        L_0x015a:
            r37 = r1 & 4
            if (r37 == 0) goto L_0x0161
            r37 = 0
            goto L_0x0163
        L_0x0161:
            r37 = r87
        L_0x0163:
            r38 = r1 & 8
            if (r38 == 0) goto L_0x016a
            r38 = 0
            goto L_0x016c
        L_0x016a:
            r38 = r88
        L_0x016c:
            r39 = r1 & 16
            if (r39 == 0) goto L_0x0173
            r39 = r0
            goto L_0x0175
        L_0x0173:
            r39 = r89
        L_0x0175:
            r40 = r1 & 32
            if (r40 == 0) goto L_0x017c
            r40 = r0
            goto L_0x017e
        L_0x017c:
            r40 = r90
        L_0x017e:
            r41 = r1 & 64
            if (r41 == 0) goto L_0x0185
            r41 = r0
            goto L_0x0187
        L_0x0185:
            r41 = r91
        L_0x0187:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018e
            r42 = r16
            goto L_0x0190
        L_0x018e:
            r42 = r92
        L_0x0190:
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0196
            r0 = 0
            goto L_0x0198
        L_0x0196:
            r0 = r94
        L_0x0198:
            r59 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01a0
            r0 = 0
            goto L_0x01a2
        L_0x01a0:
            r0 = r95
        L_0x01a2:
            r60 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01ab
            r0 = 50
            goto L_0x01ad
        L_0x01ab:
            r0 = r96
        L_0x01ad:
            r61 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01b5
            r0 = 0
            goto L_0x01b7
        L_0x01b5:
            r0 = r97
        L_0x01b7:
            r62 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01bf
            r0 = 0
            goto L_0x01c1
        L_0x01bf:
            r0 = r98
        L_0x01c1:
            r63 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01c9
            r0 = 0
            goto L_0x01cb
        L_0x01c9:
            r0 = r99
        L_0x01cb:
            r64 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r16 = r100
        L_0x01d4:
            r0 = r1 & r20
            if (r0 == 0) goto L_0x01da
            r0 = 0
            goto L_0x01dc
        L_0x01da:
            r0 = r102
        L_0x01dc:
            r20 = r1 & r22
            if (r20 == 0) goto L_0x01e3
            r20 = 0
            goto L_0x01e5
        L_0x01e3:
            r20 = r103
        L_0x01e5:
            r22 = r1 & r24
            if (r22 == 0) goto L_0x01ec
            r22 = 0
            goto L_0x01ee
        L_0x01ec:
            r22 = r104
        L_0x01ee:
            r24 = r1 & r26
            if (r24 == 0) goto L_0x01f5
            r24 = 0
            goto L_0x01f7
        L_0x01f5:
            r24 = r105
        L_0x01f7:
            r26 = 524288(0x80000, float:7.34684E-40)
            r26 = r1 & r26
            if (r26 == 0) goto L_0x0200
            r26 = 0
            goto L_0x0202
        L_0x0200:
            r26 = r106
        L_0x0202:
            r44 = 1048576(0x100000, float:1.469368E-39)
            r44 = r1 & r44
            if (r44 == 0) goto L_0x020b
            r44 = 0
            goto L_0x020d
        L_0x020b:
            r44 = r107
        L_0x020d:
            r45 = 2097152(0x200000, float:2.938736E-39)
            r45 = r1 & r45
            if (r45 == 0) goto L_0x0216
            r45 = 0
            goto L_0x0218
        L_0x0216:
            r45 = r108
        L_0x0218:
            r46 = 4194304(0x400000, float:5.877472E-39)
            r46 = r1 & r46
            r47 = 2
            if (r46 == 0) goto L_0x0223
            r46 = r47
            goto L_0x0225
        L_0x0223:
            r46 = r109
        L_0x0225:
            r48 = 8388608(0x800000, float:1.17549435E-38)
            r48 = r1 & r48
            if (r48 == 0) goto L_0x022c
            goto L_0x022e
        L_0x022c:
            r47 = r110
        L_0x022e:
            r48 = 16777216(0x1000000, float:2.3509887E-38)
            r48 = r1 & r48
            if (r48 == 0) goto L_0x0237
            r48 = 0
            goto L_0x0239
        L_0x0237:
            r48 = r111
        L_0x0239:
            r49 = 33554432(0x2000000, float:9.403955E-38)
            r49 = r1 & r49
            if (r49 == 0) goto L_0x0242
            r49 = 0
            goto L_0x0244
        L_0x0242:
            r49 = r112
        L_0x0244:
            r50 = 67108864(0x4000000, float:1.5046328E-36)
            r1 = r1 & r50
            if (r1 == 0) goto L_0x024d
            r115 = 0
            goto L_0x024f
        L_0x024d:
            r115 = r113
        L_0x024f:
            r53 = r51
            r80 = r54
            r81 = r55
            r82 = r56
            r83 = r57
            r96 = r59
            r97 = r60
            r98 = r61
            r99 = r62
            r100 = r63
            r101 = r64
            r55 = r116
            r104 = r0
            r84 = r2
            r56 = r3
            r69 = r4
            r57 = r5
            r66 = r6
            r58 = r7
            r59 = r8
            r87 = r9
            r60 = r10
            r61 = r11
            r62 = r12
            r63 = r13
            r64 = r14
            r65 = r15
            r102 = r16
            r67 = r18
            r105 = r20
            r70 = r21
            r106 = r22
            r71 = r23
            r107 = r24
            r72 = r25
            r108 = r26
            r73 = r27
            r74 = r28
            r75 = r29
            r76 = r30
            r77 = r31
            r78 = r32
            r79 = r33
            r85 = r34
            r86 = r35
            r88 = r36
            r89 = r37
            r90 = r38
            r91 = r39
            r92 = r40
            r93 = r41
            r94 = r42
            r109 = r44
            r110 = r45
            r111 = r46
            r112 = r47
            r113 = r48
            r114 = r49
            r54 = r52
            r53.<init>(r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r96, r97, r98, r99, r100, r101, r102, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceCombo2in120.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, java.lang.String, int, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, boolean, boolean, int, long, int, boolean, int, int, int, int, long, int, int, int, boolean, java.lang.Boolean, int, int, int, int, boolean, boolean, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public Boolean getYwrmEnabled() {
        return this.ywrmEnabled;
    }

    public int getYwrmUsage() {
        return this.ywrmUsage;
    }

    public int getMainMode() {
        return this.mainMode;
    }

    public int getApSubMode() {
        return this.apSubMode;
    }

    public int getHumSubMode() {
        return this.humSubMode;
    }

    public boolean getWaterTankFailure() {
        return this.waterTankFailure;
    }

    public boolean isSafetySwitchOn() {
        return this.isSafetySwitchOn;
    }

    public boolean getWaterInfill() {
        return this.waterInfill;
    }
}
