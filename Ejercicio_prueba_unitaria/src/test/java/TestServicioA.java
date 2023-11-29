import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import service.Implements.serviceAimpl;
import service.Implements.serviceBimpl;
import service.IserviceA;
import service.IserviceB;

public class TestServicioA {

    //Prueba Unitaria Metodologia TDD   Junit
    @Test
    public void testSumar(){
        int a =4;
        int b=4;
        IserviceA iserviceA= new serviceAimpl();
        Assert.assertEquals(iserviceA.sumar(a,b),8);
    }
    //Prueba con Mockito
    @Test
    public void testMultiSuma(){
        // Crea un mock de la interfaz IserviceA usando Mockito.
        IserviceA serviceA = Mockito.mock(IserviceA.class);

        // Configura el comportamiento del mock.
        // Cuando se llame a serviceA.sumar(3, 3), retornará 5.
        Mockito.when(serviceA.sumar(3, 3)).thenReturn(5);

        // Crea una instancia de la implementación serviceBimpl de IserviceB.
        IserviceB iserviceB = new serviceBimpl();

        // Configura la instancia de serviceBimpl con el mock de serviceA.
        iserviceB.setServicioA(serviceA);

        // Llama al método multiplicaSuma(3, 3, 2) en la instancia de serviceBimpl.
        // El resultado esperado es 5 * 2 = 10.
        int resultado = iserviceB.multiplicaSuma(3, 3, 2);

        // Verifica que el resultado obtenido sea igual al resultado esperado (10).
        Assert.assertEquals(resultado, 10);
    }
}
