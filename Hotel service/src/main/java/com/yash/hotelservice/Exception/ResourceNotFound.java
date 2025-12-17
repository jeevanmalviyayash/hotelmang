package com.yash.hotelservice.Exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(){
        super("ResourceNotFound Exception the server!");
    }

    public ResourceNotFound(String msg){
        super(msg);
    }
}
