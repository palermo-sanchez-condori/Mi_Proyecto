package Ventas;

public class Vendedor {
    private String nombre;
    private double sueldoBase;
    private double comision;
    private double sueldoFinal;
    private double montoVenta;
    private double porcentajeComision;

    public double getPorcentajeComision() {
        return porcentajeComision;
    }
    
    //CONSTRUCTORES
    public Vendedor()
    {    this.nombre = "";
         this.sueldoBase = 0.00;
         this.comision = 0.00;
         this.sueldoFinal=0.00;
    }
    public Vendedor(String nombre, double sueldoBase, double montoVenta)
    {   this.nombre = nombre;
        this.montoVenta = montoVenta;
        this.sueldoBase = sueldoBase;  
    } 
    
    //METODOS GETTER AND SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }
    
    //SOLO LECTURA
    public double getComision() {
        return comision;
    }
    
    public double getSueldoFinal() {
        return sueldoFinal;
    }
    private void calcularComision()
    {
        if(this.montoVenta < 2000)
        {   this.porcentajeComision = 10;
            this.comision = this.montoVenta * (this.porcentajeComision / 100);  
        }
        else
            if(this.montoVenta >= 2001 && this.montoVenta < 3000)
            {   this.porcentajeComision = 12;
                this.comision = this.montoVenta * (this.porcentajeComision / 100);  
            }
        else
            if(this.montoVenta >= 3001 && this.montoVenta < 4500)
            {   this.porcentajeComision = 15;
                this.comision = this.montoVenta * (this.porcentajeComision / 100);  
            }
        else
            if(this.montoVenta >= 4501 && this.montoVenta < 6000)
            {   this.porcentajeComision = 18;
                this.comision = this.montoVenta * (this.porcentajeComision / 100);  
            }
        else
            if(this.montoVenta >= 6000)
            {   this.porcentajeComision = 25;
                this.comision = this.montoVenta * (this.porcentajeComision / 100);  
            }
    }
}
