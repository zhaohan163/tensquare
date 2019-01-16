package com.tensqare.base.dao;

import com.tensqare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelDao extends JpaRepository<Label,String> {
}
