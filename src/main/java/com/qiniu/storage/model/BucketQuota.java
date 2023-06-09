package com.qiniu.storage.model;

/**
 * 空间配额
 */
public class BucketQuota {

    /**
     * 空间存储量配额
     */
    long size = 0;

    /**
     * 空间文件数配额
     */
    long count = 0;

    public BucketQuota() {
    }

    public BucketQuota(long size, long count) {
        this.size = size;
        this.count = count;
    }

    /**
     * 获取空间存储量配额
     *
     * @return 空间存储量配额
     */
    public long getSize() {
        return this.size;
    }

    /**
     * 设置空间存储量配额<br>
     * 参数传入0或不传表示不更改当前配置，传入-1表示取消限额，新创建的空间默认没有限额。
     *
     * @param size 空间存储量配额
     * @return 空间配置信息
     */
    public BucketQuota setSize(long size) {
        this.size = size;
        return this;
    }

    /**
     * 获取空间文件数配额
     *
     * @return 空间文件数配额
     */
    public long getCount() {
        return this.count;
    }

    /**
     * 设置
     * 参数传入0或不传表示不更改当前配置，传入-1表示取消限额，新创建的空间默认没有限额。
     *
     * @param count 空间文件数配额
     * @return 空间配置信息
     */
    public BucketQuota setCount(long count) {
        this.count = count;
        return this;
    }

}
