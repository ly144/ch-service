package com.ch.dao;

import com.ch.models.Community;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ApeRepository extends ElasticsearchRepository<Community, Integer> {

    public List<Community> findByTypeId(int typeId);

}
