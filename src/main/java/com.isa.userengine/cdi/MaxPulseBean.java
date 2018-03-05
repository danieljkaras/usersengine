package com.isa.userengine.cdi;

import com.isa.userengine.domain.Gender;

import javax.enterprise.context.RequestScoped;


@RequestScoped
public class MaxPulseBean implements MaxPulse {


    @Override
    public double countMaximumPulse(Gender gender, int age) {

        if (gender.equals(Gender.MAN)) {
            return 202 - (0.55 * age);
        } else {
            return 216 - (1.09 * age);
        }
    }
}
