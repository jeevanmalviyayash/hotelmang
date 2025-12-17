package com.yash.ratings.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(){
        super("ResourceNotFound server error!!");
    }

    public ResourceNotFound(String msg){
        super(msg);
    }
}
