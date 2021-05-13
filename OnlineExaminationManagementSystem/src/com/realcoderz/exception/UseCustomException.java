package com.realcoderz.exception;

public class UseCustomException {

    InvalidInput newExc=new InvalidInput("This is a custom exception ");

    public UseCustomException() throws InvalidInput
    {
    	System.out.println("UseCustomException.UseCustomException()");
        throw newExc;       
}

    public static void main(String args[])
    {
        try
        {
        	System.out.println("UseCustomException.main()");
            UseCustomException use=new UseCustomException();
        }
        catch(InvalidInput myEx)
        {
        	System.out.println("UseCustomException.main()");
            System.out.println("invalid:" + myEx.getMessage());
        }
    }


}
