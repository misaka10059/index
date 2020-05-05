package com.mn.index.domain.dao;

import com.mn.index.domain.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/5/5 13:43
 * DESC
 */
public interface CatalogDao extends JpaRepository<Catalog, String> {

    Catalog findByIdAndIsDeletedFalse(String id);

    List<Catalog> findAllByIsDeletedFalse();

}
