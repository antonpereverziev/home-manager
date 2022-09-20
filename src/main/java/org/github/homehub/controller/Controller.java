package org.github.homehub.controller;

import org.github.homehub.models.AccountInfo;
import org.github.homehub.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private EnrollmentService enrollmentService;

    @PutMapping("/account")
    public void create(@RequestBody AccountInfo accountInfo) {
        enrollmentService.enrollDevicesByAccount(accountInfo);
    }
}
