package com.community.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDto {
    private String clientId;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}