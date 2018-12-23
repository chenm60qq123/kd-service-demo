package com.kd.servicedemo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {

    private int num;
    private String type;
    private String message;
    private String state;
    private Object data;



    public  Message(Object data){
        this.data=data;
    }

    public Message(String state,String message,Object data){
        this.state=state;
        this.message=message;
        this.num=num;
        this.data=data;
    }



    public Message(String state,String message,int num,Object data){
        this.state=state;
        this.message=message;
        this.num=num;
        this.data=data;
    }



    public static Message success(String state,String message,int num){
        return new Message(state,message,num,null);
    }

    public static Message fails(String state,String message,Object data){
        return new Message(state,message,data);
    }

    public static Message success(String state,String message,Object data){
        return new Message(state,message,data);
    }

    public static Message success(Object data){
        return new Message(data);
    }

}
