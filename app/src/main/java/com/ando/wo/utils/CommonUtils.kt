package com.ando.wo.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.ando.wo.WanAndroidApplication

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * @author javakam
 * @date 2020/8/17  14:52
 */

fun setClipDate(text: String?) {
    val cm: ClipboardManager? =
        WanAndroidApplication.instance.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager?
    if (cm != null) {
        cm.setPrimaryClip(ClipData.newPlainText(null, text))//参数一：标签，可为空，参数二：要复制到剪贴板的文本
        if (cm.hasPrimaryClip()) {
            cm.primaryClip?.getItemAt(0)?.text
        }
    }
}