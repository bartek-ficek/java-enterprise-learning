package com.isa.userengine.cdi;

import com.isa.userengine.domain.User;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MaxPulseBean {

    public double maxPulseOfMan(User user) {
        return 202 - (0.55 * user.getAge());
    }

    public double maxPulseOfWoman(User user) {
        return 216 - (1.09 * user.getAge());
    }
}
