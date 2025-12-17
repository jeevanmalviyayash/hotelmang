package com.yash.userservice.Exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(){
        super("Resource not Found on Server !!");
    }

    public ResourceNotFound(String mes){
        super(mes);
    }
}
