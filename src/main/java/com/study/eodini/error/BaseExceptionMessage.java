package com.study.eodini.error;

import com.study.eodini.api.ApiHeader;

public interface BaseExceptionMessage {
    ApiHeader getApiHeader();
    String getGetMessage();
}
