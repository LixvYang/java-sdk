package com.qiniu.pili;

import java.util.Date;
import java.util.Map;

public class PiliStatModel {

  /**
   * 统计接口通用请求参数
   */
  public class GetStatCommonRequest {
    /**
     * 开始时间
     * 支持格式：20060102、20060102150405
     */
    public String begin;

    /**
     * 结束时间
     * 支持格式：20060102、20060102150405
     * 超过当前时间，则以当前时间为准
     * 时间范围为左闭右开区间
     */
    public String end;

    /**
     * 时间粒度
     * 可选项 5min hour day month，部分接口仅支持部分粒度
     */
    public String g;
  }

  /**
   * 获取上行流量请求参数
   */
  public class GetStatUpflowRequest {
    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * Where 查询条件
     * hub 直播空间
     * domain 域名
     * area 区域 中国大陆(cn)、香港(hk)、台湾(tw)、亚太(apac)、美洲(am)、欧洲/中东/非洲(emea)
     */
    public Map<String, String[]> where;

    /**
     * 查询值
     * flow 流量，单位：byte，带宽可以从流量转换，公式为 带宽=流量*8/时间粒度，单位：bps
     */
    public String[] select;
  }

  /**
   * 分组获取上行流量请求参数
   */
  public class GroupStatUpflowRequest {
    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * 分组
     */
    public String group;

    /**
     * 查询条件
     * hub 直播空间
     * domain 域名
     * area 区域 中国大陆(cn)、香港(hk)、台湾(tw)、亚太(apac)、美洲(am)、欧洲/中东/非洲(emea)
     */
    public Map<String, String[]> where;

    /**
     * 查询值
     * flow 流量，单位：byte，带宽可以从流量转换，公式为 带宽=流量*8/时间粒度，单位：bps
     */
    public String[] select;
  }

  /**
   * 获取下行流量请求参数
   */
  public class GetStatDownflowRequest {
    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * 查询条件
     * hub 直播空间
     * domain 域名
     * area 区域 中国大陆(cn)、香港(hk)、台湾(tw)、亚太(apac)、美洲(am)、欧洲/中东/非洲(emea)
     */
    public Map<String, String[]> where;

    /**
     * 查询值
     * flow 流量，单位：byte，带宽可以从流量转换，公式为 带宽=流量*8/时间粒度，单位：bps
     */
    public String[] select;
  }

  /**
   * GroupStatDownflowRequest 分组获取下行流量请求参数
   */
  public class GroupStatDownflowRequest {
    /*
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * Group 分组
     */
    public String group;

    /**
     * Where 查询条件
     * hub 直播空间
     * domain 域名
     * area 区域 中国大陆(cn)、香港(hk)、台湾(tw)、亚太(apac)、美洲(am)、欧洲/中东/非洲(emea)
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * flow 流量，单位：byte，带宽可以从流量转换，公式为 带宽=流量*8/时间粒度，单位：bps
     */
    public String[] select;
  }

  /**
   * GetStatCodecRequest 获取直播转码使用量请求参数
   */
  public class GetStatCodecRequest {
    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * Where 查询条件
     * hub 直播空间
     * profile 转码规格
     */
    public Map<String, String[]> where;
    /**
     * Select 查询值
     * duration 时长，单位：毫秒
     */
    public String[] select;
  }

  /**
   * GroupStatCodecRequest 分组获取直播转码使用量请求参数
   */
  public class GroupStatCodecRequest {

    /*
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /*
     * Group 分组
     */
    public String group;

    /*
     * Where 查询条件
     * hub 直播空间
     * profile 转码规格
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * duration 时长，单位：毫秒
     */
    public String[] select;
  }

  /**
   * GetStatNropRequest 获取直播鉴黄使用量请求参数
   */
  public class GetStatNropRequest {

    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * Where 查询条件
     * hub 直播空间
     * assured 鉴黄结果是否确定，true或false
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * count 鉴黄次数
     */
    public String[] select;
  }

  // GroupStatNropRequest 分组获取直播鉴黄使用量请求参数
  public class GroupStatNropRequest {

    /**
     * 通用请求参数
     */
    public GetStatCommonRequest getStatCommonRequest;

    /**
     * Group 分组
     */
    public String group;

    /**
     * Where 查询条件
     * hub 直播空间
     * assured 鉴黄结果是否确定，true或false
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * count 鉴黄次数
     */
    public String[] select;
  }

  // GetStatCasterRequest 获取导播台使用量请求参数
  public class GetStatCasterRequest {

    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * Where 查询条件
     * container 容器
     * resolution 分辨率
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * upflow 上行流量，单位：byte
     * downflow 下行流量，单位：byte
     * duration 使用时长，单位：秒
     */
    public String[] select;
  }

  // GroupStatCasterRequest 分组获取导播台使用量请求参数
  public class GroupStatCasterRequest {

    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /**
     * Group 分组
     */
    public String group;

    /**
     * Where 查询条件
     * container 容器
     * resolution 分辨率
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * upflow 上行流量，单位：byte
     * downflow 下行流量，单位：byte
     * duration 使用时长，单位：秒
     */
    public String[] select;
  }

  /**
   * GetStatPubRequest 获取Pub服务使用量请求参数
   */
  public class GetStatPubRequest {
    /** 通用请求参数 */
    public GetStatCommonRequest commonRequest;

    /**
     * Where 查询条件
     * tp 状态
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * count 转推次数
     * duration 转推时长，单位：毫秒
     */
    public String[] select;
  }

  // GroupStatPubRequest 分组获取Pub服务使用量请求参数
  public class GroupStatPubRequest {

    /**
     * 通用请求参数
     */
    public GetStatCommonRequest commonRequest;

    /** Group 分组 */
    public String group;

    /**
     * Where 查询条件
     * tp 状态
     */
    public Map<String, String[]> where;

    /**
     * Select 查询值
     * count 转推次数
     * duration 转推时长，单位：毫秒
     */
    public String[] select;
  }

  // StatResponse 统计返回值
  public class StatResponse {

    /**
     * Time 时间
     */
    public Date time;

    /**
     * Values 数据，形式如："values":{"flow":4527162977}，其中"flow"对应select项
     */
    public Map<String, Integer> values;
  }

  // StatGroupResponse 分组统计返回值
  public class StatGroupResponse {

    /**
     * Time 时间
     */
    public Date time;

    /**
     * Values
     * 数据，形式如："values":{"SD":{"duration":4527162977}}，其中"SD"对应Group项，"duration"对应Select项
     */
    public Map<String, Map<String, Integer>> values;
  }

}
