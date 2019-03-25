/**
 * 
 */
/**
 * @author Bizvane
 *
 */
package com.bizvane.couponservice.es.repository;

import com.bizvane.members.facade.es.pojo.MembersInfoSearchPojo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CouponserviceRepository extends ElasticsearchRepository<MembersInfoSearchPojo,String> {

}