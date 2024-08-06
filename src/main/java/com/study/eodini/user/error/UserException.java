package com.study.eodini.user.error;

import com.study.eodini.error.BaseException;
import com.study.eodini.error.BaseExceptionMessage;
import lombok.Getter;

@Getter
//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserException extends BaseException {


    public UserException(BaseExceptionMessage e) {
        super(e);
    }
}
