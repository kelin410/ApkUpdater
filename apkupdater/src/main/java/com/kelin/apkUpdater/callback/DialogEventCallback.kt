package com.kelin.apkUpdater.callback

import com.kelin.apkUpdater.ApkUpdater
import com.kelin.apkUpdater.UpdateInfo

/**
 * **描述: ** 开发者自己处理UI交互时的回调。
 *
 * **创建人: ** kelin
 *
 * **创建时间: ** 2017/11/14  上午11:34
 *
 * **版本: ** v 1.0.0
 */
interface DialogEventCallback {
    /**
     * 当需要显示检查更新提示对话框的时候调用。你需要在这里进行检查更新提示对话框的显示。
     * 在用户做出相应的操作后，你应当调用[ApkUpdater.setCheckHandlerResult]方法进行下一步的操作。
     *
     * @param updater [ApkUpdater]对象。
     * @param isForce 是否是强制更新。
     * @see ApkUpdater.setCheckHandlerResult
     */
    fun onShowCheckHintDialog(updater: ApkUpdater, updateInfo: UpdateInfo, isForce: Boolean)

    /**
     * 当需要加载下载进度对话框的时候调用，你需要在这做显示下载进度对话框的操作。
     *
     * 也有可能这个方法会调用不止一次，如果你在构建 [ApkUpdater.Builder] 的时候没有调用
     * [ApkUpdater.Builder.setCheckWiFiState]方法改变检测网络状态的话默认是会检测WIFI状态的。当WIFI状态改变的时候
     * 有可能会再次调用该方法，所以这里你要做好相应的判断，以避免Dialog会显示多次。
     *
     * 这里只是单纯的做显示对话的操作，无需做其他任何处理，进度条的更新需要在[.onProgress]方法中处理，
     * 您需要覆盖[.onProgress]方法。
     *
     * @param isForce 是否是强制更新。
     * @see ApkUpdater.Builder.setCheckWiFiState
     * @see .onProgress
     */
    fun onShowProgressDialog(updater: ApkUpdater, isForce: Boolean)

    /**
     * 下载进度更新的时候调用。如果您是自定义的UI交互的话您需要覆盖此方法，并在此方法中做更新进度的操作。
     * 您还需要在进度完成后进行销毁dialog的操作。
     *
     * @param total      文件总大小(字节)。
     * @param current    当前的进度(字节)。
     * @param percentage 当前下载进度的百分比。
     */
    fun onProgress(updater: ApkUpdater, total: Long, current: Long, percentage: Int)
}