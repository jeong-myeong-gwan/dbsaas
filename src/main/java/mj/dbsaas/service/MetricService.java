package mj.dbsaas.service;

import mj.dbsaas.repository.MetricDAO;
import mj.dbsaas.dto.MetricPointDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MetricService {

    private final MetricDAO dao;

    
    public List<MetricPointDTO> getMetricSeries(long instanceId, String metric) {

        List<MetricPointDTO> list = dao.getMetricSeries(instanceId, metric);

        Collections.reverse(list);

        return list;
    }
}