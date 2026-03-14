package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\u000fJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¨\u0006\u0015"},
   d2 = {"Lcom/blueair/viewcore/view/StatusLabelTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setStatus", "", "device", "Lcom/blueair/core/model/Device;", "setRatingStatus", "Lcom/blueair/core/model/HasSensorData;", "setRatingStatusFromDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "state", "Lcom/blueair/viewcore/view/StatusLabelState;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StatusLabelTextView extends AppCompatTextView {
   public StatusLabelTextView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public StatusLabelTextView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public StatusLabelTextView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
   }

   // $FF: synthetic method
   public StatusLabelTextView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   private final void setStatus(StatusLabelState var1) {
      ViewExtensionsKt.show((View)this, var1.getShouldShowStatusLabel());
      CharSequence var2;
      if (var1.getShouldSubstituteValueIntoText()) {
         var2 = (CharSequence)this.getContext().getString(var1.getTextResId(), new Object[]{String.valueOf(var1.getValueForText())});
      } else {
         var2 = (CharSequence)this.getContext().getString(var1.getTextResId());
      }

      this.setText(var2);
   }

   public final void setRatingStatus(HasSensorData var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.setStatus(StatusLabelState.Companion.fromSensors$default(StatusLabelState.Companion, var1, (SensorType)null, 2, (Object)null));
   }

   public final void setRatingStatusFromDatapoint(IndoorDatapoint var1, HasSensorData var2) {
      Intrinsics.checkNotNullParameter(var2, "device");
      if (var1 != null) {
         this.setStatus(StatusLabelState.Companion.fromDatapoint$default(StatusLabelState.Companion, var1, var2, (SensorType)null, 4, (Object)null));
      } else {
         this.setStatus(StatusLabelState.Companion.fromSensors$default(StatusLabelState.Companion, var2, (SensorType)null, 2, (Object)null));
      }
   }

   public final void setStatus(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.setStatus(StatusLabelState.Companion.from((Device)var1, (SensorType)null));
   }
}
