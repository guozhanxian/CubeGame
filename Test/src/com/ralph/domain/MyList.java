package com.ralph.domain;

/**
 * Created by guozhanxian on 2017/8/1.
 */
public class MyList
{
    private Object[] data;

    private int pointer;

    public MyList()
    {
        data = new Object[5];
        pointer = -1;
    }

    public void add(Object obj)
    {
        if(pointer>=data.length-1)
        {
            Object[] newarr = new Object[data.length+5];
            System.arraycopy(data,0,newarr,0,data.length);
            data = newarr;
        }
        data[++pointer] = obj;
    }

    public Object get(int index)
    {
        if(index<0 || index>pointer)
            return null;
        else
            return data[index];
    }

    public int size()
    {
        return pointer+1;
    }
}
