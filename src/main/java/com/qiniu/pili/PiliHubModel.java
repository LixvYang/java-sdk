package com.qiniu.pili;

import java.util.List;

/**
 * 这里定义了Pili Hub响应相关的类
 */
public class PiliHubModel {
  /**
   * GetHubListResponse 查询直播空间列表返回值
   */
  public class HubListResult {
    /**
     * Items 直播空间列表
     */
    GetHubListItem[] items;
  }

  /**
   * GetHubListItem 查询直播空间列表项
   */
  public class GetHubListItem {
    /**
     * Name 直播空间
     */
    String name;
  }

  public class HubInfoResult {
    /**
     * 直播空间名称
     */
    public String name;

    /**
     * 创建时间，Unix 时间戳
     */
    public long createdAt;

    /**
     * 更新时间，Unix 时间戳
     */
    public long updatedAt;

    /**
     * 直播空间下的域名列表
     */
    public List<HubDomain> domains;

    /**
     * 直播空间默认域名
     */
    public List<DefaultDomain> defaultDomains;

    /**
     * 存储 bucket
     */
    public String storageBucket;

    /**
     * 存储过期时间，单位：天
     */
    public long liveDataExpireDays;

    /**
     * 推流鉴权方式
     */
    public String publishSecurity;

    /**
     * 鉴黄配置信息
     */
    public NropArgs nrop;

    /**
     * 被动转码配置，形式如：720p
     */
    public List<String> passiveCodecProfiles;

    /**
     * 主动转码配置，形式如：720p
     */
    public List<String> converts;

    /**
     * 是否开启 hls 低延迟
     */
    public boolean hlsPlus;

    /**
     * 点播域名
     */
    public String vodDomain;

    /**
     * 直播日志保存信息
     */
    public AccessLogOptions accessLog;

    /**
     * 直播封面的截图间隔，单位：秒
     */
    public int snapshotInterval;
  }

  public class HubDomain {

    /**
     * 域名类型
     */
    public String type;

    /**
     * 域名
     */
    public String domain;

    /**
     * CNAME
     */
    public String cname;
  }

  public class DefaultDomain {

    /**
     * 域名类型
     */
    public String type;

    /**
     * 域名
     */
    public String domain;
  }

  public class NropArgs {

    /**
     * 是否开启直播空间级别鉴黄功能
     */
    public boolean enable;

    /**
     * 截帧间隔，每个流隔多久进行截帧并鉴黄，单位：秒
     */
    public int interval;

    /**
     * 回调 URL
     */
    public String notifyUrl;

    /**
     * 通知阈值，鉴黄结果阈值表示 AI 模型判断当前直播画面有多大的概率涉黄，当鉴黄结果阈值大于或等于通知阈值时，将发送回调信息到回调 URL
     */
    public double notifyRate;
  }

  public class AccessLogOptions {

    /**
     * 存储空间
     */
    public String saveBucket;

    /**
     * 过期天数
     */
    public int expireDays;
  }

  /**
   * HubHlsplusRequest 修改直播空间 hls 低延迟配置请求参数
   */
  public class HubHlsplusRequest {
    /**
     * 直播空间
     */
    public String hub;
    /**
     * HlsPlus 是否开启 hls 低延迟
     */
    public Boolean hlsPlus;
  }

  /**
   * HubPersistenceRequest 修改直播空间存储配置请求参数
   */
  public class HubPersistenceRequest {
    /**
     * 直播空间
     */
    public String hub;

    /**
     * StorageBucket 存储空间
     */
    public String storageBucket;

    /**
     * LiveDataExpireDays 存储过期时间
     * 单位：天
     */
    public int liveDataExpireDays;
  }

  /**
   * HubSnapshotRequest 修改直播空间封面配置请求参数
   */
  public class HubSnapshotRequest {
    /**
     * Hub 直播空间
     */
    public String hub;

    /**
     * SnapshotInterval 间隔时间
     * 单位：秒
     */
    public int snapshotInterval;
  }

}
