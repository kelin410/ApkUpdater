package com.kelin.apkUpdater

/**
 * 描述 需要更新的Apk信息对象。
 * 创建人 kelin
 * 创建时间 2017/3/13  下午2:32
 */
interface UpdateInfo {
    /**
     * 获取网络上的版本号。
     *
     * @return 返回当前对象的版本号字段的值。
     */
    val versionCode: Int

    /**
     * 获取网络上的版本名称。
     *
     * @return 返回当前对象的版本名称字段的值。
     */
    val versionName: String?

    /**
     * 获取最新版本的下载链接。
     *
     * @return 返回当前对象的下载链接字段的值。
     */
    val downLoadsUrl: String?

    /**
     * 是否强制更新。
     *
     * @return `true` 表示强制更新, `false` 则相反。
     */
    val isForceUpdate: Boolean

    /**
     * 获取强制更新的版本号，如果你的本次强制更新是针对某个或某些版本的话，你可以在该方法中返回。前提是 [.isForceUpdate]
     * 返回值必须为true，否则该方法的返回值是没有意义的。
     *
     * @return 返回你要强制更新的版本号，可以返回 null ，如果返回 null 并且 [.isForceUpdate] 返回 true 的话
     * 则表示所有版本全部强制更新。
     */
    val forceUpdateVersionCodes: IntArray?

    /**
     * 获取Apk文件名(例如 xxx.apk 或 xxx)。后缀名不是必须的。
     * 可以返回null，如果返回null则默认使用日期作为文件名。
     */
    val apkName: String?

    /**
     * 获取更新的内容。就是你本次更新了那些东西可以在这里返回，这里返回的内容会现在是Dialog的消息中，如果你没有禁用Dialog的话。
     *
     * @return 返回你本次更新的内容。
     */
    val updateMessage: CharSequence?

    /**
     * 文件签名类型。
     *
     * @return 返回你能够提供的文件签名类型，例如MD5或者SHA1.
     */
    val signatureType: SignatureType?

    /**
     * 获取网络上最新安装包的签名，用户校验下载后的安装包是否完整以及是否修改等。
     *
     * @return 如果你希望使用签名校验则返回网络上最近安装包的签名，如果返回null这表示不进行签名校验，签名可以是MD5或者SHA1。
     */
    val signature: String?
}