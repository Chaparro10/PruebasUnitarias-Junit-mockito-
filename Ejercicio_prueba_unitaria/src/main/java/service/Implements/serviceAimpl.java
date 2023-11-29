package service.Implements;

import service.IserviceA;

public class serviceAimpl implements IserviceA {
    @Override
    public int sumar(int a, int b) {
        return a +b;
    }
}
