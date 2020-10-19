package com.rvbb.b2b.backend.customer.dto;

public interface IErrorCode {

    /*Rang of 0 to 200*/
    public final static int OK = 200;
    public final static int FAIL = 0;
    public final static int SERVER_DOWN = 199;
    public final static int NOT_FOUND = 198;
    public final static int INVALID_INPUT = 197;
    public final static int UNAUTHORIZED = 196;
    public final static int UNAUTHENTICATED = 195;
    public final static int NOT_PERMISSION = 194;
    public final static int NOT_ALLOWED = 193;
    public final static int DUPLICATED = 191;
    public final static int SERVER_ERROR = 190;
    public final static int UNSUPPORTED = 189;
    public final static int EMPTY = 188;
    public final static int TOO_LARGE = 187;
    public final static int TOO_SMALL = 186;
    public final static int UNKNOWN_REASON = 185;
    public final static int UNAVAILABLE = 184;
    //add more
}
