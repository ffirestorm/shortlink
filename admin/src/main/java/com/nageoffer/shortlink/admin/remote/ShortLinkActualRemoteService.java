package com.nageoffer.shortlink.admin.remote;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.convention.result.Results;
import com.nageoffer.shortlink.admin.dto.req.RecycleBinRecoverReqDTO;
import com.nageoffer.shortlink.admin.dto.req.RecycleBinRemoveReqDTO;
import com.nageoffer.shortlink.admin.dto.req.RecycleBinSaveReqDTO;
import com.nageoffer.shortlink.admin.remote.dto.req.*;
import com.nageoffer.shortlink.admin.remote.dto.resp.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ffirestorm
 * @version 1.0
 * 2025/3/3
 */
@FeignClient("short-link-project")
public interface ShortLinkActualRemoteService {
    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建响应
     */
    @PostMapping("/api/short-link/v1/create")
    Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) ;


    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求参数
     * @return 短链接批量创建响应
     */
    @PostMapping("/api/short-link/v1/create/batch")
    Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam);


    /**
     * 修改短链接
     *
     * @param requestParam 修改短链接请求参数
     */
    @PostMapping("/api/short-link/v1/update")
    void updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param gid       分组标识
     * @param orderTag  排序标识
     * @param current   当前页
     * @param size      每页数量
     * @return 查询短链接响应
     */
    @GetMapping("/api/short-link/v1/page")
    Result<Page<ShortLinkPageRespDTO>> pageShortLink(@RequestParam("gid") String gid,
                                                     @RequestParam("orderTag") String orderTag,
                                                     @RequestParam("current")Long current,
                                                     @RequestParam("size")Long size);



    /**
     * 查询分组短链接总量
     *
     * @param requestParam 分组短链接总量请求参数
     * @return 查询分组短链接总量响应
     */
    @GetMapping("/api/short-link/v1/count")
    Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam);

    /**
     * 保存回收站
     *
     * @param requestParam 请求参数
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    void saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam);


    /**
     * 恢复短链接
     */
    @PostMapping("/api/short-link/v1/recycle-bin/recover")
    Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam);

    /**
     * 移除短链接
     */
    @PostMapping("/api/short-link/v1/recycle-bin/remove")
    Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam);

    /**
     * 分页查询回收站短链接
     *
     * @param gidList 分组标识集合
     * @param current 当前页
     * @param size    每页数量
     * @return 查询短链接响应
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    Result<Page<ShortLinkPageRespDTO>> pageRecycleBinShortLink(@RequestParam("gidList") List<String>gidList,
                                                               @RequestParam("current")Long current,
                                                               @RequestParam("size")Long size);


    /**
     * 访问单个短链接指定时间内监控数据
     *
     * @param fullShorUrl 完整短链接
     * @param gid         分组标识
     * @param startDate   开始时间
     * @param endDate     结束时间
     * @return 短链接监控信息
     */
    @GetMapping("/api/short-link/v1/stats")
    Result<ShortLinkStatsRespDTO> oneShortLinkStats(@RequestParam("fullShortUrl") String fullShorUrl ,
                                                    @RequestParam("gid") String gid,
                                                    @RequestParam("startDate") String startDate ,
                                                    @RequestParam("endDate") String endDate);


    /**
     * 访问分组短链接指定时间内监控数据
     *
     * @param gid 分组标识
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 分组短链接监控信息
     */
    @GetMapping("/api/short-link/v1/stats/group")
    Result<ShortLinkStatsRespDTO> groupShortLinkStats(@RequestParam("gid") String gid,
                                                      @RequestParam("startDate") String startDate ,
                                                      @RequestParam("endDate") String endDate);



    /**
     * 访问单个短链接指定时间内监控访问记录数据
     *
     * @param fullShorUrl 完整短链接
     * @param gid         分组标识
     * @param startDate   开始时间
     * @param endDate     结束时间
     * @return 短链接监控访问记录信息
     */
    @GetMapping("/api/short-link/v1/stats/access-record")
    Result<Page<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(@RequestParam("fullShortUrl") String fullShorUrl ,
                                                                               @RequestParam("gid") String gid,
                                                                               @RequestParam("startDate") String startDate ,
                                                                               @RequestParam("endDate") String endDate);
    /**
     * 访问分组短链接指定时间内监控访问记录数据
     *
     * @param gid 分组标识
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 分组短链接监控访问记录信息
     */
    @GetMapping("/api/short-link/v1/stats/access-record/group")
    Result<Page<ShortLinkStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(@RequestParam("gid") String gid,
                                                                                    @RequestParam("startDate") String startDate ,
                                                                                    @RequestParam("endDate") String endDate);
}
