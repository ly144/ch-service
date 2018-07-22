package com.ch.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ch.service.TicketService;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
