package com.qiniu.pili;

import java.util.List;
import com.qiniu.util.UrlSafeBase64;

public class PiliStreamModel {

  private PiliStreamModel() {
  }

  /**
   *
   * 请求查询直播流列表参数
   */
  public class GetStreamListRequest {

    /**
     * 直播空间
     */
    public String hub;

    /**
     * 只返回当前在线的流
     */
    public boolean liveOnly;

    /**
     * 流名称前缀匹配
     */
    public String prefix;

    /**
     * 返回值数量限制
     */
    public String limit;

    /**
     * 从该位置开始返回
     */
    public String marker;
  }

  /**
   * 查询直播流列表返回值
   */
  public class GetStreamsListResponse {
    /**
     * 流列表
     */
    public List<GetStreamsListResponseItem> items;

    /**
     * 表示当前位置,若marker为空,表示遍历完成
     */
    public String marker;
  }

  public class GetStreamsListResponseItem {
    /**
     * 流名
     */
    public String key;
  }

  /**
   * 查询直播流信息请求参数
   */
  public class GetStreamBaseInfoRequest {
    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流名
     */
    public String stream;
  }

  /**
   * 查询直播流信息返回值
   */
  public class GetStreamBaseInfoResponse {

    /**
     * 直播流创建时间
     * Unix 时间戳,单位:秒
     */
    public long createdAt;

    /**
     * 直播流更新时间
     * Unix 时间戳,单位:秒
     */
    public long updatedAt;

    /**
     * 直播流过期时间
     * 默认流过期时间15天,Unix 时间戳,单位:秒
     */
    public long expireAt;

    /**
     * 禁用结束时间
     */
    public int disabledTill;

    /**
     * 转码配置
     */
    public List<String> converts;

    /**
     * 是否开启水印
     */
    public boolean watermark;

    /**
     * 推流鉴权类型
     */
    public String publishSecurity;

    /**
     * 推流密钥
     */
    public String publishKey;

    /**
     * 是否开启鉴黄
     */
    public boolean nropEnable;
  }

  /**
   *
   * 禁用直播流请求参数
   */
  public class StreamDisabledRequest {

    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流名
     */
    public String stream;

    /**
     * 禁用结束时间
     * Unix 时间戳,单位:秒
     * 特殊值 -1 表示永久禁用;0 解除禁用
     */
    public int disabledTill;

    /**
     * 禁用时长
     * 单位:秒
     * 当 DisabledTill 为0时,DisablePeriodSecond 参数生效
     */
    public int disablePeriodSecond;
  }

  /**
   * 查询直播流实时信息请求参数
   */
  public class GetStreamLiveStatusRequest {
    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流名
     */
    public String stream;
  }

  /**
   * 直播流实时状态
   */
  public class StreamLiveStatus {
    /**
     * 推流开始时间
     * Unix 时间戳,单位:秒
     */
    public long startAt;

    /**
     * 推流端IP
     */
    public String clientIP;

    /**
     * 服务端IP
     */
    public String serverIP;

    /**
     * 推流码率
     */
    public int bps;

    /**
     * 帧率
     */
    public StreamLiveStatusFPS fps;

    /**
     * 流名
     */
    public String key;
  }

  /**
   * 流实时帧率
   */
  public class StreamLiveStatusFPS {

    /**
     * 音频帧率
     */
    public int audio;

    /**
     * 视频帧率
     */
    public int video;

    /**
     * metadata帧率
     */
    public int data;
  }

  /**
   * 查询直播流实时信息返回值
   */
  public class GetStreamLiveStatusResponse {

    /**
     * StreamLiveStatus
     * 直播流实时状态
     */
    public StreamLiveStatus streamLiveStatus;

    /**
     * 视频码率,单位:bps
     */
    public int videoBitRate;

    /**
     * 音频码率,单位:bps
     */
    public int audioBitRate;
  }

  /**
   * 批量查询直播实时状态请求参数
   */
  public class BatchGetStreamLiveStatusRequest {

    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流列表
     * 查询流列表数量不超过100
     */
    public List<String> items;
  }

  /**
   * 批量查询直播实时状态返回值
   */
  public class BatchGetStreamLiveStatusResponse {
    /**
     * 流列表
     */
    public List<StreamLiveStatus> items;
  }

  /**
   * 查询直播流推流记录请求参数
   */
  public class GetStreamHistoryRequest {

    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流名
     */
    public String stream;

    /**
     * 开始时间
     * 单位:秒,默认为0
     */
    public long start;

    /**
     * 结束时间
     * 单位:秒,默认为当前时间
     */
    public long end;
  }

  /**
   * 查询直播流推流记录返回值
   */
  public class GetStreamHistoryResponse {

    /**
     * 直播流推流记录列表
     */
    public List<GetStreamHistoryItem> items;
  }

  /**
   * 查询直播流推流记录项
   */
  public class GetStreamHistoryItem {

    /**
     * 推流开始时间
     */
    public long start;

    /**
     * 推流结束时间
     */
    public long end;

    /**
     * 推流端IP
     */
    public String clientIP;

    /**
     * 服务端IP
     */
    public String serverIP;
  }

  /**
   * 录制直播回放请求参数
   */
  public class StreamSaveasRequest {

    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流名
     */
    public String stream;

    /**
     * 开始时间
     * Unix 时间戳,单位:秒
     */
    public long start;

    /**
     * 结束时间
     * Unix 时间戳,单位:秒,默认为当前时间
     */
    public long end;

    /**
     * 文件名
     * 为空时会随机生成一个文件名
     */
    public String fname;

    /**
     * 文件格式
     * 可选文件格式为
     * - m3u8: HLS格式,默认值
     * - flv: FLV格式,将回放切片转封装为单个flv文件,异步模式
     * - mp4: MP4格式,将回放切片转封装为单个mp4文件,异步模式
     * 异步模式下,生成回放文件需要一定时间
     */
    public String format;

    /**
     * 异步模式时,指定数据处理的队列
     * 可以将优先级较高的任务配置到独立的队列中进行执行
     * 参考文档:https://developer.qiniu.com/dora/kb/2500/streaming-media-queue-about-seven-cows
     */
    public String pipeline;

    /**
     * 回调地址
     * 异步模式完成任务后的回调通知地址,不指定表示不做回调
     */
    public String notify;

    /**
     * 切片文件的生命周期
     * - 0: 默认值,表示修改ts文件生命周期为永久保存
     * - >0: 表示修改ts文件的的生命周期为 ExpireDays 参数值
     * - -1: 表示不修改ts文件的expire属性,可显著提升接口响应速度
     */
    public int expireDays;

    /**
     * 生成文件的生命周期
     * - 0: 默认值,表示生成文件(m3u8/flv/mp4)永久保存
     * - >0: 表示生成文件(m3u8/flv/mp4)的生命周期为 PersistentDeleteAfterDays 参数值
     * m3u8文件只有当ExpireDays为-1时生效
     */
    public int persistentDeleteAfterDays;

    /**
     * 过滤ts切片文件类型
     * 部分非标准的直播流,在推流初期缺少视频帧或音频帧,过滤功能可以剔除这部分切片
     * - 0: 默认值,不做过滤
     * - 1: 第一个ts切片需要是纯视频类型,不符合预期的ts切片将被跳过
     * - 2: 第一个ts切片需要是纯音频类型,不符合预期的ts切片将被跳过
     * - 3: 第一个ts切片需要是音视频类型,不符合预期的ts切片将被跳过
     */
    public byte firstTsType;
  }

  /**
   * 录制直播回放返回值
   */
  public class StreamSaveasResponse {

    /**
     * 文件名
     */
    public String fname;

    /**
     * 开始时间
     * Unix 时间戳,单位:秒
     */
    public long start;

    /**
     * 结束时间
     * Unix 时间戳,单位:秒
     */
    public long end;

    /**
     * 异步任务ID
     */
    public String persistentID;
  }

  /**
   * 保存直播截图请求参数
   */
  public class StreamSnapshotRequest {

    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流名
     */
    public String stream;

    /**
     * 截图时间
     * Unix 时间戳,单位:秒,不指定则为当前时间
     */
    public int time;

    /**
     * 文件名
     * 不指定系统会随机生成
     */
    public String fname;

    /**
     * 文件格式
     * 默认为jpg,支持选择jpg/png
     */
    public String format;

    /**
     * 异步模式时,指定数据处理的队列
     * 可以将优先级较高的任务配置到独立的队列中进行执行
     * 参考文档:https://developer.qiniu.com/dora/kb/2500/streaming-media-queue-about-seven-cows
     */
    public String pipeline;

    /**
     * 回调地址
     * 若指定回调地址,则截图动作为异步模式
     */
    public String notify;

    /**
     * 生命周期
     * - 0: 默认值,表示截图文件永久保存,单位:天
     */
    public int deleteAfterDays;
  }

  /**
   * 保存直播截图返回值
   */
  public class StreamSnapshotResponse {

    /**
     * 文件名
     */
    public String fname;

    /**
     * 异步任务ID
     */
    public String persistentID;
  }

  /**
   * 修改直播流转码配置请求参数
   */
  public class StreamConvertsRequest {

    /**
     * 直播空间
     */
    public String hub;

    /**
     * 流名
     */
    public String stream;

    /**
     * 转码配置
     */
    public String[] converts;
  }

  /**
   * 请求流名base64编码
   */
  public static String encodeStream(String str) {
    return UrlSafeBase64.encodeToString(str.getBytes());
  }
}
