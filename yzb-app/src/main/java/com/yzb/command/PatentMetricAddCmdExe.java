package com.yzb.command;

import com.alibaba.cola.dto.Response;
import com.yzb.domain.metrics.techinfluence.AuthorType;
import com.yzb.domain.metrics.techinfluence.InfluenceMetric;
import com.yzb.domain.metrics.techinfluence.PatentMetric;
import com.yzb.domain.metrics.techinfluence.PatentMetricItem;
import com.yzb.domain.user.UserProfile;
import com.yzb.dto.PatentMetricAddCmd;
import com.yzb.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PatentMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PatentMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(PatentMetricAddCmd cmd) {
        PatentMetricItem patentMetricItem = new PatentMetricItem();
        BeanUtils.copyProperties(cmd.getPatentMetricCO(), patentMetricItem);
        patentMetricItem.setSubMetric(new PatentMetric(new InfluenceMetric(new UserProfile(cmd.getPatentMetricCO().getOwnerId()))));
        patentMetricItem.setAuthorType(AuthorType.valueOf(cmd.getPatentMetricCO().getAuthorType()));
        metricGateway.save(patentMetricItem);
        return Response.buildSuccess();
    }
}