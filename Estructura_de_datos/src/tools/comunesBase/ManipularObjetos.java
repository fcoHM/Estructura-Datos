package tools.comunesBase;

public class ManipularObjetos {
    //funciones que se pueden usar en diferntes lugares sin necesidad de crear objetos


    //compara objeto 1 con objeto 2 
    //dice si objeto 1 objeto 2 es mayor 
    //si objeto 1 es igual a objeto 2
    // si objeto 1 es menor que objeto 2
    public static int compararObjetos(Object objeto1, Object objeto2){
        if (objeto1 instanceof Number && objeto2 instanceof Number){
            //los dos son numeros 
            Double numero1 = Double.parseDouble(objeto1.toString());
            Double numero2 = Double.parseDouble(objeto2.toString());
            if (numero1 > numero2){
                return 1;
            }else if (numero1 <numero2){
                return -1;
            }else{
                //es igual
                return 0;
            }
        }else{
            //por lo menos 1 no es numero 
            //el metodo compare y resgrese  un positivo si 01 es > o2
            //si o1 < o2 regresa negativo
            //si o1 = o2  regresa 0
            return objeto1.toString().compareToIgnoreCase(objeto2.toString());
        }
    }
}
