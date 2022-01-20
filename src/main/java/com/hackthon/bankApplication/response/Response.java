package com.hackthon.bankApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackthon.bankApplication.dto.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private StatusEnum apiStatus;
    private Object responseData;
}
