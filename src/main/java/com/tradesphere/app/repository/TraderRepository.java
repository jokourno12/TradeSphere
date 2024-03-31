package com.tradesphere.app.repository;

import com.tradesphere.app.model.entity.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepository extends JpaRepository<Trader, String> {
}
