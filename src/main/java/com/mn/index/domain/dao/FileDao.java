package com.mn.index.domain.dao;

import com.mn.index.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/23 17:31
 * DESC
 */
public interface FileDao extends JpaRepository<File, String> {

}
