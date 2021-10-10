package com.yzb.command;

import com.alibaba.cola.dto.Response;
import com.yzb.convertor.UserProfileConvertor;
import com.yzb.domain.user.UserProfile;
import com.yzb.dto.UserProfileUpdateCmd;
import com.yzb.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}