package com.simpsearch;

public class Exceptions {

    public static class SimpSearchException extends RuntimeException {
        public SimpSearchException(String msg) { super(msg); }
    }

    public static class InvalidURLException extends SimpSearchException {
        public InvalidURLException(String msg) { super(msg); }
    }

    public static class RequestFailedException extends SimpSearchException {
        public RequestFailedException(String msg) { super(msg); }
    }

    public static class ParsingException extends SimpSearchException {
        public ParsingException(String msg) { super(msg); }
    }
}