package com.tradesphere.app.service.impl;

import com.tradesphere.app.model.entity.Trader;
import com.tradesphere.app.repository.TraderRepository;
import com.tradesphere.app.repository.UserRepository;
import com.tradesphere.app.service.TraderService;
import com.tradesphere.app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class TraderServiceImpl implements TraderService {
    TraderRepository traderRepository;
    TraderServiceImpl(TraderRepository traderRepository){
        this.traderRepository=traderRepository;
    }
    @Override
    public Trader saveTrader(Trader trader) {
        traderRepository.save(trader);
        return trader;
    }
}
