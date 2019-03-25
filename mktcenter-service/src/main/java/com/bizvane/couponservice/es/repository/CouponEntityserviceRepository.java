/**
 * 
 */
/**
 * @author Bizvane
 *
 */
package com.bizvane.couponservice.es.repository;

import com.bizvane.couponfacade.es.CouponEntityInfoSearchPojo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CouponEntityserviceRepository extends ElasticsearchRepository<CouponEntityInfoSearchPojo,String> {

}