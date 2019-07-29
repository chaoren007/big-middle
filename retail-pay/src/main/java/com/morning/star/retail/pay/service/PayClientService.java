package com.morning.star.retail.pay.service;

import com.morning.star.retail.pay.client.PayClient;
import com.morning.star.retail.pay.enums.PayChannel;

public interface PayClientService {

    PayClient createPayClient(PayChannel payChannel, int ownerId);

}
