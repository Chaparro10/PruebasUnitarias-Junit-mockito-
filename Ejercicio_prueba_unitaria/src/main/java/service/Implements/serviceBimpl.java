package service.Implements;

import service.IserviceA;
import service.IserviceB;

public class serviceBimpl implements IserviceB {

    private IserviceA iserviceA;
    @Override
    public IserviceA getIserviceA() {
        return iserviceA;
    }

    @Override
    public void setServicioA(IserviceA servicioA) {
            this.iserviceA=servicioA;
    }

    @Override
    public int multiplicaSuma(int a, int b, int multiplicador) {
        return iserviceA.sumar(a,b)*multiplicador;
    }

    @Override
    public int multiplicar(int a, int b) {
        return a*b;
    }
}
